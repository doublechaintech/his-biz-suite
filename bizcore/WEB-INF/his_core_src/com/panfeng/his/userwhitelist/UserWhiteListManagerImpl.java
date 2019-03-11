
package com.panfeng.his.userwhitelist;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.panfeng.his.BaseEntity;


import com.panfeng.his.Message;
import com.panfeng.his.SmartList;
import com.panfeng.his.MultipleAccessKey;

import com.panfeng.his.HisUserContext;
//import com.panfeng.his.BaseManagerImpl;
import com.panfeng.his.HisCheckerManager;
import com.panfeng.his.CustomHisCheckerManager;

import com.panfeng.his.userdomain.UserDomain;

import com.panfeng.his.userdomain.CandidateUserDomain;







public class UserWhiteListManagerImpl extends CustomHisCheckerManager implements UserWhiteListManager {
	
	private static final String SERVICE_TYPE = "UserWhiteList";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws UserWhiteListManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new UserWhiteListManagerException(message);

	}
	
	

 	protected UserWhiteList saveUserWhiteList(HisUserContext userContext, UserWhiteList userWhiteList, String [] tokensExpr) throws Exception{	
 		//return getUserWhiteListDAO().save(userWhiteList, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveUserWhiteList(userContext, userWhiteList, tokens);
 	}
 	
 	protected UserWhiteList saveUserWhiteListDetail(HisUserContext userContext, UserWhiteList userWhiteList) throws Exception{	

 		
 		return saveUserWhiteList(userContext, userWhiteList, allTokens());
 	}
 	
 	public UserWhiteList loadUserWhiteList(HisUserContext userContext, String userWhiteListId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfUserWhiteList(userWhiteListId);
		userContext.getChecker().throwExceptionIfHasErrors( UserWhiteListManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		UserWhiteList userWhiteList = loadUserWhiteList( userContext, userWhiteListId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userWhiteList, tokens);
 	}
 	
 	
 	 public UserWhiteList searchUserWhiteList(HisUserContext userContext, String userWhiteListId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfUserWhiteList(userWhiteListId);
		userContext.getChecker().throwExceptionIfHasErrors( UserWhiteListManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		UserWhiteList userWhiteList = loadUserWhiteList( userContext, userWhiteListId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userWhiteList, tokens);
 	}
 	
 	

 	protected UserWhiteList present(HisUserContext userContext, UserWhiteList userWhiteList, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,userWhiteList,tokens);
		
		
		UserWhiteList  userWhiteListToPresent = userContext.getDAOGroup().getUserWhiteListDAO().present(userWhiteList, tokens);
		
		List<BaseEntity> entityListToNaming = userWhiteListToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getUserWhiteListDAO().alias(entityListToNaming);
		
		return  userWhiteListToPresent;
		
		
	}
 
 	
 	
 	public UserWhiteList loadUserWhiteListDetail(HisUserContext userContext, String userWhiteListId) throws Exception{	
 		UserWhiteList userWhiteList = loadUserWhiteList( userContext, userWhiteListId, allTokens());
 		return present(userContext,userWhiteList, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String userWhiteListId) throws Exception{	
 		UserWhiteList userWhiteList = loadUserWhiteList( userContext, userWhiteListId, viewTokens());
 		return present(userContext,userWhiteList, allTokens());
		
 	}
 	protected UserWhiteList saveUserWhiteList(HisUserContext userContext, UserWhiteList userWhiteList, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getUserWhiteListDAO().save(userWhiteList, tokens);
 	}
 	protected UserWhiteList loadUserWhiteList(HisUserContext userContext, String userWhiteListId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfUserWhiteList(userWhiteListId);
		userContext.getChecker().throwExceptionIfHasErrors( UserWhiteListManagerException.class);

 
 		return userContext.getDAOGroup().getUserWhiteListDAO().load(userWhiteListId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, UserWhiteList userWhiteList, Map<String, Object> tokens){
		super.addActions(userContext, userWhiteList, tokens);
		
		addAction(userContext, userWhiteList, tokens,"@create","createUserWhiteList","createUserWhiteList/","main","primary");
		addAction(userContext, userWhiteList, tokens,"@update","updateUserWhiteList","updateUserWhiteList/"+userWhiteList.getId()+"/","main","primary");
		addAction(userContext, userWhiteList, tokens,"@copy","cloneUserWhiteList","cloneUserWhiteList/"+userWhiteList.getId()+"/","main","primary");
		
		addAction(userContext, userWhiteList, tokens,"user_white_list.transfer_to_domain","transferToAnotherDomain","transferToAnotherDomain/"+userWhiteList.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, UserWhiteList userWhiteList, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public UserWhiteList createUserWhiteList(HisUserContext userContext,String userIdentity, String userSpecialFunctions, String domainId) throws Exception
	{
		
		

		

		userContext.getChecker().checkUserIdentityOfUserWhiteList(userIdentity);
		userContext.getChecker().checkUserSpecialFunctionsOfUserWhiteList(userSpecialFunctions);
	
		userContext.getChecker().throwExceptionIfHasErrors(UserWhiteListManagerException.class);


		UserWhiteList userWhiteList=createNewUserWhiteList();	

		userWhiteList.setUserIdentity(userIdentity);
		userWhiteList.setUserSpecialFunctions(userSpecialFunctions);
			
		UserDomain domain = loadUserDomain(userContext, domainId,emptyOptions());
		userWhiteList.setDomain(domain);
		
		

		userWhiteList = saveUserWhiteList(userContext, userWhiteList, emptyOptions());
		
		onNewInstanceCreated(userContext, userWhiteList);
		return userWhiteList;

		
	}
	protected UserWhiteList createNewUserWhiteList() 
	{
		
		return new UserWhiteList();		
	}
	
	protected void checkParamsForUpdatingUserWhiteList(HisUserContext userContext,String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfUserWhiteList(userWhiteListId);
		userContext.getChecker().checkVersionOfUserWhiteList( userWhiteListVersion);
		

		if(UserWhiteList.USER_IDENTITY_PROPERTY.equals(property)){
			userContext.getChecker().checkUserIdentityOfUserWhiteList(parseString(newValueExpr));
		}
		if(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY.equals(property)){
			userContext.getChecker().checkUserSpecialFunctionsOfUserWhiteList(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(UserWhiteListManagerException.class);
	
		
	}
	
	
	
	public UserWhiteList clone(HisUserContext userContext, String fromUserWhiteListId) throws Exception{
		
		return userContext.getDAOGroup().getUserWhiteListDAO().clone(fromUserWhiteListId, this.allTokens());
	}
	
	public UserWhiteList internalSaveUserWhiteList(HisUserContext userContext, UserWhiteList userWhiteList) throws Exception 
	{
		return internalSaveUserWhiteList(userContext, userWhiteList, allTokens());

	}
	public UserWhiteList internalSaveUserWhiteList(HisUserContext userContext, UserWhiteList userWhiteList, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingUserWhiteList(userContext, userWhiteListId, userWhiteListVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(userWhiteList){ 
			//will be good when the userWhiteList loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserWhiteList.
			
			
			userWhiteList = saveUserWhiteList(userContext, userWhiteList, options);
			return userWhiteList;
			
		}

	}
	
	public UserWhiteList updateUserWhiteList(HisUserContext userContext,String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingUserWhiteList(userContext, userWhiteListId, userWhiteListVersion, property, newValueExpr, tokensExpr);
		
		
		
		UserWhiteList userWhiteList = loadUserWhiteList(userContext, userWhiteListId, allTokens());
		if(userWhiteList.getVersion() != userWhiteListVersion){
			String message = "The target version("+userWhiteList.getVersion()+") is not equals to version("+userWhiteListVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userWhiteList){ 
			//will be good when the userWhiteList loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserWhiteList.
			
			userWhiteList.changeProperty(property, newValueExpr);
			userWhiteList = saveUserWhiteList(userContext, userWhiteList, tokens().done());
			return present(userContext,userWhiteList, mergedAllTokens(tokensExpr));
			//return saveUserWhiteList(userContext, userWhiteList, tokens().done());
		}

	}
	
	public UserWhiteList updateUserWhiteListProperty(HisUserContext userContext,String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingUserWhiteList(userContext, userWhiteListId, userWhiteListVersion, property, newValueExpr, tokensExpr);
		
		UserWhiteList userWhiteList = loadUserWhiteList(userContext, userWhiteListId, allTokens());
		if(userWhiteList.getVersion() != userWhiteListVersion){
			String message = "The target version("+userWhiteList.getVersion()+") is not equals to version("+userWhiteListVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userWhiteList){ 
			//will be good when the userWhiteList loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserWhiteList.
			
			userWhiteList.changeProperty(property, newValueExpr);
			
			userWhiteList = saveUserWhiteList(userContext, userWhiteList, tokens().done());
			return present(userContext,userWhiteList, mergedAllTokens(tokensExpr));
			//return saveUserWhiteList(userContext, userWhiteList, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected UserWhiteListTokens tokens(){
		return UserWhiteListTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return UserWhiteListTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return UserWhiteListTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherDomain(HisUserContext userContext, String userWhiteListId, String anotherDomainId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfUserWhiteList(userWhiteListId);
 		userContext.getChecker().checkIdOfUserDomain(anotherDomainId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(UserWhiteListManagerException.class);
 		
 	}
 	public UserWhiteList transferToAnotherDomain(HisUserContext userContext, String userWhiteListId, String anotherDomainId) throws Exception
 	{
 		checkParamsForTransferingAnotherDomain(userContext, userWhiteListId,anotherDomainId);
 
		UserWhiteList userWhiteList = loadUserWhiteList(userContext, userWhiteListId, allTokens());	
		synchronized(userWhiteList){
			//will be good when the userWhiteList loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserDomain domain = loadUserDomain(userContext, anotherDomainId, emptyOptions());		
			userWhiteList.updateDomain(domain);		
			userWhiteList = saveUserWhiteList(userContext, userWhiteList, emptyOptions());
			
			return present(userContext,userWhiteList, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateUserDomain requestCandidateDomain(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateUserDomain result = new CandidateUserDomain();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<UserDomain> candidateList = userContext.getDAOGroup().getUserDomainDAO().requestCandidateUserDomainForUserWhiteList(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected UserDomain loadUserDomain(HisUserContext userContext, String newDomainId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getUserDomainDAO().load(newDomainId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String userWhiteListId, int userWhiteListVersion) throws Exception {
		//deleteInternal(userContext, userWhiteListId, userWhiteListVersion);		
	}
	protected void deleteInternal(HisUserContext userContext,
			String userWhiteListId, int userWhiteListVersion) throws Exception{
			
		userContext.getDAOGroup().getUserWhiteListDAO().delete(userWhiteListId, userWhiteListVersion);
	}
	
	public UserWhiteList forgetByAll(HisUserContext userContext, String userWhiteListId, int userWhiteListVersion) throws Exception {
		return forgetByAllInternal(userContext, userWhiteListId, userWhiteListVersion);		
	}
	protected UserWhiteList forgetByAllInternal(HisUserContext userContext,
			String userWhiteListId, int userWhiteListVersion) throws Exception{
			
		return userContext.getDAOGroup().getUserWhiteListDAO().disconnectFromAll(userWhiteListId, userWhiteListVersion);
	}
	

	
	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new UserWhiteListManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getUserWhiteListDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(HisUserContext userContext, UserWhiteList newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


