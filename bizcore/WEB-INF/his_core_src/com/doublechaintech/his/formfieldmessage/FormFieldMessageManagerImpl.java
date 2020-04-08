
package com.doublechaintech.his.formfieldmessage;

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







public class FormFieldMessageManagerImpl extends CustomHisCheckerManager implements FormFieldMessageManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "FormFieldMessage";
	@Override
	public FormFieldMessageDAO daoOf(HisUserContext userContext) {
		return formFieldMessageDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws FormFieldMessageManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new FormFieldMessageManagerException(message);

	}



 	protected FormFieldMessage saveFormFieldMessage(HisUserContext userContext, FormFieldMessage formFieldMessage, String [] tokensExpr) throws Exception{	
 		//return getFormFieldMessageDAO().save(formFieldMessage, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveFormFieldMessage(userContext, formFieldMessage, tokens);
 	}
 	
 	protected FormFieldMessage saveFormFieldMessageDetail(HisUserContext userContext, FormFieldMessage formFieldMessage) throws Exception{	

 		
 		return saveFormFieldMessage(userContext, formFieldMessage, allTokens());
 	}
 	
 	public FormFieldMessage loadFormFieldMessage(HisUserContext userContext, String formFieldMessageId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormFieldMessage(formFieldMessageId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormFieldMessageManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		FormFieldMessage formFieldMessage = loadFormFieldMessage( userContext, formFieldMessageId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formFieldMessage, tokens);
 	}
 	
 	
 	 public FormFieldMessage searchFormFieldMessage(HisUserContext userContext, String formFieldMessageId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormFieldMessage(formFieldMessageId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormFieldMessageManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		FormFieldMessage formFieldMessage = loadFormFieldMessage( userContext, formFieldMessageId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formFieldMessage, tokens);
 	}
 	
 	

 	protected FormFieldMessage present(HisUserContext userContext, FormFieldMessage formFieldMessage, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,formFieldMessage,tokens);
		
		
		FormFieldMessage  formFieldMessageToPresent = formFieldMessageDaoOf(userContext).present(formFieldMessage, tokens);
		
		List<BaseEntity> entityListToNaming = formFieldMessageToPresent.collectRefercencesFromLists();
		formFieldMessageDaoOf(userContext).alias(entityListToNaming);
		
		return  formFieldMessageToPresent;
		
		
	}
 
 	
 	
 	public FormFieldMessage loadFormFieldMessageDetail(HisUserContext userContext, String formFieldMessageId) throws Exception{	
 		FormFieldMessage formFieldMessage = loadFormFieldMessage( userContext, formFieldMessageId, allTokens());
 		return present(userContext,formFieldMessage, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String formFieldMessageId) throws Exception{	
 		FormFieldMessage formFieldMessage = loadFormFieldMessage( userContext, formFieldMessageId, viewTokens());
 		return present(userContext,formFieldMessage, allTokens());
		
 	}
 	protected FormFieldMessage saveFormFieldMessage(HisUserContext userContext, FormFieldMessage formFieldMessage, Map<String,Object>tokens) throws Exception{	
 		return formFieldMessageDaoOf(userContext).save(formFieldMessage, tokens);
 	}
 	protected FormFieldMessage loadFormFieldMessage(HisUserContext userContext, String formFieldMessageId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfFormFieldMessage(formFieldMessageId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormFieldMessageManagerException.class);

 
 		return formFieldMessageDaoOf(userContext).load(formFieldMessageId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, FormFieldMessage formFieldMessage, Map<String, Object> tokens){
		super.addActions(userContext, formFieldMessage, tokens);
		
		addAction(userContext, formFieldMessage, tokens,"@create","createFormFieldMessage","createFormFieldMessage/","main","primary");
		addAction(userContext, formFieldMessage, tokens,"@update","updateFormFieldMessage","updateFormFieldMessage/"+formFieldMessage.getId()+"/","main","primary");
		addAction(userContext, formFieldMessage, tokens,"@copy","cloneFormFieldMessage","cloneFormFieldMessage/"+formFieldMessage.getId()+"/","main","primary");
		
		addAction(userContext, formFieldMessage, tokens,"form_field_message.transfer_to_form","transferToAnotherForm","transferToAnotherForm/"+formFieldMessage.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, FormFieldMessage formFieldMessage, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public FormFieldMessage createFormFieldMessage(HisUserContext userContext, String title,String parameterName,String formId,String level) throws Exception
	//public FormFieldMessage createFormFieldMessage(HisUserContext userContext,String title, String parameterName, String formId, String level) throws Exception
	{

		

		

		checkerOf(userContext).checkTitleOfFormFieldMessage(title);
		checkerOf(userContext).checkParameterNameOfFormFieldMessage(parameterName);
		checkerOf(userContext).checkLevelOfFormFieldMessage(level);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormFieldMessageManagerException.class);


		FormFieldMessage formFieldMessage=createNewFormFieldMessage();	

		formFieldMessage.setTitle(title);
		formFieldMessage.setParameterName(parameterName);
			
		GenericForm form = loadGenericForm(userContext, formId,emptyOptions());
		formFieldMessage.setForm(form);
		
		
		formFieldMessage.setLevel(level);

		formFieldMessage = saveFormFieldMessage(userContext, formFieldMessage, emptyOptions());
		
		onNewInstanceCreated(userContext, formFieldMessage);
		return formFieldMessage;


	}
	protected FormFieldMessage createNewFormFieldMessage()
	{

		return new FormFieldMessage();
	}

	protected void checkParamsForUpdatingFormFieldMessage(HisUserContext userContext,String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfFormFieldMessage(formFieldMessageId);
		checkerOf(userContext).checkVersionOfFormFieldMessage( formFieldMessageVersion);
		

		if(FormFieldMessage.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfFormFieldMessage(parseString(newValueExpr));
		
			
		}
		if(FormFieldMessage.PARAMETER_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkParameterNameOfFormFieldMessage(parseString(newValueExpr));
		
			
		}		

		
		if(FormFieldMessage.LEVEL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLevelOfFormFieldMessage(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormFieldMessageManagerException.class);


	}



	public FormFieldMessage clone(HisUserContext userContext, String fromFormFieldMessageId) throws Exception{

		return formFieldMessageDaoOf(userContext).clone(fromFormFieldMessageId, this.allTokens());
	}

	public FormFieldMessage internalSaveFormFieldMessage(HisUserContext userContext, FormFieldMessage formFieldMessage) throws Exception
	{
		return internalSaveFormFieldMessage(userContext, formFieldMessage, allTokens());

	}
	public FormFieldMessage internalSaveFormFieldMessage(HisUserContext userContext, FormFieldMessage formFieldMessage, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingFormFieldMessage(userContext, formFieldMessageId, formFieldMessageVersion, property, newValueExpr, tokensExpr);


		synchronized(formFieldMessage){
			//will be good when the formFieldMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormFieldMessage.
			if (formFieldMessage.isChanged()){
			
			}
			formFieldMessage = saveFormFieldMessage(userContext, formFieldMessage, options);
			return formFieldMessage;

		}

	}

	public FormFieldMessage updateFormFieldMessage(HisUserContext userContext,String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFormFieldMessage(userContext, formFieldMessageId, formFieldMessageVersion, property, newValueExpr, tokensExpr);



		FormFieldMessage formFieldMessage = loadFormFieldMessage(userContext, formFieldMessageId, allTokens());
		if(formFieldMessage.getVersion() != formFieldMessageVersion){
			String message = "The target version("+formFieldMessage.getVersion()+") is not equals to version("+formFieldMessageVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formFieldMessage){
			//will be good when the formFieldMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormFieldMessage.
			
			formFieldMessage.changeProperty(property, newValueExpr);
			formFieldMessage = saveFormFieldMessage(userContext, formFieldMessage, tokens().done());
			return present(userContext,formFieldMessage, mergedAllTokens(tokensExpr));
			//return saveFormFieldMessage(userContext, formFieldMessage, tokens().done());
		}

	}

	public FormFieldMessage updateFormFieldMessageProperty(HisUserContext userContext,String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFormFieldMessage(userContext, formFieldMessageId, formFieldMessageVersion, property, newValueExpr, tokensExpr);

		FormFieldMessage formFieldMessage = loadFormFieldMessage(userContext, formFieldMessageId, allTokens());
		if(formFieldMessage.getVersion() != formFieldMessageVersion){
			String message = "The target version("+formFieldMessage.getVersion()+") is not equals to version("+formFieldMessageVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formFieldMessage){
			//will be good when the formFieldMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormFieldMessage.

			formFieldMessage.changeProperty(property, newValueExpr);
			
			formFieldMessage = saveFormFieldMessage(userContext, formFieldMessage, tokens().done());
			return present(userContext,formFieldMessage, mergedAllTokens(tokensExpr));
			//return saveFormFieldMessage(userContext, formFieldMessage, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected FormFieldMessageTokens tokens(){
		return FormFieldMessageTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return FormFieldMessageTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return FormFieldMessageTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherForm(HisUserContext userContext, String formFieldMessageId, String anotherFormId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfFormFieldMessage(formFieldMessageId);
 		checkerOf(userContext).checkIdOfGenericForm(anotherFormId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(FormFieldMessageManagerException.class);

 	}
 	public FormFieldMessage transferToAnotherForm(HisUserContext userContext, String formFieldMessageId, String anotherFormId) throws Exception
 	{
 		checkParamsForTransferingAnotherForm(userContext, formFieldMessageId,anotherFormId);
 
		FormFieldMessage formFieldMessage = loadFormFieldMessage(userContext, formFieldMessageId, allTokens());	
		synchronized(formFieldMessage){
			//will be good when the formFieldMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GenericForm form = loadGenericForm(userContext, anotherFormId, emptyOptions());		
			formFieldMessage.updateForm(form);		
			formFieldMessage = saveFormFieldMessage(userContext, formFieldMessage, emptyOptions());
			
			return present(userContext,formFieldMessage, allTokens());
			
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
		SmartList<GenericForm> candidateList = genericFormDaoOf(userContext).requestCandidateGenericFormForFormFieldMessage(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(HisUserContext userContext, String formFieldMessageId, int formFieldMessageVersion) throws Exception {
		//deleteInternal(userContext, formFieldMessageId, formFieldMessageVersion);
	}
	protected void deleteInternal(HisUserContext userContext,
			String formFieldMessageId, int formFieldMessageVersion) throws Exception{

		formFieldMessageDaoOf(userContext).delete(formFieldMessageId, formFieldMessageVersion);
	}

	public FormFieldMessage forgetByAll(HisUserContext userContext, String formFieldMessageId, int formFieldMessageVersion) throws Exception {
		return forgetByAllInternal(userContext, formFieldMessageId, formFieldMessageVersion);
	}
	protected FormFieldMessage forgetByAllInternal(HisUserContext userContext,
			String formFieldMessageId, int formFieldMessageVersion) throws Exception{

		return formFieldMessageDaoOf(userContext).disconnectFromAll(formFieldMessageId, formFieldMessageVersion);
	}




	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new FormFieldMessageManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return formFieldMessageDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(HisUserContext userContext, FormFieldMessage newCreated) throws Exception{
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
		//   FormFieldMessage newFormFieldMessage = this.createFormFieldMessage(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newFormFieldMessage
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, FormFieldMessage.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(HisUserContext userContext,SmartList<FormFieldMessage> list) throws Exception {
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
		SmartList<FormFieldMessage> list = formFieldMessageDaoOf(userContext).findFormFieldMessageByForm(formId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(FormFieldMessage.class);
		page.setContainerObject(GenericForm.withId(formId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("表单字段的信息列表");
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
 	public Object wxappview(HisUserContext userContext, String formFieldMessageId) throws Exception{
	  SerializeScope vscope = HisViewScope.getInstance().getFormFieldMessageDetailScope().clone();
		FormFieldMessage merchantObj = (FormFieldMessage) this.view(userContext, formFieldMessageId);
    String merchantObjId = formFieldMessageId;
    String linkToUrl =	"formFieldMessageManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "表单字段的信息"+"详情";
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
				MapUtil.put("id", "3-parameterName")
				    .put("fieldName", "parameterName")
				    .put("label", "参数名称")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("parameterName", merchantObj.getParameterName());

		propList.add(
				MapUtil.put("id", "4-form")
				    .put("fieldName", "form")
				    .put("label", "形式")
				    .put("type", "object")
				    .put("displayField", "title")
				    .put("linkToUrl", "genericFormManager/wxappview/:id/")
				    .into_map()
		);
		result.put("form", merchantObj.getForm());

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


