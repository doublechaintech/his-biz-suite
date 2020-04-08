
package com.doublechaintech.his.userapp;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.his.*;
import com.doublechaintech.his.tree.*;
import com.doublechaintech.his.treenode.*;
import com.doublechaintech.his.HisUserContextImpl;
import com.doublechaintech.his.iamservice.*;
import com.doublechaintech.his.services.IamService;
import com.doublechaintech.his.secuser.SecUser;
import com.doublechaintech.his.userapp.UserApp;
import com.doublechaintech.his.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.doublechaintech.his.quicklink.QuickLink;
import com.doublechaintech.his.objectaccess.ObjectAccess;
import com.doublechaintech.his.listaccess.ListAccess;
import com.doublechaintech.his.secuser.SecUser;

import com.doublechaintech.his.secuser.CandidateSecUser;

import com.doublechaintech.his.userapp.UserApp;






public class UserAppManagerImpl extends CustomHisCheckerManager implements UserAppManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "UserApp";
	@Override
	public UserAppDAO daoOf(HisUserContext userContext) {
		return userAppDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws UserAppManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new UserAppManagerException(message);

	}



 	protected UserApp saveUserApp(HisUserContext userContext, UserApp userApp, String [] tokensExpr) throws Exception{	
 		//return getUserAppDAO().save(userApp, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveUserApp(userContext, userApp, tokens);
 	}
 	
 	protected UserApp saveUserAppDetail(HisUserContext userContext, UserApp userApp) throws Exception{	

 		
 		return saveUserApp(userContext, userApp, allTokens());
 	}
 	
 	public UserApp loadUserApp(HisUserContext userContext, String userAppId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).throwExceptionIfHasErrors( UserAppManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		UserApp userApp = loadUserApp( userContext, userAppId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userApp, tokens);
 	}
 	
 	
 	 public UserApp searchUserApp(HisUserContext userContext, String userAppId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).throwExceptionIfHasErrors( UserAppManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		UserApp userApp = loadUserApp( userContext, userAppId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userApp, tokens);
 	}
 	
 	

 	protected UserApp present(HisUserContext userContext, UserApp userApp, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,userApp,tokens);
		
		
		UserApp  userAppToPresent = userAppDaoOf(userContext).present(userApp, tokens);
		
		List<BaseEntity> entityListToNaming = userAppToPresent.collectRefercencesFromLists();
		userAppDaoOf(userContext).alias(entityListToNaming);
		
		return  userAppToPresent;
		
		
	}
 
 	
 	
 	public UserApp loadUserAppDetail(HisUserContext userContext, String userAppId) throws Exception{	
 		UserApp userApp = loadUserApp( userContext, userAppId, allTokens());
 		return present(userContext,userApp, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String userAppId) throws Exception{	
 		UserApp userApp = loadUserApp( userContext, userAppId, viewTokens());
 		return present(userContext,userApp, allTokens());
		
 	}
 	protected UserApp saveUserApp(HisUserContext userContext, UserApp userApp, Map<String,Object>tokens) throws Exception{	
 		return userAppDaoOf(userContext).save(userApp, tokens);
 	}
 	protected UserApp loadUserApp(HisUserContext userContext, String userAppId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).throwExceptionIfHasErrors( UserAppManagerException.class);

 
 		return userAppDaoOf(userContext).load(userAppId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, UserApp userApp, Map<String, Object> tokens){
		super.addActions(userContext, userApp, tokens);
		
		addAction(userContext, userApp, tokens,"@create","createUserApp","createUserApp/","main","primary");
		addAction(userContext, userApp, tokens,"@update","updateUserApp","updateUserApp/"+userApp.getId()+"/","main","primary");
		addAction(userContext, userApp, tokens,"@copy","cloneUserApp","cloneUserApp/"+userApp.getId()+"/","main","primary");
		
		addAction(userContext, userApp, tokens,"user_app.transfer_to_sec_user","transferToAnotherSecUser","transferToAnotherSecUser/"+userApp.getId()+"/","main","primary");
		addAction(userContext, userApp, tokens,"user_app.addQuickLink","addQuickLink","addQuickLink/"+userApp.getId()+"/","quickLinkList","primary");
		addAction(userContext, userApp, tokens,"user_app.removeQuickLink","removeQuickLink","removeQuickLink/"+userApp.getId()+"/","quickLinkList","primary");
		addAction(userContext, userApp, tokens,"user_app.updateQuickLink","updateQuickLink","updateQuickLink/"+userApp.getId()+"/","quickLinkList","primary");
		addAction(userContext, userApp, tokens,"user_app.copyQuickLinkFrom","copyQuickLinkFrom","copyQuickLinkFrom/"+userApp.getId()+"/","quickLinkList","primary");
		addAction(userContext, userApp, tokens,"user_app.addListAccess","addListAccess","addListAccess/"+userApp.getId()+"/","listAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.removeListAccess","removeListAccess","removeListAccess/"+userApp.getId()+"/","listAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.updateListAccess","updateListAccess","updateListAccess/"+userApp.getId()+"/","listAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.copyListAccessFrom","copyListAccessFrom","copyListAccessFrom/"+userApp.getId()+"/","listAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.addObjectAccess","addObjectAccess","addObjectAccess/"+userApp.getId()+"/","objectAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.removeObjectAccess","removeObjectAccess","removeObjectAccess/"+userApp.getId()+"/","objectAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.updateObjectAccess","updateObjectAccess","updateObjectAccess/"+userApp.getId()+"/","objectAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.copyObjectAccessFrom","copyObjectAccessFrom","copyObjectAccessFrom/"+userApp.getId()+"/","objectAccessList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, UserApp userApp, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public UserApp createUserApp(HisUserContext userContext, String title,String secUserId,String appIcon,boolean fullAccess,String permission,String objectType,String objectId,String location) throws Exception
	//public UserApp createUserApp(HisUserContext userContext,String title, String secUserId, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location) throws Exception
	{

		

		

		checkerOf(userContext).checkTitleOfUserApp(title);
		checkerOf(userContext).checkAppIconOfUserApp(appIcon);
		checkerOf(userContext).checkFullAccessOfUserApp(fullAccess);
		checkerOf(userContext).checkPermissionOfUserApp(permission);
		checkerOf(userContext).checkObjectTypeOfUserApp(objectType);
		checkerOf(userContext).checkObjectIdOfUserApp(objectId);
		checkerOf(userContext).checkLocationOfUserApp(location);
	
		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);


		UserApp userApp=createNewUserApp();	

		userApp.setTitle(title);
			
		SecUser secUser = loadSecUser(userContext, secUserId,emptyOptions());
		userApp.setSecUser(secUser);
		
		
		userApp.setAppIcon(appIcon);
		userApp.setFullAccess(fullAccess);
		userApp.setPermission(permission);
		userApp.setObjectType(objectType);
		userApp.setObjectId(objectId);
		userApp.setLocation(location);

		userApp = saveUserApp(userContext, userApp, emptyOptions());
		
		onNewInstanceCreated(userContext, userApp);
		return userApp;


	}
	protected UserApp createNewUserApp()
	{

		return new UserApp();
	}

	protected void checkParamsForUpdatingUserApp(HisUserContext userContext,String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkVersionOfUserApp( userAppVersion);
		

		if(UserApp.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfUserApp(parseString(newValueExpr));
		
			
		}		

		
		if(UserApp.APP_ICON_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAppIconOfUserApp(parseString(newValueExpr));
		
			
		}
		if(UserApp.FULL_ACCESS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFullAccessOfUserApp(parseBoolean(newValueExpr));
		
			
		}
		if(UserApp.PERMISSION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPermissionOfUserApp(parseString(newValueExpr));
		
			
		}
		if(UserApp.OBJECT_TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkObjectTypeOfUserApp(parseString(newValueExpr));
		
			
		}
		if(UserApp.OBJECT_ID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkObjectIdOfUserApp(parseString(newValueExpr));
		
			
		}
		if(UserApp.LOCATION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLocationOfUserApp(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);


	}



	public UserApp clone(HisUserContext userContext, String fromUserAppId) throws Exception{

		return userAppDaoOf(userContext).clone(fromUserAppId, this.allTokens());
	}

	public UserApp internalSaveUserApp(HisUserContext userContext, UserApp userApp) throws Exception
	{
		return internalSaveUserApp(userContext, userApp, allTokens());

	}
	public UserApp internalSaveUserApp(HisUserContext userContext, UserApp userApp, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingUserApp(userContext, userAppId, userAppVersion, property, newValueExpr, tokensExpr);


		synchronized(userApp){
			//will be good when the userApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserApp.
			if (userApp.isChanged()){
			
			}
			userApp = saveUserApp(userContext, userApp, options);
			return userApp;

		}

	}

	public UserApp updateUserApp(HisUserContext userContext,String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingUserApp(userContext, userAppId, userAppVersion, property, newValueExpr, tokensExpr);



		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		if(userApp.getVersion() != userAppVersion){
			String message = "The target version("+userApp.getVersion()+") is not equals to version("+userAppVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userApp){
			//will be good when the userApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserApp.
			
			userApp.changeProperty(property, newValueExpr);
			userApp = saveUserApp(userContext, userApp, tokens().done());
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
			//return saveUserApp(userContext, userApp, tokens().done());
		}

	}

	public UserApp updateUserAppProperty(HisUserContext userContext,String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingUserApp(userContext, userAppId, userAppVersion, property, newValueExpr, tokensExpr);

		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		if(userApp.getVersion() != userAppVersion){
			String message = "The target version("+userApp.getVersion()+") is not equals to version("+userAppVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userApp){
			//will be good when the userApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserApp.

			userApp.changeProperty(property, newValueExpr);
			
			userApp = saveUserApp(userContext, userApp, tokens().done());
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
			//return saveUserApp(userContext, userApp, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected UserAppTokens tokens(){
		return UserAppTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return UserAppTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortQuickLinkListWith("id","desc")
		.sortListAccessListWith("id","desc")
		.sortObjectAccessListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return UserAppTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherSecUser(HisUserContext userContext, String userAppId, String anotherSecUserId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfUserApp(userAppId);
 		checkerOf(userContext).checkIdOfSecUser(anotherSecUserId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

 	}
 	public UserApp transferToAnotherSecUser(HisUserContext userContext, String userAppId, String anotherSecUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUser(userContext, userAppId,anotherSecUserId);
 
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());	
		synchronized(userApp){
			//will be good when the userApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUser(userContext, anotherSecUserId, emptyOptions());		
			userApp.updateSecUser(secUser);		
			userApp = saveUserApp(userContext, userApp, emptyOptions());
			
			return present(userContext,userApp, allTokens());
			
		}

 	}

	

	protected void checkParamsForTransferingAnotherSecUserWithLogin(HisUserContext userContext, String userAppId, String anotherLogin) throws Exception
 	{

 		checkerOf(userContext).checkIdOfUserApp(userAppId);
 		checkerOf(userContext).checkLoginOfSecUser( anotherLogin);
 		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

 	}

 	public UserApp transferToAnotherSecUserWithLogin(HisUserContext userContext, String userAppId, String anotherLogin) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithLogin(userContext, userAppId,anotherLogin);
 		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){
			//will be good when the userApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithLogin(userContext, anotherLogin, emptyOptions());
			userApp.updateSecUser(secUser);
			userApp = saveUserApp(userContext, userApp, emptyOptions());

			return present(userContext,userApp, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithEmail(HisUserContext userContext, String userAppId, String anotherEmail) throws Exception
 	{

 		checkerOf(userContext).checkIdOfUserApp(userAppId);
 		checkerOf(userContext).checkEmailOfSecUser( anotherEmail);
 		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

 	}

 	public UserApp transferToAnotherSecUserWithEmail(HisUserContext userContext, String userAppId, String anotherEmail) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithEmail(userContext, userAppId,anotherEmail);
 		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){
			//will be good when the userApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithEmail(userContext, anotherEmail, emptyOptions());
			userApp.updateSecUser(secUser);
			userApp = saveUserApp(userContext, userApp, emptyOptions());

			return present(userContext,userApp, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithMobile(HisUserContext userContext, String userAppId, String anotherMobile) throws Exception
 	{

 		checkerOf(userContext).checkIdOfUserApp(userAppId);
 		checkerOf(userContext).checkMobileOfSecUser( anotherMobile);
 		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

 	}

 	public UserApp transferToAnotherSecUserWithMobile(HisUserContext userContext, String userAppId, String anotherMobile) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithMobile(userContext, userAppId,anotherMobile);
 		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){
			//will be good when the userApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithMobile(userContext, anotherMobile, emptyOptions());
			userApp.updateSecUser(secUser);
			userApp = saveUserApp(userContext, userApp, emptyOptions());

			return present(userContext,userApp, allTokens());

		}
 	}

	 


	public CandidateSecUser requestCandidateSecUser(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSecUser result = new CandidateSecUser();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("login");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SecUser> candidateList = secUserDaoOf(userContext).requestCandidateSecUserForUserApp(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected SecUser loadSecUser(HisUserContext userContext, String newSecUserId, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).load(newSecUserId, options);
 	}
 	
 	protected SecUser loadSecUserWithLogin(HisUserContext userContext, String newLogin, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByLogin(newLogin, options);
 	}

 	
 	protected SecUser loadSecUserWithEmail(HisUserContext userContext, String newEmail, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByEmail(newEmail, options);
 	}

 	
 	protected SecUser loadSecUserWithMobile(HisUserContext userContext, String newMobile, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByMobile(newMobile, options);
 	}

 	


	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String userAppId, int userAppVersion) throws Exception {
		//deleteInternal(userContext, userAppId, userAppVersion);
	}
	protected void deleteInternal(HisUserContext userContext,
			String userAppId, int userAppVersion) throws Exception{

		userAppDaoOf(userContext).delete(userAppId, userAppVersion);
	}

	public UserApp forgetByAll(HisUserContext userContext, String userAppId, int userAppVersion) throws Exception {
		return forgetByAllInternal(userContext, userAppId, userAppVersion);
	}
	protected UserApp forgetByAllInternal(HisUserContext userContext,
			String userAppId, int userAppVersion) throws Exception{

		return userAppDaoOf(userContext).disconnectFromAll(userAppId, userAppVersion);
	}




	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new UserAppManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return userAppDaoOf(userContext).deleteAll();
	}








	protected void checkParamsForAddingQuickLink(HisUserContext userContext, String userAppId, String name, String icon, String imagePath, String linkTarget,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfUserApp(userAppId);

		
		checkerOf(userContext).checkNameOfQuickLink(name);
		
		checkerOf(userContext).checkIconOfQuickLink(icon);
		
		checkerOf(userContext).checkImagePathOfQuickLink(imagePath);
		
		checkerOf(userContext).checkLinkTargetOfQuickLink(linkTarget);
	
		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);


	}
	public  UserApp addQuickLink(HisUserContext userContext, String userAppId, String name, String icon, String imagePath, String linkTarget, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingQuickLink(userContext,userAppId,name, icon, imagePath, linkTarget,tokensExpr);

		QuickLink quickLink = createQuickLink(userContext,name, icon, imagePath, linkTarget);

		UserApp userApp = loadUserApp(userContext, userAppId, emptyOptions());
		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userApp.addQuickLink( quickLink );
			userApp = saveUserApp(userContext, userApp, tokens().withQuickLinkList().done());
			
			userContext.getManagerGroup().getQuickLinkManager().onNewInstanceCreated(userContext, quickLink);
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingQuickLinkProperties(HisUserContext userContext, String userAppId,String id,String name,String icon,String imagePath,String linkTarget,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkIdOfQuickLink(id);

		checkerOf(userContext).checkNameOfQuickLink( name);
		checkerOf(userContext).checkIconOfQuickLink( icon);
		checkerOf(userContext).checkImagePathOfQuickLink( imagePath);
		checkerOf(userContext).checkLinkTargetOfQuickLink( linkTarget);

		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

	}
	public  UserApp updateQuickLinkProperties(HisUserContext userContext, String userAppId, String id,String name,String icon,String imagePath,String linkTarget, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingQuickLinkProperties(userContext,userAppId,id,name,icon,imagePath,linkTarget,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withQuickLinkListList()
				.searchQuickLinkListWith(QuickLink.ID_PROPERTY, "is", id).done();

		UserApp userAppToUpdate = loadUserApp(userContext, userAppId, options);

		if(userAppToUpdate.getQuickLinkList().isEmpty()){
			throw new UserAppManagerException("QuickLink is NOT FOUND with id: '"+id+"'");
		}

		QuickLink item = userAppToUpdate.getQuickLinkList().first();

		item.updateName( name );
		item.updateIcon( icon );
		item.updateImagePath( imagePath );
		item.updateLinkTarget( linkTarget );


		//checkParamsForAddingQuickLink(userContext,userAppId,name, code, used,tokensExpr);
		UserApp userApp = saveUserApp(userContext, userAppToUpdate, tokens().withQuickLinkList().done());
		synchronized(userApp){
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
	}


	protected QuickLink createQuickLink(HisUserContext userContext, String name, String icon, String imagePath, String linkTarget) throws Exception{

		QuickLink quickLink = new QuickLink();
		
		
		quickLink.setName(name);		
		quickLink.setIcon(icon);		
		quickLink.setImagePath(imagePath);		
		quickLink.setLinkTarget(linkTarget);		
		quickLink.setCreateTime(userContext.now());
	
		
		return quickLink;


	}

	protected QuickLink createIndexedQuickLink(String id, int version){

		QuickLink quickLink = new QuickLink();
		quickLink.setId(id);
		quickLink.setVersion(version);
		return quickLink;

	}

	protected void checkParamsForRemovingQuickLinkList(HisUserContext userContext, String userAppId,
			String quickLinkIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUserApp(userAppId);
		for(String quickLinkIdItem: quickLinkIds){
			checkerOf(userContext).checkIdOfQuickLink(quickLinkIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

	}
	public  UserApp removeQuickLinkList(HisUserContext userContext, String userAppId,
			String quickLinkIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingQuickLinkList(userContext, userAppId,  quickLinkIds, tokensExpr);


			UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
			synchronized(userApp){
				//Will be good when the userApp loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userAppDaoOf(userContext).planToRemoveQuickLinkList(userApp, quickLinkIds, allTokens());
				userApp = saveUserApp(userContext, userApp, tokens().withQuickLinkList().done());
				deleteRelationListInGraph(userContext, userApp.getQuickLinkList());
				return present(userContext,userApp, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingQuickLink(HisUserContext userContext, String userAppId,
		String quickLinkId, int quickLinkVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUserApp( userAppId);
		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
		checkerOf(userContext).checkVersionOfQuickLink(quickLinkVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

	}
	public  UserApp removeQuickLink(HisUserContext userContext, String userAppId,
		String quickLinkId, int quickLinkVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingQuickLink(userContext,userAppId, quickLinkId, quickLinkVersion,tokensExpr);

		QuickLink quickLink = createIndexedQuickLink(quickLinkId, quickLinkVersion);
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userApp.removeQuickLink( quickLink );
			userApp = saveUserApp(userContext, userApp, tokens().withQuickLinkList().done());
			deleteRelationInGraph(userContext, quickLink);
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingQuickLink(HisUserContext userContext, String userAppId,
		String quickLinkId, int quickLinkVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUserApp( userAppId);
		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
		checkerOf(userContext).checkVersionOfQuickLink(quickLinkVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

	}
	public  UserApp copyQuickLinkFrom(HisUserContext userContext, String userAppId,
		String quickLinkId, int quickLinkVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingQuickLink(userContext,userAppId, quickLinkId, quickLinkVersion,tokensExpr);

		QuickLink quickLink = createIndexedQuickLink(quickLinkId, quickLinkVersion);
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			userApp.copyQuickLinkFrom( quickLink );
			userApp = saveUserApp(userContext, userApp, tokens().withQuickLinkList().done());
			
			userContext.getManagerGroup().getQuickLinkManager().onNewInstanceCreated(userContext, (QuickLink)userApp.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingQuickLink(HisUserContext userContext, String userAppId, String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
		checkerOf(userContext).checkVersionOfQuickLink(quickLinkVersion);
		

		if(QuickLink.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfQuickLink(parseString(newValueExpr));
		
		}
		
		if(QuickLink.ICON_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkIconOfQuickLink(parseString(newValueExpr));
		
		}
		
		if(QuickLink.IMAGE_PATH_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkImagePathOfQuickLink(parseString(newValueExpr));
		
		}
		
		if(QuickLink.LINK_TARGET_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLinkTargetOfQuickLink(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

	}

	public  UserApp updateQuickLink(HisUserContext userContext, String userAppId, String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingQuickLink(userContext, userAppId, quickLinkId, quickLinkVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withQuickLinkList().searchQuickLinkListWith(QuickLink.ID_PROPERTY, "eq", quickLinkId).done();



		UserApp userApp = loadUserApp(userContext, userAppId, loadTokens);

		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//userApp.removeQuickLink( quickLink );
			//make changes to AcceleraterAccount.
			QuickLink quickLinkIndex = createIndexedQuickLink(quickLinkId, quickLinkVersion);

			QuickLink quickLink = userApp.findTheQuickLink(quickLinkIndex);
			if(quickLink == null){
				throw new UserAppManagerException(quickLink+" is NOT FOUND" );
			}

			quickLink.changeProperty(property, newValueExpr);
			
			userApp = saveUserApp(userContext, userApp, tokens().withQuickLinkList().done());
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingListAccess(HisUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfUserApp(userAppId);

		
		checkerOf(userContext).checkNameOfListAccess(name);
		
		checkerOf(userContext).checkInternalNameOfListAccess(internalName);
		
		checkerOf(userContext).checkReadPermissionOfListAccess(readPermission);
		
		checkerOf(userContext).checkCreatePermissionOfListAccess(createPermission);
		
		checkerOf(userContext).checkDeletePermissionOfListAccess(deletePermission);
		
		checkerOf(userContext).checkUpdatePermissionOfListAccess(updatePermission);
		
		checkerOf(userContext).checkExecutionPermissionOfListAccess(executionPermission);
	
		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);


	}
	public  UserApp addListAccess(HisUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingListAccess(userContext,userAppId,name, internalName, readPermission, createPermission, deletePermission, updatePermission, executionPermission,tokensExpr);

		ListAccess listAccess = createListAccess(userContext,name, internalName, readPermission, createPermission, deletePermission, updatePermission, executionPermission);

		UserApp userApp = loadUserApp(userContext, userAppId, emptyOptions());
		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userApp.addListAccess( listAccess );
			userApp = saveUserApp(userContext, userApp, tokens().withListAccessList().done());
			
			userContext.getManagerGroup().getListAccessManager().onNewInstanceCreated(userContext, listAccess);
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingListAccessProperties(HisUserContext userContext, String userAppId,String id,String name,String internalName,boolean readPermission,boolean createPermission,boolean deletePermission,boolean updatePermission,boolean executionPermission,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkIdOfListAccess(id);

		checkerOf(userContext).checkNameOfListAccess( name);
		checkerOf(userContext).checkInternalNameOfListAccess( internalName);
		checkerOf(userContext).checkReadPermissionOfListAccess( readPermission);
		checkerOf(userContext).checkCreatePermissionOfListAccess( createPermission);
		checkerOf(userContext).checkDeletePermissionOfListAccess( deletePermission);
		checkerOf(userContext).checkUpdatePermissionOfListAccess( updatePermission);
		checkerOf(userContext).checkExecutionPermissionOfListAccess( executionPermission);

		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

	}
	public  UserApp updateListAccessProperties(HisUserContext userContext, String userAppId, String id,String name,String internalName,boolean readPermission,boolean createPermission,boolean deletePermission,boolean updatePermission,boolean executionPermission, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingListAccessProperties(userContext,userAppId,id,name,internalName,readPermission,createPermission,deletePermission,updatePermission,executionPermission,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withListAccessListList()
				.searchListAccessListWith(ListAccess.ID_PROPERTY, "is", id).done();

		UserApp userAppToUpdate = loadUserApp(userContext, userAppId, options);

		if(userAppToUpdate.getListAccessList().isEmpty()){
			throw new UserAppManagerException("ListAccess is NOT FOUND with id: '"+id+"'");
		}

		ListAccess item = userAppToUpdate.getListAccessList().first();

		item.updateName( name );
		item.updateInternalName( internalName );
		item.updateReadPermission( readPermission );
		item.updateCreatePermission( createPermission );
		item.updateDeletePermission( deletePermission );
		item.updateUpdatePermission( updatePermission );
		item.updateExecutionPermission( executionPermission );


		//checkParamsForAddingListAccess(userContext,userAppId,name, code, used,tokensExpr);
		UserApp userApp = saveUserApp(userContext, userAppToUpdate, tokens().withListAccessList().done());
		synchronized(userApp){
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
	}


	protected ListAccess createListAccess(HisUserContext userContext, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission) throws Exception{

		ListAccess listAccess = new ListAccess();
		
		
		listAccess.setName(name);		
		listAccess.setInternalName(internalName);		
		listAccess.setReadPermission(readPermission);		
		listAccess.setCreatePermission(createPermission);		
		listAccess.setDeletePermission(deletePermission);		
		listAccess.setUpdatePermission(updatePermission);		
		listAccess.setExecutionPermission(executionPermission);
	
		
		return listAccess;


	}

	protected ListAccess createIndexedListAccess(String id, int version){

		ListAccess listAccess = new ListAccess();
		listAccess.setId(id);
		listAccess.setVersion(version);
		return listAccess;

	}

	protected void checkParamsForRemovingListAccessList(HisUserContext userContext, String userAppId,
			String listAccessIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUserApp(userAppId);
		for(String listAccessIdItem: listAccessIds){
			checkerOf(userContext).checkIdOfListAccess(listAccessIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

	}
	public  UserApp removeListAccessList(HisUserContext userContext, String userAppId,
			String listAccessIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingListAccessList(userContext, userAppId,  listAccessIds, tokensExpr);


			UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
			synchronized(userApp){
				//Will be good when the userApp loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userAppDaoOf(userContext).planToRemoveListAccessList(userApp, listAccessIds, allTokens());
				userApp = saveUserApp(userContext, userApp, tokens().withListAccessList().done());
				deleteRelationListInGraph(userContext, userApp.getListAccessList());
				return present(userContext,userApp, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingListAccess(HisUserContext userContext, String userAppId,
		String listAccessId, int listAccessVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUserApp( userAppId);
		checkerOf(userContext).checkIdOfListAccess(listAccessId);
		checkerOf(userContext).checkVersionOfListAccess(listAccessVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

	}
	public  UserApp removeListAccess(HisUserContext userContext, String userAppId,
		String listAccessId, int listAccessVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingListAccess(userContext,userAppId, listAccessId, listAccessVersion,tokensExpr);

		ListAccess listAccess = createIndexedListAccess(listAccessId, listAccessVersion);
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userApp.removeListAccess( listAccess );
			userApp = saveUserApp(userContext, userApp, tokens().withListAccessList().done());
			deleteRelationInGraph(userContext, listAccess);
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingListAccess(HisUserContext userContext, String userAppId,
		String listAccessId, int listAccessVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUserApp( userAppId);
		checkerOf(userContext).checkIdOfListAccess(listAccessId);
		checkerOf(userContext).checkVersionOfListAccess(listAccessVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

	}
	public  UserApp copyListAccessFrom(HisUserContext userContext, String userAppId,
		String listAccessId, int listAccessVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingListAccess(userContext,userAppId, listAccessId, listAccessVersion,tokensExpr);

		ListAccess listAccess = createIndexedListAccess(listAccessId, listAccessVersion);
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			userApp.copyListAccessFrom( listAccess );
			userApp = saveUserApp(userContext, userApp, tokens().withListAccessList().done());
			
			userContext.getManagerGroup().getListAccessManager().onNewInstanceCreated(userContext, (ListAccess)userApp.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingListAccess(HisUserContext userContext, String userAppId, String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkIdOfListAccess(listAccessId);
		checkerOf(userContext).checkVersionOfListAccess(listAccessVersion);
		

		if(ListAccess.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfListAccess(parseString(newValueExpr));
		
		}
		
		if(ListAccess.INTERNAL_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkInternalNameOfListAccess(parseString(newValueExpr));
		
		}
		
		if(ListAccess.READ_PERMISSION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkReadPermissionOfListAccess(parseBoolean(newValueExpr));
		
		}
		
		if(ListAccess.CREATE_PERMISSION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCreatePermissionOfListAccess(parseBoolean(newValueExpr));
		
		}
		
		if(ListAccess.DELETE_PERMISSION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDeletePermissionOfListAccess(parseBoolean(newValueExpr));
		
		}
		
		if(ListAccess.UPDATE_PERMISSION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkUpdatePermissionOfListAccess(parseBoolean(newValueExpr));
		
		}
		
		if(ListAccess.EXECUTION_PERMISSION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkExecutionPermissionOfListAccess(parseBoolean(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

	}

	public  UserApp updateListAccess(HisUserContext userContext, String userAppId, String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingListAccess(userContext, userAppId, listAccessId, listAccessVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withListAccessList().searchListAccessListWith(ListAccess.ID_PROPERTY, "eq", listAccessId).done();



		UserApp userApp = loadUserApp(userContext, userAppId, loadTokens);

		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//userApp.removeListAccess( listAccess );
			//make changes to AcceleraterAccount.
			ListAccess listAccessIndex = createIndexedListAccess(listAccessId, listAccessVersion);

			ListAccess listAccess = userApp.findTheListAccess(listAccessIndex);
			if(listAccess == null){
				throw new UserAppManagerException(listAccess+" is NOT FOUND" );
			}

			listAccess.changeProperty(property, newValueExpr);
			
			userApp = saveUserApp(userContext, userApp, tokens().withListAccessList().done());
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingObjectAccess(HisUserContext userContext, String userAppId, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfUserApp(userAppId);

		
		checkerOf(userContext).checkNameOfObjectAccess(name);
		
		checkerOf(userContext).checkObjectTypeOfObjectAccess(objectType);
		
		checkerOf(userContext).checkList1OfObjectAccess(list1);
		
		checkerOf(userContext).checkList2OfObjectAccess(list2);
		
		checkerOf(userContext).checkList3OfObjectAccess(list3);
		
		checkerOf(userContext).checkList4OfObjectAccess(list4);
		
		checkerOf(userContext).checkList5OfObjectAccess(list5);
		
		checkerOf(userContext).checkList6OfObjectAccess(list6);
		
		checkerOf(userContext).checkList7OfObjectAccess(list7);
		
		checkerOf(userContext).checkList8OfObjectAccess(list8);
		
		checkerOf(userContext).checkList9OfObjectAccess(list9);
	
		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);


	}
	public  UserApp addObjectAccess(HisUserContext userContext, String userAppId, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingObjectAccess(userContext,userAppId,name, objectType, list1, list2, list3, list4, list5, list6, list7, list8, list9,tokensExpr);

		ObjectAccess objectAccess = createObjectAccess(userContext,name, objectType, list1, list2, list3, list4, list5, list6, list7, list8, list9);

		UserApp userApp = loadUserApp(userContext, userAppId, emptyOptions());
		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userApp.addObjectAccess( objectAccess );
			userApp = saveUserApp(userContext, userApp, tokens().withObjectAccessList().done());
			
			userContext.getManagerGroup().getObjectAccessManager().onNewInstanceCreated(userContext, objectAccess);
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingObjectAccessProperties(HisUserContext userContext, String userAppId,String id,String name,String objectType,String list1,String list2,String list3,String list4,String list5,String list6,String list7,String list8,String list9,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkIdOfObjectAccess(id);

		checkerOf(userContext).checkNameOfObjectAccess( name);
		checkerOf(userContext).checkObjectTypeOfObjectAccess( objectType);
		checkerOf(userContext).checkList1OfObjectAccess( list1);
		checkerOf(userContext).checkList2OfObjectAccess( list2);
		checkerOf(userContext).checkList3OfObjectAccess( list3);
		checkerOf(userContext).checkList4OfObjectAccess( list4);
		checkerOf(userContext).checkList5OfObjectAccess( list5);
		checkerOf(userContext).checkList6OfObjectAccess( list6);
		checkerOf(userContext).checkList7OfObjectAccess( list7);
		checkerOf(userContext).checkList8OfObjectAccess( list8);
		checkerOf(userContext).checkList9OfObjectAccess( list9);

		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

	}
	public  UserApp updateObjectAccessProperties(HisUserContext userContext, String userAppId, String id,String name,String objectType,String list1,String list2,String list3,String list4,String list5,String list6,String list7,String list8,String list9, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingObjectAccessProperties(userContext,userAppId,id,name,objectType,list1,list2,list3,list4,list5,list6,list7,list8,list9,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withObjectAccessListList()
				.searchObjectAccessListWith(ObjectAccess.ID_PROPERTY, "is", id).done();

		UserApp userAppToUpdate = loadUserApp(userContext, userAppId, options);

		if(userAppToUpdate.getObjectAccessList().isEmpty()){
			throw new UserAppManagerException("ObjectAccess is NOT FOUND with id: '"+id+"'");
		}

		ObjectAccess item = userAppToUpdate.getObjectAccessList().first();

		item.updateName( name );
		item.updateObjectType( objectType );
		item.updateList1( list1 );
		item.updateList2( list2 );
		item.updateList3( list3 );
		item.updateList4( list4 );
		item.updateList5( list5 );
		item.updateList6( list6 );
		item.updateList7( list7 );
		item.updateList8( list8 );
		item.updateList9( list9 );


		//checkParamsForAddingObjectAccess(userContext,userAppId,name, code, used,tokensExpr);
		UserApp userApp = saveUserApp(userContext, userAppToUpdate, tokens().withObjectAccessList().done());
		synchronized(userApp){
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
	}


	protected ObjectAccess createObjectAccess(HisUserContext userContext, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9) throws Exception{

		ObjectAccess objectAccess = new ObjectAccess();
		
		
		objectAccess.setName(name);		
		objectAccess.setObjectType(objectType);		
		objectAccess.setList1(list1);		
		objectAccess.setList2(list2);		
		objectAccess.setList3(list3);		
		objectAccess.setList4(list4);		
		objectAccess.setList5(list5);		
		objectAccess.setList6(list6);		
		objectAccess.setList7(list7);		
		objectAccess.setList8(list8);		
		objectAccess.setList9(list9);
	
		
		return objectAccess;


	}

	protected ObjectAccess createIndexedObjectAccess(String id, int version){

		ObjectAccess objectAccess = new ObjectAccess();
		objectAccess.setId(id);
		objectAccess.setVersion(version);
		return objectAccess;

	}

	protected void checkParamsForRemovingObjectAccessList(HisUserContext userContext, String userAppId,
			String objectAccessIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUserApp(userAppId);
		for(String objectAccessIdItem: objectAccessIds){
			checkerOf(userContext).checkIdOfObjectAccess(objectAccessIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

	}
	public  UserApp removeObjectAccessList(HisUserContext userContext, String userAppId,
			String objectAccessIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingObjectAccessList(userContext, userAppId,  objectAccessIds, tokensExpr);


			UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
			synchronized(userApp){
				//Will be good when the userApp loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userAppDaoOf(userContext).planToRemoveObjectAccessList(userApp, objectAccessIds, allTokens());
				userApp = saveUserApp(userContext, userApp, tokens().withObjectAccessList().done());
				deleteRelationListInGraph(userContext, userApp.getObjectAccessList());
				return present(userContext,userApp, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingObjectAccess(HisUserContext userContext, String userAppId,
		String objectAccessId, int objectAccessVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUserApp( userAppId);
		checkerOf(userContext).checkIdOfObjectAccess(objectAccessId);
		checkerOf(userContext).checkVersionOfObjectAccess(objectAccessVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

	}
	public  UserApp removeObjectAccess(HisUserContext userContext, String userAppId,
		String objectAccessId, int objectAccessVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingObjectAccess(userContext,userAppId, objectAccessId, objectAccessVersion,tokensExpr);

		ObjectAccess objectAccess = createIndexedObjectAccess(objectAccessId, objectAccessVersion);
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userApp.removeObjectAccess( objectAccess );
			userApp = saveUserApp(userContext, userApp, tokens().withObjectAccessList().done());
			deleteRelationInGraph(userContext, objectAccess);
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingObjectAccess(HisUserContext userContext, String userAppId,
		String objectAccessId, int objectAccessVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUserApp( userAppId);
		checkerOf(userContext).checkIdOfObjectAccess(objectAccessId);
		checkerOf(userContext).checkVersionOfObjectAccess(objectAccessVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

	}
	public  UserApp copyObjectAccessFrom(HisUserContext userContext, String userAppId,
		String objectAccessId, int objectAccessVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingObjectAccess(userContext,userAppId, objectAccessId, objectAccessVersion,tokensExpr);

		ObjectAccess objectAccess = createIndexedObjectAccess(objectAccessId, objectAccessVersion);
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			userApp.copyObjectAccessFrom( objectAccess );
			userApp = saveUserApp(userContext, userApp, tokens().withObjectAccessList().done());
			
			userContext.getManagerGroup().getObjectAccessManager().onNewInstanceCreated(userContext, (ObjectAccess)userApp.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingObjectAccess(HisUserContext userContext, String userAppId, String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkIdOfObjectAccess(objectAccessId);
		checkerOf(userContext).checkVersionOfObjectAccess(objectAccessVersion);
		

		if(ObjectAccess.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfObjectAccess(parseString(newValueExpr));
		
		}
		
		if(ObjectAccess.OBJECT_TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkObjectTypeOfObjectAccess(parseString(newValueExpr));
		
		}
		
		if(ObjectAccess.LIST1_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkList1OfObjectAccess(parseString(newValueExpr));
		
		}
		
		if(ObjectAccess.LIST2_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkList2OfObjectAccess(parseString(newValueExpr));
		
		}
		
		if(ObjectAccess.LIST3_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkList3OfObjectAccess(parseString(newValueExpr));
		
		}
		
		if(ObjectAccess.LIST4_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkList4OfObjectAccess(parseString(newValueExpr));
		
		}
		
		if(ObjectAccess.LIST5_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkList5OfObjectAccess(parseString(newValueExpr));
		
		}
		
		if(ObjectAccess.LIST6_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkList6OfObjectAccess(parseString(newValueExpr));
		
		}
		
		if(ObjectAccess.LIST7_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkList7OfObjectAccess(parseString(newValueExpr));
		
		}
		
		if(ObjectAccess.LIST8_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkList8OfObjectAccess(parseString(newValueExpr));
		
		}
		
		if(ObjectAccess.LIST9_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkList9OfObjectAccess(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(UserAppManagerException.class);

	}

	public  UserApp updateObjectAccess(HisUserContext userContext, String userAppId, String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingObjectAccess(userContext, userAppId, objectAccessId, objectAccessVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withObjectAccessList().searchObjectAccessListWith(ObjectAccess.ID_PROPERTY, "eq", objectAccessId).done();



		UserApp userApp = loadUserApp(userContext, userAppId, loadTokens);

		synchronized(userApp){
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//userApp.removeObjectAccess( objectAccess );
			//make changes to AcceleraterAccount.
			ObjectAccess objectAccessIndex = createIndexedObjectAccess(objectAccessId, objectAccessVersion);

			ObjectAccess objectAccess = userApp.findTheObjectAccess(objectAccessIndex);
			if(objectAccess == null){
				throw new UserAppManagerException(objectAccess+" is NOT FOUND" );
			}

			objectAccess.changeProperty(property, newValueExpr);
			
			userApp = saveUserApp(userContext, userApp, tokens().withObjectAccessList().done());
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(HisUserContext userContext, UserApp newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(HisUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(HisBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(HisUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(HisBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(HisUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(HisBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(HisUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(HisBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(HisUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		HisUserContextImpl userContext = (HisUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(HisUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(HisUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(HisUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(HisUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(HisUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   UserApp newUserApp = this.createUserApp(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newUserApp
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(HisUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, UserApp.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(HisUserContext userContext,SmartList<UserApp> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<SecUser> secUserList = HisBaseUtils.collectReferencedObjectWithType(userContext, list, SecUser.class);
		userContext.getDAOGroup().enhanceList(secUserList, SecUser.class);


    }
	
	public Object listBySecUser(HisUserContext userContext,String secUserId) throws Exception {
		return listPageBySecUser(userContext, secUserId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageBySecUser(HisUserContext userContext,String secUserId, int start, int count) throws Exception {
		SmartList<UserApp> list = userAppDaoOf(userContext).findUserAppBySecUser(secUserId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(UserApp.class);
		page.setContainerObject(SecUser.withId(secUserId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("用户应用程序列表");
		page.setRequestName("listBySecUser");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listBySecUser/%s/",  getBeanName(), secUserId)));

		page.assemblerContent(userContext, "listBySecUser");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(HisUserContext userContext, String userAppId) throws Exception{
	  SerializeScope vscope = HisViewScope.getInstance().getUserAppDetailScope().clone();
		UserApp merchantObj = (UserApp) this.view(userContext, userAppId);
    String merchantObjId = userAppId;
    String linkToUrl =	"userAppManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "用户应用程序"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "序号")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-title")
				    .put("fieldName", "title")
				    .put("label", "标题")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("title", merchantObj.getTitle());

		propList.add(
				MapUtil.put("id", "3-secUser")
				    .put("fieldName", "secUser")
				    .put("label", "安全用户")
				    .put("type", "object")
				    .put("displayField", "login")
				    .put("linkToUrl", "secUserManager/wxappview/:id/")
				    .into_map()
		);
		result.put("secUser", merchantObj.getSecUser());

		propList.add(
				MapUtil.put("id", "4-appIcon")
				    .put("fieldName", "appIcon")
				    .put("label", "应用程序图标")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("appIcon", merchantObj.getAppIcon());

		propList.add(
				MapUtil.put("id", "5-fullAccess")
				    .put("fieldName", "fullAccess")
				    .put("label", "完全访问")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("fullAccess", merchantObj.getFullAccess());

		propList.add(
				MapUtil.put("id", "6-permission")
				    .put("fieldName", "permission")
				    .put("label", "许可")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("permission", merchantObj.getPermission());

		propList.add(
				MapUtil.put("id", "7-objectType")
				    .put("fieldName", "objectType")
				    .put("label", "访问对象类型")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("objectType", merchantObj.getObjectType());

		propList.add(
				MapUtil.put("id", "8-objectId")
				    .put("fieldName", "objectId")
				    .put("label", "对象ID")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("objectId", merchantObj.getObjectId());

		propList.add(
				MapUtil.put("id", "9-location")
				    .put("fieldName", "location")
				    .put("label", "位置")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("location", merchantObj.getLocation());

		//处理 sectionList

		//处理Section：quickLinkListSection
		Map quickLinkListSection = ListofUtils.buildSection(
		    "quickLinkListSection",
		    "快速链接列表",
		    null,
		    "",
		    "__no_group",
		    "quickLinkManager/listByApp/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(quickLinkListSection);

		result.put("quickLinkListSection", ListofUtils.toShortList(merchantObj.getQuickLinkList(), "quickLink"));
		vscope.field("quickLinkListSection", HisListOfViewScope.getInstance()
					.getListOfViewScope( QuickLink.class.getName(), null));

		//处理Section：listAccessListSection
		Map listAccessListSection = ListofUtils.buildSection(
		    "listAccessListSection",
		    "访问列表",
		    null,
		    "",
		    "__no_group",
		    "listAccessManager/listByApp/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(listAccessListSection);

		result.put("listAccessListSection", ListofUtils.toShortList(merchantObj.getListAccessList(), "listAccess"));
		vscope.field("listAccessListSection", HisListOfViewScope.getInstance()
					.getListOfViewScope( ListAccess.class.getName(), null));

		//处理Section：objectAccessListSection
		Map objectAccessListSection = ListofUtils.buildSection(
		    "objectAccessListSection",
		    "对象访问列表",
		    null,
		    "",
		    "__no_group",
		    "objectAccessManager/listByApp/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(objectAccessListSection);

		result.put("objectAccessListSection", ListofUtils.toShortList(merchantObj.getObjectAccessList(), "objectAccess"));
		vscope.field("objectAccessListSection", HisListOfViewScope.getInstance()
					.getListOfViewScope( ObjectAccess.class.getName(), null));

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}

}


