
package com.doublechaintech.his.expenseitem;

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


import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.expensetype.ExpenseType;

import com.doublechaintech.his.hospital.CandidateHospital;
import com.doublechaintech.his.expensetype.CandidateExpenseType;







public class ExpenseItemManagerImpl extends CustomHisCheckerManager implements ExpenseItemManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "ExpenseItem";
	@Override
	public ExpenseItemDAO daoOf(HisUserContext userContext) {
		return expenseItemDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ExpenseItemManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ExpenseItemManagerException(message);

	}



 	protected ExpenseItem saveExpenseItem(HisUserContext userContext, ExpenseItem expenseItem, String [] tokensExpr) throws Exception{	
 		//return getExpenseItemDAO().save(expenseItem, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveExpenseItem(userContext, expenseItem, tokens);
 	}
 	
 	protected ExpenseItem saveExpenseItemDetail(HisUserContext userContext, ExpenseItem expenseItem) throws Exception{	

 		
 		return saveExpenseItem(userContext, expenseItem, allTokens());
 	}
 	
 	public ExpenseItem loadExpenseItem(HisUserContext userContext, String expenseItemId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfExpenseItem(expenseItemId);
		checkerOf(userContext).throwExceptionIfHasErrors( ExpenseItemManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ExpenseItem expenseItem = loadExpenseItem( userContext, expenseItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,expenseItem, tokens);
 	}
 	
 	
 	 public ExpenseItem searchExpenseItem(HisUserContext userContext, String expenseItemId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfExpenseItem(expenseItemId);
		checkerOf(userContext).throwExceptionIfHasErrors( ExpenseItemManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ExpenseItem expenseItem = loadExpenseItem( userContext, expenseItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,expenseItem, tokens);
 	}
 	
 	

 	protected ExpenseItem present(HisUserContext userContext, ExpenseItem expenseItem, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,expenseItem,tokens);
		
		
		ExpenseItem  expenseItemToPresent = expenseItemDaoOf(userContext).present(expenseItem, tokens);
		
		List<BaseEntity> entityListToNaming = expenseItemToPresent.collectRefercencesFromLists();
		expenseItemDaoOf(userContext).alias(entityListToNaming);
		
		return  expenseItemToPresent;
		
		
	}
 
 	
 	
 	public ExpenseItem loadExpenseItemDetail(HisUserContext userContext, String expenseItemId) throws Exception{	
 		ExpenseItem expenseItem = loadExpenseItem( userContext, expenseItemId, allTokens());
 		return present(userContext,expenseItem, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String expenseItemId) throws Exception{	
 		ExpenseItem expenseItem = loadExpenseItem( userContext, expenseItemId, viewTokens());
 		return present(userContext,expenseItem, allTokens());
		
 	}
 	protected ExpenseItem saveExpenseItem(HisUserContext userContext, ExpenseItem expenseItem, Map<String,Object>tokens) throws Exception{	
 		return expenseItemDaoOf(userContext).save(expenseItem, tokens);
 	}
 	protected ExpenseItem loadExpenseItem(HisUserContext userContext, String expenseItemId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfExpenseItem(expenseItemId);
		checkerOf(userContext).throwExceptionIfHasErrors( ExpenseItemManagerException.class);

 
 		return expenseItemDaoOf(userContext).load(expenseItemId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, ExpenseItem expenseItem, Map<String, Object> tokens){
		super.addActions(userContext, expenseItem, tokens);
		
		addAction(userContext, expenseItem, tokens,"@create","createExpenseItem","createExpenseItem/","main","primary");
		addAction(userContext, expenseItem, tokens,"@update","updateExpenseItem","updateExpenseItem/"+expenseItem.getId()+"/","main","primary");
		addAction(userContext, expenseItem, tokens,"@copy","cloneExpenseItem","cloneExpenseItem/"+expenseItem.getId()+"/","main","primary");
		
		addAction(userContext, expenseItem, tokens,"expense_item.transfer_to_expense_type","transferToAnotherExpenseType","transferToAnotherExpenseType/"+expenseItem.getId()+"/","main","primary");
		addAction(userContext, expenseItem, tokens,"expense_item.transfer_to_hospital","transferToAnotherHospital","transferToAnotherHospital/"+expenseItem.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, ExpenseItem expenseItem, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ExpenseItem createExpenseItem(HisUserContext userContext, String name,BigDecimal price,String expenseTypeId,String hospitalId) throws Exception
	//public ExpenseItem createExpenseItem(HisUserContext userContext,String name, BigDecimal price, String expenseTypeId, String hospitalId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfExpenseItem(name);
		checkerOf(userContext).checkPriceOfExpenseItem(price);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseItemManagerException.class);


		ExpenseItem expenseItem=createNewExpenseItem();	

		expenseItem.setName(name);
		expenseItem.setPrice(price);
			
		ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId,emptyOptions());
		expenseItem.setExpenseType(expenseType);
		
		
			
		Hospital hospital = loadHospital(userContext, hospitalId,emptyOptions());
		expenseItem.setHospital(hospital);
		
		
		expenseItem.setUpdateTime(userContext.now());

		expenseItem = saveExpenseItem(userContext, expenseItem, emptyOptions());
		
		onNewInstanceCreated(userContext, expenseItem);
		return expenseItem;


	}
	protected ExpenseItem createNewExpenseItem()
	{

		return new ExpenseItem();
	}

	protected void checkParamsForUpdatingExpenseItem(HisUserContext userContext,String expenseItemId, int expenseItemVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfExpenseItem(expenseItemId);
		checkerOf(userContext).checkVersionOfExpenseItem( expenseItemVersion);
		

		if(ExpenseItem.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfExpenseItem(parseString(newValueExpr));
		
			
		}
		if(ExpenseItem.PRICE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPriceOfExpenseItem(parseBigDecimal(newValueExpr));
		
			
		}		

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseItemManagerException.class);


	}



	public ExpenseItem clone(HisUserContext userContext, String fromExpenseItemId) throws Exception{

		return expenseItemDaoOf(userContext).clone(fromExpenseItemId, this.allTokens());
	}

	public ExpenseItem internalSaveExpenseItem(HisUserContext userContext, ExpenseItem expenseItem) throws Exception
	{
		return internalSaveExpenseItem(userContext, expenseItem, allTokens());

	}
	public ExpenseItem internalSaveExpenseItem(HisUserContext userContext, ExpenseItem expenseItem, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingExpenseItem(userContext, expenseItemId, expenseItemVersion, property, newValueExpr, tokensExpr);


		synchronized(expenseItem){
			//will be good when the expenseItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ExpenseItem.
			if (expenseItem.isChanged()){
			expenseItem.updateUpdateTime(userContext.now());
			}
			expenseItem = saveExpenseItem(userContext, expenseItem, options);
			return expenseItem;

		}

	}

	public ExpenseItem updateExpenseItem(HisUserContext userContext,String expenseItemId, int expenseItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingExpenseItem(userContext, expenseItemId, expenseItemVersion, property, newValueExpr, tokensExpr);



		ExpenseItem expenseItem = loadExpenseItem(userContext, expenseItemId, allTokens());
		if(expenseItem.getVersion() != expenseItemVersion){
			String message = "The target version("+expenseItem.getVersion()+") is not equals to version("+expenseItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(expenseItem){
			//will be good when the expenseItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ExpenseItem.
			expenseItem.updateUpdateTime(userContext.now());
			expenseItem.changeProperty(property, newValueExpr);
			expenseItem = saveExpenseItem(userContext, expenseItem, tokens().done());
			return present(userContext,expenseItem, mergedAllTokens(tokensExpr));
			//return saveExpenseItem(userContext, expenseItem, tokens().done());
		}

	}

	public ExpenseItem updateExpenseItemProperty(HisUserContext userContext,String expenseItemId, int expenseItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingExpenseItem(userContext, expenseItemId, expenseItemVersion, property, newValueExpr, tokensExpr);

		ExpenseItem expenseItem = loadExpenseItem(userContext, expenseItemId, allTokens());
		if(expenseItem.getVersion() != expenseItemVersion){
			String message = "The target version("+expenseItem.getVersion()+") is not equals to version("+expenseItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(expenseItem){
			//will be good when the expenseItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ExpenseItem.

			expenseItem.changeProperty(property, newValueExpr);
			expenseItem.updateUpdateTime(userContext.now());
			expenseItem = saveExpenseItem(userContext, expenseItem, tokens().done());
			return present(userContext,expenseItem, mergedAllTokens(tokensExpr));
			//return saveExpenseItem(userContext, expenseItem, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ExpenseItemTokens tokens(){
		return ExpenseItemTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ExpenseItemTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ExpenseItemTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherExpenseType(HisUserContext userContext, String expenseItemId, String anotherExpenseTypeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfExpenseItem(expenseItemId);
 		checkerOf(userContext).checkIdOfExpenseType(anotherExpenseTypeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseItemManagerException.class);

 	}
 	public ExpenseItem transferToAnotherExpenseType(HisUserContext userContext, String expenseItemId, String anotherExpenseTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherExpenseType(userContext, expenseItemId,anotherExpenseTypeId);
 
		ExpenseItem expenseItem = loadExpenseItem(userContext, expenseItemId, allTokens());	
		synchronized(expenseItem){
			//will be good when the expenseItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ExpenseType expenseType = loadExpenseType(userContext, anotherExpenseTypeId, emptyOptions());		
			expenseItem.updateExpenseType(expenseType);		
			expenseItem = saveExpenseItem(userContext, expenseItem, emptyOptions());
			
			return present(userContext,expenseItem, allTokens());
			
		}

 	}

	


	public CandidateExpenseType requestCandidateExpenseType(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateExpenseType result = new CandidateExpenseType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ExpenseType> candidateList = expenseTypeDaoOf(userContext).requestCandidateExpenseTypeForExpenseItem(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherHospital(HisUserContext userContext, String expenseItemId, String anotherHospitalId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfExpenseItem(expenseItemId);
 		checkerOf(userContext).checkIdOfHospital(anotherHospitalId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseItemManagerException.class);

 	}
 	public ExpenseItem transferToAnotherHospital(HisUserContext userContext, String expenseItemId, String anotherHospitalId) throws Exception
 	{
 		checkParamsForTransferingAnotherHospital(userContext, expenseItemId,anotherHospitalId);
 
		ExpenseItem expenseItem = loadExpenseItem(userContext, expenseItemId, allTokens());	
		synchronized(expenseItem){
			//will be good when the expenseItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Hospital hospital = loadHospital(userContext, anotherHospitalId, emptyOptions());		
			expenseItem.updateHospital(hospital);		
			expenseItem = saveExpenseItem(userContext, expenseItem, emptyOptions());
			
			return present(userContext,expenseItem, allTokens());
			
		}

 	}

	


	public CandidateHospital requestCandidateHospital(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateHospital result = new CandidateHospital();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Hospital> candidateList = hospitalDaoOf(userContext).requestCandidateHospitalForExpenseItem(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Hospital loadHospital(HisUserContext userContext, String newHospitalId, Map<String,Object> options) throws Exception
 	{

 		return hospitalDaoOf(userContext).load(newHospitalId, options);
 	}
 	


	

 	protected ExpenseType loadExpenseType(HisUserContext userContext, String newExpenseTypeId, Map<String,Object> options) throws Exception
 	{

 		return expenseTypeDaoOf(userContext).load(newExpenseTypeId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String expenseItemId, int expenseItemVersion) throws Exception {
		//deleteInternal(userContext, expenseItemId, expenseItemVersion);
	}
	protected void deleteInternal(HisUserContext userContext,
			String expenseItemId, int expenseItemVersion) throws Exception{

		expenseItemDaoOf(userContext).delete(expenseItemId, expenseItemVersion);
	}

	public ExpenseItem forgetByAll(HisUserContext userContext, String expenseItemId, int expenseItemVersion) throws Exception {
		return forgetByAllInternal(userContext, expenseItemId, expenseItemVersion);
	}
	protected ExpenseItem forgetByAllInternal(HisUserContext userContext,
			String expenseItemId, int expenseItemVersion) throws Exception{

		return expenseItemDaoOf(userContext).disconnectFromAll(expenseItemId, expenseItemVersion);
	}




	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ExpenseItemManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return expenseItemDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(HisUserContext userContext, ExpenseItem newCreated) throws Exception{
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
		//   ExpenseItem newExpenseItem = this.createExpenseItem(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newExpenseItem
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, ExpenseItem.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(HisUserContext userContext,SmartList<ExpenseItem> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<ExpenseType> expenseTypeList = HisBaseUtils.collectReferencedObjectWithType(userContext, list, ExpenseType.class);
		userContext.getDAOGroup().enhanceList(expenseTypeList, ExpenseType.class);
		List<Hospital> hospitalList = HisBaseUtils.collectReferencedObjectWithType(userContext, list, Hospital.class);
		userContext.getDAOGroup().enhanceList(hospitalList, Hospital.class);


    }
	
	public Object listByExpenseType(HisUserContext userContext,String expenseTypeId) throws Exception {
		return listPageByExpenseType(userContext, expenseTypeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByExpenseType(HisUserContext userContext,String expenseTypeId, int start, int count) throws Exception {
		SmartList<ExpenseItem> list = expenseItemDaoOf(userContext).findExpenseItemByExpenseType(expenseTypeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(ExpenseItem.class);
		page.setContainerObject(ExpenseType.withId(expenseTypeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("费用项目列表");
		page.setRequestName("listByExpenseType");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByExpenseType/%s/",  getBeanName(), expenseTypeId)));

		page.assemblerContent(userContext, "listByExpenseType");
		return page.doRender(userContext);
	}
  
	public Object listByHospital(HisUserContext userContext,String hospitalId) throws Exception {
		return listPageByHospital(userContext, hospitalId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByHospital(HisUserContext userContext,String hospitalId, int start, int count) throws Exception {
		SmartList<ExpenseItem> list = expenseItemDaoOf(userContext).findExpenseItemByHospital(hospitalId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(ExpenseItem.class);
		page.setContainerObject(Hospital.withId(hospitalId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("费用项目列表");
		page.setRequestName("listByHospital");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByHospital/%s/",  getBeanName(), hospitalId)));

		page.assemblerContent(userContext, "listByHospital");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(HisUserContext userContext, String expenseItemId) throws Exception{
	  SerializeScope vscope = HisViewScope.getInstance().getExpenseItemDetailScope().clone();
		ExpenseItem merchantObj = (ExpenseItem) this.view(userContext, expenseItemId);
    String merchantObjId = expenseItemId;
    String linkToUrl =	"expenseItemManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "费用项目"+"详情";
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
				MapUtil.put("id", "3-price")
				    .put("fieldName", "price")
				    .put("label", "价格")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("price", merchantObj.getPrice());

		propList.add(
				MapUtil.put("id", "4-expenseType")
				    .put("fieldName", "expenseType")
				    .put("label", "费用类型")
				    .put("type", "object")
				    .put("displayField", "name")
				    .put("linkToUrl", "expenseTypeManager/wxappview/:id/")
				    .into_map()
		);
		result.put("expenseType", merchantObj.getExpenseType());

		propList.add(
				MapUtil.put("id", "5-hospital")
				    .put("fieldName", "hospital")
				    .put("label", "医院")
				    .put("type", "object")
				    .put("displayField", "name")
				    .put("linkToUrl", "hospitalManager/wxappview/:id/")
				    .into_map()
		);
		result.put("hospital", merchantObj.getHospital());

		propList.add(
				MapUtil.put("id", "6-updateTime")
				    .put("fieldName", "updateTime")
				    .put("label", "更新时间")
				    .put("type", "date")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("updateTime", merchantObj.getUpdateTime());

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


