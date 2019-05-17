
package com.doublechaintech.his.doctorassignment;

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


import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;

import com.doublechaintech.his.department.DepartmentDAO;
import com.doublechaintech.his.doctor.DoctorDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class DoctorAssignmentJDBCTemplateDAO extends HisNamingServiceDAO implements DoctorAssignmentDAO{
 
 	
 	private  DoctorDAO  doctorDAO;
 	public void setDoctorDAO(DoctorDAO doctorDAO){
	 	this.doctorDAO = doctorDAO;
 	}
 	public DoctorDAO getDoctorDAO(){
	 	return this.doctorDAO;
 	}
 
 	
 	private  DepartmentDAO  departmentDAO;
 	public void setDepartmentDAO(DepartmentDAO departmentDAO){
	 	this.departmentDAO = departmentDAO;
 	}
 	public DepartmentDAO getDepartmentDAO(){
	 	return this.departmentDAO;
 	}


			
		

	
	/*
	protected DoctorAssignment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalDoctorAssignment(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public DoctorAssignment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalDoctorAssignment(DoctorAssignmentTable.withId(id), options);
	}
	
	
	
	public DoctorAssignment save(DoctorAssignment doctorAssignment,Map<String,Object> options){
		
		String methodName="save(DoctorAssignment doctorAssignment,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(doctorAssignment, methodName, "doctorAssignment");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalDoctorAssignment(doctorAssignment,options);
	}
	public DoctorAssignment clone(String doctorAssignmentId, Map<String,Object> options) throws Exception{
	
		return clone(DoctorAssignmentTable.withId(doctorAssignmentId),options);
	}
	
	protected DoctorAssignment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String doctorAssignmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		DoctorAssignment newDoctorAssignment = loadInternalDoctorAssignment(accessKey, options);
		newDoctorAssignment.setVersion(0);
		
		

		
		saveInternalDoctorAssignment(newDoctorAssignment,options);
		
		return newDoctorAssignment;
	}
	
	
	
	

	protected void throwIfHasException(String doctorAssignmentId,int version,int count) throws Exception{
		if (count == 1) {
			throw new DoctorAssignmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new DoctorAssignmentNotFoundException(
					"The " + this.getTableName() + "(" + doctorAssignmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String doctorAssignmentId, int version) throws Exception{
	
		String methodName="delete(String doctorAssignmentId, int version)";
		assertMethodArgumentNotNull(doctorAssignmentId, methodName, "doctorAssignmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{doctorAssignmentId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(doctorAssignmentId,version);
		}
		
	
	}
	
	
	
	
	

	public DoctorAssignment disconnectFromAll(String doctorAssignmentId, int version) throws Exception{
	
		
		DoctorAssignment doctorAssignment = loadInternalDoctorAssignment(DoctorAssignmentTable.withId(doctorAssignmentId), emptyOptions());
		doctorAssignment.clearFromAll();
		this.saveDoctorAssignment(doctorAssignment);
		return doctorAssignment;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return DoctorAssignmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "doctor_assignment";
	}
	@Override
	protected String getBeanName() {
		
		return "doctorAssignment";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return DoctorAssignmentTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractDoctorEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, DoctorAssignmentTokens.DOCTOR);
 	}

 	protected boolean isSaveDoctorEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, DoctorAssignmentTokens.DOCTOR);
 	}
 	

 	
  

 	protected boolean isExtractDepartmentEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, DoctorAssignmentTokens.DEPARTMENT);
 	}

 	protected boolean isSaveDepartmentEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, DoctorAssignmentTokens.DEPARTMENT);
 	}
 	

 	
 
		

	

	protected DoctorAssignmentMapper getDoctorAssignmentMapper(){
		return new DoctorAssignmentMapper();
	}

	
	
	protected DoctorAssignment extractDoctorAssignment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			DoctorAssignment doctorAssignment = loadSingleObject(accessKey, getDoctorAssignmentMapper());
			return doctorAssignment;
		}catch(EmptyResultDataAccessException e){
			throw new DoctorAssignmentNotFoundException("DoctorAssignment("+accessKey+") is not found!");
		}

	}

	
	

	protected DoctorAssignment loadInternalDoctorAssignment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		DoctorAssignment doctorAssignment = extractDoctorAssignment(accessKey, loadOptions);
 	
 		if(isExtractDoctorEnabled(loadOptions)){
	 		extractDoctor(doctorAssignment, loadOptions);
 		}
  	
 		if(isExtractDepartmentEnabled(loadOptions)){
	 		extractDepartment(doctorAssignment, loadOptions);
 		}
 
		
		return doctorAssignment;
		
	}

	 

 	protected DoctorAssignment extractDoctor(DoctorAssignment doctorAssignment, Map<String,Object> options) throws Exception{

		if(doctorAssignment.getDoctor() == null){
			return doctorAssignment;
		}
		String doctorId = doctorAssignment.getDoctor().getId();
		if( doctorId == null){
			return doctorAssignment;
		}
		Doctor doctor = getDoctorDAO().load(doctorId,options);
		if(doctor != null){
			doctorAssignment.setDoctor(doctor);
		}
		
 		
 		return doctorAssignment;
 	}
 		
  

 	protected DoctorAssignment extractDepartment(DoctorAssignment doctorAssignment, Map<String,Object> options) throws Exception{

		if(doctorAssignment.getDepartment() == null){
			return doctorAssignment;
		}
		String departmentId = doctorAssignment.getDepartment().getId();
		if( departmentId == null){
			return doctorAssignment;
		}
		Department department = getDepartmentDAO().load(departmentId,options);
		if(department != null){
			doctorAssignment.setDepartment(department);
		}
		
 		
 		return doctorAssignment;
 	}
 		
 
		
		
  	
 	public SmartList<DoctorAssignment> findDoctorAssignmentByDoctor(String doctorId,Map<String,Object> options){
 	
  		SmartList<DoctorAssignment> resultList = queryWith(DoctorAssignmentTable.COLUMN_DOCTOR, doctorId, options, getDoctorAssignmentMapper());
		// analyzeDoctorAssignmentByDoctor(resultList, doctorId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<DoctorAssignment> findDoctorAssignmentByDoctor(String doctorId, int start, int count,Map<String,Object> options){
 		
 		SmartList<DoctorAssignment> resultList =  queryWithRange(DoctorAssignmentTable.COLUMN_DOCTOR, doctorId, options, getDoctorAssignmentMapper(), start, count);
 		//analyzeDoctorAssignmentByDoctor(resultList, doctorId, options);
 		return resultList;
 		
 	}
 	public void analyzeDoctorAssignmentByDoctor(SmartList<DoctorAssignment> resultList, String doctorId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(DoctorAssignment.DOCTOR_PROPERTY, doctorId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem updateTimeStatsItem = new StatsItem();
		//DoctorAssignment.UPDATE_TIME_PROPERTY
		updateTimeStatsItem.setDisplayName("医生的任务");
		updateTimeStatsItem.setInternalName(formatKeyForDateLine(DoctorAssignment.UPDATE_TIME_PROPERTY));
		updateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(DoctorAssignment.UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(updateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countDoctorAssignmentByDoctor(String doctorId,Map<String,Object> options){

 		return countWith(DoctorAssignmentTable.COLUMN_DOCTOR, doctorId, options);
 	}
 	@Override
	public Map<String, Integer> countDoctorAssignmentByDoctorIds(String[] ids, Map<String, Object> options) {
		return countWithIds(DoctorAssignmentTable.COLUMN_DOCTOR, ids, options);
	}
 	
  	
 	public SmartList<DoctorAssignment> findDoctorAssignmentByDepartment(String departmentId,Map<String,Object> options){
 	
  		SmartList<DoctorAssignment> resultList = queryWith(DoctorAssignmentTable.COLUMN_DEPARTMENT, departmentId, options, getDoctorAssignmentMapper());
		// analyzeDoctorAssignmentByDepartment(resultList, departmentId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<DoctorAssignment> findDoctorAssignmentByDepartment(String departmentId, int start, int count,Map<String,Object> options){
 		
 		SmartList<DoctorAssignment> resultList =  queryWithRange(DoctorAssignmentTable.COLUMN_DEPARTMENT, departmentId, options, getDoctorAssignmentMapper(), start, count);
 		//analyzeDoctorAssignmentByDepartment(resultList, departmentId, options);
 		return resultList;
 		
 	}
 	public void analyzeDoctorAssignmentByDepartment(SmartList<DoctorAssignment> resultList, String departmentId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(DoctorAssignment.DEPARTMENT_PROPERTY, departmentId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem updateTimeStatsItem = new StatsItem();
		//DoctorAssignment.UPDATE_TIME_PROPERTY
		updateTimeStatsItem.setDisplayName("医生的任务");
		updateTimeStatsItem.setInternalName(formatKeyForDateLine(DoctorAssignment.UPDATE_TIME_PROPERTY));
		updateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(DoctorAssignment.UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(updateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countDoctorAssignmentByDepartment(String departmentId,Map<String,Object> options){

 		return countWith(DoctorAssignmentTable.COLUMN_DEPARTMENT, departmentId, options);
 	}
 	@Override
	public Map<String, Integer> countDoctorAssignmentByDepartmentIds(String[] ids, Map<String, Object> options) {
		return countWithIds(DoctorAssignmentTable.COLUMN_DEPARTMENT, ids, options);
	}
 	
 	
		
		
		

	

	protected DoctorAssignment saveDoctorAssignment(DoctorAssignment  doctorAssignment){
		
		if(!doctorAssignment.isChanged()){
			return doctorAssignment;
		}
		
		
		String SQL=this.getSaveDoctorAssignmentSQL(doctorAssignment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveDoctorAssignmentParameters(doctorAssignment);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		doctorAssignment.incVersion();
		return doctorAssignment;
	
	}
	public SmartList<DoctorAssignment> saveDoctorAssignmentList(SmartList<DoctorAssignment> doctorAssignmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitDoctorAssignmentList(doctorAssignmentList);
		
		batchDoctorAssignmentCreate((List<DoctorAssignment>)lists[CREATE_LIST_INDEX]);
		
		batchDoctorAssignmentUpdate((List<DoctorAssignment>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(DoctorAssignment doctorAssignment:doctorAssignmentList){
			if(doctorAssignment.isChanged()){
				doctorAssignment.incVersion();
			}
			
		
		}
		
		
		return doctorAssignmentList;
	}

	public SmartList<DoctorAssignment> removeDoctorAssignmentList(SmartList<DoctorAssignment> doctorAssignmentList,Map<String,Object> options){
		
		
		super.removeList(doctorAssignmentList, options);
		
		return doctorAssignmentList;
		
		
	}
	
	protected List<Object[]> prepareDoctorAssignmentBatchCreateArgs(List<DoctorAssignment> doctorAssignmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(DoctorAssignment doctorAssignment:doctorAssignmentList ){
			Object [] parameters = prepareDoctorAssignmentCreateParameters(doctorAssignment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareDoctorAssignmentBatchUpdateArgs(List<DoctorAssignment> doctorAssignmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(DoctorAssignment doctorAssignment:doctorAssignmentList ){
			if(!doctorAssignment.isChanged()){
				continue;
			}
			Object [] parameters = prepareDoctorAssignmentUpdateParameters(doctorAssignment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchDoctorAssignmentCreate(List<DoctorAssignment> doctorAssignmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareDoctorAssignmentBatchCreateArgs(doctorAssignmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchDoctorAssignmentUpdate(List<DoctorAssignment> doctorAssignmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareDoctorAssignmentBatchUpdateArgs(doctorAssignmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitDoctorAssignmentList(List<DoctorAssignment> doctorAssignmentList){
		
		List<DoctorAssignment> doctorAssignmentCreateList=new ArrayList<DoctorAssignment>();
		List<DoctorAssignment> doctorAssignmentUpdateList=new ArrayList<DoctorAssignment>();
		
		for(DoctorAssignment doctorAssignment: doctorAssignmentList){
			if(isUpdateRequest(doctorAssignment)){
				doctorAssignmentUpdateList.add( doctorAssignment);
				continue;
			}
			doctorAssignmentCreateList.add(doctorAssignment);
		}
		
		return new Object[]{doctorAssignmentCreateList,doctorAssignmentUpdateList};
	}
	
	protected boolean isUpdateRequest(DoctorAssignment doctorAssignment){
 		return doctorAssignment.getVersion() > 0;
 	}
 	protected String getSaveDoctorAssignmentSQL(DoctorAssignment doctorAssignment){
 		if(isUpdateRequest(doctorAssignment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveDoctorAssignmentParameters(DoctorAssignment doctorAssignment){
 		if(isUpdateRequest(doctorAssignment) ){
 			return prepareDoctorAssignmentUpdateParameters(doctorAssignment);
 		}
 		return prepareDoctorAssignmentCreateParameters(doctorAssignment);
 	}
 	protected Object[] prepareDoctorAssignmentUpdateParameters(DoctorAssignment doctorAssignment){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = doctorAssignment.getName(); 	
 		if(doctorAssignment.getDoctor() != null){
 			parameters[1] = doctorAssignment.getDoctor().getId();
 		}
  	
 		if(doctorAssignment.getDepartment() != null){
 			parameters[2] = doctorAssignment.getDepartment().getId();
 		}
 
 		parameters[3] = doctorAssignment.getUpdateTime();		
 		parameters[4] = doctorAssignment.nextVersion();
 		parameters[5] = doctorAssignment.getId();
 		parameters[6] = doctorAssignment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareDoctorAssignmentCreateParameters(DoctorAssignment doctorAssignment){
		Object[] parameters = new Object[5];
		String newDoctorAssignmentId=getNextId();
		doctorAssignment.setId(newDoctorAssignmentId);
		parameters[0] =  doctorAssignment.getId();
 
 		parameters[1] = doctorAssignment.getName(); 	
 		if(doctorAssignment.getDoctor() != null){
 			parameters[2] = doctorAssignment.getDoctor().getId();
 		
 		}
 		 	
 		if(doctorAssignment.getDepartment() != null){
 			parameters[3] = doctorAssignment.getDepartment().getId();
 		
 		}
 		
 		parameters[4] = doctorAssignment.getUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected DoctorAssignment saveInternalDoctorAssignment(DoctorAssignment doctorAssignment, Map<String,Object> options){
		
		saveDoctorAssignment(doctorAssignment);
 	
 		if(isSaveDoctorEnabled(options)){
	 		saveDoctor(doctorAssignment, options);
 		}
  	
 		if(isSaveDepartmentEnabled(options)){
	 		saveDepartment(doctorAssignment, options);
 		}
 
		
		return doctorAssignment;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected DoctorAssignment saveDoctor(DoctorAssignment doctorAssignment, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(doctorAssignment.getDoctor() == null){
 			return doctorAssignment;//do nothing when it is null
 		}
 		
 		getDoctorDAO().save(doctorAssignment.getDoctor(),options);
 		return doctorAssignment;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected DoctorAssignment saveDepartment(DoctorAssignment doctorAssignment, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(doctorAssignment.getDepartment() == null){
 			return doctorAssignment;//do nothing when it is null
 		}
 		
 		getDepartmentDAO().save(doctorAssignment.getDepartment(),options);
 		return doctorAssignment;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public DoctorAssignment present(DoctorAssignment doctorAssignment,Map<String, Object> options){
	

		return doctorAssignment;
	
	}
		

	

	protected String getTableName(){
		return DoctorAssignmentTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<DoctorAssignment> doctorAssignmentList) {		
		this.enhanceListInternal(doctorAssignmentList, this.getDoctorAssignmentMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<DoctorAssignment> doctorAssignmentList = ownerEntity.collectRefsWithType(DoctorAssignment.INTERNAL_TYPE);
		this.enhanceList(doctorAssignmentList);
		
	}
	
	@Override
	public SmartList<DoctorAssignment> findDoctorAssignmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getDoctorAssignmentMapper());

	}
	@Override
	public int countDoctorAssignmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countDoctorAssignmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<DoctorAssignment> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getDoctorAssignmentMapper());
	}
}


