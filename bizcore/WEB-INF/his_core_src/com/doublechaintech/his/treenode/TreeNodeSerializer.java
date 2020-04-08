package com.doublechaintech.his.treenode;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.his.HisObjectPlainCustomSerializer;
public class TreeNodeSerializer extends HisObjectPlainCustomSerializer<TreeNode>{

	@Override
	public void serialize(TreeNode treeNode, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, treeNode, provider);
		
	}
}

















