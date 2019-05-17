
package com.doublechaintech.his.doctor;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
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


import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.doctorschedule.DoctorSchedule;
import com.doublechaintech.his.doctorassignment.DoctorAssignment;

import com.doublechaintech.his.doctorassignment.DoctorAssignmentDAO;
import com.doublechaintech.his.doctorschedule.DoctorScheduleDAO;
import com.doublechaintech.his.hospital.HospitalDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class DoctorJDBCTemplateDAO extends HisNamingServiceDAO implements DoctorDAO{
 
 	
 	private  HospitalDAO  hospitalDAO;
 	public void setHospitalDAO(HospitalDAO hospitalDAO){
	 	this.hospitalDAO = hospitalDAO;
 	}
 	public HospitalDAO getHospitalDAO(){
	 	return this.hospitalDAO;
 	}


			
		
	
  	private  DoctorAssignmentDAO  doctorAssignmentDAO;
 	public void setDoctorAssignmentDAO(DoctorAssignmentDAO pDoctorAssignmentDAO){
 	
 		if(pDoctorAssignmentDAO == null){
 			throw new IllegalStateException("Do not try to set doctorAssignmentDAO to null.");
 		}
	 	this.doctorAssignmentDAO = pDoctorAssignmentDAO;
 	}
 	public DoctorAssignmentDAO getDoctorAssignmentDAO(){
 		if(this.doctorAssignmentDAO == null){
 			throw new IllegalStateException("The doctorAssignmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.doctorAssignmentDAO;
 	}	
 	
			
		
	
  	private  DoctorScheduleDAO  doctorScheduleDAO;
 	public void setDoctorScheduleDAO(DoctorScheduleDAO pDoctorScheduleDAO){
 	
 		if(pDoctorScheduleDAO == null){
 			throw new IllegalStateException("Do not try to set doctorScheduleDAO to null.");
 		}
	 	this.doctorScheduleDAO = pDoctorScheduleDAO;
 	}
 	public DoctorScheduleDAO getDoctorScheduleDAO(){
 		if(this.doctorScheduleDAO == null){
 			throw new IllegalStateException("The doctorScheduleDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.doctorScheduleDAO;
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
		
		
 		
 		if(isSaveDoctorAssignmentListEnabled(options)){
 			for(DoctorAssignment item: newDoctor.getDoctorAssignmentList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveDoctorScheduleListEnabled(options)){
 			for(DoctorSchedule item: newDoctor.getDoctorScheduleList()){
 				item.setVersion(0);
 			}
 		}
		

		
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

 

 	protected boolean isExtractHospitalEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, DoctorTokens.HOSPITAL);
 	}

 	protected boolean isSaveHospitalEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, DoctorTokens.HOSPITAL);
 	}
 	

 	
 
		
	
	protected boolean isExtractDoctorAssignmentListEnabled(Map<String,Object> options){		
 		return checkOptions(options,DoctorTokens.DOCTOR_ASSIGNMENT_LIST);
 	}
 	protected boolean isAnalyzeDoctorAssignmentListEnabled(Map<String,Object> options){		 		
 		return DoctorTokens.of(options).analyzeDoctorAssignmentListEnabled();
 	}
	
	protected boolean isSaveDoctorAssignmentListEnabled(Map<String,Object> options){
		return checkOptions(options, DoctorTokens.DOCTOR_ASSIGNMENT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractDoctorScheduleListEnabled(Map<String,Object> options){		
 		return checkOptions(options,DoctorTokens.DOCTOR_SCHEDULE_LIST);
 	}
 	protected boolean isAnalyzeDoctorScheduleListEnabled(Map<String,Object> options){		 		
 		return DoctorTokens.of(options).analyzeDoctorScheduleListEnabled();
 	}
	
	protected boolean isSaveDoctorScheduleListEnabled(Map<String,Object> options){
		return checkOptions(options, DoctorTokens.DOCTOR_SCHEDULE_LIST);
		
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
 	
 		if(isExtractHospitalEnabled(loadOptions)){
	 		extractHospital(doctor, loadOptions);
 		}
 
		
		if(isExtractDoctorAssignmentListEnabled(loadOptions)){
	 		extractDoctorAssignmentList(doctor, loadOptions);
 		}	
 		if(isAnalyzeDoctorAssignmentListEnabled(loadOptions)){
	 		analyzeDoctorAssignmentList(doctor, loadOptions);
 		}
 		
		
		if(isExtractDoctorScheduleListEnabled(loadOptions)){
	 		extractDoctorScheduleList(doctor, loadOptions);
 		}	
 		if(isAnalyzeDoctorScheduleListEnabled(loadOptions)){
	 		analyzeDoctorScheduleList(doctor, loadOptions);
 		}
 		
		
		return doctor;
		
	}

	 

 	protected Doctor extractHospital(Doctor doctor, Map<String,Object> options) throws Exception{

		if(doctor.getHospital() == null){
			return doctor;
		}
		String hospitalId = doctor.getHospital().getId();
		if( hospitalId == null){
			return doctor;
		}
		Hospital hospital = getHospitalDAO().load(hospitalId,options);
		if(hospital != null){
			doctor.setHospital(hospital);
		}
		
 		
 		return doctor;
 	}
 		
 
		
	protected void enhanceDoctorAssignmentList(SmartList<DoctorAssignment> doctorAssignmentList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Doctor extractDoctorAssignmentList(Doctor doctor, Map<String,Object> options){
		
		
		if(doctor == null){
			return null;
		}
		if(doctor.getId() == null){
			return doctor;
		}

		
		
		SmartList<DoctorAssignment> doctorAssignmentList = getDoctorAssignmentDAO().findDoctorAssignmentByDoctor(doctor.getId(),options);
		if(doctorAssignmentList != null){
			enhanceDoctorAssignmentList(doctorAssignmentList,options);
			doctor.setDoctorAssignmentList(doctorAssignmentList);
		}
		
		return doctor;
	
	}	
	
	protected Doctor analyzeDoctorAssignmentList(Doctor doctor, Map<String,Object> options){
		
		
		if(doctor == null){
			return null;
		}
		if(doctor.getId() == null){
			return doctor;
		}

		
		
		SmartList<DoctorAssignment> doctorAssignmentList = doctor.getDoctorAssignmentList();
		if(doctorAssignmentList != null){
			getDoctorAssignmentDAO().analyzeDoctorAssignmentByDoctor(doctorAssignmentList, doctor.getId(), options);
			
		}
		
		return doctor;
	
	}	
	
		
	protected void enhanceDoctorScheduleList(SmartList<DoctorSchedule> doctorScheduleList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Doctor extractDoctorScheduleList(Doctor doctor, Map<String,Object> options){
		
		
		if(doctor == null){
			return null;
		}
		if(doctor.getId() == null){
			return doctor;
		}

		
		
		SmartList<DoctorSchedule> doctorScheduleList = getDoctorScheduleDAO().findDoctorScheduleByDoctor(doctor.getId(),options);
		if(doctorScheduleList != null){
			enhanceDoctorScheduleList(doctorScheduleList,options);
			doctor.setDoctorScheduleList(doctorScheduleList);
		}
		
		return doctor;
	
	}	
	
	protected Doctor analyzeDoctorScheduleList(Doctor doctor, Map<String,Object> options){
		
		
		if(doctor == null){
			return null;
		}
		if(doctor.getId() == null){
			return doctor;
		}

		
		
		SmartList<DoctorSchedule> doctorScheduleList = doctor.getDoctorScheduleList();
		if(doctorScheduleList != null){
			getDoctorScheduleDAO().analyzeDoctorScheduleByDoctor(doctorScheduleList, doctor.getId(), options);
			
		}
		
		return doctor;
	
	}	
	
		
		
  	
 	public SmartList<Doctor> findDoctorByHospital(String hospitalId,Map<String,Object> options){
 	
  		SmartList<Doctor> resultList = queryWith(DoctorTable.COLUMN_HOSPITAL, hospitalId, options, getDoctorMapper());
		// analyzeDoctorByHospital(resultList, hospitalId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Doctor> findDoctorByHospital(String hospitalId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Doctor> resultList =  queryWithRange(DoctorTable.COLUMN_HOSPITAL, hospitalId, options, getDoctorMapper(), start, count);
 		//analyzeDoctorByHospital(resultList, hospitalId, options);
 		return resultList;
 		
 	}
 	public void analyzeDoctorByHospital(SmartList<Doctor> resultList, String hospitalId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Doctor.HOSPITAL_PROPERTY, hospitalId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem updateTimeStatsItem = new StatsItem();
		//Doctor.UPDATE_TIME_PROPERTY
		updateTimeStatsItem.setDisplayName("医生");
		updateTimeStatsItem.setInternalName(formatKeyForDateLine(Doctor.UPDATE_TIME_PROPERTY));
		updateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Doctor.UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(updateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countDoctorByHospital(String hospitalId,Map<String,Object> options){

 		return countWith(DoctorTable.COLUMN_HOSPITAL, hospitalId, options);
 	}
 	@Override
	public Map<String, Integer> countDoctorByHospitalIds(String[] ids, Map<String, Object> options) {
		return countWithIds(DoctorTable.COLUMN_HOSPITAL, ids, options);
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
 		Object[] parameters = new Object[7];
 
 		parameters[0] = doctor.getName();
 		parameters[1] = doctor.getShotImage(); 	
 		if(doctor.getHospital() != null){
 			parameters[2] = doctor.getHospital().getId();
 		}
 
 		parameters[3] = doctor.getUpdateTime();		
 		parameters[4] = doctor.nextVersion();
 		parameters[5] = doctor.getId();
 		parameters[6] = doctor.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareDoctorCreateParameters(Doctor doctor){
		Object[] parameters = new Object[5];
		String newDoctorId=getNextId();
		doctor.setId(newDoctorId);
		parameters[0] =  doctor.getId();
 
 		parameters[1] = doctor.getName();
 		parameters[2] = doctor.getShotImage(); 	
 		if(doctor.getHospital() != null){
 			parameters[3] = doctor.getHospital().getId();
 		
 		}
 		
 		parameters[4] = doctor.getUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected Doctor saveInternalDoctor(Doctor doctor, Map<String,Object> options){
		
		saveDoctor(doctor);
 	
 		if(isSaveHospitalEnabled(options)){
	 		saveHospital(doctor, options);
 		}
 
		
		if(isSaveDoctorAssignmentListEnabled(options)){
	 		saveDoctorAssignmentList(doctor, options);
	 		//removeDoctorAssignmentList(doctor, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveDoctorScheduleListEnabled(options)){
	 		saveDoctorScheduleList(doctor, options);
	 		//removeDoctorScheduleList(doctor, options);
	 		//Not delete the record
	 		
 		}		
		
		return doctor;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Doctor saveHospital(Doctor doctor, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(doctor.getHospital() == null){
 			return doctor;//do nothing when it is null
 		}
 		
 		getHospitalDAO().save(doctor.getHospital(),options);
 		return doctor;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Doctor planToRemoveDoctorAssignmentList(Doctor doctor, String doctorAssignmentIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorAssignment.DOCTOR_PROPERTY, doctor.getId());
		key.put(DoctorAssignment.ID_PROPERTY, doctorAssignmentIds);
		
		SmartList<DoctorAssignment> externalDoctorAssignmentList = getDoctorAssignmentDAO().
				findDoctorAssignmentWithKey(key, options);
		if(externalDoctorAssignmentList == null){
			return doctor;
		}
		if(externalDoctorAssignmentList.isEmpty()){
			return doctor;
		}
		
		for(DoctorAssignment doctorAssignment: externalDoctorAssignmentList){

			doctorAssignment.clearFromAll();
		}
		
		
		SmartList<DoctorAssignment> doctorAssignmentList = doctor.getDoctorAssignmentList();		
		doctorAssignmentList.addAllToRemoveList(externalDoctorAssignmentList);
		return doctor;	
	
	}


	//disconnect Doctor with department in DoctorAssignment
	public Doctor planToRemoveDoctorAssignmentListWithDepartment(Doctor doctor, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorAssignment.DOCTOR_PROPERTY, doctor.getId());
		key.put(DoctorAssignment.DEPARTMENT_PROPERTY, departmentId);
		
		SmartList<DoctorAssignment> externalDoctorAssignmentList = getDoctorAssignmentDAO().
				findDoctorAssignmentWithKey(key, options);
		if(externalDoctorAssignmentList == null){
			return doctor;
		}
		if(externalDoctorAssignmentList.isEmpty()){
			return doctor;
		}
		
		for(DoctorAssignment doctorAssignment: externalDoctorAssignmentList){
			doctorAssignment.clearDepartment();
			doctorAssignment.clearDoctor();
			
		}
		
		
		SmartList<DoctorAssignment> doctorAssignmentList = doctor.getDoctorAssignmentList();		
		doctorAssignmentList.addAllToRemoveList(externalDoctorAssignmentList);
		return doctor;
	}
	
	public int countDoctorAssignmentListWithDepartment(String doctorId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorAssignment.DOCTOR_PROPERTY, doctorId);
		key.put(DoctorAssignment.DEPARTMENT_PROPERTY, departmentId);
		
		int count = getDoctorAssignmentDAO().countDoctorAssignmentWithKey(key, options);
		return count;
	}
	
	public Doctor planToRemoveDoctorScheduleList(Doctor doctor, String doctorScheduleIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DOCTOR_PROPERTY, doctor.getId());
		key.put(DoctorSchedule.ID_PROPERTY, doctorScheduleIds);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return doctor;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return doctor;
		}
		
		for(DoctorSchedule doctorSchedule: externalDoctorScheduleList){

			doctorSchedule.clearFromAll();
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = doctor.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return doctor;	
	
	}


	//disconnect Doctor with period in DoctorSchedule
	public Doctor planToRemoveDoctorScheduleListWithPeriod(Doctor doctor, String periodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DOCTOR_PROPERTY, doctor.getId());
		key.put(DoctorSchedule.PERIOD_PROPERTY, periodId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return doctor;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return doctor;
		}
		
		for(DoctorSchedule doctorSchedule: externalDoctorScheduleList){
			doctorSchedule.clearPeriod();
			doctorSchedule.clearDoctor();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = doctor.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return doctor;
	}
	
	public int countDoctorScheduleListWithPeriod(String doctorId, String periodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DOCTOR_PROPERTY, doctorId);
		key.put(DoctorSchedule.PERIOD_PROPERTY, periodId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	
	//disconnect Doctor with department in DoctorSchedule
	public Doctor planToRemoveDoctorScheduleListWithDepartment(Doctor doctor, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DOCTOR_PROPERTY, doctor.getId());
		key.put(DoctorSchedule.DEPARTMENT_PROPERTY, departmentId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return doctor;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return doctor;
		}
		
		for(DoctorSchedule doctorSchedule: externalDoctorScheduleList){
			doctorSchedule.clearDepartment();
			doctorSchedule.clearDoctor();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = doctor.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return doctor;
	}
	
	public int countDoctorScheduleListWithDepartment(String doctorId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DOCTOR_PROPERTY, doctorId);
		key.put(DoctorSchedule.DEPARTMENT_PROPERTY, departmentId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	
	//disconnect Doctor with expense_type in DoctorSchedule
	public Doctor planToRemoveDoctorScheduleListWithExpenseType(Doctor doctor, String expenseTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DOCTOR_PROPERTY, doctor.getId());
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, expenseTypeId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return doctor;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return doctor;
		}
		
		for(DoctorSchedule doctorSchedule: externalDoctorScheduleList){
			doctorSchedule.clearExpenseType();
			doctorSchedule.clearDoctor();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = doctor.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return doctor;
	}
	
	public int countDoctorScheduleListWithExpenseType(String doctorId, String expenseTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DOCTOR_PROPERTY, doctorId);
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, expenseTypeId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	
	//disconnect Doctor with hospital in DoctorSchedule
	public Doctor planToRemoveDoctorScheduleListWithHospital(Doctor doctor, String hospitalId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DOCTOR_PROPERTY, doctor.getId());
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, hospitalId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return doctor;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return doctor;
		}
		
		for(DoctorSchedule doctorSchedule: externalDoctorScheduleList){
			doctorSchedule.clearHospital();
			doctorSchedule.clearDoctor();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = doctor.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return doctor;
	}
	
	public int countDoctorScheduleListWithHospital(String doctorId, String hospitalId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DOCTOR_PROPERTY, doctorId);
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, hospitalId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	

		
	protected Doctor saveDoctorAssignmentList(Doctor doctor, Map<String,Object> options){
		
		
		
		
		SmartList<DoctorAssignment> doctorAssignmentList = doctor.getDoctorAssignmentList();
		if(doctorAssignmentList == null){
			//null list means nothing
			return doctor;
		}
		SmartList<DoctorAssignment> mergedUpdateDoctorAssignmentList = new SmartList<DoctorAssignment>();
		
		
		mergedUpdateDoctorAssignmentList.addAll(doctorAssignmentList); 
		if(doctorAssignmentList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateDoctorAssignmentList.addAll(doctorAssignmentList.getToRemoveList());
			doctorAssignmentList.removeAll(doctorAssignmentList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getDoctorAssignmentDAO().saveDoctorAssignmentList(mergedUpdateDoctorAssignmentList,options);
		
		if(doctorAssignmentList.getToRemoveList() != null){
			doctorAssignmentList.removeAll(doctorAssignmentList.getToRemoveList());
		}
		
		
		return doctor;
	
	}
	
	protected Doctor removeDoctorAssignmentList(Doctor doctor, Map<String,Object> options){
	
	
		SmartList<DoctorAssignment> doctorAssignmentList = doctor.getDoctorAssignmentList();
		if(doctorAssignmentList == null){
			return doctor;
		}	
	
		SmartList<DoctorAssignment> toRemoveDoctorAssignmentList = doctorAssignmentList.getToRemoveList();
		
		if(toRemoveDoctorAssignmentList == null){
			return doctor;
		}
		if(toRemoveDoctorAssignmentList.isEmpty()){
			return doctor;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getDoctorAssignmentDAO().removeDoctorAssignmentList(toRemoveDoctorAssignmentList,options);
		
		return doctor;
	
	}
	
	

 	
 	
	
	
	
		
	protected Doctor saveDoctorScheduleList(Doctor doctor, Map<String,Object> options){
		
		
		
		
		SmartList<DoctorSchedule> doctorScheduleList = doctor.getDoctorScheduleList();
		if(doctorScheduleList == null){
			//null list means nothing
			return doctor;
		}
		SmartList<DoctorSchedule> mergedUpdateDoctorScheduleList = new SmartList<DoctorSchedule>();
		
		
		mergedUpdateDoctorScheduleList.addAll(doctorScheduleList); 
		if(doctorScheduleList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateDoctorScheduleList.addAll(doctorScheduleList.getToRemoveList());
			doctorScheduleList.removeAll(doctorScheduleList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getDoctorScheduleDAO().saveDoctorScheduleList(mergedUpdateDoctorScheduleList,options);
		
		if(doctorScheduleList.getToRemoveList() != null){
			doctorScheduleList.removeAll(doctorScheduleList.getToRemoveList());
		}
		
		
		return doctor;
	
	}
	
	protected Doctor removeDoctorScheduleList(Doctor doctor, Map<String,Object> options){
	
	
		SmartList<DoctorSchedule> doctorScheduleList = doctor.getDoctorScheduleList();
		if(doctorScheduleList == null){
			return doctor;
		}	
	
		SmartList<DoctorSchedule> toRemoveDoctorScheduleList = doctorScheduleList.getToRemoveList();
		
		if(toRemoveDoctorScheduleList == null){
			return doctor;
		}
		if(toRemoveDoctorScheduleList.isEmpty()){
			return doctor;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getDoctorScheduleDAO().removeDoctorScheduleList(toRemoveDoctorScheduleList,options);
		
		return doctor;
	
	}
	
	

 	
 	
	
	
	
		

	public Doctor present(Doctor doctor,Map<String, Object> options){
	
		presentDoctorAssignmentList(doctor,options);
		presentDoctorScheduleList(doctor,options);

		return doctor;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Doctor presentDoctorAssignmentList(
			Doctor doctor,
			Map<String, Object> options) {

		SmartList<DoctorAssignment> doctorAssignmentList = doctor.getDoctorAssignmentList();		
				SmartList<DoctorAssignment> newList= presentSubList(doctor.getId(),
				doctorAssignmentList,
				options,
				getDoctorAssignmentDAO()::countDoctorAssignmentByDoctor,
				getDoctorAssignmentDAO()::findDoctorAssignmentByDoctor
				);

		
		doctor.setDoctorAssignmentList(newList);
		

		return doctor;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Doctor presentDoctorScheduleList(
			Doctor doctor,
			Map<String, Object> options) {

		SmartList<DoctorSchedule> doctorScheduleList = doctor.getDoctorScheduleList();		
				SmartList<DoctorSchedule> newList= presentSubList(doctor.getId(),
				doctorScheduleList,
				options,
				getDoctorScheduleDAO()::countDoctorScheduleByDoctor,
				getDoctorScheduleDAO()::findDoctorScheduleByDoctor
				);

		
		doctor.setDoctorScheduleList(newList);
		

		return doctor;
	}			
		

	
    public SmartList<Doctor> requestCandidateDoctorForDoctorAssignment(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(DoctorTable.COLUMN_NAME, filterKey, pageNo, pageSize, getDoctorMapper());
    }
		
    public SmartList<Doctor> requestCandidateDoctorForDoctorSchedule(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(DoctorTable.COLUMN_NAME, filterKey, pageNo, pageSize, getDoctorMapper());
    }
		

	protected String getTableName(){
		return DoctorTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Doctor> doctorList) {		
		this.enhanceListInternal(doctorList, this.getDoctorMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:DoctorAssignment的doctor的DoctorAssignmentList
	public void loadOurDoctorAssignmentList(HisUserContext userContext, List<Doctor> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return;
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorAssignment.DOCTOR_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<DoctorAssignment> loadedObjs = userContext.getDAOGroup().getDoctorAssignmentDAO().findDoctorAssignmentWithKey(key, options);
		Map<String, List<DoctorAssignment>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getDoctor().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<DoctorAssignment> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<DoctorAssignment> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setDoctorAssignmentList(loadedSmartList);
		});
	}
	
	// 需要一个加载引用我的对象的enhance方法:DoctorSchedule的doctor的DoctorScheduleList
	public void loadOurDoctorScheduleList(HisUserContext userContext, List<Doctor> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return;
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DOCTOR_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<DoctorSchedule> loadedObjs = userContext.getDAOGroup().getDoctorScheduleDAO().findDoctorScheduleWithKey(key, options);
		Map<String, List<DoctorSchedule>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getDoctor().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<DoctorSchedule> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<DoctorSchedule> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setDoctorScheduleList(loadedSmartList);
		});
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


