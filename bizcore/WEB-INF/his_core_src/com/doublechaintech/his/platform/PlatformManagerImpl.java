
package com.doublechaintech.his.platform;

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
import com.doublechaintech.his.registration.Registration;
import com.doublechaintech.his.doctor.Doctor;


import com.doublechaintech.his.profile.Profile;
import com.doublechaintech.his.platform.Platform;






public class PlatformManagerImpl extends CustomHisCheckerManager implements PlatformManager {
	
	private static final String SERVICE_TYPE = "Platform";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws PlatformManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new PlatformManagerException(message);

	}
	
	

 	protected Platform savePlatform(HisUserContext userContext, Platform platform, String [] tokensExpr) throws Exception{	
 		//return getPlatformDAO().save(platform, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePlatform(userContext, platform, tokens);
 	}
 	
 	protected Platform savePlatformDetail(HisUserContext userContext, Platform platform) throws Exception{	

 		
 		return savePlatform(userContext, platform, allTokens());
 	}
 	
 	public Platform loadPlatform(HisUserContext userContext, String platformId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	
 	 public Platform searchPlatform(HisUserContext userContext, String platformId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	

 	protected Platform present(HisUserContext userContext, Platform platform, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,platform,tokens);
		
		
		Platform  platformToPresent = userContext.getDAOGroup().getPlatformDAO().present(platform, tokens);
		
		List<BaseEntity> entityListToNaming = platformToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getPlatformDAO().alias(entityListToNaming);
		
		return  platformToPresent;
		
		
	}
 
 	
 	
 	public Platform loadPlatformDetail(HisUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, allTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, viewTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	protected Platform savePlatform(HisUserContext userContext, Platform platform, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getPlatformDAO().save(platform, tokens);
 	}
 	protected Platform loadPlatform(HisUserContext userContext, String platformId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 
 		return userContext.getDAOGroup().getPlatformDAO().load(platformId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, Platform platform, Map<String, Object> tokens){
		super.addActions(userContext, platform, tokens);
		
		addAction(userContext, platform, tokens,"@create","createPlatform","createPlatform/","main","primary");
		addAction(userContext, platform, tokens,"@update","updatePlatform","updatePlatform/"+platform.getId()+"/","main","primary");
		addAction(userContext, platform, tokens,"@copy","clonePlatform","clonePlatform/"+platform.getId()+"/","main","primary");
		
		addAction(userContext, platform, tokens,"platform.addDoctor","addDoctor","addDoctor/"+platform.getId()+"/","doctorList","primary");
		addAction(userContext, platform, tokens,"platform.removeDoctor","removeDoctor","removeDoctor/"+platform.getId()+"/","doctorList","primary");
		addAction(userContext, platform, tokens,"platform.updateDoctor","updateDoctor","updateDoctor/"+platform.getId()+"/","doctorList","primary");
		addAction(userContext, platform, tokens,"platform.copyDoctorFrom","copyDoctorFrom","copyDoctorFrom/"+platform.getId()+"/","doctorList","primary");
		addAction(userContext, platform, tokens,"platform.addProfile","addProfile","addProfile/"+platform.getId()+"/","profileList","primary");
		addAction(userContext, platform, tokens,"platform.removeProfile","removeProfile","removeProfile/"+platform.getId()+"/","profileList","primary");
		addAction(userContext, platform, tokens,"platform.updateProfile","updateProfile","updateProfile/"+platform.getId()+"/","profileList","primary");
		addAction(userContext, platform, tokens,"platform.copyProfileFrom","copyProfileFrom","copyProfileFrom/"+platform.getId()+"/","profileList","primary");
		addAction(userContext, platform, tokens,"platform.addRegistration","addRegistration","addRegistration/"+platform.getId()+"/","registrationList","primary");
		addAction(userContext, platform, tokens,"platform.removeRegistration","removeRegistration","removeRegistration/"+platform.getId()+"/","registrationList","primary");
		addAction(userContext, platform, tokens,"platform.updateRegistration","updateRegistration","updateRegistration/"+platform.getId()+"/","registrationList","primary");
		addAction(userContext, platform, tokens,"platform.copyRegistrationFrom","copyRegistrationFrom","copyRegistrationFrom/"+platform.getId()+"/","registrationList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, Platform platform, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Platform createPlatform(HisUserContext userContext,String name, String introduction, String currentVersion) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfPlatform(name);
		userContext.getChecker().checkIntroductionOfPlatform(introduction);
		userContext.getChecker().checkCurrentVersionOfPlatform(currentVersion);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);


		Platform platform=createNewPlatform();	

		platform.setName(name);
		platform.setIntroduction(introduction);
		platform.setCurrentVersion(currentVersion);

		platform = savePlatform(userContext, platform, emptyOptions());
		
		onNewInstanceCreated(userContext, platform);
		return platform;

		
	}
	protected Platform createNewPlatform() 
	{
		
		return new Platform();		
	}
	
	protected void checkParamsForUpdatingPlatform(HisUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkVersionOfPlatform( platformVersion);
		

		if(Platform.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfPlatform(parseString(newValueExpr));
		}
		if(Platform.INTRODUCTION_PROPERTY.equals(property)){
			userContext.getChecker().checkIntroductionOfPlatform(parseString(newValueExpr));
		}
		if(Platform.CURRENT_VERSION_PROPERTY.equals(property)){
			userContext.getChecker().checkCurrentVersionOfPlatform(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
		
	}
	
	
	
	public Platform clone(HisUserContext userContext, String fromPlatformId) throws Exception{
		
		return userContext.getDAOGroup().getPlatformDAO().clone(fromPlatformId, this.allTokens());
	}
	
	public Platform internalSavePlatform(HisUserContext userContext, Platform platform) throws Exception 
	{
		return internalSavePlatform(userContext, platform, allTokens());

	}
	public Platform internalSavePlatform(HisUserContext userContext, Platform platform, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			
			platform = savePlatform(userContext, platform, options);
			return platform;
			
		}

	}
	
	public Platform updatePlatform(HisUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			platform.changeProperty(property, newValueExpr);
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}
	
	public Platform updatePlatformProperty(HisUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			platform.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PlatformTokens tokens(){
		return PlatformTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PlatformTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortDoctorListWith("id","desc")
		.sortProfileListWith("id","desc")
		.sortRegistrationListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PlatformTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String platformId, int platformVersion) throws Exception {
		//deleteInternal(userContext, platformId, platformVersion);		
	}
	protected void deleteInternal(HisUserContext userContext,
			String platformId, int platformVersion) throws Exception{
			
		userContext.getDAOGroup().getPlatformDAO().delete(platformId, platformVersion);
	}
	
	public Platform forgetByAll(HisUserContext userContext, String platformId, int platformVersion) throws Exception {
		return forgetByAllInternal(userContext, platformId, platformVersion);		
	}
	protected Platform forgetByAllInternal(HisUserContext userContext,
			String platformId, int platformVersion) throws Exception{
			
		return userContext.getDAOGroup().getPlatformDAO().disconnectFromAll(platformId, platformVersion);
	}
	

	
	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PlatformManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getPlatformDAO().deleteAll();
	}


	//disconnect Platform with patient in Registration
	protected Platform breakWithRegistrationByPatient(HisUserContext userContext, String platformId, String patientId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveRegistrationListWithPatient(platform, patientId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withRegistrationList().done());
				return platform;
			}
	}
	//disconnect Platform with register in Registration
	protected Platform breakWithRegistrationByRegister(HisUserContext userContext, String platformId, String registerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveRegistrationListWithRegister(platform, registerId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withRegistrationList().done());
				return platform;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingDoctor(HisUserContext userContext, String platformId, String name,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfDoctor(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addDoctor(HisUserContext userContext, String platformId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingDoctor(userContext,platformId,name,tokensExpr);
		
		Doctor doctor = createDoctor(userContext,name);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addDoctor( doctor );		
			platform = savePlatform(userContext, platform, tokens().withDoctorList().done());
			
			userContext.getManagerGroup().getDoctorManager().onNewInstanceCreated(userContext, doctor);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingDoctorProperties(HisUserContext userContext, String platformId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfDoctor(id);
		
		userContext.getChecker().checkNameOfDoctor( name);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateDoctorProperties(HisUserContext userContext, String platformId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingDoctorProperties(userContext,platformId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withDoctorListList()
				.searchDoctorListWith(Doctor.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getDoctorList().isEmpty()){
			throw new PlatformManagerException("Doctor is NOT FOUND with id: '"+id+"'");
		}
		
		Doctor item = platformToUpdate.getDoctorList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingDoctor(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withDoctorList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Doctor createDoctor(HisUserContext userContext, String name) throws Exception{

		Doctor doctor = new Doctor();
		
		
		doctor.setName(name);
	
		
		return doctor;
	
		
	}
	
	protected Doctor createIndexedDoctor(String id, int version){

		Doctor doctor = new Doctor();
		doctor.setId(id);
		doctor.setVersion(version);
		return doctor;			
		
	}
	
	protected void checkParamsForRemovingDoctorList(HisUserContext userContext, String platformId, 
			String doctorIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String doctorId: doctorIds){
			userContext.getChecker().checkIdOfDoctor(doctorId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeDoctorList(HisUserContext userContext, String platformId, 
			String doctorIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingDoctorList(userContext, platformId,  doctorIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveDoctorList(platform, doctorIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withDoctorList().done());
				deleteRelationListInGraph(userContext, platform.getDoctorList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingDoctor(HisUserContext userContext, String platformId, 
		String doctorId, int doctorVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfDoctor(doctorId);
		userContext.getChecker().checkVersionOfDoctor(doctorVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeDoctor(HisUserContext userContext, String platformId, 
		String doctorId, int doctorVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingDoctor(userContext,platformId, doctorId, doctorVersion,tokensExpr);
		
		Doctor doctor = createIndexedDoctor(doctorId, doctorVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeDoctor( doctor );		
			platform = savePlatform(userContext, platform, tokens().withDoctorList().done());
			deleteRelationInGraph(userContext, doctor);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingDoctor(HisUserContext userContext, String platformId, 
		String doctorId, int doctorVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfDoctor(doctorId);
		userContext.getChecker().checkVersionOfDoctor(doctorVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyDoctorFrom(HisUserContext userContext, String platformId, 
		String doctorId, int doctorVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingDoctor(userContext,platformId, doctorId, doctorVersion,tokensExpr);
		
		Doctor doctor = createIndexedDoctor(doctorId, doctorVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyDoctorFrom( doctor );		
			platform = savePlatform(userContext, platform, tokens().withDoctorList().done());
			
			userContext.getManagerGroup().getDoctorManager().onNewInstanceCreated(userContext, (Doctor)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingDoctor(HisUserContext userContext, String platformId, String doctorId, int doctorVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfDoctor(doctorId);
		userContext.getChecker().checkVersionOfDoctor(doctorVersion);
		

		if(Doctor.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfDoctor(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateDoctor(HisUserContext userContext, String platformId, String doctorId, int doctorVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingDoctor(userContext, platformId, doctorId, doctorVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withDoctorList().searchDoctorListWith(Doctor.ID_PROPERTY, "eq", doctorId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeDoctor( doctor );	
			//make changes to AcceleraterAccount.
			Doctor doctorIndex = createIndexedDoctor(doctorId, doctorVersion);
		
			Doctor doctor = platform.findTheDoctor(doctorIndex);
			if(doctor == null){
				throw new PlatformManagerException(doctor+" is NOT FOUND" );
			}
			
			doctor.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withDoctorList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingProfile(HisUserContext userContext, String platformId, String name, String gender, int age, String identificationNumber, String mobile,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfProfile(name);
		
		userContext.getChecker().checkGenderOfProfile(gender);
		
		userContext.getChecker().checkAgeOfProfile(age);
		
		userContext.getChecker().checkIdentificationNumberOfProfile(identificationNumber);
		
		userContext.getChecker().checkMobileOfProfile(mobile);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addProfile(HisUserContext userContext, String platformId, String name, String gender, int age, String identificationNumber, String mobile, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProfile(userContext,platformId,name, gender, age, identificationNumber, mobile,tokensExpr);
		
		Profile profile = createProfile(userContext,name, gender, age, identificationNumber, mobile);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addProfile( profile );		
			platform = savePlatform(userContext, platform, tokens().withProfileList().done());
			
			userContext.getManagerGroup().getProfileManager().onNewInstanceCreated(userContext, profile);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProfileProperties(HisUserContext userContext, String platformId,String id,String name,String gender,int age,String identificationNumber,String mobile,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfProfile(id);
		
		userContext.getChecker().checkNameOfProfile( name);
		userContext.getChecker().checkGenderOfProfile( gender);
		userContext.getChecker().checkAgeOfProfile( age);
		userContext.getChecker().checkIdentificationNumberOfProfile( identificationNumber);
		userContext.getChecker().checkMobileOfProfile( mobile);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateProfileProperties(HisUserContext userContext, String platformId, String id,String name,String gender,int age,String identificationNumber,String mobile, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProfileProperties(userContext,platformId,id,name,gender,age,identificationNumber,mobile,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProfileListList()
				.searchProfileListWith(Profile.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getProfileList().isEmpty()){
			throw new PlatformManagerException("Profile is NOT FOUND with id: '"+id+"'");
		}
		
		Profile item = platformToUpdate.getProfileList().first();
		
		item.updateName( name );
		item.updateGender( gender );
		item.updateAge( age );
		item.updateIdentificationNumber( identificationNumber );
		item.updateMobile( mobile );

		
		//checkParamsForAddingProfile(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withProfileList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Profile createProfile(HisUserContext userContext, String name, String gender, int age, String identificationNumber, String mobile) throws Exception{

		Profile profile = new Profile();
		
		
		profile.setName(name);		
		profile.setGender(gender);		
		profile.setAge(age);		
		profile.setIdentificationNumber(identificationNumber);		
		profile.setMobile(mobile);
	
		
		return profile;
	
		
	}
	
	protected Profile createIndexedProfile(String id, int version){

		Profile profile = new Profile();
		profile.setId(id);
		profile.setVersion(version);
		return profile;			
		
	}
	
	protected void checkParamsForRemovingProfileList(HisUserContext userContext, String platformId, 
			String profileIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String profileId: profileIds){
			userContext.getChecker().checkIdOfProfile(profileId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeProfileList(HisUserContext userContext, String platformId, 
			String profileIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProfileList(userContext, platformId,  profileIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveProfileList(platform, profileIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withProfileList().done());
				deleteRelationListInGraph(userContext, platform.getProfileList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProfile(HisUserContext userContext, String platformId, 
		String profileId, int profileVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkVersionOfProfile(profileVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeProfile(HisUserContext userContext, String platformId, 
		String profileId, int profileVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProfile(userContext,platformId, profileId, profileVersion,tokensExpr);
		
		Profile profile = createIndexedProfile(profileId, profileVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeProfile( profile );		
			platform = savePlatform(userContext, platform, tokens().withProfileList().done());
			deleteRelationInGraph(userContext, profile);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingProfile(HisUserContext userContext, String platformId, 
		String profileId, int profileVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkVersionOfProfile(profileVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyProfileFrom(HisUserContext userContext, String platformId, 
		String profileId, int profileVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProfile(userContext,platformId, profileId, profileVersion,tokensExpr);
		
		Profile profile = createIndexedProfile(profileId, profileVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyProfileFrom( profile );		
			platform = savePlatform(userContext, platform, tokens().withProfileList().done());
			
			userContext.getManagerGroup().getProfileManager().onNewInstanceCreated(userContext, (Profile)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingProfile(HisUserContext userContext, String platformId, String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkVersionOfProfile(profileVersion);
		

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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateProfile(HisUserContext userContext, String platformId, String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProfile(userContext, platformId, profileId, profileVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withProfileList().searchProfileListWith(Profile.ID_PROPERTY, "eq", profileId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeProfile( profile );	
			//make changes to AcceleraterAccount.
			Profile profileIndex = createIndexedProfile(profileId, profileVersion);
		
			Profile profile = platform.findTheProfile(profileIndex);
			if(profile == null){
				throw new PlatformManagerException(profile+" is NOT FOUND" );
			}
			
			profile.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withProfileList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingRegistration(HisUserContext userContext, String platformId, String title, String patientId, String registerId, String content, String status,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkTitleOfRegistration(title);
		
		userContext.getChecker().checkPatientIdOfRegistration(patientId);
		
		userContext.getChecker().checkRegisterIdOfRegistration(registerId);
		
		userContext.getChecker().checkContentOfRegistration(content);
		
		userContext.getChecker().checkStatusOfRegistration(status);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addRegistration(HisUserContext userContext, String platformId, String title, String patientId, String registerId, String content, String status, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRegistration(userContext,platformId,title, patientId, registerId, content, status,tokensExpr);
		
		Registration registration = createRegistration(userContext,title, patientId, registerId, content, status);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addRegistration( registration );		
			platform = savePlatform(userContext, platform, tokens().withRegistrationList().done());
			
			userContext.getManagerGroup().getRegistrationManager().onNewInstanceCreated(userContext, registration);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRegistrationProperties(HisUserContext userContext, String platformId,String id,String title,String content,String status,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfRegistration(id);
		
		userContext.getChecker().checkTitleOfRegistration( title);
		userContext.getChecker().checkContentOfRegistration( content);
		userContext.getChecker().checkStatusOfRegistration( status);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateRegistrationProperties(HisUserContext userContext, String platformId, String id,String title,String content,String status, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRegistrationProperties(userContext,platformId,id,title,content,status,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRegistrationListList()
				.searchRegistrationListWith(Registration.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getRegistrationList().isEmpty()){
			throw new PlatformManagerException("Registration is NOT FOUND with id: '"+id+"'");
		}
		
		Registration item = platformToUpdate.getRegistrationList().first();
		
		item.updateTitle( title );
		item.updateContent( content );
		item.updateStatus( status );

		
		//checkParamsForAddingRegistration(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withRegistrationList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Registration createRegistration(HisUserContext userContext, String title, String patientId, String registerId, String content, String status) throws Exception{

		Registration registration = new Registration();
		
		
		registration.setTitle(title);		
		Profile  patient = new Profile();
		patient.setId(patientId);		
		registration.setPatient(patient);		
		Profile  register = new Profile();
		register.setId(registerId);		
		registration.setRegister(register);		
		registration.setContent(content);		
		registration.setUpdateTime(userContext.now());		
		registration.setStatus(status);
	
		
		return registration;
	
		
	}
	
	protected Registration createIndexedRegistration(String id, int version){

		Registration registration = new Registration();
		registration.setId(id);
		registration.setVersion(version);
		return registration;			
		
	}
	
	protected void checkParamsForRemovingRegistrationList(HisUserContext userContext, String platformId, 
			String registrationIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String registrationId: registrationIds){
			userContext.getChecker().checkIdOfRegistration(registrationId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeRegistrationList(HisUserContext userContext, String platformId, 
			String registrationIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRegistrationList(userContext, platformId,  registrationIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveRegistrationList(platform, registrationIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withRegistrationList().done());
				deleteRelationListInGraph(userContext, platform.getRegistrationList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRegistration(HisUserContext userContext, String platformId, 
		String registrationId, int registrationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfRegistration(registrationId);
		userContext.getChecker().checkVersionOfRegistration(registrationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeRegistration(HisUserContext userContext, String platformId, 
		String registrationId, int registrationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRegistration(userContext,platformId, registrationId, registrationVersion,tokensExpr);
		
		Registration registration = createIndexedRegistration(registrationId, registrationVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeRegistration( registration );		
			platform = savePlatform(userContext, platform, tokens().withRegistrationList().done());
			deleteRelationInGraph(userContext, registration);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRegistration(HisUserContext userContext, String platformId, 
		String registrationId, int registrationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfRegistration(registrationId);
		userContext.getChecker().checkVersionOfRegistration(registrationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyRegistrationFrom(HisUserContext userContext, String platformId, 
		String registrationId, int registrationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRegistration(userContext,platformId, registrationId, registrationVersion,tokensExpr);
		
		Registration registration = createIndexedRegistration(registrationId, registrationVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			registration.updateUpdateTime(userContext.now());
			
			platform.copyRegistrationFrom( registration );		
			platform = savePlatform(userContext, platform, tokens().withRegistrationList().done());
			
			userContext.getManagerGroup().getRegistrationManager().onNewInstanceCreated(userContext, (Registration)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRegistration(HisUserContext userContext, String platformId, String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateRegistration(HisUserContext userContext, String platformId, String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRegistration(userContext, platformId, registrationId, registrationVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRegistrationList().searchRegistrationListWith(Registration.ID_PROPERTY, "eq", registrationId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeRegistration( registration );	
			//make changes to AcceleraterAccount.
			Registration registrationIndex = createIndexedRegistration(registrationId, registrationVersion);
		
			Registration registration = platform.findTheRegistration(registrationIndex);
			if(registration == null){
				throw new PlatformManagerException(registration+" is NOT FOUND" );
			}
			
			registration.changeProperty(property, newValueExpr);
			registration.updateUpdateTime(userContext.now());
			platform = savePlatform(userContext, platform, tokens().withRegistrationList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(HisUserContext userContext, Platform newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


