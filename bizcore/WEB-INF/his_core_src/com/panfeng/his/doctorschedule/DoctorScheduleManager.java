
package com.panfeng.his.doctorschedule;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.panfeng.his.HisUserContext;
import com.panfeng.his.BaseEntity;
import com.panfeng.his.SmartList;

public interface DoctorScheduleManager{

		

	public DoctorSchedule createDoctorSchedule(HisUserContext userContext, String name, Date scheduleDate, String period, String doctorId, int available, BigDecimal price, String expenseTypeId, String departmentId) throws Exception;	
	public DoctorSchedule updateDoctorSchedule(HisUserContext userContext,String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public DoctorSchedule loadDoctorSchedule(HisUserContext userContext, String doctorScheduleId, String [] tokensExpr) throws Exception;
	public DoctorSchedule internalSaveDoctorSchedule(HisUserContext userContext, DoctorSchedule doctorSchedule) throws Exception;
	public DoctorSchedule internalSaveDoctorSchedule(HisUserContext userContext, DoctorSchedule doctorSchedule,Map<String,Object>option) throws Exception;
	
	public DoctorSchedule transferToAnotherDoctor(HisUserContext userContext, String doctorScheduleId, String anotherDoctorId)  throws Exception;
 	public DoctorSchedule transferToAnotherExpenseType(HisUserContext userContext, String doctorScheduleId, String anotherExpenseTypeId)  throws Exception;
 	public DoctorSchedule transferToAnotherDepartment(HisUserContext userContext, String doctorScheduleId, String anotherDepartmentId)  throws Exception;
 

	public void delete(HisUserContext userContext, String doctorScheduleId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, DoctorSchedule newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


