
package com.doublechaintech.his.expensetype;

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
import com.doublechaintech.his.expenseitem.ExpenseItem;

import com.doublechaintech.his.expenseitem.ExpenseItemDAO;
import com.doublechaintech.his.doctorschedule.DoctorScheduleDAO;
import com.doublechaintech.his.hospital.HospitalDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class ExpenseTypeJDBCTemplateDAO extends HisBaseDAOImpl implements ExpenseTypeDAO{
 
 	
 	private  HospitalDAO  hospitalDAO;
 	public void setHospitalDAO(HospitalDAO hospitalDAO){
	 	this.hospitalDAO = hospitalDAO;
 	}
 	public HospitalDAO getHospitalDAO(){
	 	return this.hospitalDAO;
 	}


			
		
	
  	private  ExpenseItemDAO  expenseItemDAO;
 	public void setExpenseItemDAO(ExpenseItemDAO pExpenseItemDAO){
 	
 		if(pExpenseItemDAO == null){
 			throw new IllegalStateException("Do not try to set expenseItemDAO to null.");
 		}
	 	this.expenseItemDAO = pExpenseItemDAO;
 	}
 	public ExpenseItemDAO getExpenseItemDAO(){
 		if(this.expenseItemDAO == null){
 			throw new IllegalStateException("The expenseItemDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.expenseItemDAO;
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
	protected ExpenseType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalExpenseType(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ExpenseType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalExpenseType(ExpenseTypeTable.withId(id), options);
	}
	
	
	
	public ExpenseType save(ExpenseType expenseType,Map<String,Object> options){
		
		String methodName="save(ExpenseType expenseType,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(expenseType, methodName, "expenseType");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalExpenseType(expenseType,options);
	}
	public ExpenseType clone(String expenseTypeId, Map<String,Object> options) throws Exception{
	
		return clone(ExpenseTypeTable.withId(expenseTypeId),options);
	}
	
	protected ExpenseType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String expenseTypeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ExpenseType newExpenseType = loadInternalExpenseType(accessKey, options);
		newExpenseType.setVersion(0);
		
		
 		
 		if(isSaveExpenseItemListEnabled(options)){
 			for(ExpenseItem item: newExpenseType.getExpenseItemList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveDoctorScheduleListEnabled(options)){
 			for(DoctorSchedule item: newExpenseType.getDoctorScheduleList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalExpenseType(newExpenseType,options);
		
		return newExpenseType;
	}
	
	
	
	

	protected void throwIfHasException(String expenseTypeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ExpenseTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ExpenseTypeNotFoundException(
					"The " + this.getTableName() + "(" + expenseTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String expenseTypeId, int version) throws Exception{
	
		String methodName="delete(String expenseTypeId, int version)";
		assertMethodArgumentNotNull(expenseTypeId, methodName, "expenseTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{expenseTypeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(expenseTypeId,version);
		}
		
	
	}
	
	
	
	
	

	public ExpenseType disconnectFromAll(String expenseTypeId, int version) throws Exception{
	
		
		ExpenseType expenseType = loadInternalExpenseType(ExpenseTypeTable.withId(expenseTypeId), emptyOptions());
		expenseType.clearFromAll();
		this.saveExpenseType(expenseType);
		return expenseType;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ExpenseTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "expense_type";
	}
	@Override
	protected String getBeanName() {
		
		return "expenseType";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ExpenseTypeTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractHospitalEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ExpenseTypeTokens.HOSPITAL);
 	}

 	protected boolean isSaveHospitalEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ExpenseTypeTokens.HOSPITAL);
 	}
 	

 	
 
		
	
	protected boolean isExtractExpenseItemListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ExpenseTypeTokens.EXPENSE_ITEM_LIST);
 	}
 	protected boolean isAnalyzeExpenseItemListEnabled(Map<String,Object> options){		 		
 		return ExpenseTypeTokens.of(options).analyzeExpenseItemListEnabled();
 	}
	
	protected boolean isSaveExpenseItemListEnabled(Map<String,Object> options){
		return checkOptions(options, ExpenseTypeTokens.EXPENSE_ITEM_LIST);
		
 	}
 	
		
	
	protected boolean isExtractDoctorScheduleListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ExpenseTypeTokens.DOCTOR_SCHEDULE_LIST);
 	}
 	protected boolean isAnalyzeDoctorScheduleListEnabled(Map<String,Object> options){		 		
 		return ExpenseTypeTokens.of(options).analyzeDoctorScheduleListEnabled();
 	}
	
	protected boolean isSaveDoctorScheduleListEnabled(Map<String,Object> options){
		return checkOptions(options, ExpenseTypeTokens.DOCTOR_SCHEDULE_LIST);
		
 	}
 	
		

	

	protected ExpenseTypeMapper getExpenseTypeMapper(){
		return new ExpenseTypeMapper();
	}

	
	
	protected ExpenseType extractExpenseType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ExpenseType expenseType = loadSingleObject(accessKey, getExpenseTypeMapper());
			return expenseType;
		}catch(EmptyResultDataAccessException e){
			throw new ExpenseTypeNotFoundException("ExpenseType("+accessKey+") is not found!");
		}

	}

	
	

	protected ExpenseType loadInternalExpenseType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ExpenseType expenseType = extractExpenseType(accessKey, loadOptions);
 	
 		if(isExtractHospitalEnabled(loadOptions)){
	 		extractHospital(expenseType, loadOptions);
 		}
 
		
		if(isExtractExpenseItemListEnabled(loadOptions)){
	 		extractExpenseItemList(expenseType, loadOptions);
 		}	
 		if(isAnalyzeExpenseItemListEnabled(loadOptions)){
	 		analyzeExpenseItemList(expenseType, loadOptions);
 		}
 		
		
		if(isExtractDoctorScheduleListEnabled(loadOptions)){
	 		extractDoctorScheduleList(expenseType, loadOptions);
 		}	
 		if(isAnalyzeDoctorScheduleListEnabled(loadOptions)){
	 		analyzeDoctorScheduleList(expenseType, loadOptions);
 		}
 		
		
		return expenseType;
		
	}

	 

 	protected ExpenseType extractHospital(ExpenseType expenseType, Map<String,Object> options) throws Exception{

		if(expenseType.getHospital() == null){
			return expenseType;
		}
		String hospitalId = expenseType.getHospital().getId();
		if( hospitalId == null){
			return expenseType;
		}
		Hospital hospital = getHospitalDAO().load(hospitalId,options);
		if(hospital != null){
			expenseType.setHospital(hospital);
		}
		
 		
 		return expenseType;
 	}
 		
 
		
	protected void enhanceExpenseItemList(SmartList<ExpenseItem> expenseItemList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ExpenseType extractExpenseItemList(ExpenseType expenseType, Map<String,Object> options){
		
		
		if(expenseType == null){
			return null;
		}
		if(expenseType.getId() == null){
			return expenseType;
		}

		
		
		SmartList<ExpenseItem> expenseItemList = getExpenseItemDAO().findExpenseItemByExpenseType(expenseType.getId(),options);
		if(expenseItemList != null){
			enhanceExpenseItemList(expenseItemList,options);
			expenseType.setExpenseItemList(expenseItemList);
		}
		
		return expenseType;
	
	}	
	
	protected ExpenseType analyzeExpenseItemList(ExpenseType expenseType, Map<String,Object> options){
		
		
		if(expenseType == null){
			return null;
		}
		if(expenseType.getId() == null){
			return expenseType;
		}

		
		
		SmartList<ExpenseItem> expenseItemList = expenseType.getExpenseItemList();
		if(expenseItemList != null){
			getExpenseItemDAO().analyzeExpenseItemByExpenseType(expenseItemList, expenseType.getId(), options);
			
		}
		
		return expenseType;
	
	}	
	
		
	protected void enhanceDoctorScheduleList(SmartList<DoctorSchedule> doctorScheduleList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ExpenseType extractDoctorScheduleList(ExpenseType expenseType, Map<String,Object> options){
		
		
		if(expenseType == null){
			return null;
		}
		if(expenseType.getId() == null){
			return expenseType;
		}

		
		
		SmartList<DoctorSchedule> doctorScheduleList = getDoctorScheduleDAO().findDoctorScheduleByExpenseType(expenseType.getId(),options);
		if(doctorScheduleList != null){
			enhanceDoctorScheduleList(doctorScheduleList,options);
			expenseType.setDoctorScheduleList(doctorScheduleList);
		}
		
		return expenseType;
	
	}	
	
	protected ExpenseType analyzeDoctorScheduleList(ExpenseType expenseType, Map<String,Object> options){
		
		
		if(expenseType == null){
			return null;
		}
		if(expenseType.getId() == null){
			return expenseType;
		}

		
		
		SmartList<DoctorSchedule> doctorScheduleList = expenseType.getDoctorScheduleList();
		if(doctorScheduleList != null){
			getDoctorScheduleDAO().analyzeDoctorScheduleByExpenseType(doctorScheduleList, expenseType.getId(), options);
			
		}
		
		return expenseType;
	
	}	
	
		
		
  	
 	public SmartList<ExpenseType> findExpenseTypeByHospital(String hospitalId,Map<String,Object> options){
 	
  		SmartList<ExpenseType> resultList = queryWith(ExpenseTypeTable.COLUMN_HOSPITAL, hospitalId, options, getExpenseTypeMapper());
		// analyzeExpenseTypeByHospital(resultList, hospitalId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ExpenseType> findExpenseTypeByHospital(String hospitalId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ExpenseType> resultList =  queryWithRange(ExpenseTypeTable.COLUMN_HOSPITAL, hospitalId, options, getExpenseTypeMapper(), start, count);
 		//analyzeExpenseTypeByHospital(resultList, hospitalId, options);
 		return resultList;
 		
 	}
 	public void analyzeExpenseTypeByHospital(SmartList<ExpenseType> resultList, String hospitalId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ExpenseType.HOSPITAL_PROPERTY, hospitalId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem updateTimeStatsItem = new StatsItem();
		//ExpenseType.UPDATE_TIME_PROPERTY
		updateTimeStatsItem.setDisplayName("费用类型");
		updateTimeStatsItem.setInternalName(formatKeyForDateLine(ExpenseType.UPDATE_TIME_PROPERTY));
		updateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ExpenseType.UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(updateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countExpenseTypeByHospital(String hospitalId,Map<String,Object> options){

 		return countWith(ExpenseTypeTable.COLUMN_HOSPITAL, hospitalId, options);
 	}
 	@Override
	public Map<String, Integer> countExpenseTypeByHospitalIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ExpenseTypeTable.COLUMN_HOSPITAL, ids, options);
	}
 	
 	
		
		
		

	

	protected ExpenseType saveExpenseType(ExpenseType  expenseType){
		
		if(!expenseType.isChanged()){
			return expenseType;
		}
		
		
		String SQL=this.getSaveExpenseTypeSQL(expenseType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveExpenseTypeParameters(expenseType);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		expenseType.incVersion();
		return expenseType;
	
	}
	public SmartList<ExpenseType> saveExpenseTypeList(SmartList<ExpenseType> expenseTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitExpenseTypeList(expenseTypeList);
		
		batchExpenseTypeCreate((List<ExpenseType>)lists[CREATE_LIST_INDEX]);
		
		batchExpenseTypeUpdate((List<ExpenseType>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ExpenseType expenseType:expenseTypeList){
			if(expenseType.isChanged()){
				expenseType.incVersion();
			}
			
		
		}
		
		
		return expenseTypeList;
	}

	public SmartList<ExpenseType> removeExpenseTypeList(SmartList<ExpenseType> expenseTypeList,Map<String,Object> options){
		
		
		super.removeList(expenseTypeList, options);
		
		return expenseTypeList;
		
		
	}
	
	protected List<Object[]> prepareExpenseTypeBatchCreateArgs(List<ExpenseType> expenseTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ExpenseType expenseType:expenseTypeList ){
			Object [] parameters = prepareExpenseTypeCreateParameters(expenseType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareExpenseTypeBatchUpdateArgs(List<ExpenseType> expenseTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ExpenseType expenseType:expenseTypeList ){
			if(!expenseType.isChanged()){
				continue;
			}
			Object [] parameters = prepareExpenseTypeUpdateParameters(expenseType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchExpenseTypeCreate(List<ExpenseType> expenseTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareExpenseTypeBatchCreateArgs(expenseTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchExpenseTypeUpdate(List<ExpenseType> expenseTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareExpenseTypeBatchUpdateArgs(expenseTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitExpenseTypeList(List<ExpenseType> expenseTypeList){
		
		List<ExpenseType> expenseTypeCreateList=new ArrayList<ExpenseType>();
		List<ExpenseType> expenseTypeUpdateList=new ArrayList<ExpenseType>();
		
		for(ExpenseType expenseType: expenseTypeList){
			if(isUpdateRequest(expenseType)){
				expenseTypeUpdateList.add( expenseType);
				continue;
			}
			expenseTypeCreateList.add(expenseType);
		}
		
		return new Object[]{expenseTypeCreateList,expenseTypeUpdateList};
	}
	
	protected boolean isUpdateRequest(ExpenseType expenseType){
 		return expenseType.getVersion() > 0;
 	}
 	protected String getSaveExpenseTypeSQL(ExpenseType expenseType){
 		if(isUpdateRequest(expenseType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveExpenseTypeParameters(ExpenseType expenseType){
 		if(isUpdateRequest(expenseType) ){
 			return prepareExpenseTypeUpdateParameters(expenseType);
 		}
 		return prepareExpenseTypeCreateParameters(expenseType);
 	}
 	protected Object[] prepareExpenseTypeUpdateParameters(ExpenseType expenseType){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = expenseType.getName();
 		parameters[1] = expenseType.getHelperChars();
 		parameters[2] = expenseType.getStatus(); 	
 		if(expenseType.getHospital() != null){
 			parameters[3] = expenseType.getHospital().getId();
 		}
 
 		parameters[4] = expenseType.getDescription();
 		parameters[5] = expenseType.getUpdateTime();		
 		parameters[6] = expenseType.nextVersion();
 		parameters[7] = expenseType.getId();
 		parameters[8] = expenseType.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareExpenseTypeCreateParameters(ExpenseType expenseType){
		Object[] parameters = new Object[7];
		String newExpenseTypeId=getNextId();
		expenseType.setId(newExpenseTypeId);
		parameters[0] =  expenseType.getId();
 
 		parameters[1] = expenseType.getName();
 		parameters[2] = expenseType.getHelperChars();
 		parameters[3] = expenseType.getStatus(); 	
 		if(expenseType.getHospital() != null){
 			parameters[4] = expenseType.getHospital().getId();
 		
 		}
 		
 		parameters[5] = expenseType.getDescription();
 		parameters[6] = expenseType.getUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected ExpenseType saveInternalExpenseType(ExpenseType expenseType, Map<String,Object> options){
		
		saveExpenseType(expenseType);
 	
 		if(isSaveHospitalEnabled(options)){
	 		saveHospital(expenseType, options);
 		}
 
		
		if(isSaveExpenseItemListEnabled(options)){
	 		saveExpenseItemList(expenseType, options);
	 		//removeExpenseItemList(expenseType, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveDoctorScheduleListEnabled(options)){
	 		saveDoctorScheduleList(expenseType, options);
	 		//removeDoctorScheduleList(expenseType, options);
	 		//Not delete the record
	 		
 		}		
		
		return expenseType;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ExpenseType saveHospital(ExpenseType expenseType, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(expenseType.getHospital() == null){
 			return expenseType;//do nothing when it is null
 		}
 		
 		getHospitalDAO().save(expenseType.getHospital(),options);
 		return expenseType;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public ExpenseType planToRemoveExpenseItemList(ExpenseType expenseType, String expenseItemIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ExpenseItem.EXPENSE_TYPE_PROPERTY, expenseType.getId());
		key.put(ExpenseItem.ID_PROPERTY, expenseItemIds);
		
		SmartList<ExpenseItem> externalExpenseItemList = getExpenseItemDAO().
				findExpenseItemWithKey(key, options);
		if(externalExpenseItemList == null){
			return expenseType;
		}
		if(externalExpenseItemList.isEmpty()){
			return expenseType;
		}
		
		for(ExpenseItem expenseItemItem: externalExpenseItemList){

			expenseItemItem.clearFromAll();
		}
		
		
		SmartList<ExpenseItem> expenseItemList = expenseType.getExpenseItemList();		
		expenseItemList.addAllToRemoveList(externalExpenseItemList);
		return expenseType;	
	
	}


	//disconnect ExpenseType with hospital in ExpenseItem
	public ExpenseType planToRemoveExpenseItemListWithHospital(ExpenseType expenseType, String hospitalId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ExpenseItem.EXPENSE_TYPE_PROPERTY, expenseType.getId());
		key.put(ExpenseItem.HOSPITAL_PROPERTY, hospitalId);
		
		SmartList<ExpenseItem> externalExpenseItemList = getExpenseItemDAO().
				findExpenseItemWithKey(key, options);
		if(externalExpenseItemList == null){
			return expenseType;
		}
		if(externalExpenseItemList.isEmpty()){
			return expenseType;
		}
		
		for(ExpenseItem expenseItemItem: externalExpenseItemList){
			expenseItemItem.clearHospital();
			expenseItemItem.clearExpenseType();
			
		}
		
		
		SmartList<ExpenseItem> expenseItemList = expenseType.getExpenseItemList();		
		expenseItemList.addAllToRemoveList(externalExpenseItemList);
		return expenseType;
	}
	
	public int countExpenseItemListWithHospital(String expenseTypeId, String hospitalId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ExpenseItem.EXPENSE_TYPE_PROPERTY, expenseTypeId);
		key.put(ExpenseItem.HOSPITAL_PROPERTY, hospitalId);
		
		int count = getExpenseItemDAO().countExpenseItemWithKey(key, options);
		return count;
	}
	
	public ExpenseType planToRemoveDoctorScheduleList(ExpenseType expenseType, String doctorScheduleIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, expenseType.getId());
		key.put(DoctorSchedule.ID_PROPERTY, doctorScheduleIds);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return expenseType;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return expenseType;
		}
		
		for(DoctorSchedule doctorScheduleItem: externalDoctorScheduleList){

			doctorScheduleItem.clearFromAll();
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = expenseType.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return expenseType;	
	
	}


	//disconnect ExpenseType with doctor in DoctorSchedule
	public ExpenseType planToRemoveDoctorScheduleListWithDoctor(ExpenseType expenseType, String doctorId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, expenseType.getId());
		key.put(DoctorSchedule.DOCTOR_PROPERTY, doctorId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return expenseType;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return expenseType;
		}
		
		for(DoctorSchedule doctorScheduleItem: externalDoctorScheduleList){
			doctorScheduleItem.clearDoctor();
			doctorScheduleItem.clearExpenseType();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = expenseType.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return expenseType;
	}
	
	public int countDoctorScheduleListWithDoctor(String expenseTypeId, String doctorId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, expenseTypeId);
		key.put(DoctorSchedule.DOCTOR_PROPERTY, doctorId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	
	//disconnect ExpenseType with period in DoctorSchedule
	public ExpenseType planToRemoveDoctorScheduleListWithPeriod(ExpenseType expenseType, String periodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, expenseType.getId());
		key.put(DoctorSchedule.PERIOD_PROPERTY, periodId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return expenseType;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return expenseType;
		}
		
		for(DoctorSchedule doctorScheduleItem: externalDoctorScheduleList){
			doctorScheduleItem.clearPeriod();
			doctorScheduleItem.clearExpenseType();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = expenseType.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return expenseType;
	}
	
	public int countDoctorScheduleListWithPeriod(String expenseTypeId, String periodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, expenseTypeId);
		key.put(DoctorSchedule.PERIOD_PROPERTY, periodId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	
	//disconnect ExpenseType with department in DoctorSchedule
	public ExpenseType planToRemoveDoctorScheduleListWithDepartment(ExpenseType expenseType, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, expenseType.getId());
		key.put(DoctorSchedule.DEPARTMENT_PROPERTY, departmentId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return expenseType;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return expenseType;
		}
		
		for(DoctorSchedule doctorScheduleItem: externalDoctorScheduleList){
			doctorScheduleItem.clearDepartment();
			doctorScheduleItem.clearExpenseType();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = expenseType.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return expenseType;
	}
	
	public int countDoctorScheduleListWithDepartment(String expenseTypeId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, expenseTypeId);
		key.put(DoctorSchedule.DEPARTMENT_PROPERTY, departmentId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	
	//disconnect ExpenseType with hospital in DoctorSchedule
	public ExpenseType planToRemoveDoctorScheduleListWithHospital(ExpenseType expenseType, String hospitalId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, expenseType.getId());
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, hospitalId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return expenseType;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return expenseType;
		}
		
		for(DoctorSchedule doctorScheduleItem: externalDoctorScheduleList){
			doctorScheduleItem.clearHospital();
			doctorScheduleItem.clearExpenseType();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = expenseType.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return expenseType;
	}
	
	public int countDoctorScheduleListWithHospital(String expenseTypeId, String hospitalId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, expenseTypeId);
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, hospitalId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	

		
	protected ExpenseType saveExpenseItemList(ExpenseType expenseType, Map<String,Object> options){
		
		
		
		
		SmartList<ExpenseItem> expenseItemList = expenseType.getExpenseItemList();
		if(expenseItemList == null){
			//null list means nothing
			return expenseType;
		}
		SmartList<ExpenseItem> mergedUpdateExpenseItemList = new SmartList<ExpenseItem>();
		
		
		mergedUpdateExpenseItemList.addAll(expenseItemList); 
		if(expenseItemList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateExpenseItemList.addAll(expenseItemList.getToRemoveList());
			expenseItemList.removeAll(expenseItemList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getExpenseItemDAO().saveExpenseItemList(mergedUpdateExpenseItemList,options);
		
		if(expenseItemList.getToRemoveList() != null){
			expenseItemList.removeAll(expenseItemList.getToRemoveList());
		}
		
		
		return expenseType;
	
	}
	
	protected ExpenseType removeExpenseItemList(ExpenseType expenseType, Map<String,Object> options){
	
	
		SmartList<ExpenseItem> expenseItemList = expenseType.getExpenseItemList();
		if(expenseItemList == null){
			return expenseType;
		}	
	
		SmartList<ExpenseItem> toRemoveExpenseItemList = expenseItemList.getToRemoveList();
		
		if(toRemoveExpenseItemList == null){
			return expenseType;
		}
		if(toRemoveExpenseItemList.isEmpty()){
			return expenseType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getExpenseItemDAO().removeExpenseItemList(toRemoveExpenseItemList,options);
		
		return expenseType;
	
	}
	
	

 	
 	
	
	
	
		
	protected ExpenseType saveDoctorScheduleList(ExpenseType expenseType, Map<String,Object> options){
		
		
		
		
		SmartList<DoctorSchedule> doctorScheduleList = expenseType.getDoctorScheduleList();
		if(doctorScheduleList == null){
			//null list means nothing
			return expenseType;
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
		
		
		return expenseType;
	
	}
	
	protected ExpenseType removeDoctorScheduleList(ExpenseType expenseType, Map<String,Object> options){
	
	
		SmartList<DoctorSchedule> doctorScheduleList = expenseType.getDoctorScheduleList();
		if(doctorScheduleList == null){
			return expenseType;
		}	
	
		SmartList<DoctorSchedule> toRemoveDoctorScheduleList = doctorScheduleList.getToRemoveList();
		
		if(toRemoveDoctorScheduleList == null){
			return expenseType;
		}
		if(toRemoveDoctorScheduleList.isEmpty()){
			return expenseType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getDoctorScheduleDAO().removeDoctorScheduleList(toRemoveDoctorScheduleList,options);
		
		return expenseType;
	
	}
	
	

 	
 	
	
	
	
		

	public ExpenseType present(ExpenseType expenseType,Map<String, Object> options){
	
		presentExpenseItemList(expenseType,options);
		presentDoctorScheduleList(expenseType,options);

		return expenseType;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected ExpenseType presentExpenseItemList(
			ExpenseType expenseType,
			Map<String, Object> options) {

		SmartList<ExpenseItem> expenseItemList = expenseType.getExpenseItemList();		
				SmartList<ExpenseItem> newList= presentSubList(expenseType.getId(),
				expenseItemList,
				options,
				getExpenseItemDAO()::countExpenseItemByExpenseType,
				getExpenseItemDAO()::findExpenseItemByExpenseType
				);

		
		expenseType.setExpenseItemList(newList);
		

		return expenseType;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected ExpenseType presentDoctorScheduleList(
			ExpenseType expenseType,
			Map<String, Object> options) {

		SmartList<DoctorSchedule> doctorScheduleList = expenseType.getDoctorScheduleList();		
				SmartList<DoctorSchedule> newList= presentSubList(expenseType.getId(),
				doctorScheduleList,
				options,
				getDoctorScheduleDAO()::countDoctorScheduleByExpenseType,
				getDoctorScheduleDAO()::findDoctorScheduleByExpenseType
				);

		
		expenseType.setDoctorScheduleList(newList);
		

		return expenseType;
	}			
		

	
    public SmartList<ExpenseType> requestCandidateExpenseTypeForExpenseItem(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ExpenseTypeTable.COLUMN_NAME, filterKey, pageNo, pageSize, getExpenseTypeMapper());
    }
		
    public SmartList<ExpenseType> requestCandidateExpenseTypeForDoctorSchedule(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ExpenseTypeTable.COLUMN_NAME, filterKey, pageNo, pageSize, getExpenseTypeMapper());
    }
		

	protected String getTableName(){
		return ExpenseTypeTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ExpenseType> expenseTypeList) {		
		this.enhanceListInternal(expenseTypeList, this.getExpenseTypeMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:ExpenseItem的expenseType的ExpenseItemList
	public SmartList<ExpenseItem> loadOurExpenseItemList(HisUserContext userContext, List<ExpenseType> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ExpenseItem.EXPENSE_TYPE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ExpenseItem> loadedObjs = userContext.getDAOGroup().getExpenseItemDAO().findExpenseItemWithKey(key, options);
		Map<String, List<ExpenseItem>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getExpenseType().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ExpenseItem> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ExpenseItem> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setExpenseItemList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:DoctorSchedule的expenseType的DoctorScheduleList
	public SmartList<DoctorSchedule> loadOurDoctorScheduleList(HisUserContext userContext, List<ExpenseType> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<DoctorSchedule> loadedObjs = userContext.getDAOGroup().getDoctorScheduleDAO().findDoctorScheduleWithKey(key, options);
		Map<String, List<DoctorSchedule>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getExpenseType().getId()));
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
		List<ExpenseType> expenseTypeList = ownerEntity.collectRefsWithType(ExpenseType.INTERNAL_TYPE);
		this.enhanceList(expenseTypeList);
		
	}
	
	@Override
	public SmartList<ExpenseType> findExpenseTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getExpenseTypeMapper());

	}
	@Override
	public int countExpenseTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countExpenseTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ExpenseType> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getExpenseTypeMapper());
	}
	
	

}


