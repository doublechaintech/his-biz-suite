package com.doublechaintech.his.profile;
import com.doublechaintech.his.BaseForm;
import com.doublechaintech.his.genericform.GenericForm;
import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formaction.FormAction;
import com.doublechaintech.his.formmessage.FormMessage;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;



public class ProfileForm extends BaseForm {
	
	
	public ProfileForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ProfileForm profileIdField(String parameterName, String initValue){
		FormField field = idFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm profileIdField(String initValue){
		return profileIdField("profileId",initValue);
	}
	public ProfileForm profileIdField(){
		return profileIdField("profileId","");
	}


	public ProfileForm nameField(String parameterName, String initValue){
		FormField field = nameFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ProfileForm nameField(){
		return nameField("name","");
	}


	public ProfileForm genderField(String parameterName, String initValue){
		FormField field = genderFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm genderField(String initValue){
		return genderField("gender",initValue);
	}
	public ProfileForm genderField(){
		return genderField("gender","");
	}


	public ProfileForm ageField(String parameterName, String initValue){
		FormField field = ageFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm ageField(String initValue){
		return ageField("age",initValue);
	}
	public ProfileForm ageField(){
		return ageField("age","");
	}


	public ProfileForm identificationNumberField(String parameterName, String initValue){
		FormField field = identificationNumberFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm identificationNumberField(String initValue){
		return identificationNumberField("identificationNumber",initValue);
	}
	public ProfileForm identificationNumberField(){
		return identificationNumberField("identificationNumber","");
	}


	public ProfileForm mobileField(String parameterName, String initValue){
		FormField field = mobileFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm mobileField(String initValue){
		return mobileField("mobile",initValue);
	}
	public ProfileForm mobileField(){
		return mobileField("mobile","");
	}


	public ProfileForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public ProfileForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public ProfileForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public ProfileForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public ProfileForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public ProfileForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public ProfileForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public ProfileForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public ProfileForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public ProfileForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	



	public ProfileForm registrationIdFieldForRegistration(String parameterName, String initValue){
		FormField field =  idFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm registrationIdFieldForRegistration(String initValue){
		return registrationIdFieldForRegistration("registrationId",initValue);
	}
	public ProfileForm registrationIdFieldForRegistration(){
		return registrationIdFieldForRegistration("registrationId","");
	}


	public ProfileForm titleFieldForRegistration(String parameterName, String initValue){
		FormField field =  titleFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm titleFieldForRegistration(String initValue){
		return titleFieldForRegistration("title",initValue);
	}
	public ProfileForm titleFieldForRegistration(){
		return titleFieldForRegistration("title","");
	}


	public ProfileForm patientIdFieldForRegistration(String parameterName, String initValue){
		FormField field =  patientIdFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm patientIdFieldForRegistration(String initValue){
		return patientIdFieldForRegistration("patientId",initValue);
	}
	public ProfileForm patientIdFieldForRegistration(){
		return patientIdFieldForRegistration("patientId","");
	}


	public ProfileForm registerIdFieldForRegistration(String parameterName, String initValue){
		FormField field =  registerIdFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm registerIdFieldForRegistration(String initValue){
		return registerIdFieldForRegistration("registerId",initValue);
	}
	public ProfileForm registerIdFieldForRegistration(){
		return registerIdFieldForRegistration("registerId","");
	}


	public ProfileForm contentFieldForRegistration(String parameterName, String initValue){
		FormField field =  contentFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm contentFieldForRegistration(String initValue){
		return contentFieldForRegistration("content",initValue);
	}
	public ProfileForm contentFieldForRegistration(){
		return contentFieldForRegistration("content","");
	}


	public ProfileForm updateTimeFieldForRegistration(String parameterName, String initValue){
		FormField field =  updateTimeFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm updateTimeFieldForRegistration(String initValue){
		return updateTimeFieldForRegistration("updateTime",initValue);
	}
	public ProfileForm updateTimeFieldForRegistration(){
		return updateTimeFieldForRegistration("updateTime","");
	}


	public ProfileForm statusFieldForRegistration(String parameterName, String initValue){
		FormField field =  statusFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm statusFieldForRegistration(String initValue){
		return statusFieldForRegistration("status",initValue);
	}
	public ProfileForm statusFieldForRegistration(){
		return statusFieldForRegistration("status","");
	}


	public ProfileForm platformIdFieldForRegistration(String parameterName, String initValue){
		FormField field =  platformIdFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm platformIdFieldForRegistration(String initValue){
		return platformIdFieldForRegistration("platformId",initValue);
	}
	public ProfileForm platformIdFieldForRegistration(){
		return platformIdFieldForRegistration("platformId","");
	}

	

	
 	public ProfileForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/profileId/");
		this.addFormAction(action);
		return this;
	}

 

	public ProfileForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


