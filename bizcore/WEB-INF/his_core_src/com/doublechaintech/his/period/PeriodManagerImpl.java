
package com.doublechaintech.his.period;

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

import com.doublechaintech.his.hospital.CandidateHospital;

import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;






public class PeriodManagerImpl extends CustomHisCheckerManager implements PeriodManager {
	
	private static final String SERVICE_TYPE = "Period";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws PeriodManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new PeriodManagerException(message);

	}
	
	

 	protected Period savePeriod(HisUserContext userContext, Period period, String [] tokensExpr) throws Exception{	
 		//return getPeriodDAO().save(period, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePeriod(userContext, period, tokens);
 	}
 	
 	protected Period savePeriodDetail(HisUserContext userContext, Period period) throws Exception{	

 		
 		return savePeriod(userContext, period, allTokens());
 	}
 	
 	public Period loadPeriod(HisUserContext userContext, String periodId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPeriod(periodId);
		userContext.getChecker().throwExceptionIfHasErrors( PeriodManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Period period = loadPeriod( userContext, periodId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,period, tokens);
 	}
 	
 	
 	 public Period searchPeriod(HisUserContext userContext, String periodId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPeriod(periodId);
		userContext.getChecker().throwExceptionIfHasErrors( PeriodManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Period period = loadPeriod( userContext, periodId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,period, tokens);
 	}
 	
 	

 	protected Period present(HisUserContext userContext, Period period, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,period,tokens);
		
		
		Period  periodToPresent = userContext.getDAOGroup().getPeriodDAO().present(period, tokens);
		
		List<BaseEntity> entityListToNaming = periodToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getPeriodDAO().alias(entityListToNaming);
		
		return  periodToPresent;
		
		
	}
 
 	
 	
 	public Period loadPeriodDetail(HisUserContext userContext, String periodId) throws Exception{	
 		Period period = loadPeriod( userContext, periodId, allTokens());
 		return present(userContext,period, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String periodId) throws Exception{	
 		Period period = loadPeriod( userContext, periodId, viewTokens());
 		return present(userContext,period, allTokens());
		
 	}
 	protected Period savePeriod(HisUserContext userContext, Period period, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getPeriodDAO().save(period, tokens);
 	}
 	protected Period loadPeriod(HisUserContext userContext, String periodId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfPeriod(periodId);
		userContext.getChecker().throwExceptionIfHasErrors( PeriodManagerException.class);

 
 		return userContext.getDAOGroup().getPeriodDAO().load(periodId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, Period period, Map<String, Object> tokens){
		super.addActions(userContext, period, tokens);
		
		addAction(userContext, period, tokens,"@create","createPeriod","createPeriod/","main","primary");
		addAction(userContext, period, tokens,"@update","updatePeriod","updatePeriod/"+period.getId()+"/","main","primary");
		addAction(userContext, period, tokens,"@copy","clonePeriod","clonePeriod/"+period.getId()+"/","main","primary");
		
		addAction(userContext, period, tokens,"period.transfer_to_hospital","transferToAnotherHospital","transferToAnotherHospital/"+period.getId()+"/","main","primary");
		addAction(userContext, period, tokens,"period.addDoctorSchedule","addDoctorSchedule","addDoctorSchedule/"+period.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, period, tokens,"period.removeDoctorSchedule","removeDoctorSchedule","removeDoctorSchedule/"+period.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, period, tokens,"period.updateDoctorSchedule","updateDoctorSchedule","updateDoctorSchedule/"+period.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, period, tokens,"period.copyDoctorScheduleFrom","copyDoctorScheduleFrom","copyDoctorScheduleFrom/"+period.getId()+"/","doctorScheduleList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, Period period, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Period createPeriod(HisUserContext userContext,String name, String hospitalId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfPeriod(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(PeriodManagerException.class);


		Period period=createNewPeriod();	

		period.setName(name);
			
		Hospital hospital = loadHospital(userContext, hospitalId,emptyOptions());
		period.setHospital(hospital);
		
		

		period = savePeriod(userContext, period, emptyOptions());
		
		onNewInstanceCreated(userContext, period);
		return period;

		
	}
	protected Period createNewPeriod() 
	{
		
		return new Period();		
	}
	
	protected void checkParamsForUpdatingPeriod(HisUserContext userContext,String periodId, int periodVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfPeriod(periodId);
		userContext.getChecker().checkVersionOfPeriod( periodVersion);
		

		if(Period.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfPeriod(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(PeriodManagerException.class);
	
		
	}
	
	
	
	public Period clone(HisUserContext userContext, String fromPeriodId) throws Exception{
		
		return userContext.getDAOGroup().getPeriodDAO().clone(fromPeriodId, this.allTokens());
	}
	
	public Period internalSavePeriod(HisUserContext userContext, Period period) throws Exception 
	{
		return internalSavePeriod(userContext, period, allTokens());

	}
	public Period internalSavePeriod(HisUserContext userContext, Period period, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingPeriod(userContext, periodId, periodVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(period){ 
			//will be good when the period loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Period.
			if (period.isChanged()){
			
			}
			period = savePeriod(userContext, period, options);
			return period;
			
		}

	}
	
	public Period updatePeriod(HisUserContext userContext,String periodId, int periodVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPeriod(userContext, periodId, periodVersion, property, newValueExpr, tokensExpr);
		
		
		
		Period period = loadPeriod(userContext, periodId, allTokens());
		if(period.getVersion() != periodVersion){
			String message = "The target version("+period.getVersion()+") is not equals to version("+periodVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(period){ 
			//will be good when the period loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Period.
			
			period.changeProperty(property, newValueExpr);
			period = savePeriod(userContext, period, tokens().done());
			return present(userContext,period, mergedAllTokens(tokensExpr));
			//return savePeriod(userContext, period, tokens().done());
		}

	}
	
	public Period updatePeriodProperty(HisUserContext userContext,String periodId, int periodVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPeriod(userContext, periodId, periodVersion, property, newValueExpr, tokensExpr);
		
		Period period = loadPeriod(userContext, periodId, allTokens());
		if(period.getVersion() != periodVersion){
			String message = "The target version("+period.getVersion()+") is not equals to version("+periodVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(period){ 
			//will be good when the period loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Period.
			
			period.changeProperty(property, newValueExpr);
			
			period = savePeriod(userContext, period, tokens().done());
			return present(userContext,period, mergedAllTokens(tokensExpr));
			//return savePeriod(userContext, period, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PeriodTokens tokens(){
		return PeriodTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PeriodTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortDoctorScheduleListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PeriodTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherHospital(HisUserContext userContext, String periodId, String anotherHospitalId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfPeriod(periodId);
 		userContext.getChecker().checkIdOfHospital(anotherHospitalId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(PeriodManagerException.class);
 		
 	}
 	public Period transferToAnotherHospital(HisUserContext userContext, String periodId, String anotherHospitalId) throws Exception
 	{
 		checkParamsForTransferingAnotherHospital(userContext, periodId,anotherHospitalId);
 
		Period period = loadPeriod(userContext, periodId, allTokens());	
		synchronized(period){
			//will be good when the period loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Hospital hospital = loadHospital(userContext, anotherHospitalId, emptyOptions());		
			period.updateHospital(hospital);		
			period = savePeriod(userContext, period, emptyOptions());
			
			return present(userContext,period, allTokens());
			
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
		SmartList<Hospital> candidateList = userContext.getDAOGroup().getHospitalDAO().requestCandidateHospitalForPeriod(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(HisUserContext userContext, String periodId, int periodVersion) throws Exception {
		//deleteInternal(userContext, periodId, periodVersion);		
	}
	protected void deleteInternal(HisUserContext userContext,
			String periodId, int periodVersion) throws Exception{
			
		userContext.getDAOGroup().getPeriodDAO().delete(periodId, periodVersion);
	}
	
	public Period forgetByAll(HisUserContext userContext, String periodId, int periodVersion) throws Exception {
		return forgetByAllInternal(userContext, periodId, periodVersion);		
	}
	protected Period forgetByAllInternal(HisUserContext userContext,
			String periodId, int periodVersion) throws Exception{
			
		return userContext.getDAOGroup().getPeriodDAO().disconnectFromAll(periodId, periodVersion);
	}
	

	
	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PeriodManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getPeriodDAO().deleteAll();
	}


	//disconnect Period with doctor in DoctorSchedule
	protected Period breakWithDoctorScheduleByDoctor(HisUserContext userContext, String periodId, String doctorId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Period period = loadPeriod(userContext, periodId, allTokens());

			synchronized(period){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPeriodDAO().planToRemoveDoctorScheduleListWithDoctor(period, doctorId, this.emptyOptions());

				period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
				return period;
			}
	}
	//disconnect Period with department in DoctorSchedule
	protected Period breakWithDoctorScheduleByDepartment(HisUserContext userContext, String periodId, String departmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Period period = loadPeriod(userContext, periodId, allTokens());

			synchronized(period){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPeriodDAO().planToRemoveDoctorScheduleListWithDepartment(period, departmentId, this.emptyOptions());

				period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
				return period;
			}
	}
	//disconnect Period with expense_type in DoctorSchedule
	protected Period breakWithDoctorScheduleByExpenseType(HisUserContext userContext, String periodId, String expenseTypeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Period period = loadPeriod(userContext, periodId, allTokens());

			synchronized(period){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPeriodDAO().planToRemoveDoctorScheduleListWithExpenseType(period, expenseTypeId, this.emptyOptions());

				period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
				return period;
			}
	}
	//disconnect Period with hospital in DoctorSchedule
	protected Period breakWithDoctorScheduleByHospital(HisUserContext userContext, String periodId, String hospitalId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Period period = loadPeriod(userContext, periodId, allTokens());

			synchronized(period){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPeriodDAO().planToRemoveDoctorScheduleListWithHospital(period, hospitalId, this.emptyOptions());

				period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
				return period;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingDoctorSchedule(HisUserContext userContext, String periodId, String name, String doctorId, Date scheduleDate, String departmentId, int available, BigDecimal price, String expenseTypeId, String hospitalId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPeriod(periodId);

		
		userContext.getChecker().checkNameOfDoctorSchedule(name);
		
		userContext.getChecker().checkDoctorIdOfDoctorSchedule(doctorId);
		
		userContext.getChecker().checkScheduleDateOfDoctorSchedule(scheduleDate);
		
		userContext.getChecker().checkDepartmentIdOfDoctorSchedule(departmentId);
		
		userContext.getChecker().checkAvailableOfDoctorSchedule(available);
		
		userContext.getChecker().checkPriceOfDoctorSchedule(price);
		
		userContext.getChecker().checkExpenseTypeIdOfDoctorSchedule(expenseTypeId);
		
		userContext.getChecker().checkHospitalIdOfDoctorSchedule(hospitalId);
	
		userContext.getChecker().throwExceptionIfHasErrors(PeriodManagerException.class);

	
	}
	public  Period addDoctorSchedule(HisUserContext userContext, String periodId, String name, String doctorId, Date scheduleDate, String departmentId, int available, BigDecimal price, String expenseTypeId, String hospitalId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingDoctorSchedule(userContext,periodId,name, doctorId, scheduleDate, departmentId, available, price, expenseTypeId, hospitalId,tokensExpr);
		
		DoctorSchedule doctorSchedule = createDoctorSchedule(userContext,name, doctorId, scheduleDate, departmentId, available, price, expenseTypeId, hospitalId);
		
		Period period = loadPeriod(userContext, periodId, allTokens());
		synchronized(period){ 
			//Will be good when the period loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			period.addDoctorSchedule( doctorSchedule );		
			period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
			
			userContext.getManagerGroup().getDoctorScheduleManager().onNewInstanceCreated(userContext, doctorSchedule);
			return present(userContext,period, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingDoctorScheduleProperties(HisUserContext userContext, String periodId,String id,String name,Date scheduleDate,int available,BigDecimal price,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPeriod(periodId);
		userContext.getChecker().checkIdOfDoctorSchedule(id);
		
		userContext.getChecker().checkNameOfDoctorSchedule( name);
		userContext.getChecker().checkScheduleDateOfDoctorSchedule( scheduleDate);
		userContext.getChecker().checkAvailableOfDoctorSchedule( available);
		userContext.getChecker().checkPriceOfDoctorSchedule( price);

		userContext.getChecker().throwExceptionIfHasErrors(PeriodManagerException.class);
		
	}
	public  Period updateDoctorScheduleProperties(HisUserContext userContext, String periodId, String id,String name,Date scheduleDate,int available,BigDecimal price, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingDoctorScheduleProperties(userContext,periodId,id,name,scheduleDate,available,price,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withDoctorScheduleListList()
				.searchDoctorScheduleListWith(DoctorSchedule.ID_PROPERTY, "is", id).done();
		
		Period periodToUpdate = loadPeriod(userContext, periodId, options);
		
		if(periodToUpdate.getDoctorScheduleList().isEmpty()){
			throw new PeriodManagerException("DoctorSchedule is NOT FOUND with id: '"+id+"'");
		}
		
		DoctorSchedule item = periodToUpdate.getDoctorScheduleList().first();
		
		item.updateName( name );
		item.updateScheduleDate( scheduleDate );
		item.updateAvailable( available );
		item.updatePrice( price );

		
		//checkParamsForAddingDoctorSchedule(userContext,periodId,name, code, used,tokensExpr);
		Period period = savePeriod(userContext, periodToUpdate, tokens().withDoctorScheduleList().done());
		synchronized(period){ 
			return present(userContext,period, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected DoctorSchedule createDoctorSchedule(HisUserContext userContext, String name, String doctorId, Date scheduleDate, String departmentId, int available, BigDecimal price, String expenseTypeId, String hospitalId) throws Exception{

		DoctorSchedule doctorSchedule = new DoctorSchedule();
		
		
		doctorSchedule.setName(name);		
		Doctor  doctor = new Doctor();
		doctor.setId(doctorId);		
		doctorSchedule.setDoctor(doctor);		
		doctorSchedule.setScheduleDate(scheduleDate);		
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
	
	protected void checkParamsForRemovingDoctorScheduleList(HisUserContext userContext, String periodId, 
			String doctorScheduleIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPeriod(periodId);
		for(String doctorScheduleIdItem: doctorScheduleIds){
			userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleIdItem);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PeriodManagerException.class);
		
	}
	public  Period removeDoctorScheduleList(HisUserContext userContext, String periodId, 
			String doctorScheduleIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingDoctorScheduleList(userContext, periodId,  doctorScheduleIds, tokensExpr);
			
			
			Period period = loadPeriod(userContext, periodId, allTokens());
			synchronized(period){ 
				//Will be good when the period loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPeriodDAO().planToRemoveDoctorScheduleList(period, doctorScheduleIds, allTokens());
				period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
				deleteRelationListInGraph(userContext, period.getDoctorScheduleList());
				return present(userContext,period, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingDoctorSchedule(HisUserContext userContext, String periodId, 
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPeriod( periodId);
		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
		userContext.getChecker().checkVersionOfDoctorSchedule(doctorScheduleVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PeriodManagerException.class);
	
	}
	public  Period removeDoctorSchedule(HisUserContext userContext, String periodId, 
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingDoctorSchedule(userContext,periodId, doctorScheduleId, doctorScheduleVersion,tokensExpr);
		
		DoctorSchedule doctorSchedule = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);
		Period period = loadPeriod(userContext, periodId, allTokens());
		synchronized(period){ 
			//Will be good when the period loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			period.removeDoctorSchedule( doctorSchedule );		
			period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
			deleteRelationInGraph(userContext, doctorSchedule);
			return present(userContext,period, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingDoctorSchedule(HisUserContext userContext, String periodId, 
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPeriod( periodId);
		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
		userContext.getChecker().checkVersionOfDoctorSchedule(doctorScheduleVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PeriodManagerException.class);
	
	}
	public  Period copyDoctorScheduleFrom(HisUserContext userContext, String periodId, 
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingDoctorSchedule(userContext,periodId, doctorScheduleId, doctorScheduleVersion,tokensExpr);
		
		DoctorSchedule doctorSchedule = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);
		Period period = loadPeriod(userContext, periodId, allTokens());
		synchronized(period){ 
			//Will be good when the period loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			doctorSchedule.updateUpdateTime(userContext.now());
			
			period.copyDoctorScheduleFrom( doctorSchedule );		
			period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
			
			userContext.getManagerGroup().getDoctorScheduleManager().onNewInstanceCreated(userContext, (DoctorSchedule)period.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,period, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingDoctorSchedule(HisUserContext userContext, String periodId, String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPeriod(periodId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PeriodManagerException.class);
	
	}
	
	public  Period updateDoctorSchedule(HisUserContext userContext, String periodId, String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingDoctorSchedule(userContext, periodId, doctorScheduleId, doctorScheduleVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withDoctorScheduleList().searchDoctorScheduleListWith(DoctorSchedule.ID_PROPERTY, "eq", doctorScheduleId).done();
		
		
		
		Period period = loadPeriod(userContext, periodId, loadTokens);
		
		synchronized(period){ 
			//Will be good when the period loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//period.removeDoctorSchedule( doctorSchedule );	
			//make changes to AcceleraterAccount.
			DoctorSchedule doctorScheduleIndex = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);
		
			DoctorSchedule doctorSchedule = period.findTheDoctorSchedule(doctorScheduleIndex);
			if(doctorSchedule == null){
				throw new PeriodManagerException(doctorSchedule+" is NOT FOUND" );
			}
			
			doctorSchedule.changeProperty(property, newValueExpr);
			doctorSchedule.updateUpdateTime(userContext.now());
			period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
			return present(userContext,period, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(HisUserContext userContext, Period newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


