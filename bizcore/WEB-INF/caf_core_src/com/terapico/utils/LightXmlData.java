package com.terapico.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LightXmlData {
	public static class Builder {
		protected Stack<LightXmlData> stack;
		protected LightXmlData rootNode;
		protected boolean forMetaData = false;
		protected boolean waitChild = false;
		public Builder() {
			this("xml");
		}
		public Builder(String tagName) {
			stack = new Stack<>();
			rootNode = new LightXmlData();
			rootNode.setTagName(tagName);
			waitChild = true;
			stack.push(rootNode);
		}
		public Builder meta() throws Exception {
			if (stack.peek() != rootNode) {
				throw new Exception("meta()必须在根节点声明");
			}
			rootNode.setMeta(new XmlMetaData() );
			forMetaData = true;
			return this;
		}
		
		public Builder version(String val) throws Exception {
			verifyInMetaScope("version");
			rootNode.getMeta().setVersion(val);
			return this;
		}
		private void verifyInMetaScope(String methodName) throws Exception {
			if (!forMetaData) {
				throw new Exception("方法"+methodName+"()只能在meta内使用。");
			}
		}
		private void verifyNotInMetaScope(String methodName) throws Exception {
			if (forMetaData) {
				throw new Exception("方法"+methodName+"()不能在meta内使用。");
			}
		}
		public Builder node(String tagName, Object value) {
			forMetaData = false;
			LightXmlData childNode = new LightXmlData();
			childNode.setTagName(tagName);
			childNode.setValue(value);
			
			if (waitChild) {
				// 添加子节点
				LightXmlData curNode = stack.peek();
				curNode.addChild(childNode);
				stack.push(childNode);
				waitChild = false;
			}else {
				// 添加兄弟节点
				stack.pop();
				LightXmlData parentNode = stack.peek();
				stack.push(childNode);
				parentNode.addChild(childNode);
			}
			return this;
		}
		public Builder cdata() throws Exception {
			verifyNotInMetaScope("cdata");
			LightXmlData curNode = stack.peek();
			curNode.setWrapperCdata(true);
			return this;
		}
		public Builder attribute(String name, Object value) throws Exception {
			verifyNotInMetaScope("attribute");
			LightXmlData curNode = stack.peek();
			curNode.addAttribute(name, value);
			return this;
		}
		public Builder child() {
			waitChild = true;
			return this;
		}
		public Builder done() {
			waitChild = false;
			stack.pop();
			return this;
		}
		public LightXmlData build() {
			return rootNode;
		}
		private LightXmlData getCurrentNode() {
			return stack.peek();
		}
		public LightXmlData fromXmlString(String xmlStr) throws Exception {
			stack.clear();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new ByteArrayInputStream(xmlStr.getBytes(StandardCharsets.UTF_8)));
			NodeList msgParamNodes = doc.getDocumentElement().getChildNodes();
			decode(doc.getDocumentElement());
			return this.build();
		}
		private void decode(Node node) throws Exception {
			boolean addChild = false;
//			System.out.println("Now read node " + node.getNodeName()+"("+node.getNodeType()+"), value="+node.getNodeValue());
			short nodeType = node.getNodeType();
			switch (nodeType){
			case Node.ENTITY_REFERENCE_NODE:
			case Node.DOCUMENT_FRAGMENT_NODE:
			case Node.DOCUMENT_TYPE_NODE:
			case Node.NOTATION_NODE:
			case Node.PROCESSING_INSTRUCTION_NODE:
				return;
				// 忽略以上类型的ｎｏｄｅ
			case Node.ATTRIBUTE_NODE:
				this.attribute(node.getNodeName(), node.getNodeValue());
				return;
			case Node.TEXT_NODE:
			case Node.CDATA_SECTION_NODE:
				if (TextUtil.isBlank(node.getTextContent())) {
					return;
				}
				getCurrentNode().setValue(node.getTextContent());
				return;
			case Node.ENTITY_NODE:
			case Node.DOCUMENT_NODE:
			case Node.ELEMENT_NODE:
				if (stack.isEmpty()) {
					rootNode.setTagName(node.getNodeName());
					stack.push(rootNode);
				}else {
					this.node(node.getNodeName(), null);
				}
				default:
					break;
			}
			
			
			NamedNodeMap attrs = node.getAttributes();
			if (attrs != null){
				for (int i = 0; i < attrs.getLength(); i++) {
					Node attrNode = attrs.item(i);
					this.attribute(attrNode.getNodeName(), attrNode.getNodeValue());
				}
			}
			NodeList children = node.getChildNodes();
			if (children == null){
				return;
			}
			addChild = false;
			for (int i = 0; i < children.getLength(); i++) {
				Node childNode = children.item(i);
				if (!addChild) {
					switch (childNode.getNodeType()) {
					case Node.ENTITY_NODE:
					case Node.DOCUMENT_NODE:
					case Node.ELEMENT_NODE:
						this.child();
						addChild = true;
//						System.out.println("ready to add child");
						break;
					}
				}
				decode(childNode);
			}
			if (addChild) {
//				System.out.println("finish add child");
				this.done();
			}
			return;
		}
		
		
		
	}
	
	public static class XmlMetaData {
		protected String version;

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}
	}
	
	public static class NodeWrapper {
		List<LightXmlData> node;
		public boolean isPresent() {
			return node != null && node.size() > 0;
		}
		public NodeWrapper get(int index) {
			if (node == null) {
				return this;
			}
			if (node.size() <= index) {
				return this;
			}
			NodeWrapper rst = new NodeWrapper();
			rst.node = new ArrayList<>();
			rst.node.add(node.get(index));
			return rst;
		}
		public LightXmlData get() {
			if (node == null) {
				return null;
			}
			if (node.size() > 0) {
				return node.get(0);
			}
			return null;
		}
		public List<LightXmlData> getAll() {
			return node;
		}
		public NodeWrapper child(String name) {
			LightXmlData firstNode = get();
			if (firstNode == null) {
				return new NodeWrapper();
			}
			return firstNode.child(name);
		}
	}
	protected XmlMetaData meta;
	protected List<LightXmlData> children;
	protected String tagName;
	protected Object value;
	protected Map<String, Object> attributes;
	protected boolean wrapperCdata = false;
	
	public XmlMetaData getMeta() {
		return meta;
	}
	
	public void addAttribute(String name, Object value) {
		ensureAttributes();
		attributes.put(name, value);
	}
	private void ensureAttributes() {
		if (attributes == null) {
			attributes = new HashMap<>();
		}
	}
	protected void addChild(LightXmlData childNode) {
		ensureChildren();
		children.add(childNode);
	}
	private void ensureChildren() {
		if (children == null) {
			children = new ArrayList<>();
		}
	}
	public void setMeta(XmlMetaData meta) {
		this.meta = meta;
	}
	public List<LightXmlData> getChildren() {
		return children;
	}
	public void setChildren(List<LightXmlData> children) {
		this.children = children;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public boolean isWrapperCdata() {
		return wrapperCdata;
	}
	public void setWrapperCdata(boolean wrapperCdata) {
		this.wrapperCdata = wrapperCdata;
	}
	
	public String toXML() throws UnsupportedEncodingException {
		return toXML(false);
	}
	public String toXML(boolean pretty) throws UnsupportedEncodingException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream pOut = new PrintStream(out);
		if (this.getMeta() != null) {
			printMetaData(pOut);
		}
		printNodeData(pOut, this, 0, pretty);
		pOut.close();
		return out.toString("utf-8");
	}
	private void printNodeData(PrintStream out, LightXmlData node, int level, boolean pretty) {
		if (pretty) {
			for(int i=0;i<level;i++) {
				out.print("  ");
			}
		}
		if (node.getAttributes() == null) {
			out.printf("<%s>", node.getTagName());
		}else {
			out.printf("<%s", node.getTagName());
			node.getAttributes().forEach((key, value)->{
				out.printf(" %s=\"%s\"", key, convertNodeValueToString(value));
			});
			out.print(">");
		}
		printNodeValue(out, node);
		if (node.getChildren() == null) {
			out.println(String.format("</%s>", node.getTagName()));
			return;
		}
		out.println();
		for(LightXmlData child : node.getChildren()) {
			printNodeData(out, child, level+1, pretty);
		}
		if (pretty) {
			for(int i=0;i<level;i++) {
				out.print("  ");
			}
		}
		out.println(String.format("</%s>", node.getTagName()));
	}
	private void printNodeValue(PrintStream out, LightXmlData node) {
		if (node.getValue() == null) {
			return;
		}
		if (node.isWrapperCdata()) {
			out.printf("<![CDATA[%s]]>", convertNodeValueToString(node.getValue()));
		}else {
			out.print(convertNodeValueToString(node.getValue()));
		}
	}
	private String convertNodeValueToString(Object value) {
		return value.toString();
	}
	private void printMetaData(PrintStream out) {
		out.print("<?xml");
		if (this.meta.getVersion() != null) {
			out.printf(" version=\"%s\"", meta.getVersion());
		}
		out.println(" ?>");
	}
	
	public NodeWrapper child(String name) {
		return children(name);
	}
	public NodeWrapper children(String name) {
		if (children == null) {
			return new NodeWrapper();
		}
		List<LightXmlData> nodes = children.stream().filter(it->it.getTagName().equals(name)).collect(Collectors.toList());
		if (nodes.isEmpty()) {
			return new NodeWrapper();
		}
		NodeWrapper rst = new NodeWrapper();
		rst.node = nodes;
		return rst;
	}
	
}
