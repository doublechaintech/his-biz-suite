
package com.doublechaintech.his.hospital;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;

public interface HospitalManager{

		

	public Hospital createHospital(HisUserContext userContext, String name, String address, String telephone) throws Exception;	
	public Hospital updateHospital(HisUserContext userContext,String hospitalId, int hospitalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Hospital loadHospital(HisUserContext userContext, String hospitalId, String [] tokensExpr) throws Exception;
	public Hospital internalSaveHospital(HisUserContext userContext, Hospital hospital) throws Exception;
	public Hospital internalSaveHospital(HisUserContext userContext, Hospital hospital,Map<String,Object>option) throws Exception;
	


	public void delete(HisUserContext userContext, String hospitalId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, Hospital newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ExpenseTypeManager getExpenseTypeManager(HisUserContext userContext, String hospitalId, String name, String helperChars, String status, String description ,String [] tokensExpr)  throws Exception;
	
	public  Hospital addExpenseType(HisUserContext userContext, String hospitalId, String name, String helperChars, String status, String description , String [] tokensExpr)  throws Exception;
	public  Hospital removeExpenseType(HisUserContext userContext, String hospitalId, String expenseTypeId, int expenseTypeVersion,String [] tokensExpr)  throws Exception;
	public  Hospital updateExpenseType(HisUserContext userContext, String hospitalId, String expenseTypeId, int expenseTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PeriodManager getPeriodManager(HisUserContext userContext, String hospitalId, String name ,String [] tokensExpr)  throws Exception;
	
	public  Hospital addPeriod(HisUserContext userContext, String hospitalId, String name , String [] tokensExpr)  throws Exception;
	public  Hospital removePeriod(HisUserContext userContext, String hospitalId, String periodId, int periodVersion,String [] tokensExpr)  throws Exception;
	public  Hospital updatePeriod(HisUserContext userContext, String hospitalId, String periodId, int periodVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ExpenseItemManager getExpenseItemManager(HisUserContext userContext, String hospitalId, String name, BigDecimal price, String expenseTypeId ,String [] tokensExpr)  throws Exception;
	
	public  Hospital addExpenseItem(HisUserContext userContext, String hospitalId, String name, BigDecimal price, String expenseTypeId , String [] tokensExpr)  throws Exception;
	public  Hospital removeExpenseItem(HisUserContext userContext, String hospitalId, String expenseItemId, int expenseItemVersion,String [] tokensExpr)  throws Exception;
	public  Hospital updateExpenseItem(HisUserContext userContext, String hospitalId, String expenseItemId, int expenseItemVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  DoctorManager getDoctorManager(HisUserContext userContext, String hospitalId, String name, String shotImage ,String [] tokensExpr)  throws Exception;
	
	public  Hospital addDoctor(HisUserContext userContext, String hospitalId, String name, String shotImage , String [] tokensExpr)  throws Exception;
	public  Hospital removeDoctor(HisUserContext userContext, String hospitalId, String doctorId, int doctorVersion,String [] tokensExpr)  throws Exception;
	public  Hospital updateDoctor(HisUserContext userContext, String hospitalId, String doctorId, int doctorVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  DepartmentManager getDepartmentManager(HisUserContext userContext, String hospitalId, String name ,String [] tokensExpr)  throws Exception;
	
	public  Hospital addDepartment(HisUserContext userContext, String hospitalId, String name , String [] tokensExpr)  throws Exception;
	public  Hospital removeDepartment(HisUserContext userContext, String hospitalId, String departmentId, int departmentVersion,String [] tokensExpr)  throws Exception;
	public  Hospital updateDepartment(HisUserContext userContext, String hospitalId, String departmentId, int departmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  DoctorScheduleManager getDoctorScheduleManager(HisUserContext userContext, String hospitalId, String name, String doctorId, Date scheduleDate, String periodId, String departmentId, int available, BigDecimal price, String expenseTypeId ,String [] tokensExpr)  throws Exception;
	
	public  Hospital addDoctorSchedule(HisUserContext userContext, String hospitalId, String name, String doctorId, Date scheduleDate, String periodId, String departmentId, int available, BigDecimal price, String expenseTypeId , String [] tokensExpr)  throws Exception;
	public  Hospital removeDoctorSchedule(HisUserContext userContext, String hospitalId, String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr)  throws Exception;
	public  Hospital updateDoctorSchedule(HisUserContext userContext, String hospitalId, String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


