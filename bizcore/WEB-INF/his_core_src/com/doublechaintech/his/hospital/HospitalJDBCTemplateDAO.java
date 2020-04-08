
package com.doublechaintech.his.hospital;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.TextUtil;

import com.doublechaintech.his.HisBaseDAOImpl;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.AccessKey;
import com.doublechaintech.his.DateKey;
import com.doublechaintech.his.StatsInfo;
import com.doublechaintech.his.StatsItem;

import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;


import com.doublechaintech.his.doctorschedule.DoctorSchedule;
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.expenseitem.ExpenseItem;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;

import com.doublechaintech.his.expenseitem.ExpenseItemDAO;
import com.doublechaintech.his.doctorschedule.DoctorScheduleDAO;
import com.doublechaintech.his.department.DepartmentDAO;
import com.doublechaintech.his.doctor.DoctorDAO;
import com.doublechaintech.his.expensetype.ExpenseTypeDAO;
import com.doublechaintech.his.period.PeriodDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class HospitalJDBCTemplateDAO extends HisBaseDAOImpl implements HospitalDAO{


			
		
	
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
 	
			
		
	
  	private  PeriodDAO  periodDAO;
 	public void setPeriodDAO(PeriodDAO pPeriodDAO){
 	
 		if(pPeriodDAO == null){
 			throw new IllegalStateException("Do not try to set periodDAO to null.");
 		}
	 	this.periodDAO = pPeriodDAO;
 	}
 	public PeriodDAO getPeriodDAO(){
 		if(this.periodDAO == null){
 			throw new IllegalStateException("The periodDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.periodDAO;
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
	protected Hospital load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalHospital(accessKey, options);
	}
	*/
	
	public SmartList<Hospital> loadAll() {
	    return this.loadAll(getHospitalMapper());
	}
	
	
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
		
 		
 		if(isSavePeriodListEnabled(options)){
 			for(Period item: newHospital.getPeriodList()){
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
		
 		
 		if(isSaveDoctorScheduleListEnabled(options)){
 			for(DoctorSchedule item: newHospital.getDoctorScheduleList()){
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
 	
		
	
	protected boolean isExtractPeriodListEnabled(Map<String,Object> options){		
 		return checkOptions(options,HospitalTokens.PERIOD_LIST);
 	}
 	protected boolean isAnalyzePeriodListEnabled(Map<String,Object> options){		 		
 		return HospitalTokens.of(options).analyzePeriodListEnabled();
 	}
	
	protected boolean isSavePeriodListEnabled(Map<String,Object> options){
		return checkOptions(options, HospitalTokens.PERIOD_LIST);
		
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
 	
		
	
	protected boolean isExtractDoctorScheduleListEnabled(Map<String,Object> options){		
 		return checkOptions(options,HospitalTokens.DOCTOR_SCHEDULE_LIST);
 	}
 	protected boolean isAnalyzeDoctorScheduleListEnabled(Map<String,Object> options){		 		
 		return HospitalTokens.of(options).analyzeDoctorScheduleListEnabled();
 	}
	
	protected boolean isSaveDoctorScheduleListEnabled(Map<String,Object> options){
		return checkOptions(options, HospitalTokens.DOCTOR_SCHEDULE_LIST);
		
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
 		
		
		if(isExtractPeriodListEnabled(loadOptions)){
	 		extractPeriodList(hospital, loadOptions);
 		}	
 		if(isAnalyzePeriodListEnabled(loadOptions)){
	 		analyzePeriodList(hospital, loadOptions);
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
 		
		
		if(isExtractDoctorScheduleListEnabled(loadOptions)){
	 		extractDoctorScheduleList(hospital, loadOptions);
 		}	
 		if(isAnalyzeDoctorScheduleListEnabled(loadOptions)){
	 		analyzeDoctorScheduleList(hospital, loadOptions);
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
	
		
	protected void enhancePeriodList(SmartList<Period> periodList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Hospital extractPeriodList(Hospital hospital, Map<String,Object> options){
		
		
		if(hospital == null){
			return null;
		}
		if(hospital.getId() == null){
			return hospital;
		}

		
		
		SmartList<Period> periodList = getPeriodDAO().findPeriodByHospital(hospital.getId(),options);
		if(periodList != null){
			enhancePeriodList(periodList,options);
			hospital.setPeriodList(periodList);
		}
		
		return hospital;
	
	}	
	
	protected Hospital analyzePeriodList(Hospital hospital, Map<String,Object> options){
		
		
		if(hospital == null){
			return null;
		}
		if(hospital.getId() == null){
			return hospital;
		}

		
		
		SmartList<Period> periodList = hospital.getPeriodList();
		if(periodList != null){
			getPeriodDAO().analyzePeriodByHospital(periodList, hospital.getId(), options);
			
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
	
		
	protected void enhanceDoctorScheduleList(SmartList<DoctorSchedule> doctorScheduleList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Hospital extractDoctorScheduleList(Hospital hospital, Map<String,Object> options){
		
		
		if(hospital == null){
			return null;
		}
		if(hospital.getId() == null){
			return hospital;
		}

		
		
		SmartList<DoctorSchedule> doctorScheduleList = getDoctorScheduleDAO().findDoctorScheduleByHospital(hospital.getId(),options);
		if(doctorScheduleList != null){
			enhanceDoctorScheduleList(doctorScheduleList,options);
			hospital.setDoctorScheduleList(doctorScheduleList);
		}
		
		return hospital;
	
	}	
	
	protected Hospital analyzeDoctorScheduleList(Hospital hospital, Map<String,Object> options){
		
		
		if(hospital == null){
			return null;
		}
		if(hospital.getId() == null){
			return hospital;
		}

		
		
		SmartList<DoctorSchedule> doctorScheduleList = hospital.getDoctorScheduleList();
		if(doctorScheduleList != null){
			getDoctorScheduleDAO().analyzeDoctorScheduleByHospital(doctorScheduleList, hospital.getId(), options);
			
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
		
		if(isSavePeriodListEnabled(options)){
	 		savePeriodList(hospital, options);
	 		//removePeriodList(hospital, options);
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
		
		if(isSaveDoctorScheduleListEnabled(options)){
	 		saveDoctorScheduleList(hospital, options);
	 		//removeDoctorScheduleList(hospital, options);
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
		
		for(ExpenseType expenseTypeItem: externalExpenseTypeList){

			expenseTypeItem.clearFromAll();
		}
		
		
		SmartList<ExpenseType> expenseTypeList = hospital.getExpenseTypeList();		
		expenseTypeList.addAllToRemoveList(externalExpenseTypeList);
		return hospital;	
	
	}


	public Hospital planToRemovePeriodList(Hospital hospital, String periodIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Period.HOSPITAL_PROPERTY, hospital.getId());
		key.put(Period.ID_PROPERTY, periodIds);
		
		SmartList<Period> externalPeriodList = getPeriodDAO().
				findPeriodWithKey(key, options);
		if(externalPeriodList == null){
			return hospital;
		}
		if(externalPeriodList.isEmpty()){
			return hospital;
		}
		
		for(Period periodItem: externalPeriodList){

			periodItem.clearFromAll();
		}
		
		
		SmartList<Period> periodList = hospital.getPeriodList();		
		periodList.addAllToRemoveList(externalPeriodList);
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
		
		for(ExpenseItem expenseItemItem: externalExpenseItemList){

			expenseItemItem.clearFromAll();
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
		
		for(ExpenseItem expenseItemItem: externalExpenseItemList){
			expenseItemItem.clearExpenseType();
			expenseItemItem.clearHospital();
			
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
		
		for(Doctor doctorItem: externalDoctorList){

			doctorItem.clearFromAll();
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
		
		for(Department departmentItem: externalDepartmentList){

			departmentItem.clearFromAll();
		}
		
		
		SmartList<Department> departmentList = hospital.getDepartmentList();		
		departmentList.addAllToRemoveList(externalDepartmentList);
		return hospital;	
	
	}


	public Hospital planToRemoveDoctorScheduleList(Hospital hospital, String doctorScheduleIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, hospital.getId());
		key.put(DoctorSchedule.ID_PROPERTY, doctorScheduleIds);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return hospital;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return hospital;
		}
		
		for(DoctorSchedule doctorScheduleItem: externalDoctorScheduleList){

			doctorScheduleItem.clearFromAll();
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = hospital.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return hospital;	
	
	}


	//disconnect Hospital with doctor in DoctorSchedule
	public Hospital planToRemoveDoctorScheduleListWithDoctor(Hospital hospital, String doctorId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, hospital.getId());
		key.put(DoctorSchedule.DOCTOR_PROPERTY, doctorId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return hospital;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return hospital;
		}
		
		for(DoctorSchedule doctorScheduleItem: externalDoctorScheduleList){
			doctorScheduleItem.clearDoctor();
			doctorScheduleItem.clearHospital();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = hospital.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return hospital;
	}
	
	public int countDoctorScheduleListWithDoctor(String hospitalId, String doctorId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, hospitalId);
		key.put(DoctorSchedule.DOCTOR_PROPERTY, doctorId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	
	//disconnect Hospital with period in DoctorSchedule
	public Hospital planToRemoveDoctorScheduleListWithPeriod(Hospital hospital, String periodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, hospital.getId());
		key.put(DoctorSchedule.PERIOD_PROPERTY, periodId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return hospital;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return hospital;
		}
		
		for(DoctorSchedule doctorScheduleItem: externalDoctorScheduleList){
			doctorScheduleItem.clearPeriod();
			doctorScheduleItem.clearHospital();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = hospital.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return hospital;
	}
	
	public int countDoctorScheduleListWithPeriod(String hospitalId, String periodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, hospitalId);
		key.put(DoctorSchedule.PERIOD_PROPERTY, periodId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	
	//disconnect Hospital with department in DoctorSchedule
	public Hospital planToRemoveDoctorScheduleListWithDepartment(Hospital hospital, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, hospital.getId());
		key.put(DoctorSchedule.DEPARTMENT_PROPERTY, departmentId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return hospital;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return hospital;
		}
		
		for(DoctorSchedule doctorScheduleItem: externalDoctorScheduleList){
			doctorScheduleItem.clearDepartment();
			doctorScheduleItem.clearHospital();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = hospital.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return hospital;
	}
	
	public int countDoctorScheduleListWithDepartment(String hospitalId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, hospitalId);
		key.put(DoctorSchedule.DEPARTMENT_PROPERTY, departmentId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
	}
	
	//disconnect Hospital with expense_type in DoctorSchedule
	public Hospital planToRemoveDoctorScheduleListWithExpenseType(Hospital hospital, String expenseTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, hospital.getId());
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, expenseTypeId);
		
		SmartList<DoctorSchedule> externalDoctorScheduleList = getDoctorScheduleDAO().
				findDoctorScheduleWithKey(key, options);
		if(externalDoctorScheduleList == null){
			return hospital;
		}
		if(externalDoctorScheduleList.isEmpty()){
			return hospital;
		}
		
		for(DoctorSchedule doctorScheduleItem: externalDoctorScheduleList){
			doctorScheduleItem.clearExpenseType();
			doctorScheduleItem.clearHospital();
			
		}
		
		
		SmartList<DoctorSchedule> doctorScheduleList = hospital.getDoctorScheduleList();		
		doctorScheduleList.addAllToRemoveList(externalDoctorScheduleList);
		return hospital;
	}
	
	public int countDoctorScheduleListWithExpenseType(String hospitalId, String expenseTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, hospitalId);
		key.put(DoctorSchedule.EXPENSE_TYPE_PROPERTY, expenseTypeId);
		
		int count = getDoctorScheduleDAO().countDoctorScheduleWithKey(key, options);
		return count;
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
	
	

 	
 	
	
	
	
		
	protected Hospital savePeriodList(Hospital hospital, Map<String,Object> options){
		
		
		
		
		SmartList<Period> periodList = hospital.getPeriodList();
		if(periodList == null){
			//null list means nothing
			return hospital;
		}
		SmartList<Period> mergedUpdatePeriodList = new SmartList<Period>();
		
		
		mergedUpdatePeriodList.addAll(periodList); 
		if(periodList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdatePeriodList.addAll(periodList.getToRemoveList());
			periodList.removeAll(periodList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getPeriodDAO().savePeriodList(mergedUpdatePeriodList,options);
		
		if(periodList.getToRemoveList() != null){
			periodList.removeAll(periodList.getToRemoveList());
		}
		
		
		return hospital;
	
	}
	
	protected Hospital removePeriodList(Hospital hospital, Map<String,Object> options){
	
	
		SmartList<Period> periodList = hospital.getPeriodList();
		if(periodList == null){
			return hospital;
		}	
	
		SmartList<Period> toRemovePeriodList = periodList.getToRemoveList();
		
		if(toRemovePeriodList == null){
			return hospital;
		}
		if(toRemovePeriodList.isEmpty()){
			return hospital;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getPeriodDAO().removePeriodList(toRemovePeriodList,options);
		
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
	
	

 	
 	
	
	
	
		
	protected Hospital saveDoctorScheduleList(Hospital hospital, Map<String,Object> options){
		
		
		
		
		SmartList<DoctorSchedule> doctorScheduleList = hospital.getDoctorScheduleList();
		if(doctorScheduleList == null){
			//null list means nothing
			return hospital;
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
		
		
		return hospital;
	
	}
	
	protected Hospital removeDoctorScheduleList(Hospital hospital, Map<String,Object> options){
	
	
		SmartList<DoctorSchedule> doctorScheduleList = hospital.getDoctorScheduleList();
		if(doctorScheduleList == null){
			return hospital;
		}	
	
		SmartList<DoctorSchedule> toRemoveDoctorScheduleList = doctorScheduleList.getToRemoveList();
		
		if(toRemoveDoctorScheduleList == null){
			return hospital;
		}
		if(toRemoveDoctorScheduleList.isEmpty()){
			return hospital;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getDoctorScheduleDAO().removeDoctorScheduleList(toRemoveDoctorScheduleList,options);
		
		return hospital;
	
	}
	
	

 	
 	
	
	
	
		

	public Hospital present(Hospital hospital,Map<String, Object> options){
	
		presentExpenseTypeList(hospital,options);
		presentPeriodList(hospital,options);
		presentExpenseItemList(hospital,options);
		presentDoctorList(hospital,options);
		presentDepartmentList(hospital,options);
		presentDoctorScheduleList(hospital,options);

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
 	protected Hospital presentPeriodList(
			Hospital hospital,
			Map<String, Object> options) {

		SmartList<Period> periodList = hospital.getPeriodList();		
				SmartList<Period> newList= presentSubList(hospital.getId(),
				periodList,
				options,
				getPeriodDAO()::countPeriodByHospital,
				getPeriodDAO()::findPeriodByHospital
				);

		
		hospital.setPeriodList(newList);
		

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
		
	//Using java8 feature to reduce the code significantly
 	protected Hospital presentDoctorScheduleList(
			Hospital hospital,
			Map<String, Object> options) {

		SmartList<DoctorSchedule> doctorScheduleList = hospital.getDoctorScheduleList();		
				SmartList<DoctorSchedule> newList= presentSubList(hospital.getId(),
				doctorScheduleList,
				options,
				getDoctorScheduleDAO()::countDoctorScheduleByHospital,
				getDoctorScheduleDAO()::findDoctorScheduleByHospital
				);

		
		hospital.setDoctorScheduleList(newList);
		

		return hospital;
	}			
		

	
    public SmartList<Hospital> requestCandidateHospitalForExpenseType(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HospitalTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getHospitalMapper());
    }
		
    public SmartList<Hospital> requestCandidateHospitalForPeriod(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HospitalTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getHospitalMapper());
    }
		
    public SmartList<Hospital> requestCandidateHospitalForExpenseItem(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HospitalTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getHospitalMapper());
    }
		
    public SmartList<Hospital> requestCandidateHospitalForDoctor(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HospitalTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getHospitalMapper());
    }
		
    public SmartList<Hospital> requestCandidateHospitalForDepartment(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HospitalTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getHospitalMapper());
    }
		
    public SmartList<Hospital> requestCandidateHospitalForDoctorSchedule(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HospitalTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getHospitalMapper());
    }
		

	protected String getTableName(){
		return HospitalTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Hospital> hospitalList) {		
		this.enhanceListInternal(hospitalList, this.getHospitalMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:ExpenseType的hospital的ExpenseTypeList
	public SmartList<ExpenseType> loadOurExpenseTypeList(HisUserContext userContext, List<Hospital> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ExpenseType.HOSPITAL_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ExpenseType> loadedObjs = userContext.getDAOGroup().getExpenseTypeDAO().findExpenseTypeWithKey(key, options);
		Map<String, List<ExpenseType>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getHospital().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ExpenseType> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ExpenseType> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setExpenseTypeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:Period的hospital的PeriodList
	public SmartList<Period> loadOurPeriodList(HisUserContext userContext, List<Hospital> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Period.HOSPITAL_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Period> loadedObjs = userContext.getDAOGroup().getPeriodDAO().findPeriodWithKey(key, options);
		Map<String, List<Period>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getHospital().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Period> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Period> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setPeriodList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:ExpenseItem的hospital的ExpenseItemList
	public SmartList<ExpenseItem> loadOurExpenseItemList(HisUserContext userContext, List<Hospital> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ExpenseItem.HOSPITAL_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ExpenseItem> loadedObjs = userContext.getDAOGroup().getExpenseItemDAO().findExpenseItemWithKey(key, options);
		Map<String, List<ExpenseItem>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getHospital().getId()));
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
	
	// 需要一个加载引用我的对象的enhance方法:Doctor的hospital的DoctorList
	public SmartList<Doctor> loadOurDoctorList(HisUserContext userContext, List<Hospital> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Doctor.HOSPITAL_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Doctor> loadedObjs = userContext.getDAOGroup().getDoctorDAO().findDoctorWithKey(key, options);
		Map<String, List<Doctor>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getHospital().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Doctor> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Doctor> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setDoctorList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:Department的hospital的DepartmentList
	public SmartList<Department> loadOurDepartmentList(HisUserContext userContext, List<Hospital> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Department.HOSPITAL_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Department> loadedObjs = userContext.getDAOGroup().getDepartmentDAO().findDepartmentWithKey(key, options);
		Map<String, List<Department>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getHospital().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Department> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Department> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setDepartmentList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:DoctorSchedule的hospital的DoctorScheduleList
	public SmartList<DoctorSchedule> loadOurDoctorScheduleList(HisUserContext userContext, List<Hospital> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DoctorSchedule.HOSPITAL_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<DoctorSchedule> loadedObjs = userContext.getDAOGroup().getDoctorScheduleDAO().findDoctorScheduleWithKey(key, options);
		Map<String, List<DoctorSchedule>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getHospital().getId()));
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
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateHospital executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateHospital result = new CandidateHospital();
		int pageNo = Math.max(1, query.getPageNo());
		result.setOwnerClass(TextUtil.toCamelCase(query.getOwnerType()));
		result.setOwnerId(query.getOwnerId());
		result.setFilterKey(query.getFilterKey());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase("displayName")));
		result.setGroupByFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase(query.getGroupBy())));

		SmartList candidateList = queryList(sql, parmeters);
		this.alias(candidateList);
		result.setCandidates(candidateList);
		int offSet = (pageNo - 1 ) * query.getPageSize();
		if (candidateList.size() > query.getPageSize()) {
			result.setTotalPage(pageNo+1);
		}else {
			result.setTotalPage(pageNo);
		}
		return result;
	}
	
	
    
	public Map<String, Integer> countBySql(String sql, Object[] params) {
		if (params == null || params.length == 0) {
			return new HashMap<>();
		}
		List<Map<String, Object>> result = this.getJdbcTemplateObject().queryForList(sql, params);
		if (result == null || result.isEmpty()) {
			return new HashMap<>();
		}
		Map<String, Integer> cntMap = new HashMap<>();
		for (Map<String, Object> data : result) {
			String key = (String) data.get("id");
			Number value = (Number) data.get("count");
			cntMap.put(key, value.intValue());
		}
		this.logSQLAndParameters("countBySql", sql, params, cntMap.size() + " Counts");
		return cntMap;
	}

	public Integer singleCountBySql(String sql, Object[] params) {
		Integer cnt = this.getJdbcTemplateObject().queryForObject(sql, params, Integer.class);
		logSQLAndParameters("singleCountBySql", sql, params, cnt + "");
		return cnt;
	}

	public BigDecimal summaryBySql(String sql, Object[] params) {
		BigDecimal cnt = this.getJdbcTemplateObject().queryForObject(sql, params, BigDecimal.class);
		logSQLAndParameters("summaryBySql", sql, params, cnt + "");
		return cnt == null ? BigDecimal.ZERO : cnt;
	}

	public <T> List<T> queryForList(String sql, Object[] params, Class<T> claxx) {
		List<T> result = this.getJdbcTemplateObject().queryForList(sql, params, claxx);
		logSQLAndParameters("queryForList", sql, params, result.size() + " items");
		return result;
	}

	public Map<String, Object> queryForMap(String sql, Object[] params) throws DataAccessException {
		Map<String, Object> result = null;
		try {
			result = this.getJdbcTemplateObject().queryForMap(sql, params);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public <T> T queryForObject(String sql, Object[] params, Class<T> claxx) throws DataAccessException {
		T result = null;
		try {
			result = this.getJdbcTemplateObject().queryForObject(sql, params, claxx);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public List<Map<String, Object>> queryAsMapList(String sql, Object[] params) {
		List<Map<String, Object>> result = getJdbcTemplateObject().queryForList(sql, params);
		logSQLAndParameters("queryAsMapList", sql, params, result.size() + " items");
		return result;
	}

	public synchronized int updateBySql(String sql, Object[] params) {
		int result = getJdbcTemplateObject().update(sql, params);
		logSQLAndParameters("updateBySql", sql, params, result + " items");
		return result;
	}

	public void execSqlWithRowCallback(String sql, Object[] args, RowCallbackHandler callback) {
		getJdbcTemplateObject().query(sql, args, callback);
	}

	public void executeSql(String sql) {
		logSQLAndParameters("executeSql", sql, new Object[] {}, "");
		getJdbcTemplateObject().execute(sql);
	}


}


