package com.doublechaintech.his.quicklink;
import com.doublechaintech.his.BaseForm;
import com.doublechaintech.his.genericform.GenericForm;
import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formaction.FormAction;
import com.doublechaintech.his.formmessage.FormMessage;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;



public class QuickLinkForm extends BaseForm {
	
	
	public QuickLinkForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public QuickLinkForm quickLinkIdField(String parameterName, String initValue){
		FormField field = idFromQuickLink(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuickLinkForm quickLinkIdField(String initValue){
		return quickLinkIdField("quickLinkId",initValue);
	}
	public QuickLinkForm quickLinkIdField(){
		return quickLinkIdField("quickLinkId","");
	}


	public QuickLinkForm nameField(String parameterName, String initValue){
		FormField field = nameFromQuickLink(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuickLinkForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public QuickLinkForm nameField(){
		return nameField("name","");
	}


	public QuickLinkForm iconField(String parameterName, String initValue){
		FormField field = iconFromQuickLink(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuickLinkForm iconField(String initValue){
		return iconField("icon",initValue);
	}
	public QuickLinkForm iconField(){
		return iconField("icon","");
	}


	public QuickLinkForm imagePathField(String parameterName, String initValue){
		FormField field = imagePathFromQuickLink(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuickLinkForm imagePathField(String initValue){
		return imagePathField("imagePath",initValue);
	}
	public QuickLinkForm imagePathField(){
		return imagePathField("imagePath","");
	}


	public QuickLinkForm linkTargetField(String parameterName, String initValue){
		FormField field = linkTargetFromQuickLink(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuickLinkForm linkTargetField(String initValue){
		return linkTargetField("linkTarget",initValue);
	}
	public QuickLinkForm linkTargetField(){
		return linkTargetField("linkTarget","");
	}


	public QuickLinkForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromQuickLink(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuickLinkForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public QuickLinkForm createTimeField(){
		return createTimeField("createTime","");
	}


	public QuickLinkForm appIdField(String parameterName, String initValue){
		FormField field = appIdFromQuickLink(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuickLinkForm appIdField(String initValue){
		return appIdField("appId",initValue);
	}
	public QuickLinkForm appIdField(){
		return appIdField("appId","");
	}

	
	


	public QuickLinkForm userAppIdFieldOfUserApp(String parameterName, String initValue){
		FormField field =  idFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public QuickLinkForm userAppIdFieldOfUserApp(String initValue){
		return userAppIdFieldOfUserApp("userAppId",initValue);
	}
	public QuickLinkForm userAppIdFieldOfUserApp(){
		return userAppIdFieldOfUserApp("userAppId","");
	}


	public QuickLinkForm titleFieldOfUserApp(String parameterName, String initValue){
		FormField field =  titleFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public QuickLinkForm titleFieldOfUserApp(String initValue){
		return titleFieldOfUserApp("title",initValue);
	}
	public QuickLinkForm titleFieldOfUserApp(){
		return titleFieldOfUserApp("title","");
	}


	public QuickLinkForm secUserIdFieldOfUserApp(String parameterName, String initValue){
		FormField field =  secUserIdFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public QuickLinkForm secUserIdFieldOfUserApp(String initValue){
		return secUserIdFieldOfUserApp("secUserId",initValue);
	}
	public QuickLinkForm secUserIdFieldOfUserApp(){
		return secUserIdFieldOfUserApp("secUserId","");
	}


	public QuickLinkForm appIconFieldOfUserApp(String parameterName, String initValue){
		FormField field =  appIconFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public QuickLinkForm appIconFieldOfUserApp(String initValue){
		return appIconFieldOfUserApp("appIcon",initValue);
	}
	public QuickLinkForm appIconFieldOfUserApp(){
		return appIconFieldOfUserApp("appIcon","");
	}


	public QuickLinkForm fullAccessFieldOfUserApp(String parameterName, String initValue){
		FormField field =  fullAccessFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public QuickLinkForm fullAccessFieldOfUserApp(String initValue){
		return fullAccessFieldOfUserApp("fullAccess",initValue);
	}
	public QuickLinkForm fullAccessFieldOfUserApp(){
		return fullAccessFieldOfUserApp("fullAccess","");
	}


	public QuickLinkForm permissionFieldOfUserApp(String parameterName, String initValue){
		FormField field =  permissionFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public QuickLinkForm permissionFieldOfUserApp(String initValue){
		return permissionFieldOfUserApp("permission",initValue);
	}
	public QuickLinkForm permissionFieldOfUserApp(){
		return permissionFieldOfUserApp("permission","");
	}


	public QuickLinkForm objectTypeFieldOfUserApp(String parameterName, String initValue){
		FormField field =  objectTypeFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public QuickLinkForm objectTypeFieldOfUserApp(String initValue){
		return objectTypeFieldOfUserApp("objectType",initValue);
	}
	public QuickLinkForm objectTypeFieldOfUserApp(){
		return objectTypeFieldOfUserApp("objectType","");
	}


	public QuickLinkForm objectIdFieldOfUserApp(String parameterName, String initValue){
		FormField field =  objectIdFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public QuickLinkForm objectIdFieldOfUserApp(String initValue){
		return objectIdFieldOfUserApp("objectId",initValue);
	}
	public QuickLinkForm objectIdFieldOfUserApp(){
		return objectIdFieldOfUserApp("objectId","");
	}


	public QuickLinkForm locationFieldOfUserApp(String parameterName, String initValue){
		FormField field =  locationFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public QuickLinkForm locationFieldOfUserApp(String initValue){
		return locationFieldOfUserApp("location",initValue);
	}
	public QuickLinkForm locationFieldOfUserApp(){
		return locationFieldOfUserApp("location","");
	}

	


	

	
 	public QuickLinkForm transferToAnotherAppAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherApp/quickLinkId/");
		this.addFormAction(action);
		return this;
	}

 

	public QuickLinkForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


