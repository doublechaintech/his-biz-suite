
package com.panfeng.his.expenseitem;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.panfeng.his.HisNamingServiceDAO;
import com.panfeng.his.BaseEntity;
import com.panfeng.his.SmartList;
import com.panfeng.his.AccessKey;
import com.panfeng.his.DateKey;
import com.panfeng.his.StatsInfo;
import com.panfeng.his.StatsItem;

import com.panfeng.his.MultipleAccessKey;
import com.panfeng.his.HisUserContext;


import com.panfeng.his.hospital.Hospital;
import com.panfeng.his.expensetype.ExpenseType;

import com.panfeng.his.hospital.HospitalDAO;
import com.panfeng.his.expensetype.ExpenseTypeDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class ExpenseItemJDBCTemplateDAO extends HisNamingServiceDAO implements ExpenseItemDAO{
 
 	
 	private  ExpenseTypeDAO  expenseTypeDAO;
 	public void setExpenseTypeDAO(ExpenseTypeDAO expenseTypeDAO){
	 	this.expenseTypeDAO = expenseTypeDAO;
 	}
 	public ExpenseTypeDAO getExpenseTypeDAO(){
	 	return this.expenseTypeDAO;
 	}
 
 	
 	private  HospitalDAO  hospitalDAO;
 	public void setHospitalDAO(HospitalDAO hospitalDAO){
	 	this.hospitalDAO = hospitalDAO;
 	}
 	public HospitalDAO getHospitalDAO(){
	 	return this.hospitalDAO;
 	}


			
		

	
	/*
	protected ExpenseItem load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalExpenseItem(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ExpenseItem load(String id,Map<String,Object> options) throws Exception{
		return loadInternalExpenseItem(ExpenseItemTable.withId(id), options);
	}
	
	
	
	public ExpenseItem save(ExpenseItem expenseItem,Map<String,Object> options){
		
		String methodName="save(ExpenseItem expenseItem,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(expenseItem, methodName, "expenseItem");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalExpenseItem(expenseItem,options);
	}
	public ExpenseItem clone(String expenseItemId, Map<String,Object> options) throws Exception{
	
		return clone(ExpenseItemTable.withId(expenseItemId),options);
	}
	
	protected ExpenseItem clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String expenseItemId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ExpenseItem newExpenseItem = loadInternalExpenseItem(accessKey, options);
		newExpenseItem.setVersion(0);
		
		

		
		saveInternalExpenseItem(newExpenseItem,options);
		
		return newExpenseItem;
	}
	
	
	
	

	protected void throwIfHasException(String expenseItemId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ExpenseItemVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ExpenseItemNotFoundException(
					"The " + this.getTableName() + "(" + expenseItemId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String expenseItemId, int version) throws Exception{
	
		String methodName="delete(String expenseItemId, int version)";
		assertMethodArgumentNotNull(expenseItemId, methodName, "expenseItemId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{expenseItemId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(expenseItemId,version);
		}
		
	
	}
	
	
	
	
	

	public ExpenseItem disconnectFromAll(String expenseItemId, int version) throws Exception{
	
		
		ExpenseItem expenseItem = loadInternalExpenseItem(ExpenseItemTable.withId(expenseItemId), emptyOptions());
		expenseItem.clearFromAll();
		this.saveExpenseItem(expenseItem);
		return expenseItem;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ExpenseItemTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "expense_item";
	}
	@Override
	protected String getBeanName() {
		
		return "expenseItem";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ExpenseItemTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractExpenseTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ExpenseItemTokens.EXPENSETYPE);
 	}

 	protected boolean isSaveExpenseTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ExpenseItemTokens.EXPENSETYPE);
 	}
 	

 	
  

 	protected boolean isExtractHospitalEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ExpenseItemTokens.HOSPITAL);
 	}

 	protected boolean isSaveHospitalEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ExpenseItemTokens.HOSPITAL);
 	}
 	

 	
 
		

	

	protected ExpenseItemMapper getExpenseItemMapper(){
		return new ExpenseItemMapper();
	}

	
	
	protected ExpenseItem extractExpenseItem(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ExpenseItem expenseItem = loadSingleObject(accessKey, getExpenseItemMapper());
			return expenseItem;
		}catch(EmptyResultDataAccessException e){
			throw new ExpenseItemNotFoundException("ExpenseItem("+accessKey+") is not found!");
		}

	}

	
	

	protected ExpenseItem loadInternalExpenseItem(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ExpenseItem expenseItem = extractExpenseItem(accessKey, loadOptions);
 	
 		if(isExtractExpenseTypeEnabled(loadOptions)){
	 		extractExpenseType(expenseItem, loadOptions);
 		}
  	
 		if(isExtractHospitalEnabled(loadOptions)){
	 		extractHospital(expenseItem, loadOptions);
 		}
 
		
		return expenseItem;
		
	}

	 

 	protected ExpenseItem extractExpenseType(ExpenseItem expenseItem, Map<String,Object> options) throws Exception{

		if(expenseItem.getExpenseType() == null){
			return expenseItem;
		}
		String expenseTypeId = expenseItem.getExpenseType().getId();
		if( expenseTypeId == null){
			return expenseItem;
		}
		ExpenseType expenseType = getExpenseTypeDAO().load(expenseTypeId,options);
		if(expenseType != null){
			expenseItem.setExpenseType(expenseType);
		}
		
 		
 		return expenseItem;
 	}
 		
  

 	protected ExpenseItem extractHospital(ExpenseItem expenseItem, Map<String,Object> options) throws Exception{

		if(expenseItem.getHospital() == null){
			return expenseItem;
		}
		String hospitalId = expenseItem.getHospital().getId();
		if( hospitalId == null){
			return expenseItem;
		}
		Hospital hospital = getHospitalDAO().load(hospitalId,options);
		if(hospital != null){
			expenseItem.setHospital(hospital);
		}
		
 		
 		return expenseItem;
 	}
 		
 
		
		
  	
 	public SmartList<ExpenseItem> findExpenseItemByExpenseType(String expenseTypeId,Map<String,Object> options){
 	
  		SmartList<ExpenseItem> resultList = queryWith(ExpenseItemTable.COLUMN_EXPENSE_TYPE, expenseTypeId, options, getExpenseItemMapper());
		// analyzeExpenseItemByExpenseType(resultList, expenseTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ExpenseItem> findExpenseItemByExpenseType(String expenseTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ExpenseItem> resultList =  queryWithRange(ExpenseItemTable.COLUMN_EXPENSE_TYPE, expenseTypeId, options, getExpenseItemMapper(), start, count);
 		//analyzeExpenseItemByExpenseType(resultList, expenseTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzeExpenseItemByExpenseType(SmartList<ExpenseItem> resultList, String expenseTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ExpenseItem.EXPENSE_TYPE_PROPERTY, expenseTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countExpenseItemByExpenseType(String expenseTypeId,Map<String,Object> options){

 		return countWith(ExpenseItemTable.COLUMN_EXPENSE_TYPE, expenseTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countExpenseItemByExpenseTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ExpenseItemTable.COLUMN_EXPENSE_TYPE, ids, options);
	}
 	
  	
 	public SmartList<ExpenseItem> findExpenseItemByHospital(String hospitalId,Map<String,Object> options){
 	
  		SmartList<ExpenseItem> resultList = queryWith(ExpenseItemTable.COLUMN_HOSPITAL, hospitalId, options, getExpenseItemMapper());
		// analyzeExpenseItemByHospital(resultList, hospitalId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ExpenseItem> findExpenseItemByHospital(String hospitalId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ExpenseItem> resultList =  queryWithRange(ExpenseItemTable.COLUMN_HOSPITAL, hospitalId, options, getExpenseItemMapper(), start, count);
 		//analyzeExpenseItemByHospital(resultList, hospitalId, options);
 		return resultList;
 		
 	}
 	public void analyzeExpenseItemByHospital(SmartList<ExpenseItem> resultList, String hospitalId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ExpenseItem.HOSPITAL_PROPERTY, hospitalId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countExpenseItemByHospital(String hospitalId,Map<String,Object> options){

 		return countWith(ExpenseItemTable.COLUMN_HOSPITAL, hospitalId, options);
 	}
 	@Override
	public Map<String, Integer> countExpenseItemByHospitalIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ExpenseItemTable.COLUMN_HOSPITAL, ids, options);
	}
 	
 	
		
		
		

	

	protected ExpenseItem saveExpenseItem(ExpenseItem  expenseItem){
		
		if(!expenseItem.isChanged()){
			return expenseItem;
		}
		
		
		String SQL=this.getSaveExpenseItemSQL(expenseItem);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveExpenseItemParameters(expenseItem);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		expenseItem.incVersion();
		return expenseItem;
	
	}
	public SmartList<ExpenseItem> saveExpenseItemList(SmartList<ExpenseItem> expenseItemList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitExpenseItemList(expenseItemList);
		
		batchExpenseItemCreate((List<ExpenseItem>)lists[CREATE_LIST_INDEX]);
		
		batchExpenseItemUpdate((List<ExpenseItem>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ExpenseItem expenseItem:expenseItemList){
			if(expenseItem.isChanged()){
				expenseItem.incVersion();
			}
			
		
		}
		
		
		return expenseItemList;
	}

	public SmartList<ExpenseItem> removeExpenseItemList(SmartList<ExpenseItem> expenseItemList,Map<String,Object> options){
		
		
		super.removeList(expenseItemList, options);
		
		return expenseItemList;
		
		
	}
	
	protected List<Object[]> prepareExpenseItemBatchCreateArgs(List<ExpenseItem> expenseItemList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ExpenseItem expenseItem:expenseItemList ){
			Object [] parameters = prepareExpenseItemCreateParameters(expenseItem);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareExpenseItemBatchUpdateArgs(List<ExpenseItem> expenseItemList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ExpenseItem expenseItem:expenseItemList ){
			if(!expenseItem.isChanged()){
				continue;
			}
			Object [] parameters = prepareExpenseItemUpdateParameters(expenseItem);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchExpenseItemCreate(List<ExpenseItem> expenseItemList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareExpenseItemBatchCreateArgs(expenseItemList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchExpenseItemUpdate(List<ExpenseItem> expenseItemList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareExpenseItemBatchUpdateArgs(expenseItemList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitExpenseItemList(List<ExpenseItem> expenseItemList){
		
		List<ExpenseItem> expenseItemCreateList=new ArrayList<ExpenseItem>();
		List<ExpenseItem> expenseItemUpdateList=new ArrayList<ExpenseItem>();
		
		for(ExpenseItem expenseItem: expenseItemList){
			if(isUpdateRequest(expenseItem)){
				expenseItemUpdateList.add( expenseItem);
				continue;
			}
			expenseItemCreateList.add(expenseItem);
		}
		
		return new Object[]{expenseItemCreateList,expenseItemUpdateList};
	}
	
	protected boolean isUpdateRequest(ExpenseItem expenseItem){
 		return expenseItem.getVersion() > 0;
 	}
 	protected String getSaveExpenseItemSQL(ExpenseItem expenseItem){
 		if(isUpdateRequest(expenseItem)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveExpenseItemParameters(ExpenseItem expenseItem){
 		if(isUpdateRequest(expenseItem) ){
 			return prepareExpenseItemUpdateParameters(expenseItem);
 		}
 		return prepareExpenseItemCreateParameters(expenseItem);
 	}
 	protected Object[] prepareExpenseItemUpdateParameters(ExpenseItem expenseItem){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = expenseItem.getName();
 		parameters[1] = expenseItem.getPrice(); 	
 		if(expenseItem.getExpenseType() != null){
 			parameters[2] = expenseItem.getExpenseType().getId();
 		}
  	
 		if(expenseItem.getHospital() != null){
 			parameters[3] = expenseItem.getHospital().getId();
 		}
 		
 		parameters[4] = expenseItem.nextVersion();
 		parameters[5] = expenseItem.getId();
 		parameters[6] = expenseItem.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareExpenseItemCreateParameters(ExpenseItem expenseItem){
		Object[] parameters = new Object[5];
		String newExpenseItemId=getNextId();
		expenseItem.setId(newExpenseItemId);
		parameters[0] =  expenseItem.getId();
 
 		parameters[1] = expenseItem.getName();
 		parameters[2] = expenseItem.getPrice(); 	
 		if(expenseItem.getExpenseType() != null){
 			parameters[3] = expenseItem.getExpenseType().getId();
 		
 		}
 		 	
 		if(expenseItem.getHospital() != null){
 			parameters[4] = expenseItem.getHospital().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected ExpenseItem saveInternalExpenseItem(ExpenseItem expenseItem, Map<String,Object> options){
		
		saveExpenseItem(expenseItem);
 	
 		if(isSaveExpenseTypeEnabled(options)){
	 		saveExpenseType(expenseItem, options);
 		}
  	
 		if(isSaveHospitalEnabled(options)){
	 		saveHospital(expenseItem, options);
 		}
 
		
		return expenseItem;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ExpenseItem saveExpenseType(ExpenseItem expenseItem, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(expenseItem.getExpenseType() == null){
 			return expenseItem;//do nothing when it is null
 		}
 		
 		getExpenseTypeDAO().save(expenseItem.getExpenseType(),options);
 		return expenseItem;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ExpenseItem saveHospital(ExpenseItem expenseItem, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(expenseItem.getHospital() == null){
 			return expenseItem;//do nothing when it is null
 		}
 		
 		getHospitalDAO().save(expenseItem.getHospital(),options);
 		return expenseItem;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public ExpenseItem present(ExpenseItem expenseItem,Map<String, Object> options){
	

		return expenseItem;
	
	}
		

	

	protected String getTableName(){
		return ExpenseItemTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ExpenseItem> expenseItemList) {		
		this.enhanceListInternal(expenseItemList, this.getExpenseItemMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ExpenseItem> expenseItemList = ownerEntity.collectRefsWithType(ExpenseItem.INTERNAL_TYPE);
		this.enhanceList(expenseItemList);
		
	}
	
	@Override
	public SmartList<ExpenseItem> findExpenseItemWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getExpenseItemMapper());

	}
	@Override
	public int countExpenseItemWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countExpenseItemWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ExpenseItem> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getExpenseItemMapper());
	}
}


