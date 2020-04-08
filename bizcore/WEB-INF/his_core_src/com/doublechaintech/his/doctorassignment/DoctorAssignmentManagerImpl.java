
package com.doublechaintech.his.doctorassignment;

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


import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;

import com.doublechaintech.his.doctor.CandidateDoctor;
import com.doublechaintech.his.department.CandidateDepartment;







public class DoctorAssignmentManagerImpl extends CustomHisCheckerManager implements DoctorAssignmentManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "DoctorAssignment";
	@Override
	public DoctorAssignmentDAO daoOf(HisUserContext userContext) {
		return doctorAssignmentDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws DoctorAssignmentManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new DoctorAssignmentManagerException(message);

	}



 	protected DoctorAssignment saveDoctorAssignment(HisUserContext userContext, DoctorAssignment doctorAssignment, String [] tokensExpr) throws Exception{	
 		//return getDoctorAssignmentDAO().save(doctorAssignment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveDoctorAssignment(userContext, doctorAssignment, tokens);
 	}
 	
 	protected DoctorAssignment saveDoctorAssignmentDetail(HisUserContext userContext, DoctorAssignment doctorAssignment) throws Exception{	

 		
 		return saveDoctorAssignment(userContext, doctorAssignment, allTokens());
 	}
 	
 	public DoctorAssignment loadDoctorAssignment(HisUserContext userContext, String doctorAssignmentId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfDoctorAssignment(doctorAssignmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( DoctorAssignmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		DoctorAssignment doctorAssignment = loadDoctorAssignment( userContext, doctorAssignmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,doctorAssignment, tokens);
 	}
 	
 	
 	 public DoctorAssignment searchDoctorAssignment(HisUserContext userContext, String doctorAssignmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfDoctorAssignment(doctorAssignmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( DoctorAssignmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		DoctorAssignment doctorAssignment = loadDoctorAssignment( userContext, doctorAssignmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,doctorAssignment, tokens);
 	}
 	
 	

 	protected DoctorAssignment present(HisUserContext userContext, DoctorAssignment doctorAssignment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,doctorAssignment,tokens);
		
		
		DoctorAssignment  doctorAssignmentToPresent = doctorAssignmentDaoOf(userContext).present(doctorAssignment, tokens);
		
		List<BaseEntity> entityListToNaming = doctorAssignmentToPresent.collectRefercencesFromLists();
		doctorAssignmentDaoOf(userContext).alias(entityListToNaming);
		
		return  doctorAssignmentToPresent;
		
		
	}
 
 	
 	
 	public DoctorAssignment loadDoctorAssignmentDetail(HisUserContext userContext, String doctorAssignmentId) throws Exception{	
 		DoctorAssignment doctorAssignment = loadDoctorAssignment( userContext, doctorAssignmentId, allTokens());
 		return present(userContext,doctorAssignment, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String doctorAssignmentId) throws Exception{	
 		DoctorAssignment doctorAssignment = loadDoctorAssignment( userContext, doctorAssignmentId, viewTokens());
 		return present(userContext,doctorAssignment, allTokens());
		
 	}
 	protected DoctorAssignment saveDoctorAssignment(HisUserContext userContext, DoctorAssignment doctorAssignment, Map<String,Object>tokens) throws Exception{	
 		return doctorAssignmentDaoOf(userContext).save(doctorAssignment, tokens);
 	}
 	protected DoctorAssignment loadDoctorAssignment(HisUserContext userContext, String doctorAssignmentId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfDoctorAssignment(doctorAssignmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( DoctorAssignmentManagerException.class);

 
 		return doctorAssignmentDaoOf(userContext).load(doctorAssignmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, DoctorAssignment doctorAssignment, Map<String, Object> tokens){
		super.addActions(userContext, doctorAssignment, tokens);
		
		addAction(userContext, doctorAssignment, tokens,"@create","createDoctorAssignment","createDoctorAssignment/","main","primary");
		addAction(userContext, doctorAssignment, tokens,"@update","updateDoctorAssignment","updateDoctorAssignment/"+doctorAssignment.getId()+"/","main","primary");
		addAction(userContext, doctorAssignment, tokens,"@copy","cloneDoctorAssignment","cloneDoctorAssignment/"+doctorAssignment.getId()+"/","main","primary");
		
		addAction(userContext, doctorAssignment, tokens,"doctor_assignment.transfer_to_doctor","transferToAnotherDoctor","transferToAnotherDoctor/"+doctorAssignment.getId()+"/","main","primary");
		addAction(userContext, doctorAssignment, tokens,"doctor_assignment.transfer_to_department","transferToAnotherDepartment","transferToAnotherDepartment/"+doctorAssignment.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, DoctorAssignment doctorAssignment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public DoctorAssignment createDoctorAssignment(HisUserContext userContext, String name,String doctorId,String departmentId) throws Exception
	//public DoctorAssignment createDoctorAssignment(HisUserContext userContext,String name, String doctorId, String departmentId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfDoctorAssignment(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(DoctorAssignmentManagerException.class);


		DoctorAssignment doctorAssignment=createNewDoctorAssignment();	

		doctorAssignment.setName(name);
			
		Doctor doctor = loadDoctor(userContext, doctorId,emptyOptions());
		doctorAssignment.setDoctor(doctor);
		
		
			
		Department department = loadDepartment(userContext, departmentId,emptyOptions());
		doctorAssignment.setDepartment(department);
		
		
		doctorAssignment.setUpdateTime(userContext.now());

		doctorAssignment = saveDoctorAssignment(userContext, doctorAssignment, emptyOptions());
		
		onNewInstanceCreated(userContext, doctorAssignment);
		return doctorAssignment;


	}
	protected DoctorAssignment createNewDoctorAssignment()
	{

		return new DoctorAssignment();
	}

	protected void checkParamsForUpdatingDoctorAssignment(HisUserContext userContext,String doctorAssignmentId, int doctorAssignmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfDoctorAssignment(doctorAssignmentId);
		checkerOf(userContext).checkVersionOfDoctorAssignment( doctorAssignmentVersion);
		

		if(DoctorAssignment.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfDoctorAssignment(parseString(newValueExpr));
		
			
		}		

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(DoctorAssignmentManagerException.class);


	}



	public DoctorAssignment clone(HisUserContext userContext, String fromDoctorAssignmentId) throws Exception{

		return doctorAssignmentDaoOf(userContext).clone(fromDoctorAssignmentId, this.allTokens());
	}

	public DoctorAssignment internalSaveDoctorAssignment(HisUserContext userContext, DoctorAssignment doctorAssignment) throws Exception
	{
		return internalSaveDoctorAssignment(userContext, doctorAssignment, allTokens());

	}
	public DoctorAssignment internalSaveDoctorAssignment(HisUserContext userContext, DoctorAssignment doctorAssignment, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingDoctorAssignment(userContext, doctorAssignmentId, doctorAssignmentVersion, property, newValueExpr, tokensExpr);


		synchronized(doctorAssignment){
			//will be good when the doctorAssignment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to DoctorAssignment.
			if (doctorAssignment.isChanged()){
			doctorAssignment.updateUpdateTime(userContext.now());
			}
			doctorAssignment = saveDoctorAssignment(userContext, doctorAssignment, options);
			return doctorAssignment;

		}

	}

	public DoctorAssignment updateDoctorAssignment(HisUserContext userContext,String doctorAssignmentId, int doctorAssignmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingDoctorAssignment(userContext, doctorAssignmentId, doctorAssignmentVersion, property, newValueExpr, tokensExpr);



		DoctorAssignment doctorAssignment = loadDoctorAssignment(userContext, doctorAssignmentId, allTokens());
		if(doctorAssignment.getVersion() != doctorAssignmentVersion){
			String message = "The target version("+doctorAssignment.getVersion()+") is not equals to version("+doctorAssignmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(doctorAssignment){
			//will be good when the doctorAssignment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to DoctorAssignment.
			doctorAssignment.updateUpdateTime(userContext.now());
			doctorAssignment.changeProperty(property, newValueExpr);
			doctorAssignment = saveDoctorAssignment(userContext, doctorAssignment, tokens().done());
			return present(userContext,doctorAssignment, mergedAllTokens(tokensExpr));
			//return saveDoctorAssignment(userContext, doctorAssignment, tokens().done());
		}

	}

	public DoctorAssignment updateDoctorAssignmentProperty(HisUserContext userContext,String doctorAssignmentId, int doctorAssignmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingDoctorAssignment(userContext, doctorAssignmentId, doctorAssignmentVersion, property, newValueExpr, tokensExpr);

		DoctorAssignment doctorAssignment = loadDoctorAssignment(userContext, doctorAssignmentId, allTokens());
		if(doctorAssignment.getVersion() != doctorAssignmentVersion){
			String message = "The target version("+doctorAssignment.getVersion()+") is not equals to version("+doctorAssignmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(doctorAssignment){
			//will be good when the doctorAssignment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to DoctorAssignment.

			doctorAssignment.changeProperty(property, newValueExpr);
			doctorAssignment.updateUpdateTime(userContext.now());
			doctorAssignment = saveDoctorAssignment(userContext, doctorAssignment, tokens().done());
			return present(userContext,doctorAssignment, mergedAllTokens(tokensExpr));
			//return saveDoctorAssignment(userContext, doctorAssignment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected DoctorAssignmentTokens tokens(){
		return DoctorAssignmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return DoctorAssignmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return DoctorAssignmentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherDoctor(HisUserContext userContext, String doctorAssignmentId, String anotherDoctorId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfDoctorAssignment(doctorAssignmentId);
 		checkerOf(userContext).checkIdOfDoctor(anotherDoctorId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(DoctorAssignmentManagerException.class);

 	}
 	public DoctorAssignment transferToAnotherDoctor(HisUserContext userContext, String doctorAssignmentId, String anotherDoctorId) throws Exception
 	{
 		checkParamsForTransferingAnotherDoctor(userContext, doctorAssignmentId,anotherDoctorId);
 
		DoctorAssignment doctorAssignment = loadDoctorAssignment(userContext, doctorAssignmentId, allTokens());	
		synchronized(doctorAssignment){
			//will be good when the doctorAssignment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Doctor doctor = loadDoctor(userContext, anotherDoctorId, emptyOptions());		
			doctorAssignment.updateDoctor(doctor);		
			doctorAssignment = saveDoctorAssignment(userContext, doctorAssignment, emptyOptions());
			
			return present(userContext,doctorAssignment, allTokens());
			
		}

 	}

	


	public CandidateDoctor requestCandidateDoctor(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateDoctor result = new CandidateDoctor();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Doctor> candidateList = doctorDaoOf(userContext).requestCandidateDoctorForDoctorAssignment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherDepartment(HisUserContext userContext, String doctorAssignmentId, String anotherDepartmentId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfDoctorAssignment(doctorAssignmentId);
 		checkerOf(userContext).checkIdOfDepartment(anotherDepartmentId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(DoctorAssignmentManagerException.class);

 	}
 	public DoctorAssignment transferToAnotherDepartment(HisUserContext userContext, String doctorAssignmentId, String anotherDepartmentId) throws Exception
 	{
 		checkParamsForTransferingAnotherDepartment(userContext, doctorAssignmentId,anotherDepartmentId);
 
		DoctorAssignment doctorAssignment = loadDoctorAssignment(userContext, doctorAssignmentId, allTokens());	
		synchronized(doctorAssignment){
			//will be good when the doctorAssignment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Department department = loadDepartment(userContext, anotherDepartmentId, emptyOptions());		
			doctorAssignment.updateDepartment(department);		
			doctorAssignment = saveDoctorAssignment(userContext, doctorAssignment, emptyOptions());
			
			return present(userContext,doctorAssignment, allTokens());
			
		}

 	}

	


	public CandidateDepartment requestCandidateDepartment(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateDepartment result = new CandidateDepartment();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Department> candidateList = departmentDaoOf(userContext).requestCandidateDepartmentForDoctorAssignment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Doctor loadDoctor(HisUserContext userContext, String newDoctorId, Map<String,Object> options) throws Exception
 	{

 		return doctorDaoOf(userContext).load(newDoctorId, options);
 	}
 	


	

 	protected Department loadDepartment(HisUserContext userContext, String newDepartmentId, Map<String,Object> options) throws Exception
 	{

 		return departmentDaoOf(userContext).load(newDepartmentId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String doctorAssignmentId, int doctorAssignmentVersion) throws Exception {
		//deleteInternal(userContext, doctorAssignmentId, doctorAssignmentVersion);
	}
	protected void deleteInternal(HisUserContext userContext,
			String doctorAssignmentId, int doctorAssignmentVersion) throws Exception{

		doctorAssignmentDaoOf(userContext).delete(doctorAssignmentId, doctorAssignmentVersion);
	}

	public DoctorAssignment forgetByAll(HisUserContext userContext, String doctorAssignmentId, int doctorAssignmentVersion) throws Exception {
		return forgetByAllInternal(userContext, doctorAssignmentId, doctorAssignmentVersion);
	}
	protected DoctorAssignment forgetByAllInternal(HisUserContext userContext,
			String doctorAssignmentId, int doctorAssignmentVersion) throws Exception{

		return doctorAssignmentDaoOf(userContext).disconnectFromAll(doctorAssignmentId, doctorAssignmentVersion);
	}




	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new DoctorAssignmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return doctorAssignmentDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(HisUserContext userContext, DoctorAssignment newCreated) throws Exception{
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
		//   DoctorAssignment newDoctorAssignment = this.createDoctorAssignment(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newDoctorAssignment
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, DoctorAssignment.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(HisUserContext userContext,SmartList<DoctorAssignment> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Doctor> doctorList = HisBaseUtils.collectReferencedObjectWithType(userContext, list, Doctor.class);
		userContext.getDAOGroup().enhanceList(doctorList, Doctor.class);
		List<Department> departmentList = HisBaseUtils.collectReferencedObjectWithType(userContext, list, Department.class);
		userContext.getDAOGroup().enhanceList(departmentList, Department.class);


    }
	
	public Object listByDoctor(HisUserContext userContext,String doctorId) throws Exception {
		return listPageByDoctor(userContext, doctorId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByDoctor(HisUserContext userContext,String doctorId, int start, int count) throws Exception {
		SmartList<DoctorAssignment> list = doctorAssignmentDaoOf(userContext).findDoctorAssignmentByDoctor(doctorId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(DoctorAssignment.class);
		page.setContainerObject(Doctor.withId(doctorId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("医生的任务列表");
		page.setRequestName("listByDoctor");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByDoctor/%s/",  getBeanName(), doctorId)));

		page.assemblerContent(userContext, "listByDoctor");
		return page.doRender(userContext);
	}
  
	public Object listByDepartment(HisUserContext userContext,String departmentId) throws Exception {
		return listPageByDepartment(userContext, departmentId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByDepartment(HisUserContext userContext,String departmentId, int start, int count) throws Exception {
		SmartList<DoctorAssignment> list = doctorAssignmentDaoOf(userContext).findDoctorAssignmentByDepartment(departmentId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(DoctorAssignment.class);
		page.setContainerObject(Department.withId(departmentId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("医生的任务列表");
		page.setRequestName("listByDepartment");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByDepartment/%s/",  getBeanName(), departmentId)));

		page.assemblerContent(userContext, "listByDepartment");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(HisUserContext userContext, String doctorAssignmentId) throws Exception{
	  SerializeScope vscope = HisViewScope.getInstance().getDoctorAssignmentDetailScope().clone();
		DoctorAssignment merchantObj = (DoctorAssignment) this.view(userContext, doctorAssignmentId);
    String merchantObjId = doctorAssignmentId;
    String linkToUrl =	"doctorAssignmentManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "医生的任务"+"详情";
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
				MapUtil.put("id", "3-doctor")
				    .put("fieldName", "doctor")
				    .put("label", "医生")
				    .put("type", "object")
				    .put("displayField", "name")
				    .put("linkToUrl", "doctorManager/wxappview/:id/")
				    .into_map()
		);
		result.put("doctor", merchantObj.getDoctor());

		propList.add(
				MapUtil.put("id", "4-department")
				    .put("fieldName", "department")
				    .put("label", "部门")
				    .put("type", "object")
				    .put("displayField", "name")
				    .put("linkToUrl", "departmentManager/wxappview/:id/")
				    .into_map()
		);
		result.put("department", merchantObj.getDepartment());

		propList.add(
				MapUtil.put("id", "5-updateTime")
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


