
package com.doublechaintech.his.doctor;

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
import com.doublechaintech.his.doctorassignment.DoctorAssignment;

import com.doublechaintech.his.hospital.CandidateHospital;

import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;






public class DoctorManagerImpl extends CustomHisCheckerManager implements DoctorManager {
	
	private static final String SERVICE_TYPE = "Doctor";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws DoctorManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new DoctorManagerException(message);

	}
	
	

 	protected Doctor saveDoctor(HisUserContext userContext, Doctor doctor, String [] tokensExpr) throws Exception{	
 		//return getDoctorDAO().save(doctor, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveDoctor(userContext, doctor, tokens);
 	}
 	
 	protected Doctor saveDoctorDetail(HisUserContext userContext, Doctor doctor) throws Exception{	

 		
 		return saveDoctor(userContext, doctor, allTokens());
 	}
 	
 	public Doctor loadDoctor(HisUserContext userContext, String doctorId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfDoctor(doctorId);
		userContext.getChecker().throwExceptionIfHasErrors( DoctorManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Doctor doctor = loadDoctor( userContext, doctorId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,doctor, tokens);
 	}
 	
 	
 	 public Doctor searchDoctor(HisUserContext userContext, String doctorId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfDoctor(doctorId);
		userContext.getChecker().throwExceptionIfHasErrors( DoctorManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Doctor doctor = loadDoctor( userContext, doctorId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,doctor, tokens);
 	}
 	
 	

 	protected Doctor present(HisUserContext userContext, Doctor doctor, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,doctor,tokens);
		
		
		Doctor  doctorToPresent = userContext.getDAOGroup().getDoctorDAO().present(doctor, tokens);
		
		List<BaseEntity> entityListToNaming = doctorToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getDoctorDAO().alias(entityListToNaming);
		
		return  doctorToPresent;
		
		
	}
 
 	
 	
 	public Doctor loadDoctorDetail(HisUserContext userContext, String doctorId) throws Exception{	
 		Doctor doctor = loadDoctor( userContext, doctorId, allTokens());
 		return present(userContext,doctor, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String doctorId) throws Exception{	
 		Doctor doctor = loadDoctor( userContext, doctorId, viewTokens());
 		return present(userContext,doctor, allTokens());
		
 	}
 	protected Doctor saveDoctor(HisUserContext userContext, Doctor doctor, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getDoctorDAO().save(doctor, tokens);
 	}
 	protected Doctor loadDoctor(HisUserContext userContext, String doctorId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfDoctor(doctorId);
		userContext.getChecker().throwExceptionIfHasErrors( DoctorManagerException.class);

 
 		return userContext.getDAOGroup().getDoctorDAO().load(doctorId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, Doctor doctor, Map<String, Object> tokens){
		super.addActions(userContext, doctor, tokens);
		
		addAction(userContext, doctor, tokens,"@create","createDoctor","createDoctor/","main","primary");
		addAction(userContext, doctor, tokens,"@update","updateDoctor","updateDoctor/"+doctor.getId()+"/","main","primary");
		addAction(userContext, doctor, tokens,"@copy","cloneDoctor","cloneDoctor/"+doctor.getId()+"/","main","primary");
		
		addAction(userContext, doctor, tokens,"doctor.transfer_to_hospital","transferToAnotherHospital","transferToAnotherHospital/"+doctor.getId()+"/","main","primary");
		addAction(userContext, doctor, tokens,"doctor.addDoctorAssignment","addDoctorAssignment","addDoctorAssignment/"+doctor.getId()+"/","doctorAssignmentList","primary");
		addAction(userContext, doctor, tokens,"doctor.removeDoctorAssignment","removeDoctorAssignment","removeDoctorAssignment/"+doctor.getId()+"/","doctorAssignmentList","primary");
		addAction(userContext, doctor, tokens,"doctor.updateDoctorAssignment","updateDoctorAssignment","updateDoctorAssignment/"+doctor.getId()+"/","doctorAssignmentList","primary");
		addAction(userContext, doctor, tokens,"doctor.copyDoctorAssignmentFrom","copyDoctorAssignmentFrom","copyDoctorAssignmentFrom/"+doctor.getId()+"/","doctorAssignmentList","primary");
		addAction(userContext, doctor, tokens,"doctor.addDoctorSchedule","addDoctorSchedule","addDoctorSchedule/"+doctor.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, doctor, tokens,"doctor.removeDoctorSchedule","removeDoctorSchedule","removeDoctorSchedule/"+doctor.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, doctor, tokens,"doctor.updateDoctorSchedule","updateDoctorSchedule","updateDoctorSchedule/"+doctor.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, doctor, tokens,"doctor.copyDoctorScheduleFrom","copyDoctorScheduleFrom","copyDoctorScheduleFrom/"+doctor.getId()+"/","doctorScheduleList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, Doctor doctor, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Doctor createDoctor(HisUserContext userContext,String name, String shotImage, String hospitalId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfDoctor(name);
		userContext.getChecker().checkShotImageOfDoctor(shotImage);
	
		userContext.getChecker().throwExceptionIfHasErrors(DoctorManagerException.class);


		Doctor doctor=createNewDoctor();	

		doctor.setName(name);
		doctor.setShotImage(shotImage);
			
		Hospital hospital = loadHospital(userContext, hospitalId,emptyOptions());
		doctor.setHospital(hospital);
		
		
		doctor.setUpdateTime(userContext.now());

		doctor = saveDoctor(userContext, doctor, emptyOptions());
		
		onNewInstanceCreated(userContext, doctor);
		return doctor;

		
	}
	protected Doctor createNewDoctor() 
	{
		
		return new Doctor();		
	}
	
	protected void checkParamsForUpdatingDoctor(HisUserContext userContext,String doctorId, int doctorVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfDoctor(doctorId);
		userContext.getChecker().checkVersionOfDoctor( doctorVersion);
		

		if(Doctor.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfDoctor(parseString(newValueExpr));
		}
		if(Doctor.SHOT_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkShotImageOfDoctor(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(DoctorManagerException.class);
	
		
	}
	
	
	
	public Doctor clone(HisUserContext userContext, String fromDoctorId) throws Exception{
		
		return userContext.getDAOGroup().getDoctorDAO().clone(fromDoctorId, this.allTokens());
	}
	
	public Doctor internalSaveDoctor(HisUserContext userContext, Doctor doctor) throws Exception 
	{
		return internalSaveDoctor(userContext, doctor, allTokens());

	}
	public Doctor internalSaveDoctor(HisUserContext userContext, Doctor doctor, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingDoctor(userContext, doctorId, doctorVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(doctor){ 
			//will be good when the doctor loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Doctor.
			if (doctor.isChanged()){
			doctor.updateUpdateTime(userContext.now());
			}
			doctor = saveDoctor(userContext, doctor, options);
			return doctor;
			
		}

	}
	
	public Doctor updateDoctor(HisUserContext userContext,String doctorId, int doctorVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingDoctor(userContext, doctorId, doctorVersion, property, newValueExpr, tokensExpr);
		
		
		
		Doctor doctor = loadDoctor(userContext, doctorId, allTokens());
		if(doctor.getVersion() != doctorVersion){
			String message = "The target version("+doctor.getVersion()+") is not equals to version("+doctorVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(doctor){ 
			//will be good when the doctor loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Doctor.
			doctor.updateUpdateTime(userContext.now());
			doctor.changeProperty(property, newValueExpr);
			doctor = saveDoctor(userContext, doctor, tokens().done());
			return present(userContext,doctor, mergedAllTokens(tokensExpr));
			//return saveDoctor(userContext, doctor, tokens().done());
		}

	}
	
	public Doctor updateDoctorProperty(HisUserContext userContext,String doctorId, int doctorVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingDoctor(userContext, doctorId, doctorVersion, property, newValueExpr, tokensExpr);
		
		Doctor doctor = loadDoctor(userContext, doctorId, allTokens());
		if(doctor.getVersion() != doctorVersion){
			String message = "The target version("+doctor.getVersion()+") is not equals to version("+doctorVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(doctor){ 
			//will be good when the doctor loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Doctor.
			
			doctor.changeProperty(property, newValueExpr);
			doctor.updateUpdateTime(userContext.now());
			doctor = saveDoctor(userContext, doctor, tokens().done());
			return present(userContext,doctor, mergedAllTokens(tokensExpr));
			//return saveDoctor(userContext, doctor, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected DoctorTokens tokens(){
		return DoctorTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return DoctorTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortDoctorAssignmentListWith("id","desc")
		.sortDoctorScheduleListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return DoctorTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherHospital(HisUserContext userContext, String doctorId, String anotherHospitalId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfDoctor(doctorId);
 		userContext.getChecker().checkIdOfHospital(anotherHospitalId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(DoctorManagerException.class);
 		
 	}
 	public Doctor transferToAnotherHospital(HisUserContext userContext, String doctorId, String anotherHospitalId) throws Exception
 	{
 		checkParamsForTransferingAnotherHospital(userContext, doctorId,anotherHospitalId);
 
		Doctor doctor = loadDoctor(userContext, doctorId, allTokens());	
		synchronized(doctor){
			//will be good when the doctor loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Hospital hospital = loadHospital(userContext, anotherHospitalId, emptyOptions());		
			doctor.updateHospital(hospital);		
			doctor = saveDoctor(userContext, doctor, emptyOptions());
			
			return present(userContext,doctor, allTokens());
			
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
		SmartList<Hospital> candidateList = userContext.getDAOGroup().getHospitalDAO().requestCandidateHospitalForDoctor(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(HisUserContext userContext, String doctorId, int doctorVersion) throws Exception {
		//deleteInternal(userContext, doctorId, doctorVersion);		
	}
	protected void deleteInternal(HisUserContext userContext,
			String doctorId, int doctorVersion) throws Exception{
			
		userContext.getDAOGroup().getDoctorDAO().delete(doctorId, doctorVersion);
	}
	
	public Doctor forgetByAll(HisUserContext userContext, String doctorId, int doctorVersion) throws Exception {
		return forgetByAllInternal(userContext, doctorId, doctorVersion);		
	}
	protected Doctor forgetByAllInternal(HisUserContext userContext,
			String doctorId, int doctorVersion) throws Exception{
			
		return userContext.getDAOGroup().getDoctorDAO().disconnectFromAll(doctorId, doctorVersion);
	}
	

	
	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new DoctorManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getDoctorDAO().deleteAll();
	}


	//disconnect Doctor with department in DoctorAssignment
	protected Doctor breakWithDoctorAssignmentByDepartment(HisUserContext userContext, String doctorId, String departmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Doctor doctor = loadDoctor(userContext, doctorId, allTokens());

			synchronized(doctor){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getDoctorDAO().planToRemoveDoctorAssignmentListWithDepartment(doctor, departmentId, this.emptyOptions());

				doctor = saveDoctor(userContext, doctor, tokens().withDoctorAssignmentList().done());
				return doctor;
			}
	}
	//disconnect Doctor with period in DoctorSchedule
	protected Doctor breakWithDoctorScheduleByPeriod(HisUserContext userContext, String doctorId, String periodId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Doctor doctor = loadDoctor(userContext, doctorId, allTokens());

			synchronized(doctor){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getDoctorDAO().planToRemoveDoctorScheduleListWithPeriod(doctor, periodId, this.emptyOptions());

				doctor = saveDoctor(userContext, doctor, tokens().withDoctorScheduleList().done());
				return doctor;
			}
	}
	//disconnect Doctor with department in DoctorSchedule
	protected Doctor breakWithDoctorScheduleByDepartment(HisUserContext userContext, String doctorId, String departmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Doctor doctor = loadDoctor(userContext, doctorId, allTokens());

			synchronized(doctor){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getDoctorDAO().planToRemoveDoctorScheduleListWithDepartment(doctor, departmentId, this.emptyOptions());

				doctor = saveDoctor(userContext, doctor, tokens().withDoctorScheduleList().done());
				return doctor;
			}
	}
	//disconnect Doctor with expense_type in DoctorSchedule
	protected Doctor breakWithDoctorScheduleByExpenseType(HisUserContext userContext, String doctorId, String expenseTypeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Doctor doctor = loadDoctor(userContext, doctorId, allTokens());

			synchronized(doctor){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getDoctorDAO().planToRemoveDoctorScheduleListWithExpenseType(doctor, expenseTypeId, this.emptyOptions());

				doctor = saveDoctor(userContext, doctor, tokens().withDoctorScheduleList().done());
				return doctor;
			}
	}
	//disconnect Doctor with hospital in DoctorSchedule
	protected Doctor breakWithDoctorScheduleByHospital(HisUserContext userContext, String doctorId, String hospitalId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Doctor doctor = loadDoctor(userContext, doctorId, allTokens());

			synchronized(doctor){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getDoctorDAO().planToRemoveDoctorScheduleListWithHospital(doctor, hospitalId, this.emptyOptions());

				doctor = saveDoctor(userContext, doctor, tokens().withDoctorScheduleList().done());
				return doctor;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingDoctorAssignment(HisUserContext userContext, String doctorId, String name, String departmentId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfDoctor(doctorId);

		
		userContext.getChecker().checkNameOfDoctorAssignment(name);
		
		userContext.getChecker().checkDepartmentIdOfDoctorAssignment(departmentId);
	
		userContext.getChecker().throwExceptionIfHasErrors(DoctorManagerException.class);

	
	}
	public  Doctor addDoctorAssignment(HisUserContext userContext, String doctorId, String name, String departmentId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingDoctorAssignment(userContext,doctorId,name, departmentId,tokensExpr);
		
		DoctorAssignment doctorAssignment = createDoctorAssignment(userContext,name, departmentId);
		
		Doctor doctor = loadDoctor(userContext, doctorId, allTokens());
		synchronized(doctor){ 
			//Will be good when the doctor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			doctor.addDoctorAssignment( doctorAssignment );		
			doctor = saveDoctor(userContext, doctor, tokens().withDoctorAssignmentList().done());
			
			userContext.getManagerGroup().getDoctorAssignmentManager().onNewInstanceCreated(userContext, doctorAssignment);
			return present(userContext,doctor, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingDoctorAssignmentProperties(HisUserContext userContext, String doctorId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfDoctor(doctorId);
		userContext.getChecker().checkIdOfDoctorAssignment(id);
		
		userContext.getChecker().checkNameOfDoctorAssignment( name);

		userContext.getChecker().throwExceptionIfHasErrors(DoctorManagerException.class);
		
	}
	public  Doctor updateDoctorAssignmentProperties(HisUserContext userContext, String doctorId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingDoctorAssignmentProperties(userContext,doctorId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withDoctorAssignmentListList()
				.searchDoctorAssignmentListWith(DoctorAssignment.ID_PROPERTY, "is", id).done();
		
		Doctor doctorToUpdate = loadDoctor(userContext, doctorId, options);
		
		if(doctorToUpdate.getDoctorAssignmentList().isEmpty()){
			throw new DoctorManagerException("DoctorAssignment is NOT FOUND with id: '"+id+"'");
		}
		
		DoctorAssignment item = doctorToUpdate.getDoctorAssignmentList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingDoctorAssignment(userContext,doctorId,name, code, used,tokensExpr);
		Doctor doctor = saveDoctor(userContext, doctorToUpdate, tokens().withDoctorAssignmentList().done());
		synchronized(doctor){ 
			return present(userContext,doctor, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected DoctorAssignment createDoctorAssignment(HisUserContext userContext, String name, String departmentId) throws Exception{

		DoctorAssignment doctorAssignment = new DoctorAssignment();
		
		
		doctorAssignment.setName(name);		
		Department  department = new Department();
		department.setId(departmentId);		
		doctorAssignment.setDepartment(department);		
		doctorAssignment.setUpdateTime(userContext.now());
	
		
		return doctorAssignment;
	
		
	}
	
	protected DoctorAssignment createIndexedDoctorAssignment(String id, int version){

		DoctorAssignment doctorAssignment = new DoctorAssignment();
		doctorAssignment.setId(id);
		doctorAssignment.setVersion(version);
		return doctorAssignment;			
		
	}
	
	protected void checkParamsForRemovingDoctorAssignmentList(HisUserContext userContext, String doctorId, 
			String doctorAssignmentIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfDoctor(doctorId);
		for(String doctorAssignmentId: doctorAssignmentIds){
			userContext.getChecker().checkIdOfDoctorAssignment(doctorAssignmentId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(DoctorManagerException.class);
		
	}
	public  Doctor removeDoctorAssignmentList(HisUserContext userContext, String doctorId, 
			String doctorAssignmentIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingDoctorAssignmentList(userContext, doctorId,  doctorAssignmentIds, tokensExpr);
			
			
			Doctor doctor = loadDoctor(userContext, doctorId, allTokens());
			synchronized(doctor){ 
				//Will be good when the doctor loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getDoctorDAO().planToRemoveDoctorAssignmentList(doctor, doctorAssignmentIds, allTokens());
				doctor = saveDoctor(userContext, doctor, tokens().withDoctorAssignmentList().done());
				deleteRelationListInGraph(userContext, doctor.getDoctorAssignmentList());
				return present(userContext,doctor, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingDoctorAssignment(HisUserContext userContext, String doctorId, 
		String doctorAssignmentId, int doctorAssignmentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfDoctor( doctorId);
		userContext.getChecker().checkIdOfDoctorAssignment(doctorAssignmentId);
		userContext.getChecker().checkVersionOfDoctorAssignment(doctorAssignmentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(DoctorManagerException.class);
	
	}
	public  Doctor removeDoctorAssignment(HisUserContext userContext, String doctorId, 
		String doctorAssignmentId, int doctorAssignmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingDoctorAssignment(userContext,doctorId, doctorAssignmentId, doctorAssignmentVersion,tokensExpr);
		
		DoctorAssignment doctorAssignment = createIndexedDoctorAssignment(doctorAssignmentId, doctorAssignmentVersion);
		Doctor doctor = loadDoctor(userContext, doctorId, allTokens());
		synchronized(doctor){ 
			//Will be good when the doctor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			doctor.removeDoctorAssignment( doctorAssignment );		
			doctor = saveDoctor(userContext, doctor, tokens().withDoctorAssignmentList().done());
			deleteRelationInGraph(userContext, doctorAssignment);
			return present(userContext,doctor, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingDoctorAssignment(HisUserContext userContext, String doctorId, 
		String doctorAssignmentId, int doctorAssignmentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfDoctor( doctorId);
		userContext.getChecker().checkIdOfDoctorAssignment(doctorAssignmentId);
		userContext.getChecker().checkVersionOfDoctorAssignment(doctorAssignmentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(DoctorManagerException.class);
	
	}
	public  Doctor copyDoctorAssignmentFrom(HisUserContext userContext, String doctorId, 
		String doctorAssignmentId, int doctorAssignmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingDoctorAssignment(userContext,doctorId, doctorAssignmentId, doctorAssignmentVersion,tokensExpr);
		
		DoctorAssignment doctorAssignment = createIndexedDoctorAssignment(doctorAssignmentId, doctorAssignmentVersion);
		Doctor doctor = loadDoctor(userContext, doctorId, allTokens());
		synchronized(doctor){ 
			//Will be good when the doctor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			doctorAssignment.updateUpdateTime(userContext.now());
			
			doctor.copyDoctorAssignmentFrom( doctorAssignment );		
			doctor = saveDoctor(userContext, doctor, tokens().withDoctorAssignmentList().done());
			
			userContext.getManagerGroup().getDoctorAssignmentManager().onNewInstanceCreated(userContext, (DoctorAssignment)doctor.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,doctor, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingDoctorAssignment(HisUserContext userContext, String doctorId, String doctorAssignmentId, int doctorAssignmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfDoctor(doctorId);
		userContext.getChecker().checkIdOfDoctorAssignment(doctorAssignmentId);
		userContext.getChecker().checkVersionOfDoctorAssignment(doctorAssignmentVersion);
		

		if(DoctorAssignment.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfDoctorAssignment(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(DoctorManagerException.class);
	
	}
	
	public  Doctor updateDoctorAssignment(HisUserContext userContext, String doctorId, String doctorAssignmentId, int doctorAssignmentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingDoctorAssignment(userContext, doctorId, doctorAssignmentId, doctorAssignmentVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withDoctorAssignmentList().searchDoctorAssignmentListWith(DoctorAssignment.ID_PROPERTY, "eq", doctorAssignmentId).done();
		
		
		
		Doctor doctor = loadDoctor(userContext, doctorId, loadTokens);
		
		synchronized(doctor){ 
			//Will be good when the doctor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//doctor.removeDoctorAssignment( doctorAssignment );	
			//make changes to AcceleraterAccount.
			DoctorAssignment doctorAssignmentIndex = createIndexedDoctorAssignment(doctorAssignmentId, doctorAssignmentVersion);
		
			DoctorAssignment doctorAssignment = doctor.findTheDoctorAssignment(doctorAssignmentIndex);
			if(doctorAssignment == null){
				throw new DoctorManagerException(doctorAssignment+" is NOT FOUND" );
			}
			
			doctorAssignment.changeProperty(property, newValueExpr);
			doctorAssignment.updateUpdateTime(userContext.now());
			doctor = saveDoctor(userContext, doctor, tokens().withDoctorAssignmentList().done());
			return present(userContext,doctor, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingDoctorSchedule(HisUserContext userContext, String doctorId, String name, Date scheduleDate, String periodId, String departmentId, int available, BigDecimal price, String expenseTypeId, String hospitalId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfDoctor(doctorId);

		
		userContext.getChecker().checkNameOfDoctorSchedule(name);
		
		userContext.getChecker().checkScheduleDateOfDoctorSchedule(scheduleDate);
		
		userContext.getChecker().checkPeriodIdOfDoctorSchedule(periodId);
		
		userContext.getChecker().checkDepartmentIdOfDoctorSchedule(departmentId);
		
		userContext.getChecker().checkAvailableOfDoctorSchedule(available);
		
		userContext.getChecker().checkPriceOfDoctorSchedule(price);
		
		userContext.getChecker().checkExpenseTypeIdOfDoctorSchedule(expenseTypeId);
		
		userContext.getChecker().checkHospitalIdOfDoctorSchedule(hospitalId);
	
		userContext.getChecker().throwExceptionIfHasErrors(DoctorManagerException.class);

	
	}
	public  Doctor addDoctorSchedule(HisUserContext userContext, String doctorId, String name, Date scheduleDate, String periodId, String departmentId, int available, BigDecimal price, String expenseTypeId, String hospitalId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingDoctorSchedule(userContext,doctorId,name, scheduleDate, periodId, departmentId, available, price, expenseTypeId, hospitalId,tokensExpr);
		
		DoctorSchedule doctorSchedule = createDoctorSchedule(userContext,name, scheduleDate, periodId, departmentId, available, price, expenseTypeId, hospitalId);
		
		Doctor doctor = loadDoctor(userContext, doctorId, allTokens());
		synchronized(doctor){ 
			//Will be good when the doctor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			doctor.addDoctorSchedule( doctorSchedule );		
			doctor = saveDoctor(userContext, doctor, tokens().withDoctorScheduleList().done());
			
			userContext.getManagerGroup().getDoctorScheduleManager().onNewInstanceCreated(userContext, doctorSchedule);
			return present(userContext,doctor, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingDoctorScheduleProperties(HisUserContext userContext, String doctorId,String id,String name,Date scheduleDate,int available,BigDecimal price,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfDoctor(doctorId);
		userContext.getChecker().checkIdOfDoctorSchedule(id);
		
		userContext.getChecker().checkNameOfDoctorSchedule( name);
		userContext.getChecker().checkScheduleDateOfDoctorSchedule( scheduleDate);
		userContext.getChecker().checkAvailableOfDoctorSchedule( available);
		userContext.getChecker().checkPriceOfDoctorSchedule( price);

		userContext.getChecker().throwExceptionIfHasErrors(DoctorManagerException.class);
		
	}
	public  Doctor updateDoctorScheduleProperties(HisUserContext userContext, String doctorId, String id,String name,Date scheduleDate,int available,BigDecimal price, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingDoctorScheduleProperties(userContext,doctorId,id,name,scheduleDate,available,price,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withDoctorScheduleListList()
				.searchDoctorScheduleListWith(DoctorSchedule.ID_PROPERTY, "is", id).done();
		
		Doctor doctorToUpdate = loadDoctor(userContext, doctorId, options);
		
		if(doctorToUpdate.getDoctorScheduleList().isEmpty()){
			throw new DoctorManagerException("DoctorSchedule is NOT FOUND with id: '"+id+"'");
		}
		
		DoctorSchedule item = doctorToUpdate.getDoctorScheduleList().first();
		
		item.updateName( name );
		item.updateScheduleDate( scheduleDate );
		item.updateAvailable( available );
		item.updatePrice( price );

		
		//checkParamsForAddingDoctorSchedule(userContext,doctorId,name, code, used,tokensExpr);
		Doctor doctor = saveDoctor(userContext, doctorToUpdate, tokens().withDoctorScheduleList().done());
		synchronized(doctor){ 
			return present(userContext,doctor, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected DoctorSchedule createDoctorSchedule(HisUserContext userContext, String name, Date scheduleDate, String periodId, String departmentId, int available, BigDecimal price, String expenseTypeId, String hospitalId) throws Exception{

		DoctorSchedule doctorSchedule = new DoctorSchedule();
		
		
		doctorSchedule.setName(name);		
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
	
	protected void checkParamsForRemovingDoctorScheduleList(HisUserContext userContext, String doctorId, 
			String doctorScheduleIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfDoctor(doctorId);
		for(String doctorScheduleId: doctorScheduleIds){
			userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(DoctorManagerException.class);
		
	}
	public  Doctor removeDoctorScheduleList(HisUserContext userContext, String doctorId, 
			String doctorScheduleIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingDoctorScheduleList(userContext, doctorId,  doctorScheduleIds, tokensExpr);
			
			
			Doctor doctor = loadDoctor(userContext, doctorId, allTokens());
			synchronized(doctor){ 
				//Will be good when the doctor loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getDoctorDAO().planToRemoveDoctorScheduleList(doctor, doctorScheduleIds, allTokens());
				doctor = saveDoctor(userContext, doctor, tokens().withDoctorScheduleList().done());
				deleteRelationListInGraph(userContext, doctor.getDoctorScheduleList());
				return present(userContext,doctor, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingDoctorSchedule(HisUserContext userContext, String doctorId, 
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfDoctor( doctorId);
		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
		userContext.getChecker().checkVersionOfDoctorSchedule(doctorScheduleVersion);
		userContext.getChecker().throwExceptionIfHasErrors(DoctorManagerException.class);
	
	}
	public  Doctor removeDoctorSchedule(HisUserContext userContext, String doctorId, 
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingDoctorSchedule(userContext,doctorId, doctorScheduleId, doctorScheduleVersion,tokensExpr);
		
		DoctorSchedule doctorSchedule = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);
		Doctor doctor = loadDoctor(userContext, doctorId, allTokens());
		synchronized(doctor){ 
			//Will be good when the doctor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			doctor.removeDoctorSchedule( doctorSchedule );		
			doctor = saveDoctor(userContext, doctor, tokens().withDoctorScheduleList().done());
			deleteRelationInGraph(userContext, doctorSchedule);
			return present(userContext,doctor, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingDoctorSchedule(HisUserContext userContext, String doctorId, 
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfDoctor( doctorId);
		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
		userContext.getChecker().checkVersionOfDoctorSchedule(doctorScheduleVersion);
		userContext.getChecker().throwExceptionIfHasErrors(DoctorManagerException.class);
	
	}
	public  Doctor copyDoctorScheduleFrom(HisUserContext userContext, String doctorId, 
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingDoctorSchedule(userContext,doctorId, doctorScheduleId, doctorScheduleVersion,tokensExpr);
		
		DoctorSchedule doctorSchedule = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);
		Doctor doctor = loadDoctor(userContext, doctorId, allTokens());
		synchronized(doctor){ 
			//Will be good when the doctor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			doctorSchedule.updateUpdateTime(userContext.now());
			
			doctor.copyDoctorScheduleFrom( doctorSchedule );		
			doctor = saveDoctor(userContext, doctor, tokens().withDoctorScheduleList().done());
			
			userContext.getManagerGroup().getDoctorScheduleManager().onNewInstanceCreated(userContext, (DoctorSchedule)doctor.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,doctor, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingDoctorSchedule(HisUserContext userContext, String doctorId, String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfDoctor(doctorId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(DoctorManagerException.class);
	
	}
	
	public  Doctor updateDoctorSchedule(HisUserContext userContext, String doctorId, String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingDoctorSchedule(userContext, doctorId, doctorScheduleId, doctorScheduleVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withDoctorScheduleList().searchDoctorScheduleListWith(DoctorSchedule.ID_PROPERTY, "eq", doctorScheduleId).done();
		
		
		
		Doctor doctor = loadDoctor(userContext, doctorId, loadTokens);
		
		synchronized(doctor){ 
			//Will be good when the doctor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//doctor.removeDoctorSchedule( doctorSchedule );	
			//make changes to AcceleraterAccount.
			DoctorSchedule doctorScheduleIndex = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);
		
			DoctorSchedule doctorSchedule = doctor.findTheDoctorSchedule(doctorScheduleIndex);
			if(doctorSchedule == null){
				throw new DoctorManagerException(doctorSchedule+" is NOT FOUND" );
			}
			
			doctorSchedule.changeProperty(property, newValueExpr);
			doctorSchedule.updateUpdateTime(userContext.now());
			doctor = saveDoctor(userContext, doctor, tokens().withDoctorScheduleList().done());
			return present(userContext,doctor, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(HisUserContext userContext, Doctor newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


