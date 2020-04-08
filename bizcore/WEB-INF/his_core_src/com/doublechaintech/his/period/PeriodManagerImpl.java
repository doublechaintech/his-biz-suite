
package com.doublechaintech.his.period;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.his.*;
import com.doublechaintech.his.tree.*;
import com.doublechaintech.his.treenode.*;
import com.doublechaintech.his.HisUserContextImpl;
import com.doublechaintech.his.iamservice.*;
import com.doublechaintech.his.services.IamService;
import com.doublechaintech.his.secuser.SecUser;
import com.doublechaintech.his.userapp.UserApp;
import com.doublechaintech.his.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.doctorschedule.DoctorSchedule;

import com.doublechaintech.his.hospital.CandidateHospital;

import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;






public class PeriodManagerImpl extends CustomHisCheckerManager implements PeriodManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "Period";
	@Override
	public PeriodDAO daoOf(HisUserContext userContext) {
		return periodDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws PeriodManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new PeriodManagerException(message);

	}



 	protected Period savePeriod(HisUserContext userContext, Period period, String [] tokensExpr) throws Exception{	
 		//return getPeriodDAO().save(period, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePeriod(userContext, period, tokens);
 	}
 	
 	protected Period savePeriodDetail(HisUserContext userContext, Period period) throws Exception{	

 		
 		return savePeriod(userContext, period, allTokens());
 	}
 	
 	public Period loadPeriod(HisUserContext userContext, String periodId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPeriod(periodId);
		checkerOf(userContext).throwExceptionIfHasErrors( PeriodManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Period period = loadPeriod( userContext, periodId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,period, tokens);
 	}
 	
 	
 	 public Period searchPeriod(HisUserContext userContext, String periodId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPeriod(periodId);
		checkerOf(userContext).throwExceptionIfHasErrors( PeriodManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Period period = loadPeriod( userContext, periodId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,period, tokens);
 	}
 	
 	

 	protected Period present(HisUserContext userContext, Period period, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,period,tokens);
		
		
		Period  periodToPresent = periodDaoOf(userContext).present(period, tokens);
		
		List<BaseEntity> entityListToNaming = periodToPresent.collectRefercencesFromLists();
		periodDaoOf(userContext).alias(entityListToNaming);
		
		return  periodToPresent;
		
		
	}
 
 	
 	
 	public Period loadPeriodDetail(HisUserContext userContext, String periodId) throws Exception{	
 		Period period = loadPeriod( userContext, periodId, allTokens());
 		return present(userContext,period, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String periodId) throws Exception{	
 		Period period = loadPeriod( userContext, periodId, viewTokens());
 		return present(userContext,period, allTokens());
		
 	}
 	protected Period savePeriod(HisUserContext userContext, Period period, Map<String,Object>tokens) throws Exception{	
 		return periodDaoOf(userContext).save(period, tokens);
 	}
 	protected Period loadPeriod(HisUserContext userContext, String periodId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfPeriod(periodId);
		checkerOf(userContext).throwExceptionIfHasErrors( PeriodManagerException.class);

 
 		return periodDaoOf(userContext).load(periodId, tokens);
 	}

	
	

	public Period loadPeriodWithCode(HisUserContext userContext, String code, Map<String,Object>tokens) throws Exception{	
 		return periodDaoOf(userContext).loadByCode(code, tokens);
 	}

	 


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, Period period, Map<String, Object> tokens){
		super.addActions(userContext, period, tokens);
		
		addAction(userContext, period, tokens,"@create","createPeriod","createPeriod/","main","primary");
		addAction(userContext, period, tokens,"@update","updatePeriod","updatePeriod/"+period.getId()+"/","main","primary");
		addAction(userContext, period, tokens,"@copy","clonePeriod","clonePeriod/"+period.getId()+"/","main","primary");
		
		addAction(userContext, period, tokens,"period.transfer_to_hospital","transferToAnotherHospital","transferToAnotherHospital/"+period.getId()+"/","main","primary");
		addAction(userContext, period, tokens,"period.addDoctorSchedule","addDoctorSchedule","addDoctorSchedule/"+period.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, period, tokens,"period.removeDoctorSchedule","removeDoctorSchedule","removeDoctorSchedule/"+period.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, period, tokens,"period.updateDoctorSchedule","updateDoctorSchedule","updateDoctorSchedule/"+period.getId()+"/","doctorScheduleList","primary");
		addAction(userContext, period, tokens,"period.copyDoctorScheduleFrom","copyDoctorScheduleFrom","copyDoctorScheduleFrom/"+period.getId()+"/","doctorScheduleList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, Period period, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public Period createPeriod(HisUserContext userContext, String name,String code,String hospitalId) throws Exception
	//public Period createPeriod(HisUserContext userContext,String name, String code, String hospitalId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfPeriod(name);
		checkerOf(userContext).checkCodeOfPeriod(code);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PeriodManagerException.class);


		Period period=createNewPeriod();	

		period.setName(name);
		period.setCode(code);
			
		Hospital hospital = loadHospital(userContext, hospitalId,emptyOptions());
		period.setHospital(hospital);
		
		

		period = savePeriod(userContext, period, emptyOptions());
		
		onNewInstanceCreated(userContext, period);
		return period;


	}
	protected Period createNewPeriod()
	{

		return new Period();
	}

	protected void checkParamsForUpdatingPeriod(HisUserContext userContext,String periodId, int periodVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfPeriod(periodId);
		checkerOf(userContext).checkVersionOfPeriod( periodVersion);
		

		if(Period.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfPeriod(parseString(newValueExpr));
		
			
		}
		if(Period.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfPeriod(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PeriodManagerException.class);


	}



	public Period clone(HisUserContext userContext, String fromPeriodId) throws Exception{

		return periodDaoOf(userContext).clone(fromPeriodId, this.allTokens());
	}

	public Period internalSavePeriod(HisUserContext userContext, Period period) throws Exception
	{
		return internalSavePeriod(userContext, period, allTokens());

	}
	public Period internalSavePeriod(HisUserContext userContext, Period period, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingPeriod(userContext, periodId, periodVersion, property, newValueExpr, tokensExpr);


		synchronized(period){
			//will be good when the period loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Period.
			if (period.isChanged()){
			
			}
			period = savePeriod(userContext, period, options);
			return period;

		}

	}

	public Period updatePeriod(HisUserContext userContext,String periodId, int periodVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPeriod(userContext, periodId, periodVersion, property, newValueExpr, tokensExpr);



		Period period = loadPeriod(userContext, periodId, allTokens());
		if(period.getVersion() != periodVersion){
			String message = "The target version("+period.getVersion()+") is not equals to version("+periodVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(period){
			//will be good when the period loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Period.
			
			period.changeProperty(property, newValueExpr);
			period = savePeriod(userContext, period, tokens().done());
			return present(userContext,period, mergedAllTokens(tokensExpr));
			//return savePeriod(userContext, period, tokens().done());
		}

	}

	public Period updatePeriodProperty(HisUserContext userContext,String periodId, int periodVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPeriod(userContext, periodId, periodVersion, property, newValueExpr, tokensExpr);

		Period period = loadPeriod(userContext, periodId, allTokens());
		if(period.getVersion() != periodVersion){
			String message = "The target version("+period.getVersion()+") is not equals to version("+periodVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(period){
			//will be good when the period loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Period.

			period.changeProperty(property, newValueExpr);
			
			period = savePeriod(userContext, period, tokens().done());
			return present(userContext,period, mergedAllTokens(tokensExpr));
			//return savePeriod(userContext, period, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected PeriodTokens tokens(){
		return PeriodTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PeriodTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortDoctorScheduleListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PeriodTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherHospital(HisUserContext userContext, String periodId, String anotherHospitalId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfPeriod(periodId);
 		checkerOf(userContext).checkIdOfHospital(anotherHospitalId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(PeriodManagerException.class);

 	}
 	public Period transferToAnotherHospital(HisUserContext userContext, String periodId, String anotherHospitalId) throws Exception
 	{
 		checkParamsForTransferingAnotherHospital(userContext, periodId,anotherHospitalId);
 
		Period period = loadPeriod(userContext, periodId, allTokens());	
		synchronized(period){
			//will be good when the period loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Hospital hospital = loadHospital(userContext, anotherHospitalId, emptyOptions());		
			period.updateHospital(hospital);		
			period = savePeriod(userContext, period, emptyOptions());
			
			return present(userContext,period, allTokens());
			
		}

 	}

	


	public CandidateHospital requestCandidateHospital(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateHospital result = new CandidateHospital();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Hospital> candidateList = hospitalDaoOf(userContext).requestCandidateHospitalForPeriod(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Hospital loadHospital(HisUserContext userContext, String newHospitalId, Map<String,Object> options) throws Exception
 	{

 		return hospitalDaoOf(userContext).load(newHospitalId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String periodId, int periodVersion) throws Exception {
		//deleteInternal(userContext, periodId, periodVersion);
	}
	protected void deleteInternal(HisUserContext userContext,
			String periodId, int periodVersion) throws Exception{

		periodDaoOf(userContext).delete(periodId, periodVersion);
	}

	public Period forgetByAll(HisUserContext userContext, String periodId, int periodVersion) throws Exception {
		return forgetByAllInternal(userContext, periodId, periodVersion);
	}
	protected Period forgetByAllInternal(HisUserContext userContext,
			String periodId, int periodVersion) throws Exception{

		return periodDaoOf(userContext).disconnectFromAll(periodId, periodVersion);
	}




	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PeriodManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return periodDaoOf(userContext).deleteAll();
	}


	//disconnect Period with doctor in DoctorSchedule
	protected Period breakWithDoctorScheduleByDoctor(HisUserContext userContext, String periodId, String doctorId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Period period = loadPeriod(userContext, periodId, allTokens());

			synchronized(period){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				periodDaoOf(userContext).planToRemoveDoctorScheduleListWithDoctor(period, doctorId, this.emptyOptions());

				period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
				return period;
			}
	}
	//disconnect Period with department in DoctorSchedule
	protected Period breakWithDoctorScheduleByDepartment(HisUserContext userContext, String periodId, String departmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Period period = loadPeriod(userContext, periodId, allTokens());

			synchronized(period){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				periodDaoOf(userContext).planToRemoveDoctorScheduleListWithDepartment(period, departmentId, this.emptyOptions());

				period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
				return period;
			}
	}
	//disconnect Period with expense_type in DoctorSchedule
	protected Period breakWithDoctorScheduleByExpenseType(HisUserContext userContext, String periodId, String expenseTypeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Period period = loadPeriod(userContext, periodId, allTokens());

			synchronized(period){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				periodDaoOf(userContext).planToRemoveDoctorScheduleListWithExpenseType(period, expenseTypeId, this.emptyOptions());

				period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
				return period;
			}
	}
	//disconnect Period with hospital in DoctorSchedule
	protected Period breakWithDoctorScheduleByHospital(HisUserContext userContext, String periodId, String hospitalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Period period = loadPeriod(userContext, periodId, allTokens());

			synchronized(period){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				periodDaoOf(userContext).planToRemoveDoctorScheduleListWithHospital(period, hospitalId, this.emptyOptions());

				period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
				return period;
			}
	}






	protected void checkParamsForAddingDoctorSchedule(HisUserContext userContext, String periodId, String name, String doctorId, Date scheduleDate, String departmentId, int available, BigDecimal price, String expenseTypeId, String hospitalId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfPeriod(periodId);

		
		checkerOf(userContext).checkNameOfDoctorSchedule(name);
		
		checkerOf(userContext).checkDoctorIdOfDoctorSchedule(doctorId);
		
		checkerOf(userContext).checkScheduleDateOfDoctorSchedule(scheduleDate);
		
		checkerOf(userContext).checkDepartmentIdOfDoctorSchedule(departmentId);
		
		checkerOf(userContext).checkAvailableOfDoctorSchedule(available);
		
		checkerOf(userContext).checkPriceOfDoctorSchedule(price);
		
		checkerOf(userContext).checkExpenseTypeIdOfDoctorSchedule(expenseTypeId);
		
		checkerOf(userContext).checkHospitalIdOfDoctorSchedule(hospitalId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PeriodManagerException.class);


	}
	public  Period addDoctorSchedule(HisUserContext userContext, String periodId, String name, String doctorId, Date scheduleDate, String departmentId, int available, BigDecimal price, String expenseTypeId, String hospitalId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingDoctorSchedule(userContext,periodId,name, doctorId, scheduleDate, departmentId, available, price, expenseTypeId, hospitalId,tokensExpr);

		DoctorSchedule doctorSchedule = createDoctorSchedule(userContext,name, doctorId, scheduleDate, departmentId, available, price, expenseTypeId, hospitalId);

		Period period = loadPeriod(userContext, periodId, emptyOptions());
		synchronized(period){
			//Will be good when the period loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			period.addDoctorSchedule( doctorSchedule );
			period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
			
			userContext.getManagerGroup().getDoctorScheduleManager().onNewInstanceCreated(userContext, doctorSchedule);
			return present(userContext,period, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingDoctorScheduleProperties(HisUserContext userContext, String periodId,String id,String name,Date scheduleDate,int available,BigDecimal price,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPeriod(periodId);
		checkerOf(userContext).checkIdOfDoctorSchedule(id);

		checkerOf(userContext).checkNameOfDoctorSchedule( name);
		checkerOf(userContext).checkScheduleDateOfDoctorSchedule( scheduleDate);
		checkerOf(userContext).checkAvailableOfDoctorSchedule( available);
		checkerOf(userContext).checkPriceOfDoctorSchedule( price);

		checkerOf(userContext).throwExceptionIfHasErrors(PeriodManagerException.class);

	}
	public  Period updateDoctorScheduleProperties(HisUserContext userContext, String periodId, String id,String name,Date scheduleDate,int available,BigDecimal price, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingDoctorScheduleProperties(userContext,periodId,id,name,scheduleDate,available,price,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withDoctorScheduleListList()
				.searchDoctorScheduleListWith(DoctorSchedule.ID_PROPERTY, "is", id).done();

		Period periodToUpdate = loadPeriod(userContext, periodId, options);

		if(periodToUpdate.getDoctorScheduleList().isEmpty()){
			throw new PeriodManagerException("DoctorSchedule is NOT FOUND with id: '"+id+"'");
		}

		DoctorSchedule item = periodToUpdate.getDoctorScheduleList().first();

		item.updateName( name );
		item.updateScheduleDate( scheduleDate );
		item.updateAvailable( available );
		item.updatePrice( price );


		//checkParamsForAddingDoctorSchedule(userContext,periodId,name, code, used,tokensExpr);
		Period period = savePeriod(userContext, periodToUpdate, tokens().withDoctorScheduleList().done());
		synchronized(period){
			return present(userContext,period, mergedAllTokens(tokensExpr));
		}
	}


	protected DoctorSchedule createDoctorSchedule(HisUserContext userContext, String name, String doctorId, Date scheduleDate, String departmentId, int available, BigDecimal price, String expenseTypeId, String hospitalId) throws Exception{

		DoctorSchedule doctorSchedule = new DoctorSchedule();
		
		
		doctorSchedule.setName(name);		
		Doctor  doctor = new Doctor();
		doctor.setId(doctorId);		
		doctorSchedule.setDoctor(doctor);		
		doctorSchedule.setScheduleDate(scheduleDate);		
		Department  department = new Department();
		department.setId(departmentId);		
		doctorSchedule.setDepartment(department);		
		doctorSchedule.setAvailable(available);		
		doctorSchedule.setPrice(price);		
		ExpenseType  expenseType = new ExpenseType();
		expenseType.setId(expenseTypeId);		
		doctorSchedule.setExpenseType(expenseType);		
		doctorSchedule.setCreateTime(userContext.now());		
		doctorSchedule.setUpdateTime(userContext.now());		
		Hospital  hospital = new Hospital();
		hospital.setId(hospitalId);		
		doctorSchedule.setHospital(hospital);
	
		
		return doctorSchedule;


	}

	protected DoctorSchedule createIndexedDoctorSchedule(String id, int version){

		DoctorSchedule doctorSchedule = new DoctorSchedule();
		doctorSchedule.setId(id);
		doctorSchedule.setVersion(version);
		return doctorSchedule;

	}

	protected void checkParamsForRemovingDoctorScheduleList(HisUserContext userContext, String periodId,
			String doctorScheduleIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPeriod(periodId);
		for(String doctorScheduleIdItem: doctorScheduleIds){
			checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(PeriodManagerException.class);

	}
	public  Period removeDoctorScheduleList(HisUserContext userContext, String periodId,
			String doctorScheduleIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingDoctorScheduleList(userContext, periodId,  doctorScheduleIds, tokensExpr);


			Period period = loadPeriod(userContext, periodId, allTokens());
			synchronized(period){
				//Will be good when the period loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				periodDaoOf(userContext).planToRemoveDoctorScheduleList(period, doctorScheduleIds, allTokens());
				period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
				deleteRelationListInGraph(userContext, period.getDoctorScheduleList());
				return present(userContext,period, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingDoctorSchedule(HisUserContext userContext, String periodId,
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPeriod( periodId);
		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
		checkerOf(userContext).checkVersionOfDoctorSchedule(doctorScheduleVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PeriodManagerException.class);

	}
	public  Period removeDoctorSchedule(HisUserContext userContext, String periodId,
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingDoctorSchedule(userContext,periodId, doctorScheduleId, doctorScheduleVersion,tokensExpr);

		DoctorSchedule doctorSchedule = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);
		Period period = loadPeriod(userContext, periodId, allTokens());
		synchronized(period){
			//Will be good when the period loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			period.removeDoctorSchedule( doctorSchedule );
			period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
			deleteRelationInGraph(userContext, doctorSchedule);
			return present(userContext,period, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingDoctorSchedule(HisUserContext userContext, String periodId,
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPeriod( periodId);
		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
		checkerOf(userContext).checkVersionOfDoctorSchedule(doctorScheduleVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PeriodManagerException.class);

	}
	public  Period copyDoctorScheduleFrom(HisUserContext userContext, String periodId,
		String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingDoctorSchedule(userContext,periodId, doctorScheduleId, doctorScheduleVersion,tokensExpr);

		DoctorSchedule doctorSchedule = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);
		Period period = loadPeriod(userContext, periodId, allTokens());
		synchronized(period){
			//Will be good when the period loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			doctorSchedule.updateUpdateTime(userContext.now());

			period.copyDoctorScheduleFrom( doctorSchedule );
			period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
			
			userContext.getManagerGroup().getDoctorScheduleManager().onNewInstanceCreated(userContext, (DoctorSchedule)period.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,period, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingDoctorSchedule(HisUserContext userContext, String periodId, String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPeriod(periodId);
		checkerOf(userContext).checkIdOfDoctorSchedule(doctorScheduleId);
		checkerOf(userContext).checkVersionOfDoctorSchedule(doctorScheduleVersion);
		

		if(DoctorSchedule.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfDoctorSchedule(parseString(newValueExpr));
		
		}
		
		if(DoctorSchedule.SCHEDULE_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkScheduleDateOfDoctorSchedule(parseDate(newValueExpr));
		
		}
		
		if(DoctorSchedule.AVAILABLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAvailableOfDoctorSchedule(parseInt(newValueExpr));
		
		}
		
		if(DoctorSchedule.PRICE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPriceOfDoctorSchedule(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PeriodManagerException.class);

	}

	public  Period updateDoctorSchedule(HisUserContext userContext, String periodId, String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingDoctorSchedule(userContext, periodId, doctorScheduleId, doctorScheduleVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withDoctorScheduleList().searchDoctorScheduleListWith(DoctorSchedule.ID_PROPERTY, "eq", doctorScheduleId).done();



		Period period = loadPeriod(userContext, periodId, loadTokens);

		synchronized(period){
			//Will be good when the period loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//period.removeDoctorSchedule( doctorSchedule );
			//make changes to AcceleraterAccount.
			DoctorSchedule doctorScheduleIndex = createIndexedDoctorSchedule(doctorScheduleId, doctorScheduleVersion);

			DoctorSchedule doctorSchedule = period.findTheDoctorSchedule(doctorScheduleIndex);
			if(doctorSchedule == null){
				throw new PeriodManagerException(doctorSchedule+" is NOT FOUND" );
			}

			doctorSchedule.changeProperty(property, newValueExpr);
			doctorSchedule.updateUpdateTime(userContext.now());
			period = savePeriod(userContext, period, tokens().withDoctorScheduleList().done());
			return present(userContext,period, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(HisUserContext userContext, Period newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(HisUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(HisBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(HisUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(HisBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(HisUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(HisBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(HisUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(HisBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(HisUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		HisUserContextImpl userContext = (HisUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(HisUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(HisUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(HisUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(HisUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(HisUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   Period newPeriod = this.createPeriod(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newPeriod
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(HisUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Period.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(HisUserContext userContext,SmartList<Period> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Hospital> hospitalList = HisBaseUtils.collectReferencedObjectWithType(userContext, list, Hospital.class);
		userContext.getDAOGroup().enhanceList(hospitalList, Hospital.class);


    }
	
	public Object listByHospital(HisUserContext userContext,String hospitalId) throws Exception {
		return listPageByHospital(userContext, hospitalId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByHospital(HisUserContext userContext,String hospitalId, int start, int count) throws Exception {
		SmartList<Period> list = periodDaoOf(userContext).findPeriodByHospital(hospitalId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(Period.class);
		page.setContainerObject(Hospital.withId(hospitalId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("期列表");
		page.setRequestName("listByHospital");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByHospital/%s/",  getBeanName(), hospitalId)));

		page.assemblerContent(userContext, "listByHospital");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(HisUserContext userContext, String periodId) throws Exception{
	  SerializeScope vscope = HisViewScope.getInstance().getPeriodDetailScope().clone();
		Period merchantObj = (Period) this.view(userContext, periodId);
    String merchantObjId = periodId;
    String linkToUrl =	"periodManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "期"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "序号")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "3-code")
				    .put("fieldName", "code")
				    .put("label", "代码")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("code", merchantObj.getCode());

		propList.add(
				MapUtil.put("id", "4-hospital")
				    .put("fieldName", "hospital")
				    .put("label", "医院")
				    .put("type", "object")
				    .put("displayField", "name")
				    .put("linkToUrl", "hospitalManager/wxappview/:id/")
				    .into_map()
		);
		result.put("hospital", merchantObj.getHospital());

		//处理 sectionList

		//处理Section：doctorScheduleListSection
		Map doctorScheduleListSection = ListofUtils.buildSection(
		    "doctorScheduleListSection",
		    "医生安排列表",
		    null,
		    "",
		    "__no_group",
		    "doctorScheduleManager/listByPeriod/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(doctorScheduleListSection);

		result.put("doctorScheduleListSection", ListofUtils.toShortList(merchantObj.getDoctorScheduleList(), "doctorSchedule"));
		vscope.field("doctorScheduleListSection", HisListOfViewScope.getInstance()
					.getListOfViewScope( DoctorSchedule.class.getName(), null));

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}

}


