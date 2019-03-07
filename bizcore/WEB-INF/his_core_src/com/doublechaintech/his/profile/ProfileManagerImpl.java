
package com.doublechaintech.his.profile;

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
import com.doublechaintech.his.registration.Registration;

import com.doublechaintech.his.platform.CandidatePlatform;

import com.doublechaintech.his.profile.Profile;
import com.doublechaintech.his.platform.Platform;






public class ProfileManagerImpl extends CustomHisCheckerManager implements ProfileManager {
	
	private static final String SERVICE_TYPE = "Profile";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ProfileManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ProfileManagerException(message);

	}
	
	

 	protected Profile saveProfile(HisUserContext userContext, Profile profile, String [] tokensExpr) throws Exception{	
 		//return getProfileDAO().save(profile, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProfile(userContext, profile, tokens);
 	}
 	
 	protected Profile saveProfileDetail(HisUserContext userContext, Profile profile) throws Exception{	

 		
 		return saveProfile(userContext, profile, allTokens());
 	}
 	
 	public Profile loadProfile(HisUserContext userContext, String profileId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Profile profile = loadProfile( userContext, profileId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,profile, tokens);
 	}
 	
 	
 	 public Profile searchProfile(HisUserContext userContext, String profileId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Profile profile = loadProfile( userContext, profileId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,profile, tokens);
 	}
 	
 	

 	protected Profile present(HisUserContext userContext, Profile profile, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,profile,tokens);
		
		
		Profile  profileToPresent = userContext.getDAOGroup().getProfileDAO().present(profile, tokens);
		
		List<BaseEntity> entityListToNaming = profileToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getProfileDAO().alias(entityListToNaming);
		
		return  profileToPresent;
		
		
	}
 
 	
 	
 	public Profile loadProfileDetail(HisUserContext userContext, String profileId) throws Exception{	
 		Profile profile = loadProfile( userContext, profileId, allTokens());
 		return present(userContext,profile, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String profileId) throws Exception{	
 		Profile profile = loadProfile( userContext, profileId, viewTokens());
 		return present(userContext,profile, allTokens());
		
 	}
 	protected Profile saveProfile(HisUserContext userContext, Profile profile, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getProfileDAO().save(profile, tokens);
 	}
 	protected Profile loadProfile(HisUserContext userContext, String profileId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 
 		return userContext.getDAOGroup().getProfileDAO().load(profileId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, Profile profile, Map<String, Object> tokens){
		super.addActions(userContext, profile, tokens);
		
		addAction(userContext, profile, tokens,"@create","createProfile","createProfile/","main","primary");
		addAction(userContext, profile, tokens,"@update","updateProfile","updateProfile/"+profile.getId()+"/","main","primary");
		addAction(userContext, profile, tokens,"@copy","cloneProfile","cloneProfile/"+profile.getId()+"/","main","primary");
		
		addAction(userContext, profile, tokens,"profile.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+profile.getId()+"/","main","primary");
		addAction(userContext, profile, tokens,"profile.addRegistration","addRegistration","addRegistration/"+profile.getId()+"/","registrationListAsPatient","primary");
		addAction(userContext, profile, tokens,"profile.removeRegistration","removeRegistration","removeRegistration/"+profile.getId()+"/","registrationListAsPatient","primary");
		addAction(userContext, profile, tokens,"profile.updateRegistration","updateRegistration","updateRegistration/"+profile.getId()+"/","registrationListAsPatient","primary");
		addAction(userContext, profile, tokens,"profile.copyRegistrationFrom","copyRegistrationFrom","copyRegistrationFrom/"+profile.getId()+"/","registrationListAsPatient","primary");
		addAction(userContext, profile, tokens,"profile.addRegistration","addRegistration","addRegistration/"+profile.getId()+"/","registrationListAsRegister","primary");
		addAction(userContext, profile, tokens,"profile.removeRegistration","removeRegistration","removeRegistration/"+profile.getId()+"/","registrationListAsRegister","primary");
		addAction(userContext, profile, tokens,"profile.updateRegistration","updateRegistration","updateRegistration/"+profile.getId()+"/","registrationListAsRegister","primary");
		addAction(userContext, profile, tokens,"profile.copyRegistrationFrom","copyRegistrationFrom","copyRegistrationFrom/"+profile.getId()+"/","registrationListAsRegister","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, Profile profile, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Profile createProfile(HisUserContext userContext,String name, String gender, int age, String identificationNumber, String mobile, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfProfile(name);
		userContext.getChecker().checkGenderOfProfile(gender);
		userContext.getChecker().checkAgeOfProfile(age);
		userContext.getChecker().checkIdentificationNumberOfProfile(identificationNumber);
		userContext.getChecker().checkMobileOfProfile(mobile);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);


		Profile profile=createNewProfile();	

		profile.setName(name);
		profile.setGender(gender);
		profile.setAge(age);
		profile.setIdentificationNumber(identificationNumber);
		profile.setMobile(mobile);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		profile.setPlatform(platform);
		
		

		profile = saveProfile(userContext, profile, emptyOptions());
		
		onNewInstanceCreated(userContext, profile);
		return profile;

		
	}
	protected Profile createNewProfile() 
	{
		
		return new Profile();		
	}
	
	protected void checkParamsForUpdatingProfile(HisUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkVersionOfProfile( profileVersion);
		

		if(Profile.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProfile(parseString(newValueExpr));
		}
		if(Profile.GENDER_PROPERTY.equals(property)){
			userContext.getChecker().checkGenderOfProfile(parseString(newValueExpr));
		}
		if(Profile.AGE_PROPERTY.equals(property)){
			userContext.getChecker().checkAgeOfProfile(parseInt(newValueExpr));
		}
		if(Profile.IDENTIFICATION_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkIdentificationNumberOfProfile(parseString(newValueExpr));
		}
		if(Profile.MOBILE_PROPERTY.equals(property)){
			userContext.getChecker().checkMobileOfProfile(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
		
	}
	
	
	
	public Profile clone(HisUserContext userContext, String fromProfileId) throws Exception{
		
		return userContext.getDAOGroup().getProfileDAO().clone(fromProfileId, this.allTokens());
	}
	
	public Profile internalSaveProfile(HisUserContext userContext, Profile profile) throws Exception 
	{
		return internalSaveProfile(userContext, profile, allTokens());

	}
	public Profile internalSaveProfile(HisUserContext userContext, Profile profile, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			
			
			profile = saveProfile(userContext, profile, options);
			return profile;
			
		}

	}
	
	public Profile updateProfile(HisUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		if(profile.getVersion() != profileVersion){
			String message = "The target version("+profile.getVersion()+") is not equals to version("+profileVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			
			profile.changeProperty(property, newValueExpr);
			profile = saveProfile(userContext, profile, tokens().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
			//return saveProfile(userContext, profile, tokens().done());
		}

	}
	
	public Profile updateProfileProperty(HisUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		if(profile.getVersion() != profileVersion){
			String message = "The target version("+profile.getVersion()+") is not equals to version("+profileVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			
			profile.changeProperty(property, newValueExpr);
			
			profile = saveProfile(userContext, profile, tokens().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
			//return saveProfile(userContext, profile, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProfileTokens tokens(){
		return ProfileTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProfileTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRegistrationListAsPatientWith("id","desc")
		.sortRegistrationListAsRegisterWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProfileTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(HisUserContext userContext, String profileId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProfile(profileId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
 		
 	}
 	public Profile transferToAnotherPlatform(HisUserContext userContext, String profileId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, profileId,anotherPlatformId);
 
		Profile profile = loadProfile(userContext, profileId, allTokens());	
		synchronized(profile){
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			profile.updatePlatform(platform);		
			profile = saveProfile(userContext, profile, emptyOptions());
			
			return present(userContext,profile, allTokens());
			
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForProfile(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(HisUserContext userContext, String profileId, int profileVersion) throws Exception {
		//deleteInternal(userContext, profileId, profileVersion);		
	}
	protected void deleteInternal(HisUserContext userContext,
			String profileId, int profileVersion) throws Exception{
			
		userContext.getDAOGroup().getProfileDAO().delete(profileId, profileVersion);
	}
	
	public Profile forgetByAll(HisUserContext userContext, String profileId, int profileVersion) throws Exception {
		return forgetByAllInternal(userContext, profileId, profileVersion);		
	}
	protected Profile forgetByAllInternal(HisUserContext userContext,
			String profileId, int profileVersion) throws Exception{
			
		return userContext.getDAOGroup().getProfileDAO().disconnectFromAll(profileId, profileVersion);
	}
	

	
	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProfileManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getProfileDAO().deleteAll();
	}


	//disconnect Profile with platform in Registration
	protected Profile breakWithRegistrationAsPatientByPlatform(HisUserContext userContext, String profileId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveRegistrationListAsPatientWithPlatform(profile, platformId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withRegistrationListAsPatient().done());
				return profile;
			}
	}
	//disconnect Profile with platform in Registration
	protected Profile breakWithRegistrationAsRegisterByPlatform(HisUserContext userContext, String profileId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveRegistrationListAsRegisterWithPlatform(profile, platformId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withRegistrationListAsRegister().done());
				return profile;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingRegistrationAsPatient(HisUserContext userContext, String profileId, String title, String content, String status, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkTitleOfRegistration(title);
		
		userContext.getChecker().checkContentOfRegistration(content);
		
		userContext.getChecker().checkStatusOfRegistration(status);
		
		userContext.getChecker().checkPlatformIdOfRegistration(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addRegistrationAsPatient(HisUserContext userContext, String profileId, String title, String content, String status, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRegistrationAsPatient(userContext,profileId,title, content, status, platformId,tokensExpr);
		
		Registration registration = createRegistrationAsPatient(userContext,title, content, status, platformId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addRegistrationAsPatient( registration );		
			profile = saveProfile(userContext, profile, tokens().withRegistrationListAsPatient().done());
			
			userContext.getManagerGroup().getRegistrationManager().onNewInstanceCreated(userContext, registration);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRegistrationAsPatientProperties(HisUserContext userContext, String profileId,String id,String title,String content,String status,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfRegistration(id);
		
		userContext.getChecker().checkTitleOfRegistration( title);
		userContext.getChecker().checkContentOfRegistration( content);
		userContext.getChecker().checkStatusOfRegistration( status);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateRegistrationAsPatientProperties(HisUserContext userContext, String profileId, String id,String title,String content,String status, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRegistrationAsPatientProperties(userContext,profileId,id,title,content,status,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRegistrationListAsPatientList()
				.searchRegistrationListAsPatientWith(Registration.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getRegistrationListAsPatient().isEmpty()){
			throw new ProfileManagerException("Registration is NOT FOUND with id: '"+id+"'");
		}
		
		Registration item = profileToUpdate.getRegistrationListAsPatient().first();
		
		item.updateTitle( title );
		item.updateContent( content );
		item.updateStatus( status );

		
		//checkParamsForAddingRegistrationAsPatient(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withRegistrationListAsPatient().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Registration createRegistrationAsPatient(HisUserContext userContext, String title, String content, String status, String platformId) throws Exception{

		Registration registration = new Registration();
		
		
		registration.setTitle(title);		
		registration.setContent(content);		
		registration.setUpdateTime(userContext.now());		
		registration.setStatus(status);		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		registration.setPlatform(platform);
	
		
		return registration;
	
		
	}
	
	protected Registration createIndexedRegistrationAsPatient(String id, int version){

		Registration registration = new Registration();
		registration.setId(id);
		registration.setVersion(version);
		return registration;			
		
	}
	
	protected void checkParamsForRemovingRegistrationListAsPatient(HisUserContext userContext, String profileId, 
			String registrationIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String registrationId: registrationIds){
			userContext.getChecker().checkIdOfRegistration(registrationId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeRegistrationListAsPatient(HisUserContext userContext, String profileId, 
			String registrationIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRegistrationListAsPatient(userContext, profileId,  registrationIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveRegistrationListAsPatient(profile, registrationIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withRegistrationListAsPatient().done());
				deleteRelationListInGraph(userContext, profile.getRegistrationListAsPatient());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRegistrationAsPatient(HisUserContext userContext, String profileId, 
		String registrationId, int registrationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfRegistration(registrationId);
		userContext.getChecker().checkVersionOfRegistration(registrationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeRegistrationAsPatient(HisUserContext userContext, String profileId, 
		String registrationId, int registrationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRegistrationAsPatient(userContext,profileId, registrationId, registrationVersion,tokensExpr);
		
		Registration registration = createIndexedRegistrationAsPatient(registrationId, registrationVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeRegistrationAsPatient( registration );		
			profile = saveProfile(userContext, profile, tokens().withRegistrationListAsPatient().done());
			deleteRelationInGraph(userContext, registration);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRegistrationAsPatient(HisUserContext userContext, String profileId, 
		String registrationId, int registrationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfRegistration(registrationId);
		userContext.getChecker().checkVersionOfRegistration(registrationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyRegistrationAsPatientFrom(HisUserContext userContext, String profileId, 
		String registrationId, int registrationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRegistrationAsPatient(userContext,profileId, registrationId, registrationVersion,tokensExpr);
		
		Registration registrationAsPatient = createIndexedRegistrationAsPatient(registrationId, registrationVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			registrationAsPatient.updateUpdateTime(userContext.now());
			
			profile.copyRegistrationAsPatientFrom( registrationAsPatient );		
			profile = saveProfile(userContext, profile, tokens().withRegistrationListAsPatient().done());
			
			userContext.getManagerGroup().getRegistrationManager().onNewInstanceCreated(userContext, (Registration)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRegistrationAsPatient(HisUserContext userContext, String profileId, String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfRegistration(registrationId);
		userContext.getChecker().checkVersionOfRegistration(registrationVersion);
		

		if(Registration.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfRegistration(parseString(newValueExpr));
		}
		
		if(Registration.CONTENT_PROPERTY.equals(property)){
			userContext.getChecker().checkContentOfRegistration(parseString(newValueExpr));
		}
		
		if(Registration.STATUS_PROPERTY.equals(property)){
			userContext.getChecker().checkStatusOfRegistration(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateRegistrationAsPatient(HisUserContext userContext, String profileId, String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRegistrationAsPatient(userContext, profileId, registrationId, registrationVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRegistrationListAsPatient().searchRegistrationListAsPatientWith(Registration.ID_PROPERTY, "eq", registrationId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeRegistrationAsPatient( registration );	
			//make changes to AcceleraterAccount.
			Registration registrationIndex = createIndexedRegistrationAsPatient(registrationId, registrationVersion);
		
			Registration registrationAsPatient = profile.findTheRegistrationAsPatient(registrationIndex);
			if(registrationAsPatient == null){
				throw new ProfileManagerException(registrationAsPatient+" is NOT FOUND" );
			}
			
			registrationAsPatient.changeProperty(property, newValueExpr);
			registrationAsPatient.updateUpdateTime(userContext.now());
			profile = saveProfile(userContext, profile, tokens().withRegistrationListAsPatient().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingRegistrationAsRegister(HisUserContext userContext, String profileId, String title, String content, String status, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkTitleOfRegistration(title);
		
		userContext.getChecker().checkContentOfRegistration(content);
		
		userContext.getChecker().checkStatusOfRegistration(status);
		
		userContext.getChecker().checkPlatformIdOfRegistration(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addRegistrationAsRegister(HisUserContext userContext, String profileId, String title, String content, String status, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRegistrationAsRegister(userContext,profileId,title, content, status, platformId,tokensExpr);
		
		Registration registration = createRegistrationAsRegister(userContext,title, content, status, platformId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addRegistrationAsRegister( registration );		
			profile = saveProfile(userContext, profile, tokens().withRegistrationListAsRegister().done());
			
			userContext.getManagerGroup().getRegistrationManager().onNewInstanceCreated(userContext, registration);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRegistrationAsRegisterProperties(HisUserContext userContext, String profileId,String id,String title,String content,String status,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfRegistration(id);
		
		userContext.getChecker().checkTitleOfRegistration( title);
		userContext.getChecker().checkContentOfRegistration( content);
		userContext.getChecker().checkStatusOfRegistration( status);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateRegistrationAsRegisterProperties(HisUserContext userContext, String profileId, String id,String title,String content,String status, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRegistrationAsRegisterProperties(userContext,profileId,id,title,content,status,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRegistrationListAsRegisterList()
				.searchRegistrationListAsRegisterWith(Registration.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getRegistrationListAsRegister().isEmpty()){
			throw new ProfileManagerException("Registration is NOT FOUND with id: '"+id+"'");
		}
		
		Registration item = profileToUpdate.getRegistrationListAsRegister().first();
		
		item.updateTitle( title );
		item.updateContent( content );
		item.updateStatus( status );

		
		//checkParamsForAddingRegistrationAsRegister(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withRegistrationListAsRegister().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Registration createRegistrationAsRegister(HisUserContext userContext, String title, String content, String status, String platformId) throws Exception{

		Registration registration = new Registration();
		
		
		registration.setTitle(title);		
		registration.setContent(content);		
		registration.setUpdateTime(userContext.now());		
		registration.setStatus(status);		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		registration.setPlatform(platform);
	
		
		return registration;
	
		
	}
	
	protected Registration createIndexedRegistrationAsRegister(String id, int version){

		Registration registration = new Registration();
		registration.setId(id);
		registration.setVersion(version);
		return registration;			
		
	}
	
	protected void checkParamsForRemovingRegistrationListAsRegister(HisUserContext userContext, String profileId, 
			String registrationIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String registrationId: registrationIds){
			userContext.getChecker().checkIdOfRegistration(registrationId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeRegistrationListAsRegister(HisUserContext userContext, String profileId, 
			String registrationIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRegistrationListAsRegister(userContext, profileId,  registrationIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveRegistrationListAsRegister(profile, registrationIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withRegistrationListAsRegister().done());
				deleteRelationListInGraph(userContext, profile.getRegistrationListAsRegister());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRegistrationAsRegister(HisUserContext userContext, String profileId, 
		String registrationId, int registrationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfRegistration(registrationId);
		userContext.getChecker().checkVersionOfRegistration(registrationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeRegistrationAsRegister(HisUserContext userContext, String profileId, 
		String registrationId, int registrationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRegistrationAsRegister(userContext,profileId, registrationId, registrationVersion,tokensExpr);
		
		Registration registration = createIndexedRegistrationAsRegister(registrationId, registrationVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeRegistrationAsRegister( registration );		
			profile = saveProfile(userContext, profile, tokens().withRegistrationListAsRegister().done());
			deleteRelationInGraph(userContext, registration);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRegistrationAsRegister(HisUserContext userContext, String profileId, 
		String registrationId, int registrationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfRegistration(registrationId);
		userContext.getChecker().checkVersionOfRegistration(registrationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyRegistrationAsRegisterFrom(HisUserContext userContext, String profileId, 
		String registrationId, int registrationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRegistrationAsRegister(userContext,profileId, registrationId, registrationVersion,tokensExpr);
		
		Registration registrationAsRegister = createIndexedRegistrationAsRegister(registrationId, registrationVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			registrationAsRegister.updateUpdateTime(userContext.now());
			
			profile.copyRegistrationAsRegisterFrom( registrationAsRegister );		
			profile = saveProfile(userContext, profile, tokens().withRegistrationListAsRegister().done());
			
			userContext.getManagerGroup().getRegistrationManager().onNewInstanceCreated(userContext, (Registration)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRegistrationAsRegister(HisUserContext userContext, String profileId, String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfRegistration(registrationId);
		userContext.getChecker().checkVersionOfRegistration(registrationVersion);
		

		if(Registration.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfRegistration(parseString(newValueExpr));
		}
		
		if(Registration.CONTENT_PROPERTY.equals(property)){
			userContext.getChecker().checkContentOfRegistration(parseString(newValueExpr));
		}
		
		if(Registration.STATUS_PROPERTY.equals(property)){
			userContext.getChecker().checkStatusOfRegistration(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateRegistrationAsRegister(HisUserContext userContext, String profileId, String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRegistrationAsRegister(userContext, profileId, registrationId, registrationVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRegistrationListAsRegister().searchRegistrationListAsRegisterWith(Registration.ID_PROPERTY, "eq", registrationId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeRegistrationAsRegister( registration );	
			//make changes to AcceleraterAccount.
			Registration registrationIndex = createIndexedRegistrationAsRegister(registrationId, registrationVersion);
		
			Registration registrationAsRegister = profile.findTheRegistrationAsRegister(registrationIndex);
			if(registrationAsRegister == null){
				throw new ProfileManagerException(registrationAsRegister+" is NOT FOUND" );
			}
			
			registrationAsRegister.changeProperty(property, newValueExpr);
			registrationAsRegister.updateUpdateTime(userContext.now());
			profile = saveProfile(userContext, profile, tokens().withRegistrationListAsRegister().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(HisUserContext userContext, Profile newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


