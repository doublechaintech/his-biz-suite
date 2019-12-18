package com.doublechaintech.his.candidateelement;
import com.doublechaintech.his.BaseForm;
import com.doublechaintech.his.genericform.GenericForm;
import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formaction.FormAction;
import com.doublechaintech.his.formmessage.FormMessage;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;



public class CandidateElementForm extends BaseForm {
	
	
	public CandidateElementForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public CandidateElementForm candidateElementIdField(String parameterName, String initValue){
		FormField field = idFromCandidateElement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CandidateElementForm candidateElementIdField(String initValue){
		return candidateElementIdField("candidateElementId",initValue);
	}
	public CandidateElementForm candidateElementIdField(){
		return candidateElementIdField("candidateElementId","");
	}


	public CandidateElementForm nameField(String parameterName, String initValue){
		FormField field = nameFromCandidateElement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CandidateElementForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public CandidateElementForm nameField(){
		return nameField("name","");
	}


	public CandidateElementForm typeField(String parameterName, String initValue){
		FormField field = typeFromCandidateElement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CandidateElementForm typeField(String initValue){
		return typeField("type",initValue);
	}
	public CandidateElementForm typeField(){
		return typeField("type","");
	}


	public CandidateElementForm imageField(String parameterName, String initValue){
		FormField field = imageFromCandidateElement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CandidateElementForm imageField(String initValue){
		return imageField("image",initValue);
	}
	public CandidateElementForm imageField(){
		return imageField("image","");
	}


	public CandidateElementForm containerIdField(String parameterName, String initValue){
		FormField field = containerIdFromCandidateElement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CandidateElementForm containerIdField(String initValue){
		return containerIdField("containerId",initValue);
	}
	public CandidateElementForm containerIdField(){
		return containerIdField("containerId","");
	}

	
	


	public CandidateElementForm candidateContainerIdFieldOfCandidateContainer(String parameterName, String initValue){
		FormField field =  idFromCandidateContainer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CandidateElementForm candidateContainerIdFieldOfCandidateContainer(String initValue){
		return candidateContainerIdFieldOfCandidateContainer("candidateContainerId",initValue);
	}
	public CandidateElementForm candidateContainerIdFieldOfCandidateContainer(){
		return candidateContainerIdFieldOfCandidateContainer("candidateContainerId","");
	}


	public CandidateElementForm nameFieldOfCandidateContainer(String parameterName, String initValue){
		FormField field =  nameFromCandidateContainer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CandidateElementForm nameFieldOfCandidateContainer(String initValue){
		return nameFieldOfCandidateContainer("name",initValue);
	}
	public CandidateElementForm nameFieldOfCandidateContainer(){
		return nameFieldOfCandidateContainer("name","");
	}

	


	

	
 	public CandidateElementForm transferToAnotherContainerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherContainer/candidateElementId/");
		this.addFormAction(action);
		return this;
	}

 

	public CandidateElementForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}












