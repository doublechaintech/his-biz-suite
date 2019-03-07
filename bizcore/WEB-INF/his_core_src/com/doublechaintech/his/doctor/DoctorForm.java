package com.doublechaintech.his.doctor;
import com.doublechaintech.his.BaseForm;
import com.doublechaintech.his.genericform.GenericForm;
import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formaction.FormAction;
import com.doublechaintech.his.formmessage.FormMessage;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;



public class DoctorForm extends BaseForm {
	
	
	public DoctorForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public DoctorForm doctorIdField(String parameterName, String initValue){
		FormField field = idFromDoctor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm doctorIdField(String initValue){
		return doctorIdField("doctorId",initValue);
	}
	public DoctorForm doctorIdField(){
		return doctorIdField("doctorId","");
	}


	public DoctorForm nameField(String parameterName, String initValue){
		FormField field = nameFromDoctor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public DoctorForm nameField(){
		return nameField("name","");
	}


	public DoctorForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromDoctor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public DoctorForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public DoctorForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public DoctorForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public DoctorForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public DoctorForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public DoctorForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public DoctorForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public DoctorForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public DoctorForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	


	

	
 	public DoctorForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/doctorId/");
		this.addFormAction(action);
		return this;
	}

 

	public DoctorForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


