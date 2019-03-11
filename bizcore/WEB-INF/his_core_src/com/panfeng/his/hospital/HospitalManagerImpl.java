
package com.panfeng.his.hospital;

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

import com.panfeng.his.doctor.Doctor;
import com.panfeng.his.expenseitem.ExpenseItem;
import com.panfeng.his.department.Department;
import com.panfeng.his.expensetype.ExpenseType;


import com.panfeng.his.hospital.Hospital;
import com.panfeng.his.expensetype.ExpenseType;






public class HospitalManagerImpl extends CustomHisCheckerManager implements HospitalManager {
	
	private static final String SERVICE_TYPE = "Hospital";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws HospitalManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new HospitalManagerException(message);

	}
	
	

 	protected Hospital saveHospital(HisUserContext userContext, Hospital hospital, String [] tokensExpr) throws Exception{	
 		//return getHospitalDAO().save(hospital, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveHospital(userContext, hospital, tokens);
 	}
 	
 	protected Hospital saveHospitalDetail(HisUserContext userContext, Hospital hospital) throws Exception{	

 		
 		return saveHospital(userContext, hospital, allTokens());
 	}
 	
 	public Hospital loadHospital(HisUserContext userContext, String hospitalId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfHospital(hospitalId);
		userContext.getChecker().throwExceptionIfHasErrors( HospitalManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Hospital hospital = loadHospital( userContext, hospitalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,hospital, tokens);
 	}
 	
 	
 	 public Hospital searchHospital(HisUserContext userContext, String hospitalId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfHospital(hospitalId);
		userContext.getChecker().throwExceptionIfHasErrors( HospitalManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Hospital hospital = loadHospital( userContext, hospitalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,hospital, tokens);
 	}
 	
 	

 	protected Hospital present(HisUserContext userContext, Hospital hospital, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,hospital,tokens);
		
		
		Hospital  hospitalToPresent = userContext.getDAOGroup().getHospitalDAO().present(hospital, tokens);
		
		List<BaseEntity> entityListToNaming = hospitalToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getHospitalDAO().alias(entityListToNaming);
		
		return  hospitalToPresent;
		
		
	}
 
 	
 	
 	public Hospital loadHospitalDetail(HisUserContext userContext, String hospitalId) throws Exception{	
 		Hospital hospital = loadHospital( userContext, hospitalId, allTokens());
 		return present(userContext,hospital, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String hospitalId) throws Exception{	
 		Hospital hospital = loadHospital( userContext, hospitalId, viewTokens());
 		return present(userContext,hospital, allTokens());
		
 	}
 	protected Hospital saveHospital(HisUserContext userContext, Hospital hospital, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getHospitalDAO().save(hospital, tokens);
 	}
 	protected Hospital loadHospital(HisUserContext userContext, String hospitalId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfHospital(hospitalId);
		userContext.getChecker().throwExceptionIfHasErrors( HospitalManagerException.class);

 
 		return userContext.getDAOGroup().getHospitalDAO().load(hospitalId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, Hospital hospital, Map<String, Object> tokens){
		super.addActions(userContext, hospital, tokens);
		
		addAction(userContext, hospital, tokens,"@create","createHospital","createHospital/","main","primary");
		addAction(userContext, hospital, tokens,"@update","updateHospital","updateHospital/"+hospital.getId()+"/","main","primary");
		addAction(userContext, hospital, tokens,"@copy","cloneHospital","cloneHospital/"+hospital.getId()+"/","main","primary");
		
		addAction(userContext, hospital, tokens,"hospital.addExpenseType","addExpenseType","addExpenseType/"+hospital.getId()+"/","expenseTypeList","primary");
		addAction(userContext, hospital, tokens,"hospital.removeExpenseType","removeExpenseType","removeExpenseType/"+hospital.getId()+"/","expenseTypeList","primary");
		addAction(userContext, hospital, tokens,"hospital.updateExpenseType","updateExpenseType","updateExpenseType/"+hospital.getId()+"/","expenseTypeList","primary");
		addAction(userContext, hospital, tokens,"hospital.copyExpenseTypeFrom","copyExpenseTypeFrom","copyExpenseTypeFrom/"+hospital.getId()+"/","expenseTypeList","primary");
		addAction(userContext, hospital, tokens,"hospital.addExpenseItem","addExpenseItem","addExpenseItem/"+hospital.getId()+"/","expenseItemList","primary");
		addAction(userContext, hospital, tokens,"hospital.removeExpenseItem","removeExpenseItem","removeExpenseItem/"+hospital.getId()+"/","expenseItemList","primary");
		addAction(userContext, hospital, tokens,"hospital.updateExpenseItem","updateExpenseItem","updateExpenseItem/"+hospital.getId()+"/","expenseItemList","primary");
		addAction(userContext, hospital, tokens,"hospital.copyExpenseItemFrom","copyExpenseItemFrom","copyExpenseItemFrom/"+hospital.getId()+"/","expenseItemList","primary");
		addAction(userContext, hospital, tokens,"hospital.addDoctor","addDoctor","addDoctor/"+hospital.getId()+"/","doctorList","primary");
		addAction(userContext, hospital, tokens,"hospital.removeDoctor","removeDoctor","removeDoctor/"+hospital.getId()+"/","doctorList","primary");
		addAction(userContext, hospital, tokens,"hospital.updateDoctor","updateDoctor","updateDoctor/"+hospital.getId()+"/","doctorList","primary");
		addAction(userContext, hospital, tokens,"hospital.copyDoctorFrom","copyDoctorFrom","copyDoctorFrom/"+hospital.getId()+"/","doctorList","primary");
		addAction(userContext, hospital, tokens,"hospital.addDepartment","addDepartment","addDepartment/"+hospital.getId()+"/","departmentList","primary");
		addAction(userContext, hospital, tokens,"hospital.removeDepartment","removeDepartment","removeDepartment/"+hospital.getId()+"/","departmentList","primary");
		addAction(userContext, hospital, tokens,"hospital.updateDepartment","updateDepartment","updateDepartment/"+hospital.getId()+"/","departmentList","primary");
		addAction(userContext, hospital, tokens,"hospital.copyDepartmentFrom","copyDepartmentFrom","copyDepartmentFrom/"+hospital.getId()+"/","departmentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, Hospital hospital, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Hospital createHospital(HisUserContext userContext,String name, String address, String telephone) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfHospital(name);
		userContext.getChecker().checkAddressOfHospital(address);
		userContext.getChecker().checkTelephoneOfHospital(telephone);
	
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);


		Hospital hospital=createNewHospital();	

		hospital.setName(name);
		hospital.setAddress(address);
		hospital.setTelephone(telephone);

		hospital = saveHospital(userContext, hospital, emptyOptions());
		
		onNewInstanceCreated(userContext, hospital);
		return hospital;

		
	}
	protected Hospital createNewHospital() 
	{
		
		return new Hospital();		
	}
	
	protected void checkParamsForUpdatingHospital(HisUserContext userContext,String hospitalId, int hospitalVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfHospital(hospitalId);
		userContext.getChecker().checkVersionOfHospital( hospitalVersion);
		

		if(Hospital.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfHospital(parseString(newValueExpr));
		}
		if(Hospital.ADDRESS_PROPERTY.equals(property)){
			userContext.getChecker().checkAddressOfHospital(parseString(newValueExpr));
		}
		if(Hospital.TELEPHONE_PROPERTY.equals(property)){
			userContext.getChecker().checkTelephoneOfHospital(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
	
		
	}
	
	
	
	public Hospital clone(HisUserContext userContext, String fromHospitalId) throws Exception{
		
		return userContext.getDAOGroup().getHospitalDAO().clone(fromHospitalId, this.allTokens());
	}
	
	public Hospital internalSaveHospital(HisUserContext userContext, Hospital hospital) throws Exception 
	{
		return internalSaveHospital(userContext, hospital, allTokens());

	}
	public Hospital internalSaveHospital(HisUserContext userContext, Hospital hospital, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingHospital(userContext, hospitalId, hospitalVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(hospital){ 
			//will be good when the hospital loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Hospital.
			
			
			hospital = saveHospital(userContext, hospital, options);
			return hospital;
			
		}

	}
	
	public Hospital updateHospital(HisUserContext userContext,String hospitalId, int hospitalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingHospital(userContext, hospitalId, hospitalVersion, property, newValueExpr, tokensExpr);
		
		
		
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		if(hospital.getVersion() != hospitalVersion){
			String message = "The target version("+hospital.getVersion()+") is not equals to version("+hospitalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(hospital){ 
			//will be good when the hospital loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Hospital.
			
			hospital.changeProperty(property, newValueExpr);
			hospital = saveHospital(userContext, hospital, tokens().done());
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
			//return saveHospital(userContext, hospital, tokens().done());
		}

	}
	
	public Hospital updateHospitalProperty(HisUserContext userContext,String hospitalId, int hospitalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingHospital(userContext, hospitalId, hospitalVersion, property, newValueExpr, tokensExpr);
		
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		if(hospital.getVersion() != hospitalVersion){
			String message = "The target version("+hospital.getVersion()+") is not equals to version("+hospitalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(hospital){ 
			//will be good when the hospital loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Hospital.
			
			hospital.changeProperty(property, newValueExpr);
			
			hospital = saveHospital(userContext, hospital, tokens().done());
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
			//return saveHospital(userContext, hospital, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected HospitalTokens tokens(){
		return HospitalTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return HospitalTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortExpenseTypeListWith("id","desc")
		.sortExpenseItemListWith("id","desc")
		.sortDoctorListWith("id","desc")
		.sortDepartmentListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return HospitalTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String hospitalId, int hospitalVersion) throws Exception {
		//deleteInternal(userContext, hospitalId, hospitalVersion);		
	}
	protected void deleteInternal(HisUserContext userContext,
			String hospitalId, int hospitalVersion) throws Exception{
			
		userContext.getDAOGroup().getHospitalDAO().delete(hospitalId, hospitalVersion);
	}
	
	public Hospital forgetByAll(HisUserContext userContext, String hospitalId, int hospitalVersion) throws Exception {
		return forgetByAllInternal(userContext, hospitalId, hospitalVersion);		
	}
	protected Hospital forgetByAllInternal(HisUserContext userContext,
			String hospitalId, int hospitalVersion) throws Exception{
			
		return userContext.getDAOGroup().getHospitalDAO().disconnectFromAll(hospitalId, hospitalVersion);
	}
	

	
	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new HospitalManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getHospitalDAO().deleteAll();
	}


	//disconnect Hospital with expense_type in ExpenseItem
	protected Hospital breakWithExpenseItemByExpenseType(HisUserContext userContext, String hospitalId, String expenseTypeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Hospital hospital = loadHospital(userContext, hospitalId, allTokens());

			synchronized(hospital){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getHospitalDAO().planToRemoveExpenseItemListWithExpenseType(hospital, expenseTypeId, this.emptyOptions());

				hospital = saveHospital(userContext, hospital, tokens().withExpenseItemList().done());
				return hospital;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingExpenseType(HisUserContext userContext, String hospitalId, String name, String helperChars, String status, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfHospital(hospitalId);

		
		userContext.getChecker().checkNameOfExpenseType(name);
		
		userContext.getChecker().checkHelperCharsOfExpenseType(helperChars);
		
		userContext.getChecker().checkStatusOfExpenseType(status);
		
		userContext.getChecker().checkDescriptionOfExpenseType(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);

	
	}
	public  Hospital addExpenseType(HisUserContext userContext, String hospitalId, String name, String helperChars, String status, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingExpenseType(userContext,hospitalId,name, helperChars, status, description,tokensExpr);
		
		ExpenseType expenseType = createExpenseType(userContext,name, helperChars, status, description);
		
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){ 
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hospital.addExpenseType( expenseType );		
			hospital = saveHospital(userContext, hospital, tokens().withExpenseTypeList().done());
			
			userContext.getManagerGroup().getExpenseTypeManager().onNewInstanceCreated(userContext, expenseType);
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingExpenseTypeProperties(HisUserContext userContext, String hospitalId,String id,String name,String helperChars,String status,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfHospital(hospitalId);
		userContext.getChecker().checkIdOfExpenseType(id);
		
		userContext.getChecker().checkNameOfExpenseType( name);
		userContext.getChecker().checkHelperCharsOfExpenseType( helperChars);
		userContext.getChecker().checkStatusOfExpenseType( status);
		userContext.getChecker().checkDescriptionOfExpenseType( description);

		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
		
	}
	public  Hospital updateExpenseTypeProperties(HisUserContext userContext, String hospitalId, String id,String name,String helperChars,String status,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingExpenseTypeProperties(userContext,hospitalId,id,name,helperChars,status,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withExpenseTypeListList()
				.searchExpenseTypeListWith(ExpenseType.ID_PROPERTY, "is", id).done();
		
		Hospital hospitalToUpdate = loadHospital(userContext, hospitalId, options);
		
		if(hospitalToUpdate.getExpenseTypeList().isEmpty()){
			throw new HospitalManagerException("ExpenseType is NOT FOUND with id: '"+id+"'");
		}
		
		ExpenseType item = hospitalToUpdate.getExpenseTypeList().first();
		
		item.updateName( name );
		item.updateHelperChars( helperChars );
		item.updateStatus( status );
		item.updateDescription( description );

		
		//checkParamsForAddingExpenseType(userContext,hospitalId,name, code, used,tokensExpr);
		Hospital hospital = saveHospital(userContext, hospitalToUpdate, tokens().withExpenseTypeList().done());
		synchronized(hospital){ 
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ExpenseType createExpenseType(HisUserContext userContext, String name, String helperChars, String status, String description) throws Exception{

		ExpenseType expenseType = new ExpenseType();
		
		
		expenseType.setName(name);		
		expenseType.setHelperChars(helperChars);		
		expenseType.setStatus(status);		
		expenseType.setDescription(description);
	
		
		return expenseType;
	
		
	}
	
	protected ExpenseType createIndexedExpenseType(String id, int version){

		ExpenseType expenseType = new ExpenseType();
		expenseType.setId(id);
		expenseType.setVersion(version);
		return expenseType;			
		
	}
	
	protected void checkParamsForRemovingExpenseTypeList(HisUserContext userContext, String hospitalId, 
			String expenseTypeIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfHospital(hospitalId);
		for(String expenseTypeId: expenseTypeIds){
			userContext.getChecker().checkIdOfExpenseType(expenseTypeId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
		
	}
	public  Hospital removeExpenseTypeList(HisUserContext userContext, String hospitalId, 
			String expenseTypeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingExpenseTypeList(userContext, hospitalId,  expenseTypeIds, tokensExpr);
			
			
			Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
			synchronized(hospital){ 
				//Will be good when the hospital loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getHospitalDAO().planToRemoveExpenseTypeList(hospital, expenseTypeIds, allTokens());
				hospital = saveHospital(userContext, hospital, tokens().withExpenseTypeList().done());
				deleteRelationListInGraph(userContext, hospital.getExpenseTypeList());
				return present(userContext,hospital, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingExpenseType(HisUserContext userContext, String hospitalId, 
		String expenseTypeId, int expenseTypeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfHospital( hospitalId);
		userContext.getChecker().checkIdOfExpenseType(expenseTypeId);
		userContext.getChecker().checkVersionOfExpenseType(expenseTypeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
	
	}
	public  Hospital removeExpenseType(HisUserContext userContext, String hospitalId, 
		String expenseTypeId, int expenseTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingExpenseType(userContext,hospitalId, expenseTypeId, expenseTypeVersion,tokensExpr);
		
		ExpenseType expenseType = createIndexedExpenseType(expenseTypeId, expenseTypeVersion);
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){ 
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hospital.removeExpenseType( expenseType );		
			hospital = saveHospital(userContext, hospital, tokens().withExpenseTypeList().done());
			deleteRelationInGraph(userContext, expenseType);
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingExpenseType(HisUserContext userContext, String hospitalId, 
		String expenseTypeId, int expenseTypeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfHospital( hospitalId);
		userContext.getChecker().checkIdOfExpenseType(expenseTypeId);
		userContext.getChecker().checkVersionOfExpenseType(expenseTypeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
	
	}
	public  Hospital copyExpenseTypeFrom(HisUserContext userContext, String hospitalId, 
		String expenseTypeId, int expenseTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingExpenseType(userContext,hospitalId, expenseTypeId, expenseTypeVersion,tokensExpr);
		
		ExpenseType expenseType = createIndexedExpenseType(expenseTypeId, expenseTypeVersion);
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){ 
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			hospital.copyExpenseTypeFrom( expenseType );		
			hospital = saveHospital(userContext, hospital, tokens().withExpenseTypeList().done());
			
			userContext.getManagerGroup().getExpenseTypeManager().onNewInstanceCreated(userContext, (ExpenseType)hospital.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingExpenseType(HisUserContext userContext, String hospitalId, String expenseTypeId, int expenseTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfHospital(hospitalId);
		userContext.getChecker().checkIdOfExpenseType(expenseTypeId);
		userContext.getChecker().checkVersionOfExpenseType(expenseTypeVersion);
		

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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
	
	}
	
	public  Hospital updateExpenseType(HisUserContext userContext, String hospitalId, String expenseTypeId, int expenseTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingExpenseType(userContext, hospitalId, expenseTypeId, expenseTypeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withExpenseTypeList().searchExpenseTypeListWith(ExpenseType.ID_PROPERTY, "eq", expenseTypeId).done();
		
		
		
		Hospital hospital = loadHospital(userContext, hospitalId, loadTokens);
		
		synchronized(hospital){ 
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//hospital.removeExpenseType( expenseType );	
			//make changes to AcceleraterAccount.
			ExpenseType expenseTypeIndex = createIndexedExpenseType(expenseTypeId, expenseTypeVersion);
		
			ExpenseType expenseType = hospital.findTheExpenseType(expenseTypeIndex);
			if(expenseType == null){
				throw new HospitalManagerException(expenseType+" is NOT FOUND" );
			}
			
			expenseType.changeProperty(property, newValueExpr);
			
			hospital = saveHospital(userContext, hospital, tokens().withExpenseTypeList().done());
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingExpenseItem(HisUserContext userContext, String hospitalId, String name, BigDecimal price, String expenseTypeId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfHospital(hospitalId);

		
		userContext.getChecker().checkNameOfExpenseItem(name);
		
		userContext.getChecker().checkPriceOfExpenseItem(price);
		
		userContext.getChecker().checkExpenseTypeIdOfExpenseItem(expenseTypeId);
	
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);

	
	}
	public  Hospital addExpenseItem(HisUserContext userContext, String hospitalId, String name, BigDecimal price, String expenseTypeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingExpenseItem(userContext,hospitalId,name, price, expenseTypeId,tokensExpr);
		
		ExpenseItem expenseItem = createExpenseItem(userContext,name, price, expenseTypeId);
		
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){ 
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hospital.addExpenseItem( expenseItem );		
			hospital = saveHospital(userContext, hospital, tokens().withExpenseItemList().done());
			
			userContext.getManagerGroup().getExpenseItemManager().onNewInstanceCreated(userContext, expenseItem);
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingExpenseItemProperties(HisUserContext userContext, String hospitalId,String id,String name,BigDecimal price,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfHospital(hospitalId);
		userContext.getChecker().checkIdOfExpenseItem(id);
		
		userContext.getChecker().checkNameOfExpenseItem( name);
		userContext.getChecker().checkPriceOfExpenseItem( price);

		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
		
	}
	public  Hospital updateExpenseItemProperties(HisUserContext userContext, String hospitalId, String id,String name,BigDecimal price, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingExpenseItemProperties(userContext,hospitalId,id,name,price,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withExpenseItemListList()
				.searchExpenseItemListWith(ExpenseItem.ID_PROPERTY, "is", id).done();
		
		Hospital hospitalToUpdate = loadHospital(userContext, hospitalId, options);
		
		if(hospitalToUpdate.getExpenseItemList().isEmpty()){
			throw new HospitalManagerException("ExpenseItem is NOT FOUND with id: '"+id+"'");
		}
		
		ExpenseItem item = hospitalToUpdate.getExpenseItemList().first();
		
		item.updateName( name );
		item.updatePrice( price );

		
		//checkParamsForAddingExpenseItem(userContext,hospitalId,name, code, used,tokensExpr);
		Hospital hospital = saveHospital(userContext, hospitalToUpdate, tokens().withExpenseItemList().done());
		synchronized(hospital){ 
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ExpenseItem createExpenseItem(HisUserContext userContext, String name, BigDecimal price, String expenseTypeId) throws Exception{

		ExpenseItem expenseItem = new ExpenseItem();
		
		
		expenseItem.setName(name);		
		expenseItem.setPrice(price);		
		ExpenseType  expenseType = new ExpenseType();
		expenseType.setId(expenseTypeId);		
		expenseItem.setExpenseType(expenseType);
	
		
		return expenseItem;
	
		
	}
	
	protected ExpenseItem createIndexedExpenseItem(String id, int version){

		ExpenseItem expenseItem = new ExpenseItem();
		expenseItem.setId(id);
		expenseItem.setVersion(version);
		return expenseItem;			
		
	}
	
	protected void checkParamsForRemovingExpenseItemList(HisUserContext userContext, String hospitalId, 
			String expenseItemIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfHospital(hospitalId);
		for(String expenseItemId: expenseItemIds){
			userContext.getChecker().checkIdOfExpenseItem(expenseItemId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
		
	}
	public  Hospital removeExpenseItemList(HisUserContext userContext, String hospitalId, 
			String expenseItemIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingExpenseItemList(userContext, hospitalId,  expenseItemIds, tokensExpr);
			
			
			Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
			synchronized(hospital){ 
				//Will be good when the hospital loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getHospitalDAO().planToRemoveExpenseItemList(hospital, expenseItemIds, allTokens());
				hospital = saveHospital(userContext, hospital, tokens().withExpenseItemList().done());
				deleteRelationListInGraph(userContext, hospital.getExpenseItemList());
				return present(userContext,hospital, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingExpenseItem(HisUserContext userContext, String hospitalId, 
		String expenseItemId, int expenseItemVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfHospital( hospitalId);
		userContext.getChecker().checkIdOfExpenseItem(expenseItemId);
		userContext.getChecker().checkVersionOfExpenseItem(expenseItemVersion);
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
	
	}
	public  Hospital removeExpenseItem(HisUserContext userContext, String hospitalId, 
		String expenseItemId, int expenseItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingExpenseItem(userContext,hospitalId, expenseItemId, expenseItemVersion,tokensExpr);
		
		ExpenseItem expenseItem = createIndexedExpenseItem(expenseItemId, expenseItemVersion);
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){ 
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hospital.removeExpenseItem( expenseItem );		
			hospital = saveHospital(userContext, hospital, tokens().withExpenseItemList().done());
			deleteRelationInGraph(userContext, expenseItem);
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingExpenseItem(HisUserContext userContext, String hospitalId, 
		String expenseItemId, int expenseItemVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfHospital( hospitalId);
		userContext.getChecker().checkIdOfExpenseItem(expenseItemId);
		userContext.getChecker().checkVersionOfExpenseItem(expenseItemVersion);
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
	
	}
	public  Hospital copyExpenseItemFrom(HisUserContext userContext, String hospitalId, 
		String expenseItemId, int expenseItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingExpenseItem(userContext,hospitalId, expenseItemId, expenseItemVersion,tokensExpr);
		
		ExpenseItem expenseItem = createIndexedExpenseItem(expenseItemId, expenseItemVersion);
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){ 
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			hospital.copyExpenseItemFrom( expenseItem );		
			hospital = saveHospital(userContext, hospital, tokens().withExpenseItemList().done());
			
			userContext.getManagerGroup().getExpenseItemManager().onNewInstanceCreated(userContext, (ExpenseItem)hospital.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingExpenseItem(HisUserContext userContext, String hospitalId, String expenseItemId, int expenseItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfHospital(hospitalId);
		userContext.getChecker().checkIdOfExpenseItem(expenseItemId);
		userContext.getChecker().checkVersionOfExpenseItem(expenseItemVersion);
		

		if(ExpenseItem.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfExpenseItem(parseString(newValueExpr));
		}
		
		if(ExpenseItem.PRICE_PROPERTY.equals(property)){
			userContext.getChecker().checkPriceOfExpenseItem(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
	
	}
	
	public  Hospital updateExpenseItem(HisUserContext userContext, String hospitalId, String expenseItemId, int expenseItemVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingExpenseItem(userContext, hospitalId, expenseItemId, expenseItemVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withExpenseItemList().searchExpenseItemListWith(ExpenseItem.ID_PROPERTY, "eq", expenseItemId).done();
		
		
		
		Hospital hospital = loadHospital(userContext, hospitalId, loadTokens);
		
		synchronized(hospital){ 
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//hospital.removeExpenseItem( expenseItem );	
			//make changes to AcceleraterAccount.
			ExpenseItem expenseItemIndex = createIndexedExpenseItem(expenseItemId, expenseItemVersion);
		
			ExpenseItem expenseItem = hospital.findTheExpenseItem(expenseItemIndex);
			if(expenseItem == null){
				throw new HospitalManagerException(expenseItem+" is NOT FOUND" );
			}
			
			expenseItem.changeProperty(property, newValueExpr);
			
			hospital = saveHospital(userContext, hospital, tokens().withExpenseItemList().done());
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingDoctor(HisUserContext userContext, String hospitalId, String name,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfHospital(hospitalId);

		
		userContext.getChecker().checkNameOfDoctor(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);

	
	}
	public  Hospital addDoctor(HisUserContext userContext, String hospitalId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingDoctor(userContext,hospitalId,name,tokensExpr);
		
		Doctor doctor = createDoctor(userContext,name);
		
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){ 
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hospital.addDoctor( doctor );		
			hospital = saveHospital(userContext, hospital, tokens().withDoctorList().done());
			
			userContext.getManagerGroup().getDoctorManager().onNewInstanceCreated(userContext, doctor);
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingDoctorProperties(HisUserContext userContext, String hospitalId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfHospital(hospitalId);
		userContext.getChecker().checkIdOfDoctor(id);
		
		userContext.getChecker().checkNameOfDoctor( name);

		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
		
	}
	public  Hospital updateDoctorProperties(HisUserContext userContext, String hospitalId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingDoctorProperties(userContext,hospitalId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withDoctorListList()
				.searchDoctorListWith(Doctor.ID_PROPERTY, "is", id).done();
		
		Hospital hospitalToUpdate = loadHospital(userContext, hospitalId, options);
		
		if(hospitalToUpdate.getDoctorList().isEmpty()){
			throw new HospitalManagerException("Doctor is NOT FOUND with id: '"+id+"'");
		}
		
		Doctor item = hospitalToUpdate.getDoctorList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingDoctor(userContext,hospitalId,name, code, used,tokensExpr);
		Hospital hospital = saveHospital(userContext, hospitalToUpdate, tokens().withDoctorList().done());
		synchronized(hospital){ 
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Doctor createDoctor(HisUserContext userContext, String name) throws Exception{

		Doctor doctor = new Doctor();
		
		
		doctor.setName(name);
	
		
		return doctor;
	
		
	}
	
	protected Doctor createIndexedDoctor(String id, int version){

		Doctor doctor = new Doctor();
		doctor.setId(id);
		doctor.setVersion(version);
		return doctor;			
		
	}
	
	protected void checkParamsForRemovingDoctorList(HisUserContext userContext, String hospitalId, 
			String doctorIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfHospital(hospitalId);
		for(String doctorId: doctorIds){
			userContext.getChecker().checkIdOfDoctor(doctorId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
		
	}
	public  Hospital removeDoctorList(HisUserContext userContext, String hospitalId, 
			String doctorIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingDoctorList(userContext, hospitalId,  doctorIds, tokensExpr);
			
			
			Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
			synchronized(hospital){ 
				//Will be good when the hospital loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getHospitalDAO().planToRemoveDoctorList(hospital, doctorIds, allTokens());
				hospital = saveHospital(userContext, hospital, tokens().withDoctorList().done());
				deleteRelationListInGraph(userContext, hospital.getDoctorList());
				return present(userContext,hospital, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingDoctor(HisUserContext userContext, String hospitalId, 
		String doctorId, int doctorVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfHospital( hospitalId);
		userContext.getChecker().checkIdOfDoctor(doctorId);
		userContext.getChecker().checkVersionOfDoctor(doctorVersion);
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
	
	}
	public  Hospital removeDoctor(HisUserContext userContext, String hospitalId, 
		String doctorId, int doctorVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingDoctor(userContext,hospitalId, doctorId, doctorVersion,tokensExpr);
		
		Doctor doctor = createIndexedDoctor(doctorId, doctorVersion);
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){ 
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hospital.removeDoctor( doctor );		
			hospital = saveHospital(userContext, hospital, tokens().withDoctorList().done());
			deleteRelationInGraph(userContext, doctor);
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingDoctor(HisUserContext userContext, String hospitalId, 
		String doctorId, int doctorVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfHospital( hospitalId);
		userContext.getChecker().checkIdOfDoctor(doctorId);
		userContext.getChecker().checkVersionOfDoctor(doctorVersion);
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
	
	}
	public  Hospital copyDoctorFrom(HisUserContext userContext, String hospitalId, 
		String doctorId, int doctorVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingDoctor(userContext,hospitalId, doctorId, doctorVersion,tokensExpr);
		
		Doctor doctor = createIndexedDoctor(doctorId, doctorVersion);
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){ 
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			hospital.copyDoctorFrom( doctor );		
			hospital = saveHospital(userContext, hospital, tokens().withDoctorList().done());
			
			userContext.getManagerGroup().getDoctorManager().onNewInstanceCreated(userContext, (Doctor)hospital.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingDoctor(HisUserContext userContext, String hospitalId, String doctorId, int doctorVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfHospital(hospitalId);
		userContext.getChecker().checkIdOfDoctor(doctorId);
		userContext.getChecker().checkVersionOfDoctor(doctorVersion);
		

		if(Doctor.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfDoctor(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
	
	}
	
	public  Hospital updateDoctor(HisUserContext userContext, String hospitalId, String doctorId, int doctorVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingDoctor(userContext, hospitalId, doctorId, doctorVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withDoctorList().searchDoctorListWith(Doctor.ID_PROPERTY, "eq", doctorId).done();
		
		
		
		Hospital hospital = loadHospital(userContext, hospitalId, loadTokens);
		
		synchronized(hospital){ 
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//hospital.removeDoctor( doctor );	
			//make changes to AcceleraterAccount.
			Doctor doctorIndex = createIndexedDoctor(doctorId, doctorVersion);
		
			Doctor doctor = hospital.findTheDoctor(doctorIndex);
			if(doctor == null){
				throw new HospitalManagerException(doctor+" is NOT FOUND" );
			}
			
			doctor.changeProperty(property, newValueExpr);
			
			hospital = saveHospital(userContext, hospital, tokens().withDoctorList().done());
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingDepartment(HisUserContext userContext, String hospitalId, String name,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfHospital(hospitalId);

		
		userContext.getChecker().checkNameOfDepartment(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);

	
	}
	public  Hospital addDepartment(HisUserContext userContext, String hospitalId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingDepartment(userContext,hospitalId,name,tokensExpr);
		
		Department department = createDepartment(userContext,name);
		
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){ 
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hospital.addDepartment( department );		
			hospital = saveHospital(userContext, hospital, tokens().withDepartmentList().done());
			
			userContext.getManagerGroup().getDepartmentManager().onNewInstanceCreated(userContext, department);
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingDepartmentProperties(HisUserContext userContext, String hospitalId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfHospital(hospitalId);
		userContext.getChecker().checkIdOfDepartment(id);
		
		userContext.getChecker().checkNameOfDepartment( name);

		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
		
	}
	public  Hospital updateDepartmentProperties(HisUserContext userContext, String hospitalId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingDepartmentProperties(userContext,hospitalId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withDepartmentListList()
				.searchDepartmentListWith(Department.ID_PROPERTY, "is", id).done();
		
		Hospital hospitalToUpdate = loadHospital(userContext, hospitalId, options);
		
		if(hospitalToUpdate.getDepartmentList().isEmpty()){
			throw new HospitalManagerException("Department is NOT FOUND with id: '"+id+"'");
		}
		
		Department item = hospitalToUpdate.getDepartmentList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingDepartment(userContext,hospitalId,name, code, used,tokensExpr);
		Hospital hospital = saveHospital(userContext, hospitalToUpdate, tokens().withDepartmentList().done());
		synchronized(hospital){ 
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Department createDepartment(HisUserContext userContext, String name) throws Exception{

		Department department = new Department();
		
		
		department.setName(name);
	
		
		return department;
	
		
	}
	
	protected Department createIndexedDepartment(String id, int version){

		Department department = new Department();
		department.setId(id);
		department.setVersion(version);
		return department;			
		
	}
	
	protected void checkParamsForRemovingDepartmentList(HisUserContext userContext, String hospitalId, 
			String departmentIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfHospital(hospitalId);
		for(String departmentId: departmentIds){
			userContext.getChecker().checkIdOfDepartment(departmentId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
		
	}
	public  Hospital removeDepartmentList(HisUserContext userContext, String hospitalId, 
			String departmentIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingDepartmentList(userContext, hospitalId,  departmentIds, tokensExpr);
			
			
			Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
			synchronized(hospital){ 
				//Will be good when the hospital loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getHospitalDAO().planToRemoveDepartmentList(hospital, departmentIds, allTokens());
				hospital = saveHospital(userContext, hospital, tokens().withDepartmentList().done());
				deleteRelationListInGraph(userContext, hospital.getDepartmentList());
				return present(userContext,hospital, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingDepartment(HisUserContext userContext, String hospitalId, 
		String departmentId, int departmentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfHospital( hospitalId);
		userContext.getChecker().checkIdOfDepartment(departmentId);
		userContext.getChecker().checkVersionOfDepartment(departmentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
	
	}
	public  Hospital removeDepartment(HisUserContext userContext, String hospitalId, 
		String departmentId, int departmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingDepartment(userContext,hospitalId, departmentId, departmentVersion,tokensExpr);
		
		Department department = createIndexedDepartment(departmentId, departmentVersion);
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){ 
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hospital.removeDepartment( department );		
			hospital = saveHospital(userContext, hospital, tokens().withDepartmentList().done());
			deleteRelationInGraph(userContext, department);
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingDepartment(HisUserContext userContext, String hospitalId, 
		String departmentId, int departmentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfHospital( hospitalId);
		userContext.getChecker().checkIdOfDepartment(departmentId);
		userContext.getChecker().checkVersionOfDepartment(departmentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
	
	}
	public  Hospital copyDepartmentFrom(HisUserContext userContext, String hospitalId, 
		String departmentId, int departmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingDepartment(userContext,hospitalId, departmentId, departmentVersion,tokensExpr);
		
		Department department = createIndexedDepartment(departmentId, departmentVersion);
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){ 
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			hospital.copyDepartmentFrom( department );		
			hospital = saveHospital(userContext, hospital, tokens().withDepartmentList().done());
			
			userContext.getManagerGroup().getDepartmentManager().onNewInstanceCreated(userContext, (Department)hospital.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingDepartment(HisUserContext userContext, String hospitalId, String departmentId, int departmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfHospital(hospitalId);
		userContext.getChecker().checkIdOfDepartment(departmentId);
		userContext.getChecker().checkVersionOfDepartment(departmentVersion);
		

		if(Department.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfDepartment(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(HospitalManagerException.class);
	
	}
	
	public  Hospital updateDepartment(HisUserContext userContext, String hospitalId, String departmentId, int departmentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingDepartment(userContext, hospitalId, departmentId, departmentVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withDepartmentList().searchDepartmentListWith(Department.ID_PROPERTY, "eq", departmentId).done();
		
		
		
		Hospital hospital = loadHospital(userContext, hospitalId, loadTokens);
		
		synchronized(hospital){ 
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//hospital.removeDepartment( department );	
			//make changes to AcceleraterAccount.
			Department departmentIndex = createIndexedDepartment(departmentId, departmentVersion);
		
			Department department = hospital.findTheDepartment(departmentIndex);
			if(department == null){
				throw new HospitalManagerException(department+" is NOT FOUND" );
			}
			
			department.changeProperty(property, newValueExpr);
			
			hospital = saveHospital(userContext, hospital, tokens().withDepartmentList().done());
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(HisUserContext userContext, Hospital newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


