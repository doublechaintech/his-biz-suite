package com.doublechaintech.his.registration;
import com.doublechaintech.his.BaseForm;
import com.doublechaintech.his.genericform.GenericForm;
import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formaction.FormAction;
import com.doublechaintech.his.formmessage.FormMessage;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;



public class RegistrationForm extends BaseForm {
	
	
	public RegistrationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RegistrationForm registrationIdField(String parameterName, String initValue){
		FormField field = idFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RegistrationForm registrationIdField(String initValue){
		return registrationIdField("registrationId",initValue);
	}
	public RegistrationForm registrationIdField(){
		return registrationIdField("registrationId","");
	}


	public RegistrationForm titleField(String parameterName, String initValue){
		FormField field = titleFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RegistrationForm titleField(String initValue){
		return titleField("title",initValue);
	}
	public RegistrationForm titleField(){
		return titleField("title","");
	}


	public RegistrationForm patientIdField(String parameterName, String initValue){
		FormField field = patientIdFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RegistrationForm patientIdField(String initValue){
		return patientIdField("patientId",initValue);
	}
	public RegistrationForm patientIdField(){
		return patientIdField("patientId","");
	}


	public RegistrationForm registerIdField(String parameterName, String initValue){
		FormField field = registerIdFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RegistrationForm registerIdField(String initValue){
		return registerIdField("registerId",initValue);
	}
	public RegistrationForm registerIdField(){
		return registerIdField("registerId","");
	}


	public RegistrationForm contentField(String parameterName, String initValue){
		FormField field = contentFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RegistrationForm contentField(String initValue){
		return contentField("content",initValue);
	}
	public RegistrationForm contentField(){
		return contentField("content","");
	}


	public RegistrationForm updateTimeField(String parameterName, String initValue){
		FormField field = updateTimeFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RegistrationForm updateTimeField(String initValue){
		return updateTimeField("updateTime",initValue);
	}
	public RegistrationForm updateTimeField(){
		return updateTimeField("updateTime","");
	}


	public RegistrationForm statusField(String parameterName, String initValue){
		FormField field = statusFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RegistrationForm statusField(String initValue){
		return statusField("status",initValue);
	}
	public RegistrationForm statusField(){
		return statusField("status","");
	}


	public RegistrationForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RegistrationForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public RegistrationForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public RegistrationForm profileIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegistrationForm profileIdFieldOfProfile(String initValue){
		return profileIdFieldOfProfile("profileId",initValue);
	}
	public RegistrationForm profileIdFieldOfProfile(){
		return profileIdFieldOfProfile("profileId","");
	}


	public RegistrationForm nameFieldOfProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegistrationForm nameFieldOfProfile(String initValue){
		return nameFieldOfProfile("name",initValue);
	}
	public RegistrationForm nameFieldOfProfile(){
		return nameFieldOfProfile("name","");
	}


	public RegistrationForm genderFieldOfProfile(String parameterName, String initValue){
		FormField field =  genderFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegistrationForm genderFieldOfProfile(String initValue){
		return genderFieldOfProfile("gender",initValue);
	}
	public RegistrationForm genderFieldOfProfile(){
		return genderFieldOfProfile("gender","");
	}


	public RegistrationForm ageFieldOfProfile(String parameterName, String initValue){
		FormField field =  ageFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegistrationForm ageFieldOfProfile(String initValue){
		return ageFieldOfProfile("age",initValue);
	}
	public RegistrationForm ageFieldOfProfile(){
		return ageFieldOfProfile("age","");
	}


	public RegistrationForm identificationNumberFieldOfProfile(String parameterName, String initValue){
		FormField field =  identificationNumberFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegistrationForm identificationNumberFieldOfProfile(String initValue){
		return identificationNumberFieldOfProfile("identificationNumber",initValue);
	}
	public RegistrationForm identificationNumberFieldOfProfile(){
		return identificationNumberFieldOfProfile("identificationNumber","");
	}


	public RegistrationForm mobileFieldOfProfile(String parameterName, String initValue){
		FormField field =  mobileFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegistrationForm mobileFieldOfProfile(String initValue){
		return mobileFieldOfProfile("mobile",initValue);
	}
	public RegistrationForm mobileFieldOfProfile(){
		return mobileFieldOfProfile("mobile","");
	}


	public RegistrationForm platformIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegistrationForm platformIdFieldOfProfile(String initValue){
		return platformIdFieldOfProfile("platformId",initValue);
	}
	public RegistrationForm platformIdFieldOfProfile(){
		return platformIdFieldOfProfile("platformId","");
	}


	public RegistrationForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegistrationForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public RegistrationForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public RegistrationForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegistrationForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public RegistrationForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public RegistrationForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegistrationForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public RegistrationForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public RegistrationForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegistrationForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public RegistrationForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	


	

	
 	public RegistrationForm transferToAnotherPatientAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPatient/registrationId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public RegistrationForm transferToAnotherRegisterAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherRegister/registrationId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public RegistrationForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/registrationId/");
		this.addFormAction(action);
		return this;
	}

 

	public RegistrationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


