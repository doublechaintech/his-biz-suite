
package com.doublechaintech.his.expensetype;

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
import com.doublechaintech.his.doctorschedule.DoctorSchedule;
import com.doublechaintech.his.expenseitem.ExpenseItem;

import com.doublechaintech.his.hospital.CandidateHospital;

import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;






public class ExpenseTypeManagerImpl extends CustomHisCheckerManager implements ExpenseTypeManager {
	
	private static final String SERVICE_TYPE = "ExpenseType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ExpenseTypeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ExpenseTypeManagerException(message);

	}
	
	

 	protected ExpenseType saveExpenseType(HisUserContext userContext, ExpenseType expenseType, String [] tokensExpr) throws Exception{	
 		//return getExpenseTypeDAO().save(expenseType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveExpenseType(userContext, expenseType, tokens);
 	}
 	
 	protected ExpenseType saveExpenseTypeDetail(HisUserContext userContext, ExpenseType expenseType) throws Exception{	

 		
 		return saveExpenseType(userContext, expenseType, allTokens());
 	}
 	
 	public ExpenseType loadExpenseType(HisUserContext userContext, String expenseTypeId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfExpenseType(expenseTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( ExpenseTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ExpenseType expenseType = loadExpenseType( userContext, expenseTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,expenseType, tokens);
 	}
 	
 	
 	 public ExpenseType searchExpenseType(HisUserContext userContext, String expenseTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfExpenseType(expenseTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( ExpenseTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ExpenseType expenseType = loadExpenseType( userContext, expenseTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,expenseType, tokens);
 	}
 	
 	

 	protected ExpenseType present(HisUserContext userContext, ExpenseType expenseType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,expenseType,tokens);
		
		
		ExpenseType  expenseTypeToPresent = userContext.getDAOGroup().getExpenseTypeDAO().present(expenseType, tokens);
		
		List<BaseEntity> entityListToNaming = expenseTypeToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getExpenseTypeDAO().alias(entityListToNaming);
		
		return  expenseTypeToPresent;
		
		
	}
 
 	
 	
 	public ExpenseType loadExpenseTypeDetail(HisUserContext userContext, String expenseTypeId) throws Exception{	
 		ExpenseType expenseType = loadExpenseType( userContext, expenseTypeId, allTokens());
 		return present(userContext,expenseType, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String expenseTypeId) throws Exception{	
 		ExpenseType expenseType = loadExpenseType( userContext, expenseTypeId, viewTokens());
 		return present(userContext,expenseType, allTokens());
		
 	}
 	protected ExpenseType saveExpenseType(HisUserContext userContext, ExpenseType expenseType, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getExpenseTypeDAO().save(expenseType, tokens);
 	}
 	protected ExpenseType loadExpenseType(HisUserContext userContext, String expenseTypeId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfExpenseType(expenseTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( ExpenseTypeManagerException.class);

 
 		return userContext.getDAOGroup().getExpenseTypeDAO().load(expenseTypeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, ExpenseType expenseType, Map<String, Object> tokens){
		super.addActions(userContext, expenseType, tokens);
		
		addAction(userContext, expenseType, tokens,"@create","createExpenseType","createExpenseType/","main","primary");
		addAction(userContext, expenseType, tokens,"@update","updateExpenseType","updateExpenseType/"+expenseType.getId()+"/","main","primary");
		addAction(userContext, expenseType, tokens,"@copy","cloneExpenseType","cloneExpenseType/"+expenseType.getId()+"/","main","primary");
		
		addAction(userContext, expenseType, tokens,"expense_type.transfer_to_hospital","transferToAnotherHospital","transferToAnotherHospital/"+expenseType.getId()+"/","main","primary");
		addAction(userContext, expenseType, tokens,"expense_type.addExpenseItem","addExpenseItem","addExpenseItem/"+expenseType.getId()+"/","expenseItemList","primary");
		addAction(userContext, expenseType, tokens,"expense_type.removeExpenseItem","removeExpenseItem","removeExpenseItem/"+expenseType.getId()+"/","expenseItemList","primary");
		addAction(userContext, expenseType, tokens,"expense_type.updateExpenseItem","updateExpenseItem","updateExpenseItem/"+expenseType.getId()+"/","expenseItemList","primary");
		addAction(userContext, expenseType, tokens,"expense_type.copyExpenseItemFrom","copyExpenseItemFrom","copyExpenseItemFrom/"+expenseType.getId()+"/","expenseItemList","primary");
		addAction(userContext, expenseType, tokens,"expense_type.addDoctorSchedule","addDoctorSchedule","addDoctorSchedule/"+expenseType.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, expenseType, tokens,"expense_type.removeDoctorSchedule","removeDoctorSchedule","removeDoctorSchedule/"+expenseType.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, expenseType, tokens,"expense_type.updateDoctorSchedule","updateDoctorSchedule","updateDoctorSchedule/"+expenseType.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, expenseType, tokens,"expense_type.copyDoctorScheduleFrom","copyDoctorScheduleFrom","copyDoctorScheduleFrom/"+expenseType.getId()+"/","doctorScheduleList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, ExpenseType expenseType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ExpenseType createExpenseType(HisUserContext userContext,String name, String helperChars, String status, String hospitalId, String description) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfExpenseType(name);
		userContext.getChecker().checkHelperCharsOfExpenseType(helperChars);
		userContext.getChecker().checkStatusOfExpenseType(status);
		userContext.getChecker().checkDescriptionOfExpenseType(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(ExpenseTypeManagerException.class);


		ExpenseType expenseType=createNewExpenseType();	

		expenseType.setName(name);
		expenseType.setHelperChars(helperChars);
		expenseType.setStatus(status);
			
		Hospital hospital = loadHospital(userContext, hospitalId,emptyOptions());
		expenseType.setHospital(hospital);
		
		
		expenseType.setDescription(description);
		expenseType.setUpdateTime(userContext.now());

		expenseType = saveExpenseType(userContext, expenseType, emptyOptions());
		
		onNewInstanceCreated(userContext, expenseType);
		return expenseType;

		
	}
	protected ExpenseType createNewExpenseType() 
	{
		
		return new ExpenseType();		
	}
	
	protected void checkParamsForUpdatingExpenseType(HisUserContext userContext,String expenseTypeId, int expenseTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfExpenseType(expenseTypeId);
		userContext.getChecker().checkVersionOfExpenseType( expenseTypeVersion);
		

		if(ExpenseType.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfExpenseType(parseString(newValueExpr));
		}
		if(ExpenseType.HELPER_CHARS_PROPERTY.equals(property)){
			userContext.getChecker().checkHelperCharsOfExpenseType(parseString(newValueExpr));
		}
		if(ExpenseType.STATUS_PROPERTY.equals(property)){
			userContext.getChecker().checkStatusOfExpenseType(parseString(newValueExpr));
		}		

		
		if(ExpenseType.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfExpenseType(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ExpenseTypeManagerException.class);
	
		
	}
	
	
	
	public ExpenseType clone(HisUserContext userContext, String fromExpenseTypeId) throws Exception{
		
		return userContext.getDAOGroup().getExpenseTypeDAO().clone(fromExpenseTypeId, this.allTokens());
	}
	
	public ExpenseType internalSaveExpenseType(HisUserContext userContext, ExpenseType expenseType) throws Exception 
	{
		return internalSaveExpenseType(userContext, expenseType, allTokens());

	}
	public ExpenseType internalSaveExpenseType(HisUserContext userContext, ExpenseType expenseType, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingExpenseType(userContext, expenseTypeId, expenseTypeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(expenseType){ 
			//will be good when the expenseType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ExpenseType.
			if (expenseType.isChanged()){
			expenseType.updateUpdateTime(userContext.now());
			}
			expenseType = saveExpenseType(userContext, expenseType, options);
			return expenseType;
			
		}

	}
	
	public ExpenseType updateExpenseType(HisUserContext userContext,String expenseTypeId, int expenseTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingExpenseType(userContext, expenseTypeId, expenseTypeVersion, property, newValueExpr, tokensExpr);
		
		
		
		ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());
		if(expenseType.getVersion() != expenseTypeVersion){
			String message = "The target version("+expenseType.getVersion()+") is not equals to version("+expenseTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(expenseType){ 
			//will be good when the expenseType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ExpenseType.
			expenseType.updateUpdateTime(userContext.now());
			expenseType.changeProperty(property, newValueExpr);
			expenseType = saveExpenseType(userContext, expenseType, tokens().done());
			return present(userContext,expenseType, mergedAllTokens(tokensExpr));
			//return saveExpenseType(userContext, expenseType, tokens().done());
		}

	}
	
	public ExpenseType updateExpenseTypeProperty(HisUserContext userContext,String expenseTypeId, int expenseTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingExpenseType(userContext, expenseTypeId, expenseTypeVersion, property, newValueExpr, tokensExpr);
		
		ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());
		if(expenseType.getVersion() != expenseTypeVersion){
			String message = "The target version("+expenseType.getVersion()+") is not equals to version("+expenseTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(expenseType){ 
			//will be good when the expenseType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ExpenseType.
			
			expenseType.changeProperty(property, newValueExpr);
			expenseType.updateUpdateTime(userContext.now());
			expenseType = saveExpenseType(userContext, expenseType, tokens().done());
			return present(userContext,expenseType, mergedAllTokens(tokensExpr));
			//return saveExpenseType(userContext, expenseType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ExpenseTypeTokens tokens(){
		return ExpenseTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ExpenseTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortExpenseItemListWith("id","desc")
		.sortDoctorScheduleListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ExpenseTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherHospital(HisUserContext userContext, String expenseTypeId, String anotherHospitalId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfExpenseType(expenseTypeId);
 		userContext.getChecker().checkIdOfHospital(anotherHospitalId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ExpenseTypeManagerException.class);
 		
 	}
 	public ExpenseType transferToAnotherHospital(HisUserContext userContext, String expenseTypeId, String anotherHospitalId) throws Exception
 	{
 		checkParamsForTransferingAnotherHospital(userContext, expenseTypeId,anotherHospitalId);
 
		ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());	
		synchronized(expenseType){
			//will be good when the expenseType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Hospital hospital = loadHospital(userContext, anotherHospitalId, emptyOptions());		
			expenseType.updateHospital(hospital);		
			expenseType = saveExpenseType(userContext, expenseType, emptyOptions());
			
			return present(userContext,expenseType, allTokens());
			
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
		SmartList<Hospital> candidateList = userContext.getDAOGroup().getHospitalDAO().requestCandidateHospitalForExpenseType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String expenseTypeId, int expenseTypeVersion) throws Exception {
		//deleteInternal(userContext, expenseTypeId, expenseTypeVersion);		
	}
	protected void deleteInternal(HisUserContext userContext,
			String expenseTypeId, int expenseTypeVersion) throws Exception{
			
		userContext.getDAOGroup().getExpenseTypeDAO().delete(expenseTypeId, expenseTypeVersion);
	}
	
	public ExpenseType forgetByAll(HisUserContext userContext, String expenseTypeId, int expenseTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, expenseTypeId, expenseTypeVersion);		
	}
	protected ExpenseType forgetByAllInternal(HisUserContext userContext,
			String expenseTypeId, int expenseTypeVersion) throws Exception{
			
		return userContext.getDAOGroup().getExpenseTypeDAO().disconnectFromAll(expenseTypeId, expenseTypeVersion);
	}
	

	
	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ExpenseTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getExpenseTypeDAO().deleteAll();
	}


	//disconnect ExpenseType with hospital in ExpenseItem
	protected ExpenseType breakWithExpenseItemByHospital(HisUserContext userContext, String expenseTypeId, String hospitalId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());

			synchronized(expenseType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getExpenseTypeDAO().planToRemoveExpenseItemListWithHospital(expenseType, hospitalId, this.emptyOptions());

				expenseType = saveExpenseType(userContext, expenseType, tokens().withExpenseItemList().done());
				return expenseType;
			}
	}
	//disconnect ExpenseType with doctor in DoctorSchedule
	protected ExpenseType breakWithDoctorScheduleByDoctor(HisUserContext userContext, String expenseTypeId, String doctorId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());

			synchronized(expenseType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getExpenseTypeDAO().planToRemoveDoctorScheduleListWithDoctor(expenseType, doctorId, this.emptyOptions());

				expenseType = saveExpenseType(userContext, expenseType, tokens().withDoctorScheduleList().done());
				return expenseType;
			}
	}
	//disconnect ExpenseType with period in DoctorSchedule
	protected ExpenseType breakWithDoctorScheduleByPeriod(HisUserContext userContext, String expenseTypeId, String periodId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());

			synchronized(expenseType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getExpenseTypeDAO().planToRemoveDoctorScheduleListWithPeriod(expenseType, periodId, this.emptyOptions());

				expenseType = saveExpenseType(userContext, expenseType, tokens().withDoctorScheduleList().done());
				return expenseType;
			}
	}
	//disconnect ExpenseType with department in DoctorSchedule
	protected ExpenseType breakWithDoctorScheduleByDepartment(HisUserContext userContext, String expenseTypeId, String departmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());

			synchronized(expenseType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getExpenseTypeDAO().planToRemoveDoctorScheduleListWithDepartment(expenseType, departmentId, this.emptyOptions());

				expenseType = saveExpenseType(userContext, expenseType, tokens().withDoctorScheduleList().done());
				return expenseType;
			}
	}
	//disconnect ExpenseType with hospital in DoctorSchedule
	protected ExpenseType breakWithDoctorScheduleByHospital(HisUserContext userContext, String expenseTypeId, String hospitalId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());

			synchronized(expenseType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getExpenseTypeDAO().planToRemoveDoctorScheduleListWithHospital(expenseType, hospitalId, this.emptyOptions());

				expenseType = saveExpenseType(userContext, expenseType, tokens().withDoctorScheduleList().done());
				return expenseType;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingExpenseItem(HisUserContext userContext, String expenseTypeId, String name, BigDecimal price, String hospitalId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfExpenseType(expenseTypeId);

		
		userContext.getChecker().checkNameOfExpenseItem(name);
		
		userContext.getChecker().checkPriceOfExpenseItem(price);
		
		userContext.getChecker().checkHospitalIdOfExpenseItem(hospitalId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ExpenseTypeManagerException.class);

	
	}
	public  ExpenseType addExpenseItem(HisUserContext userContext, String expenseTypeId, String name, BigDecimal price, String hospitalId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingExpenseItem(userContext,expenseTypeId,name, price, hospitalId,tokensExpr);
		
		ExpenseItem expenseItem = createExpenseItem(userContext,name, price, hospitalId);
		
		ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());
		synchronized(expenseType){ 
			//Will be good when the expenseType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			expenseType.addExpenseItem( expenseItem );		
			expenseType = saveExpenseType(userContext, expenseType, tokens().withExpenseItemList().done());
			
			userContext.getManagerGroup().getExpenseItemManager().onNewInstanceCreated(userContext, expenseItem);
			return present(userContext,expenseType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingExpenseItemProperties(HisUserContext userContext, String expenseTypeId,String id,String name,BigDecimal price,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfExpenseType(expenseTypeId);
		userContext.getChecker().checkIdOfExpenseItem(id);
		
		userContext.getChecker().checkNameOfExpenseItem( name);
		userContext.getChecker().checkPriceOfExpenseItem( price);

		userContext.getChecker().throwExceptionIfHasErrors(ExpenseTypeManagerException.class);
		
	}
	public  ExpenseType updateExpenseItemProperties(HisUserContext userContext, String expenseTypeId, String id,String name,BigDecimal price, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingExpenseItemProperties(userContext,expenseTypeId,id,name,price,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withExpenseItemListList()
				.searchExpenseItemListWith(ExpenseItem.ID_PROPERTY, "is", id).done();
		
		ExpenseType expenseTypeToUpdate = loadExpenseType(userContext, expenseTypeId, options);
		
		if(expenseTypeToUpdate.getExpenseItemList().isEmpty()){
			throw new ExpenseTypeManagerException("ExpenseItem is NOT FOUND with id: '"+id+"'");
		}
		
		ExpenseItem item = expenseTypeToUpdate.getExpenseItemList().first();
		
		item.updateName( name );
		item.updatePrice( price );

		
		//checkParamsForAddingExpenseItem(userContext,expenseTypeId,name, code, used,tokensExpr);
		ExpenseType expenseType = saveExpenseType(userContext, expenseTypeToUpdate, tokens().withExpenseItemList().done());
		synchronized(expenseType){ 
			return present(userContext,expenseType, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ExpenseItem createExpenseItem(HisUserContext userContext, String name, BigDecimal price, String hospitalId) throws Exception{

		ExpenseItem expenseItem = new ExpenseItem();
		
		
		expenseItem.setName(name);		
		expenseItem.setPrice(price);		
		Hospital  hospital = new Hospital();
		hospital.setId(hospitalId);		
		expenseItem.setHospital(hospital);		
		expenseItem.setUpdateTime(userContext.now());
	
		
		return expenseItem;
	
		
	}
	
	protected ExpenseItem createIndexedExpenseItem(String id, int version){

		ExpenseItem expenseItem = new ExpenseItem();
		expenseItem.setId(id);
		expenseItem.setVersion(version);
		return expenseItem;			
		
	}
	
	protected void checkParamsForRemovingExpenseItemList(HisUserContext userContext, String expenseTypeId, 
			String expenseItemIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfExpenseType(expenseTypeId);
		for(String expenseItemIdItem: expenseItemIds){
			userContext.getChecker().checkIdOfExpenseItem(expenseItemIdItem);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ExpenseTypeManagerException.class);
		
	}
	public  ExpenseType removeExpenseItemList(HisUserContext userContext, String expenseTypeId, 
			String expenseItemIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingExpenseItemList(userContext, expenseTypeId,  expenseItemIds, tokensExpr);
			
			
			ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());
			synchronized(expenseType){ 
				//Will be good when the expenseType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getExpenseTypeDAO().planToRemoveExpenseItemList(expenseType, expenseItemIds, allTokens());
				expenseType = saveExpenseType(userContext, expenseType, tokens().withExpenseItemList().done());
				deleteRelationListInGraph(userContext, expenseType.getExpenseItemList());
				return present(userContext,expenseType, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingExpenseItem(HisUserContext userContext, String expenseTypeId, 
		String expenseItemId, int expenseItemVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfExpenseType( expenseTypeId);
		userContext.getChecker().checkIdOfExpenseItem(expenseItemId);
		userContext.getChecker().checkVersionOfExpenseItem(expenseItemVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ExpenseTypeManagerException.class);
	
	}
	public  ExpenseType removeExpenseItem(HisUserContext userContext, String expenseTypeId, 
		String expenseItemId, int expenseItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingExpenseItem(userContext,expenseTypeId, expenseItemId, expenseItemVersion,tokensExpr);
		
		ExpenseItem expenseItem = createIndexedExpenseItem(expenseItemId, expenseItemVersion);
		ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());
		synchronized(expenseType){ 
			//Will be good when the expenseType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			expenseType.removeExpenseItem( expenseItem );		
			expenseType = saveExpenseType(userContext, expenseType, tokens().withExpenseItemList().done());
			deleteRelationInGraph(userContext, expenseItem);
			return present(userContext,expenseType, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingExpenseItem(HisUserContext userContext, String expenseTypeId, 
		String expenseItemId, int expenseItemVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfExpenseType( expenseTypeId);
		userContext.getChecker().checkIdOfExpenseItem(expenseItemId);
		userContext.getChecker().checkVersionOfExpenseItem(expenseItemVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ExpenseTypeManagerException.class);
	
	}
	public  ExpenseType copyExpenseItemFrom(HisUserContext userContext, String expenseTypeId, 
		String expenseItemId, int expenseItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingExpenseItem(userContext,expenseTypeId, expenseItemId, expenseItemVersion,tokensExpr);
		
		ExpenseItem expenseItem = createIndexedExpenseItem(expenseItemId, expenseItemVersion);
		ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());
		synchronized(expenseType){ 
			//Will be good when the expenseType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			expenseItem.updateUpdateTime(userContext.now());
			
			expenseType.copyExpenseItemFrom( expenseItem );		
			expenseType = saveExpenseType(userContext, expenseType, tokens().withExpenseItemList().done());
			
			userContext.getManagerGroup().getExpenseItemManager().onNewInstanceCreated(userContext, (ExpenseItem)expenseType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,expenseType, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingExpenseItem(HisUserContext userContext, String expenseTypeId, String expenseItemId, int expenseItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfExpenseType(expenseTypeId);
		userContext.getChecker().checkIdOfExpenseItem(expenseItemId);
		userContext.getChecker().checkVersionOfExpenseItem(expenseItemVersion);
		

		if(ExpenseItem.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfExpenseItem(parseString(newValueExpr));
		}
		
		if(ExpenseItem.PRICE_PROPERTY.equals(property)){
			userContext.getChecker().checkPriceOfExpenseItem(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ExpenseTypeManagerException.class);
	
	}
	
	public  ExpenseType updateExpenseItem(HisUserContext userContext, String expenseTypeId, String expenseItemId, int expenseItemVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingExpenseItem(userContext, expenseTypeId, expenseItemId, expenseItemVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withExpenseItemList().searchExpenseItemListWith(ExpenseItem.ID_PROPERTY, "eq", expenseItemId).done();
		
		
		
		ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, loadTokens);
		
		synchronized(expenseType){ 
			//Will be good when the expenseType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//expenseType.removeExpenseItem( expenseItem );	
			//make changes to AcceleraterAccount.
			ExpenseItem expenseItemIndex = createIndexedExpenseItem(expenseItemId, expenseItemVersion);
		
			ExpenseItem expenseItem = expenseType.findTheExpenseItem(expenseItemIndex);
			if(expenseItem == null){
				throw new ExpenseTypeManagerException(expenseItem+" is NOT FOUND" );
			}
			
			expenseItem.changeProperty(property, newValueExpr);
			expenseItem.updateUpdateTime(userContext.now());
			expenseType = saveExpenseType(userContext, expenseType, tokens().withExpenseItemList().done());
			return present(userContext,expenseType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingDoctorSchedule(HisUserContext userContext, String expenseTypeId, String name, String doctorId, Date scheduleDate, String periodId, String departmentId, int available, BigDecimal price, String hospitalId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfExpenseType(expenseTypeId);

		
		userContext.getChecker().checkNameOfDoctorSchedule(name);
		
		userContext.getChecker().checkDoctorIdOfDoctorSchedule(doctorId);
		
		userContext.getChecker().checkScheduleDateOfDoctorSchedule(scheduleDate);
		
		userContext.getChecker().checkPeriodIdOfDoctorSchedule(periodId);
		
		userContext.getChecker().checkDepartmentIdOfDoctorSchedule(departmentId);
		
		userContext.getChecker().checkAvailableOfDoctorSchedule(available);
		
		userContext.getChecker().checkPriceOfDoctorSchedule(price);
		
		userContext.getChecker().checkHospitalIdOfDoctorSchedule(hospitalId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ExpenseTypeManagerException.class);

	
	}
	public  ExpenseType addDoctorSchedule(HisUserContext userContext, String expenseTypeId, String name, String doctorId, Date scheduleDate, String periodId, String departmentId, int available, BigDecimal price, String hospitalId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingDoctorSchedule(userContext,expenseTypeId,name, doctorId, scheduleDate, periodId, departmentId, available, price, hospitalId,tokensExpr);
		
		DoctorSchedule doctorSchedule = createDoctorSchedule(userContext,name, doctorId, scheduleDate, periodId, departmentId, available, price, hospitalId);
		
		ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());
		synchronized(expenseType){ 
			//Will be good when the expenseType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			expenseType.addDoctorSchedule( doctorSchedule );		
			expenseType = saveExpenseType(userContext, expenseType, tokens().withDoctorScheduleList().done());
			
			userContext.getManagerGroup().getDoctorScheduleManager().onNewInstanceCreated(userContext, doctorSchedule);
			return present(userContext,expenseType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingDoctorScheduleProperties(HisUserContext userContext, String expenseTypeId,String id,String name,Date scheduleDate,int available,BigDecimal price,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfExpenseType(expenseTypeId);
		userContext.getChecker().checkIdOfDoctorSchedule(id);
		
		userContext.getChecker().checkNameOfDoctorSchedule( name);
		userContext.getChecker().checkScheduleDateOfDoctorSchedule( scheduleDate);
		userContext.getChecker().checkAvailableOfDoctorSchedule( available);
		userContext.getChecker().checkPriceOfDoctorSchedule( price);

		userContext.getChecker().throwExceptionIfHasErrors(ExpenseTypeManagerException.class);
		
	}
	public  ExpenseType updateDoctorScheduleProperties(HisUserContext userContext, String expenseTypeId, String id,String name,Date scheduleDate,int available,BigDecimal price, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingDoctorScheduleProperties(userContext,expenseTypeId,id,name,scheduleDate,available,price,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withDoctorScheduleListList()
				.searchDoctorScheduleListWith(DoctorSchedule.ID_PROPERTY, "is", id).done();
		
		ExpenseType expenseTypeToUpdate = loadExpenseType(userContext, expenseTypeId, options);
		
		if(expenseTypeToUpdate.getDoctorScheduleList().isEmpty()){
			throw new ExpenseTypeManagerException("DoctorSchedule is NOT FOUND with id: '"+id+"'");
		}
		
		DoctorSchedule item = expenseTypeToUpdate.getDoctorScheduleList().first();
		
		item.updateName( name );
		item.updateScheduleDate( scheduleDate );
		item.updateAvailable( available );
		item.updatePrice( price );

		
		//checkParamsForAddingDoctorSchedule(userContext,expenseTypeId,name, code, used,tokensExpr);
		ExpenseType expenseType = saveExpenseType(userContext, expenseTypeToUpdate, tokens().withDoctorScheduleList().done());
		synchronized(expenseType){ 
			return present(userContext,expenseType, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected DoctorSchedule createDoctorSchedule(HisUserContext userContext, String name, String doctorId, Date scheduleDate, String periodId, String departmentId, int available, BigDecimal price, String hospitalId) throws Exception{

		DoctorSchedule doctorSchedule = new DoctorSchedule();
		
		
		doctorSchedule.setName(name);		
		Doctor  doctor = new Doctor();
		doctor.setId(doctorId);		
		doctorSchedule.setDoctor(doctor);		
		doctorSchedule.setScheduleDate(scheduleDate);		
		Period  period = new Period();
		period.setId(periodId);		
		doctorSchedule.setPeriod(period);		
		Department  department = new Department();
		department.setId(departmentId);		
		doctorSchedule.setDepartment(department);		
		doctorSchedule.setAvailable(available);		
		doctorSchedule.setPrice(price);		
		doctorSchedule.setCreateTime(userContext.now());		
		doctorSchedule.setUpdateTime(userContext.now());		
		Hospital  hospital = new Hospital();
		hospital.setId(hospitalId);		
		doctorSchedule.setHospital(hospital);
	
		
		return doctorSchedule;
	
		
	}
	
	protected DoctorSchedule createIndexedDoctorSchedule(String id, int version){

		DoctorSchedule doctorSchedule = new DoctorSchedule();
		doctorSchedule.setId(id);
		doctorSchedule.setVersion(version);
		return doctorSchedule;			
		
	}
	
	protected void checkParamsForRemovingDoctorScheduleList(HisUserContext userContext, String expenseTypeId, 
			String doctorScheduleIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfExpenseType(expenseTypeId);
		for(String doctorScheduleIdItem: doctorScheduleIds){
			userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleIdItem);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ExpenseTypeManagerException.class);
		
	}
	public  ExpenseType removeDoctorScheduleList(HisUserContext userContext, String expenseTypeId, 
			String doctorScheduleIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingDoctorScheduleList(userContext, expenseTypeId,  doctorScheduleIds, tokensExpr);
			
			
			ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());
			synchronized(expenseType){ 
				//Will be good when the expenseType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getExpenseTypeDAO().planToRemoveDoctorScheduleList(expenseType, doctorScheduleIds, allTokens());
				expenseType = saveExpenseType(userContext, expenseType, tokens().withDoctorScheduleList().done());
				deleteRelationListInGraph(userContext, expenseType.getDoctorScheduleList());
				return present(userContext,expenseType, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingDoctorSchedule(HisUserContext userContext, String expenseTypeId, 
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfExpenseType( expenseTypeId);
		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
		userContext.getChecker().checkVersionOfDoctorSchedule(doctorScheduleVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ExpenseTypeManagerException.class);
	
	}
	public  ExpenseType removeDoctorSchedule(HisUserContext userContext, String expenseTypeId, 
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingDoctorSchedule(userContext,expenseTypeId, doctorScheduleId, doctorScheduleVersion,tokensExpr);
		
		DoctorSchedule doctorSchedule = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);
		ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());
		synchronized(expenseType){ 
			//Will be good when the expenseType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			expenseType.removeDoctorSchedule( doctorSchedule );		
			expenseType = saveExpenseType(userContext, expenseType, tokens().withDoctorScheduleList().done());
			deleteRelationInGraph(userContext, doctorSchedule);
			return present(userContext,expenseType, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingDoctorSchedule(HisUserContext userContext, String expenseTypeId, 
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfExpenseType( expenseTypeId);
		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
		userContext.getChecker().checkVersionOfDoctorSchedule(doctorScheduleVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ExpenseTypeManagerException.class);
	
	}
	public  ExpenseType copyDoctorScheduleFrom(HisUserContext userContext, String expenseTypeId, 
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingDoctorSchedule(userContext,expenseTypeId, doctorScheduleId, doctorScheduleVersion,tokensExpr);
		
		DoctorSchedule doctorSchedule = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);
		ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());
		synchronized(expenseType){ 
			//Will be good when the expenseType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			doctorSchedule.updateUpdateTime(userContext.now());
			
			expenseType.copyDoctorScheduleFrom( doctorSchedule );		
			expenseType = saveExpenseType(userContext, expenseType, tokens().withDoctorScheduleList().done());
			
			userContext.getManagerGroup().getDoctorScheduleManager().onNewInstanceCreated(userContext, (DoctorSchedule)expenseType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,expenseType, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingDoctorSchedule(HisUserContext userContext, String expenseTypeId, String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfExpenseType(expenseTypeId);
		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
		userContext.getChecker().checkVersionOfDoctorSchedule(doctorScheduleVersion);
		

		if(DoctorSchedule.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfDoctorSchedule(parseString(newValueExpr));
		}
		
		if(DoctorSchedule.SCHEDULE_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkScheduleDateOfDoctorSchedule(parseDate(newValueExpr));
		}
		
		if(DoctorSchedule.AVAILABLE_PROPERTY.equals(property)){
			userContext.getChecker().checkAvailableOfDoctorSchedule(parseInt(newValueExpr));
		}
		
		if(DoctorSchedule.PRICE_PROPERTY.equals(property)){
			userContext.getChecker().checkPriceOfDoctorSchedule(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ExpenseTypeManagerException.class);
	
	}
	
	public  ExpenseType updateDoctorSchedule(HisUserContext userContext, String expenseTypeId, String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingDoctorSchedule(userContext, expenseTypeId, doctorScheduleId, doctorScheduleVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withDoctorScheduleList().searchDoctorScheduleListWith(DoctorSchedule.ID_PROPERTY, "eq", doctorScheduleId).done();
		
		
		
		ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, loadTokens);
		
		synchronized(expenseType){ 
			//Will be good when the expenseType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//expenseType.removeDoctorSchedule( doctorSchedule );	
			//make changes to AcceleraterAccount.
			DoctorSchedule doctorScheduleIndex = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);
		
			DoctorSchedule doctorSchedule = expenseType.findTheDoctorSchedule(doctorScheduleIndex);
			if(doctorSchedule == null){
				throw new ExpenseTypeManagerException(doctorSchedule+" is NOT FOUND" );
			}
			
			doctorSchedule.changeProperty(property, newValueExpr);
			doctorSchedule.updateUpdateTime(userContext.now());
			expenseType = saveExpenseType(userContext, expenseType, tokens().withDoctorScheduleList().done());
			return present(userContext,expenseType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(HisUserContext userContext, ExpenseType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


