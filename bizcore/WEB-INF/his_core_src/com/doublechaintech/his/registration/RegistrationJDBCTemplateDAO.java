
package com.doublechaintech.his.registration;

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
import com.doublechaintech.his.platform.Platform;

import com.doublechaintech.his.platform.PlatformDAO;
import com.doublechaintech.his.profile.ProfileDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class RegistrationJDBCTemplateDAO extends HisNamingServiceDAO implements RegistrationDAO{
 
 	
 	private  ProfileDAO  profileDAO;
 	public void setProfileDAO(ProfileDAO profileDAO){
	 	this.profileDAO = profileDAO;
 	}
 	public ProfileDAO getProfileDAO(){
	 	return this.profileDAO;
 	}
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		

	
	/*
	protected Registration load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRegistration(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Registration load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRegistration(RegistrationTable.withId(id), options);
	}
	
	
	
	public Registration save(Registration registration,Map<String,Object> options){
		
		String methodName="save(Registration registration,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(registration, methodName, "registration");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRegistration(registration,options);
	}
	public Registration clone(String registrationId, Map<String,Object> options) throws Exception{
	
		return clone(RegistrationTable.withId(registrationId),options);
	}
	
	protected Registration clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String registrationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Registration newRegistration = loadInternalRegistration(accessKey, options);
		newRegistration.setVersion(0);
		
		

		
		saveInternalRegistration(newRegistration,options);
		
		return newRegistration;
	}
	
	
	
	

	protected void throwIfHasException(String registrationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RegistrationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RegistrationNotFoundException(
					"The " + this.getTableName() + "(" + registrationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String registrationId, int version) throws Exception{
	
		String methodName="delete(String registrationId, int version)";
		assertMethodArgumentNotNull(registrationId, methodName, "registrationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{registrationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(registrationId,version);
		}
		
	
	}
	
	
	
	
	

	public Registration disconnectFromAll(String registrationId, int version) throws Exception{
	
		
		Registration registration = loadInternalRegistration(RegistrationTable.withId(registrationId), emptyOptions());
		registration.clearFromAll();
		this.saveRegistration(registration);
		return registration;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RegistrationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "registration";
	}
	@Override
	protected String getBeanName() {
		
		return "registration";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RegistrationTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPatientEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RegistrationTokens.PATIENT);
 	}

 	protected boolean isSavePatientEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RegistrationTokens.PATIENT);
 	}
 	

 	
  

 	protected boolean isExtractRegisterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RegistrationTokens.REGISTER);
 	}

 	protected boolean isSaveRegisterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RegistrationTokens.REGISTER);
 	}
 	

 	
  

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RegistrationTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RegistrationTokens.PLATFORM);
 	}
 	

 	
 
		

	

	protected RegistrationMapper getRegistrationMapper(){
		return new RegistrationMapper();
	}

	
	
	protected Registration extractRegistration(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Registration registration = loadSingleObject(accessKey, getRegistrationMapper());
			return registration;
		}catch(EmptyResultDataAccessException e){
			throw new RegistrationNotFoundException("Registration("+accessKey+") is not found!");
		}

	}

	
	

	protected Registration loadInternalRegistration(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Registration registration = extractRegistration(accessKey, loadOptions);
 	
 		if(isExtractPatientEnabled(loadOptions)){
	 		extractPatient(registration, loadOptions);
 		}
  	
 		if(isExtractRegisterEnabled(loadOptions)){
	 		extractRegister(registration, loadOptions);
 		}
  	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(registration, loadOptions);
 		}
 
		
		return registration;
		
	}

	 

 	protected Registration extractPatient(Registration registration, Map<String,Object> options) throws Exception{

		if(registration.getPatient() == null){
			return registration;
		}
		String patientId = registration.getPatient().getId();
		if( patientId == null){
			return registration;
		}
		Profile patient = getProfileDAO().load(patientId,options);
		if(patient != null){
			registration.setPatient(patient);
		}
		
 		
 		return registration;
 	}
 		
  

 	protected Registration extractRegister(Registration registration, Map<String,Object> options) throws Exception{

		if(registration.getRegister() == null){
			return registration;
		}
		String registerId = registration.getRegister().getId();
		if( registerId == null){
			return registration;
		}
		Profile register = getProfileDAO().load(registerId,options);
		if(register != null){
			registration.setRegister(register);
		}
		
 		
 		return registration;
 	}
 		
  

 	protected Registration extractPlatform(Registration registration, Map<String,Object> options) throws Exception{

		if(registration.getPlatform() == null){
			return registration;
		}
		String platformId = registration.getPlatform().getId();
		if( platformId == null){
			return registration;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			registration.setPlatform(platform);
		}
		
 		
 		return registration;
 	}
 		
 
		
		
  	
 	public SmartList<Registration> findRegistrationByPatient(String profileId,Map<String,Object> options){
 	
  		SmartList<Registration> resultList = queryWith(RegistrationTable.COLUMN_PATIENT, profileId, options, getRegistrationMapper());
		// analyzeRegistrationByPatient(resultList, profileId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Registration> findRegistrationByPatient(String profileId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Registration> resultList =  queryWithRange(RegistrationTable.COLUMN_PATIENT, profileId, options, getRegistrationMapper(), start, count);
 		//analyzeRegistrationByPatient(resultList, profileId, options);
 		return resultList;
 		
 	}
 	public void analyzeRegistrationByPatient(SmartList<Registration> resultList, String profileId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Registration.PATIENT_PROPERTY, profileId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem updateTimeStatsItem = new StatsItem();
		//Registration.UPDATE_TIME_PROPERTY
		updateTimeStatsItem.setDisplayName("Registration");
		updateTimeStatsItem.setInternalName(formatKeyForDateLine(Registration.UPDATE_TIME_PROPERTY));
		updateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Registration.UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(updateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRegistrationByPatient(String profileId,Map<String,Object> options){

 		return countWith(RegistrationTable.COLUMN_PATIENT, profileId, options);
 	}
 	@Override
	public Map<String, Integer> countRegistrationByPatientIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RegistrationTable.COLUMN_PATIENT, ids, options);
	}
 	
  	
 	public SmartList<Registration> findRegistrationByRegister(String profileId,Map<String,Object> options){
 	
  		SmartList<Registration> resultList = queryWith(RegistrationTable.COLUMN_REGISTER, profileId, options, getRegistrationMapper());
		// analyzeRegistrationByRegister(resultList, profileId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Registration> findRegistrationByRegister(String profileId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Registration> resultList =  queryWithRange(RegistrationTable.COLUMN_REGISTER, profileId, options, getRegistrationMapper(), start, count);
 		//analyzeRegistrationByRegister(resultList, profileId, options);
 		return resultList;
 		
 	}
 	public void analyzeRegistrationByRegister(SmartList<Registration> resultList, String profileId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Registration.REGISTER_PROPERTY, profileId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem updateTimeStatsItem = new StatsItem();
		//Registration.UPDATE_TIME_PROPERTY
		updateTimeStatsItem.setDisplayName("Registration");
		updateTimeStatsItem.setInternalName(formatKeyForDateLine(Registration.UPDATE_TIME_PROPERTY));
		updateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Registration.UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(updateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRegistrationByRegister(String profileId,Map<String,Object> options){

 		return countWith(RegistrationTable.COLUMN_REGISTER, profileId, options);
 	}
 	@Override
	public Map<String, Integer> countRegistrationByRegisterIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RegistrationTable.COLUMN_REGISTER, ids, options);
	}
 	
  	
 	public SmartList<Registration> findRegistrationByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<Registration> resultList = queryWith(RegistrationTable.COLUMN_PLATFORM, platformId, options, getRegistrationMapper());
		// analyzeRegistrationByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Registration> findRegistrationByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Registration> resultList =  queryWithRange(RegistrationTable.COLUMN_PLATFORM, platformId, options, getRegistrationMapper(), start, count);
 		//analyzeRegistrationByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeRegistrationByPlatform(SmartList<Registration> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Registration.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem updateTimeStatsItem = new StatsItem();
		//Registration.UPDATE_TIME_PROPERTY
		updateTimeStatsItem.setDisplayName("Registration");
		updateTimeStatsItem.setInternalName(formatKeyForDateLine(Registration.UPDATE_TIME_PROPERTY));
		updateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Registration.UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(updateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRegistrationByPlatform(String platformId,Map<String,Object> options){

 		return countWith(RegistrationTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countRegistrationByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RegistrationTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected Registration saveRegistration(Registration  registration){
		
		if(!registration.isChanged()){
			return registration;
		}
		
		
		String SQL=this.getSaveRegistrationSQL(registration);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRegistrationParameters(registration);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		registration.incVersion();
		return registration;
	
	}
	public SmartList<Registration> saveRegistrationList(SmartList<Registration> registrationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRegistrationList(registrationList);
		
		batchRegistrationCreate((List<Registration>)lists[CREATE_LIST_INDEX]);
		
		batchRegistrationUpdate((List<Registration>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Registration registration:registrationList){
			if(registration.isChanged()){
				registration.incVersion();
			}
			
		
		}
		
		
		return registrationList;
	}

	public SmartList<Registration> removeRegistrationList(SmartList<Registration> registrationList,Map<String,Object> options){
		
		
		super.removeList(registrationList, options);
		
		return registrationList;
		
		
	}
	
	protected List<Object[]> prepareRegistrationBatchCreateArgs(List<Registration> registrationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Registration registration:registrationList ){
			Object [] parameters = prepareRegistrationCreateParameters(registration);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRegistrationBatchUpdateArgs(List<Registration> registrationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Registration registration:registrationList ){
			if(!registration.isChanged()){
				continue;
			}
			Object [] parameters = prepareRegistrationUpdateParameters(registration);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRegistrationCreate(List<Registration> registrationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRegistrationBatchCreateArgs(registrationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRegistrationUpdate(List<Registration> registrationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRegistrationBatchUpdateArgs(registrationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRegistrationList(List<Registration> registrationList){
		
		List<Registration> registrationCreateList=new ArrayList<Registration>();
		List<Registration> registrationUpdateList=new ArrayList<Registration>();
		
		for(Registration registration: registrationList){
			if(isUpdateRequest(registration)){
				registrationUpdateList.add( registration);
				continue;
			}
			registrationCreateList.add(registration);
		}
		
		return new Object[]{registrationCreateList,registrationUpdateList};
	}
	
	protected boolean isUpdateRequest(Registration registration){
 		return registration.getVersion() > 0;
 	}
 	protected String getSaveRegistrationSQL(Registration registration){
 		if(isUpdateRequest(registration)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRegistrationParameters(Registration registration){
 		if(isUpdateRequest(registration) ){
 			return prepareRegistrationUpdateParameters(registration);
 		}
 		return prepareRegistrationCreateParameters(registration);
 	}
 	protected Object[] prepareRegistrationUpdateParameters(Registration registration){
 		Object[] parameters = new Object[10];
 
 		parameters[0] = registration.getTitle(); 	
 		if(registration.getPatient() != null){
 			parameters[1] = registration.getPatient().getId();
 		}
  	
 		if(registration.getRegister() != null){
 			parameters[2] = registration.getRegister().getId();
 		}
 
 		parameters[3] = registration.getContent();
 		parameters[4] = registration.getUpdateTime();
 		parameters[5] = registration.getStatus(); 	
 		if(registration.getPlatform() != null){
 			parameters[6] = registration.getPlatform().getId();
 		}
 		
 		parameters[7] = registration.nextVersion();
 		parameters[8] = registration.getId();
 		parameters[9] = registration.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRegistrationCreateParameters(Registration registration){
		Object[] parameters = new Object[8];
		String newRegistrationId=getNextId();
		registration.setId(newRegistrationId);
		parameters[0] =  registration.getId();
 
 		parameters[1] = registration.getTitle(); 	
 		if(registration.getPatient() != null){
 			parameters[2] = registration.getPatient().getId();
 		
 		}
 		 	
 		if(registration.getRegister() != null){
 			parameters[3] = registration.getRegister().getId();
 		
 		}
 		
 		parameters[4] = registration.getContent();
 		parameters[5] = registration.getUpdateTime();
 		parameters[6] = registration.getStatus(); 	
 		if(registration.getPlatform() != null){
 			parameters[7] = registration.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Registration saveInternalRegistration(Registration registration, Map<String,Object> options){
		
		saveRegistration(registration);
 	
 		if(isSavePatientEnabled(options)){
	 		savePatient(registration, options);
 		}
  	
 		if(isSaveRegisterEnabled(options)){
	 		saveRegister(registration, options);
 		}
  	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(registration, options);
 		}
 
		
		return registration;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Registration savePatient(Registration registration, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(registration.getPatient() == null){
 			return registration;//do nothing when it is null
 		}
 		
 		getProfileDAO().save(registration.getPatient(),options);
 		return registration;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Registration saveRegister(Registration registration, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(registration.getRegister() == null){
 			return registration;//do nothing when it is null
 		}
 		
 		getProfileDAO().save(registration.getRegister(),options);
 		return registration;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Registration savePlatform(Registration registration, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(registration.getPlatform() == null){
 			return registration;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(registration.getPlatform(),options);
 		return registration;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public Registration present(Registration registration,Map<String, Object> options){
	

		return registration;
	
	}
		

	

	protected String getTableName(){
		return RegistrationTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Registration> registrationList) {		
		this.enhanceListInternal(registrationList, this.getRegistrationMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Registration> registrationList = ownerEntity.collectRefsWithType(Registration.INTERNAL_TYPE);
		this.enhanceList(registrationList);
		
	}
	
	@Override
	public SmartList<Registration> findRegistrationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRegistrationMapper());

	}
	@Override
	public int countRegistrationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRegistrationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Registration> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRegistrationMapper());
	}
}


