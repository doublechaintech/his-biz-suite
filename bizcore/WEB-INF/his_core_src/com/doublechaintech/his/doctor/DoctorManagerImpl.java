
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

import com.doublechaintech.his.platform.Platform;

import com.doublechaintech.his.platform.CandidatePlatform;







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
		
		addAction(userContext, doctor, tokens,"doctor.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+doctor.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, Doctor doctor, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Doctor createDoctor(HisUserContext userContext,String name, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfDoctor(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(DoctorManagerException.class);


		Doctor doctor=createNewDoctor();	

		doctor.setName(name);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		doctor.setPlatform(platform);
		
		

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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return DoctorTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(HisUserContext userContext, String doctorId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfDoctor(doctorId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(DoctorManagerException.class);
 		
 	}
 	public Doctor transferToAnotherPlatform(HisUserContext userContext, String doctorId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, doctorId,anotherPlatformId);
 
		Doctor doctor = loadDoctor(userContext, doctorId, allTokens());	
		synchronized(doctor){
			//will be good when the doctor loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			doctor.updatePlatform(platform);		
			doctor = saveDoctor(userContext, doctor, emptyOptions());
			
			return present(userContext,doctor, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePlatform requestCandidatePlatform(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForDoctor(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Platform loadPlatform(HisUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
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


	
	
	
	
	

	public void onNewInstanceCreated(HisUserContext userContext, Doctor newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


