
package com.doublechaintech.his.quicklink;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.his.BaseEntity;


import com.doublechaintech.his.Message;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.MultipleAccessKey;

import com.doublechaintech.his.HisUserContext;
//import com.doublechaintech.his.BaseManagerImpl;
import com.doublechaintech.his.HisCheckerManager;
import com.doublechaintech.his.CustomHisCheckerManager;

import com.doublechaintech.his.userapp.UserApp;

import com.doublechaintech.his.userapp.CandidateUserApp;







public class QuickLinkManagerImpl extends CustomHisCheckerManager implements QuickLinkManager {
	
	private static final String SERVICE_TYPE = "QuickLink";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws QuickLinkManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new QuickLinkManagerException(message);

	}
	
	

 	protected QuickLink saveQuickLink(HisUserContext userContext, QuickLink quickLink, String [] tokensExpr) throws Exception{	
 		//return getQuickLinkDAO().save(quickLink, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveQuickLink(userContext, quickLink, tokens);
 	}
 	
 	protected QuickLink saveQuickLinkDetail(HisUserContext userContext, QuickLink quickLink) throws Exception{	

 		
 		return saveQuickLink(userContext, quickLink, allTokens());
 	}
 	
 	public QuickLink loadQuickLink(HisUserContext userContext, String quickLinkId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfQuickLink(quickLinkId);
		userContext.getChecker().throwExceptionIfHasErrors( QuickLinkManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,quickLink, tokens);
 	}
 	
 	
 	 public QuickLink searchQuickLink(HisUserContext userContext, String quickLinkId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfQuickLink(quickLinkId);
		userContext.getChecker().throwExceptionIfHasErrors( QuickLinkManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,quickLink, tokens);
 	}
 	
 	

 	protected QuickLink present(HisUserContext userContext, QuickLink quickLink, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,quickLink,tokens);
		
		
		QuickLink  quickLinkToPresent = userContext.getDAOGroup().getQuickLinkDAO().present(quickLink, tokens);
		
		List<BaseEntity> entityListToNaming = quickLinkToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getQuickLinkDAO().alias(entityListToNaming);
		
		return  quickLinkToPresent;
		
		
	}
 
 	
 	
 	public QuickLink loadQuickLinkDetail(HisUserContext userContext, String quickLinkId) throws Exception{	
 		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, allTokens());
 		return present(userContext,quickLink, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String quickLinkId) throws Exception{	
 		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, viewTokens());
 		return present(userContext,quickLink, allTokens());
		
 	}
 	protected QuickLink saveQuickLink(HisUserContext userContext, QuickLink quickLink, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getQuickLinkDAO().save(quickLink, tokens);
 	}
 	protected QuickLink loadQuickLink(HisUserContext userContext, String quickLinkId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfQuickLink(quickLinkId);
		userContext.getChecker().throwExceptionIfHasErrors( QuickLinkManagerException.class);

 
 		return userContext.getDAOGroup().getQuickLinkDAO().load(quickLinkId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, QuickLink quickLink, Map<String, Object> tokens){
		super.addActions(userContext, quickLink, tokens);
		
		addAction(userContext, quickLink, tokens,"@create","createQuickLink","createQuickLink/","main","primary");
		addAction(userContext, quickLink, tokens,"@update","updateQuickLink","updateQuickLink/"+quickLink.getId()+"/","main","primary");
		addAction(userContext, quickLink, tokens,"@copy","cloneQuickLink","cloneQuickLink/"+quickLink.getId()+"/","main","primary");
		
		addAction(userContext, quickLink, tokens,"quick_link.transfer_to_app","transferToAnotherApp","transferToAnotherApp/"+quickLink.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, QuickLink quickLink, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public QuickLink createQuickLink(HisUserContext userContext,String name, String icon, String imagePath, String linkTarget, String appId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfQuickLink(name);
		userContext.getChecker().checkIconOfQuickLink(icon);
		userContext.getChecker().checkImagePathOfQuickLink(imagePath);
		userContext.getChecker().checkLinkTargetOfQuickLink(linkTarget);
	
		userContext.getChecker().throwExceptionIfHasErrors(QuickLinkManagerException.class);


		QuickLink quickLink=createNewQuickLink();	

		quickLink.setName(name);
		quickLink.setIcon(icon);
		quickLink.setImagePath(imagePath);
		quickLink.setLinkTarget(linkTarget);
		quickLink.setCreateTime(userContext.now());
			
		UserApp app = loadUserApp(userContext, appId,emptyOptions());
		quickLink.setApp(app);
		
		

		quickLink = saveQuickLink(userContext, quickLink, emptyOptions());
		
		onNewInstanceCreated(userContext, quickLink);
		return quickLink;

		
	}
	protected QuickLink createNewQuickLink() 
	{
		
		return new QuickLink();		
	}
	
	protected void checkParamsForUpdatingQuickLink(HisUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfQuickLink(quickLinkId);
		userContext.getChecker().checkVersionOfQuickLink( quickLinkVersion);
		

		if(QuickLink.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfQuickLink(parseString(newValueExpr));
		}
		if(QuickLink.ICON_PROPERTY.equals(property)){
			userContext.getChecker().checkIconOfQuickLink(parseString(newValueExpr));
		}
		if(QuickLink.IMAGE_PATH_PROPERTY.equals(property)){
			userContext.getChecker().checkImagePathOfQuickLink(parseString(newValueExpr));
		}
		if(QuickLink.LINK_TARGET_PROPERTY.equals(property)){
			userContext.getChecker().checkLinkTargetOfQuickLink(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(QuickLinkManagerException.class);
	
		
	}
	
	
	
	public QuickLink clone(HisUserContext userContext, String fromQuickLinkId) throws Exception{
		
		return userContext.getDAOGroup().getQuickLinkDAO().clone(fromQuickLinkId, this.allTokens());
	}
	
	public QuickLink internalSaveQuickLink(HisUserContext userContext, QuickLink quickLink) throws Exception 
	{
		return internalSaveQuickLink(userContext, quickLink, allTokens());

	}
	public QuickLink internalSaveQuickLink(HisUserContext userContext, QuickLink quickLink, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingQuickLink(userContext, quickLinkId, quickLinkVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(quickLink){ 
			//will be good when the quickLink loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to QuickLink.
			if (quickLink.isChanged()){
			
			}
			quickLink = saveQuickLink(userContext, quickLink, options);
			return quickLink;
			
		}

	}
	
	public QuickLink updateQuickLink(HisUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingQuickLink(userContext, quickLinkId, quickLinkVersion, property, newValueExpr, tokensExpr);
		
		
		
		QuickLink quickLink = loadQuickLink(userContext, quickLinkId, allTokens());
		if(quickLink.getVersion() != quickLinkVersion){
			String message = "The target version("+quickLink.getVersion()+") is not equals to version("+quickLinkVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(quickLink){ 
			//will be good when the quickLink loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to QuickLink.
			
			quickLink.changeProperty(property, newValueExpr);
			quickLink = saveQuickLink(userContext, quickLink, tokens().done());
			return present(userContext,quickLink, mergedAllTokens(tokensExpr));
			//return saveQuickLink(userContext, quickLink, tokens().done());
		}

	}
	
	public QuickLink updateQuickLinkProperty(HisUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingQuickLink(userContext, quickLinkId, quickLinkVersion, property, newValueExpr, tokensExpr);
		
		QuickLink quickLink = loadQuickLink(userContext, quickLinkId, allTokens());
		if(quickLink.getVersion() != quickLinkVersion){
			String message = "The target version("+quickLink.getVersion()+") is not equals to version("+quickLinkVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(quickLink){ 
			//will be good when the quickLink loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to QuickLink.
			
			quickLink.changeProperty(property, newValueExpr);
			
			quickLink = saveQuickLink(userContext, quickLink, tokens().done());
			return present(userContext,quickLink, mergedAllTokens(tokensExpr));
			//return saveQuickLink(userContext, quickLink, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected QuickLinkTokens tokens(){
		return QuickLinkTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return QuickLinkTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return QuickLinkTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherApp(HisUserContext userContext, String quickLinkId, String anotherAppId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfQuickLink(quickLinkId);
 		userContext.getChecker().checkIdOfUserApp(anotherAppId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(QuickLinkManagerException.class);
 		
 	}
 	public QuickLink transferToAnotherApp(HisUserContext userContext, String quickLinkId, String anotherAppId) throws Exception
 	{
 		checkParamsForTransferingAnotherApp(userContext, quickLinkId,anotherAppId);
 
		QuickLink quickLink = loadQuickLink(userContext, quickLinkId, allTokens());	
		synchronized(quickLink){
			//will be good when the quickLink loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserApp app = loadUserApp(userContext, anotherAppId, emptyOptions());		
			quickLink.updateApp(app);		
			quickLink = saveQuickLink(userContext, quickLink, emptyOptions());
			
			return present(userContext,quickLink, allTokens());
			
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
		SmartList<UserApp> candidateList = userContext.getDAOGroup().getUserAppDAO().requestCandidateUserAppForQuickLink(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected UserApp loadUserApp(HisUserContext userContext, String newAppId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getUserAppDAO().load(newAppId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String quickLinkId, int quickLinkVersion) throws Exception {
		//deleteInternal(userContext, quickLinkId, quickLinkVersion);		
	}
	protected void deleteInternal(HisUserContext userContext,
			String quickLinkId, int quickLinkVersion) throws Exception{
			
		userContext.getDAOGroup().getQuickLinkDAO().delete(quickLinkId, quickLinkVersion);
	}
	
	public QuickLink forgetByAll(HisUserContext userContext, String quickLinkId, int quickLinkVersion) throws Exception {
		return forgetByAllInternal(userContext, quickLinkId, quickLinkVersion);		
	}
	protected QuickLink forgetByAllInternal(HisUserContext userContext,
			String quickLinkId, int quickLinkVersion) throws Exception{
			
		return userContext.getDAOGroup().getQuickLinkDAO().disconnectFromAll(quickLinkId, quickLinkVersion);
	}
	

	
	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new QuickLinkManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getQuickLinkDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(HisUserContext userContext, QuickLink newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


