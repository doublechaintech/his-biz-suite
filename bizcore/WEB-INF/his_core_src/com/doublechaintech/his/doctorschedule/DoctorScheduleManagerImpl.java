
package com.doublechaintech.his.doctorschedule;

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
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;

import com.doublechaintech.his.hospital.CandidateHospital;
import com.doublechaintech.his.period.CandidatePeriod;
import com.doublechaintech.his.expensetype.CandidateExpenseType;
import com.doublechaintech.his.doctor.CandidateDoctor;
import com.doublechaintech.his.department.CandidateDepartment;







public class DoctorScheduleManagerImpl extends CustomHisCheckerManager implements DoctorScheduleManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "DoctorSchedule";
	@Override
	public DoctorScheduleDAO daoOf(HisUserContext userContext) {
		return doctorScheduleDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
		checkerOf(userContext).throwExceptionIfHasErrors( DoctorScheduleManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		DoctorSchedule doctorSchedule = loadDoctorSchedule( userContext, doctorScheduleId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,doctorSchedule, tokens);
 	}
 	
 	
 	 public DoctorSchedule searchDoctorSchedule(HisUserContext userContext, String doctorScheduleId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
		checkerOf(userContext).throwExceptionIfHasErrors( DoctorScheduleManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		DoctorSchedule doctorSchedule = loadDoctorSchedule( userContext, doctorScheduleId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,doctorSchedule, tokens);
 	}
 	
 	

 	protected DoctorSchedule present(HisUserContext userContext, DoctorSchedule doctorSchedule, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,doctorSchedule,tokens);
		
		
		DoctorSchedule  doctorScheduleToPresent = doctorScheduleDaoOf(userContext).present(doctorSchedule, tokens);
		
		List<BaseEntity> entityListToNaming = doctorScheduleToPresent.collectRefercencesFromLists();
		doctorScheduleDaoOf(userContext).alias(entityListToNaming);
		
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
 		return doctorScheduleDaoOf(userContext).save(doctorSchedule, tokens);
 	}
 	protected DoctorSchedule loadDoctorSchedule(HisUserContext userContext, String doctorScheduleId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
		checkerOf(userContext).throwExceptionIfHasErrors( DoctorScheduleManagerException.class);

 
 		return doctorScheduleDaoOf(userContext).load(doctorScheduleId, tokens);
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
	
 	
 	
 
 	
 	

	public DoctorSchedule createDoctorSchedule(HisUserContext userContext, String name,String doctorId,Date scheduleDate,String periodId,String departmentId,int available,BigDecimal price,String expenseTypeId,String hospitalId) throws Exception
	//public DoctorSchedule createDoctorSchedule(HisUserContext userContext,String name, String doctorId, Date scheduleDate, String periodId, String departmentId, int available, BigDecimal price, String expenseTypeId, String hospitalId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfDoctorSchedule(name);
		checkerOf(userContext).checkScheduleDateOfDoctorSchedule(scheduleDate);
		checkerOf(userContext).checkAvailableOfDoctorSchedule(available);
		checkerOf(userContext).checkPriceOfDoctorSchedule(price);
	
		checkerOf(userContext).throwExceptionIfHasErrors(DoctorScheduleManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
		checkerOf(userContext).checkVersionOfDoctorSchedule( doctorScheduleVersion);
		

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

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(DoctorScheduleManagerException.class);


	}



	public DoctorSchedule clone(HisUserContext userContext, String fromDoctorScheduleId) throws Exception{

		return doctorScheduleDaoOf(userContext).clone(fromDoctorScheduleId, this.allTokens());
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
			if (doctorSchedule.isChanged()){
			doctorSchedule.updateUpdateTime(userContext.now());
			}
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

 		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
 		checkerOf(userContext).checkIdOfDoctor(anotherDoctorId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(DoctorScheduleManagerException.class);

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
		SmartList<Doctor> candidateList = doctorDaoOf(userContext).requestCandidateDoctorForDoctorSchedule(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherPeriod(HisUserContext userContext, String doctorScheduleId, String anotherPeriodId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
 		checkerOf(userContext).checkIdOfPeriod(anotherPeriodId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(DoctorScheduleManagerException.class);

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

	

	protected void checkParamsForTransferingAnotherPeriodWithCode(HisUserContext userContext, String doctorScheduleId, String anotherCode) throws Exception
 	{

 		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
 		checkerOf(userContext).checkCodeOfPeriod( anotherCode);
 		checkerOf(userContext).throwExceptionIfHasErrors(DoctorScheduleManagerException.class);

 	}

 	public DoctorSchedule transferToAnotherPeriodWithCode(HisUserContext userContext, String doctorScheduleId, String anotherCode) throws Exception
 	{
 		checkParamsForTransferingAnotherPeriodWithCode(userContext, doctorScheduleId,anotherCode);
 		DoctorSchedule doctorSchedule = loadDoctorSchedule(userContext, doctorScheduleId, allTokens());
		synchronized(doctorSchedule){
			//will be good when the doctorSchedule loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Period period = loadPeriodWithCode(userContext, anotherCode, emptyOptions());
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
		SmartList<Period> candidateList = periodDaoOf(userContext).requestCandidatePeriodForDoctorSchedule(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherDepartment(HisUserContext userContext, String doctorScheduleId, String anotherDepartmentId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
 		checkerOf(userContext).checkIdOfDepartment(anotherDepartmentId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(DoctorScheduleManagerException.class);

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
		SmartList<Department> candidateList = departmentDaoOf(userContext).requestCandidateDepartmentForDoctorSchedule(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherExpenseType(HisUserContext userContext, String doctorScheduleId, String anotherExpenseTypeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
 		checkerOf(userContext).checkIdOfExpenseType(anotherExpenseTypeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(DoctorScheduleManagerException.class);

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
		SmartList<ExpenseType> candidateList = expenseTypeDaoOf(userContext).requestCandidateExpenseTypeForDoctorSchedule(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherHospital(HisUserContext userContext, String doctorScheduleId, String anotherHospitalId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
 		checkerOf(userContext).checkIdOfHospital(anotherHospitalId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(DoctorScheduleManagerException.class);

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
		SmartList<Hospital> candidateList = hospitalDaoOf(userContext).requestCandidateHospitalForDoctorSchedule(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Period loadPeriod(HisUserContext userContext, String newPeriodId, Map<String,Object> options) throws Exception
 	{

 		return periodDaoOf(userContext).load(newPeriodId, options);
 	}
 	
 	protected Period loadPeriodWithCode(HisUserContext userContext, String newCode, Map<String,Object> options) throws Exception
 	{

 		return periodDaoOf(userContext).loadByCode(newCode, options);
 	}

 	


	

 	protected Doctor loadDoctor(HisUserContext userContext, String newDoctorId, Map<String,Object> options) throws Exception
 	{

 		return doctorDaoOf(userContext).load(newDoctorId, options);
 	}
 	


	

 	protected Hospital loadHospital(HisUserContext userContext, String newHospitalId, Map<String,Object> options) throws Exception
 	{

 		return hospitalDaoOf(userContext).load(newHospitalId, options);
 	}
 	


	

 	protected ExpenseType loadExpenseType(HisUserContext userContext, String newExpenseTypeId, Map<String,Object> options) throws Exception
 	{

 		return expenseTypeDaoOf(userContext).load(newExpenseTypeId, options);
 	}
 	


	

 	protected Department loadDepartment(HisUserContext userContext, String newDepartmentId, Map<String,Object> options) throws Exception
 	{

 		return departmentDaoOf(userContext).load(newDepartmentId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String doctorScheduleId, int doctorScheduleVersion) throws Exception {
		//deleteInternal(userContext, doctorScheduleId, doctorScheduleVersion);
	}
	protected void deleteInternal(HisUserContext userContext,
			String doctorScheduleId, int doctorScheduleVersion) throws Exception{

		doctorScheduleDaoOf(userContext).delete(doctorScheduleId, doctorScheduleVersion);
	}

	public DoctorSchedule forgetByAll(HisUserContext userContext, String doctorScheduleId, int doctorScheduleVersion) throws Exception {
		return forgetByAllInternal(userContext, doctorScheduleId, doctorScheduleVersion);
	}
	protected DoctorSchedule forgetByAllInternal(HisUserContext userContext,
			String doctorScheduleId, int doctorScheduleVersion) throws Exception{

		return doctorScheduleDaoOf(userContext).disconnectFromAll(doctorScheduleId, doctorScheduleVersion);
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
		return doctorScheduleDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(HisUserContext userContext, DoctorSchedule newCreated) throws Exception{
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
		//   DoctorSchedule newDoctorSchedule = this.createDoctorSchedule(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newDoctorSchedule
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, DoctorSchedule.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(HisUserContext userContext,SmartList<DoctorSchedule> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Doctor> doctorList = HisBaseUtils.collectReferencedObjectWithType(userContext, list, Doctor.class);
		userContext.getDAOGroup().enhanceList(doctorList, Doctor.class);
		List<Period> periodList = HisBaseUtils.collectReferencedObjectWithType(userContext, list, Period.class);
		userContext.getDAOGroup().enhanceList(periodList, Period.class);
		List<Department> departmentList = HisBaseUtils.collectReferencedObjectWithType(userContext, list, Department.class);
		userContext.getDAOGroup().enhanceList(departmentList, Department.class);
		List<ExpenseType> expenseTypeList = HisBaseUtils.collectReferencedObjectWithType(userContext, list, ExpenseType.class);
		userContext.getDAOGroup().enhanceList(expenseTypeList, ExpenseType.class);
		List<Hospital> hospitalList = HisBaseUtils.collectReferencedObjectWithType(userContext, list, Hospital.class);
		userContext.getDAOGroup().enhanceList(hospitalList, Hospital.class);


    }
	
	public Object listByDoctor(HisUserContext userContext,String doctorId) throws Exception {
		return listPageByDoctor(userContext, doctorId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByDoctor(HisUserContext userContext,String doctorId, int start, int count) throws Exception {
		SmartList<DoctorSchedule> list = doctorScheduleDaoOf(userContext).findDoctorScheduleByDoctor(doctorId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(DoctorSchedule.class);
		page.setContainerObject(Doctor.withId(doctorId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("医生安排列表");
		page.setRequestName("listByDoctor");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByDoctor/%s/",  getBeanName(), doctorId)));

		page.assemblerContent(userContext, "listByDoctor");
		return page.doRender(userContext);
	}
  
	public Object listByPeriod(HisUserContext userContext,String periodId) throws Exception {
		return listPageByPeriod(userContext, periodId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByPeriod(HisUserContext userContext,String periodId, int start, int count) throws Exception {
		SmartList<DoctorSchedule> list = doctorScheduleDaoOf(userContext).findDoctorScheduleByPeriod(periodId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(DoctorSchedule.class);
		page.setContainerObject(Period.withId(periodId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("医生安排列表");
		page.setRequestName("listByPeriod");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByPeriod/%s/",  getBeanName(), periodId)));

		page.assemblerContent(userContext, "listByPeriod");
		return page.doRender(userContext);
	}
  
	public Object listByDepartment(HisUserContext userContext,String departmentId) throws Exception {
		return listPageByDepartment(userContext, departmentId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByDepartment(HisUserContext userContext,String departmentId, int start, int count) throws Exception {
		SmartList<DoctorSchedule> list = doctorScheduleDaoOf(userContext).findDoctorScheduleByDepartment(departmentId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(DoctorSchedule.class);
		page.setContainerObject(Department.withId(departmentId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("医生安排列表");
		page.setRequestName("listByDepartment");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByDepartment/%s/",  getBeanName(), departmentId)));

		page.assemblerContent(userContext, "listByDepartment");
		return page.doRender(userContext);
	}
  
	public Object listByExpenseType(HisUserContext userContext,String expenseTypeId) throws Exception {
		return listPageByExpenseType(userContext, expenseTypeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByExpenseType(HisUserContext userContext,String expenseTypeId, int start, int count) throws Exception {
		SmartList<DoctorSchedule> list = doctorScheduleDaoOf(userContext).findDoctorScheduleByExpenseType(expenseTypeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(DoctorSchedule.class);
		page.setContainerObject(ExpenseType.withId(expenseTypeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("医生安排列表");
		page.setRequestName("listByExpenseType");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByExpenseType/%s/",  getBeanName(), expenseTypeId)));

		page.assemblerContent(userContext, "listByExpenseType");
		return page.doRender(userContext);
	}
  
	public Object listByHospital(HisUserContext userContext,String hospitalId) throws Exception {
		return listPageByHospital(userContext, hospitalId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByHospital(HisUserContext userContext,String hospitalId, int start, int count) throws Exception {
		SmartList<DoctorSchedule> list = doctorScheduleDaoOf(userContext).findDoctorScheduleByHospital(hospitalId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(DoctorSchedule.class);
		page.setContainerObject(Hospital.withId(hospitalId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("医生安排列表");
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
 	public Object wxappview(HisUserContext userContext, String doctorScheduleId) throws Exception{
	  SerializeScope vscope = HisViewScope.getInstance().getDoctorScheduleDetailScope().clone();
		DoctorSchedule merchantObj = (DoctorSchedule) this.view(userContext, doctorScheduleId);
    String merchantObjId = doctorScheduleId;
    String linkToUrl =	"doctorScheduleManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "医生安排"+"详情";
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
				MapUtil.put("id", "4-scheduleDate")
				    .put("fieldName", "scheduleDate")
				    .put("label", "安排日期")
				    .put("type", "date")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("scheduleDate", merchantObj.getScheduleDate());

		propList.add(
				MapUtil.put("id", "5-period")
				    .put("fieldName", "period")
				    .put("label", "期")
				    .put("type", "status")
				    .put("displayField", "name")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("period", merchantObj.getPeriod());

		propList.add(
				MapUtil.put("id", "6-department")
				    .put("fieldName", "department")
				    .put("label", "部门")
				    .put("type", "object")
				    .put("displayField", "name")
				    .put("linkToUrl", "departmentManager/wxappview/:id/")
				    .into_map()
		);
		result.put("department", merchantObj.getDepartment());

		propList.add(
				MapUtil.put("id", "7-available")
				    .put("fieldName", "available")
				    .put("label", "可用")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("available", merchantObj.getAvailable());

		propList.add(
				MapUtil.put("id", "8-price")
				    .put("fieldName", "price")
				    .put("label", "价格")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("price", merchantObj.getPrice());

		propList.add(
				MapUtil.put("id", "9-expenseType")
				    .put("fieldName", "expenseType")
				    .put("label", "费用类型")
				    .put("type", "object")
				    .put("displayField", "name")
				    .put("linkToUrl", "expenseTypeManager/wxappview/:id/")
				    .into_map()
		);
		result.put("expenseType", merchantObj.getExpenseType());

		propList.add(
				MapUtil.put("id", "10-createTime")
				    .put("fieldName", "createTime")
				    .put("label", "创建时间")
				    .put("type", "date")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("createTime", merchantObj.getCreateTime());

		propList.add(
				MapUtil.put("id", "11-updateTime")
				    .put("fieldName", "updateTime")
				    .put("label", "更新时间")
				    .put("type", "date")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("updateTime", merchantObj.getUpdateTime());

		propList.add(
				MapUtil.put("id", "12-hospital")
				    .put("fieldName", "hospital")
				    .put("label", "医院")
				    .put("type", "object")
				    .put("displayField", "name")
				    .put("linkToUrl", "hospitalManager/wxappview/:id/")
				    .into_map()
		);
		result.put("hospital", merchantObj.getHospital());

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


