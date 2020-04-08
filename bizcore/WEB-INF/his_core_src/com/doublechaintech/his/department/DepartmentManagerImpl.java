
package com.doublechaintech.his.department;

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






public class DepartmentManagerImpl extends CustomHisCheckerManager implements DepartmentManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "Department";
	@Override
	public DepartmentDAO daoOf(HisUserContext userContext) {
		return departmentDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfDepartment(departmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( DepartmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Department department = loadDepartment( userContext, departmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,department, tokens);
 	}
 	
 	
 	 public Department searchDepartment(HisUserContext userContext, String departmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfDepartment(departmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( DepartmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Department department = loadDepartment( userContext, departmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,department, tokens);
 	}
 	
 	

 	protected Department present(HisUserContext userContext, Department department, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,department,tokens);
		
		
		Department  departmentToPresent = departmentDaoOf(userContext).present(department, tokens);
		
		List<BaseEntity> entityListToNaming = departmentToPresent.collectRefercencesFromLists();
		departmentDaoOf(userContext).alias(entityListToNaming);
		
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
 		return departmentDaoOf(userContext).save(department, tokens);
 	}
 	protected Department loadDepartment(HisUserContext userContext, String departmentId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfDepartment(departmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( DepartmentManagerException.class);

 
 		return departmentDaoOf(userContext).load(departmentId, tokens);
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
	
 	
 	
 
 	
 	

	public Department createDepartment(HisUserContext userContext, String name,String hospitalId) throws Exception
	//public Department createDepartment(HisUserContext userContext,String name, String hospitalId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfDepartment(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(DepartmentManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfDepartment(departmentId);
		checkerOf(userContext).checkVersionOfDepartment( departmentVersion);
		

		if(Department.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfDepartment(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(DepartmentManagerException.class);


	}



	public Department clone(HisUserContext userContext, String fromDepartmentId) throws Exception{

		return departmentDaoOf(userContext).clone(fromDepartmentId, this.allTokens());
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

 		checkerOf(userContext).checkIdOfDepartment(departmentId);
 		checkerOf(userContext).checkIdOfHospital(anotherHospitalId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(DepartmentManagerException.class);

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
		SmartList<Hospital> candidateList = hospitalDaoOf(userContext).requestCandidateHospitalForDepartment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(HisUserContext userContext, String departmentId, int departmentVersion) throws Exception {
		//deleteInternal(userContext, departmentId, departmentVersion);
	}
	protected void deleteInternal(HisUserContext userContext,
			String departmentId, int departmentVersion) throws Exception{

		departmentDaoOf(userContext).delete(departmentId, departmentVersion);
	}

	public Department forgetByAll(HisUserContext userContext, String departmentId, int departmentVersion) throws Exception {
		return forgetByAllInternal(userContext, departmentId, departmentVersion);
	}
	protected Department forgetByAllInternal(HisUserContext userContext,
			String departmentId, int departmentVersion) throws Exception{

		return departmentDaoOf(userContext).disconnectFromAll(departmentId, departmentVersion);
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
		return departmentDaoOf(userContext).deleteAll();
	}


	//disconnect Department with doctor in DoctorAssignment
	protected Department breakWithDoctorAssignmentByDoctor(HisUserContext userContext, String departmentId, String doctorId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Department department = loadDepartment(userContext, departmentId, allTokens());

			synchronized(department){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				departmentDaoOf(userContext).planToRemoveDoctorAssignmentListWithDoctor(department, doctorId, this.emptyOptions());

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

				departmentDaoOf(userContext).planToRemoveDoctorScheduleListWithDoctor(department, doctorId, this.emptyOptions());

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

				departmentDaoOf(userContext).planToRemoveDoctorScheduleListWithPeriod(department, periodId, this.emptyOptions());

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

				departmentDaoOf(userContext).planToRemoveDoctorScheduleListWithExpenseType(department, expenseTypeId, this.emptyOptions());

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

				departmentDaoOf(userContext).planToRemoveDoctorScheduleListWithHospital(department, hospitalId, this.emptyOptions());

				department = saveDepartment(userContext, department, tokens().withDoctorScheduleList().done());
				return department;
			}
	}






	protected void checkParamsForAddingDoctorAssignment(HisUserContext userContext, String departmentId, String name, String doctorId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfDepartment(departmentId);

		
		checkerOf(userContext).checkNameOfDoctorAssignment(name);
		
		checkerOf(userContext).checkDoctorIdOfDoctorAssignment(doctorId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(DepartmentManagerException.class);


	}
	public  Department addDoctorAssignment(HisUserContext userContext, String departmentId, String name, String doctorId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingDoctorAssignment(userContext,departmentId,name, doctorId,tokensExpr);

		DoctorAssignment doctorAssignment = createDoctorAssignment(userContext,name, doctorId);

		Department department = loadDepartment(userContext, departmentId, emptyOptions());
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

		checkerOf(userContext).checkIdOfDepartment(departmentId);
		checkerOf(userContext).checkIdOfDoctorAssignment(id);

		checkerOf(userContext).checkNameOfDoctorAssignment( name);

		checkerOf(userContext).throwExceptionIfHasErrors(DepartmentManagerException.class);

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

		checkerOf(userContext).checkIdOfDepartment(departmentId);
		for(String doctorAssignmentIdItem: doctorAssignmentIds){
			checkerOf(userContext).checkIdOfDoctorAssignment(doctorAssignmentIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(DepartmentManagerException.class);

	}
	public  Department removeDoctorAssignmentList(HisUserContext userContext, String departmentId,
			String doctorAssignmentIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingDoctorAssignmentList(userContext, departmentId,  doctorAssignmentIds, tokensExpr);


			Department department = loadDepartment(userContext, departmentId, allTokens());
			synchronized(department){
				//Will be good when the department loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				departmentDaoOf(userContext).planToRemoveDoctorAssignmentList(department, doctorAssignmentIds, allTokens());
				department = saveDepartment(userContext, department, tokens().withDoctorAssignmentList().done());
				deleteRelationListInGraph(userContext, department.getDoctorAssignmentList());
				return present(userContext,department, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingDoctorAssignment(HisUserContext userContext, String departmentId,
		String doctorAssignmentId, int doctorAssignmentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfDepartment( departmentId);
		checkerOf(userContext).checkIdOfDoctorAssignment(doctorAssignmentId);
		checkerOf(userContext).checkVersionOfDoctorAssignment(doctorAssignmentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(DepartmentManagerException.class);

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
		
		checkerOf(userContext).checkIdOfDepartment( departmentId);
		checkerOf(userContext).checkIdOfDoctorAssignment(doctorAssignmentId);
		checkerOf(userContext).checkVersionOfDoctorAssignment(doctorAssignmentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(DepartmentManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfDepartment(departmentId);
		checkerOf(userContext).checkIdOfDoctorAssignment(doctorAssignmentId);
		checkerOf(userContext).checkVersionOfDoctorAssignment(doctorAssignmentVersion);
		

		if(DoctorAssignment.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfDoctorAssignment(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(DepartmentManagerException.class);

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

				checkerOf(userContext).checkIdOfDepartment(departmentId);

		
		checkerOf(userContext).checkNameOfDoctorSchedule(name);
		
		checkerOf(userContext).checkDoctorIdOfDoctorSchedule(doctorId);
		
		checkerOf(userContext).checkScheduleDateOfDoctorSchedule(scheduleDate);
		
		checkerOf(userContext).checkPeriodIdOfDoctorSchedule(periodId);
		
		checkerOf(userContext).checkAvailableOfDoctorSchedule(available);
		
		checkerOf(userContext).checkPriceOfDoctorSchedule(price);
		
		checkerOf(userContext).checkExpenseTypeIdOfDoctorSchedule(expenseTypeId);
		
		checkerOf(userContext).checkHospitalIdOfDoctorSchedule(hospitalId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(DepartmentManagerException.class);


	}
	public  Department addDoctorSchedule(HisUserContext userContext, String departmentId, String name, String doctorId, Date scheduleDate, String periodId, int available, BigDecimal price, String expenseTypeId, String hospitalId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingDoctorSchedule(userContext,departmentId,name, doctorId, scheduleDate, periodId, available, price, expenseTypeId, hospitalId,tokensExpr);

		DoctorSchedule doctorSchedule = createDoctorSchedule(userContext,name, doctorId, scheduleDate, periodId, available, price, expenseTypeId, hospitalId);

		Department department = loadDepartment(userContext, departmentId, emptyOptions());
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

		checkerOf(userContext).checkIdOfDepartment(departmentId);
		checkerOf(userContext).checkIdOfDoctorSchedule(id);

		checkerOf(userContext).checkNameOfDoctorSchedule( name);
		checkerOf(userContext).checkScheduleDateOfDoctorSchedule( scheduleDate);
		checkerOf(userContext).checkAvailableOfDoctorSchedule( available);
		checkerOf(userContext).checkPriceOfDoctorSchedule( price);

		checkerOf(userContext).throwExceptionIfHasErrors(DepartmentManagerException.class);

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

		checkerOf(userContext).checkIdOfDepartment(departmentId);
		for(String doctorScheduleIdItem: doctorScheduleIds){
			checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(DepartmentManagerException.class);

	}
	public  Department removeDoctorScheduleList(HisUserContext userContext, String departmentId,
			String doctorScheduleIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingDoctorScheduleList(userContext, departmentId,  doctorScheduleIds, tokensExpr);


			Department department = loadDepartment(userContext, departmentId, allTokens());
			synchronized(department){
				//Will be good when the department loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				departmentDaoOf(userContext).planToRemoveDoctorScheduleList(department, doctorScheduleIds, allTokens());
				department = saveDepartment(userContext, department, tokens().withDoctorScheduleList().done());
				deleteRelationListInGraph(userContext, department.getDoctorScheduleList());
				return present(userContext,department, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingDoctorSchedule(HisUserContext userContext, String departmentId,
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfDepartment( departmentId);
		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
		checkerOf(userContext).checkVersionOfDoctorSchedule(doctorScheduleVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(DepartmentManagerException.class);

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
		
		checkerOf(userContext).checkIdOfDepartment( departmentId);
		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
		checkerOf(userContext).checkVersionOfDoctorSchedule(doctorScheduleVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(DepartmentManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfDepartment(departmentId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(DepartmentManagerException.class);

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
		//   Department newDepartment = this.createDepartment(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newDepartment
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Department.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(HisUserContext userContext,SmartList<Department> list) throws Exception {
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
		SmartList<Department> list = departmentDaoOf(userContext).findDepartmentByHospital(hospitalId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(Department.class);
		page.setContainerObject(Hospital.withId(hospitalId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("部门列表");
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
 	public Object wxappview(HisUserContext userContext, String departmentId) throws Exception{
	  SerializeScope vscope = HisViewScope.getInstance().getDepartmentDetailScope().clone();
		Department merchantObj = (Department) this.view(userContext, departmentId);
    String merchantObjId = departmentId;
    String linkToUrl =	"departmentManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "部门"+"详情";
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
				MapUtil.put("id", "3-hospital")
				    .put("fieldName", "hospital")
				    .put("label", "医院")
				    .put("type", "object")
				    .put("displayField", "name")
				    .put("linkToUrl", "hospitalManager/wxappview/:id/")
				    .into_map()
		);
		result.put("hospital", merchantObj.getHospital());

		propList.add(
				MapUtil.put("id", "4-updateTime")
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
		    "doctorScheduleManager/listByDepartment/"+merchantObjId+"/",
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


