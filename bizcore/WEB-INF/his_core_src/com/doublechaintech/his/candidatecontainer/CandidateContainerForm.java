package com.doublechaintech.his.candidatecontainer;
import com.doublechaintech.his.BaseForm;
import com.doublechaintech.his.genericform.GenericForm;
import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formaction.FormAction;
import com.doublechaintech.his.formmessage.FormMessage;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;



public class CandidateContainerForm extends BaseForm {
	
	
	public CandidateContainerForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public CandidateContainerForm candidateContainerIdField(String parameterName, String initValue){
		FormField field = idFromCandidateContainer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CandidateContainerForm candidateContainerIdField(String initValue){
		return candidateContainerIdField("candidateContainerId",initValue);
	}
	public CandidateContainerForm candidateContainerIdField(){
		return candidateContainerIdField("candidateContainerId","");
	}


	public CandidateContainerForm nameField(String parameterName, String initValue){
		FormField field = nameFromCandidateContainer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CandidateContainerForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public CandidateContainerForm nameField(){
		return nameField("name","");
	}

	
	

	



	public CandidateContainerForm candidateElementIdFieldForCandidateElement(String parameterName, String initValue){
		FormField field =  idFromCandidateElement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CandidateContainerForm candidateElementIdFieldForCandidateElement(String initValue){
		return candidateElementIdFieldForCandidateElement("candidateElementId",initValue);
	}
	public CandidateContainerForm candidateElementIdFieldForCandidateElement(){
		return candidateElementIdFieldForCandidateElement("candidateElementId","");
	}


	public CandidateContainerForm nameFieldForCandidateElement(String parameterName, String initValue){
		FormField field =  nameFromCandidateElement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CandidateContainerForm nameFieldForCandidateElement(String initValue){
		return nameFieldForCandidateElement("name",initValue);
	}
	public CandidateContainerForm nameFieldForCandidateElement(){
		return nameFieldForCandidateElement("name","");
	}


	public CandidateContainerForm typeFieldForCandidateElement(String parameterName, String initValue){
		FormField field =  typeFromCandidateElement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CandidateContainerForm typeFieldForCandidateElement(String initValue){
		return typeFieldForCandidateElement("type",initValue);
	}
	public CandidateContainerForm typeFieldForCandidateElement(){
		return typeFieldForCandidateElement("type","");
	}


	public CandidateContainerForm imageFieldForCandidateElement(String parameterName, String initValue){
		FormField field =  imageFromCandidateElement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CandidateContainerForm imageFieldForCandidateElement(String initValue){
		return imageFieldForCandidateElement("image",initValue);
	}
	public CandidateContainerForm imageFieldForCandidateElement(){
		return imageFieldForCandidateElement("image","");
	}


	public CandidateContainerForm containerIdFieldForCandidateElement(String parameterName, String initValue){
		FormField field =  containerIdFromCandidateElement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CandidateContainerForm containerIdFieldForCandidateElement(String initValue){
		return containerIdFieldForCandidateElement("containerId",initValue);
	}
	public CandidateContainerForm containerIdFieldForCandidateElement(){
		return containerIdFieldForCandidateElement("containerId","");
	}

	



	public CandidateContainerForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


