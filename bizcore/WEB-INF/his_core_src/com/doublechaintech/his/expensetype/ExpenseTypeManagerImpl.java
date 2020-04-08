
package com.doublechaintech.his.expensetype;

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
import com.doublechaintech.his.doctorschedule.DoctorSchedule;
import com.doublechaintech.his.expenseitem.ExpenseItem;

import com.doublechaintech.his.hospital.CandidateHospital;

import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;






public class ExpenseTypeManagerImpl extends CustomHisCheckerManager implements ExpenseTypeManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "ExpenseType";
	@Override
	public ExpenseTypeDAO daoOf(HisUserContext userContext) {
		return expenseTypeDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfExpenseType(expenseTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( ExpenseTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ExpenseType expenseType = loadExpenseType( userContext, expenseTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,expenseType, tokens);
 	}
 	
 	
 	 public ExpenseType searchExpenseType(HisUserContext userContext, String expenseTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfExpenseType(expenseTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( ExpenseTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ExpenseType expenseType = loadExpenseType( userContext, expenseTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,expenseType, tokens);
 	}
 	
 	

 	protected ExpenseType present(HisUserContext userContext, ExpenseType expenseType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,expenseType,tokens);
		
		
		ExpenseType  expenseTypeToPresent = expenseTypeDaoOf(userContext).present(expenseType, tokens);
		
		List<BaseEntity> entityListToNaming = expenseTypeToPresent.collectRefercencesFromLists();
		expenseTypeDaoOf(userContext).alias(entityListToNaming);
		
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
 		return expenseTypeDaoOf(userContext).save(expenseType, tokens);
 	}
 	protected ExpenseType loadExpenseType(HisUserContext userContext, String expenseTypeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfExpenseType(expenseTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( ExpenseTypeManagerException.class);

 
 		return expenseTypeDaoOf(userContext).load(expenseTypeId, tokens);
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
	
 	
 	
 
 	
 	

	public ExpenseType createExpenseType(HisUserContext userContext, String name,String helperChars,String status,String hospitalId,String description) throws Exception
	//public ExpenseType createExpenseType(HisUserContext userContext,String name, String helperChars, String status, String hospitalId, String description) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfExpenseType(name);
		checkerOf(userContext).checkHelperCharsOfExpenseType(helperChars);
		checkerOf(userContext).checkStatusOfExpenseType(status);
		checkerOf(userContext).checkDescriptionOfExpenseType(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseTypeManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfExpenseType(expenseTypeId);
		checkerOf(userContext).checkVersionOfExpenseType( expenseTypeVersion);
		

		if(ExpenseType.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfExpenseType(parseString(newValueExpr));
		
			
		}
		if(ExpenseType.HELPER_CHARS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkHelperCharsOfExpenseType(parseString(newValueExpr));
		
			
		}
		if(ExpenseType.STATUS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkStatusOfExpenseType(parseString(newValueExpr));
		
			
		}		

		
		if(ExpenseType.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfExpenseType(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseTypeManagerException.class);


	}



	public ExpenseType clone(HisUserContext userContext, String fromExpenseTypeId) throws Exception{

		return expenseTypeDaoOf(userContext).clone(fromExpenseTypeId, this.allTokens());
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

 		checkerOf(userContext).checkIdOfExpenseType(expenseTypeId);
 		checkerOf(userContext).checkIdOfHospital(anotherHospitalId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseTypeManagerException.class);

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
		SmartList<Hospital> candidateList = hospitalDaoOf(userContext).requestCandidateHospitalForExpenseType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	


	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String expenseTypeId, int expenseTypeVersion) throws Exception {
		//deleteInternal(userContext, expenseTypeId, expenseTypeVersion);
	}
	protected void deleteInternal(HisUserContext userContext,
			String expenseTypeId, int expenseTypeVersion) throws Exception{

		expenseTypeDaoOf(userContext).delete(expenseTypeId, expenseTypeVersion);
	}

	public ExpenseType forgetByAll(HisUserContext userContext, String expenseTypeId, int expenseTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, expenseTypeId, expenseTypeVersion);
	}
	protected ExpenseType forgetByAllInternal(HisUserContext userContext,
			String expenseTypeId, int expenseTypeVersion) throws Exception{

		return expenseTypeDaoOf(userContext).disconnectFromAll(expenseTypeId, expenseTypeVersion);
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
		return expenseTypeDaoOf(userContext).deleteAll();
	}


	//disconnect ExpenseType with hospital in ExpenseItem
	protected ExpenseType breakWithExpenseItemByHospital(HisUserContext userContext, String expenseTypeId, String hospitalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());

			synchronized(expenseType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				expenseTypeDaoOf(userContext).planToRemoveExpenseItemListWithHospital(expenseType, hospitalId, this.emptyOptions());

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

				expenseTypeDaoOf(userContext).planToRemoveDoctorScheduleListWithDoctor(expenseType, doctorId, this.emptyOptions());

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

				expenseTypeDaoOf(userContext).planToRemoveDoctorScheduleListWithPeriod(expenseType, periodId, this.emptyOptions());

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

				expenseTypeDaoOf(userContext).planToRemoveDoctorScheduleListWithDepartment(expenseType, departmentId, this.emptyOptions());

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

				expenseTypeDaoOf(userContext).planToRemoveDoctorScheduleListWithHospital(expenseType, hospitalId, this.emptyOptions());

				expenseType = saveExpenseType(userContext, expenseType, tokens().withDoctorScheduleList().done());
				return expenseType;
			}
	}






	protected void checkParamsForAddingExpenseItem(HisUserContext userContext, String expenseTypeId, String name, BigDecimal price, String hospitalId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfExpenseType(expenseTypeId);

		
		checkerOf(userContext).checkNameOfExpenseItem(name);
		
		checkerOf(userContext).checkPriceOfExpenseItem(price);
		
		checkerOf(userContext).checkHospitalIdOfExpenseItem(hospitalId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseTypeManagerException.class);


	}
	public  ExpenseType addExpenseItem(HisUserContext userContext, String expenseTypeId, String name, BigDecimal price, String hospitalId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingExpenseItem(userContext,expenseTypeId,name, price, hospitalId,tokensExpr);

		ExpenseItem expenseItem = createExpenseItem(userContext,name, price, hospitalId);

		ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, emptyOptions());
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

		checkerOf(userContext).checkIdOfExpenseType(expenseTypeId);
		checkerOf(userContext).checkIdOfExpenseItem(id);

		checkerOf(userContext).checkNameOfExpenseItem( name);
		checkerOf(userContext).checkPriceOfExpenseItem( price);

		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseTypeManagerException.class);

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

		checkerOf(userContext).checkIdOfExpenseType(expenseTypeId);
		for(String expenseItemIdItem: expenseItemIds){
			checkerOf(userContext).checkIdOfExpenseItem(expenseItemIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseTypeManagerException.class);

	}
	public  ExpenseType removeExpenseItemList(HisUserContext userContext, String expenseTypeId,
			String expenseItemIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingExpenseItemList(userContext, expenseTypeId,  expenseItemIds, tokensExpr);


			ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());
			synchronized(expenseType){
				//Will be good when the expenseType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				expenseTypeDaoOf(userContext).planToRemoveExpenseItemList(expenseType, expenseItemIds, allTokens());
				expenseType = saveExpenseType(userContext, expenseType, tokens().withExpenseItemList().done());
				deleteRelationListInGraph(userContext, expenseType.getExpenseItemList());
				return present(userContext,expenseType, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingExpenseItem(HisUserContext userContext, String expenseTypeId,
		String expenseItemId, int expenseItemVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfExpenseType( expenseTypeId);
		checkerOf(userContext).checkIdOfExpenseItem(expenseItemId);
		checkerOf(userContext).checkVersionOfExpenseItem(expenseItemVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseTypeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfExpenseType( expenseTypeId);
		checkerOf(userContext).checkIdOfExpenseItem(expenseItemId);
		checkerOf(userContext).checkVersionOfExpenseItem(expenseItemVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseTypeManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfExpenseType(expenseTypeId);
		checkerOf(userContext).checkIdOfExpenseItem(expenseItemId);
		checkerOf(userContext).checkVersionOfExpenseItem(expenseItemVersion);
		

		if(ExpenseItem.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfExpenseItem(parseString(newValueExpr));
		
		}
		
		if(ExpenseItem.PRICE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPriceOfExpenseItem(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseTypeManagerException.class);

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

				checkerOf(userContext).checkIdOfExpenseType(expenseTypeId);

		
		checkerOf(userContext).checkNameOfDoctorSchedule(name);
		
		checkerOf(userContext).checkDoctorIdOfDoctorSchedule(doctorId);
		
		checkerOf(userContext).checkScheduleDateOfDoctorSchedule(scheduleDate);
		
		checkerOf(userContext).checkPeriodIdOfDoctorSchedule(periodId);
		
		checkerOf(userContext).checkDepartmentIdOfDoctorSchedule(departmentId);
		
		checkerOf(userContext).checkAvailableOfDoctorSchedule(available);
		
		checkerOf(userContext).checkPriceOfDoctorSchedule(price);
		
		checkerOf(userContext).checkHospitalIdOfDoctorSchedule(hospitalId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseTypeManagerException.class);


	}
	public  ExpenseType addDoctorSchedule(HisUserContext userContext, String expenseTypeId, String name, String doctorId, Date scheduleDate, String periodId, String departmentId, int available, BigDecimal price, String hospitalId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingDoctorSchedule(userContext,expenseTypeId,name, doctorId, scheduleDate, periodId, departmentId, available, price, hospitalId,tokensExpr);

		DoctorSchedule doctorSchedule = createDoctorSchedule(userContext,name, doctorId, scheduleDate, periodId, departmentId, available, price, hospitalId);

		ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, emptyOptions());
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

		checkerOf(userContext).checkIdOfExpenseType(expenseTypeId);
		checkerOf(userContext).checkIdOfDoctorSchedule(id);

		checkerOf(userContext).checkNameOfDoctorSchedule( name);
		checkerOf(userContext).checkScheduleDateOfDoctorSchedule( scheduleDate);
		checkerOf(userContext).checkAvailableOfDoctorSchedule( available);
		checkerOf(userContext).checkPriceOfDoctorSchedule( price);

		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseTypeManagerException.class);

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

		checkerOf(userContext).checkIdOfExpenseType(expenseTypeId);
		for(String doctorScheduleIdItem: doctorScheduleIds){
			checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseTypeManagerException.class);

	}
	public  ExpenseType removeDoctorScheduleList(HisUserContext userContext, String expenseTypeId,
			String doctorScheduleIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingDoctorScheduleList(userContext, expenseTypeId,  doctorScheduleIds, tokensExpr);


			ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId, allTokens());
			synchronized(expenseType){
				//Will be good when the expenseType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				expenseTypeDaoOf(userContext).planToRemoveDoctorScheduleList(expenseType, doctorScheduleIds, allTokens());
				expenseType = saveExpenseType(userContext, expenseType, tokens().withDoctorScheduleList().done());
				deleteRelationListInGraph(userContext, expenseType.getDoctorScheduleList());
				return present(userContext,expenseType, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingDoctorSchedule(HisUserContext userContext, String expenseTypeId,
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfExpenseType( expenseTypeId);
		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
		checkerOf(userContext).checkVersionOfDoctorSchedule(doctorScheduleVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseTypeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfExpenseType( expenseTypeId);
		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
		checkerOf(userContext).checkVersionOfDoctorSchedule(doctorScheduleVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseTypeManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfExpenseType(expenseTypeId);
		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
		checkerOf(userContext).checkVersionOfDoctorSchedule(doctorScheduleVersion);
		

		if(DoctorSchedule.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfDoctorSchedule(parseString(newValueExpr));
		
		}
		
		if(DoctorSchedule.SCHEDULE_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkScheduleDateOfDoctorSchedule(parseDate(newValueExpr));
		
		}
		
		if(DoctorSchedule.AVAILABLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAvailableOfDoctorSchedule(parseInt(newValueExpr));
		
		}
		
		if(DoctorSchedule.PRICE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPriceOfDoctorSchedule(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExpenseTypeManagerException.class);

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
		//   ExpenseType newExpenseType = this.createExpenseType(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newExpenseType
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, ExpenseType.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(HisUserContext userContext,SmartList<ExpenseType> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Hospital> hospitalList = HisBaseUtils.collectReferencedObjectWithType(userContext, list, Hospital.class);
		userContext.getDAOGroup().enhanceList(hospitalList, Hospital.class);


    }
	
	public Object listByHospital(HisUserContext userContext,String hospitalId) throws Exception {
		return listPageByHospital(userContext, hospitalId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByHospital(HisUserContext userContext,String hospitalId, int start, int count) throws Exception {
		SmartList<ExpenseType> list = expenseTypeDaoOf(userContext).findExpenseTypeByHospital(hospitalId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(ExpenseType.class);
		page.setContainerObject(Hospital.withId(hospitalId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("费用类型列表");
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
 	public Object wxappview(HisUserContext userContext, String expenseTypeId) throws Exception{
	  SerializeScope vscope = HisViewScope.getInstance().getExpenseTypeDetailScope().clone();
		ExpenseType merchantObj = (ExpenseType) this.view(userContext, expenseTypeId);
    String merchantObjId = expenseTypeId;
    String linkToUrl =	"expenseTypeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "费用类型"+"详情";
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
				MapUtil.put("id", "3-helperChars")
				    .put("fieldName", "helperChars")
				    .put("label", "辅助识字课")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("helperChars", merchantObj.getHelperChars());

		propList.add(
				MapUtil.put("id", "4-status")
				    .put("fieldName", "status")
				    .put("label", "状态")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("status", merchantObj.getStatus());

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
				MapUtil.put("id", "6-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "longText")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		propList.add(
				MapUtil.put("id", "7-updateTime")
				    .put("fieldName", "updateTime")
				    .put("label", "更新时间")
				    .put("type", "date")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("updateTime", merchantObj.getUpdateTime());

		//处理 sectionList

		//处理Section：doctorScheduleListSection
		Map doctorScheduleListSection = ListofUtils.buildSection(
		    "doctorScheduleListSection",
		    "医生安排列表",
		    null,
		    "",
		    "__no_group",
		    "doctorScheduleManager/listByExpenseType/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(doctorScheduleListSection);

		result.put("doctorScheduleListSection", ListofUtils.toShortList(merchantObj.getDoctorScheduleList(), "doctorSchedule"));
		vscope.field("doctorScheduleListSection", HisListOfViewScope.getInstance()
					.getListOfViewScope( DoctorSchedule.class.getName(), null));

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


