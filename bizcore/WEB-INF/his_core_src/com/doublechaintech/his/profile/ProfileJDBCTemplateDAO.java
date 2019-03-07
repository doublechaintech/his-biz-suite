
package com.doublechaintech.his.profile;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.his.HisNamingServiceDAO;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.AccessKey;
import com.doublechaintech.his.DateKey;
import com.doublechaintech.his.StatsInfo;
import com.doublechaintech.his.StatsItem;

import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;


import com.doublechaintech.his.platform.Platform;
import com.doublechaintech.his.registration.Registration;

import com.doublechaintech.his.platform.PlatformDAO;
import com.doublechaintech.his.registration.RegistrationDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class ProfileJDBCTemplateDAO extends HisNamingServiceDAO implements ProfileDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		
	
  	private  RegistrationDAO  registrationDAO;
 	public void setRegistrationDAO(RegistrationDAO pRegistrationDAO){
 	
 		if(pRegistrationDAO == null){
 			throw new IllegalStateException("Do not try to set registrationDAO to null.");
 		}
	 	this.registrationDAO = pRegistrationDAO;
 	}
 	public RegistrationDAO getRegistrationDAO(){
 		if(this.registrationDAO == null){
 			throw new IllegalStateException("The registrationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.registrationDAO;
 	}	
 	
			
		

	
	/*
	protected Profile load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalProfile(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Profile load(String id,Map<String,Object> options) throws Exception{
		return loadInternalProfile(ProfileTable.withId(id), options);
	}
	
	
	
	public Profile save(Profile profile,Map<String,Object> options){
		
		String methodName="save(Profile profile,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(profile, methodName, "profile");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalProfile(profile,options);
	}
	public Profile clone(String profileId, Map<String,Object> options) throws Exception{
	
		return clone(ProfileTable.withId(profileId),options);
	}
	
	protected Profile clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String profileId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Profile newProfile = loadInternalProfile(accessKey, options);
		newProfile.setVersion(0);
		
		
 		
 		if(isSaveRegistrationListAsPatientEnabled(options)){
 			for(Registration item: newProfile.getRegistrationListAsPatient()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRegistrationListAsRegisterEnabled(options)){
 			for(Registration item: newProfile.getRegistrationListAsRegister()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalProfile(newProfile,options);
		
		return newProfile;
	}
	
	
	
	

	protected void throwIfHasException(String profileId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ProfileVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ProfileNotFoundException(
					"The " + this.getTableName() + "(" + profileId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String profileId, int version) throws Exception{
	
		String methodName="delete(String profileId, int version)";
		assertMethodArgumentNotNull(profileId, methodName, "profileId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{profileId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(profileId,version);
		}
		
	
	}
	
	
	
	
	

	public Profile disconnectFromAll(String profileId, int version) throws Exception{
	
		
		Profile profile = loadInternalProfile(ProfileTable.withId(profileId), emptyOptions());
		profile.clearFromAll();
		this.saveProfile(profile);
		return profile;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ProfileTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "profile";
	}
	@Override
	protected String getBeanName() {
		
		return "profile";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ProfileTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ProfileTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ProfileTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractRegistrationListAsPatientEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProfileTokens.REGISTRATION_LIST_AS_PATIENT);
 	}
 	protected boolean isAnalyzeRegistrationListAsPatientEnabled(Map<String,Object> options){		 		
 		return ProfileTokens.of(options).analyzeRegistrationListAsPatientEnabled();
 	}
	
	protected boolean isSaveRegistrationListAsPatientEnabled(Map<String,Object> options){
		return checkOptions(options, ProfileTokens.REGISTRATION_LIST_AS_PATIENT);
		
 	}
 	
		
	
	protected boolean isExtractRegistrationListAsRegisterEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProfileTokens.REGISTRATION_LIST_AS_REGISTER);
 	}
 	protected boolean isAnalyzeRegistrationListAsRegisterEnabled(Map<String,Object> options){		 		
 		return ProfileTokens.of(options).analyzeRegistrationListAsRegisterEnabled();
 	}
	
	protected boolean isSaveRegistrationListAsRegisterEnabled(Map<String,Object> options){
		return checkOptions(options, ProfileTokens.REGISTRATION_LIST_AS_REGISTER);
		
 	}
 	
		

	

	protected ProfileMapper getProfileMapper(){
		return new ProfileMapper();
	}

	
	
	protected Profile extractProfile(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Profile profile = loadSingleObject(accessKey, getProfileMapper());
			return profile;
		}catch(EmptyResultDataAccessException e){
			throw new ProfileNotFoundException("Profile("+accessKey+") is not found!");
		}

	}

	
	

	protected Profile loadInternalProfile(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Profile profile = extractProfile(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(profile, loadOptions);
 		}
 
		
		if(isExtractRegistrationListAsPatientEnabled(loadOptions)){
	 		extractRegistrationListAsPatient(profile, loadOptions);
 		}	
 		if(isAnalyzeRegistrationListAsPatientEnabled(loadOptions)){
	 		analyzeRegistrationListAsPatient(profile, loadOptions);
 		}
 		
		
		if(isExtractRegistrationListAsRegisterEnabled(loadOptions)){
	 		extractRegistrationListAsRegister(profile, loadOptions);
 		}	
 		if(isAnalyzeRegistrationListAsRegisterEnabled(loadOptions)){
	 		analyzeRegistrationListAsRegister(profile, loadOptions);
 		}
 		
		
		return profile;
		
	}

	 

 	protected Profile extractPlatform(Profile profile, Map<String,Object> options) throws Exception{

		if(profile.getPlatform() == null){
			return profile;
		}
		String platformId = profile.getPlatform().getId();
		if( platformId == null){
			return profile;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			profile.setPlatform(platform);
		}
		
 		
 		return profile;
 	}
 		
 
		
	protected void enhanceRegistrationListAsPatient(SmartList<Registration> registrationListAsPatient,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Profile extractRegistrationListAsPatient(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}
		convertListOptions(options,"registrationListAsPatient","registrationList");

		
		
		SmartList<Registration> registrationListAsPatient = getRegistrationDAO().findRegistrationByPatient(profile.getId(),options);
		if(registrationListAsPatient != null){
			enhanceRegistrationListAsPatient(registrationListAsPatient,options);
			profile.setRegistrationListAsPatient(registrationListAsPatient);
		}
		
		return profile;
	
	}	
	
	protected Profile analyzeRegistrationListAsPatient(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}
		convertListOptions(options,"registrationListAsPatient","registrationList");

		
		
		SmartList<Registration> registrationListAsPatient = profile.getRegistrationListAsPatient();
		if(registrationListAsPatient != null){
			getRegistrationDAO().analyzeRegistrationByPatient(registrationListAsPatient, profile.getId(), options);
			
		}
		
		return profile;
	
	}	
	
		
	protected void enhanceRegistrationListAsRegister(SmartList<Registration> registrationListAsRegister,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Profile extractRegistrationListAsRegister(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}
		convertListOptions(options,"registrationListAsRegister","registrationList");

		
		
		SmartList<Registration> registrationListAsRegister = getRegistrationDAO().findRegistrationByRegister(profile.getId(),options);
		if(registrationListAsRegister != null){
			enhanceRegistrationListAsRegister(registrationListAsRegister,options);
			profile.setRegistrationListAsRegister(registrationListAsRegister);
		}
		
		return profile;
	
	}	
	
	protected Profile analyzeRegistrationListAsRegister(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}
		convertListOptions(options,"registrationListAsRegister","registrationList");

		
		
		SmartList<Registration> registrationListAsRegister = profile.getRegistrationListAsRegister();
		if(registrationListAsRegister != null){
			getRegistrationDAO().analyzeRegistrationByPatient(registrationListAsRegister, profile.getId(), options);
			
		}
		
		return profile;
	
	}	
	
		
		
  	
 	public SmartList<Profile> findProfileByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<Profile> resultList = queryWith(ProfileTable.COLUMN_PLATFORM, platformId, options, getProfileMapper());
		// analyzeProfileByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Profile> findProfileByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Profile> resultList =  queryWithRange(ProfileTable.COLUMN_PLATFORM, platformId, options, getProfileMapper(), start, count);
 		//analyzeProfileByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeProfileByPlatform(SmartList<Profile> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countProfileByPlatform(String platformId,Map<String,Object> options){

 		return countWith(ProfileTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countProfileByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ProfileTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected Profile saveProfile(Profile  profile){
		
		if(!profile.isChanged()){
			return profile;
		}
		
		
		String SQL=this.getSaveProfileSQL(profile);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveProfileParameters(profile);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		profile.incVersion();
		return profile;
	
	}
	public SmartList<Profile> saveProfileList(SmartList<Profile> profileList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitProfileList(profileList);
		
		batchProfileCreate((List<Profile>)lists[CREATE_LIST_INDEX]);
		
		batchProfileUpdate((List<Profile>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Profile profile:profileList){
			if(profile.isChanged()){
				profile.incVersion();
			}
			
		
		}
		
		
		return profileList;
	}

	public SmartList<Profile> removeProfileList(SmartList<Profile> profileList,Map<String,Object> options){
		
		
		super.removeList(profileList, options);
		
		return profileList;
		
		
	}
	
	protected List<Object[]> prepareProfileBatchCreateArgs(List<Profile> profileList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Profile profile:profileList ){
			Object [] parameters = prepareProfileCreateParameters(profile);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareProfileBatchUpdateArgs(List<Profile> profileList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Profile profile:profileList ){
			if(!profile.isChanged()){
				continue;
			}
			Object [] parameters = prepareProfileUpdateParameters(profile);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchProfileCreate(List<Profile> profileList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareProfileBatchCreateArgs(profileList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchProfileUpdate(List<Profile> profileList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareProfileBatchUpdateArgs(profileList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitProfileList(List<Profile> profileList){
		
		List<Profile> profileCreateList=new ArrayList<Profile>();
		List<Profile> profileUpdateList=new ArrayList<Profile>();
		
		for(Profile profile: profileList){
			if(isUpdateRequest(profile)){
				profileUpdateList.add( profile);
				continue;
			}
			profileCreateList.add(profile);
		}
		
		return new Object[]{profileCreateList,profileUpdateList};
	}
	
	protected boolean isUpdateRequest(Profile profile){
 		return profile.getVersion() > 0;
 	}
 	protected String getSaveProfileSQL(Profile profile){
 		if(isUpdateRequest(profile)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveProfileParameters(Profile profile){
 		if(isUpdateRequest(profile) ){
 			return prepareProfileUpdateParameters(profile);
 		}
 		return prepareProfileCreateParameters(profile);
 	}
 	protected Object[] prepareProfileUpdateParameters(Profile profile){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = profile.getName();
 		parameters[1] = profile.getGender();
 		parameters[2] = profile.getAge();
 		parameters[3] = profile.getIdentificationNumber();
 		parameters[4] = profile.getMobile(); 	
 		if(profile.getPlatform() != null){
 			parameters[5] = profile.getPlatform().getId();
 		}
 		
 		parameters[6] = profile.nextVersion();
 		parameters[7] = profile.getId();
 		parameters[8] = profile.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareProfileCreateParameters(Profile profile){
		Object[] parameters = new Object[7];
		String newProfileId=getNextId();
		profile.setId(newProfileId);
		parameters[0] =  profile.getId();
 
 		parameters[1] = profile.getName();
 		parameters[2] = profile.getGender();
 		parameters[3] = profile.getAge();
 		parameters[4] = profile.getIdentificationNumber();
 		parameters[5] = profile.getMobile(); 	
 		if(profile.getPlatform() != null){
 			parameters[6] = profile.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Profile saveInternalProfile(Profile profile, Map<String,Object> options){
		
		saveProfile(profile);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(profile, options);
 		}
 
		
		if(isSaveRegistrationListAsPatientEnabled(options)){
	 		saveRegistrationListAsPatient(profile, options);
	 		//removeRegistrationListAsPatient(profile, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveRegistrationListAsRegisterEnabled(options)){
	 		saveRegistrationListAsRegister(profile, options);
	 		//removeRegistrationListAsRegister(profile, options);
	 		//Not delete the record
	 		
 		}		
		
		return profile;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Profile savePlatform(Profile profile, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(profile.getPlatform() == null){
 			return profile;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(profile.getPlatform(),options);
 		return profile;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Profile planToRemoveRegistrationListAsPatient(Profile profile, String registrationIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Registration.PATIENT_PROPERTY, profile.getId());
		key.put(Registration.ID_PROPERTY, registrationIds);
		
		SmartList<Registration> externalRegistrationList = getRegistrationDAO().
				findRegistrationWithKey(key, options);
		if(externalRegistrationList == null){
			return profile;
		}
		if(externalRegistrationList.isEmpty()){
			return profile;
		}
		
		for(Registration registration: externalRegistrationList){

			registration.clearFromAll();
		}
		
		
		SmartList<Registration> registrationListAsPatient = profile.getRegistrationListAsPatient();		
		registrationListAsPatient.addAllToRemoveList(externalRegistrationList);
		return profile;	
	
	}


	//disconnect Profile with platform in Registration
	public Profile planToRemoveRegistrationListAsPatientWithPlatform(Profile profile, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Registration.PATIENT_PROPERTY, profile.getId());
		key.put(Registration.PLATFORM_PROPERTY, platformId);
		
		SmartList<Registration> externalRegistrationList = getRegistrationDAO().
				findRegistrationWithKey(key, options);
		if(externalRegistrationList == null){
			return profile;
		}
		if(externalRegistrationList.isEmpty()){
			return profile;
		}
		
		for(Registration registration: externalRegistrationList){
			registration.clearPlatform();
			registration.clearPatient();
			
		}
		
		
		SmartList<Registration> registrationList = profile.getRegistrationListAsPatient();		
		registrationList.addAllToRemoveList(externalRegistrationList);
		return profile;
	}
	
	public int countRegistrationListAsPatientWithPlatform(String profileId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Registration.PATIENT_PROPERTY, profileId);
		key.put(Registration.PLATFORM_PROPERTY, platformId);
		
		int count = getRegistrationDAO().countRegistrationWithKey(key, options);
		return count;
	}
	
	public Profile planToRemoveRegistrationListAsRegister(Profile profile, String registrationIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Registration.PATIENT_PROPERTY, profile.getId());
		key.put(Registration.ID_PROPERTY, registrationIds);
		
		SmartList<Registration> externalRegistrationList = getRegistrationDAO().
				findRegistrationWithKey(key, options);
		if(externalRegistrationList == null){
			return profile;
		}
		if(externalRegistrationList.isEmpty()){
			return profile;
		}
		
		for(Registration registration: externalRegistrationList){

			registration.clearFromAll();
		}
		
		
		SmartList<Registration> registrationListAsRegister = profile.getRegistrationListAsRegister();		
		registrationListAsRegister.addAllToRemoveList(externalRegistrationList);
		return profile;	
	
	}


	//disconnect Profile with platform in Registration
	public Profile planToRemoveRegistrationListAsRegisterWithPlatform(Profile profile, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Registration.PATIENT_PROPERTY, profile.getId());
		key.put(Registration.PLATFORM_PROPERTY, platformId);
		
		SmartList<Registration> externalRegistrationList = getRegistrationDAO().
				findRegistrationWithKey(key, options);
		if(externalRegistrationList == null){
			return profile;
		}
		if(externalRegistrationList.isEmpty()){
			return profile;
		}
		
		for(Registration registration: externalRegistrationList){
			registration.clearPlatform();
			registration.clearPatient();
			
		}
		
		
		SmartList<Registration> registrationList = profile.getRegistrationListAsPatient();		
		registrationList.addAllToRemoveList(externalRegistrationList);
		return profile;
	}
	
	public int countRegistrationListAsRegisterWithPlatform(String profileId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Registration.PATIENT_PROPERTY, profileId);
		key.put(Registration.PLATFORM_PROPERTY, platformId);
		
		int count = getRegistrationDAO().countRegistrationWithKey(key, options);
		return count;
	}
	

		
	protected Profile saveRegistrationListAsPatient(Profile profile, Map<String,Object> options){
		
		
		
		
		SmartList<Registration> registrationListAsPatient = profile.getRegistrationListAsPatient();
		if(registrationListAsPatient == null){
			//null list means nothing
			return profile;
		}
		SmartList<Registration> mergedUpdateRegistrationListAsPatient = new SmartList<Registration>();
		
		
		mergedUpdateRegistrationListAsPatient.addAll(registrationListAsPatient); 
		if(registrationListAsPatient.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRegistrationListAsPatient.addAll(registrationListAsPatient.getToRemoveList());
			registrationListAsPatient.removeAll(registrationListAsPatient.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getRegistrationDAO().saveRegistrationList(mergedUpdateRegistrationListAsPatient,options);
		
		if(registrationListAsPatient.getToRemoveList() != null){
			registrationListAsPatient.removeAll(registrationListAsPatient.getToRemoveList());
		}
		
		
		return profile;
	
	}
	
	protected Profile removeRegistrationListAsPatient(Profile profile, Map<String,Object> options){
	
	
		SmartList<Registration> registrationListAsPatient = profile.getRegistrationListAsPatient();
		if(registrationListAsPatient == null){
			return profile;
		}	
	
		SmartList<Registration> toRemoveRegistrationListAsPatient = registrationListAsPatient.getToRemoveList();
		
		if(toRemoveRegistrationListAsPatient == null){
			return profile;
		}
		if(toRemoveRegistrationListAsPatient.isEmpty()){
			return profile;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRegistrationDAO().removeRegistrationList(toRemoveRegistrationListAsPatient,options);
		
		return profile;
	
	}
	
	

 	
 	
	
	
	
		
	protected Profile saveRegistrationListAsRegister(Profile profile, Map<String,Object> options){
		
		
		
		
		SmartList<Registration> registrationListAsRegister = profile.getRegistrationListAsRegister();
		if(registrationListAsRegister == null){
			//null list means nothing
			return profile;
		}
		SmartList<Registration> mergedUpdateRegistrationListAsRegister = new SmartList<Registration>();
		
		
		mergedUpdateRegistrationListAsRegister.addAll(registrationListAsRegister); 
		if(registrationListAsRegister.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRegistrationListAsRegister.addAll(registrationListAsRegister.getToRemoveList());
			registrationListAsRegister.removeAll(registrationListAsRegister.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getRegistrationDAO().saveRegistrationList(mergedUpdateRegistrationListAsRegister,options);
		
		if(registrationListAsRegister.getToRemoveList() != null){
			registrationListAsRegister.removeAll(registrationListAsRegister.getToRemoveList());
		}
		
		
		return profile;
	
	}
	
	protected Profile removeRegistrationListAsRegister(Profile profile, Map<String,Object> options){
	
	
		SmartList<Registration> registrationListAsRegister = profile.getRegistrationListAsRegister();
		if(registrationListAsRegister == null){
			return profile;
		}	
	
		SmartList<Registration> toRemoveRegistrationListAsRegister = registrationListAsRegister.getToRemoveList();
		
		if(toRemoveRegistrationListAsRegister == null){
			return profile;
		}
		if(toRemoveRegistrationListAsRegister.isEmpty()){
			return profile;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRegistrationDAO().removeRegistrationList(toRemoveRegistrationListAsRegister,options);
		
		return profile;
	
	}
	
	

 	
 	
	
	
	
		

	public Profile present(Profile profile,Map<String, Object> options){
	
		presentRegistrationListAsPatient(profile,options);
		presentRegistrationListAsRegister(profile,options);

		return profile;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Profile presentRegistrationListAsPatient(
			Profile profile,
			Map<String, Object> options) {

		SmartList<Registration> registrationListAsPatient = profile.getRegistrationListAsPatient();		
				SmartList<Registration> newList= presentSubList(profile.getId(),
				registrationListAsPatient,
				options,
				getRegistrationDAO()::countRegistrationByPatient,
				getRegistrationDAO()::findRegistrationByPatient
				);

		
		profile.setRegistrationListAsPatient(newList);
		

		return profile;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Profile presentRegistrationListAsRegister(
			Profile profile,
			Map<String, Object> options) {

		SmartList<Registration> registrationListAsRegister = profile.getRegistrationListAsRegister();		
				SmartList<Registration> newList= presentSubList(profile.getId(),
				registrationListAsRegister,
				options,
				getRegistrationDAO()::countRegistrationByRegister,
				getRegistrationDAO()::findRegistrationByRegister
				);

		
		profile.setRegistrationListAsRegister(newList);
		

		return profile;
	}			
		

	
    public SmartList<Profile> requestCandidateProfileForRegistrationAsPatient(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProfileTable.COLUMN_NAME, filterKey, pageNo, pageSize, getProfileMapper());
    }
		
    public SmartList<Profile> requestCandidateProfileForRegistrationAsRegister(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProfileTable.COLUMN_NAME, filterKey, pageNo, pageSize, getProfileMapper());
    }
		

	protected String getTableName(){
		return ProfileTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Profile> profileList) {		
		this.enhanceListInternal(profileList, this.getProfileMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Profile> profileList = ownerEntity.collectRefsWithType(Profile.INTERNAL_TYPE);
		this.enhanceList(profileList);
		
	}
	
	@Override
	public SmartList<Profile> findProfileWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getProfileMapper());

	}
	@Override
	public int countProfileWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countProfileWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Profile> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getProfileMapper());
	}
}


