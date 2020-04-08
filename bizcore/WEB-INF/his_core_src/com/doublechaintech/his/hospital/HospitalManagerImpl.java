
package com.doublechaintech.his.hospital;

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


import com.doublechaintech.his.doctorschedule.DoctorSchedule;
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.expenseitem.ExpenseItem;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;


import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;






public class HospitalManagerImpl extends CustomHisCheckerManager implements HospitalManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "Hospital";
	@Override
	public HospitalDAO daoOf(HisUserContext userContext) {
		return hospitalDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfHospital(hospitalId);
		checkerOf(userContext).throwExceptionIfHasErrors( HospitalManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Hospital hospital = loadHospital( userContext, hospitalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,hospital, tokens);
 	}
 	
 	
 	 public Hospital searchHospital(HisUserContext userContext, String hospitalId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfHospital(hospitalId);
		checkerOf(userContext).throwExceptionIfHasErrors( HospitalManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Hospital hospital = loadHospital( userContext, hospitalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,hospital, tokens);
 	}
 	
 	

 	protected Hospital present(HisUserContext userContext, Hospital hospital, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,hospital,tokens);
		
		
		Hospital  hospitalToPresent = hospitalDaoOf(userContext).present(hospital, tokens);
		
		List<BaseEntity> entityListToNaming = hospitalToPresent.collectRefercencesFromLists();
		hospitalDaoOf(userContext).alias(entityListToNaming);
		
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
 		return hospitalDaoOf(userContext).save(hospital, tokens);
 	}
 	protected Hospital loadHospital(HisUserContext userContext, String hospitalId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfHospital(hospitalId);
		checkerOf(userContext).throwExceptionIfHasErrors( HospitalManagerException.class);

 
 		return hospitalDaoOf(userContext).load(hospitalId, tokens);
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
		addAction(userContext, hospital, tokens,"hospital.addPeriod","addPeriod","addPeriod/"+hospital.getId()+"/","periodList","primary");
		addAction(userContext, hospital, tokens,"hospital.removePeriod","removePeriod","removePeriod/"+hospital.getId()+"/","periodList","primary");
		addAction(userContext, hospital, tokens,"hospital.updatePeriod","updatePeriod","updatePeriod/"+hospital.getId()+"/","periodList","primary");
		addAction(userContext, hospital, tokens,"hospital.copyPeriodFrom","copyPeriodFrom","copyPeriodFrom/"+hospital.getId()+"/","periodList","primary");
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
		addAction(userContext, hospital, tokens,"hospital.addDoctorSchedule","addDoctorSchedule","addDoctorSchedule/"+hospital.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, hospital, tokens,"hospital.removeDoctorSchedule","removeDoctorSchedule","removeDoctorSchedule/"+hospital.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, hospital, tokens,"hospital.updateDoctorSchedule","updateDoctorSchedule","updateDoctorSchedule/"+hospital.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, hospital, tokens,"hospital.copyDoctorScheduleFrom","copyDoctorScheduleFrom","copyDoctorScheduleFrom/"+hospital.getId()+"/","doctorScheduleList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, Hospital hospital, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public Hospital createHospital(HisUserContext userContext, String name,String address,String telephone) throws Exception
	//public Hospital createHospital(HisUserContext userContext,String name, String address, String telephone) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfHospital(name);
		checkerOf(userContext).checkAddressOfHospital(address);
		checkerOf(userContext).checkTelephoneOfHospital(telephone);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfHospital(hospitalId);
		checkerOf(userContext).checkVersionOfHospital( hospitalVersion);
		

		if(Hospital.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfHospital(parseString(newValueExpr));
		
			
		}
		if(Hospital.ADDRESS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAddressOfHospital(parseString(newValueExpr));
		
			
		}
		if(Hospital.TELEPHONE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTelephoneOfHospital(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);


	}



	public Hospital clone(HisUserContext userContext, String fromHospitalId) throws Exception{

		return hospitalDaoOf(userContext).clone(fromHospitalId, this.allTokens());
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
			if (hospital.isChanged()){
			
			}
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
		.sortPeriodListWith("id","desc")
		.sortExpenseItemListWith("id","desc")
		.sortDoctorListWith("id","desc")
		.sortDepartmentListWith("id","desc")
		.sortDoctorScheduleListWith("id","desc")
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

		hospitalDaoOf(userContext).delete(hospitalId, hospitalVersion);
	}

	public Hospital forgetByAll(HisUserContext userContext, String hospitalId, int hospitalVersion) throws Exception {
		return forgetByAllInternal(userContext, hospitalId, hospitalVersion);
	}
	protected Hospital forgetByAllInternal(HisUserContext userContext,
			String hospitalId, int hospitalVersion) throws Exception{

		return hospitalDaoOf(userContext).disconnectFromAll(hospitalId, hospitalVersion);
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
		return hospitalDaoOf(userContext).deleteAll();
	}


	//disconnect Hospital with expense_type in ExpenseItem
	protected Hospital breakWithExpenseItemByExpenseType(HisUserContext userContext, String hospitalId, String expenseTypeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Hospital hospital = loadHospital(userContext, hospitalId, allTokens());

			synchronized(hospital){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				hospitalDaoOf(userContext).planToRemoveExpenseItemListWithExpenseType(hospital, expenseTypeId, this.emptyOptions());

				hospital = saveHospital(userContext, hospital, tokens().withExpenseItemList().done());
				return hospital;
			}
	}
	//disconnect Hospital with doctor in DoctorSchedule
	protected Hospital breakWithDoctorScheduleByDoctor(HisUserContext userContext, String hospitalId, String doctorId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Hospital hospital = loadHospital(userContext, hospitalId, allTokens());

			synchronized(hospital){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				hospitalDaoOf(userContext).planToRemoveDoctorScheduleListWithDoctor(hospital, doctorId, this.emptyOptions());

				hospital = saveHospital(userContext, hospital, tokens().withDoctorScheduleList().done());
				return hospital;
			}
	}
	//disconnect Hospital with period in DoctorSchedule
	protected Hospital breakWithDoctorScheduleByPeriod(HisUserContext userContext, String hospitalId, String periodId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Hospital hospital = loadHospital(userContext, hospitalId, allTokens());

			synchronized(hospital){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				hospitalDaoOf(userContext).planToRemoveDoctorScheduleListWithPeriod(hospital, periodId, this.emptyOptions());

				hospital = saveHospital(userContext, hospital, tokens().withDoctorScheduleList().done());
				return hospital;
			}
	}
	//disconnect Hospital with department in DoctorSchedule
	protected Hospital breakWithDoctorScheduleByDepartment(HisUserContext userContext, String hospitalId, String departmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Hospital hospital = loadHospital(userContext, hospitalId, allTokens());

			synchronized(hospital){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				hospitalDaoOf(userContext).planToRemoveDoctorScheduleListWithDepartment(hospital, departmentId, this.emptyOptions());

				hospital = saveHospital(userContext, hospital, tokens().withDoctorScheduleList().done());
				return hospital;
			}
	}
	//disconnect Hospital with expense_type in DoctorSchedule
	protected Hospital breakWithDoctorScheduleByExpenseType(HisUserContext userContext, String hospitalId, String expenseTypeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Hospital hospital = loadHospital(userContext, hospitalId, allTokens());

			synchronized(hospital){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				hospitalDaoOf(userContext).planToRemoveDoctorScheduleListWithExpenseType(hospital, expenseTypeId, this.emptyOptions());

				hospital = saveHospital(userContext, hospital, tokens().withDoctorScheduleList().done());
				return hospital;
			}
	}






	protected void checkParamsForAddingExpenseType(HisUserContext userContext, String hospitalId, String name, String helperChars, String status, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfHospital(hospitalId);

		
		checkerOf(userContext).checkNameOfExpenseType(name);
		
		checkerOf(userContext).checkHelperCharsOfExpenseType(helperChars);
		
		checkerOf(userContext).checkStatusOfExpenseType(status);
		
		checkerOf(userContext).checkDescriptionOfExpenseType(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);


	}
	public  Hospital addExpenseType(HisUserContext userContext, String hospitalId, String name, String helperChars, String status, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingExpenseType(userContext,hospitalId,name, helperChars, status, description,tokensExpr);

		ExpenseType expenseType = createExpenseType(userContext,name, helperChars, status, description);

		Hospital hospital = loadHospital(userContext, hospitalId, emptyOptions());
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

		checkerOf(userContext).checkIdOfHospital(hospitalId);
		checkerOf(userContext).checkIdOfExpenseType(id);

		checkerOf(userContext).checkNameOfExpenseType( name);
		checkerOf(userContext).checkHelperCharsOfExpenseType( helperChars);
		checkerOf(userContext).checkStatusOfExpenseType( status);
		checkerOf(userContext).checkDescriptionOfExpenseType( description);

		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

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
		expenseType.setUpdateTime(userContext.now());
	
		
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

		checkerOf(userContext).checkIdOfHospital(hospitalId);
		for(String expenseTypeIdItem: expenseTypeIds){
			checkerOf(userContext).checkIdOfExpenseType(expenseTypeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}
	public  Hospital removeExpenseTypeList(HisUserContext userContext, String hospitalId,
			String expenseTypeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingExpenseTypeList(userContext, hospitalId,  expenseTypeIds, tokensExpr);


			Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
			synchronized(hospital){
				//Will be good when the hospital loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				hospitalDaoOf(userContext).planToRemoveExpenseTypeList(hospital, expenseTypeIds, allTokens());
				hospital = saveHospital(userContext, hospital, tokens().withExpenseTypeList().done());
				deleteRelationListInGraph(userContext, hospital.getExpenseTypeList());
				return present(userContext,hospital, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingExpenseType(HisUserContext userContext, String hospitalId,
		String expenseTypeId, int expenseTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHospital( hospitalId);
		checkerOf(userContext).checkIdOfExpenseType(expenseTypeId);
		checkerOf(userContext).checkVersionOfExpenseType(expenseTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

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
		
		checkerOf(userContext).checkIdOfHospital( hospitalId);
		checkerOf(userContext).checkIdOfExpenseType(expenseTypeId);
		checkerOf(userContext).checkVersionOfExpenseType(expenseTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}
	public  Hospital copyExpenseTypeFrom(HisUserContext userContext, String hospitalId,
		String expenseTypeId, int expenseTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingExpenseType(userContext,hospitalId, expenseTypeId, expenseTypeVersion,tokensExpr);

		ExpenseType expenseType = createIndexedExpenseType(expenseTypeId, expenseTypeVersion);
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			expenseType.updateUpdateTime(userContext.now());

			hospital.copyExpenseTypeFrom( expenseType );
			hospital = saveHospital(userContext, hospital, tokens().withExpenseTypeList().done());
			
			userContext.getManagerGroup().getExpenseTypeManager().onNewInstanceCreated(userContext, (ExpenseType)hospital.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingExpenseType(HisUserContext userContext, String hospitalId, String expenseTypeId, int expenseTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfHospital(hospitalId);
		checkerOf(userContext).checkIdOfExpenseType(expenseTypeId);
		checkerOf(userContext).checkVersionOfExpenseType(expenseTypeVersion);
		

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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

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
			expenseType.updateUpdateTime(userContext.now());
			hospital = saveHospital(userContext, hospital, tokens().withExpenseTypeList().done());
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingPeriod(HisUserContext userContext, String hospitalId, String name, String code,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfHospital(hospitalId);

		
		checkerOf(userContext).checkNameOfPeriod(name);
		
		checkerOf(userContext).checkCodeOfPeriod(code);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);


	}
	public  Hospital addPeriod(HisUserContext userContext, String hospitalId, String name, String code, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingPeriod(userContext,hospitalId,name, code,tokensExpr);

		Period period = createPeriod(userContext,name, code);

		Hospital hospital = loadHospital(userContext, hospitalId, emptyOptions());
		synchronized(hospital){
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hospital.addPeriod( period );
			hospital = saveHospital(userContext, hospital, tokens().withPeriodList().done());
			
			userContext.getManagerGroup().getPeriodManager().onNewInstanceCreated(userContext, period);
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingPeriodProperties(HisUserContext userContext, String hospitalId,String id,String name,String code,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfHospital(hospitalId);
		checkerOf(userContext).checkIdOfPeriod(id);

		checkerOf(userContext).checkNameOfPeriod( name);
		checkerOf(userContext).checkCodeOfPeriod( code);

		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}
	public  Hospital updatePeriodProperties(HisUserContext userContext, String hospitalId, String id,String name,String code, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPeriodProperties(userContext,hospitalId,id,name,code,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withPeriodListList()
				.searchPeriodListWith(Period.ID_PROPERTY, "is", id).done();

		Hospital hospitalToUpdate = loadHospital(userContext, hospitalId, options);

		if(hospitalToUpdate.getPeriodList().isEmpty()){
			throw new HospitalManagerException("Period is NOT FOUND with id: '"+id+"'");
		}

		Period item = hospitalToUpdate.getPeriodList().first();

		item.updateName( name );
		item.updateCode( code );


		//checkParamsForAddingPeriod(userContext,hospitalId,name, code, used,tokensExpr);
		Hospital hospital = saveHospital(userContext, hospitalToUpdate, tokens().withPeriodList().done());
		synchronized(hospital){
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
	}


	protected Period createPeriod(HisUserContext userContext, String name, String code) throws Exception{

		Period period = new Period();
		
		
		period.setName(name);		
		period.setCode(code);
	
		
		return period;


	}

	protected Period createIndexedPeriod(String id, int version){

		Period period = new Period();
		period.setId(id);
		period.setVersion(version);
		return period;

	}

	protected void checkParamsForRemovingPeriodList(HisUserContext userContext, String hospitalId,
			String periodIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfHospital(hospitalId);
		for(String periodIdItem: periodIds){
			checkerOf(userContext).checkIdOfPeriod(periodIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}
	public  Hospital removePeriodList(HisUserContext userContext, String hospitalId,
			String periodIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingPeriodList(userContext, hospitalId,  periodIds, tokensExpr);


			Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
			synchronized(hospital){
				//Will be good when the hospital loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				hospitalDaoOf(userContext).planToRemovePeriodList(hospital, periodIds, allTokens());
				hospital = saveHospital(userContext, hospital, tokens().withPeriodList().done());
				deleteRelationListInGraph(userContext, hospital.getPeriodList());
				return present(userContext,hospital, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingPeriod(HisUserContext userContext, String hospitalId,
		String periodId, int periodVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHospital( hospitalId);
		checkerOf(userContext).checkIdOfPeriod(periodId);
		checkerOf(userContext).checkVersionOfPeriod(periodVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}
	public  Hospital removePeriod(HisUserContext userContext, String hospitalId,
		String periodId, int periodVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingPeriod(userContext,hospitalId, periodId, periodVersion,tokensExpr);

		Period period = createIndexedPeriod(periodId, periodVersion);
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hospital.removePeriod( period );
			hospital = saveHospital(userContext, hospital, tokens().withPeriodList().done());
			deleteRelationInGraph(userContext, period);
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingPeriod(HisUserContext userContext, String hospitalId,
		String periodId, int periodVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHospital( hospitalId);
		checkerOf(userContext).checkIdOfPeriod(periodId);
		checkerOf(userContext).checkVersionOfPeriod(periodVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}
	public  Hospital copyPeriodFrom(HisUserContext userContext, String hospitalId,
		String periodId, int periodVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingPeriod(userContext,hospitalId, periodId, periodVersion,tokensExpr);

		Period period = createIndexedPeriod(periodId, periodVersion);
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			hospital.copyPeriodFrom( period );
			hospital = saveHospital(userContext, hospital, tokens().withPeriodList().done());
			
			userContext.getManagerGroup().getPeriodManager().onNewInstanceCreated(userContext, (Period)hospital.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingPeriod(HisUserContext userContext, String hospitalId, String periodId, int periodVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfHospital(hospitalId);
		checkerOf(userContext).checkIdOfPeriod(periodId);
		checkerOf(userContext).checkVersionOfPeriod(periodVersion);
		

		if(Period.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfPeriod(parseString(newValueExpr));
		
		}
		
		if(Period.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfPeriod(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}

	public  Hospital updatePeriod(HisUserContext userContext, String hospitalId, String periodId, int periodVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingPeriod(userContext, hospitalId, periodId, periodVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withPeriodList().searchPeriodListWith(Period.ID_PROPERTY, "eq", periodId).done();



		Hospital hospital = loadHospital(userContext, hospitalId, loadTokens);

		synchronized(hospital){
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//hospital.removePeriod( period );
			//make changes to AcceleraterAccount.
			Period periodIndex = createIndexedPeriod(periodId, periodVersion);

			Period period = hospital.findThePeriod(periodIndex);
			if(period == null){
				throw new HospitalManagerException(period+" is NOT FOUND" );
			}

			period.changeProperty(property, newValueExpr);
			
			hospital = saveHospital(userContext, hospital, tokens().withPeriodList().done());
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingExpenseItem(HisUserContext userContext, String hospitalId, String name, BigDecimal price, String expenseTypeId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfHospital(hospitalId);

		
		checkerOf(userContext).checkNameOfExpenseItem(name);
		
		checkerOf(userContext).checkPriceOfExpenseItem(price);
		
		checkerOf(userContext).checkExpenseTypeIdOfExpenseItem(expenseTypeId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);


	}
	public  Hospital addExpenseItem(HisUserContext userContext, String hospitalId, String name, BigDecimal price, String expenseTypeId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingExpenseItem(userContext,hospitalId,name, price, expenseTypeId,tokensExpr);

		ExpenseItem expenseItem = createExpenseItem(userContext,name, price, expenseTypeId);

		Hospital hospital = loadHospital(userContext, hospitalId, emptyOptions());
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

		checkerOf(userContext).checkIdOfHospital(hospitalId);
		checkerOf(userContext).checkIdOfExpenseItem(id);

		checkerOf(userContext).checkNameOfExpenseItem( name);
		checkerOf(userContext).checkPriceOfExpenseItem( price);

		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

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
		expenseItem.setUpdateTime(userContext.now());
	
		
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

		checkerOf(userContext).checkIdOfHospital(hospitalId);
		for(String expenseItemIdItem: expenseItemIds){
			checkerOf(userContext).checkIdOfExpenseItem(expenseItemIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}
	public  Hospital removeExpenseItemList(HisUserContext userContext, String hospitalId,
			String expenseItemIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingExpenseItemList(userContext, hospitalId,  expenseItemIds, tokensExpr);


			Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
			synchronized(hospital){
				//Will be good when the hospital loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				hospitalDaoOf(userContext).planToRemoveExpenseItemList(hospital, expenseItemIds, allTokens());
				hospital = saveHospital(userContext, hospital, tokens().withExpenseItemList().done());
				deleteRelationListInGraph(userContext, hospital.getExpenseItemList());
				return present(userContext,hospital, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingExpenseItem(HisUserContext userContext, String hospitalId,
		String expenseItemId, int expenseItemVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHospital( hospitalId);
		checkerOf(userContext).checkIdOfExpenseItem(expenseItemId);
		checkerOf(userContext).checkVersionOfExpenseItem(expenseItemVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

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
		
		checkerOf(userContext).checkIdOfHospital( hospitalId);
		checkerOf(userContext).checkIdOfExpenseItem(expenseItemId);
		checkerOf(userContext).checkVersionOfExpenseItem(expenseItemVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}
	public  Hospital copyExpenseItemFrom(HisUserContext userContext, String hospitalId,
		String expenseItemId, int expenseItemVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingExpenseItem(userContext,hospitalId, expenseItemId, expenseItemVersion,tokensExpr);

		ExpenseItem expenseItem = createIndexedExpenseItem(expenseItemId, expenseItemVersion);
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			expenseItem.updateUpdateTime(userContext.now());

			hospital.copyExpenseItemFrom( expenseItem );
			hospital = saveHospital(userContext, hospital, tokens().withExpenseItemList().done());
			
			userContext.getManagerGroup().getExpenseItemManager().onNewInstanceCreated(userContext, (ExpenseItem)hospital.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingExpenseItem(HisUserContext userContext, String hospitalId, String expenseItemId, int expenseItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfHospital(hospitalId);
		checkerOf(userContext).checkIdOfExpenseItem(expenseItemId);
		checkerOf(userContext).checkVersionOfExpenseItem(expenseItemVersion);
		

		if(ExpenseItem.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfExpenseItem(parseString(newValueExpr));
		
		}
		
		if(ExpenseItem.PRICE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPriceOfExpenseItem(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

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
			expenseItem.updateUpdateTime(userContext.now());
			hospital = saveHospital(userContext, hospital, tokens().withExpenseItemList().done());
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingDoctor(HisUserContext userContext, String hospitalId, String name, String shotImage,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfHospital(hospitalId);

		
		checkerOf(userContext).checkNameOfDoctor(name);
		
		checkerOf(userContext).checkShotImageOfDoctor(shotImage);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);


	}
	public  Hospital addDoctor(HisUserContext userContext, String hospitalId, String name, String shotImage, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingDoctor(userContext,hospitalId,name, shotImage,tokensExpr);

		Doctor doctor = createDoctor(userContext,name, shotImage);

		Hospital hospital = loadHospital(userContext, hospitalId, emptyOptions());
		synchronized(hospital){
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hospital.addDoctor( doctor );
			hospital = saveHospital(userContext, hospital, tokens().withDoctorList().done());
			
			userContext.getManagerGroup().getDoctorManager().onNewInstanceCreated(userContext, doctor);
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingDoctorProperties(HisUserContext userContext, String hospitalId,String id,String name,String shotImage,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfHospital(hospitalId);
		checkerOf(userContext).checkIdOfDoctor(id);

		checkerOf(userContext).checkNameOfDoctor( name);
		checkerOf(userContext).checkShotImageOfDoctor( shotImage);

		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}
	public  Hospital updateDoctorProperties(HisUserContext userContext, String hospitalId, String id,String name,String shotImage, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingDoctorProperties(userContext,hospitalId,id,name,shotImage,tokensExpr);

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
		item.updateShotImage( shotImage );


		//checkParamsForAddingDoctor(userContext,hospitalId,name, code, used,tokensExpr);
		Hospital hospital = saveHospital(userContext, hospitalToUpdate, tokens().withDoctorList().done());
		synchronized(hospital){
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
	}


	protected Doctor createDoctor(HisUserContext userContext, String name, String shotImage) throws Exception{

		Doctor doctor = new Doctor();
		
		
		doctor.setName(name);		
		doctor.setShotImage(shotImage);		
		doctor.setUpdateTime(userContext.now());
	
		
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

		checkerOf(userContext).checkIdOfHospital(hospitalId);
		for(String doctorIdItem: doctorIds){
			checkerOf(userContext).checkIdOfDoctor(doctorIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}
	public  Hospital removeDoctorList(HisUserContext userContext, String hospitalId,
			String doctorIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingDoctorList(userContext, hospitalId,  doctorIds, tokensExpr);


			Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
			synchronized(hospital){
				//Will be good when the hospital loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				hospitalDaoOf(userContext).planToRemoveDoctorList(hospital, doctorIds, allTokens());
				hospital = saveHospital(userContext, hospital, tokens().withDoctorList().done());
				deleteRelationListInGraph(userContext, hospital.getDoctorList());
				return present(userContext,hospital, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingDoctor(HisUserContext userContext, String hospitalId,
		String doctorId, int doctorVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHospital( hospitalId);
		checkerOf(userContext).checkIdOfDoctor(doctorId);
		checkerOf(userContext).checkVersionOfDoctor(doctorVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

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
		
		checkerOf(userContext).checkIdOfHospital( hospitalId);
		checkerOf(userContext).checkIdOfDoctor(doctorId);
		checkerOf(userContext).checkVersionOfDoctor(doctorVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}
	public  Hospital copyDoctorFrom(HisUserContext userContext, String hospitalId,
		String doctorId, int doctorVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingDoctor(userContext,hospitalId, doctorId, doctorVersion,tokensExpr);

		Doctor doctor = createIndexedDoctor(doctorId, doctorVersion);
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			doctor.updateUpdateTime(userContext.now());

			hospital.copyDoctorFrom( doctor );
			hospital = saveHospital(userContext, hospital, tokens().withDoctorList().done());
			
			userContext.getManagerGroup().getDoctorManager().onNewInstanceCreated(userContext, (Doctor)hospital.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingDoctor(HisUserContext userContext, String hospitalId, String doctorId, int doctorVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfHospital(hospitalId);
		checkerOf(userContext).checkIdOfDoctor(doctorId);
		checkerOf(userContext).checkVersionOfDoctor(doctorVersion);
		

		if(Doctor.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfDoctor(parseString(newValueExpr));
		
		}
		
		if(Doctor.SHOT_IMAGE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkShotImageOfDoctor(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

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
			doctor.updateUpdateTime(userContext.now());
			hospital = saveHospital(userContext, hospital, tokens().withDoctorList().done());
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingDepartment(HisUserContext userContext, String hospitalId, String name,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfHospital(hospitalId);

		
		checkerOf(userContext).checkNameOfDepartment(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);


	}
	public  Hospital addDepartment(HisUserContext userContext, String hospitalId, String name, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingDepartment(userContext,hospitalId,name,tokensExpr);

		Department department = createDepartment(userContext,name);

		Hospital hospital = loadHospital(userContext, hospitalId, emptyOptions());
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

		checkerOf(userContext).checkIdOfHospital(hospitalId);
		checkerOf(userContext).checkIdOfDepartment(id);

		checkerOf(userContext).checkNameOfDepartment( name);

		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

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
		department.setUpdateTime(userContext.now());
	
		
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

		checkerOf(userContext).checkIdOfHospital(hospitalId);
		for(String departmentIdItem: departmentIds){
			checkerOf(userContext).checkIdOfDepartment(departmentIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}
	public  Hospital removeDepartmentList(HisUserContext userContext, String hospitalId,
			String departmentIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingDepartmentList(userContext, hospitalId,  departmentIds, tokensExpr);


			Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
			synchronized(hospital){
				//Will be good when the hospital loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				hospitalDaoOf(userContext).planToRemoveDepartmentList(hospital, departmentIds, allTokens());
				hospital = saveHospital(userContext, hospital, tokens().withDepartmentList().done());
				deleteRelationListInGraph(userContext, hospital.getDepartmentList());
				return present(userContext,hospital, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingDepartment(HisUserContext userContext, String hospitalId,
		String departmentId, int departmentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHospital( hospitalId);
		checkerOf(userContext).checkIdOfDepartment(departmentId);
		checkerOf(userContext).checkVersionOfDepartment(departmentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

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
		
		checkerOf(userContext).checkIdOfHospital( hospitalId);
		checkerOf(userContext).checkIdOfDepartment(departmentId);
		checkerOf(userContext).checkVersionOfDepartment(departmentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}
	public  Hospital copyDepartmentFrom(HisUserContext userContext, String hospitalId,
		String departmentId, int departmentVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingDepartment(userContext,hospitalId, departmentId, departmentVersion,tokensExpr);

		Department department = createIndexedDepartment(departmentId, departmentVersion);
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			department.updateUpdateTime(userContext.now());

			hospital.copyDepartmentFrom( department );
			hospital = saveHospital(userContext, hospital, tokens().withDepartmentList().done());
			
			userContext.getManagerGroup().getDepartmentManager().onNewInstanceCreated(userContext, (Department)hospital.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingDepartment(HisUserContext userContext, String hospitalId, String departmentId, int departmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfHospital(hospitalId);
		checkerOf(userContext).checkIdOfDepartment(departmentId);
		checkerOf(userContext).checkVersionOfDepartment(departmentVersion);
		

		if(Department.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfDepartment(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

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
			department.updateUpdateTime(userContext.now());
			hospital = saveHospital(userContext, hospital, tokens().withDepartmentList().done());
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingDoctorSchedule(HisUserContext userContext, String hospitalId, String name, String doctorId, Date scheduleDate, String periodId, String departmentId, int available, BigDecimal price, String expenseTypeId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfHospital(hospitalId);

		
		checkerOf(userContext).checkNameOfDoctorSchedule(name);
		
		checkerOf(userContext).checkDoctorIdOfDoctorSchedule(doctorId);
		
		checkerOf(userContext).checkScheduleDateOfDoctorSchedule(scheduleDate);
		
		checkerOf(userContext).checkPeriodIdOfDoctorSchedule(periodId);
		
		checkerOf(userContext).checkDepartmentIdOfDoctorSchedule(departmentId);
		
		checkerOf(userContext).checkAvailableOfDoctorSchedule(available);
		
		checkerOf(userContext).checkPriceOfDoctorSchedule(price);
		
		checkerOf(userContext).checkExpenseTypeIdOfDoctorSchedule(expenseTypeId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);


	}
	public  Hospital addDoctorSchedule(HisUserContext userContext, String hospitalId, String name, String doctorId, Date scheduleDate, String periodId, String departmentId, int available, BigDecimal price, String expenseTypeId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingDoctorSchedule(userContext,hospitalId,name, doctorId, scheduleDate, periodId, departmentId, available, price, expenseTypeId,tokensExpr);

		DoctorSchedule doctorSchedule = createDoctorSchedule(userContext,name, doctorId, scheduleDate, periodId, departmentId, available, price, expenseTypeId);

		Hospital hospital = loadHospital(userContext, hospitalId, emptyOptions());
		synchronized(hospital){
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hospital.addDoctorSchedule( doctorSchedule );
			hospital = saveHospital(userContext, hospital, tokens().withDoctorScheduleList().done());
			
			userContext.getManagerGroup().getDoctorScheduleManager().onNewInstanceCreated(userContext, doctorSchedule);
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingDoctorScheduleProperties(HisUserContext userContext, String hospitalId,String id,String name,Date scheduleDate,int available,BigDecimal price,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfHospital(hospitalId);
		checkerOf(userContext).checkIdOfDoctorSchedule(id);

		checkerOf(userContext).checkNameOfDoctorSchedule( name);
		checkerOf(userContext).checkScheduleDateOfDoctorSchedule( scheduleDate);
		checkerOf(userContext).checkAvailableOfDoctorSchedule( available);
		checkerOf(userContext).checkPriceOfDoctorSchedule( price);

		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}
	public  Hospital updateDoctorScheduleProperties(HisUserContext userContext, String hospitalId, String id,String name,Date scheduleDate,int available,BigDecimal price, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingDoctorScheduleProperties(userContext,hospitalId,id,name,scheduleDate,available,price,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withDoctorScheduleListList()
				.searchDoctorScheduleListWith(DoctorSchedule.ID_PROPERTY, "is", id).done();

		Hospital hospitalToUpdate = loadHospital(userContext, hospitalId, options);

		if(hospitalToUpdate.getDoctorScheduleList().isEmpty()){
			throw new HospitalManagerException("DoctorSchedule is NOT FOUND with id: '"+id+"'");
		}

		DoctorSchedule item = hospitalToUpdate.getDoctorScheduleList().first();

		item.updateName( name );
		item.updateScheduleDate( scheduleDate );
		item.updateAvailable( available );
		item.updatePrice( price );


		//checkParamsForAddingDoctorSchedule(userContext,hospitalId,name, code, used,tokensExpr);
		Hospital hospital = saveHospital(userContext, hospitalToUpdate, tokens().withDoctorScheduleList().done());
		synchronized(hospital){
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}
	}


	protected DoctorSchedule createDoctorSchedule(HisUserContext userContext, String name, String doctorId, Date scheduleDate, String periodId, String departmentId, int available, BigDecimal price, String expenseTypeId) throws Exception{

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
		ExpenseType  expenseType = new ExpenseType();
		expenseType.setId(expenseTypeId);		
		doctorSchedule.setExpenseType(expenseType);		
		doctorSchedule.setCreateTime(userContext.now());		
		doctorSchedule.setUpdateTime(userContext.now());
	
		
		return doctorSchedule;


	}

	protected DoctorSchedule createIndexedDoctorSchedule(String id, int version){

		DoctorSchedule doctorSchedule = new DoctorSchedule();
		doctorSchedule.setId(id);
		doctorSchedule.setVersion(version);
		return doctorSchedule;

	}

	protected void checkParamsForRemovingDoctorScheduleList(HisUserContext userContext, String hospitalId,
			String doctorScheduleIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfHospital(hospitalId);
		for(String doctorScheduleIdItem: doctorScheduleIds){
			checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}
	public  Hospital removeDoctorScheduleList(HisUserContext userContext, String hospitalId,
			String doctorScheduleIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingDoctorScheduleList(userContext, hospitalId,  doctorScheduleIds, tokensExpr);


			Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
			synchronized(hospital){
				//Will be good when the hospital loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				hospitalDaoOf(userContext).planToRemoveDoctorScheduleList(hospital, doctorScheduleIds, allTokens());
				hospital = saveHospital(userContext, hospital, tokens().withDoctorScheduleList().done());
				deleteRelationListInGraph(userContext, hospital.getDoctorScheduleList());
				return present(userContext,hospital, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingDoctorSchedule(HisUserContext userContext, String hospitalId,
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHospital( hospitalId);
		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
		checkerOf(userContext).checkVersionOfDoctorSchedule(doctorScheduleVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}
	public  Hospital removeDoctorSchedule(HisUserContext userContext, String hospitalId,
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingDoctorSchedule(userContext,hospitalId, doctorScheduleId, doctorScheduleVersion,tokensExpr);

		DoctorSchedule doctorSchedule = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hospital.removeDoctorSchedule( doctorSchedule );
			hospital = saveHospital(userContext, hospital, tokens().withDoctorScheduleList().done());
			deleteRelationInGraph(userContext, doctorSchedule);
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingDoctorSchedule(HisUserContext userContext, String hospitalId,
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHospital( hospitalId);
		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
		checkerOf(userContext).checkVersionOfDoctorSchedule(doctorScheduleVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}
	public  Hospital copyDoctorScheduleFrom(HisUserContext userContext, String hospitalId,
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingDoctorSchedule(userContext,hospitalId, doctorScheduleId, doctorScheduleVersion,tokensExpr);

		DoctorSchedule doctorSchedule = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);
		Hospital hospital = loadHospital(userContext, hospitalId, allTokens());
		synchronized(hospital){
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			doctorSchedule.updateUpdateTime(userContext.now());

			hospital.copyDoctorScheduleFrom( doctorSchedule );
			hospital = saveHospital(userContext, hospital, tokens().withDoctorScheduleList().done());
			
			userContext.getManagerGroup().getDoctorScheduleManager().onNewInstanceCreated(userContext, (DoctorSchedule)hospital.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingDoctorSchedule(HisUserContext userContext, String hospitalId, String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfHospital(hospitalId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(HospitalManagerException.class);

	}

	public  Hospital updateDoctorSchedule(HisUserContext userContext, String hospitalId, String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingDoctorSchedule(userContext, hospitalId, doctorScheduleId, doctorScheduleVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withDoctorScheduleList().searchDoctorScheduleListWith(DoctorSchedule.ID_PROPERTY, "eq", doctorScheduleId).done();



		Hospital hospital = loadHospital(userContext, hospitalId, loadTokens);

		synchronized(hospital){
			//Will be good when the hospital loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//hospital.removeDoctorSchedule( doctorSchedule );
			//make changes to AcceleraterAccount.
			DoctorSchedule doctorScheduleIndex = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);

			DoctorSchedule doctorSchedule = hospital.findTheDoctorSchedule(doctorScheduleIndex);
			if(doctorSchedule == null){
				throw new HospitalManagerException(doctorSchedule+" is NOT FOUND" );
			}

			doctorSchedule.changeProperty(property, newValueExpr);
			doctorSchedule.updateUpdateTime(userContext.now());
			hospital = saveHospital(userContext, hospital, tokens().withDoctorScheduleList().done());
			return present(userContext,hospital, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(HisUserContext userContext, Hospital newCreated) throws Exception{
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
		//   Hospital newHospital = this.createHospital(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newHospital
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Hospital.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(HisUserContext userContext,SmartList<Hospital> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}


    }
	
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(HisUserContext userContext, String hospitalId) throws Exception{
	  SerializeScope vscope = HisViewScope.getInstance().getHospitalDetailScope().clone();
		Hospital merchantObj = (Hospital) this.view(userContext, hospitalId);
    String merchantObjId = hospitalId;
    String linkToUrl =	"hospitalManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "医院"+"详情";
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
				MapUtil.put("id", "3-address")
				    .put("fieldName", "address")
				    .put("label", "地址")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("address", merchantObj.getAddress());

		propList.add(
				MapUtil.put("id", "4-telephone")
				    .put("fieldName", "telephone")
				    .put("label", "电话")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("telephone", merchantObj.getTelephone());

		//处理 sectionList

		//处理Section：doctorListSection
		Map doctorListSection = ListofUtils.buildSection(
		    "doctorListSection",
		    "医生列表",
		    null,
		    "",
		    "__no_group",
		    "doctorManager/listByHospital/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(doctorListSection);

		result.put("doctorListSection", ListofUtils.toShortList(merchantObj.getDoctorList(), "doctor"));
		vscope.field("doctorListSection", HisListOfViewScope.getInstance()
					.getListOfViewScope( Doctor.class.getName(), null));

		//处理Section：doctorScheduleListSection
		Map doctorScheduleListSection = ListofUtils.buildSection(
		    "doctorScheduleListSection",
		    "医生安排列表",
		    null,
		    "",
		    "__no_group",
		    "doctorScheduleManager/listByHospital/"+merchantObjId+"/",
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


