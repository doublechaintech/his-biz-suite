
package com.doublechaintech.his.platform;

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


import com.doublechaintech.his.profile.Profile;
import com.doublechaintech.his.registration.Registration;
import com.doublechaintech.his.doctor.Doctor;

import com.doublechaintech.his.doctor.DoctorDAO;
import com.doublechaintech.his.profile.ProfileDAO;
import com.doublechaintech.his.registration.RegistrationDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class PlatformJDBCTemplateDAO extends HisNamingServiceDAO implements PlatformDAO{


			
		
	
  	private  DoctorDAO  doctorDAO;
 	public void setDoctorDAO(DoctorDAO pDoctorDAO){
 	
 		if(pDoctorDAO == null){
 			throw new IllegalStateException("Do not try to set doctorDAO to null.");
 		}
	 	this.doctorDAO = pDoctorDAO;
 	}
 	public DoctorDAO getDoctorDAO(){
 		if(this.doctorDAO == null){
 			throw new IllegalStateException("The doctorDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.doctorDAO;
 	}	
 	
			
		
	
  	private  ProfileDAO  profileDAO;
 	public void setProfileDAO(ProfileDAO pProfileDAO){
 	
 		if(pProfileDAO == null){
 			throw new IllegalStateException("Do not try to set profileDAO to null.");
 		}
	 	this.profileDAO = pProfileDAO;
 	}
 	public ProfileDAO getProfileDAO(){
 		if(this.profileDAO == null){
 			throw new IllegalStateException("The profileDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.profileDAO;
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
	protected Platform load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Platform load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(PlatformTable.withId(id), options);
	}
	
	
	
	public Platform save(Platform platform,Map<String,Object> options){
		
		String methodName="save(Platform platform,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(platform, methodName, "platform");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPlatform(platform,options);
	}
	public Platform clone(String platformId, Map<String,Object> options) throws Exception{
	
		return clone(PlatformTable.withId(platformId),options);
	}
	
	protected Platform clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String platformId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Platform newPlatform = loadInternalPlatform(accessKey, options);
		newPlatform.setVersion(0);
		
		
 		
 		if(isSaveDoctorListEnabled(options)){
 			for(Doctor item: newPlatform.getDoctorList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveProfileListEnabled(options)){
 			for(Profile item: newPlatform.getProfileList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRegistrationListEnabled(options)){
 			for(Registration item: newPlatform.getRegistrationList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalPlatform(newPlatform,options);
		
		return newPlatform;
	}
	
	
	
	

	protected void throwIfHasException(String platformId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PlatformVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PlatformNotFoundException(
					"The " + this.getTableName() + "(" + platformId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String platformId, int version) throws Exception{
	
		String methodName="delete(String platformId, int version)";
		assertMethodArgumentNotNull(platformId, methodName, "platformId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{platformId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(platformId,version);
		}
		
	
	}
	
	
	
	
	

	public Platform disconnectFromAll(String platformId, int version) throws Exception{
	
		
		Platform platform = loadInternalPlatform(PlatformTable.withId(platformId), emptyOptions());
		platform.clearFromAll();
		this.savePlatform(platform);
		return platform;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return PlatformTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "platform";
	}
	@Override
	protected String getBeanName() {
		
		return "platform";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PlatformTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractDoctorListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.DOCTOR_LIST);
 	}
 	protected boolean isAnalyzeDoctorListEnabled(Map<String,Object> options){		 		
 		return PlatformTokens.of(options).analyzeDoctorListEnabled();
 	}
	
	protected boolean isSaveDoctorListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.DOCTOR_LIST);
		
 	}
 	
		
	
	protected boolean isExtractProfileListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.PROFILE_LIST);
 	}
 	protected boolean isAnalyzeProfileListEnabled(Map<String,Object> options){		 		
 		return PlatformTokens.of(options).analyzeProfileListEnabled();
 	}
	
	protected boolean isSaveProfileListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.PROFILE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractRegistrationListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.REGISTRATION_LIST);
 	}
 	protected boolean isAnalyzeRegistrationListEnabled(Map<String,Object> options){		 		
 		return PlatformTokens.of(options).analyzeRegistrationListEnabled();
 	}
	
	protected boolean isSaveRegistrationListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.REGISTRATION_LIST);
		
 	}
 	
		

	

	protected PlatformMapper getPlatformMapper(){
		return new PlatformMapper();
	}

	
	
	protected Platform extractPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Platform platform = loadSingleObject(accessKey, getPlatformMapper());
			return platform;
		}catch(EmptyResultDataAccessException e){
			throw new PlatformNotFoundException("Platform("+accessKey+") is not found!");
		}

	}

	
	

	protected Platform loadInternalPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Platform platform = extractPlatform(accessKey, loadOptions);

		
		if(isExtractDoctorListEnabled(loadOptions)){
	 		extractDoctorList(platform, loadOptions);
 		}	
 		if(isAnalyzeDoctorListEnabled(loadOptions)){
	 		analyzeDoctorList(platform, loadOptions);
 		}
 		
		
		if(isExtractProfileListEnabled(loadOptions)){
	 		extractProfileList(platform, loadOptions);
 		}	
 		if(isAnalyzeProfileListEnabled(loadOptions)){
	 		analyzeProfileList(platform, loadOptions);
 		}
 		
		
		if(isExtractRegistrationListEnabled(loadOptions)){
	 		extractRegistrationList(platform, loadOptions);
 		}	
 		if(isAnalyzeRegistrationListEnabled(loadOptions)){
	 		analyzeRegistrationList(platform, loadOptions);
 		}
 		
		
		return platform;
		
	}

	
		
	protected void enhanceDoctorList(SmartList<Doctor> doctorList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractDoctorList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Doctor> doctorList = getDoctorDAO().findDoctorByPlatform(platform.getId(),options);
		if(doctorList != null){
			enhanceDoctorList(doctorList,options);
			platform.setDoctorList(doctorList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeDoctorList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Doctor> doctorList = platform.getDoctorList();
		if(doctorList != null){
			getDoctorDAO().analyzeDoctorByPlatform(doctorList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceProfileList(SmartList<Profile> profileList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractProfileList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Profile> profileList = getProfileDAO().findProfileByPlatform(platform.getId(),options);
		if(profileList != null){
			enhanceProfileList(profileList,options);
			platform.setProfileList(profileList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeProfileList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Profile> profileList = platform.getProfileList();
		if(profileList != null){
			getProfileDAO().analyzeProfileByPlatform(profileList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceRegistrationList(SmartList<Registration> registrationList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractRegistrationList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Registration> registrationList = getRegistrationDAO().findRegistrationByPlatform(platform.getId(),options);
		if(registrationList != null){
			enhanceRegistrationList(registrationList,options);
			platform.setRegistrationList(registrationList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeRegistrationList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Registration> registrationList = platform.getRegistrationList();
		if(registrationList != null){
			getRegistrationDAO().analyzeRegistrationByPlatform(registrationList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
		
 	
		
		
		

	

	protected Platform savePlatform(Platform  platform){
		
		if(!platform.isChanged()){
			return platform;
		}
		
		
		String SQL=this.getSavePlatformSQL(platform);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePlatformParameters(platform);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		platform.incVersion();
		return platform;
	
	}
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPlatformList(platformList);
		
		batchPlatformCreate((List<Platform>)lists[CREATE_LIST_INDEX]);
		
		batchPlatformUpdate((List<Platform>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Platform platform:platformList){
			if(platform.isChanged()){
				platform.incVersion();
			}
			
		
		}
		
		
		return platformList;
	}

	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		
		
		super.removeList(platformList, options);
		
		return platformList;
		
		
	}
	
	protected List<Object[]> preparePlatformBatchCreateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			Object [] parameters = preparePlatformCreateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePlatformBatchUpdateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			if(!platform.isChanged()){
				continue;
			}
			Object [] parameters = preparePlatformUpdateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPlatformCreate(List<Platform> platformList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePlatformBatchCreateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPlatformUpdate(List<Platform> platformList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePlatformBatchUpdateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPlatformList(List<Platform> platformList){
		
		List<Platform> platformCreateList=new ArrayList<Platform>();
		List<Platform> platformUpdateList=new ArrayList<Platform>();
		
		for(Platform platform: platformList){
			if(isUpdateRequest(platform)){
				platformUpdateList.add( platform);
				continue;
			}
			platformCreateList.add(platform);
		}
		
		return new Object[]{platformCreateList,platformUpdateList};
	}
	
	protected boolean isUpdateRequest(Platform platform){
 		return platform.getVersion() > 0;
 	}
 	protected String getSavePlatformSQL(Platform platform){
 		if(isUpdateRequest(platform)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePlatformParameters(Platform platform){
 		if(isUpdateRequest(platform) ){
 			return preparePlatformUpdateParameters(platform);
 		}
 		return preparePlatformCreateParameters(platform);
 	}
 	protected Object[] preparePlatformUpdateParameters(Platform platform){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = platform.getName();
 		parameters[1] = platform.getIntroduction();
 		parameters[2] = platform.getCurrentVersion();		
 		parameters[3] = platform.nextVersion();
 		parameters[4] = platform.getId();
 		parameters[5] = platform.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePlatformCreateParameters(Platform platform){
		Object[] parameters = new Object[4];
		String newPlatformId=getNextId();
		platform.setId(newPlatformId);
		parameters[0] =  platform.getId();
 
 		parameters[1] = platform.getName();
 		parameters[2] = platform.getIntroduction();
 		parameters[3] = platform.getCurrentVersion();		
 				
 		return parameters;
 	}
 	
	protected Platform saveInternalPlatform(Platform platform, Map<String,Object> options){
		
		savePlatform(platform);

		
		if(isSaveDoctorListEnabled(options)){
	 		saveDoctorList(platform, options);
	 		//removeDoctorList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveProfileListEnabled(options)){
	 		saveProfileList(platform, options);
	 		//removeProfileList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveRegistrationListEnabled(options)){
	 		saveRegistrationList(platform, options);
	 		//removeRegistrationList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		return platform;
		
	}
	
	
	
	//======================================================================================
	

	
	public Platform planToRemoveDoctorList(Platform platform, String doctorIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Doctor.PLATFORM_PROPERTY, platform.getId());
		key.put(Doctor.ID_PROPERTY, doctorIds);
		
		SmartList<Doctor> externalDoctorList = getDoctorDAO().
				findDoctorWithKey(key, options);
		if(externalDoctorList == null){
			return platform;
		}
		if(externalDoctorList.isEmpty()){
			return platform;
		}
		
		for(Doctor doctor: externalDoctorList){

			doctor.clearFromAll();
		}
		
		
		SmartList<Doctor> doctorList = platform.getDoctorList();		
		doctorList.addAllToRemoveList(externalDoctorList);
		return platform;	
	
	}


	public Platform planToRemoveProfileList(Platform platform, String profileIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Profile.PLATFORM_PROPERTY, platform.getId());
		key.put(Profile.ID_PROPERTY, profileIds);
		
		SmartList<Profile> externalProfileList = getProfileDAO().
				findProfileWithKey(key, options);
		if(externalProfileList == null){
			return platform;
		}
		if(externalProfileList.isEmpty()){
			return platform;
		}
		
		for(Profile profile: externalProfileList){

			profile.clearFromAll();
		}
		
		
		SmartList<Profile> profileList = platform.getProfileList();		
		profileList.addAllToRemoveList(externalProfileList);
		return platform;	
	
	}


	public Platform planToRemoveRegistrationList(Platform platform, String registrationIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Registration.PLATFORM_PROPERTY, platform.getId());
		key.put(Registration.ID_PROPERTY, registrationIds);
		
		SmartList<Registration> externalRegistrationList = getRegistrationDAO().
				findRegistrationWithKey(key, options);
		if(externalRegistrationList == null){
			return platform;
		}
		if(externalRegistrationList.isEmpty()){
			return platform;
		}
		
		for(Registration registration: externalRegistrationList){

			registration.clearFromAll();
		}
		
		
		SmartList<Registration> registrationList = platform.getRegistrationList();		
		registrationList.addAllToRemoveList(externalRegistrationList);
		return platform;	
	
	}


	//disconnect Platform with patient in Registration
	public Platform planToRemoveRegistrationListWithPatient(Platform platform, String patientId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Registration.PLATFORM_PROPERTY, platform.getId());
		key.put(Registration.PATIENT_PROPERTY, patientId);
		
		SmartList<Registration> externalRegistrationList = getRegistrationDAO().
				findRegistrationWithKey(key, options);
		if(externalRegistrationList == null){
			return platform;
		}
		if(externalRegistrationList.isEmpty()){
			return platform;
		}
		
		for(Registration registration: externalRegistrationList){
			registration.clearPatient();
			registration.clearPlatform();
			
		}
		
		
		SmartList<Registration> registrationList = platform.getRegistrationList();		
		registrationList.addAllToRemoveList(externalRegistrationList);
		return platform;
	}
	
	public int countRegistrationListWithPatient(String platformId, String patientId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Registration.PLATFORM_PROPERTY, platformId);
		key.put(Registration.PATIENT_PROPERTY, patientId);
		
		int count = getRegistrationDAO().countRegistrationWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with register in Registration
	public Platform planToRemoveRegistrationListWithRegister(Platform platform, String registerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Registration.PLATFORM_PROPERTY, platform.getId());
		key.put(Registration.REGISTER_PROPERTY, registerId);
		
		SmartList<Registration> externalRegistrationList = getRegistrationDAO().
				findRegistrationWithKey(key, options);
		if(externalRegistrationList == null){
			return platform;
		}
		if(externalRegistrationList.isEmpty()){
			return platform;
		}
		
		for(Registration registration: externalRegistrationList){
			registration.clearRegister();
			registration.clearPlatform();
			
		}
		
		
		SmartList<Registration> registrationList = platform.getRegistrationList();		
		registrationList.addAllToRemoveList(externalRegistrationList);
		return platform;
	}
	
	public int countRegistrationListWithRegister(String platformId, String registerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Registration.PLATFORM_PROPERTY, platformId);
		key.put(Registration.REGISTER_PROPERTY, registerId);
		
		int count = getRegistrationDAO().countRegistrationWithKey(key, options);
		return count;
	}
	

		
	protected Platform saveDoctorList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Doctor> doctorList = platform.getDoctorList();
		if(doctorList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Doctor> mergedUpdateDoctorList = new SmartList<Doctor>();
		
		
		mergedUpdateDoctorList.addAll(doctorList); 
		if(doctorList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateDoctorList.addAll(doctorList.getToRemoveList());
			doctorList.removeAll(doctorList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getDoctorDAO().saveDoctorList(mergedUpdateDoctorList,options);
		
		if(doctorList.getToRemoveList() != null){
			doctorList.removeAll(doctorList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeDoctorList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Doctor> doctorList = platform.getDoctorList();
		if(doctorList == null){
			return platform;
		}	
	
		SmartList<Doctor> toRemoveDoctorList = doctorList.getToRemoveList();
		
		if(toRemoveDoctorList == null){
			return platform;
		}
		if(toRemoveDoctorList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getDoctorDAO().removeDoctorList(toRemoveDoctorList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveProfileList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Profile> profileList = platform.getProfileList();
		if(profileList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Profile> mergedUpdateProfileList = new SmartList<Profile>();
		
		
		mergedUpdateProfileList.addAll(profileList); 
		if(profileList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateProfileList.addAll(profileList.getToRemoveList());
			profileList.removeAll(profileList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getProfileDAO().saveProfileList(mergedUpdateProfileList,options);
		
		if(profileList.getToRemoveList() != null){
			profileList.removeAll(profileList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeProfileList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Profile> profileList = platform.getProfileList();
		if(profileList == null){
			return platform;
		}	
	
		SmartList<Profile> toRemoveProfileList = profileList.getToRemoveList();
		
		if(toRemoveProfileList == null){
			return platform;
		}
		if(toRemoveProfileList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProfileDAO().removeProfileList(toRemoveProfileList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveRegistrationList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Registration> registrationList = platform.getRegistrationList();
		if(registrationList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Registration> mergedUpdateRegistrationList = new SmartList<Registration>();
		
		
		mergedUpdateRegistrationList.addAll(registrationList); 
		if(registrationList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRegistrationList.addAll(registrationList.getToRemoveList());
			registrationList.removeAll(registrationList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getRegistrationDAO().saveRegistrationList(mergedUpdateRegistrationList,options);
		
		if(registrationList.getToRemoveList() != null){
			registrationList.removeAll(registrationList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeRegistrationList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Registration> registrationList = platform.getRegistrationList();
		if(registrationList == null){
			return platform;
		}	
	
		SmartList<Registration> toRemoveRegistrationList = registrationList.getToRemoveList();
		
		if(toRemoveRegistrationList == null){
			return platform;
		}
		if(toRemoveRegistrationList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRegistrationDAO().removeRegistrationList(toRemoveRegistrationList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		

	public Platform present(Platform platform,Map<String, Object> options){
	
		presentDoctorList(platform,options);
		presentProfileList(platform,options);
		presentRegistrationList(platform,options);

		return platform;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentDoctorList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Doctor> doctorList = platform.getDoctorList();		
				SmartList<Doctor> newList= presentSubList(platform.getId(),
				doctorList,
				options,
				getDoctorDAO()::countDoctorByPlatform,
				getDoctorDAO()::findDoctorByPlatform
				);

		
		platform.setDoctorList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentProfileList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Profile> profileList = platform.getProfileList();		
				SmartList<Profile> newList= presentSubList(platform.getId(),
				profileList,
				options,
				getProfileDAO()::countProfileByPlatform,
				getProfileDAO()::findProfileByPlatform
				);

		
		platform.setProfileList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentRegistrationList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Registration> registrationList = platform.getRegistrationList();		
				SmartList<Registration> newList= presentSubList(platform.getId(),
				registrationList,
				options,
				getRegistrationDAO()::countRegistrationByPlatform,
				getRegistrationDAO()::findRegistrationByPlatform
				);

		
		platform.setRegistrationList(newList);
		

		return platform;
	}			
		

	
    public SmartList<Platform> requestCandidatePlatformForDoctor(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForProfile(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForRegistration(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		

	protected String getTableName(){
		return PlatformTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Platform> platformList) {		
		this.enhanceListInternal(platformList, this.getPlatformMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Platform> platformList = ownerEntity.collectRefsWithType(Platform.INTERNAL_TYPE);
		this.enhanceList(platformList);
		
	}
	
	@Override
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getPlatformMapper());

	}
	@Override
	public int countPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Platform> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPlatformMapper());
	}
}


