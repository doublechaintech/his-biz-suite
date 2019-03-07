
package com.doublechaintech.his.doctor;

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

import com.doublechaintech.his.platform.PlatformDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class DoctorJDBCTemplateDAO extends HisNamingServiceDAO implements DoctorDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		

	
	/*
	protected Doctor load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalDoctor(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Doctor load(String id,Map<String,Object> options) throws Exception{
		return loadInternalDoctor(DoctorTable.withId(id), options);
	}
	
	
	
	public Doctor save(Doctor doctor,Map<String,Object> options){
		
		String methodName="save(Doctor doctor,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(doctor, methodName, "doctor");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalDoctor(doctor,options);
	}
	public Doctor clone(String doctorId, Map<String,Object> options) throws Exception{
	
		return clone(DoctorTable.withId(doctorId),options);
	}
	
	protected Doctor clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String doctorId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Doctor newDoctor = loadInternalDoctor(accessKey, options);
		newDoctor.setVersion(0);
		
		

		
		saveInternalDoctor(newDoctor,options);
		
		return newDoctor;
	}
	
	
	
	

	protected void throwIfHasException(String doctorId,int version,int count) throws Exception{
		if (count == 1) {
			throw new DoctorVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new DoctorNotFoundException(
					"The " + this.getTableName() + "(" + doctorId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String doctorId, int version) throws Exception{
	
		String methodName="delete(String doctorId, int version)";
		assertMethodArgumentNotNull(doctorId, methodName, "doctorId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{doctorId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(doctorId,version);
		}
		
	
	}
	
	
	
	
	

	public Doctor disconnectFromAll(String doctorId, int version) throws Exception{
	
		
		Doctor doctor = loadInternalDoctor(DoctorTable.withId(doctorId), emptyOptions());
		doctor.clearFromAll();
		this.saveDoctor(doctor);
		return doctor;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return DoctorTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "doctor";
	}
	@Override
	protected String getBeanName() {
		
		return "doctor";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return DoctorTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, DoctorTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, DoctorTokens.PLATFORM);
 	}
 	

 	
 
		

	

	protected DoctorMapper getDoctorMapper(){
		return new DoctorMapper();
	}

	
	
	protected Doctor extractDoctor(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Doctor doctor = loadSingleObject(accessKey, getDoctorMapper());
			return doctor;
		}catch(EmptyResultDataAccessException e){
			throw new DoctorNotFoundException("Doctor("+accessKey+") is not found!");
		}

	}

	
	

	protected Doctor loadInternalDoctor(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Doctor doctor = extractDoctor(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(doctor, loadOptions);
 		}
 
		
		return doctor;
		
	}

	 

 	protected Doctor extractPlatform(Doctor doctor, Map<String,Object> options) throws Exception{

		if(doctor.getPlatform() == null){
			return doctor;
		}
		String platformId = doctor.getPlatform().getId();
		if( platformId == null){
			return doctor;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			doctor.setPlatform(platform);
		}
		
 		
 		return doctor;
 	}
 		
 
		
		
  	
 	public SmartList<Doctor> findDoctorByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<Doctor> resultList = queryWith(DoctorTable.COLUMN_PLATFORM, platformId, options, getDoctorMapper());
		// analyzeDoctorByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Doctor> findDoctorByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Doctor> resultList =  queryWithRange(DoctorTable.COLUMN_PLATFORM, platformId, options, getDoctorMapper(), start, count);
 		//analyzeDoctorByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeDoctorByPlatform(SmartList<Doctor> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countDoctorByPlatform(String platformId,Map<String,Object> options){

 		return countWith(DoctorTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countDoctorByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(DoctorTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected Doctor saveDoctor(Doctor  doctor){
		
		if(!doctor.isChanged()){
			return doctor;
		}
		
		
		String SQL=this.getSaveDoctorSQL(doctor);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveDoctorParameters(doctor);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		doctor.incVersion();
		return doctor;
	
	}
	public SmartList<Doctor> saveDoctorList(SmartList<Doctor> doctorList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitDoctorList(doctorList);
		
		batchDoctorCreate((List<Doctor>)lists[CREATE_LIST_INDEX]);
		
		batchDoctorUpdate((List<Doctor>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Doctor doctor:doctorList){
			if(doctor.isChanged()){
				doctor.incVersion();
			}
			
		
		}
		
		
		return doctorList;
	}

	public SmartList<Doctor> removeDoctorList(SmartList<Doctor> doctorList,Map<String,Object> options){
		
		
		super.removeList(doctorList, options);
		
		return doctorList;
		
		
	}
	
	protected List<Object[]> prepareDoctorBatchCreateArgs(List<Doctor> doctorList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Doctor doctor:doctorList ){
			Object [] parameters = prepareDoctorCreateParameters(doctor);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareDoctorBatchUpdateArgs(List<Doctor> doctorList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Doctor doctor:doctorList ){
			if(!doctor.isChanged()){
				continue;
			}
			Object [] parameters = prepareDoctorUpdateParameters(doctor);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchDoctorCreate(List<Doctor> doctorList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareDoctorBatchCreateArgs(doctorList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchDoctorUpdate(List<Doctor> doctorList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareDoctorBatchUpdateArgs(doctorList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitDoctorList(List<Doctor> doctorList){
		
		List<Doctor> doctorCreateList=new ArrayList<Doctor>();
		List<Doctor> doctorUpdateList=new ArrayList<Doctor>();
		
		for(Doctor doctor: doctorList){
			if(isUpdateRequest(doctor)){
				doctorUpdateList.add( doctor);
				continue;
			}
			doctorCreateList.add(doctor);
		}
		
		return new Object[]{doctorCreateList,doctorUpdateList};
	}
	
	protected boolean isUpdateRequest(Doctor doctor){
 		return doctor.getVersion() > 0;
 	}
 	protected String getSaveDoctorSQL(Doctor doctor){
 		if(isUpdateRequest(doctor)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveDoctorParameters(Doctor doctor){
 		if(isUpdateRequest(doctor) ){
 			return prepareDoctorUpdateParameters(doctor);
 		}
 		return prepareDoctorCreateParameters(doctor);
 	}
 	protected Object[] prepareDoctorUpdateParameters(Doctor doctor){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = doctor.getName(); 	
 		if(doctor.getPlatform() != null){
 			parameters[1] = doctor.getPlatform().getId();
 		}
 		
 		parameters[2] = doctor.nextVersion();
 		parameters[3] = doctor.getId();
 		parameters[4] = doctor.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareDoctorCreateParameters(Doctor doctor){
		Object[] parameters = new Object[3];
		String newDoctorId=getNextId();
		doctor.setId(newDoctorId);
		parameters[0] =  doctor.getId();
 
 		parameters[1] = doctor.getName(); 	
 		if(doctor.getPlatform() != null){
 			parameters[2] = doctor.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Doctor saveInternalDoctor(Doctor doctor, Map<String,Object> options){
		
		saveDoctor(doctor);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(doctor, options);
 		}
 
		
		return doctor;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Doctor savePlatform(Doctor doctor, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(doctor.getPlatform() == null){
 			return doctor;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(doctor.getPlatform(),options);
 		return doctor;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public Doctor present(Doctor doctor,Map<String, Object> options){
	

		return doctor;
	
	}
		

	

	protected String getTableName(){
		return DoctorTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Doctor> doctorList) {		
		this.enhanceListInternal(doctorList, this.getDoctorMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Doctor> doctorList = ownerEntity.collectRefsWithType(Doctor.INTERNAL_TYPE);
		this.enhanceList(doctorList);
		
	}
	
	@Override
	public SmartList<Doctor> findDoctorWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getDoctorMapper());

	}
	@Override
	public int countDoctorWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countDoctorWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Doctor> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getDoctorMapper());
	}
}


