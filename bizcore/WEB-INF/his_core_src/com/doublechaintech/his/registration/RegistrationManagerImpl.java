
package com.doublechaintech.his.registration;

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

import com.doublechaintech.his.profile.Profile;
import com.doublechaintech.his.platform.Platform;

import com.doublechaintech.his.profile.CandidateProfile;
import com.doublechaintech.his.platform.CandidatePlatform;







public class RegistrationManagerImpl extends CustomHisCheckerManager implements RegistrationManager {
	
	private static final String SERVICE_TYPE = "Registration";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RegistrationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RegistrationManagerException(message);

	}
	
	

 	protected Registration saveRegistration(HisUserContext userContext, Registration registration, String [] tokensExpr) throws Exception{	
 		//return getRegistrationDAO().save(registration, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRegistration(userContext, registration, tokens);
 	}
 	
 	protected Registration saveRegistrationDetail(HisUserContext userContext, Registration registration) throws Exception{	

 		
 		return saveRegistration(userContext, registration, allTokens());
 	}
 	
 	public Registration loadRegistration(HisUserContext userContext, String registrationId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRegistration(registrationId);
		userContext.getChecker().throwExceptionIfHasErrors( RegistrationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Registration registration = loadRegistration( userContext, registrationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,registration, tokens);
 	}
 	
 	
 	 public Registration searchRegistration(HisUserContext userContext, String registrationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRegistration(registrationId);
		userContext.getChecker().throwExceptionIfHasErrors( RegistrationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Registration registration = loadRegistration( userContext, registrationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,registration, tokens);
 	}
 	
 	

 	protected Registration present(HisUserContext userContext, Registration registration, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,registration,tokens);
		
		
		Registration  registrationToPresent = userContext.getDAOGroup().getRegistrationDAO().present(registration, tokens);
		
		List<BaseEntity> entityListToNaming = registrationToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRegistrationDAO().alias(entityListToNaming);
		
		return  registrationToPresent;
		
		
	}
 
 	
 	
 	public Registration loadRegistrationDetail(HisUserContext userContext, String registrationId) throws Exception{	
 		Registration registration = loadRegistration( userContext, registrationId, allTokens());
 		return present(userContext,registration, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String registrationId) throws Exception{	
 		Registration registration = loadRegistration( userContext, registrationId, viewTokens());
 		return present(userContext,registration, allTokens());
		
 	}
 	protected Registration saveRegistration(HisUserContext userContext, Registration registration, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRegistrationDAO().save(registration, tokens);
 	}
 	protected Registration loadRegistration(HisUserContext userContext, String registrationId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRegistration(registrationId);
		userContext.getChecker().throwExceptionIfHasErrors( RegistrationManagerException.class);

 
 		return userContext.getDAOGroup().getRegistrationDAO().load(registrationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, Registration registration, Map<String, Object> tokens){
		super.addActions(userContext, registration, tokens);
		
		addAction(userContext, registration, tokens,"@create","createRegistration","createRegistration/","main","primary");
		addAction(userContext, registration, tokens,"@update","updateRegistration","updateRegistration/"+registration.getId()+"/","main","primary");
		addAction(userContext, registration, tokens,"@copy","cloneRegistration","cloneRegistration/"+registration.getId()+"/","main","primary");
		
		addAction(userContext, registration, tokens,"registration.transfer_to_patient","transferToAnotherPatient","transferToAnotherPatient/"+registration.getId()+"/","main","primary");
		addAction(userContext, registration, tokens,"registration.transfer_to_register","transferToAnotherRegister","transferToAnotherRegister/"+registration.getId()+"/","main","primary");
		addAction(userContext, registration, tokens,"registration.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+registration.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, Registration registration, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Registration createRegistration(HisUserContext userContext,String title, String patientId, String registerId, String content, String status, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkTitleOfRegistration(title);
		userContext.getChecker().checkContentOfRegistration(content);
		userContext.getChecker().checkStatusOfRegistration(status);
	
		userContext.getChecker().throwExceptionIfHasErrors(RegistrationManagerException.class);


		Registration registration=createNewRegistration();	

		registration.setTitle(title);
			
		Profile patient = loadProfile(userContext, patientId,emptyOptions());
		registration.setPatient(patient);
		
		
			
		Profile register = loadProfile(userContext, registerId,emptyOptions());
		registration.setRegister(register);
		
		
		registration.setContent(content);
		registration.setUpdateTime(userContext.now());
		registration.setStatus(status);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		registration.setPlatform(platform);
		
		

		registration = saveRegistration(userContext, registration, emptyOptions());
		
		onNewInstanceCreated(userContext, registration);
		return registration;

		
	}
	protected Registration createNewRegistration() 
	{
		
		return new Registration();		
	}
	
	protected void checkParamsForUpdatingRegistration(HisUserContext userContext,String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRegistration(registrationId);
		userContext.getChecker().checkVersionOfRegistration( registrationVersion);
		

		if(Registration.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfRegistration(parseString(newValueExpr));
		}		

				

		
		if(Registration.CONTENT_PROPERTY.equals(property)){
			userContext.getChecker().checkContentOfRegistration(parseString(newValueExpr));
		}
		if(Registration.STATUS_PROPERTY.equals(property)){
			userContext.getChecker().checkStatusOfRegistration(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(RegistrationManagerException.class);
	
		
	}
	
	
	
	public Registration clone(HisUserContext userContext, String fromRegistrationId) throws Exception{
		
		return userContext.getDAOGroup().getRegistrationDAO().clone(fromRegistrationId, this.allTokens());
	}
	
	public Registration internalSaveRegistration(HisUserContext userContext, Registration registration) throws Exception 
	{
		return internalSaveRegistration(userContext, registration, allTokens());

	}
	public Registration internalSaveRegistration(HisUserContext userContext, Registration registration, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRegistration(userContext, registrationId, registrationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(registration){ 
			//will be good when the registration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Registration.
			
			
			registration = saveRegistration(userContext, registration, options);
			return registration;
			
		}

	}
	
	public Registration updateRegistration(HisUserContext userContext,String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRegistration(userContext, registrationId, registrationVersion, property, newValueExpr, tokensExpr);
		
		
		
		Registration registration = loadRegistration(userContext, registrationId, allTokens());
		if(registration.getVersion() != registrationVersion){
			String message = "The target version("+registration.getVersion()+") is not equals to version("+registrationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(registration){ 
			//will be good when the registration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Registration.
			registration.updateUpdateTime(userContext.now());
			registration.changeProperty(property, newValueExpr);
			registration = saveRegistration(userContext, registration, tokens().done());
			return present(userContext,registration, mergedAllTokens(tokensExpr));
			//return saveRegistration(userContext, registration, tokens().done());
		}

	}
	
	public Registration updateRegistrationProperty(HisUserContext userContext,String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRegistration(userContext, registrationId, registrationVersion, property, newValueExpr, tokensExpr);
		
		Registration registration = loadRegistration(userContext, registrationId, allTokens());
		if(registration.getVersion() != registrationVersion){
			String message = "The target version("+registration.getVersion()+") is not equals to version("+registrationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(registration){ 
			//will be good when the registration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Registration.
			
			registration.changeProperty(property, newValueExpr);
			registration.updateUpdateTime(userContext.now());
			registration = saveRegistration(userContext, registration, tokens().done());
			return present(userContext,registration, mergedAllTokens(tokensExpr));
			//return saveRegistration(userContext, registration, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RegistrationTokens tokens(){
		return RegistrationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RegistrationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RegistrationTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPatient(HisUserContext userContext, String registrationId, String anotherPatientId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRegistration(registrationId);
 		userContext.getChecker().checkIdOfProfile(anotherPatientId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RegistrationManagerException.class);
 		
 	}
 	public Registration transferToAnotherPatient(HisUserContext userContext, String registrationId, String anotherPatientId) throws Exception
 	{
 		checkParamsForTransferingAnotherPatient(userContext, registrationId,anotherPatientId);
 
		Registration registration = loadRegistration(userContext, registrationId, allTokens());	
		synchronized(registration){
			//will be good when the registration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Profile patient = loadProfile(userContext, anotherPatientId, emptyOptions());		
			registration.updatePatient(patient);		
			registration = saveRegistration(userContext, registration, emptyOptions());
			
			return present(userContext,registration, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateProfile requestCandidatePatient(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProfile result = new CandidateProfile();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Profile> candidateList = userContext.getDAOGroup().getProfileDAO().requestCandidateProfileForRegistrationAsPatient(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherRegister(HisUserContext userContext, String registrationId, String anotherRegisterId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRegistration(registrationId);
 		userContext.getChecker().checkIdOfProfile(anotherRegisterId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RegistrationManagerException.class);
 		
 	}
 	public Registration transferToAnotherRegister(HisUserContext userContext, String registrationId, String anotherRegisterId) throws Exception
 	{
 		checkParamsForTransferingAnotherRegister(userContext, registrationId,anotherRegisterId);
 
		Registration registration = loadRegistration(userContext, registrationId, allTokens());	
		synchronized(registration){
			//will be good when the registration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Profile register = loadProfile(userContext, anotherRegisterId, emptyOptions());		
			registration.updateRegister(register);		
			registration = saveRegistration(userContext, registration, emptyOptions());
			
			return present(userContext,registration, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateProfile requestCandidateRegister(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProfile result = new CandidateProfile();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Profile> candidateList = userContext.getDAOGroup().getProfileDAO().requestCandidateProfileForRegistrationAsRegister(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPlatform(HisUserContext userContext, String registrationId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRegistration(registrationId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RegistrationManagerException.class);
 		
 	}
 	public Registration transferToAnotherPlatform(HisUserContext userContext, String registrationId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, registrationId,anotherPlatformId);
 
		Registration registration = loadRegistration(userContext, registrationId, allTokens());	
		synchronized(registration){
			//will be good when the registration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			registration.updatePlatform(platform);		
			registration = saveRegistration(userContext, registration, emptyOptions());
			
			return present(userContext,registration, allTokens());
			
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForRegistration(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Profile loadProfile(HisUserContext userContext, String newPatientId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getProfileDAO().load(newPatientId, options);
 	}
 	
 	
 	
	
	 	
 	protected Platform loadPlatform(HisUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String registrationId, int registrationVersion) throws Exception {
		//deleteInternal(userContext, registrationId, registrationVersion);		
	}
	protected void deleteInternal(HisUserContext userContext,
			String registrationId, int registrationVersion) throws Exception{
			
		userContext.getDAOGroup().getRegistrationDAO().delete(registrationId, registrationVersion);
	}
	
	public Registration forgetByAll(HisUserContext userContext, String registrationId, int registrationVersion) throws Exception {
		return forgetByAllInternal(userContext, registrationId, registrationVersion);		
	}
	protected Registration forgetByAllInternal(HisUserContext userContext,
			String registrationId, int registrationVersion) throws Exception{
			
		return userContext.getDAOGroup().getRegistrationDAO().disconnectFromAll(registrationId, registrationVersion);
	}
	

	
	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RegistrationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRegistrationDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(HisUserContext userContext, Registration newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


