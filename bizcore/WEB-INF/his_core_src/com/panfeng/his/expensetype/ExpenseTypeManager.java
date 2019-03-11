
package com.panfeng.his.expensetype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.panfeng.his.HisUserContext;
import com.panfeng.his.BaseEntity;
import com.panfeng.his.SmartList;

public interface ExpenseTypeManager{

		

	public ExpenseType createExpenseType(HisUserContext userContext, String name, String helperChars, String status, String hospitalId, String description) throws Exception;	
	public ExpenseType updateExpenseType(HisUserContext userContext,String expenseTypeId, int expenseTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ExpenseType loadExpenseType(HisUserContext userContext, String expenseTypeId, String [] tokensExpr) throws Exception;
	public ExpenseType internalSaveExpenseType(HisUserContext userContext, ExpenseType expenseType) throws Exception;
	public ExpenseType internalSaveExpenseType(HisUserContext userContext, ExpenseType expenseType,Map<String,Object>option) throws Exception;
	
	public ExpenseType transferToAnotherHospital(HisUserContext userContext, String expenseTypeId, String anotherHospitalId)  throws Exception;
 

	public void delete(HisUserContext userContext, String expenseTypeId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, ExpenseType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ExpenseItemManager getExpenseItemManager(HisUserContext userContext, String expenseTypeId, String name, BigDecimal price, String hospitalId ,String [] tokensExpr)  throws Exception;
	
	public  ExpenseType addExpenseItem(HisUserContext userContext, String expenseTypeId, String name, BigDecimal price, String hospitalId , String [] tokensExpr)  throws Exception;
	public  ExpenseType removeExpenseItem(HisUserContext userContext, String expenseTypeId, String expenseItemId, int expenseItemVersion,String [] tokensExpr)  throws Exception;
	public  ExpenseType updateExpenseItem(HisUserContext userContext, String expenseTypeId, String expenseItemId, int expenseItemVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  DoctorScheduleManager getDoctorScheduleManager(HisUserContext userContext, String expenseTypeId, String name, Date scheduleDate, String period, String doctorId, int available, BigDecimal price, String departmentId ,String [] tokensExpr)  throws Exception;
	
	public  ExpenseType addDoctorSchedule(HisUserContext userContext, String expenseTypeId, String name, Date scheduleDate, String period, String doctorId, int available, BigDecimal price, String departmentId , String [] tokensExpr)  throws Exception;
	public  ExpenseType removeDoctorSchedule(HisUserContext userContext, String expenseTypeId, String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr)  throws Exception;
	public  ExpenseType updateDoctorSchedule(HisUserContext userContext, String expenseTypeId, String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


