
package com.doublechaintech.his.department;

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


import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.doctorschedule.DoctorSchedule;
import com.doublechaintech.his.doctorassignment.DoctorAssignment;

import com.doublechaintech.his.doctorassignment.DoctorAssignmentDAO;
import com.doublechaintech.his.doctorschedule.DoctorScheduleDAO;
import com.doublechaintech.his.hospital.HospitalDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class DepartmentJDBCTemplateDAO extends HisNamingServiceDAO implements DepartmentDAO{
 
 	
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
	protected Department load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalDepartment(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Department load(String id,Map<String,Object> options) throws Exception{
		return loadInternalDepartment(DepartmentTable.withId(id), options);
	}
	
	
	
	public Department save(Department department,Map<String,Object> options){
		
		String methodName="save(Department department,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(department, methodName, "department");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalDepartment(department,options);
	}
	public Department clone(String departmentId, Map<String,Object> options) throws Exception{
	
		return clone(DepartmentTable.withId(departmentId),options);
	}
	
	protected Department clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String departmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Department newDepartment = loadInternalDepartment(accessKey, options);
		newDepartment.setVersion(0);
		
		
 		
 		if(isSaveDoctorAssignmentListEnabled(options)){
 			for(DoctorAssignment item: newDepartment.getDoctorAssignmentList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveDoctorScheduleListEnabled(options)){
 			for(DoctorSchedule item: newDepartment.getDoctorScheduleList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalDepartment(newDepartment,options);
		
		return newDepartment;
	}
	
	
	
	

	protected void throwIfHasException(String departmentId,int version,int count) throws Exception{
		if (count == 1) {
			throw new DepartmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new DepartmentNotFoundException(
					"The " + this.getTableName() + "(" + departmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String departmentId, int version) throws Exception{
	
		String methodName="delete(String departmentId, int version)";
		assertMethodArgumentNotNull(departmentId, methodName, "departmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{departmentId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(departmentId,version);
		}
		
	
	}
	
	
	
	
	

	public Department disconnectFromAll(String departmentId, int version) throws Exception{
	
		
		Department department = loadInternalDepartment(DepartmentTable.withId(departmentId), emptyOptions());
		department.clearFromAll();
		this.saveDepartment(department);
		return department;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return DepartmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "department";
	}
	@Override
	protected String getBeanName() {
		
		return "department";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return DepartmentTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractHospitalEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, DepartmentTokens.HOSPITAL);
 	}

 	protected boolean isSaveHospitalEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, DepartmentTokens.HOSPITAL);
 	}
 	

 	
 
		
	
	protected boolean isExtractDoctorAssignmentListEnabled(Map<String,Object> options){		
 		return checkOptions(options,DepartmentTokens.DOCTOR_ASSIGNMENT_LIST);
 	}
 	protected boolean isAnalyzeDoctorAssignmentListEnabled(Map<String,Object> options){		 		
 		return DepartmentTokens.of(options).analyzeDoctorAssignmentListEnabled();
 	}
	
	protected boolean isSaveDoctorAssignmentListEnabled(Map<String,Object> options){
		return checkOptions(options, DepartmentTokens.DOCTOR_ASSIGNMENT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractDoctorScheduleListEnabled(Map<String,Object> options){		
 		return checkOptions(options,DepartmentTokens.DOCTOR_SCHEDULE_LIST);
 	}
 	protected boolean isAnalyzeDoctorScheduleListEnabled(Map<String,Object> options){		 		
 		return DepartmentTokens.of(options).analyzeDoctorScheduleListEnabled();
 	}
	
	protected boolean isSaveDoctorScheduleListEnabled(Map<String,Object> options){
		return checkOptions(options, DepartmentTokens.DOCTOR_SCHEDULE_LIST);
		
 	}
 	
		

	

	protected DepartmentMapper getDepartmentMapper(){
		return new DepartmentMapper();
	}

	
	
	protected Department extractDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Department department = loadSingleObject(accessKey, getDepartmentMapper());
			return department;
		}catch(EmptyResultDataAccessException e){
			throw new DepartmentNotFoundException("Department("+accessKey+") is not found!");
		}

	}

	
	

	protected Department loadInternalDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Department department = extractDepartment(accessKey, loadOptions);
 	
 		if(isExtractHospitalEnabled(loadOptions)){
	 		extractHospital(department, loadOptions);
 		}
 
		
		if(isExtractDoctorAssignmentListEnabled(loadOptions)){
	 		extractDoctorAssignmentList(department, loadOptions);
 		}	
 		if(isAnalyzeDoctorAssignmentListEnabled(loadOptions)){
	 		analyzeDoctorAssignmentList(department, loadOptions);
 		}
 		
		
		if(isExtractDoctorScheduleListEnabled(loadOptions)){
	 		extractDoctorScheduleList(department, loadOptions);
 		}	
 		if(isAnalyzeDoctorScheduleListEnabled(loadOptions)){
	 		analyzeDoctorScheduleList(department, loadOptions);
 		}
 		
		
		return department;
		
	}

	 

 	protected Department extractHospital(Department department, Map<String,Object> options) throws Exception{

		if(department.getHospital() == null){
			return department;
		}
		String hospitalId = department.getHospital().getId();
		if( hospitalId == null){
			return department;
		}
		Hospital hospital = getHospitalDAO().load(hospitalId,options);
		if(hospital != null){
			department.setHospital(hospital);
		}
		
 		
 		return department;
 	}
 		
 
		
	protected void enhanceDoctorAssignmentList(SmartList<DoctorAssignment> doctorAssignmentList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Department extractDoctorAssignmentList(Department department, Map<String,Object> options){
		
		
		if(department == null){
			return null;
		}
		if(department.getId() == null){
			return department;
		}

		
		
		SmartList<DoctorAssignment> doctorAssignmentList = getDoctorAssignmentDAO().findDoctorAssignmentByDepartment(department.getId(),options);
		if(doctorAssignmentList != null){
			enhanceDoctorAssignmentList(doctorAssignmentList,options);
			department.setDoctorAssignmentList(doctorAssignmentList);
		}
		
		return department;
	
	}	
	
	protected Department analyzeDoctorAssignmentList(Department department, Map<String,Object> options){
		
		
		if(department == null){
			return null;
		}
		if(department.getId() == null){
			return department;
		}

		
		
		SmartList<DoctorAssignment> doctorAssignmentList = department.getDoctorAssignmentList();
		if(doctorAssignmentList != null){
			getDoctorAssignmentDAO().analyzeDoctorAssignmentByDepartment(doctorAssignmentList, department.getId(), options);
			
		}
		
		return department;
	
	}	
	
		
	protected void enhanceDoctorScheduleList(SmartList<DoctorSchedule> doctorScheduleList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Department extractDoctorScheduleList(Department department, Map<String,Object> options){
		
		
		if(department == null){
			return null;
		}
		if(department.getId() == null){
			return department;
		}

		
		
		SmartList<DoctorSchedule> doctorScheduleList = getDoctorScheduleDAO().findDoctorScheduleByDepartment(department.getId(),options);
		if(doctorScheduleList != null){
			enhanceDoctorScheduleList(doctorScheduleList,options);
			department.setDoctorScheduleList(doctorScheduleList);
		}
		
		return department;
	
	}	
	
	protected Department analyzeDoctorScheduleList(Department department, Map<String,Object> options){
		
		
		if(department == null){
			return null;
		}
		if(department.getId() == null){
			return department;
		}

		
		
		SmartList<DoctorSchedule> doctorScheduleList = department.getDoctorScheduleList();
		if(doctorScheduleList != null){
			getDoctorScheduleDAO().analyzeDoctorScheduleByDepartment(doctorScheduleList, department.getId(), options);
			
		}
		
		return department;
	
	}	
	
		
		
  	
 	public SmartList<Department> findDepartmentByHospital(String hospitalId,Map<String,Object> options){
 	
  		SmartList<Department> resultList = queryWith(DepartmentTable.COLUMN_HOSPITAL, hospitalId, options, getDepartmentMapper());
		// analyzeDepartmentByHospital(resultList, hospitalId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Department> findDepartmentByHospital(String hospitalId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Department> resultList =  queryWithRange(DepartmentTable.COLUMN_HOSPITAL, hospitalId, options, getDepartmentMapper(), start, count);
 		//analyzeDepartmentByHospital(resultList, hospitalId, options);
 		return resultList;
 		
 	}
 	public void analyzeDepartmentByHospital(SmartList<Department> resultList, String hospitalId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Department.HOSPITAL_PROPERTY, hospitalId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem updateTimeStatsItem = new StatsItem();
		//Department.UPDATE_TIME_PROPERTY
		updateTimeStatsItem.setDisplayName("部门");
		updateTimeStatsItem.setInternalName(formatKeyForDateLine(Department.UPDATE_TIME_PROPERTY));
		updateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Department.UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(updateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countDepartmentByHospital(String hospitalId,Map<String,Object> options){

 		return countWith(DepartmentTable.COLUMN_HOSPITAL, hospitalId, options);
 	}
 	@Override
	public Map<String, Integer> countDepartmentByHospitalIds(String[] ids, Map<String, Object> options) {
		return countWithIds(DepartmentTable.COLUMN_HOSPITAL, ids, options);
	}
 	
 	
		
		
		

	

	protected Department saveDepartment(Department  department){
		
		if(!department.isChanged()){
			return department;
		}
		
		
		String SQL=this.getSaveDepartmentSQL(department);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveDepartmentParameters(department);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		department.incVersion();
		return department;
	
	}
	public SmartList<Department> saveDepartmentList(SmartList<Department> departmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitDepartmentList(departmentList);
		
		batchDepartmentCreate((List<Department>)lists[CREATE_LIST_INDEX]);
		
		batchDepartmentUpdate((List<Department>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Department department:departmentList){
			if(department.isChanged()){
				department.incVersion();
			}
			
		
		}
		
		
		return departmentList;
	}

	public SmartList<Department> removeDepartmentList(SmartList<Department> departmentList,Map<String,Object> options){
		
		
		super.removeList(departmentList, options);
		
		return departmentList;
		
		
	}
	
	protected List<Object[]> prepareDepartmentBatchCreateArgs(List<Department> departmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Department department:departmentList ){
			Object [] parameters = prepareDepartmentCreateParameters(department);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareDepartmentBatchUpdateArgs(List<Department> departmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Department department:departmentList ){
			if(!department.isChanged()){
				continue;
			}
			Object [] parameters = prepareDepartmentUpdateParameters(department);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchDepartmentCreate(List<Department> departmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareDepartmentBatchCreateArgs(departmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchDepartmentUpdate(List<Department> departmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareDepartmentBatchUpdateArgs(departmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitDepartmentList(List<Department> departmentList){
		
		List<Department> departmentCreateList=new ArrayList<Department>();
		List<Department> departmentUpdateList=new ArrayList<Department>();
		
		for(Department department: departmentList){
			if(isUpdateRequest(department)){
				departmentUpdateList.add( department);
				continue;
			}
			departmentCreateList.add(department);
		}
		
		return new Object[]{departmentCreateList,departmentUpdateList};
	}
	
	protected boolean isUpdateRequest(Department department){
 		return department.getVersion() > 0;
 	}
 	protected String getSaveDepartmentSQL(Department department){
 		if(isUpdateRequest(department)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveDepartmentParameters(Department department){
 		if(isUpdateRequest(department) ){
 			return prepareDepartmentUpdateParameters(department);
 		}
 		return prepareDepartmentCreateParameters(department);
 	}
 	protected Object[] prepareDepartmentUpdateParameters(Department department){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = department.getName(); 	
 		if(department.getHospital() != null){
 			parameters[1] = department.getHospital().getId();
 		}
 
 		parameters[2] = department.getUpdateTime();		
 		parameters[3] = department.nextVersion();
 		parameters[4] = department.getId();
 		parameters[5] = department.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareDepartmentCreateParameters(Department department){
		Object[] parameters = new Object[4];
		String newDepartmentId=getNextId();
		department.setId(newDepartmentId);
		parameters[0] =  department.getId();
 
 		parameters[1] = department.getName(); 	
 		if(department.getHospital() != null){
 			parameters[2] = department.getHospital().getId();
 		
 		}
 		
 		parameters[3] = department.getUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected Department saveInternalDepartment(Department department, Map<String,Object> options){
		
		saveDepartment(department);
 	
 		if(isSaveHospitalEnabled(options)){
	 		saveHospital(department, options);
 		}
 
		
		if(isSaveDoctorAssignmentListEnabled(options)){
	 		saveDoctorAssignmentList(department, options);
	 		//removeDoctorAssignmentList(department, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveDoctorScheduleListEnabled(options)){
	 		saveDoctorScheduleList(department, options);
	 		//removeDoctorScheduleList(department, options);
	 		//Not delete the record
	 		
 		}		
		
		return department;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Department saveHospital(Department department, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(department.getHospital() == null){
 			return department;//do nothing when it is null
 		}
 		
 		getHospitalDAO().save(department.getHospital(),options);
 		return department;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Department planToRemoveDoctorAssignmentList(Department department, String doctorAssignmentIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorAssignment.DEPARTMENT_PROPERTY, department.getId());
		key.put(DoctorAssignment.ID_PROPERTY, doctorAssignmentIds);
		
		SmartList<DoctorAssignment> externalDoctorAssignmentList = getDoctorAssignmentDAO().
				findDoctorAssignmentWithKey(key, options);
		if(externalDoctorAssignmentList == null){
			return department;
		}
		if(externalDoctorAssignmentList.isEmpty()){
			return department;
		}
		
		for(DoctorAssignment doctorAssignment: externalDoctorAssignmentList){

			doctorAssignment.clearFromAll();
		}
		
		
		SmartList<DoctorAssignment> doctorAssignmentList = department.getDoctorAssignmentList();		
		doctorAssignmentList.addAllToRemoveList(externalDoctorAssignmentList);
		return department;	
	
	}


	//disconnect Department with doctor in DoctorAssignment
	public Department planToRemoveDoctorAssignmentListWithDoctor(Department department, String doctorId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorAssignment.DEPARTMENT_PROPERTY, department.getId());
		key.put(DoctorAssignment.DOCTOR_PROPERTY, doctorId);
		
		SmartList<DoctorAssignment> externalDoctorAssignmentList = getDoctorAssignmentDAO().
				findDoctorAssignmentWithKey(key, options);
		if(externalDoctorAssignmentList == null){
			return department;
		}
		if(externalDoctorAssignmentList.isEmpty()){
			return department;
		}
		
		for(DoctorAssignment doctorAssignment: externalDoctorAssignmentList){
			doctorAssignment.clearDoctor();
			doctorAssignment.clearDepartment();
			
		}
		
		
		SmartList<DoctorAssignment> doctorAssignmentList = department.getDoctorAssignmentList();		
		doctorAssignmentList.addAllToRemoveList(externalDoctorAssignmentList);
		return department;
	}
	
	public int countDoctorAssignmentListWithDoctor(String departmentId, String doctorId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorAssignment.DEPARTMENT_PROPERTY, departmentId);
		key.put(DoctorAssignment.DOCTOR_PROPERTY, doctorId);
		
		int count = getDoctorAssignmentDAO().countDoctorAssignmentWithKey(key, options);
		return count;
	}
	
	public Department planToRemoveDoctorScheduleList(Department department, String doctorScheduleIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DEPARTMENT_PROPERTY, department.getId());
		key.put(DoctorSchedule.ID_PROPERTY, doctorScheduleIds);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return department;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return department;
		}
		
		for(DoctorSchedule doctorSchedule: externalDoctorScheduleList){

			doctorSchedule.clearFromAll();
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = department.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return department;	
	
	}


	//disconnect Department with doctor in DoctorSchedule
	public Department planToRemoveDoctorScheduleListWithDoctor(Department department, String doctorId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DEPARTMENT_PROPERTY, department.getId());
		key.put(DoctorSchedule.DOCTOR_PROPERTY, doctorId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return department;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return department;
		}
		
		for(DoctorSchedule doctorSchedule: externalDoctorScheduleList){
			doctorSchedule.clearDoctor();
			doctorSchedule.clearDepartment();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = department.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return department;
	}
	
	public int countDoctorScheduleListWithDoctor(String departmentId, String doctorId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DEPARTMENT_PROPERTY, departmentId);
		key.put(DoctorSchedule.DOCTOR_PROPERTY, doctorId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	
	//disconnect Department with period in DoctorSchedule
	public Department planToRemoveDoctorScheduleListWithPeriod(Department department, String periodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DEPARTMENT_PROPERTY, department.getId());
		key.put(DoctorSchedule.PERIOD_PROPERTY, periodId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return department;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return department;
		}
		
		for(DoctorSchedule doctorSchedule: externalDoctorScheduleList){
			doctorSchedule.clearPeriod();
			doctorSchedule.clearDepartment();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = department.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return department;
	}
	
	public int countDoctorScheduleListWithPeriod(String departmentId, String periodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DEPARTMENT_PROPERTY, departmentId);
		key.put(DoctorSchedule.PERIOD_PROPERTY, periodId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	
	//disconnect Department with expense_type in DoctorSchedule
	public Department planToRemoveDoctorScheduleListWithExpenseType(Department department, String expenseTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DEPARTMENT_PROPERTY, department.getId());
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, expenseTypeId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return department;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return department;
		}
		
		for(DoctorSchedule doctorSchedule: externalDoctorScheduleList){
			doctorSchedule.clearExpenseType();
			doctorSchedule.clearDepartment();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = department.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return department;
	}
	
	public int countDoctorScheduleListWithExpenseType(String departmentId, String expenseTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DEPARTMENT_PROPERTY, departmentId);
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, expenseTypeId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	
	//disconnect Department with hospital in DoctorSchedule
	public Department planToRemoveDoctorScheduleListWithHospital(Department department, String hospitalId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DEPARTMENT_PROPERTY, department.getId());
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, hospitalId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return department;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return department;
		}
		
		for(DoctorSchedule doctorSchedule: externalDoctorScheduleList){
			doctorSchedule.clearHospital();
			doctorSchedule.clearDepartment();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = department.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return department;
	}
	
	public int countDoctorScheduleListWithHospital(String departmentId, String hospitalId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.DEPARTMENT_PROPERTY, departmentId);
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, hospitalId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	

		
	protected Department saveDoctorAssignmentList(Department department, Map<String,Object> options){
		
		
		
		
		SmartList<DoctorAssignment> doctorAssignmentList = department.getDoctorAssignmentList();
		if(doctorAssignmentList == null){
			//null list means nothing
			return department;
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
		
		
		return department;
	
	}
	
	protected Department removeDoctorAssignmentList(Department department, Map<String,Object> options){
	
	
		SmartList<DoctorAssignment> doctorAssignmentList = department.getDoctorAssignmentList();
		if(doctorAssignmentList == null){
			return department;
		}	
	
		SmartList<DoctorAssignment> toRemoveDoctorAssignmentList = doctorAssignmentList.getToRemoveList();
		
		if(toRemoveDoctorAssignmentList == null){
			return department;
		}
		if(toRemoveDoctorAssignmentList.isEmpty()){
			return department;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getDoctorAssignmentDAO().removeDoctorAssignmentList(toRemoveDoctorAssignmentList,options);
		
		return department;
	
	}
	
	

 	
 	
	
	
	
		
	protected Department saveDoctorScheduleList(Department department, Map<String,Object> options){
		
		
		
		
		SmartList<DoctorSchedule> doctorScheduleList = department.getDoctorScheduleList();
		if(doctorScheduleList == null){
			//null list means nothing
			return department;
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
		
		
		return department;
	
	}
	
	protected Department removeDoctorScheduleList(Department department, Map<String,Object> options){
	
	
		SmartList<DoctorSchedule> doctorScheduleList = department.getDoctorScheduleList();
		if(doctorScheduleList == null){
			return department;
		}	
	
		SmartList<DoctorSchedule> toRemoveDoctorScheduleList = doctorScheduleList.getToRemoveList();
		
		if(toRemoveDoctorScheduleList == null){
			return department;
		}
		if(toRemoveDoctorScheduleList.isEmpty()){
			return department;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getDoctorScheduleDAO().removeDoctorScheduleList(toRemoveDoctorScheduleList,options);
		
		return department;
	
	}
	
	

 	
 	
	
	
	
		

	public Department present(Department department,Map<String, Object> options){
	
		presentDoctorAssignmentList(department,options);
		presentDoctorScheduleList(department,options);

		return department;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Department presentDoctorAssignmentList(
			Department department,
			Map<String, Object> options) {

		SmartList<DoctorAssignment> doctorAssignmentList = department.getDoctorAssignmentList();		
				SmartList<DoctorAssignment> newList= presentSubList(department.getId(),
				doctorAssignmentList,
				options,
				getDoctorAssignmentDAO()::countDoctorAssignmentByDepartment,
				getDoctorAssignmentDAO()::findDoctorAssignmentByDepartment
				);

		
		department.setDoctorAssignmentList(newList);
		

		return department;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Department presentDoctorScheduleList(
			Department department,
			Map<String, Object> options) {

		SmartList<DoctorSchedule> doctorScheduleList = department.getDoctorScheduleList();		
				SmartList<DoctorSchedule> newList= presentSubList(department.getId(),
				doctorScheduleList,
				options,
				getDoctorScheduleDAO()::countDoctorScheduleByDepartment,
				getDoctorScheduleDAO()::findDoctorScheduleByDepartment
				);

		
		department.setDoctorScheduleList(newList);
		

		return department;
	}			
		

	
    public SmartList<Department> requestCandidateDepartmentForDoctorAssignment(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(DepartmentTable.COLUMN_NAME, filterKey, pageNo, pageSize, getDepartmentMapper());
    }
		
    public SmartList<Department> requestCandidateDepartmentForDoctorSchedule(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(DepartmentTable.COLUMN_NAME, filterKey, pageNo, pageSize, getDepartmentMapper());
    }
		

	protected String getTableName(){
		return DepartmentTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Department> departmentList) {		
		this.enhanceListInternal(departmentList, this.getDepartmentMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Department> departmentList = ownerEntity.collectRefsWithType(Department.INTERNAL_TYPE);
		this.enhanceList(departmentList);
		
	}
	
	@Override
	public SmartList<Department> findDepartmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getDepartmentMapper());

	}
	@Override
	public int countDepartmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countDepartmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Department> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getDepartmentMapper());
	}
}


