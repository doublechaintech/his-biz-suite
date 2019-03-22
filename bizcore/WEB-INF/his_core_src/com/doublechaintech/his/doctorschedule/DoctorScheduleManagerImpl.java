
package com.doublechaintech.his.doctorschedule;

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
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;

import com.doublechaintech.his.hospital.CandidateHospital;
import com.doublechaintech.his.period.CandidatePeriod;
import com.doublechaintech.his.expensetype.CandidateExpenseType;
import com.doublechaintech.his.doctor.CandidateDoctor;
import com.doublechaintech.his.department.CandidateDepartment;







public class DoctorScheduleManagerImpl extends CustomHisCheckerManager implements DoctorScheduleManager {
	
	private static final String SERVICE_TYPE = "DoctorSchedule";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws DoctorScheduleManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new DoctorScheduleManagerException(message);

	}
	
	

 	protected DoctorSchedule saveDoctorSchedule(HisUserContext userContext, DoctorSchedule doctorSchedule, String [] tokensExpr) throws Exception{	
 		//return getDoctorScheduleDAO().save(doctorSchedule, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveDoctorSchedule(userContext, doctorSchedule, tokens);
 	}
 	
 	protected DoctorSchedule saveDoctorScheduleDetail(HisUserContext userContext, DoctorSchedule doctorSchedule) throws Exception{	

 		
 		return saveDoctorSchedule(userContext, doctorSchedule, allTokens());
 	}
 	
 	public DoctorSchedule loadDoctorSchedule(HisUserContext userContext, String doctorScheduleId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
		userContext.getChecker().throwExceptionIfHasErrors( DoctorScheduleManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		DoctorSchedule doctorSchedule = loadDoctorSchedule( userContext, doctorScheduleId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,doctorSchedule, tokens);
 	}
 	
 	
 	 public DoctorSchedule searchDoctorSchedule(HisUserContext userContext, String doctorScheduleId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
		userContext.getChecker().throwExceptionIfHasErrors( DoctorScheduleManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		DoctorSchedule doctorSchedule = loadDoctorSchedule( userContext, doctorScheduleId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,doctorSchedule, tokens);
 	}
 	
 	

 	protected DoctorSchedule present(HisUserContext userContext, DoctorSchedule doctorSchedule, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,doctorSchedule,tokens);
		
		
		DoctorSchedule  doctorScheduleToPresent = userContext.getDAOGroup().getDoctorScheduleDAO().present(doctorSchedule, tokens);
		
		List<BaseEntity> entityListToNaming = doctorScheduleToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getDoctorScheduleDAO().alias(entityListToNaming);
		
		return  doctorScheduleToPresent;
		
		
	}
 
 	
 	
 	public DoctorSchedule loadDoctorScheduleDetail(HisUserContext userContext, String doctorScheduleId) throws Exception{	
 		DoctorSchedule doctorSchedule = loadDoctorSchedule( userContext, doctorScheduleId, allTokens());
 		return present(userContext,doctorSchedule, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String doctorScheduleId) throws Exception{	
 		DoctorSchedule doctorSchedule = loadDoctorSchedule( userContext, doctorScheduleId, viewTokens());
 		return present(userContext,doctorSchedule, allTokens());
		
 	}
 	protected DoctorSchedule saveDoctorSchedule(HisUserContext userContext, DoctorSchedule doctorSchedule, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getDoctorScheduleDAO().save(doctorSchedule, tokens);
 	}
 	protected DoctorSchedule loadDoctorSchedule(HisUserContext userContext, String doctorScheduleId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
		userContext.getChecker().throwExceptionIfHasErrors( DoctorScheduleManagerException.class);

 
 		return userContext.getDAOGroup().getDoctorScheduleDAO().load(doctorScheduleId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, DoctorSchedule doctorSchedule, Map<String, Object> tokens){
		super.addActions(userContext, doctorSchedule, tokens);
		
		addAction(userContext, doctorSchedule, tokens,"@create","createDoctorSchedule","createDoctorSchedule/","main","primary");
		addAction(userContext, doctorSchedule, tokens,"@update","updateDoctorSchedule","updateDoctorSchedule/"+doctorSchedule.getId()+"/","main","primary");
		addAction(userContext, doctorSchedule, tokens,"@copy","cloneDoctorSchedule","cloneDoctorSchedule/"+doctorSchedule.getId()+"/","main","primary");
		
		addAction(userContext, doctorSchedule, tokens,"doctor_schedule.transfer_to_doctor","transferToAnotherDoctor","transferToAnotherDoctor/"+doctorSchedule.getId()+"/","main","primary");
		addAction(userContext, doctorSchedule, tokens,"doctor_schedule.transfer_to_period","transferToAnotherPeriod","transferToAnotherPeriod/"+doctorSchedule.getId()+"/","main","primary");
		addAction(userContext, doctorSchedule, tokens,"doctor_schedule.transfer_to_department","transferToAnotherDepartment","transferToAnotherDepartment/"+doctorSchedule.getId()+"/","main","primary");
		addAction(userContext, doctorSchedule, tokens,"doctor_schedule.transfer_to_expense_type","transferToAnotherExpenseType","transferToAnotherExpenseType/"+doctorSchedule.getId()+"/","main","primary");
		addAction(userContext, doctorSchedule, tokens,"doctor_schedule.transfer_to_hospital","transferToAnotherHospital","transferToAnotherHospital/"+doctorSchedule.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, DoctorSchedule doctorSchedule, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public DoctorSchedule createDoctorSchedule(HisUserContext userContext,String name, String doctorId, Date scheduleDate, String periodId, String departmentId, int available, BigDecimal price, String expenseTypeId, String hospitalId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfDoctorSchedule(name);
		userContext.getChecker().checkScheduleDateOfDoctorSchedule(scheduleDate);
		userContext.getChecker().checkAvailableOfDoctorSchedule(available);
		userContext.getChecker().checkPriceOfDoctorSchedule(price);
	
		userContext.getChecker().throwExceptionIfHasErrors(DoctorScheduleManagerException.class);


		DoctorSchedule doctorSchedule=createNewDoctorSchedule();	

		doctorSchedule.setName(name);
			
		Doctor doctor = loadDoctor(userContext, doctorId,emptyOptions());
		doctorSchedule.setDoctor(doctor);
		
		
		doctorSchedule.setScheduleDate(scheduleDate);
			
		Period period = loadPeriod(userContext, periodId,emptyOptions());
		doctorSchedule.setPeriod(period);
		
		
			
		Department department = loadDepartment(userContext, departmentId,emptyOptions());
		doctorSchedule.setDepartment(department);
		
		
		doctorSchedule.setAvailable(available);
		doctorSchedule.setPrice(price);
			
		ExpenseType expenseType = loadExpenseType(userContext, expenseTypeId,emptyOptions());
		doctorSchedule.setExpenseType(expenseType);
		
		
		doctorSchedule.setCreateTime(userContext.now());
		doctorSchedule.setUpdateTime(userContext.now());
			
		Hospital hospital = loadHospital(userContext, hospitalId,emptyOptions());
		doctorSchedule.setHospital(hospital);
		
		

		doctorSchedule = saveDoctorSchedule(userContext, doctorSchedule, emptyOptions());
		
		onNewInstanceCreated(userContext, doctorSchedule);
		return doctorSchedule;

		
	}
	protected DoctorSchedule createNewDoctorSchedule() 
	{
		
		return new DoctorSchedule();		
	}
	
	protected void checkParamsForUpdatingDoctorSchedule(HisUserContext userContext,String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
		userContext.getChecker().checkVersionOfDoctorSchedule( doctorScheduleVersion);
		

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

				

		
	
		userContext.getChecker().throwExceptionIfHasErrors(DoctorScheduleManagerException.class);
	
		
	}
	
	
	
	public DoctorSchedule clone(HisUserContext userContext, String fromDoctorScheduleId) throws Exception{
		
		return userContext.getDAOGroup().getDoctorScheduleDAO().clone(fromDoctorScheduleId, this.allTokens());
	}
	
	public DoctorSchedule internalSaveDoctorSchedule(HisUserContext userContext, DoctorSchedule doctorSchedule) throws Exception 
	{
		return internalSaveDoctorSchedule(userContext, doctorSchedule, allTokens());

	}
	public DoctorSchedule internalSaveDoctorSchedule(HisUserContext userContext, DoctorSchedule doctorSchedule, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingDoctorSchedule(userContext, doctorScheduleId, doctorScheduleVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(doctorSchedule){ 
			//will be good when the doctorSchedule loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to DoctorSchedule.
			
			
			doctorSchedule = saveDoctorSchedule(userContext, doctorSchedule, options);
			return doctorSchedule;
			
		}

	}
	
	public DoctorSchedule updateDoctorSchedule(HisUserContext userContext,String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingDoctorSchedule(userContext, doctorScheduleId, doctorScheduleVersion, property, newValueExpr, tokensExpr);
		
		
		
		DoctorSchedule doctorSchedule = loadDoctorSchedule(userContext, doctorScheduleId, allTokens());
		if(doctorSchedule.getVersion() != doctorScheduleVersion){
			String message = "The target version("+doctorSchedule.getVersion()+") is not equals to version("+doctorScheduleVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(doctorSchedule){ 
			//will be good when the doctorSchedule loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to DoctorSchedule.
			doctorSchedule.updateUpdateTime(userContext.now());
			doctorSchedule.changeProperty(property, newValueExpr);
			doctorSchedule = saveDoctorSchedule(userContext, doctorSchedule, tokens().done());
			return present(userContext,doctorSchedule, mergedAllTokens(tokensExpr));
			//return saveDoctorSchedule(userContext, doctorSchedule, tokens().done());
		}

	}
	
	public DoctorSchedule updateDoctorScheduleProperty(HisUserContext userContext,String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingDoctorSchedule(userContext, doctorScheduleId, doctorScheduleVersion, property, newValueExpr, tokensExpr);
		
		DoctorSchedule doctorSchedule = loadDoctorSchedule(userContext, doctorScheduleId, allTokens());
		if(doctorSchedule.getVersion() != doctorScheduleVersion){
			String message = "The target version("+doctorSchedule.getVersion()+") is not equals to version("+doctorScheduleVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(doctorSchedule){ 
			//will be good when the doctorSchedule loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to DoctorSchedule.
			
			doctorSchedule.changeProperty(property, newValueExpr);
			doctorSchedule.updateUpdateTime(userContext.now());
			doctorSchedule = saveDoctorSchedule(userContext, doctorSchedule, tokens().done());
			return present(userContext,doctorSchedule, mergedAllTokens(tokensExpr));
			//return saveDoctorSchedule(userContext, doctorSchedule, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected DoctorScheduleTokens tokens(){
		return DoctorScheduleTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return DoctorScheduleTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return DoctorScheduleTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherDoctor(HisUserContext userContext, String doctorScheduleId, String anotherDoctorId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
 		userContext.getChecker().checkIdOfDoctor(anotherDoctorId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(DoctorScheduleManagerException.class);
 		
 	}
 	public DoctorSchedule transferToAnotherDoctor(HisUserContext userContext, String doctorScheduleId, String anotherDoctorId) throws Exception
 	{
 		checkParamsForTransferingAnotherDoctor(userContext, doctorScheduleId,anotherDoctorId);
 
		DoctorSchedule doctorSchedule = loadDoctorSchedule(userContext, doctorScheduleId, allTokens());	
		synchronized(doctorSchedule){
			//will be good when the doctorSchedule loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Doctor doctor = loadDoctor(userContext, anotherDoctorId, emptyOptions());		
			doctorSchedule.updateDoctor(doctor);		
			doctorSchedule = saveDoctorSchedule(userContext, doctorSchedule, emptyOptions());
			
			return present(userContext,doctorSchedule, allTokens());
			
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
		SmartList<Doctor> candidateList = userContext.getDAOGroup().getDoctorDAO().requestCandidateDoctorForDoctorSchedule(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPeriod(HisUserContext userContext, String doctorScheduleId, String anotherPeriodId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
 		userContext.getChecker().checkIdOfPeriod(anotherPeriodId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(DoctorScheduleManagerException.class);
 		
 	}
 	public DoctorSchedule transferToAnotherPeriod(HisUserContext userContext, String doctorScheduleId, String anotherPeriodId) throws Exception
 	{
 		checkParamsForTransferingAnotherPeriod(userContext, doctorScheduleId,anotherPeriodId);
 
		DoctorSchedule doctorSchedule = loadDoctorSchedule(userContext, doctorScheduleId, allTokens());	
		synchronized(doctorSchedule){
			//will be good when the doctorSchedule loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Period period = loadPeriod(userContext, anotherPeriodId, emptyOptions());		
			doctorSchedule.updatePeriod(period);		
			doctorSchedule = saveDoctorSchedule(userContext, doctorSchedule, emptyOptions());
			
			return present(userContext,doctorSchedule, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePeriod requestCandidatePeriod(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePeriod result = new CandidatePeriod();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Period> candidateList = userContext.getDAOGroup().getPeriodDAO().requestCandidatePeriodForDoctorSchedule(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherDepartment(HisUserContext userContext, String doctorScheduleId, String anotherDepartmentId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
 		userContext.getChecker().checkIdOfDepartment(anotherDepartmentId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(DoctorScheduleManagerException.class);
 		
 	}
 	public DoctorSchedule transferToAnotherDepartment(HisUserContext userContext, String doctorScheduleId, String anotherDepartmentId) throws Exception
 	{
 		checkParamsForTransferingAnotherDepartment(userContext, doctorScheduleId,anotherDepartmentId);
 
		DoctorSchedule doctorSchedule = loadDoctorSchedule(userContext, doctorScheduleId, allTokens());	
		synchronized(doctorSchedule){
			//will be good when the doctorSchedule loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Department department = loadDepartment(userContext, anotherDepartmentId, emptyOptions());		
			doctorSchedule.updateDepartment(department);		
			doctorSchedule = saveDoctorSchedule(userContext, doctorSchedule, emptyOptions());
			
			return present(userContext,doctorSchedule, allTokens());
			
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
		SmartList<Department> candidateList = userContext.getDAOGroup().getDepartmentDAO().requestCandidateDepartmentForDoctorSchedule(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherExpenseType(HisUserContext userContext, String doctorScheduleId, String anotherExpenseTypeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
 		userContext.getChecker().checkIdOfExpenseType(anotherExpenseTypeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(DoctorScheduleManagerException.class);
 		
 	}
 	public DoctorSchedule transferToAnotherExpenseType(HisUserContext userContext, String doctorScheduleId, String anotherExpenseTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherExpenseType(userContext, doctorScheduleId,anotherExpenseTypeId);
 
		DoctorSchedule doctorSchedule = loadDoctorSchedule(userContext, doctorScheduleId, allTokens());	
		synchronized(doctorSchedule){
			//will be good when the doctorSchedule loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ExpenseType expenseType = loadExpenseType(userContext, anotherExpenseTypeId, emptyOptions());		
			doctorSchedule.updateExpenseType(expenseType);		
			doctorSchedule = saveDoctorSchedule(userContext, doctorSchedule, emptyOptions());
			
			return present(userContext,doctorSchedule, allTokens());
			
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
		SmartList<ExpenseType> candidateList = userContext.getDAOGroup().getExpenseTypeDAO().requestCandidateExpenseTypeForDoctorSchedule(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherHospital(HisUserContext userContext, String doctorScheduleId, String anotherHospitalId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
 		userContext.getChecker().checkIdOfHospital(anotherHospitalId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(DoctorScheduleManagerException.class);
 		
 	}
 	public DoctorSchedule transferToAnotherHospital(HisUserContext userContext, String doctorScheduleId, String anotherHospitalId) throws Exception
 	{
 		checkParamsForTransferingAnotherHospital(userContext, doctorScheduleId,anotherHospitalId);
 
		DoctorSchedule doctorSchedule = loadDoctorSchedule(userContext, doctorScheduleId, allTokens());	
		synchronized(doctorSchedule){
			//will be good when the doctorSchedule loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Hospital hospital = loadHospital(userContext, anotherHospitalId, emptyOptions());		
			doctorSchedule.updateHospital(hospital);		
			doctorSchedule = saveDoctorSchedule(userContext, doctorSchedule, emptyOptions());
			
			return present(userContext,doctorSchedule, allTokens());
			
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
		SmartList<Hospital> candidateList = userContext.getDAOGroup().getHospitalDAO().requestCandidateHospitalForDoctorSchedule(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Doctor loadDoctor(HisUserContext userContext, String newDoctorId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getDoctorDAO().load(newDoctorId, options);
 	}
 	
 	
 	
	
	 	
 	protected Period loadPeriod(HisUserContext userContext, String newPeriodId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPeriodDAO().load(newPeriodId, options);
 	}
 	
 	
 	
	
	 	
 	protected ExpenseType loadExpenseType(HisUserContext userContext, String newExpenseTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getExpenseTypeDAO().load(newExpenseTypeId, options);
 	}
 	
 	
 	
	
	 	
 	protected Department loadDepartment(HisUserContext userContext, String newDepartmentId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getDepartmentDAO().load(newDepartmentId, options);
 	}
 	
 	
 	
	
	 	
 	protected Hospital loadHospital(HisUserContext userContext, String newHospitalId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getHospitalDAO().load(newHospitalId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String doctorScheduleId, int doctorScheduleVersion) throws Exception {
		//deleteInternal(userContext, doctorScheduleId, doctorScheduleVersion);		
	}
	protected void deleteInternal(HisUserContext userContext,
			String doctorScheduleId, int doctorScheduleVersion) throws Exception{
			
		userContext.getDAOGroup().getDoctorScheduleDAO().delete(doctorScheduleId, doctorScheduleVersion);
	}
	
	public DoctorSchedule forgetByAll(HisUserContext userContext, String doctorScheduleId, int doctorScheduleVersion) throws Exception {
		return forgetByAllInternal(userContext, doctorScheduleId, doctorScheduleVersion);		
	}
	protected DoctorSchedule forgetByAllInternal(HisUserContext userContext,
			String doctorScheduleId, int doctorScheduleVersion) throws Exception{
			
		return userContext.getDAOGroup().getDoctorScheduleDAO().disconnectFromAll(doctorScheduleId, doctorScheduleVersion);
	}
	

	
	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new DoctorScheduleManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getDoctorScheduleDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(HisUserContext userContext, DoctorSchedule newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


