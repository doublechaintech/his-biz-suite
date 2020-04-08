
package com.doublechaintech.his.listaccess;

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







public class ListAccessManagerImpl extends CustomHisCheckerManager implements ListAccessManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "ListAccess";
	@Override
	public ListAccessDAO daoOf(HisUserContext userContext) {
		return listAccessDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ListAccessManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ListAccessManagerException(message);

	}



 	protected ListAccess saveListAccess(HisUserContext userContext, ListAccess listAccess, String [] tokensExpr) throws Exception{	
 		//return getListAccessDAO().save(listAccess, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveListAccess(userContext, listAccess, tokens);
 	}
 	
 	protected ListAccess saveListAccessDetail(HisUserContext userContext, ListAccess listAccess) throws Exception{	

 		
 		return saveListAccess(userContext, listAccess, allTokens());
 	}
 	
 	public ListAccess loadListAccess(HisUserContext userContext, String listAccessId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfListAccess(listAccessId);
		checkerOf(userContext).throwExceptionIfHasErrors( ListAccessManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ListAccess listAccess = loadListAccess( userContext, listAccessId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,listAccess, tokens);
 	}
 	
 	
 	 public ListAccess searchListAccess(HisUserContext userContext, String listAccessId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfListAccess(listAccessId);
		checkerOf(userContext).throwExceptionIfHasErrors( ListAccessManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ListAccess listAccess = loadListAccess( userContext, listAccessId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,listAccess, tokens);
 	}
 	
 	

 	protected ListAccess present(HisUserContext userContext, ListAccess listAccess, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,listAccess,tokens);
		
		
		ListAccess  listAccessToPresent = listAccessDaoOf(userContext).present(listAccess, tokens);
		
		List<BaseEntity> entityListToNaming = listAccessToPresent.collectRefercencesFromLists();
		listAccessDaoOf(userContext).alias(entityListToNaming);
		
		return  listAccessToPresent;
		
		
	}
 
 	
 	
 	public ListAccess loadListAccessDetail(HisUserContext userContext, String listAccessId) throws Exception{	
 		ListAccess listAccess = loadListAccess( userContext, listAccessId, allTokens());
 		return present(userContext,listAccess, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String listAccessId) throws Exception{	
 		ListAccess listAccess = loadListAccess( userContext, listAccessId, viewTokens());
 		return present(userContext,listAccess, allTokens());
		
 	}
 	protected ListAccess saveListAccess(HisUserContext userContext, ListAccess listAccess, Map<String,Object>tokens) throws Exception{	
 		return listAccessDaoOf(userContext).save(listAccess, tokens);
 	}
 	protected ListAccess loadListAccess(HisUserContext userContext, String listAccessId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfListAccess(listAccessId);
		checkerOf(userContext).throwExceptionIfHasErrors( ListAccessManagerException.class);

 
 		return listAccessDaoOf(userContext).load(listAccessId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, ListAccess listAccess, Map<String, Object> tokens){
		super.addActions(userContext, listAccess, tokens);
		
		addAction(userContext, listAccess, tokens,"@create","createListAccess","createListAccess/","main","primary");
		addAction(userContext, listAccess, tokens,"@update","updateListAccess","updateListAccess/"+listAccess.getId()+"/","main","primary");
		addAction(userContext, listAccess, tokens,"@copy","cloneListAccess","cloneListAccess/"+listAccess.getId()+"/","main","primary");
		
		addAction(userContext, listAccess, tokens,"list_access.transfer_to_app","transferToAnotherApp","transferToAnotherApp/"+listAccess.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, ListAccess listAccess, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ListAccess createListAccess(HisUserContext userContext, String name,String internalName,boolean readPermission,boolean createPermission,boolean deletePermission,boolean updatePermission,boolean executionPermission,String appId) throws Exception
	//public ListAccess createListAccess(HisUserContext userContext,String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission, String appId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfListAccess(name);
		checkerOf(userContext).checkInternalNameOfListAccess(internalName);
		checkerOf(userContext).checkReadPermissionOfListAccess(readPermission);
		checkerOf(userContext).checkCreatePermissionOfListAccess(createPermission);
		checkerOf(userContext).checkDeletePermissionOfListAccess(deletePermission);
		checkerOf(userContext).checkUpdatePermissionOfListAccess(updatePermission);
		checkerOf(userContext).checkExecutionPermissionOfListAccess(executionPermission);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ListAccessManagerException.class);


		ListAccess listAccess=createNewListAccess();	

		listAccess.setName(name);
		listAccess.setInternalName(internalName);
		listAccess.setReadPermission(readPermission);
		listAccess.setCreatePermission(createPermission);
		listAccess.setDeletePermission(deletePermission);
		listAccess.setUpdatePermission(updatePermission);
		listAccess.setExecutionPermission(executionPermission);
			
		UserApp app = loadUserApp(userContext, appId,emptyOptions());
		listAccess.setApp(app);
		
		

		listAccess = saveListAccess(userContext, listAccess, emptyOptions());
		
		onNewInstanceCreated(userContext, listAccess);
		return listAccess;


	}
	protected ListAccess createNewListAccess()
	{

		return new ListAccess();
	}

	protected void checkParamsForUpdatingListAccess(HisUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfListAccess(listAccessId);
		checkerOf(userContext).checkVersionOfListAccess( listAccessVersion);
		

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

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ListAccessManagerException.class);


	}



	public ListAccess clone(HisUserContext userContext, String fromListAccessId) throws Exception{

		return listAccessDaoOf(userContext).clone(fromListAccessId, this.allTokens());
	}

	public ListAccess internalSaveListAccess(HisUserContext userContext, ListAccess listAccess) throws Exception
	{
		return internalSaveListAccess(userContext, listAccess, allTokens());

	}
	public ListAccess internalSaveListAccess(HisUserContext userContext, ListAccess listAccess, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingListAccess(userContext, listAccessId, listAccessVersion, property, newValueExpr, tokensExpr);


		synchronized(listAccess){
			//will be good when the listAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ListAccess.
			if (listAccess.isChanged()){
			
			}
			listAccess = saveListAccess(userContext, listAccess, options);
			return listAccess;

		}

	}

	public ListAccess updateListAccess(HisUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingListAccess(userContext, listAccessId, listAccessVersion, property, newValueExpr, tokensExpr);



		ListAccess listAccess = loadListAccess(userContext, listAccessId, allTokens());
		if(listAccess.getVersion() != listAccessVersion){
			String message = "The target version("+listAccess.getVersion()+") is not equals to version("+listAccessVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(listAccess){
			//will be good when the listAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ListAccess.
			
			listAccess.changeProperty(property, newValueExpr);
			listAccess = saveListAccess(userContext, listAccess, tokens().done());
			return present(userContext,listAccess, mergedAllTokens(tokensExpr));
			//return saveListAccess(userContext, listAccess, tokens().done());
		}

	}

	public ListAccess updateListAccessProperty(HisUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingListAccess(userContext, listAccessId, listAccessVersion, property, newValueExpr, tokensExpr);

		ListAccess listAccess = loadListAccess(userContext, listAccessId, allTokens());
		if(listAccess.getVersion() != listAccessVersion){
			String message = "The target version("+listAccess.getVersion()+") is not equals to version("+listAccessVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(listAccess){
			//will be good when the listAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ListAccess.

			listAccess.changeProperty(property, newValueExpr);
			
			listAccess = saveListAccess(userContext, listAccess, tokens().done());
			return present(userContext,listAccess, mergedAllTokens(tokensExpr));
			//return saveListAccess(userContext, listAccess, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ListAccessTokens tokens(){
		return ListAccessTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ListAccessTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ListAccessTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherApp(HisUserContext userContext, String listAccessId, String anotherAppId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfListAccess(listAccessId);
 		checkerOf(userContext).checkIdOfUserApp(anotherAppId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ListAccessManagerException.class);

 	}
 	public ListAccess transferToAnotherApp(HisUserContext userContext, String listAccessId, String anotherAppId) throws Exception
 	{
 		checkParamsForTransferingAnotherApp(userContext, listAccessId,anotherAppId);
 
		ListAccess listAccess = loadListAccess(userContext, listAccessId, allTokens());	
		synchronized(listAccess){
			//will be good when the listAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserApp app = loadUserApp(userContext, anotherAppId, emptyOptions());		
			listAccess.updateApp(app);		
			listAccess = saveListAccess(userContext, listAccess, emptyOptions());
			
			return present(userContext,listAccess, allTokens());
			
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
		SmartList<UserApp> candidateList = userAppDaoOf(userContext).requestCandidateUserAppForListAccess(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(HisUserContext userContext, String listAccessId, int listAccessVersion) throws Exception {
		//deleteInternal(userContext, listAccessId, listAccessVersion);
	}
	protected void deleteInternal(HisUserContext userContext,
			String listAccessId, int listAccessVersion) throws Exception{

		listAccessDaoOf(userContext).delete(listAccessId, listAccessVersion);
	}

	public ListAccess forgetByAll(HisUserContext userContext, String listAccessId, int listAccessVersion) throws Exception {
		return forgetByAllInternal(userContext, listAccessId, listAccessVersion);
	}
	protected ListAccess forgetByAllInternal(HisUserContext userContext,
			String listAccessId, int listAccessVersion) throws Exception{

		return listAccessDaoOf(userContext).disconnectFromAll(listAccessId, listAccessVersion);
	}




	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ListAccessManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return listAccessDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(HisUserContext userContext, ListAccess newCreated) throws Exception{
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
		//   ListAccess newListAccess = this.createListAccess(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newListAccess
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, ListAccess.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(HisUserContext userContext,SmartList<ListAccess> list) throws Exception {
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
		SmartList<ListAccess> list = listAccessDaoOf(userContext).findListAccessByApp(appId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(ListAccess.class);
		page.setContainerObject(UserApp.withId(appId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("访问列表列表");
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
 	public Object wxappview(HisUserContext userContext, String listAccessId) throws Exception{
	  SerializeScope vscope = HisViewScope.getInstance().getListAccessDetailScope().clone();
		ListAccess merchantObj = (ListAccess) this.view(userContext, listAccessId);
    String merchantObjId = listAccessId;
    String linkToUrl =	"listAccessManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "访问列表"+"详情";
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
				MapUtil.put("id", "3-internalName")
				    .put("fieldName", "internalName")
				    .put("label", "内部名称")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("internalName", merchantObj.getInternalName());

		propList.add(
				MapUtil.put("id", "4-readPermission")
				    .put("fieldName", "readPermission")
				    .put("label", "读权限")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("readPermission", merchantObj.getReadPermission());

		propList.add(
				MapUtil.put("id", "5-createPermission")
				    .put("fieldName", "createPermission")
				    .put("label", "创建权限")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("createPermission", merchantObj.getCreatePermission());

		propList.add(
				MapUtil.put("id", "6-deletePermission")
				    .put("fieldName", "deletePermission")
				    .put("label", "删除权限")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("deletePermission", merchantObj.getDeletePermission());

		propList.add(
				MapUtil.put("id", "7-updatePermission")
				    .put("fieldName", "updatePermission")
				    .put("label", "更新许可")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("updatePermission", merchantObj.getUpdatePermission());

		propList.add(
				MapUtil.put("id", "8-executionPermission")
				    .put("fieldName", "executionPermission")
				    .put("label", "执行权限")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("executionPermission", merchantObj.getExecutionPermission());

		propList.add(
				MapUtil.put("id", "9-app")
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


