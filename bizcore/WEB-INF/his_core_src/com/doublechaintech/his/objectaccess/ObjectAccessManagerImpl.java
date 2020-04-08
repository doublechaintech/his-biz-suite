
package com.doublechaintech.his.objectaccess;

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


import com.doublechaintech.his.userapp.UserApp;

import com.doublechaintech.his.userapp.CandidateUserApp;







public class ObjectAccessManagerImpl extends CustomHisCheckerManager implements ObjectAccessManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "ObjectAccess";
	@Override
	public ObjectAccessDAO daoOf(HisUserContext userContext) {
		return objectAccessDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ObjectAccessManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ObjectAccessManagerException(message);

	}



 	protected ObjectAccess saveObjectAccess(HisUserContext userContext, ObjectAccess objectAccess, String [] tokensExpr) throws Exception{	
 		//return getObjectAccessDAO().save(objectAccess, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveObjectAccess(userContext, objectAccess, tokens);
 	}
 	
 	protected ObjectAccess saveObjectAccessDetail(HisUserContext userContext, ObjectAccess objectAccess) throws Exception{	

 		
 		return saveObjectAccess(userContext, objectAccess, allTokens());
 	}
 	
 	public ObjectAccess loadObjectAccess(HisUserContext userContext, String objectAccessId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfObjectAccess(objectAccessId);
		checkerOf(userContext).throwExceptionIfHasErrors( ObjectAccessManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ObjectAccess objectAccess = loadObjectAccess( userContext, objectAccessId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,objectAccess, tokens);
 	}
 	
 	
 	 public ObjectAccess searchObjectAccess(HisUserContext userContext, String objectAccessId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfObjectAccess(objectAccessId);
		checkerOf(userContext).throwExceptionIfHasErrors( ObjectAccessManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ObjectAccess objectAccess = loadObjectAccess( userContext, objectAccessId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,objectAccess, tokens);
 	}
 	
 	

 	protected ObjectAccess present(HisUserContext userContext, ObjectAccess objectAccess, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,objectAccess,tokens);
		
		
		ObjectAccess  objectAccessToPresent = objectAccessDaoOf(userContext).present(objectAccess, tokens);
		
		List<BaseEntity> entityListToNaming = objectAccessToPresent.collectRefercencesFromLists();
		objectAccessDaoOf(userContext).alias(entityListToNaming);
		
		return  objectAccessToPresent;
		
		
	}
 
 	
 	
 	public ObjectAccess loadObjectAccessDetail(HisUserContext userContext, String objectAccessId) throws Exception{	
 		ObjectAccess objectAccess = loadObjectAccess( userContext, objectAccessId, allTokens());
 		return present(userContext,objectAccess, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String objectAccessId) throws Exception{	
 		ObjectAccess objectAccess = loadObjectAccess( userContext, objectAccessId, viewTokens());
 		return present(userContext,objectAccess, allTokens());
		
 	}
 	protected ObjectAccess saveObjectAccess(HisUserContext userContext, ObjectAccess objectAccess, Map<String,Object>tokens) throws Exception{	
 		return objectAccessDaoOf(userContext).save(objectAccess, tokens);
 	}
 	protected ObjectAccess loadObjectAccess(HisUserContext userContext, String objectAccessId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfObjectAccess(objectAccessId);
		checkerOf(userContext).throwExceptionIfHasErrors( ObjectAccessManagerException.class);

 
 		return objectAccessDaoOf(userContext).load(objectAccessId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, ObjectAccess objectAccess, Map<String, Object> tokens){
		super.addActions(userContext, objectAccess, tokens);
		
		addAction(userContext, objectAccess, tokens,"@create","createObjectAccess","createObjectAccess/","main","primary");
		addAction(userContext, objectAccess, tokens,"@update","updateObjectAccess","updateObjectAccess/"+objectAccess.getId()+"/","main","primary");
		addAction(userContext, objectAccess, tokens,"@copy","cloneObjectAccess","cloneObjectAccess/"+objectAccess.getId()+"/","main","primary");
		
		addAction(userContext, objectAccess, tokens,"object_access.transfer_to_app","transferToAnotherApp","transferToAnotherApp/"+objectAccess.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, ObjectAccess objectAccess, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ObjectAccess createObjectAccess(HisUserContext userContext, String name,String objectType,String list1,String list2,String list3,String list4,String list5,String list6,String list7,String list8,String list9,String appId) throws Exception
	//public ObjectAccess createObjectAccess(HisUserContext userContext,String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9, String appId) throws Exception
	{

		

		

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
	
		checkerOf(userContext).throwExceptionIfHasErrors(ObjectAccessManagerException.class);


		ObjectAccess objectAccess=createNewObjectAccess();	

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
			
		UserApp app = loadUserApp(userContext, appId,emptyOptions());
		objectAccess.setApp(app);
		
		

		objectAccess = saveObjectAccess(userContext, objectAccess, emptyOptions());
		
		onNewInstanceCreated(userContext, objectAccess);
		return objectAccess;


	}
	protected ObjectAccess createNewObjectAccess()
	{

		return new ObjectAccess();
	}

	protected void checkParamsForUpdatingObjectAccess(HisUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfObjectAccess(objectAccessId);
		checkerOf(userContext).checkVersionOfObjectAccess( objectAccessVersion);
		

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

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ObjectAccessManagerException.class);


	}



	public ObjectAccess clone(HisUserContext userContext, String fromObjectAccessId) throws Exception{

		return objectAccessDaoOf(userContext).clone(fromObjectAccessId, this.allTokens());
	}

	public ObjectAccess internalSaveObjectAccess(HisUserContext userContext, ObjectAccess objectAccess) throws Exception
	{
		return internalSaveObjectAccess(userContext, objectAccess, allTokens());

	}
	public ObjectAccess internalSaveObjectAccess(HisUserContext userContext, ObjectAccess objectAccess, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingObjectAccess(userContext, objectAccessId, objectAccessVersion, property, newValueExpr, tokensExpr);


		synchronized(objectAccess){
			//will be good when the objectAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ObjectAccess.
			if (objectAccess.isChanged()){
			
			}
			objectAccess = saveObjectAccess(userContext, objectAccess, options);
			return objectAccess;

		}

	}

	public ObjectAccess updateObjectAccess(HisUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingObjectAccess(userContext, objectAccessId, objectAccessVersion, property, newValueExpr, tokensExpr);



		ObjectAccess objectAccess = loadObjectAccess(userContext, objectAccessId, allTokens());
		if(objectAccess.getVersion() != objectAccessVersion){
			String message = "The target version("+objectAccess.getVersion()+") is not equals to version("+objectAccessVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(objectAccess){
			//will be good when the objectAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ObjectAccess.
			
			objectAccess.changeProperty(property, newValueExpr);
			objectAccess = saveObjectAccess(userContext, objectAccess, tokens().done());
			return present(userContext,objectAccess, mergedAllTokens(tokensExpr));
			//return saveObjectAccess(userContext, objectAccess, tokens().done());
		}

	}

	public ObjectAccess updateObjectAccessProperty(HisUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingObjectAccess(userContext, objectAccessId, objectAccessVersion, property, newValueExpr, tokensExpr);

		ObjectAccess objectAccess = loadObjectAccess(userContext, objectAccessId, allTokens());
		if(objectAccess.getVersion() != objectAccessVersion){
			String message = "The target version("+objectAccess.getVersion()+") is not equals to version("+objectAccessVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(objectAccess){
			//will be good when the objectAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ObjectAccess.

			objectAccess.changeProperty(property, newValueExpr);
			
			objectAccess = saveObjectAccess(userContext, objectAccess, tokens().done());
			return present(userContext,objectAccess, mergedAllTokens(tokensExpr));
			//return saveObjectAccess(userContext, objectAccess, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ObjectAccessTokens tokens(){
		return ObjectAccessTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ObjectAccessTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ObjectAccessTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherApp(HisUserContext userContext, String objectAccessId, String anotherAppId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfObjectAccess(objectAccessId);
 		checkerOf(userContext).checkIdOfUserApp(anotherAppId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ObjectAccessManagerException.class);

 	}
 	public ObjectAccess transferToAnotherApp(HisUserContext userContext, String objectAccessId, String anotherAppId) throws Exception
 	{
 		checkParamsForTransferingAnotherApp(userContext, objectAccessId,anotherAppId);
 
		ObjectAccess objectAccess = loadObjectAccess(userContext, objectAccessId, allTokens());	
		synchronized(objectAccess){
			//will be good when the objectAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserApp app = loadUserApp(userContext, anotherAppId, emptyOptions());		
			objectAccess.updateApp(app);		
			objectAccess = saveObjectAccess(userContext, objectAccess, emptyOptions());
			
			return present(userContext,objectAccess, allTokens());
			
		}

 	}

	


	public CandidateUserApp requestCandidateApp(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateUserApp result = new CandidateUserApp();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<UserApp> candidateList = userAppDaoOf(userContext).requestCandidateUserAppForObjectAccess(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected UserApp loadUserApp(HisUserContext userContext, String newAppId, Map<String,Object> options) throws Exception
 	{

 		return userAppDaoOf(userContext).load(newAppId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String objectAccessId, int objectAccessVersion) throws Exception {
		//deleteInternal(userContext, objectAccessId, objectAccessVersion);
	}
	protected void deleteInternal(HisUserContext userContext,
			String objectAccessId, int objectAccessVersion) throws Exception{

		objectAccessDaoOf(userContext).delete(objectAccessId, objectAccessVersion);
	}

	public ObjectAccess forgetByAll(HisUserContext userContext, String objectAccessId, int objectAccessVersion) throws Exception {
		return forgetByAllInternal(userContext, objectAccessId, objectAccessVersion);
	}
	protected ObjectAccess forgetByAllInternal(HisUserContext userContext,
			String objectAccessId, int objectAccessVersion) throws Exception{

		return objectAccessDaoOf(userContext).disconnectFromAll(objectAccessId, objectAccessVersion);
	}




	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ObjectAccessManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return objectAccessDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(HisUserContext userContext, ObjectAccess newCreated) throws Exception{
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
		//   ObjectAccess newObjectAccess = this.createObjectAccess(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newObjectAccess
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, ObjectAccess.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(HisUserContext userContext,SmartList<ObjectAccess> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<UserApp> appList = HisBaseUtils.collectReferencedObjectWithType(userContext, list, UserApp.class);
		userContext.getDAOGroup().enhanceList(appList, UserApp.class);


    }
	
	public Object listByApp(HisUserContext userContext,String appId) throws Exception {
		return listPageByApp(userContext, appId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByApp(HisUserContext userContext,String appId, int start, int count) throws Exception {
		SmartList<ObjectAccess> list = objectAccessDaoOf(userContext).findObjectAccessByApp(appId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(ObjectAccess.class);
		page.setContainerObject(UserApp.withId(appId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("对象访问列表");
		page.setRequestName("listByApp");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByApp/%s/",  getBeanName(), appId)));

		page.assemblerContent(userContext, "listByApp");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(HisUserContext userContext, String objectAccessId) throws Exception{
	  SerializeScope vscope = HisViewScope.getInstance().getObjectAccessDetailScope().clone();
		ObjectAccess merchantObj = (ObjectAccess) this.view(userContext, objectAccessId);
    String merchantObjId = objectAccessId;
    String linkToUrl =	"objectAccessManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "对象访问"+"详情";
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
				MapUtil.put("id", "2-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "3-objectType")
				    .put("fieldName", "objectType")
				    .put("label", "访问对象类型")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("objectType", merchantObj.getObjectType());

		propList.add(
				MapUtil.put("id", "4-list1")
				    .put("fieldName", "list1")
				    .put("label", "列表1")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("list1", merchantObj.getList1());

		propList.add(
				MapUtil.put("id", "5-list2")
				    .put("fieldName", "list2")
				    .put("label", "列表2")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("list2", merchantObj.getList2());

		propList.add(
				MapUtil.put("id", "6-list3")
				    .put("fieldName", "list3")
				    .put("label", "列表3")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("list3", merchantObj.getList3());

		propList.add(
				MapUtil.put("id", "7-list4")
				    .put("fieldName", "list4")
				    .put("label", "列表4")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("list4", merchantObj.getList4());

		propList.add(
				MapUtil.put("id", "8-list5")
				    .put("fieldName", "list5")
				    .put("label", "列表5")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("list5", merchantObj.getList5());

		propList.add(
				MapUtil.put("id", "9-list6")
				    .put("fieldName", "list6")
				    .put("label", "列表6")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("list6", merchantObj.getList6());

		propList.add(
				MapUtil.put("id", "10-list7")
				    .put("fieldName", "list7")
				    .put("label", "列表7")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("list7", merchantObj.getList7());

		propList.add(
				MapUtil.put("id", "11-list8")
				    .put("fieldName", "list8")
				    .put("label", "列表8")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("list8", merchantObj.getList8());

		propList.add(
				MapUtil.put("id", "12-list9")
				    .put("fieldName", "list9")
				    .put("label", "列表9")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("list9", merchantObj.getList9());

		propList.add(
				MapUtil.put("id", "13-app")
				    .put("fieldName", "app")
				    .put("label", "应用程序")
				    .put("type", "object")
				    .put("displayField", "title")
				    .put("linkToUrl", "userAppManager/wxappview/:id/")
				    .into_map()
		);
		result.put("app", merchantObj.getApp());

		//处理 sectionList

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


