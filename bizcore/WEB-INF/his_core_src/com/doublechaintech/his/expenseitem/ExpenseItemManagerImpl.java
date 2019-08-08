
package com.doublechaintech.his.expenseitem;

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

import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.expensetype.ExpenseType;

import com.doublechaintech.his.hospital.CandidateHospital;
import com.doublechaintech.his.expensetype.CandidateExpenseType;







public class ExpenseItemManagerImpl extends CustomHisCheckerManager implements ExpenseItemManager {
	
	private static final String SERVICE_TYPE = "ExpenseItem";
	
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
 
 		userContext.getChecker().checkIdOfExpenseItem(expenseItemId);
		userContext.getChecker().throwExceptionIfHasErrors( ExpenseItemManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ExpenseItem expenseItem = loadExpenseItem( userContext, expenseItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,expenseItem, tokens);
 	}
 	
 	
 	 public ExpenseItem searchExpenseItem(HisUserContext userContext, String expenseItemId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfExpenseItem(expenseItemId);
		userContext.getChecker().throwExceptionIfHasErrors( ExpenseItemManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ExpenseItem expenseItem = loadExpenseItem( userContext, expenseItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,expenseItem, tokens);
 	}
 	
 	

 	protected ExpenseItem present(HisUserContext userContext, ExpenseItem expenseItem, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,expenseItem,tokens);
		
		
		ExpenseItem  expenseItemToPresent = userContext.getDAOGroup().getExpenseItemDAO().present(expenseItem, tokens);
		
		List<BaseEntity> entityListToNaming = expenseItemToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getExpenseItemDAO().alias(entityListToNaming);
		
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
 		return userContext.getDAOGroup().getExpenseItemDAO().save(expenseItem, tokens);
 	}
 	protected ExpenseItem loadExpenseItem(HisUserContext userContext, String expenseItemId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfExpenseItem(expenseItemId);
		userContext.getChecker().throwExceptionIfHasErrors( ExpenseItemManagerException.class);

 
 		return userContext.getDAOGroup().getExpenseItemDAO().load(expenseItemId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, ExpenseItem expenseItem, Map<String, Object> tokens){
		super.addActions(userContext, expenseItem, tokens);
		
		addAction(userContext, expenseItem, tokens,"@create","createExpenseItem","createExpenseItem/","main","primary");
		addAction(userContext, expenseItem, tokens,"@update","updateExpenseItem","updateExpenseItem/"+expenseItem.getId()+"/","main","primary");
		addAction(userContext, expenseItem, tokens,"@copy","cloneExpenseItem","cloneExpenseItem/"+expenseItem.getId()+"/","main","primary");
		
		addAction(userContext, expenseItem, tokens,"expense_item.transfer_to_expense_type","transferToAnotherExpenseType","transferToAnotherExpenseType/"+expenseItem.getId()+"/","main","primary");
		addAction(userContext, expenseItem, tokens,"expense_item.transfer_to_hospital","transferToAnotherHospital","transferToAnotherHospital/"+expenseItem.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, ExpenseItem expenseItem, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ExpenseItem createExpenseItem(HisUserContext userContext,String name, BigDecimal price, String expenseTypeId, String hospitalId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfExpenseItem(name);
		userContext.getChecker().checkPriceOfExpenseItem(price);
	
		userContext.getChecker().throwExceptionIfHasErrors(ExpenseItemManagerException.class);


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
		

		
		
		userContext.getChecker().checkIdOfExpenseItem(expenseItemId);
		userContext.getChecker().checkVersionOfExpenseItem( expenseItemVersion);
		

		if(ExpenseItem.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfExpenseItem(parseString(newValueExpr));
		}
		if(ExpenseItem.PRICE_PROPERTY.equals(property)){
			userContext.getChecker().checkPriceOfExpenseItem(parseBigDecimal(newValueExpr));
		}		

				

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ExpenseItemManagerException.class);
	
		
	}
	
	
	
	public ExpenseItem clone(HisUserContext userContext, String fromExpenseItemId) throws Exception{
		
		return userContext.getDAOGroup().getExpenseItemDAO().clone(fromExpenseItemId, this.allTokens());
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
 		
 		userContext.getChecker().checkIdOfExpenseItem(expenseItemId);
 		userContext.getChecker().checkIdOfExpenseType(anotherExpenseTypeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ExpenseItemManagerException.class);
 		
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
		SmartList<ExpenseType> candidateList = userContext.getDAOGroup().getExpenseTypeDAO().requestCandidateExpenseTypeForExpenseItem(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherHospital(HisUserContext userContext, String expenseItemId, String anotherHospitalId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfExpenseItem(expenseItemId);
 		userContext.getChecker().checkIdOfHospital(anotherHospitalId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ExpenseItemManagerException.class);
 		
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
		SmartList<Hospital> candidateList = userContext.getDAOGroup().getHospitalDAO().requestCandidateHospitalForExpenseItem(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Hospital loadHospital(HisUserContext userContext, String newHospitalId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getHospitalDAO().load(newHospitalId, options);
 	}
 	
 	
 	
	
	 	
 	protected ExpenseType loadExpenseType(HisUserContext userContext, String newExpenseTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getExpenseTypeDAO().load(newExpenseTypeId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String expenseItemId, int expenseItemVersion) throws Exception {
		//deleteInternal(userContext, expenseItemId, expenseItemVersion);		
	}
	protected void deleteInternal(HisUserContext userContext,
			String expenseItemId, int expenseItemVersion) throws Exception{
			
		userContext.getDAOGroup().getExpenseItemDAO().delete(expenseItemId, expenseItemVersion);
	}
	
	public ExpenseItem forgetByAll(HisUserContext userContext, String expenseItemId, int expenseItemVersion) throws Exception {
		return forgetByAllInternal(userContext, expenseItemId, expenseItemVersion);		
	}
	protected ExpenseItem forgetByAllInternal(HisUserContext userContext,
			String expenseItemId, int expenseItemVersion) throws Exception{
			
		return userContext.getDAOGroup().getExpenseItemDAO().disconnectFromAll(expenseItemId, expenseItemVersion);
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
		return userContext.getDAOGroup().getExpenseItemDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(HisUserContext userContext, ExpenseItem newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


