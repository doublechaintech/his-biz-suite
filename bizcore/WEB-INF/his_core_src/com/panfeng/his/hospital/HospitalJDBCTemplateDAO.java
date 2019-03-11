
package com.panfeng.his.hospital;

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


import com.panfeng.his.doctor.Doctor;
import com.panfeng.his.expenseitem.ExpenseItem;
import com.panfeng.his.department.Department;
import com.panfeng.his.expensetype.ExpenseType;

import com.panfeng.his.expenseitem.ExpenseItemDAO;
import com.panfeng.his.department.DepartmentDAO;
import com.panfeng.his.expensetype.ExpenseTypeDAO;
import com.panfeng.his.doctor.DoctorDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class HospitalJDBCTemplateDAO extends HisNamingServiceDAO implements HospitalDAO{


			
		
	
  	private  ExpenseTypeDAO  expenseTypeDAO;
 	public void setExpenseTypeDAO(ExpenseTypeDAO pExpenseTypeDAO){
 	
 		if(pExpenseTypeDAO == null){
 			throw new IllegalStateException("Do not try to set expenseTypeDAO to null.");
 		}
	 	this.expenseTypeDAO = pExpenseTypeDAO;
 	}
 	public ExpenseTypeDAO getExpenseTypeDAO(){
 		if(this.expenseTypeDAO == null){
 			throw new IllegalStateException("The expenseTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.expenseTypeDAO;
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
 	
			
		
	
  	private  DepartmentDAO  departmentDAO;
 	public void setDepartmentDAO(DepartmentDAO pDepartmentDAO){
 	
 		if(pDepartmentDAO == null){
 			throw new IllegalStateException("Do not try to set departmentDAO to null.");
 		}
	 	this.departmentDAO = pDepartmentDAO;
 	}
 	public DepartmentDAO getDepartmentDAO(){
 		if(this.departmentDAO == null){
 			throw new IllegalStateException("The departmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.departmentDAO;
 	}	
 	
			
		

	
	/*
	protected Hospital load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalHospital(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Hospital load(String id,Map<String,Object> options) throws Exception{
		return loadInternalHospital(HospitalTable.withId(id), options);
	}
	
	
	
	public Hospital save(Hospital hospital,Map<String,Object> options){
		
		String methodName="save(Hospital hospital,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(hospital, methodName, "hospital");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalHospital(hospital,options);
	}
	public Hospital clone(String hospitalId, Map<String,Object> options) throws Exception{
	
		return clone(HospitalTable.withId(hospitalId),options);
	}
	
	protected Hospital clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String hospitalId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Hospital newHospital = loadInternalHospital(accessKey, options);
		newHospital.setVersion(0);
		
		
 		
 		if(isSaveExpenseTypeListEnabled(options)){
 			for(ExpenseType item: newHospital.getExpenseTypeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveExpenseItemListEnabled(options)){
 			for(ExpenseItem item: newHospital.getExpenseItemList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveDoctorListEnabled(options)){
 			for(Doctor item: newHospital.getDoctorList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveDepartmentListEnabled(options)){
 			for(Department item: newHospital.getDepartmentList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalHospital(newHospital,options);
		
		return newHospital;
	}
	
	
	
	

	protected void throwIfHasException(String hospitalId,int version,int count) throws Exception{
		if (count == 1) {
			throw new HospitalVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new HospitalNotFoundException(
					"The " + this.getTableName() + "(" + hospitalId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String hospitalId, int version) throws Exception{
	
		String methodName="delete(String hospitalId, int version)";
		assertMethodArgumentNotNull(hospitalId, methodName, "hospitalId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{hospitalId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(hospitalId,version);
		}
		
	
	}
	
	
	
	
	

	public Hospital disconnectFromAll(String hospitalId, int version) throws Exception{
	
		
		Hospital hospital = loadInternalHospital(HospitalTable.withId(hospitalId), emptyOptions());
		hospital.clearFromAll();
		this.saveHospital(hospital);
		return hospital;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return HospitalTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "hospital";
	}
	@Override
	protected String getBeanName() {
		
		return "hospital";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return HospitalTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractExpenseTypeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,HospitalTokens.EXPENSE_TYPE_LIST);
 	}
 	protected boolean isAnalyzeExpenseTypeListEnabled(Map<String,Object> options){		 		
 		return HospitalTokens.of(options).analyzeExpenseTypeListEnabled();
 	}
	
	protected boolean isSaveExpenseTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, HospitalTokens.EXPENSE_TYPE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractExpenseItemListEnabled(Map<String,Object> options){		
 		return checkOptions(options,HospitalTokens.EXPENSE_ITEM_LIST);
 	}
 	protected boolean isAnalyzeExpenseItemListEnabled(Map<String,Object> options){		 		
 		return HospitalTokens.of(options).analyzeExpenseItemListEnabled();
 	}
	
	protected boolean isSaveExpenseItemListEnabled(Map<String,Object> options){
		return checkOptions(options, HospitalTokens.EXPENSE_ITEM_LIST);
		
 	}
 	
		
	
	protected boolean isExtractDoctorListEnabled(Map<String,Object> options){		
 		return checkOptions(options,HospitalTokens.DOCTOR_LIST);
 	}
 	protected boolean isAnalyzeDoctorListEnabled(Map<String,Object> options){		 		
 		return HospitalTokens.of(options).analyzeDoctorListEnabled();
 	}
	
	protected boolean isSaveDoctorListEnabled(Map<String,Object> options){
		return checkOptions(options, HospitalTokens.DOCTOR_LIST);
		
 	}
 	
		
	
	protected boolean isExtractDepartmentListEnabled(Map<String,Object> options){		
 		return checkOptions(options,HospitalTokens.DEPARTMENT_LIST);
 	}
 	protected boolean isAnalyzeDepartmentListEnabled(Map<String,Object> options){		 		
 		return HospitalTokens.of(options).analyzeDepartmentListEnabled();
 	}
	
	protected boolean isSaveDepartmentListEnabled(Map<String,Object> options){
		return checkOptions(options, HospitalTokens.DEPARTMENT_LIST);
		
 	}
 	
		

	

	protected HospitalMapper getHospitalMapper(){
		return new HospitalMapper();
	}

	
	
	protected Hospital extractHospital(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Hospital hospital = loadSingleObject(accessKey, getHospitalMapper());
			return hospital;
		}catch(EmptyResultDataAccessException e){
			throw new HospitalNotFoundException("Hospital("+accessKey+") is not found!");
		}

	}

	
	

	protected Hospital loadInternalHospital(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Hospital hospital = extractHospital(accessKey, loadOptions);

		
		if(isExtractExpenseTypeListEnabled(loadOptions)){
	 		extractExpenseTypeList(hospital, loadOptions);
 		}	
 		if(isAnalyzeExpenseTypeListEnabled(loadOptions)){
	 		analyzeExpenseTypeList(hospital, loadOptions);
 		}
 		
		
		if(isExtractExpenseItemListEnabled(loadOptions)){
	 		extractExpenseItemList(hospital, loadOptions);
 		}	
 		if(isAnalyzeExpenseItemListEnabled(loadOptions)){
	 		analyzeExpenseItemList(hospital, loadOptions);
 		}
 		
		
		if(isExtractDoctorListEnabled(loadOptions)){
	 		extractDoctorList(hospital, loadOptions);
 		}	
 		if(isAnalyzeDoctorListEnabled(loadOptions)){
	 		analyzeDoctorList(hospital, loadOptions);
 		}
 		
		
		if(isExtractDepartmentListEnabled(loadOptions)){
	 		extractDepartmentList(hospital, loadOptions);
 		}	
 		if(isAnalyzeDepartmentListEnabled(loadOptions)){
	 		analyzeDepartmentList(hospital, loadOptions);
 		}
 		
		
		return hospital;
		
	}

	
		
	protected void enhanceExpenseTypeList(SmartList<ExpenseType> expenseTypeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Hospital extractExpenseTypeList(Hospital hospital, Map<String,Object> options){
		
		
		if(hospital == null){
			return null;
		}
		if(hospital.getId() == null){
			return hospital;
		}

		
		
		SmartList<ExpenseType> expenseTypeList = getExpenseTypeDAO().findExpenseTypeByHospital(hospital.getId(),options);
		if(expenseTypeList != null){
			enhanceExpenseTypeList(expenseTypeList,options);
			hospital.setExpenseTypeList(expenseTypeList);
		}
		
		return hospital;
	
	}	
	
	protected Hospital analyzeExpenseTypeList(Hospital hospital, Map<String,Object> options){
		
		
		if(hospital == null){
			return null;
		}
		if(hospital.getId() == null){
			return hospital;
		}

		
		
		SmartList<ExpenseType> expenseTypeList = hospital.getExpenseTypeList();
		if(expenseTypeList != null){
			getExpenseTypeDAO().analyzeExpenseTypeByHospital(expenseTypeList, hospital.getId(), options);
			
		}
		
		return hospital;
	
	}	
	
		
	protected void enhanceExpenseItemList(SmartList<ExpenseItem> expenseItemList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Hospital extractExpenseItemList(Hospital hospital, Map<String,Object> options){
		
		
		if(hospital == null){
			return null;
		}
		if(hospital.getId() == null){
			return hospital;
		}

		
		
		SmartList<ExpenseItem> expenseItemList = getExpenseItemDAO().findExpenseItemByHospital(hospital.getId(),options);
		if(expenseItemList != null){
			enhanceExpenseItemList(expenseItemList,options);
			hospital.setExpenseItemList(expenseItemList);
		}
		
		return hospital;
	
	}	
	
	protected Hospital analyzeExpenseItemList(Hospital hospital, Map<String,Object> options){
		
		
		if(hospital == null){
			return null;
		}
		if(hospital.getId() == null){
			return hospital;
		}

		
		
		SmartList<ExpenseItem> expenseItemList = hospital.getExpenseItemList();
		if(expenseItemList != null){
			getExpenseItemDAO().analyzeExpenseItemByHospital(expenseItemList, hospital.getId(), options);
			
		}
		
		return hospital;
	
	}	
	
		
	protected void enhanceDoctorList(SmartList<Doctor> doctorList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Hospital extractDoctorList(Hospital hospital, Map<String,Object> options){
		
		
		if(hospital == null){
			return null;
		}
		if(hospital.getId() == null){
			return hospital;
		}

		
		
		SmartList<Doctor> doctorList = getDoctorDAO().findDoctorByHospital(hospital.getId(),options);
		if(doctorList != null){
			enhanceDoctorList(doctorList,options);
			hospital.setDoctorList(doctorList);
		}
		
		return hospital;
	
	}	
	
	protected Hospital analyzeDoctorList(Hospital hospital, Map<String,Object> options){
		
		
		if(hospital == null){
			return null;
		}
		if(hospital.getId() == null){
			return hospital;
		}

		
		
		SmartList<Doctor> doctorList = hospital.getDoctorList();
		if(doctorList != null){
			getDoctorDAO().analyzeDoctorByHospital(doctorList, hospital.getId(), options);
			
		}
		
		return hospital;
	
	}	
	
		
	protected void enhanceDepartmentList(SmartList<Department> departmentList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Hospital extractDepartmentList(Hospital hospital, Map<String,Object> options){
		
		
		if(hospital == null){
			return null;
		}
		if(hospital.getId() == null){
			return hospital;
		}

		
		
		SmartList<Department> departmentList = getDepartmentDAO().findDepartmentByHospital(hospital.getId(),options);
		if(departmentList != null){
			enhanceDepartmentList(departmentList,options);
			hospital.setDepartmentList(departmentList);
		}
		
		return hospital;
	
	}	
	
	protected Hospital analyzeDepartmentList(Hospital hospital, Map<String,Object> options){
		
		
		if(hospital == null){
			return null;
		}
		if(hospital.getId() == null){
			return hospital;
		}

		
		
		SmartList<Department> departmentList = hospital.getDepartmentList();
		if(departmentList != null){
			getDepartmentDAO().analyzeDepartmentByHospital(departmentList, hospital.getId(), options);
			
		}
		
		return hospital;
	
	}	
	
		
		
 	
		
		
		

	

	protected Hospital saveHospital(Hospital  hospital){
		
		if(!hospital.isChanged()){
			return hospital;
		}
		
		
		String SQL=this.getSaveHospitalSQL(hospital);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveHospitalParameters(hospital);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		hospital.incVersion();
		return hospital;
	
	}
	public SmartList<Hospital> saveHospitalList(SmartList<Hospital> hospitalList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitHospitalList(hospitalList);
		
		batchHospitalCreate((List<Hospital>)lists[CREATE_LIST_INDEX]);
		
		batchHospitalUpdate((List<Hospital>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Hospital hospital:hospitalList){
			if(hospital.isChanged()){
				hospital.incVersion();
			}
			
		
		}
		
		
		return hospitalList;
	}

	public SmartList<Hospital> removeHospitalList(SmartList<Hospital> hospitalList,Map<String,Object> options){
		
		
		super.removeList(hospitalList, options);
		
		return hospitalList;
		
		
	}
	
	protected List<Object[]> prepareHospitalBatchCreateArgs(List<Hospital> hospitalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Hospital hospital:hospitalList ){
			Object [] parameters = prepareHospitalCreateParameters(hospital);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareHospitalBatchUpdateArgs(List<Hospital> hospitalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Hospital hospital:hospitalList ){
			if(!hospital.isChanged()){
				continue;
			}
			Object [] parameters = prepareHospitalUpdateParameters(hospital);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchHospitalCreate(List<Hospital> hospitalList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareHospitalBatchCreateArgs(hospitalList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchHospitalUpdate(List<Hospital> hospitalList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareHospitalBatchUpdateArgs(hospitalList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitHospitalList(List<Hospital> hospitalList){
		
		List<Hospital> hospitalCreateList=new ArrayList<Hospital>();
		List<Hospital> hospitalUpdateList=new ArrayList<Hospital>();
		
		for(Hospital hospital: hospitalList){
			if(isUpdateRequest(hospital)){
				hospitalUpdateList.add( hospital);
				continue;
			}
			hospitalCreateList.add(hospital);
		}
		
		return new Object[]{hospitalCreateList,hospitalUpdateList};
	}
	
	protected boolean isUpdateRequest(Hospital hospital){
 		return hospital.getVersion() > 0;
 	}
 	protected String getSaveHospitalSQL(Hospital hospital){
 		if(isUpdateRequest(hospital)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveHospitalParameters(Hospital hospital){
 		if(isUpdateRequest(hospital) ){
 			return prepareHospitalUpdateParameters(hospital);
 		}
 		return prepareHospitalCreateParameters(hospital);
 	}
 	protected Object[] prepareHospitalUpdateParameters(Hospital hospital){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = hospital.getName();
 		parameters[1] = hospital.getAddress();
 		parameters[2] = hospital.getTelephone();		
 		parameters[3] = hospital.nextVersion();
 		parameters[4] = hospital.getId();
 		parameters[5] = hospital.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareHospitalCreateParameters(Hospital hospital){
		Object[] parameters = new Object[4];
		String newHospitalId=getNextId();
		hospital.setId(newHospitalId);
		parameters[0] =  hospital.getId();
 
 		parameters[1] = hospital.getName();
 		parameters[2] = hospital.getAddress();
 		parameters[3] = hospital.getTelephone();		
 				
 		return parameters;
 	}
 	
	protected Hospital saveInternalHospital(Hospital hospital, Map<String,Object> options){
		
		saveHospital(hospital);

		
		if(isSaveExpenseTypeListEnabled(options)){
	 		saveExpenseTypeList(hospital, options);
	 		//removeExpenseTypeList(hospital, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveExpenseItemListEnabled(options)){
	 		saveExpenseItemList(hospital, options);
	 		//removeExpenseItemList(hospital, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveDoctorListEnabled(options)){
	 		saveDoctorList(hospital, options);
	 		//removeDoctorList(hospital, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveDepartmentListEnabled(options)){
	 		saveDepartmentList(hospital, options);
	 		//removeDepartmentList(hospital, options);
	 		//Not delete the record
	 		
 		}		
		
		return hospital;
		
	}
	
	
	
	//======================================================================================
	

	
	public Hospital planToRemoveExpenseTypeList(Hospital hospital, String expenseTypeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ExpenseType.HOSPITAL_PROPERTY, hospital.getId());
		key.put(ExpenseType.ID_PROPERTY, expenseTypeIds);
		
		SmartList<ExpenseType> externalExpenseTypeList = getExpenseTypeDAO().
				findExpenseTypeWithKey(key, options);
		if(externalExpenseTypeList == null){
			return hospital;
		}
		if(externalExpenseTypeList.isEmpty()){
			return hospital;
		}
		
		for(ExpenseType expenseType: externalExpenseTypeList){

			expenseType.clearFromAll();
		}
		
		
		SmartList<ExpenseType> expenseTypeList = hospital.getExpenseTypeList();		
		expenseTypeList.addAllToRemoveList(externalExpenseTypeList);
		return hospital;	
	
	}


	public Hospital planToRemoveExpenseItemList(Hospital hospital, String expenseItemIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ExpenseItem.HOSPITAL_PROPERTY, hospital.getId());
		key.put(ExpenseItem.ID_PROPERTY, expenseItemIds);
		
		SmartList<ExpenseItem> externalExpenseItemList = getExpenseItemDAO().
				findExpenseItemWithKey(key, options);
		if(externalExpenseItemList == null){
			return hospital;
		}
		if(externalExpenseItemList.isEmpty()){
			return hospital;
		}
		
		for(ExpenseItem expenseItem: externalExpenseItemList){

			expenseItem.clearFromAll();
		}
		
		
		SmartList<ExpenseItem> expenseItemList = hospital.getExpenseItemList();		
		expenseItemList.addAllToRemoveList(externalExpenseItemList);
		return hospital;	
	
	}


	//disconnect Hospital with expense_type in ExpenseItem
	public Hospital planToRemoveExpenseItemListWithExpenseType(Hospital hospital, String expenseTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ExpenseItem.HOSPITAL_PROPERTY, hospital.getId());
		key.put(ExpenseItem.EXPENSE_TYPE_PROPERTY, expenseTypeId);
		
		SmartList<ExpenseItem> externalExpenseItemList = getExpenseItemDAO().
				findExpenseItemWithKey(key, options);
		if(externalExpenseItemList == null){
			return hospital;
		}
		if(externalExpenseItemList.isEmpty()){
			return hospital;
		}
		
		for(ExpenseItem expenseItem: externalExpenseItemList){
			expenseItem.clearExpenseType();
			expenseItem.clearHospital();
			
		}
		
		
		SmartList<ExpenseItem> expenseItemList = hospital.getExpenseItemList();		
		expenseItemList.addAllToRemoveList(externalExpenseItemList);
		return hospital;
	}
	
	public int countExpenseItemListWithExpenseType(String hospitalId, String expenseTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ExpenseItem.HOSPITAL_PROPERTY, hospitalId);
		key.put(ExpenseItem.EXPENSE_TYPE_PROPERTY, expenseTypeId);
		
		int count = getExpenseItemDAO().countExpenseItemWithKey(key, options);
		return count;
	}
	
	public Hospital planToRemoveDoctorList(Hospital hospital, String doctorIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Doctor.HOSPITAL_PROPERTY, hospital.getId());
		key.put(Doctor.ID_PROPERTY, doctorIds);
		
		SmartList<Doctor> externalDoctorList = getDoctorDAO().
				findDoctorWithKey(key, options);
		if(externalDoctorList == null){
			return hospital;
		}
		if(externalDoctorList.isEmpty()){
			return hospital;
		}
		
		for(Doctor doctor: externalDoctorList){

			doctor.clearFromAll();
		}
		
		
		SmartList<Doctor> doctorList = hospital.getDoctorList();		
		doctorList.addAllToRemoveList(externalDoctorList);
		return hospital;	
	
	}


	public Hospital planToRemoveDepartmentList(Hospital hospital, String departmentIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Department.HOSPITAL_PROPERTY, hospital.getId());
		key.put(Department.ID_PROPERTY, departmentIds);
		
		SmartList<Department> externalDepartmentList = getDepartmentDAO().
				findDepartmentWithKey(key, options);
		if(externalDepartmentList == null){
			return hospital;
		}
		if(externalDepartmentList.isEmpty()){
			return hospital;
		}
		
		for(Department department: externalDepartmentList){

			department.clearFromAll();
		}
		
		
		SmartList<Department> departmentList = hospital.getDepartmentList();		
		departmentList.addAllToRemoveList(externalDepartmentList);
		return hospital;	
	
	}



		
	protected Hospital saveExpenseTypeList(Hospital hospital, Map<String,Object> options){
		
		
		
		
		SmartList<ExpenseType> expenseTypeList = hospital.getExpenseTypeList();
		if(expenseTypeList == null){
			//null list means nothing
			return hospital;
		}
		SmartList<ExpenseType> mergedUpdateExpenseTypeList = new SmartList<ExpenseType>();
		
		
		mergedUpdateExpenseTypeList.addAll(expenseTypeList); 
		if(expenseTypeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateExpenseTypeList.addAll(expenseTypeList.getToRemoveList());
			expenseTypeList.removeAll(expenseTypeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getExpenseTypeDAO().saveExpenseTypeList(mergedUpdateExpenseTypeList,options);
		
		if(expenseTypeList.getToRemoveList() != null){
			expenseTypeList.removeAll(expenseTypeList.getToRemoveList());
		}
		
		
		return hospital;
	
	}
	
	protected Hospital removeExpenseTypeList(Hospital hospital, Map<String,Object> options){
	
	
		SmartList<ExpenseType> expenseTypeList = hospital.getExpenseTypeList();
		if(expenseTypeList == null){
			return hospital;
		}	
	
		SmartList<ExpenseType> toRemoveExpenseTypeList = expenseTypeList.getToRemoveList();
		
		if(toRemoveExpenseTypeList == null){
			return hospital;
		}
		if(toRemoveExpenseTypeList.isEmpty()){
			return hospital;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getExpenseTypeDAO().removeExpenseTypeList(toRemoveExpenseTypeList,options);
		
		return hospital;
	
	}
	
	

 	
 	
	
	
	
		
	protected Hospital saveExpenseItemList(Hospital hospital, Map<String,Object> options){
		
		
		
		
		SmartList<ExpenseItem> expenseItemList = hospital.getExpenseItemList();
		if(expenseItemList == null){
			//null list means nothing
			return hospital;
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
		
		
		return hospital;
	
	}
	
	protected Hospital removeExpenseItemList(Hospital hospital, Map<String,Object> options){
	
	
		SmartList<ExpenseItem> expenseItemList = hospital.getExpenseItemList();
		if(expenseItemList == null){
			return hospital;
		}	
	
		SmartList<ExpenseItem> toRemoveExpenseItemList = expenseItemList.getToRemoveList();
		
		if(toRemoveExpenseItemList == null){
			return hospital;
		}
		if(toRemoveExpenseItemList.isEmpty()){
			return hospital;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getExpenseItemDAO().removeExpenseItemList(toRemoveExpenseItemList,options);
		
		return hospital;
	
	}
	
	

 	
 	
	
	
	
		
	protected Hospital saveDoctorList(Hospital hospital, Map<String,Object> options){
		
		
		
		
		SmartList<Doctor> doctorList = hospital.getDoctorList();
		if(doctorList == null){
			//null list means nothing
			return hospital;
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
		
		
		return hospital;
	
	}
	
	protected Hospital removeDoctorList(Hospital hospital, Map<String,Object> options){
	
	
		SmartList<Doctor> doctorList = hospital.getDoctorList();
		if(doctorList == null){
			return hospital;
		}	
	
		SmartList<Doctor> toRemoveDoctorList = doctorList.getToRemoveList();
		
		if(toRemoveDoctorList == null){
			return hospital;
		}
		if(toRemoveDoctorList.isEmpty()){
			return hospital;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getDoctorDAO().removeDoctorList(toRemoveDoctorList,options);
		
		return hospital;
	
	}
	
	

 	
 	
	
	
	
		
	protected Hospital saveDepartmentList(Hospital hospital, Map<String,Object> options){
		
		
		
		
		SmartList<Department> departmentList = hospital.getDepartmentList();
		if(departmentList == null){
			//null list means nothing
			return hospital;
		}
		SmartList<Department> mergedUpdateDepartmentList = new SmartList<Department>();
		
		
		mergedUpdateDepartmentList.addAll(departmentList); 
		if(departmentList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateDepartmentList.addAll(departmentList.getToRemoveList());
			departmentList.removeAll(departmentList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getDepartmentDAO().saveDepartmentList(mergedUpdateDepartmentList,options);
		
		if(departmentList.getToRemoveList() != null){
			departmentList.removeAll(departmentList.getToRemoveList());
		}
		
		
		return hospital;
	
	}
	
	protected Hospital removeDepartmentList(Hospital hospital, Map<String,Object> options){
	
	
		SmartList<Department> departmentList = hospital.getDepartmentList();
		if(departmentList == null){
			return hospital;
		}	
	
		SmartList<Department> toRemoveDepartmentList = departmentList.getToRemoveList();
		
		if(toRemoveDepartmentList == null){
			return hospital;
		}
		if(toRemoveDepartmentList.isEmpty()){
			return hospital;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getDepartmentDAO().removeDepartmentList(toRemoveDepartmentList,options);
		
		return hospital;
	
	}
	
	

 	
 	
	
	
	
		

	public Hospital present(Hospital hospital,Map<String, Object> options){
	
		presentExpenseTypeList(hospital,options);
		presentExpenseItemList(hospital,options);
		presentDoctorList(hospital,options);
		presentDepartmentList(hospital,options);

		return hospital;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Hospital presentExpenseTypeList(
			Hospital hospital,
			Map<String, Object> options) {

		SmartList<ExpenseType> expenseTypeList = hospital.getExpenseTypeList();		
				SmartList<ExpenseType> newList= presentSubList(hospital.getId(),
				expenseTypeList,
				options,
				getExpenseTypeDAO()::countExpenseTypeByHospital,
				getExpenseTypeDAO()::findExpenseTypeByHospital
				);

		
		hospital.setExpenseTypeList(newList);
		

		return hospital;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Hospital presentExpenseItemList(
			Hospital hospital,
			Map<String, Object> options) {

		SmartList<ExpenseItem> expenseItemList = hospital.getExpenseItemList();		
				SmartList<ExpenseItem> newList= presentSubList(hospital.getId(),
				expenseItemList,
				options,
				getExpenseItemDAO()::countExpenseItemByHospital,
				getExpenseItemDAO()::findExpenseItemByHospital
				);

		
		hospital.setExpenseItemList(newList);
		

		return hospital;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Hospital presentDoctorList(
			Hospital hospital,
			Map<String, Object> options) {

		SmartList<Doctor> doctorList = hospital.getDoctorList();		
				SmartList<Doctor> newList= presentSubList(hospital.getId(),
				doctorList,
				options,
				getDoctorDAO()::countDoctorByHospital,
				getDoctorDAO()::findDoctorByHospital
				);

		
		hospital.setDoctorList(newList);
		

		return hospital;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Hospital presentDepartmentList(
			Hospital hospital,
			Map<String, Object> options) {

		SmartList<Department> departmentList = hospital.getDepartmentList();		
				SmartList<Department> newList= presentSubList(hospital.getId(),
				departmentList,
				options,
				getDepartmentDAO()::countDepartmentByHospital,
				getDepartmentDAO()::findDepartmentByHospital
				);

		
		hospital.setDepartmentList(newList);
		

		return hospital;
	}			
		

	
    public SmartList<Hospital> requestCandidateHospitalForExpenseType(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HospitalTable.COLUMN_NAME, filterKey, pageNo, pageSize, getHospitalMapper());
    }
		
    public SmartList<Hospital> requestCandidateHospitalForExpenseItem(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HospitalTable.COLUMN_NAME, filterKey, pageNo, pageSize, getHospitalMapper());
    }
		
    public SmartList<Hospital> requestCandidateHospitalForDoctor(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HospitalTable.COLUMN_NAME, filterKey, pageNo, pageSize, getHospitalMapper());
    }
		
    public SmartList<Hospital> requestCandidateHospitalForDepartment(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HospitalTable.COLUMN_NAME, filterKey, pageNo, pageSize, getHospitalMapper());
    }
		

	protected String getTableName(){
		return HospitalTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Hospital> hospitalList) {		
		this.enhanceListInternal(hospitalList, this.getHospitalMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Hospital> hospitalList = ownerEntity.collectRefsWithType(Hospital.INTERNAL_TYPE);
		this.enhanceList(hospitalList);
		
	}
	
	@Override
	public SmartList<Hospital> findHospitalWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getHospitalMapper());

	}
	@Override
	public int countHospitalWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countHospitalWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Hospital> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getHospitalMapper());
	}
}


