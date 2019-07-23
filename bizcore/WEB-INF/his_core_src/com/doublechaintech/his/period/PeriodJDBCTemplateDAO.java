
package com.doublechaintech.his.period;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.his.HisBaseDAOImpl;
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

import com.doublechaintech.his.doctorschedule.DoctorScheduleDAO;
import com.doublechaintech.his.hospital.HospitalDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class PeriodJDBCTemplateDAO extends HisBaseDAOImpl implements PeriodDAO{
 
 	
 	private  HospitalDAO  hospitalDAO;
 	public void setHospitalDAO(HospitalDAO hospitalDAO){
	 	this.hospitalDAO = hospitalDAO;
 	}
 	public HospitalDAO getHospitalDAO(){
	 	return this.hospitalDAO;
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
	protected Period load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPeriod(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Period load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPeriod(PeriodTable.withId(id), options);
	}
	
	
	
	public Period save(Period period,Map<String,Object> options){
		
		String methodName="save(Period period,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(period, methodName, "period");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPeriod(period,options);
	}
	public Period clone(String periodId, Map<String,Object> options) throws Exception{
	
		return clone(PeriodTable.withId(periodId),options);
	}
	
	protected Period clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String periodId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Period newPeriod = loadInternalPeriod(accessKey, options);
		newPeriod.setVersion(0);
		
		
 		
 		if(isSaveDoctorScheduleListEnabled(options)){
 			for(DoctorSchedule item: newPeriod.getDoctorScheduleList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalPeriod(newPeriod,options);
		
		return newPeriod;
	}
	
	
	
	

	protected void throwIfHasException(String periodId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PeriodVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PeriodNotFoundException(
					"The " + this.getTableName() + "(" + periodId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String periodId, int version) throws Exception{
	
		String methodName="delete(String periodId, int version)";
		assertMethodArgumentNotNull(periodId, methodName, "periodId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{periodId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(periodId,version);
		}
		
	
	}
	
	
	
	
	

	public Period disconnectFromAll(String periodId, int version) throws Exception{
	
		
		Period period = loadInternalPeriod(PeriodTable.withId(periodId), emptyOptions());
		period.clearFromAll();
		this.savePeriod(period);
		return period;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return PeriodTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "period";
	}
	@Override
	protected String getBeanName() {
		
		return "period";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PeriodTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractHospitalEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PeriodTokens.HOSPITAL);
 	}

 	protected boolean isSaveHospitalEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PeriodTokens.HOSPITAL);
 	}
 	

 	
 
		
	
	protected boolean isExtractDoctorScheduleListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PeriodTokens.DOCTOR_SCHEDULE_LIST);
 	}
 	protected boolean isAnalyzeDoctorScheduleListEnabled(Map<String,Object> options){		 		
 		return PeriodTokens.of(options).analyzeDoctorScheduleListEnabled();
 	}
	
	protected boolean isSaveDoctorScheduleListEnabled(Map<String,Object> options){
		return checkOptions(options, PeriodTokens.DOCTOR_SCHEDULE_LIST);
		
 	}
 	
		

	

	protected PeriodMapper getPeriodMapper(){
		return new PeriodMapper();
	}

	
	
	protected Period extractPeriod(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Period period = loadSingleObject(accessKey, getPeriodMapper());
			return period;
		}catch(EmptyResultDataAccessException e){
			throw new PeriodNotFoundException("Period("+accessKey+") is not found!");
		}

	}

	
	

	protected Period loadInternalPeriod(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Period period = extractPeriod(accessKey, loadOptions);
 	
 		if(isExtractHospitalEnabled(loadOptions)){
	 		extractHospital(period, loadOptions);
 		}
 
		
		if(isExtractDoctorScheduleListEnabled(loadOptions)){
	 		extractDoctorScheduleList(period, loadOptions);
 		}	
 		if(isAnalyzeDoctorScheduleListEnabled(loadOptions)){
	 		analyzeDoctorScheduleList(period, loadOptions);
 		}
 		
		
		return period;
		
	}

	 

 	protected Period extractHospital(Period period, Map<String,Object> options) throws Exception{

		if(period.getHospital() == null){
			return period;
		}
		String hospitalId = period.getHospital().getId();
		if( hospitalId == null){
			return period;
		}
		Hospital hospital = getHospitalDAO().load(hospitalId,options);
		if(hospital != null){
			period.setHospital(hospital);
		}
		
 		
 		return period;
 	}
 		
 
		
	protected void enhanceDoctorScheduleList(SmartList<DoctorSchedule> doctorScheduleList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Period extractDoctorScheduleList(Period period, Map<String,Object> options){
		
		
		if(period == null){
			return null;
		}
		if(period.getId() == null){
			return period;
		}

		
		
		SmartList<DoctorSchedule> doctorScheduleList = getDoctorScheduleDAO().findDoctorScheduleByPeriod(period.getId(),options);
		if(doctorScheduleList != null){
			enhanceDoctorScheduleList(doctorScheduleList,options);
			period.setDoctorScheduleList(doctorScheduleList);
		}
		
		return period;
	
	}	
	
	protected Period analyzeDoctorScheduleList(Period period, Map<String,Object> options){
		
		
		if(period == null){
			return null;
		}
		if(period.getId() == null){
			return period;
		}

		
		
		SmartList<DoctorSchedule> doctorScheduleList = period.getDoctorScheduleList();
		if(doctorScheduleList != null){
			getDoctorScheduleDAO().analyzeDoctorScheduleByPeriod(doctorScheduleList, period.getId(), options);
			
		}
		
		return period;
	
	}	
	
		
		
  	
 	public SmartList<Period> findPeriodByHospital(String hospitalId,Map<String,Object> options){
 	
  		SmartList<Period> resultList = queryWith(PeriodTable.COLUMN_HOSPITAL, hospitalId, options, getPeriodMapper());
		// analyzePeriodByHospital(resultList, hospitalId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Period> findPeriodByHospital(String hospitalId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Period> resultList =  queryWithRange(PeriodTable.COLUMN_HOSPITAL, hospitalId, options, getPeriodMapper(), start, count);
 		//analyzePeriodByHospital(resultList, hospitalId, options);
 		return resultList;
 		
 	}
 	public void analyzePeriodByHospital(SmartList<Period> resultList, String hospitalId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countPeriodByHospital(String hospitalId,Map<String,Object> options){

 		return countWith(PeriodTable.COLUMN_HOSPITAL, hospitalId, options);
 	}
 	@Override
	public Map<String, Integer> countPeriodByHospitalIds(String[] ids, Map<String, Object> options) {
		return countWithIds(PeriodTable.COLUMN_HOSPITAL, ids, options);
	}
 	
 	
		
		
		

	

	protected Period savePeriod(Period  period){
		
		if(!period.isChanged()){
			return period;
		}
		
		
		String SQL=this.getSavePeriodSQL(period);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePeriodParameters(period);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		period.incVersion();
		return period;
	
	}
	public SmartList<Period> savePeriodList(SmartList<Period> periodList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPeriodList(periodList);
		
		batchPeriodCreate((List<Period>)lists[CREATE_LIST_INDEX]);
		
		batchPeriodUpdate((List<Period>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Period period:periodList){
			if(period.isChanged()){
				period.incVersion();
			}
			
		
		}
		
		
		return periodList;
	}

	public SmartList<Period> removePeriodList(SmartList<Period> periodList,Map<String,Object> options){
		
		
		super.removeList(periodList, options);
		
		return periodList;
		
		
	}
	
	protected List<Object[]> preparePeriodBatchCreateArgs(List<Period> periodList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Period period:periodList ){
			Object [] parameters = preparePeriodCreateParameters(period);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePeriodBatchUpdateArgs(List<Period> periodList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Period period:periodList ){
			if(!period.isChanged()){
				continue;
			}
			Object [] parameters = preparePeriodUpdateParameters(period);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPeriodCreate(List<Period> periodList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePeriodBatchCreateArgs(periodList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPeriodUpdate(List<Period> periodList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePeriodBatchUpdateArgs(periodList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPeriodList(List<Period> periodList){
		
		List<Period> periodCreateList=new ArrayList<Period>();
		List<Period> periodUpdateList=new ArrayList<Period>();
		
		for(Period period: periodList){
			if(isUpdateRequest(period)){
				periodUpdateList.add( period);
				continue;
			}
			periodCreateList.add(period);
		}
		
		return new Object[]{periodCreateList,periodUpdateList};
	}
	
	protected boolean isUpdateRequest(Period period){
 		return period.getVersion() > 0;
 	}
 	protected String getSavePeriodSQL(Period period){
 		if(isUpdateRequest(period)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePeriodParameters(Period period){
 		if(isUpdateRequest(period) ){
 			return preparePeriodUpdateParameters(period);
 		}
 		return preparePeriodCreateParameters(period);
 	}
 	protected Object[] preparePeriodUpdateParameters(Period period){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = period.getName(); 	
 		if(period.getHospital() != null){
 			parameters[1] = period.getHospital().getId();
 		}
 		
 		parameters[2] = period.nextVersion();
 		parameters[3] = period.getId();
 		parameters[4] = period.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePeriodCreateParameters(Period period){
		Object[] parameters = new Object[3];
		String newPeriodId=getNextId();
		period.setId(newPeriodId);
		parameters[0] =  period.getId();
 
 		parameters[1] = period.getName(); 	
 		if(period.getHospital() != null){
 			parameters[2] = period.getHospital().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Period saveInternalPeriod(Period period, Map<String,Object> options){
		
		savePeriod(period);
 	
 		if(isSaveHospitalEnabled(options)){
	 		saveHospital(period, options);
 		}
 
		
		if(isSaveDoctorScheduleListEnabled(options)){
	 		saveDoctorScheduleList(period, options);
	 		//removeDoctorScheduleList(period, options);
	 		//Not delete the record
	 		
 		}		
		
		return period;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Period saveHospital(Period period, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(period.getHospital() == null){
 			return period;//do nothing when it is null
 		}
 		
 		getHospitalDAO().save(period.getHospital(),options);
 		return period;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Period planToRemoveDoctorScheduleList(Period period, String doctorScheduleIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.PERIOD_PROPERTY, period.getId());
		key.put(DoctorSchedule.ID_PROPERTY, doctorScheduleIds);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return period;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return period;
		}
		
		for(DoctorSchedule doctorScheduleItem: externalDoctorScheduleList){

			doctorScheduleItem.clearFromAll();
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = period.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return period;	
	
	}


	//disconnect Period with doctor in DoctorSchedule
	public Period planToRemoveDoctorScheduleListWithDoctor(Period period, String doctorId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.PERIOD_PROPERTY, period.getId());
		key.put(DoctorSchedule.DOCTOR_PROPERTY, doctorId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return period;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return period;
		}
		
		for(DoctorSchedule doctorScheduleItem: externalDoctorScheduleList){
			doctorScheduleItem.clearDoctor();
			doctorScheduleItem.clearPeriod();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = period.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return period;
	}
	
	public int countDoctorScheduleListWithDoctor(String periodId, String doctorId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.PERIOD_PROPERTY, periodId);
		key.put(DoctorSchedule.DOCTOR_PROPERTY, doctorId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	
	//disconnect Period with department in DoctorSchedule
	public Period planToRemoveDoctorScheduleListWithDepartment(Period period, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.PERIOD_PROPERTY, period.getId());
		key.put(DoctorSchedule.DEPARTMENT_PROPERTY, departmentId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return period;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return period;
		}
		
		for(DoctorSchedule doctorScheduleItem: externalDoctorScheduleList){
			doctorScheduleItem.clearDepartment();
			doctorScheduleItem.clearPeriod();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = period.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return period;
	}
	
	public int countDoctorScheduleListWithDepartment(String periodId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.PERIOD_PROPERTY, periodId);
		key.put(DoctorSchedule.DEPARTMENT_PROPERTY, departmentId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	
	//disconnect Period with expense_type in DoctorSchedule
	public Period planToRemoveDoctorScheduleListWithExpenseType(Period period, String expenseTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.PERIOD_PROPERTY, period.getId());
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, expenseTypeId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return period;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return period;
		}
		
		for(DoctorSchedule doctorScheduleItem: externalDoctorScheduleList){
			doctorScheduleItem.clearExpenseType();
			doctorScheduleItem.clearPeriod();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = period.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return period;
	}
	
	public int countDoctorScheduleListWithExpenseType(String periodId, String expenseTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.PERIOD_PROPERTY, periodId);
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, expenseTypeId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	
	//disconnect Period with hospital in DoctorSchedule
	public Period planToRemoveDoctorScheduleListWithHospital(Period period, String hospitalId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.PERIOD_PROPERTY, period.getId());
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, hospitalId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return period;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return period;
		}
		
		for(DoctorSchedule doctorScheduleItem: externalDoctorScheduleList){
			doctorScheduleItem.clearHospital();
			doctorScheduleItem.clearPeriod();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = period.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return period;
	}
	
	public int countDoctorScheduleListWithHospital(String periodId, String hospitalId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.PERIOD_PROPERTY, periodId);
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, hospitalId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	

		
	protected Period saveDoctorScheduleList(Period period, Map<String,Object> options){
		
		
		
		
		SmartList<DoctorSchedule> doctorScheduleList = period.getDoctorScheduleList();
		if(doctorScheduleList == null){
			//null list means nothing
			return period;
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
		
		
		return period;
	
	}
	
	protected Period removeDoctorScheduleList(Period period, Map<String,Object> options){
	
	
		SmartList<DoctorSchedule> doctorScheduleList = period.getDoctorScheduleList();
		if(doctorScheduleList == null){
			return period;
		}	
	
		SmartList<DoctorSchedule> toRemoveDoctorScheduleList = doctorScheduleList.getToRemoveList();
		
		if(toRemoveDoctorScheduleList == null){
			return period;
		}
		if(toRemoveDoctorScheduleList.isEmpty()){
			return period;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getDoctorScheduleDAO().removeDoctorScheduleList(toRemoveDoctorScheduleList,options);
		
		return period;
	
	}
	
	

 	
 	
	
	
	
		

	public Period present(Period period,Map<String, Object> options){
	
		presentDoctorScheduleList(period,options);

		return period;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Period presentDoctorScheduleList(
			Period period,
			Map<String, Object> options) {

		SmartList<DoctorSchedule> doctorScheduleList = period.getDoctorScheduleList();		
				SmartList<DoctorSchedule> newList= presentSubList(period.getId(),
				doctorScheduleList,
				options,
				getDoctorScheduleDAO()::countDoctorScheduleByPeriod,
				getDoctorScheduleDAO()::findDoctorScheduleByPeriod
				);

		
		period.setDoctorScheduleList(newList);
		

		return period;
	}			
		

	
    public SmartList<Period> requestCandidatePeriodForDoctorSchedule(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PeriodTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPeriodMapper());
    }
		

	protected String getTableName(){
		return PeriodTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Period> periodList) {		
		this.enhanceListInternal(periodList, this.getPeriodMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:DoctorSchedule的period的DoctorScheduleList
	public SmartList<DoctorSchedule> loadOurDoctorScheduleList(HisUserContext userContext, List<Period> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.PERIOD_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<DoctorSchedule> loadedObjs = userContext.getDAOGroup().getDoctorScheduleDAO().findDoctorScheduleWithKey(key, options);
		Map<String, List<DoctorSchedule>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPeriod().getId()));
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
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Period> periodList = ownerEntity.collectRefsWithType(Period.INTERNAL_TYPE);
		this.enhanceList(periodList);
		
	}
	
	@Override
	public SmartList<Period> findPeriodWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getPeriodMapper());

	}
	@Override
	public int countPeriodWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countPeriodWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Period> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPeriodMapper());
	}
	
	

}


