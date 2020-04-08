
package com.doublechaintech.his.formaction;

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


import com.doublechaintech.his.genericform.GenericForm;

import com.doublechaintech.his.genericform.CandidateGenericForm;







public class FormActionManagerImpl extends CustomHisCheckerManager implements FormActionManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "FormAction";
	@Override
	public FormActionDAO daoOf(HisUserContext userContext) {
		return formActionDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws FormActionManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new FormActionManagerException(message);

	}



 	protected FormAction saveFormAction(HisUserContext userContext, FormAction formAction, String [] tokensExpr) throws Exception{	
 		//return getFormActionDAO().save(formAction, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveFormAction(userContext, formAction, tokens);
 	}
 	
 	protected FormAction saveFormActionDetail(HisUserContext userContext, FormAction formAction) throws Exception{	

 		
 		return saveFormAction(userContext, formAction, allTokens());
 	}
 	
 	public FormAction loadFormAction(HisUserContext userContext, String formActionId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormAction(formActionId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormActionManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		FormAction formAction = loadFormAction( userContext, formActionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formAction, tokens);
 	}
 	
 	
 	 public FormAction searchFormAction(HisUserContext userContext, String formActionId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormAction(formActionId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormActionManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		FormAction formAction = loadFormAction( userContext, formActionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formAction, tokens);
 	}
 	
 	

 	protected FormAction present(HisUserContext userContext, FormAction formAction, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,formAction,tokens);
		
		
		FormAction  formActionToPresent = formActionDaoOf(userContext).present(formAction, tokens);
		
		List<BaseEntity> entityListToNaming = formActionToPresent.collectRefercencesFromLists();
		formActionDaoOf(userContext).alias(entityListToNaming);
		
		return  formActionToPresent;
		
		
	}
 
 	
 	
 	public FormAction loadFormActionDetail(HisUserContext userContext, String formActionId) throws Exception{	
 		FormAction formAction = loadFormAction( userContext, formActionId, allTokens());
 		return present(userContext,formAction, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String formActionId) throws Exception{	
 		FormAction formAction = loadFormAction( userContext, formActionId, viewTokens());
 		return present(userContext,formAction, allTokens());
		
 	}
 	protected FormAction saveFormAction(HisUserContext userContext, FormAction formAction, Map<String,Object>tokens) throws Exception{	
 		return formActionDaoOf(userContext).save(formAction, tokens);
 	}
 	protected FormAction loadFormAction(HisUserContext userContext, String formActionId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfFormAction(formActionId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormActionManagerException.class);

 
 		return formActionDaoOf(userContext).load(formActionId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, FormAction formAction, Map<String, Object> tokens){
		super.addActions(userContext, formAction, tokens);
		
		addAction(userContext, formAction, tokens,"@create","createFormAction","createFormAction/","main","primary");
		addAction(userContext, formAction, tokens,"@update","updateFormAction","updateFormAction/"+formAction.getId()+"/","main","primary");
		addAction(userContext, formAction, tokens,"@copy","cloneFormAction","cloneFormAction/"+formAction.getId()+"/","main","primary");
		
		addAction(userContext, formAction, tokens,"form_action.transfer_to_form","transferToAnotherForm","transferToAnotherForm/"+formAction.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, FormAction formAction, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public FormAction createFormAction(HisUserContext userContext, String label,String localeKey,String actionKey,String level,String url,String formId) throws Exception
	//public FormAction createFormAction(HisUserContext userContext,String label, String localeKey, String actionKey, String level, String url, String formId) throws Exception
	{

		

		

		checkerOf(userContext).checkLabelOfFormAction(label);
		checkerOf(userContext).checkLocaleKeyOfFormAction(localeKey);
		checkerOf(userContext).checkActionKeyOfFormAction(actionKey);
		checkerOf(userContext).checkLevelOfFormAction(level);
		checkerOf(userContext).checkUrlOfFormAction(url);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormActionManagerException.class);


		FormAction formAction=createNewFormAction();	

		formAction.setLabel(label);
		formAction.setLocaleKey(localeKey);
		formAction.setActionKey(actionKey);
		formAction.setLevel(level);
		formAction.setUrl(url);
			
		GenericForm form = loadGenericForm(userContext, formId,emptyOptions());
		formAction.setForm(form);
		
		

		formAction = saveFormAction(userContext, formAction, emptyOptions());
		
		onNewInstanceCreated(userContext, formAction);
		return formAction;


	}
	protected FormAction createNewFormAction()
	{

		return new FormAction();
	}

	protected void checkParamsForUpdatingFormAction(HisUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfFormAction(formActionId);
		checkerOf(userContext).checkVersionOfFormAction( formActionVersion);
		

		if(FormAction.LABEL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLabelOfFormAction(parseString(newValueExpr));
		
			
		}
		if(FormAction.LOCALE_KEY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLocaleKeyOfFormAction(parseString(newValueExpr));
		
			
		}
		if(FormAction.ACTION_KEY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkActionKeyOfFormAction(parseString(newValueExpr));
		
			
		}
		if(FormAction.LEVEL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLevelOfFormAction(parseString(newValueExpr));
		
			
		}
		if(FormAction.URL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkUrlOfFormAction(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormActionManagerException.class);


	}



	public FormAction clone(HisUserContext userContext, String fromFormActionId) throws Exception{

		return formActionDaoOf(userContext).clone(fromFormActionId, this.allTokens());
	}

	public FormAction internalSaveFormAction(HisUserContext userContext, FormAction formAction) throws Exception
	{
		return internalSaveFormAction(userContext, formAction, allTokens());

	}
	public FormAction internalSaveFormAction(HisUserContext userContext, FormAction formAction, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingFormAction(userContext, formActionId, formActionVersion, property, newValueExpr, tokensExpr);


		synchronized(formAction){
			//will be good when the formAction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormAction.
			if (formAction.isChanged()){
			
			}
			formAction = saveFormAction(userContext, formAction, options);
			return formAction;

		}

	}

	public FormAction updateFormAction(HisUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFormAction(userContext, formActionId, formActionVersion, property, newValueExpr, tokensExpr);



		FormAction formAction = loadFormAction(userContext, formActionId, allTokens());
		if(formAction.getVersion() != formActionVersion){
			String message = "The target version("+formAction.getVersion()+") is not equals to version("+formActionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formAction){
			//will be good when the formAction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormAction.
			
			formAction.changeProperty(property, newValueExpr);
			formAction = saveFormAction(userContext, formAction, tokens().done());
			return present(userContext,formAction, mergedAllTokens(tokensExpr));
			//return saveFormAction(userContext, formAction, tokens().done());
		}

	}

	public FormAction updateFormActionProperty(HisUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFormAction(userContext, formActionId, formActionVersion, property, newValueExpr, tokensExpr);

		FormAction formAction = loadFormAction(userContext, formActionId, allTokens());
		if(formAction.getVersion() != formActionVersion){
			String message = "The target version("+formAction.getVersion()+") is not equals to version("+formActionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formAction){
			//will be good when the formAction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormAction.

			formAction.changeProperty(property, newValueExpr);
			
			formAction = saveFormAction(userContext, formAction, tokens().done());
			return present(userContext,formAction, mergedAllTokens(tokensExpr));
			//return saveFormAction(userContext, formAction, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected FormActionTokens tokens(){
		return FormActionTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return FormActionTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return FormActionTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherForm(HisUserContext userContext, String formActionId, String anotherFormId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfFormAction(formActionId);
 		checkerOf(userContext).checkIdOfGenericForm(anotherFormId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(FormActionManagerException.class);

 	}
 	public FormAction transferToAnotherForm(HisUserContext userContext, String formActionId, String anotherFormId) throws Exception
 	{
 		checkParamsForTransferingAnotherForm(userContext, formActionId,anotherFormId);
 
		FormAction formAction = loadFormAction(userContext, formActionId, allTokens());	
		synchronized(formAction){
			//will be good when the formAction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GenericForm form = loadGenericForm(userContext, anotherFormId, emptyOptions());		
			formAction.updateForm(form);		
			formAction = saveFormAction(userContext, formAction, emptyOptions());
			
			return present(userContext,formAction, allTokens());
			
		}

 	}

	


	public CandidateGenericForm requestCandidateForm(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateGenericForm result = new CandidateGenericForm();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<GenericForm> candidateList = genericFormDaoOf(userContext).requestCandidateGenericFormForFormAction(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected GenericForm loadGenericForm(HisUserContext userContext, String newFormId, Map<String,Object> options) throws Exception
 	{

 		return genericFormDaoOf(userContext).load(newFormId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String formActionId, int formActionVersion) throws Exception {
		//deleteInternal(userContext, formActionId, formActionVersion);
	}
	protected void deleteInternal(HisUserContext userContext,
			String formActionId, int formActionVersion) throws Exception{

		formActionDaoOf(userContext).delete(formActionId, formActionVersion);
	}

	public FormAction forgetByAll(HisUserContext userContext, String formActionId, int formActionVersion) throws Exception {
		return forgetByAllInternal(userContext, formActionId, formActionVersion);
	}
	protected FormAction forgetByAllInternal(HisUserContext userContext,
			String formActionId, int formActionVersion) throws Exception{

		return formActionDaoOf(userContext).disconnectFromAll(formActionId, formActionVersion);
	}




	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new FormActionManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return formActionDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(HisUserContext userContext, FormAction newCreated) throws Exception{
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
		//   FormAction newFormAction = this.createFormAction(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newFormAction
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, FormAction.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(HisUserContext userContext,SmartList<FormAction> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<GenericForm> formList = HisBaseUtils.collectReferencedObjectWithType(userContext, list, GenericForm.class);
		userContext.getDAOGroup().enhanceList(formList, GenericForm.class);


    }
	
	public Object listByForm(HisUserContext userContext,String formId) throws Exception {
		return listPageByForm(userContext, formId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByForm(HisUserContext userContext,String formId, int start, int count) throws Exception {
		SmartList<FormAction> list = formActionDaoOf(userContext).findFormActionByForm(formId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(FormAction.class);
		page.setContainerObject(GenericForm.withId(formId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("表单动作列表");
		page.setRequestName("listByForm");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByForm/%s/",  getBeanName(), formId)));

		page.assemblerContent(userContext, "listByForm");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(HisUserContext userContext, String formActionId) throws Exception{
	  SerializeScope vscope = HisViewScope.getInstance().getFormActionDetailScope().clone();
		FormAction merchantObj = (FormAction) this.view(userContext, formActionId);
    String merchantObjId = formActionId;
    String linkToUrl =	"formActionManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "表单动作"+"详情";
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
				MapUtil.put("id", "2-label")
				    .put("fieldName", "label")
				    .put("label", "标签")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("label", merchantObj.getLabel());

		propList.add(
				MapUtil.put("id", "3-localeKey")
				    .put("fieldName", "localeKey")
				    .put("label", "语言环境的关键")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("localeKey", merchantObj.getLocaleKey());

		propList.add(
				MapUtil.put("id", "4-actionKey")
				    .put("fieldName", "actionKey")
				    .put("label", "行动的关键")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("actionKey", merchantObj.getActionKey());

		propList.add(
				MapUtil.put("id", "5-level")
				    .put("fieldName", "level")
				    .put("label", "水平")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("level", merchantObj.getLevel());

		propList.add(
				MapUtil.put("id", "6-url")
				    .put("fieldName", "url")
				    .put("label", "url")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("url", merchantObj.getUrl());

		propList.add(
				MapUtil.put("id", "7-form")
				    .put("fieldName", "form")
				    .put("label", "形式")
				    .put("type", "object")
				    .put("displayField", "title")
				    .put("linkToUrl", "genericFormManager/wxappview/:id/")
				    .into_map()
		);
		result.put("form", merchantObj.getForm());

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


