package com.doublechaintech.his.platform;
import com.doublechaintech.his.BaseForm;
import com.doublechaintech.his.genericform.GenericForm;
import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formaction.FormAction;
import com.doublechaintech.his.formmessage.FormMessage;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;



public class PlatformForm extends BaseForm {
	
	
	public PlatformForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PlatformForm platformIdField(String parameterName, String initValue){
		FormField field = idFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public PlatformForm platformIdField(){
		return platformIdField("platformId","");
	}


	public PlatformForm nameField(String parameterName, String initValue){
		FormField field = nameFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PlatformForm nameField(){
		return nameField("name","");
	}


	public PlatformForm introductionField(String parameterName, String initValue){
		FormField field = introductionFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm introductionField(String initValue){
		return introductionField("introduction",initValue);
	}
	public PlatformForm introductionField(){
		return introductionField("introduction","");
	}


	public PlatformForm currentVersionField(String parameterName, String initValue){
		FormField field = currentVersionFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm currentVersionField(String initValue){
		return currentVersionField("currentVersion",initValue);
	}
	public PlatformForm currentVersionField(){
		return currentVersionField("currentVersion","");
	}

	
	

	



	public PlatformForm doctorIdFieldForDoctor(String parameterName, String initValue){
		FormField field =  idFromDoctor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm doctorIdFieldForDoctor(String initValue){
		return doctorIdFieldForDoctor("doctorId",initValue);
	}
	public PlatformForm doctorIdFieldForDoctor(){
		return doctorIdFieldForDoctor("doctorId","");
	}


	public PlatformForm nameFieldForDoctor(String parameterName, String initValue){
		FormField field =  nameFromDoctor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForDoctor(String initValue){
		return nameFieldForDoctor("name",initValue);
	}
	public PlatformForm nameFieldForDoctor(){
		return nameFieldForDoctor("name","");
	}


	public PlatformForm platformIdFieldForDoctor(String parameterName, String initValue){
		FormField field =  platformIdFromDoctor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForDoctor(String initValue){
		return platformIdFieldForDoctor("platformId",initValue);
	}
	public PlatformForm platformIdFieldForDoctor(){
		return platformIdFieldForDoctor("platformId","");
	}


	public PlatformForm profileIdFieldForProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm profileIdFieldForProfile(String initValue){
		return profileIdFieldForProfile("profileId",initValue);
	}
	public PlatformForm profileIdFieldForProfile(){
		return profileIdFieldForProfile("profileId","");
	}


	public PlatformForm nameFieldForProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForProfile(String initValue){
		return nameFieldForProfile("name",initValue);
	}
	public PlatformForm nameFieldForProfile(){
		return nameFieldForProfile("name","");
	}


	public PlatformForm genderFieldForProfile(String parameterName, String initValue){
		FormField field =  genderFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm genderFieldForProfile(String initValue){
		return genderFieldForProfile("gender",initValue);
	}
	public PlatformForm genderFieldForProfile(){
		return genderFieldForProfile("gender","");
	}


	public PlatformForm ageFieldForProfile(String parameterName, String initValue){
		FormField field =  ageFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm ageFieldForProfile(String initValue){
		return ageFieldForProfile("age",initValue);
	}
	public PlatformForm ageFieldForProfile(){
		return ageFieldForProfile("age","");
	}


	public PlatformForm identificationNumberFieldForProfile(String parameterName, String initValue){
		FormField field =  identificationNumberFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm identificationNumberFieldForProfile(String initValue){
		return identificationNumberFieldForProfile("identificationNumber",initValue);
	}
	public PlatformForm identificationNumberFieldForProfile(){
		return identificationNumberFieldForProfile("identificationNumber","");
	}


	public PlatformForm mobileFieldForProfile(String parameterName, String initValue){
		FormField field =  mobileFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm mobileFieldForProfile(String initValue){
		return mobileFieldForProfile("mobile",initValue);
	}
	public PlatformForm mobileFieldForProfile(){
		return mobileFieldForProfile("mobile","");
	}


	public PlatformForm platformIdFieldForProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForProfile(String initValue){
		return platformIdFieldForProfile("platformId",initValue);
	}
	public PlatformForm platformIdFieldForProfile(){
		return platformIdFieldForProfile("platformId","");
	}


	public PlatformForm registrationIdFieldForRegistration(String parameterName, String initValue){
		FormField field =  idFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm registrationIdFieldForRegistration(String initValue){
		return registrationIdFieldForRegistration("registrationId",initValue);
	}
	public PlatformForm registrationIdFieldForRegistration(){
		return registrationIdFieldForRegistration("registrationId","");
	}


	public PlatformForm titleFieldForRegistration(String parameterName, String initValue){
		FormField field =  titleFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm titleFieldForRegistration(String initValue){
		return titleFieldForRegistration("title",initValue);
	}
	public PlatformForm titleFieldForRegistration(){
		return titleFieldForRegistration("title","");
	}


	public PlatformForm patientIdFieldForRegistration(String parameterName, String initValue){
		FormField field =  patientIdFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm patientIdFieldForRegistration(String initValue){
		return patientIdFieldForRegistration("patientId",initValue);
	}
	public PlatformForm patientIdFieldForRegistration(){
		return patientIdFieldForRegistration("patientId","");
	}


	public PlatformForm registerIdFieldForRegistration(String parameterName, String initValue){
		FormField field =  registerIdFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm registerIdFieldForRegistration(String initValue){
		return registerIdFieldForRegistration("registerId",initValue);
	}
	public PlatformForm registerIdFieldForRegistration(){
		return registerIdFieldForRegistration("registerId","");
	}


	public PlatformForm contentFieldForRegistration(String parameterName, String initValue){
		FormField field =  contentFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm contentFieldForRegistration(String initValue){
		return contentFieldForRegistration("content",initValue);
	}
	public PlatformForm contentFieldForRegistration(){
		return contentFieldForRegistration("content","");
	}


	public PlatformForm updateTimeFieldForRegistration(String parameterName, String initValue){
		FormField field =  updateTimeFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm updateTimeFieldForRegistration(String initValue){
		return updateTimeFieldForRegistration("updateTime",initValue);
	}
	public PlatformForm updateTimeFieldForRegistration(){
		return updateTimeFieldForRegistration("updateTime","");
	}


	public PlatformForm statusFieldForRegistration(String parameterName, String initValue){
		FormField field =  statusFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm statusFieldForRegistration(String initValue){
		return statusFieldForRegistration("status",initValue);
	}
	public PlatformForm statusFieldForRegistration(){
		return statusFieldForRegistration("status","");
	}


	public PlatformForm platformIdFieldForRegistration(String parameterName, String initValue){
		FormField field =  platformIdFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForRegistration(String initValue){
		return platformIdFieldForRegistration("platformId",initValue);
	}
	public PlatformForm platformIdFieldForRegistration(){
		return platformIdFieldForRegistration("platformId","");
	}

	



	public PlatformForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


