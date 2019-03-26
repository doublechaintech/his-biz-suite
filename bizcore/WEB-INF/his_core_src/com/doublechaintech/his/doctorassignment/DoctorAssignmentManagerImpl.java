
package com.doublechaintech.his.doctorassignment;

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

import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;

import com.doublechaintech.his.doctor.CandidateDoctor;
import com.doublechaintech.his.department.CandidateDepartment;







public class DoctorAssignmentManagerImpl extends CustomHisCheckerManager implements DoctorAssignmentManager {
	
	private static final String SERVICE_TYPE = "DoctorAssignment";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws DoctorAssignmentManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new DoctorAssignmentManagerException(message);

	}
	
	

 	protected DoctorAssignment saveDoctorAssignment(HisUserContext userContext, DoctorAssignment doctorAssignment, String [] tokensExpr) throws Exception{	
 		//return getDoctorAssignmentDAO().save(doctorAssignment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveDoctorAssignment(userContext, doctorAssignment, tokens);
 	}
 	
 	protected DoctorAssignment saveDoctorAssignmentDetail(HisUserContext userContext, DoctorAssignment doctorAssignment) throws Exception{	

 		
 		return saveDoctorAssignment(userContext, doctorAssignment, allTokens());
 	}
 	
 	public DoctorAssignment loadDoctorAssignment(HisUserContext userContext, String doctorAssignmentId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfDoctorAssignment(doctorAssignmentId);
		userContext.getChecker().throwExceptionIfHasErrors( DoctorAssignmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		DoctorAssignment doctorAssignment = loadDoctorAssignment( userContext, doctorAssignmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,doctorAssignment, tokens);
 	}
 	
 	
 	 public DoctorAssignment searchDoctorAssignment(HisUserContext userContext, String doctorAssignmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfDoctorAssignment(doctorAssignmentId);
		userContext.getChecker().throwExceptionIfHasErrors( DoctorAssignmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		DoctorAssignment doctorAssignment = loadDoctorAssignment( userContext, doctorAssignmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,doctorAssignment, tokens);
 	}
 	
 	

 	protected DoctorAssignment present(HisUserContext userContext, DoctorAssignment doctorAssignment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,doctorAssignment,tokens);
		
		
		DoctorAssignment  doctorAssignmentToPresent = userContext.getDAOGroup().getDoctorAssignmentDAO().present(doctorAssignment, tokens);
		
		List<BaseEntity> entityListToNaming = doctorAssignmentToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getDoctorAssignmentDAO().alias(entityListToNaming);
		
		return  doctorAssignmentToPresent;
		
		
	}
 
 	
 	
 	public DoctorAssignment loadDoctorAssignmentDetail(HisUserContext userContext, String doctorAssignmentId) throws Exception{	
 		DoctorAssignment doctorAssignment = loadDoctorAssignment( userContext, doctorAssignmentId, allTokens());
 		return present(userContext,doctorAssignment, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String doctorAssignmentId) throws Exception{	
 		DoctorAssignment doctorAssignment = loadDoctorAssignment( userContext, doctorAssignmentId, viewTokens());
 		return present(userContext,doctorAssignment, allTokens());
		
 	}
 	protected DoctorAssignment saveDoctorAssignment(HisUserContext userContext, DoctorAssignment doctorAssignment, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getDoctorAssignmentDAO().save(doctorAssignment, tokens);
 	}
 	protected DoctorAssignment loadDoctorAssignment(HisUserContext userContext, String doctorAssignmentId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfDoctorAssignment(doctorAssignmentId);
		userContext.getChecker().throwExceptionIfHasErrors( DoctorAssignmentManagerException.class);

 
 		return userContext.getDAOGroup().getDoctorAssignmentDAO().load(doctorAssignmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, DoctorAssignment doctorAssignment, Map<String, Object> tokens){
		super.addActions(userContext, doctorAssignment, tokens);
		
		addAction(userContext, doctorAssignment, tokens,"@create","createDoctorAssignment","createDoctorAssignment/","main","primary");
		addAction(userContext, doctorAssignment, tokens,"@update","updateDoctorAssignment","updateDoctorAssignment/"+doctorAssignment.getId()+"/","main","primary");
		addAction(userContext, doctorAssignment, tokens,"@copy","cloneDoctorAssignment","cloneDoctorAssignment/"+doctorAssignment.getId()+"/","main","primary");
		
		addAction(userContext, doctorAssignment, tokens,"doctor_assignment.transfer_to_doctor","transferToAnotherDoctor","transferToAnotherDoctor/"+doctorAssignment.getId()+"/","main","primary");
		addAction(userContext, doctorAssignment, tokens,"doctor_assignment.transfer_to_department","transferToAnotherDepartment","transferToAnotherDepartment/"+doctorAssignment.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, DoctorAssignment doctorAssignment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public DoctorAssignment createDoctorAssignment(HisUserContext userContext,String name, String doctorId, String departmentId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfDoctorAssignment(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(DoctorAssignmentManagerException.class);


		DoctorAssignment doctorAssignment=createNewDoctorAssignment();	

		doctorAssignment.setName(name);
			
		Doctor doctor = loadDoctor(userContext, doctorId,emptyOptions());
		doctorAssignment.setDoctor(doctor);
		
		
			
		Department department = loadDepartment(userContext, departmentId,emptyOptions());
		doctorAssignment.setDepartment(department);
		
		
		doctorAssignment.setUpdateTime(userContext.now());

		doctorAssignment = saveDoctorAssignment(userContext, doctorAssignment, emptyOptions());
		
		onNewInstanceCreated(userContext, doctorAssignment);
		return doctorAssignment;

		
	}
	protected DoctorAssignment createNewDoctorAssignment() 
	{
		
		return new DoctorAssignment();		
	}
	
	protected void checkParamsForUpdatingDoctorAssignment(HisUserContext userContext,String doctorAssignmentId, int doctorAssignmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfDoctorAssignment(doctorAssignmentId);
		userContext.getChecker().checkVersionOfDoctorAssignment( doctorAssignmentVersion);
		

		if(DoctorAssignment.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfDoctorAssignment(parseString(newValueExpr));
		}		

				

		
	
		userContext.getChecker().throwExceptionIfHasErrors(DoctorAssignmentManagerException.class);
	
		
	}
	
	
	
	public DoctorAssignment clone(HisUserContext userContext, String fromDoctorAssignmentId) throws Exception{
		
		return userContext.getDAOGroup().getDoctorAssignmentDAO().clone(fromDoctorAssignmentId, this.allTokens());
	}
	
	public DoctorAssignment internalSaveDoctorAssignment(HisUserContext userContext, DoctorAssignment doctorAssignment) throws Exception 
	{
		return internalSaveDoctorAssignment(userContext, doctorAssignment, allTokens());

	}
	public DoctorAssignment internalSaveDoctorAssignment(HisUserContext userContext, DoctorAssignment doctorAssignment, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingDoctorAssignment(userContext, doctorAssignmentId, doctorAssignmentVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(doctorAssignment){ 
			//will be good when the doctorAssignment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to DoctorAssignment.
			
			
			doctorAssignment = saveDoctorAssignment(userContext, doctorAssignment, options);
			return doctorAssignment;
			
		}

	}
	
	public DoctorAssignment updateDoctorAssignment(HisUserContext userContext,String doctorAssignmentId, int doctorAssignmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingDoctorAssignment(userContext, doctorAssignmentId, doctorAssignmentVersion, property, newValueExpr, tokensExpr);
		
		
		
		DoctorAssignment doctorAssignment = loadDoctorAssignment(userContext, doctorAssignmentId, allTokens());
		if(doctorAssignment.getVersion() != doctorAssignmentVersion){
			String message = "The target version("+doctorAssignment.getVersion()+") is not equals to version("+doctorAssignmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(doctorAssignment){ 
			//will be good when the doctorAssignment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to DoctorAssignment.
			doctorAssignment.updateUpdateTime(userContext.now());
			doctorAssignment.changeProperty(property, newValueExpr);
			doctorAssignment = saveDoctorAssignment(userContext, doctorAssignment, tokens().done());
			return present(userContext,doctorAssignment, mergedAllTokens(tokensExpr));
			//return saveDoctorAssignment(userContext, doctorAssignment, tokens().done());
		}

	}
	
	public DoctorAssignment updateDoctorAssignmentProperty(HisUserContext userContext,String doctorAssignmentId, int doctorAssignmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingDoctorAssignment(userContext, doctorAssignmentId, doctorAssignmentVersion, property, newValueExpr, tokensExpr);
		
		DoctorAssignment doctorAssignment = loadDoctorAssignment(userContext, doctorAssignmentId, allTokens());
		if(doctorAssignment.getVersion() != doctorAssignmentVersion){
			String message = "The target version("+doctorAssignment.getVersion()+") is not equals to version("+doctorAssignmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(doctorAssignment){ 
			//will be good when the doctorAssignment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to DoctorAssignment.
			
			doctorAssignment.changeProperty(property, newValueExpr);
			doctorAssignment.updateUpdateTime(userContext.now());
			doctorAssignment = saveDoctorAssignment(userContext, doctorAssignment, tokens().done());
			return present(userContext,doctorAssignment, mergedAllTokens(tokensExpr));
			//return saveDoctorAssignment(userContext, doctorAssignment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected DoctorAssignmentTokens tokens(){
		return DoctorAssignmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return DoctorAssignmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return DoctorAssignmentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherDoctor(HisUserContext userContext, String doctorAssignmentId, String anotherDoctorId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfDoctorAssignment(doctorAssignmentId);
 		userContext.getChecker().checkIdOfDoctor(anotherDoctorId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(DoctorAssignmentManagerException.class);
 		
 	}
 	public DoctorAssignment transferToAnotherDoctor(HisUserContext userContext, String doctorAssignmentId, String anotherDoctorId) throws Exception
 	{
 		checkParamsForTransferingAnotherDoctor(userContext, doctorAssignmentId,anotherDoctorId);
 
		DoctorAssignment doctorAssignment = loadDoctorAssignment(userContext, doctorAssignmentId, allTokens());	
		synchronized(doctorAssignment){
			//will be good when the doctorAssignment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Doctor doctor = loadDoctor(userContext, anotherDoctorId, emptyOptions());		
			doctorAssignment.updateDoctor(doctor);		
			doctorAssignment = saveDoctorAssignment(userContext, doctorAssignment, emptyOptions());
			
			return present(userContext,doctorAssignment, allTokens());
			
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
		SmartList<Doctor> candidateList = userContext.getDAOGroup().getDoctorDAO().requestCandidateDoctorForDoctorAssignment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherDepartment(HisUserContext userContext, String doctorAssignmentId, String anotherDepartmentId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfDoctorAssignment(doctorAssignmentId);
 		userContext.getChecker().checkIdOfDepartment(anotherDepartmentId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(DoctorAssignmentManagerException.class);
 		
 	}
 	public DoctorAssignment transferToAnotherDepartment(HisUserContext userContext, String doctorAssignmentId, String anotherDepartmentId) throws Exception
 	{
 		checkParamsForTransferingAnotherDepartment(userContext, doctorAssignmentId,anotherDepartmentId);
 
		DoctorAssignment doctorAssignment = loadDoctorAssignment(userContext, doctorAssignmentId, allTokens());	
		synchronized(doctorAssignment){
			//will be good when the doctorAssignment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Department department = loadDepartment(userContext, anotherDepartmentId, emptyOptions());		
			doctorAssignment.updateDepartment(department);		
			doctorAssignment = saveDoctorAssignment(userContext, doctorAssignment, emptyOptions());
			
			return present(userContext,doctorAssignment, allTokens());
			
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
		SmartList<Department> candidateList = userContext.getDAOGroup().getDepartmentDAO().requestCandidateDepartmentForDoctorAssignment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	 	
 	protected Department loadDepartment(HisUserContext userContext, String newDepartmentId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getDepartmentDAO().load(newDepartmentId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String doctorAssignmentId, int doctorAssignmentVersion) throws Exception {
		//deleteInternal(userContext, doctorAssignmentId, doctorAssignmentVersion);		
	}
	protected void deleteInternal(HisUserContext userContext,
			String doctorAssignmentId, int doctorAssignmentVersion) throws Exception{
			
		userContext.getDAOGroup().getDoctorAssignmentDAO().delete(doctorAssignmentId, doctorAssignmentVersion);
	}
	
	public DoctorAssignment forgetByAll(HisUserContext userContext, String doctorAssignmentId, int doctorAssignmentVersion) throws Exception {
		return forgetByAllInternal(userContext, doctorAssignmentId, doctorAssignmentVersion);		
	}
	protected DoctorAssignment forgetByAllInternal(HisUserContext userContext,
			String doctorAssignmentId, int doctorAssignmentVersion) throws Exception{
			
		return userContext.getDAOGroup().getDoctorAssignmentDAO().disconnectFromAll(doctorAssignmentId, doctorAssignmentVersion);
	}
	

	
	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new DoctorAssignmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getDoctorAssignmentDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(HisUserContext userContext, DoctorAssignment newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


