
package com.doublechaintech.his.doctor;

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
import com.doublechaintech.his.doctorassignment.DoctorAssignment;

import com.doublechaintech.his.hospital.CandidateHospital;

import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;






public class DoctorManagerImpl extends CustomHisCheckerManager implements DoctorManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "Doctor";
	@Override
	public DoctorDAO daoOf(HisUserContext userContext) {
		return doctorDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfDoctor(doctorId);
		checkerOf(userContext).throwExceptionIfHasErrors( DoctorManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Doctor doctor = loadDoctor( userContext, doctorId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,doctor, tokens);
 	}
 	
 	
 	 public Doctor searchDoctor(HisUserContext userContext, String doctorId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfDoctor(doctorId);
		checkerOf(userContext).throwExceptionIfHasErrors( DoctorManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Doctor doctor = loadDoctor( userContext, doctorId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,doctor, tokens);
 	}
 	
 	

 	protected Doctor present(HisUserContext userContext, Doctor doctor, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,doctor,tokens);
		
		
		Doctor  doctorToPresent = doctorDaoOf(userContext).present(doctor, tokens);
		
		List<BaseEntity> entityListToNaming = doctorToPresent.collectRefercencesFromLists();
		doctorDaoOf(userContext).alias(entityListToNaming);
		
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
 		return doctorDaoOf(userContext).save(doctor, tokens);
 	}
 	protected Doctor loadDoctor(HisUserContext userContext, String doctorId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfDoctor(doctorId);
		checkerOf(userContext).throwExceptionIfHasErrors( DoctorManagerException.class);

 
 		return doctorDaoOf(userContext).load(doctorId, tokens);
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
	
 	
 	
 
 	
 	

	public Doctor createDoctor(HisUserContext userContext, String name,String shotImage,String hospitalId) throws Exception
	//public Doctor createDoctor(HisUserContext userContext,String name, String shotImage, String hospitalId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfDoctor(name);
		checkerOf(userContext).checkShotImageOfDoctor(shotImage);
	
		checkerOf(userContext).throwExceptionIfHasErrors(DoctorManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfDoctor(doctorId);
		checkerOf(userContext).checkVersionOfDoctor( doctorVersion);
		

		if(Doctor.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfDoctor(parseString(newValueExpr));
		
			
		}
		if(Doctor.SHOT_IMAGE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkShotImageOfDoctor(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(DoctorManagerException.class);


	}



	public Doctor clone(HisUserContext userContext, String fromDoctorId) throws Exception{

		return doctorDaoOf(userContext).clone(fromDoctorId, this.allTokens());
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

 		checkerOf(userContext).checkIdOfDoctor(doctorId);
 		checkerOf(userContext).checkIdOfHospital(anotherHospitalId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(DoctorManagerException.class);

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
		SmartList<Hospital> candidateList = hospitalDaoOf(userContext).requestCandidateHospitalForDoctor(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(HisUserContext userContext, String doctorId, int doctorVersion) throws Exception {
		//deleteInternal(userContext, doctorId, doctorVersion);
	}
	protected void deleteInternal(HisUserContext userContext,
			String doctorId, int doctorVersion) throws Exception{

		doctorDaoOf(userContext).delete(doctorId, doctorVersion);
	}

	public Doctor forgetByAll(HisUserContext userContext, String doctorId, int doctorVersion) throws Exception {
		return forgetByAllInternal(userContext, doctorId, doctorVersion);
	}
	protected Doctor forgetByAllInternal(HisUserContext userContext,
			String doctorId, int doctorVersion) throws Exception{

		return doctorDaoOf(userContext).disconnectFromAll(doctorId, doctorVersion);
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
		return doctorDaoOf(userContext).deleteAll();
	}


	//disconnect Doctor with department in DoctorAssignment
	protected Doctor breakWithDoctorAssignmentByDepartment(HisUserContext userContext, String doctorId, String departmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Doctor doctor = loadDoctor(userContext, doctorId, allTokens());

			synchronized(doctor){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				doctorDaoOf(userContext).planToRemoveDoctorAssignmentListWithDepartment(doctor, departmentId, this.emptyOptions());

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

				doctorDaoOf(userContext).planToRemoveDoctorScheduleListWithPeriod(doctor, periodId, this.emptyOptions());

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

				doctorDaoOf(userContext).planToRemoveDoctorScheduleListWithDepartment(doctor, departmentId, this.emptyOptions());

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

				doctorDaoOf(userContext).planToRemoveDoctorScheduleListWithExpenseType(doctor, expenseTypeId, this.emptyOptions());

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

				doctorDaoOf(userContext).planToRemoveDoctorScheduleListWithHospital(doctor, hospitalId, this.emptyOptions());

				doctor = saveDoctor(userContext, doctor, tokens().withDoctorScheduleList().done());
				return doctor;
			}
	}






	protected void checkParamsForAddingDoctorAssignment(HisUserContext userContext, String doctorId, String name, String departmentId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfDoctor(doctorId);

		
		checkerOf(userContext).checkNameOfDoctorAssignment(name);
		
		checkerOf(userContext).checkDepartmentIdOfDoctorAssignment(departmentId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(DoctorManagerException.class);


	}
	public  Doctor addDoctorAssignment(HisUserContext userContext, String doctorId, String name, String departmentId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingDoctorAssignment(userContext,doctorId,name, departmentId,tokensExpr);

		DoctorAssignment doctorAssignment = createDoctorAssignment(userContext,name, departmentId);

		Doctor doctor = loadDoctor(userContext, doctorId, emptyOptions());
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

		checkerOf(userContext).checkIdOfDoctor(doctorId);
		checkerOf(userContext).checkIdOfDoctorAssignment(id);

		checkerOf(userContext).checkNameOfDoctorAssignment( name);

		checkerOf(userContext).throwExceptionIfHasErrors(DoctorManagerException.class);

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

		checkerOf(userContext).checkIdOfDoctor(doctorId);
		for(String doctorAssignmentIdItem: doctorAssignmentIds){
			checkerOf(userContext).checkIdOfDoctorAssignment(doctorAssignmentIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(DoctorManagerException.class);

	}
	public  Doctor removeDoctorAssignmentList(HisUserContext userContext, String doctorId,
			String doctorAssignmentIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingDoctorAssignmentList(userContext, doctorId,  doctorAssignmentIds, tokensExpr);


			Doctor doctor = loadDoctor(userContext, doctorId, allTokens());
			synchronized(doctor){
				//Will be good when the doctor loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				doctorDaoOf(userContext).planToRemoveDoctorAssignmentList(doctor, doctorAssignmentIds, allTokens());
				doctor = saveDoctor(userContext, doctor, tokens().withDoctorAssignmentList().done());
				deleteRelationListInGraph(userContext, doctor.getDoctorAssignmentList());
				return present(userContext,doctor, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingDoctorAssignment(HisUserContext userContext, String doctorId,
		String doctorAssignmentId, int doctorAssignmentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfDoctor( doctorId);
		checkerOf(userContext).checkIdOfDoctorAssignment(doctorAssignmentId);
		checkerOf(userContext).checkVersionOfDoctorAssignment(doctorAssignmentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(DoctorManagerException.class);

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
		
		checkerOf(userContext).checkIdOfDoctor( doctorId);
		checkerOf(userContext).checkIdOfDoctorAssignment(doctorAssignmentId);
		checkerOf(userContext).checkVersionOfDoctorAssignment(doctorAssignmentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(DoctorManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfDoctor(doctorId);
		checkerOf(userContext).checkIdOfDoctorAssignment(doctorAssignmentId);
		checkerOf(userContext).checkVersionOfDoctorAssignment(doctorAssignmentVersion);
		

		if(DoctorAssignment.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfDoctorAssignment(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(DoctorManagerException.class);

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

				checkerOf(userContext).checkIdOfDoctor(doctorId);

		
		checkerOf(userContext).checkNameOfDoctorSchedule(name);
		
		checkerOf(userContext).checkScheduleDateOfDoctorSchedule(scheduleDate);
		
		checkerOf(userContext).checkPeriodIdOfDoctorSchedule(periodId);
		
		checkerOf(userContext).checkDepartmentIdOfDoctorSchedule(departmentId);
		
		checkerOf(userContext).checkAvailableOfDoctorSchedule(available);
		
		checkerOf(userContext).checkPriceOfDoctorSchedule(price);
		
		checkerOf(userContext).checkExpenseTypeIdOfDoctorSchedule(expenseTypeId);
		
		checkerOf(userContext).checkHospitalIdOfDoctorSchedule(hospitalId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(DoctorManagerException.class);


	}
	public  Doctor addDoctorSchedule(HisUserContext userContext, String doctorId, String name, Date scheduleDate, String periodId, String departmentId, int available, BigDecimal price, String expenseTypeId, String hospitalId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingDoctorSchedule(userContext,doctorId,name, scheduleDate, periodId, departmentId, available, price, expenseTypeId, hospitalId,tokensExpr);

		DoctorSchedule doctorSchedule = createDoctorSchedule(userContext,name, scheduleDate, periodId, departmentId, available, price, expenseTypeId, hospitalId);

		Doctor doctor = loadDoctor(userContext, doctorId, emptyOptions());
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

		checkerOf(userContext).checkIdOfDoctor(doctorId);
		checkerOf(userContext).checkIdOfDoctorSchedule(id);

		checkerOf(userContext).checkNameOfDoctorSchedule( name);
		checkerOf(userContext).checkScheduleDateOfDoctorSchedule( scheduleDate);
		checkerOf(userContext).checkAvailableOfDoctorSchedule( available);
		checkerOf(userContext).checkPriceOfDoctorSchedule( price);

		checkerOf(userContext).throwExceptionIfHasErrors(DoctorManagerException.class);

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

		checkerOf(userContext).checkIdOfDoctor(doctorId);
		for(String doctorScheduleIdItem: doctorScheduleIds){
			checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(DoctorManagerException.class);

	}
	public  Doctor removeDoctorScheduleList(HisUserContext userContext, String doctorId,
			String doctorScheduleIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingDoctorScheduleList(userContext, doctorId,  doctorScheduleIds, tokensExpr);


			Doctor doctor = loadDoctor(userContext, doctorId, allTokens());
			synchronized(doctor){
				//Will be good when the doctor loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				doctorDaoOf(userContext).planToRemoveDoctorScheduleList(doctor, doctorScheduleIds, allTokens());
				doctor = saveDoctor(userContext, doctor, tokens().withDoctorScheduleList().done());
				deleteRelationListInGraph(userContext, doctor.getDoctorScheduleList());
				return present(userContext,doctor, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingDoctorSchedule(HisUserContext userContext, String doctorId,
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfDoctor( doctorId);
		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
		checkerOf(userContext).checkVersionOfDoctorSchedule(doctorScheduleVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(DoctorManagerException.class);

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
		
		checkerOf(userContext).checkIdOfDoctor( doctorId);
		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
		checkerOf(userContext).checkVersionOfDoctorSchedule(doctorScheduleVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(DoctorManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfDoctor(doctorId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(DoctorManagerException.class);

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
		//   Doctor newDoctor = this.createDoctor(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newDoctor
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Doctor.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(HisUserContext userContext,SmartList<Doctor> list) throws Exception {
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
		SmartList<Doctor> list = doctorDaoOf(userContext).findDoctorByHospital(hospitalId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(Doctor.class);
		page.setContainerObject(Hospital.withId(hospitalId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("医生列表");
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
 	public Object wxappview(HisUserContext userContext, String doctorId) throws Exception{
	  SerializeScope vscope = HisViewScope.getInstance().getDoctorDetailScope().clone();
		Doctor merchantObj = (Doctor) this.view(userContext, doctorId);
    String merchantObjId = doctorId;
    String linkToUrl =	"doctorManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "医生"+"详情";
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
				MapUtil.put("id", "3-shotImage")
				    .put("fieldName", "shotImage")
				    .put("label", "拍摄的图像")
				    .put("type", "image")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("shotImage", merchantObj.getShotImage());

		propList.add(
				MapUtil.put("id", "4-hospital")
				    .put("fieldName", "hospital")
				    .put("label", "医院")
				    .put("type", "object")
				    .put("displayField", "name")
				    .put("linkToUrl", "hospitalManager/wxappview/:id/")
				    .into_map()
		);
		result.put("hospital", merchantObj.getHospital());

		propList.add(
				MapUtil.put("id", "5-updateTime")
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
		    "doctorScheduleManager/listByDoctor/"+merchantObjId+"/",
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


