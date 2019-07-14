
package com.doublechaintech.his.department;

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






public class DepartmentManagerImpl extends CustomHisCheckerManager implements DepartmentManager {
	
	private static final String SERVICE_TYPE = "Department";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws DepartmentManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new DepartmentManagerException(message);

	}
	
	

 	protected Department saveDepartment(HisUserContext userContext, Department department, String [] tokensExpr) throws Exception{	
 		//return getDepartmentDAO().save(department, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveDepartment(userContext, department, tokens);
 	}
 	
 	protected Department saveDepartmentDetail(HisUserContext userContext, Department department) throws Exception{	

 		
 		return saveDepartment(userContext, department, allTokens());
 	}
 	
 	public Department loadDepartment(HisUserContext userContext, String departmentId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfDepartment(departmentId);
		userContext.getChecker().throwExceptionIfHasErrors( DepartmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Department department = loadDepartment( userContext, departmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,department, tokens);
 	}
 	
 	
 	 public Department searchDepartment(HisUserContext userContext, String departmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfDepartment(departmentId);
		userContext.getChecker().throwExceptionIfHasErrors( DepartmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Department department = loadDepartment( userContext, departmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,department, tokens);
 	}
 	
 	

 	protected Department present(HisUserContext userContext, Department department, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,department,tokens);
		
		
		Department  departmentToPresent = userContext.getDAOGroup().getDepartmentDAO().present(department, tokens);
		
		List<BaseEntity> entityListToNaming = departmentToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getDepartmentDAO().alias(entityListToNaming);
		
		return  departmentToPresent;
		
		
	}
 
 	
 	
 	public Department loadDepartmentDetail(HisUserContext userContext, String departmentId) throws Exception{	
 		Department department = loadDepartment( userContext, departmentId, allTokens());
 		return present(userContext,department, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String departmentId) throws Exception{	
 		Department department = loadDepartment( userContext, departmentId, viewTokens());
 		return present(userContext,department, allTokens());
		
 	}
 	protected Department saveDepartment(HisUserContext userContext, Department department, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getDepartmentDAO().save(department, tokens);
 	}
 	protected Department loadDepartment(HisUserContext userContext, String departmentId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfDepartment(departmentId);
		userContext.getChecker().throwExceptionIfHasErrors( DepartmentManagerException.class);

 
 		return userContext.getDAOGroup().getDepartmentDAO().load(departmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, Department department, Map<String, Object> tokens){
		super.addActions(userContext, department, tokens);
		
		addAction(userContext, department, tokens,"@create","createDepartment","createDepartment/","main","primary");
		addAction(userContext, department, tokens,"@update","updateDepartment","updateDepartment/"+department.getId()+"/","main","primary");
		addAction(userContext, department, tokens,"@copy","cloneDepartment","cloneDepartment/"+department.getId()+"/","main","primary");
		
		addAction(userContext, department, tokens,"department.transfer_to_hospital","transferToAnotherHospital","transferToAnotherHospital/"+department.getId()+"/","main","primary");
		addAction(userContext, department, tokens,"department.addDoctorAssignment","addDoctorAssignment","addDoctorAssignment/"+department.getId()+"/","doctorAssignmentList","primary");
		addAction(userContext, department, tokens,"department.removeDoctorAssignment","removeDoctorAssignment","removeDoctorAssignment/"+department.getId()+"/","doctorAssignmentList","primary");
		addAction(userContext, department, tokens,"department.updateDoctorAssignment","updateDoctorAssignment","updateDoctorAssignment/"+department.getId()+"/","doctorAssignmentList","primary");
		addAction(userContext, department, tokens,"department.copyDoctorAssignmentFrom","copyDoctorAssignmentFrom","copyDoctorAssignmentFrom/"+department.getId()+"/","doctorAssignmentList","primary");
		addAction(userContext, department, tokens,"department.addDoctorSchedule","addDoctorSchedule","addDoctorSchedule/"+department.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, department, tokens,"department.removeDoctorSchedule","removeDoctorSchedule","removeDoctorSchedule/"+department.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, department, tokens,"department.updateDoctorSchedule","updateDoctorSchedule","updateDoctorSchedule/"+department.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, department, tokens,"department.copyDoctorScheduleFrom","copyDoctorScheduleFrom","copyDoctorScheduleFrom/"+department.getId()+"/","doctorScheduleList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, Department department, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Department createDepartment(HisUserContext userContext,String name, String hospitalId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfDepartment(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(DepartmentManagerException.class);


		Department department=createNewDepartment();	

		department.setName(name);
			
		Hospital hospital = loadHospital(userContext, hospitalId,emptyOptions());
		department.setHospital(hospital);
		
		
		department.setUpdateTime(userContext.now());

		department = saveDepartment(userContext, department, emptyOptions());
		
		onNewInstanceCreated(userContext, department);
		return department;

		
	}
	protected Department createNewDepartment() 
	{
		
		return new Department();		
	}
	
	protected void checkParamsForUpdatingDepartment(HisUserContext userContext,String departmentId, int departmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfDepartment(departmentId);
		userContext.getChecker().checkVersionOfDepartment( departmentVersion);
		

		if(Department.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfDepartment(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(DepartmentManagerException.class);
	
		
	}
	
	
	
	public Department clone(HisUserContext userContext, String fromDepartmentId) throws Exception{
		
		return userContext.getDAOGroup().getDepartmentDAO().clone(fromDepartmentId, this.allTokens());
	}
	
	public Department internalSaveDepartment(HisUserContext userContext, Department department) throws Exception 
	{
		return internalSaveDepartment(userContext, department, allTokens());

	}
	public Department internalSaveDepartment(HisUserContext userContext, Department department, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingDepartment(userContext, departmentId, departmentVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(department){ 
			//will be good when the department loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Department.
			if (department.isChanged()){
			department.updateUpdateTime(userContext.now());
			}
			department = saveDepartment(userContext, department, options);
			return department;
			
		}

	}
	
	public Department updateDepartment(HisUserContext userContext,String departmentId, int departmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingDepartment(userContext, departmentId, departmentVersion, property, newValueExpr, tokensExpr);
		
		
		
		Department department = loadDepartment(userContext, departmentId, allTokens());
		if(department.getVersion() != departmentVersion){
			String message = "The target version("+department.getVersion()+") is not equals to version("+departmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(department){ 
			//will be good when the department loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Department.
			department.updateUpdateTime(userContext.now());
			department.changeProperty(property, newValueExpr);
			department = saveDepartment(userContext, department, tokens().done());
			return present(userContext,department, mergedAllTokens(tokensExpr));
			//return saveDepartment(userContext, department, tokens().done());
		}

	}
	
	public Department updateDepartmentProperty(HisUserContext userContext,String departmentId, int departmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingDepartment(userContext, departmentId, departmentVersion, property, newValueExpr, tokensExpr);
		
		Department department = loadDepartment(userContext, departmentId, allTokens());
		if(department.getVersion() != departmentVersion){
			String message = "The target version("+department.getVersion()+") is not equals to version("+departmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(department){ 
			//will be good when the department loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Department.
			
			department.changeProperty(property, newValueExpr);
			department.updateUpdateTime(userContext.now());
			department = saveDepartment(userContext, department, tokens().done());
			return present(userContext,department, mergedAllTokens(tokensExpr));
			//return saveDepartment(userContext, department, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected DepartmentTokens tokens(){
		return DepartmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return DepartmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortDoctorAssignmentListWith("id","desc")
		.sortDoctorScheduleListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return DepartmentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherHospital(HisUserContext userContext, String departmentId, String anotherHospitalId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfDepartment(departmentId);
 		userContext.getChecker().checkIdOfHospital(anotherHospitalId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(DepartmentManagerException.class);
 		
 	}
 	public Department transferToAnotherHospital(HisUserContext userContext, String departmentId, String anotherHospitalId) throws Exception
 	{
 		checkParamsForTransferingAnotherHospital(userContext, departmentId,anotherHospitalId);
 
		Department department = loadDepartment(userContext, departmentId, allTokens());	
		synchronized(department){
			//will be good when the department loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Hospital hospital = loadHospital(userContext, anotherHospitalId, emptyOptions());		
			department.updateHospital(hospital);		
			department = saveDepartment(userContext, department, emptyOptions());
			
			return present(userContext,department, allTokens());
			
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
		SmartList<Hospital> candidateList = userContext.getDAOGroup().getHospitalDAO().requestCandidateHospitalForDepartment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(HisUserContext userContext, String departmentId, int departmentVersion) throws Exception {
		//deleteInternal(userContext, departmentId, departmentVersion);		
	}
	protected void deleteInternal(HisUserContext userContext,
			String departmentId, int departmentVersion) throws Exception{
			
		userContext.getDAOGroup().getDepartmentDAO().delete(departmentId, departmentVersion);
	}
	
	public Department forgetByAll(HisUserContext userContext, String departmentId, int departmentVersion) throws Exception {
		return forgetByAllInternal(userContext, departmentId, departmentVersion);		
	}
	protected Department forgetByAllInternal(HisUserContext userContext,
			String departmentId, int departmentVersion) throws Exception{
			
		return userContext.getDAOGroup().getDepartmentDAO().disconnectFromAll(departmentId, departmentVersion);
	}
	

	
	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new DepartmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getDepartmentDAO().deleteAll();
	}


	//disconnect Department with doctor in DoctorAssignment
	protected Department breakWithDoctorAssignmentByDoctor(HisUserContext userContext, String departmentId, String doctorId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Department department = loadDepartment(userContext, departmentId, allTokens());

			synchronized(department){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getDepartmentDAO().planToRemoveDoctorAssignmentListWithDoctor(department, doctorId, this.emptyOptions());

				department = saveDepartment(userContext, department, tokens().withDoctorAssignmentList().done());
				return department;
			}
	}
	//disconnect Department with doctor in DoctorSchedule
	protected Department breakWithDoctorScheduleByDoctor(HisUserContext userContext, String departmentId, String doctorId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Department department = loadDepartment(userContext, departmentId, allTokens());

			synchronized(department){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getDepartmentDAO().planToRemoveDoctorScheduleListWithDoctor(department, doctorId, this.emptyOptions());

				department = saveDepartment(userContext, department, tokens().withDoctorScheduleList().done());
				return department;
			}
	}
	//disconnect Department with period in DoctorSchedule
	protected Department breakWithDoctorScheduleByPeriod(HisUserContext userContext, String departmentId, String periodId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Department department = loadDepartment(userContext, departmentId, allTokens());

			synchronized(department){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getDepartmentDAO().planToRemoveDoctorScheduleListWithPeriod(department, periodId, this.emptyOptions());

				department = saveDepartment(userContext, department, tokens().withDoctorScheduleList().done());
				return department;
			}
	}
	//disconnect Department with expense_type in DoctorSchedule
	protected Department breakWithDoctorScheduleByExpenseType(HisUserContext userContext, String departmentId, String expenseTypeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Department department = loadDepartment(userContext, departmentId, allTokens());

			synchronized(department){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getDepartmentDAO().planToRemoveDoctorScheduleListWithExpenseType(department, expenseTypeId, this.emptyOptions());

				department = saveDepartment(userContext, department, tokens().withDoctorScheduleList().done());
				return department;
			}
	}
	//disconnect Department with hospital in DoctorSchedule
	protected Department breakWithDoctorScheduleByHospital(HisUserContext userContext, String departmentId, String hospitalId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Department department = loadDepartment(userContext, departmentId, allTokens());

			synchronized(department){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getDepartmentDAO().planToRemoveDoctorScheduleListWithHospital(department, hospitalId, this.emptyOptions());

				department = saveDepartment(userContext, department, tokens().withDoctorScheduleList().done());
				return department;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingDoctorAssignment(HisUserContext userContext, String departmentId, String name, String doctorId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfDepartment(departmentId);

		
		userContext.getChecker().checkNameOfDoctorAssignment(name);
		
		userContext.getChecker().checkDoctorIdOfDoctorAssignment(doctorId);
	
		userContext.getChecker().throwExceptionIfHasErrors(DepartmentManagerException.class);

	
	}
	public  Department addDoctorAssignment(HisUserContext userContext, String departmentId, String name, String doctorId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingDoctorAssignment(userContext,departmentId,name, doctorId,tokensExpr);
		
		DoctorAssignment doctorAssignment = createDoctorAssignment(userContext,name, doctorId);
		
		Department department = loadDepartment(userContext, departmentId, allTokens());
		synchronized(department){ 
			//Will be good when the department loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			department.addDoctorAssignment( doctorAssignment );		
			department = saveDepartment(userContext, department, tokens().withDoctorAssignmentList().done());
			
			userContext.getManagerGroup().getDoctorAssignmentManager().onNewInstanceCreated(userContext, doctorAssignment);
			return present(userContext,department, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingDoctorAssignmentProperties(HisUserContext userContext, String departmentId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfDepartment(departmentId);
		userContext.getChecker().checkIdOfDoctorAssignment(id);
		
		userContext.getChecker().checkNameOfDoctorAssignment( name);

		userContext.getChecker().throwExceptionIfHasErrors(DepartmentManagerException.class);
		
	}
	public  Department updateDoctorAssignmentProperties(HisUserContext userContext, String departmentId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingDoctorAssignmentProperties(userContext,departmentId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withDoctorAssignmentListList()
				.searchDoctorAssignmentListWith(DoctorAssignment.ID_PROPERTY, "is", id).done();
		
		Department departmentToUpdate = loadDepartment(userContext, departmentId, options);
		
		if(departmentToUpdate.getDoctorAssignmentList().isEmpty()){
			throw new DepartmentManagerException("DoctorAssignment is NOT FOUND with id: '"+id+"'");
		}
		
		DoctorAssignment item = departmentToUpdate.getDoctorAssignmentList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingDoctorAssignment(userContext,departmentId,name, code, used,tokensExpr);
		Department department = saveDepartment(userContext, departmentToUpdate, tokens().withDoctorAssignmentList().done());
		synchronized(department){ 
			return present(userContext,department, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected DoctorAssignment createDoctorAssignment(HisUserContext userContext, String name, String doctorId) throws Exception{

		DoctorAssignment doctorAssignment = new DoctorAssignment();
		
		
		doctorAssignment.setName(name);		
		Doctor  doctor = new Doctor();
		doctor.setId(doctorId);		
		doctorAssignment.setDoctor(doctor);		
		doctorAssignment.setUpdateTime(userContext.now());
	
		
		return doctorAssignment;
	
		
	}
	
	protected DoctorAssignment createIndexedDoctorAssignment(String id, int version){

		DoctorAssignment doctorAssignment = new DoctorAssignment();
		doctorAssignment.setId(id);
		doctorAssignment.setVersion(version);
		return doctorAssignment;			
		
	}
	
	protected void checkParamsForRemovingDoctorAssignmentList(HisUserContext userContext, String departmentId, 
			String doctorAssignmentIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfDepartment(departmentId);
		for(String doctorAssignmentIdItem: doctorAssignmentIds){
			userContext.getChecker().checkIdOfDoctorAssignment(doctorAssignmentIdItem);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(DepartmentManagerException.class);
		
	}
	public  Department removeDoctorAssignmentList(HisUserContext userContext, String departmentId, 
			String doctorAssignmentIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingDoctorAssignmentList(userContext, departmentId,  doctorAssignmentIds, tokensExpr);
			
			
			Department department = loadDepartment(userContext, departmentId, allTokens());
			synchronized(department){ 
				//Will be good when the department loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getDepartmentDAO().planToRemoveDoctorAssignmentList(department, doctorAssignmentIds, allTokens());
				department = saveDepartment(userContext, department, tokens().withDoctorAssignmentList().done());
				deleteRelationListInGraph(userContext, department.getDoctorAssignmentList());
				return present(userContext,department, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingDoctorAssignment(HisUserContext userContext, String departmentId, 
		String doctorAssignmentId, int doctorAssignmentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfDepartment( departmentId);
		userContext.getChecker().checkIdOfDoctorAssignment(doctorAssignmentId);
		userContext.getChecker().checkVersionOfDoctorAssignment(doctorAssignmentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(DepartmentManagerException.class);
	
	}
	public  Department removeDoctorAssignment(HisUserContext userContext, String departmentId, 
		String doctorAssignmentId, int doctorAssignmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingDoctorAssignment(userContext,departmentId, doctorAssignmentId, doctorAssignmentVersion,tokensExpr);
		
		DoctorAssignment doctorAssignment = createIndexedDoctorAssignment(doctorAssignmentId, doctorAssignmentVersion);
		Department department = loadDepartment(userContext, departmentId, allTokens());
		synchronized(department){ 
			//Will be good when the department loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			department.removeDoctorAssignment( doctorAssignment );		
			department = saveDepartment(userContext, department, tokens().withDoctorAssignmentList().done());
			deleteRelationInGraph(userContext, doctorAssignment);
			return present(userContext,department, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingDoctorAssignment(HisUserContext userContext, String departmentId, 
		String doctorAssignmentId, int doctorAssignmentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfDepartment( departmentId);
		userContext.getChecker().checkIdOfDoctorAssignment(doctorAssignmentId);
		userContext.getChecker().checkVersionOfDoctorAssignment(doctorAssignmentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(DepartmentManagerException.class);
	
	}
	public  Department copyDoctorAssignmentFrom(HisUserContext userContext, String departmentId, 
		String doctorAssignmentId, int doctorAssignmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingDoctorAssignment(userContext,departmentId, doctorAssignmentId, doctorAssignmentVersion,tokensExpr);
		
		DoctorAssignment doctorAssignment = createIndexedDoctorAssignment(doctorAssignmentId, doctorAssignmentVersion);
		Department department = loadDepartment(userContext, departmentId, allTokens());
		synchronized(department){ 
			//Will be good when the department loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			doctorAssignment.updateUpdateTime(userContext.now());
			
			department.copyDoctorAssignmentFrom( doctorAssignment );		
			department = saveDepartment(userContext, department, tokens().withDoctorAssignmentList().done());
			
			userContext.getManagerGroup().getDoctorAssignmentManager().onNewInstanceCreated(userContext, (DoctorAssignment)department.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,department, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingDoctorAssignment(HisUserContext userContext, String departmentId, String doctorAssignmentId, int doctorAssignmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfDepartment(departmentId);
		userContext.getChecker().checkIdOfDoctorAssignment(doctorAssignmentId);
		userContext.getChecker().checkVersionOfDoctorAssignment(doctorAssignmentVersion);
		

		if(DoctorAssignment.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfDoctorAssignment(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(DepartmentManagerException.class);
	
	}
	
	public  Department updateDoctorAssignment(HisUserContext userContext, String departmentId, String doctorAssignmentId, int doctorAssignmentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingDoctorAssignment(userContext, departmentId, doctorAssignmentId, doctorAssignmentVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withDoctorAssignmentList().searchDoctorAssignmentListWith(DoctorAssignment.ID_PROPERTY, "eq", doctorAssignmentId).done();
		
		
		
		Department department = loadDepartment(userContext, departmentId, loadTokens);
		
		synchronized(department){ 
			//Will be good when the department loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//department.removeDoctorAssignment( doctorAssignment );	
			//make changes to AcceleraterAccount.
			DoctorAssignment doctorAssignmentIndex = createIndexedDoctorAssignment(doctorAssignmentId, doctorAssignmentVersion);
		
			DoctorAssignment doctorAssignment = department.findTheDoctorAssignment(doctorAssignmentIndex);
			if(doctorAssignment == null){
				throw new DepartmentManagerException(doctorAssignment+" is NOT FOUND" );
			}
			
			doctorAssignment.changeProperty(property, newValueExpr);
			doctorAssignment.updateUpdateTime(userContext.now());
			department = saveDepartment(userContext, department, tokens().withDoctorAssignmentList().done());
			return present(userContext,department, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingDoctorSchedule(HisUserContext userContext, String departmentId, String name, String doctorId, Date scheduleDate, String periodId, int available, BigDecimal price, String expenseTypeId, String hospitalId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfDepartment(departmentId);

		
		userContext.getChecker().checkNameOfDoctorSchedule(name);
		
		userContext.getChecker().checkDoctorIdOfDoctorSchedule(doctorId);
		
		userContext.getChecker().checkScheduleDateOfDoctorSchedule(scheduleDate);
		
		userContext.getChecker().checkPeriodIdOfDoctorSchedule(periodId);
		
		userContext.getChecker().checkAvailableOfDoctorSchedule(available);
		
		userContext.getChecker().checkPriceOfDoctorSchedule(price);
		
		userContext.getChecker().checkExpenseTypeIdOfDoctorSchedule(expenseTypeId);
		
		userContext.getChecker().checkHospitalIdOfDoctorSchedule(hospitalId);
	
		userContext.getChecker().throwExceptionIfHasErrors(DepartmentManagerException.class);

	
	}
	public  Department addDoctorSchedule(HisUserContext userContext, String departmentId, String name, String doctorId, Date scheduleDate, String periodId, int available, BigDecimal price, String expenseTypeId, String hospitalId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingDoctorSchedule(userContext,departmentId,name, doctorId, scheduleDate, periodId, available, price, expenseTypeId, hospitalId,tokensExpr);
		
		DoctorSchedule doctorSchedule = createDoctorSchedule(userContext,name, doctorId, scheduleDate, periodId, available, price, expenseTypeId, hospitalId);
		
		Department department = loadDepartment(userContext, departmentId, allTokens());
		synchronized(department){ 
			//Will be good when the department loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			department.addDoctorSchedule( doctorSchedule );		
			department = saveDepartment(userContext, department, tokens().withDoctorScheduleList().done());
			
			userContext.getManagerGroup().getDoctorScheduleManager().onNewInstanceCreated(userContext, doctorSchedule);
			return present(userContext,department, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingDoctorScheduleProperties(HisUserContext userContext, String departmentId,String id,String name,Date scheduleDate,int available,BigDecimal price,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfDepartment(departmentId);
		userContext.getChecker().checkIdOfDoctorSchedule(id);
		
		userContext.getChecker().checkNameOfDoctorSchedule( name);
		userContext.getChecker().checkScheduleDateOfDoctorSchedule( scheduleDate);
		userContext.getChecker().checkAvailableOfDoctorSchedule( available);
		userContext.getChecker().checkPriceOfDoctorSchedule( price);

		userContext.getChecker().throwExceptionIfHasErrors(DepartmentManagerException.class);
		
	}
	public  Department updateDoctorScheduleProperties(HisUserContext userContext, String departmentId, String id,String name,Date scheduleDate,int available,BigDecimal price, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingDoctorScheduleProperties(userContext,departmentId,id,name,scheduleDate,available,price,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withDoctorScheduleListList()
				.searchDoctorScheduleListWith(DoctorSchedule.ID_PROPERTY, "is", id).done();
		
		Department departmentToUpdate = loadDepartment(userContext, departmentId, options);
		
		if(departmentToUpdate.getDoctorScheduleList().isEmpty()){
			throw new DepartmentManagerException("DoctorSchedule is NOT FOUND with id: '"+id+"'");
		}
		
		DoctorSchedule item = departmentToUpdate.getDoctorScheduleList().first();
		
		item.updateName( name );
		item.updateScheduleDate( scheduleDate );
		item.updateAvailable( available );
		item.updatePrice( price );

		
		//checkParamsForAddingDoctorSchedule(userContext,departmentId,name, code, used,tokensExpr);
		Department department = saveDepartment(userContext, departmentToUpdate, tokens().withDoctorScheduleList().done());
		synchronized(department){ 
			return present(userContext,department, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected DoctorSchedule createDoctorSchedule(HisUserContext userContext, String name, String doctorId, Date scheduleDate, String periodId, int available, BigDecimal price, String expenseTypeId, String hospitalId) throws Exception{

		DoctorSchedule doctorSchedule = new DoctorSchedule();
		
		
		doctorSchedule.setName(name);		
		Doctor  doctor = new Doctor();
		doctor.setId(doctorId);		
		doctorSchedule.setDoctor(doctor);		
		doctorSchedule.setScheduleDate(scheduleDate);		
		Period  period = new Period();
		period.setId(periodId);		
		doctorSchedule.setPeriod(period);		
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
	
	protected void checkParamsForRemovingDoctorScheduleList(HisUserContext userContext, String departmentId, 
			String doctorScheduleIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfDepartment(departmentId);
		for(String doctorScheduleIdItem: doctorScheduleIds){
			userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleIdItem);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(DepartmentManagerException.class);
		
	}
	public  Department removeDoctorScheduleList(HisUserContext userContext, String departmentId, 
			String doctorScheduleIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingDoctorScheduleList(userContext, departmentId,  doctorScheduleIds, tokensExpr);
			
			
			Department department = loadDepartment(userContext, departmentId, allTokens());
			synchronized(department){ 
				//Will be good when the department loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getDepartmentDAO().planToRemoveDoctorScheduleList(department, doctorScheduleIds, allTokens());
				department = saveDepartment(userContext, department, tokens().withDoctorScheduleList().done());
				deleteRelationListInGraph(userContext, department.getDoctorScheduleList());
				return present(userContext,department, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingDoctorSchedule(HisUserContext userContext, String departmentId, 
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfDepartment( departmentId);
		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
		userContext.getChecker().checkVersionOfDoctorSchedule(doctorScheduleVersion);
		userContext.getChecker().throwExceptionIfHasErrors(DepartmentManagerException.class);
	
	}
	public  Department removeDoctorSchedule(HisUserContext userContext, String departmentId, 
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingDoctorSchedule(userContext,departmentId, doctorScheduleId, doctorScheduleVersion,tokensExpr);
		
		DoctorSchedule doctorSchedule = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);
		Department department = loadDepartment(userContext, departmentId, allTokens());
		synchronized(department){ 
			//Will be good when the department loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			department.removeDoctorSchedule( doctorSchedule );		
			department = saveDepartment(userContext, department, tokens().withDoctorScheduleList().done());
			deleteRelationInGraph(userContext, doctorSchedule);
			return present(userContext,department, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingDoctorSchedule(HisUserContext userContext, String departmentId, 
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfDepartment( departmentId);
		userContext.getChecker().checkIdOfDoctorSchedule(doctorScheduleId);
		userContext.getChecker().checkVersionOfDoctorSchedule(doctorScheduleVersion);
		userContext.getChecker().throwExceptionIfHasErrors(DepartmentManagerException.class);
	
	}
	public  Department copyDoctorScheduleFrom(HisUserContext userContext, String departmentId, 
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingDoctorSchedule(userContext,departmentId, doctorScheduleId, doctorScheduleVersion,tokensExpr);
		
		DoctorSchedule doctorSchedule = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);
		Department department = loadDepartment(userContext, departmentId, allTokens());
		synchronized(department){ 
			//Will be good when the department loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			doctorSchedule.updateUpdateTime(userContext.now());
			
			department.copyDoctorScheduleFrom( doctorSchedule );		
			department = saveDepartment(userContext, department, tokens().withDoctorScheduleList().done());
			
			userContext.getManagerGroup().getDoctorScheduleManager().onNewInstanceCreated(userContext, (DoctorSchedule)department.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,department, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingDoctorSchedule(HisUserContext userContext, String departmentId, String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfDepartment(departmentId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(DepartmentManagerException.class);
	
	}
	
	public  Department updateDoctorSchedule(HisUserContext userContext, String departmentId, String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingDoctorSchedule(userContext, departmentId, doctorScheduleId, doctorScheduleVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withDoctorScheduleList().searchDoctorScheduleListWith(DoctorSchedule.ID_PROPERTY, "eq", doctorScheduleId).done();
		
		
		
		Department department = loadDepartment(userContext, departmentId, loadTokens);
		
		synchronized(department){ 
			//Will be good when the department loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//department.removeDoctorSchedule( doctorSchedule );	
			//make changes to AcceleraterAccount.
			DoctorSchedule doctorScheduleIndex = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);
		
			DoctorSchedule doctorSchedule = department.findTheDoctorSchedule(doctorScheduleIndex);
			if(doctorSchedule == null){
				throw new DepartmentManagerException(doctorSchedule+" is NOT FOUND" );
			}
			
			doctorSchedule.changeProperty(property, newValueExpr);
			doctorSchedule.updateUpdateTime(userContext.now());
			department = saveDepartment(userContext, department, tokens().withDoctorScheduleList().done());
			return present(userContext,department, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(HisUserContext userContext, Department newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


