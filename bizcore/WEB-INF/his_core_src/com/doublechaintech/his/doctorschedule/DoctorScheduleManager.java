
package com.doublechaintech.his.doctorschedule;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface DoctorScheduleManager extends BaseManager{

		

	public DoctorSchedule createDoctorSchedule(HisUserContext userContext, String name,String doctorId,Date scheduleDate,String periodId,String departmentId,int available,BigDecimal price,String expenseTypeId,String hospitalId) throws Exception;
	public DoctorSchedule updateDoctorSchedule(HisUserContext userContext,String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public DoctorSchedule loadDoctorSchedule(HisUserContext userContext, String doctorScheduleId, String [] tokensExpr) throws Exception;
	public DoctorSchedule internalSaveDoctorSchedule(HisUserContext userContext, DoctorSchedule doctorSchedule) throws Exception;
	public DoctorSchedule internalSaveDoctorSchedule(HisUserContext userContext, DoctorSchedule doctorSchedule,Map<String,Object>option) throws Exception;

	public DoctorSchedule transferToAnotherDoctor(HisUserContext userContext, String doctorScheduleId, String anotherDoctorId)  throws Exception;
 	public DoctorSchedule transferToAnotherPeriod(HisUserContext userContext, String doctorScheduleId, String anotherPeriodId)  throws Exception;
 	public DoctorSchedule transferToAnotherDepartment(HisUserContext userContext, String doctorScheduleId, String anotherDepartmentId)  throws Exception;
 	public DoctorSchedule transferToAnotherExpenseType(HisUserContext userContext, String doctorScheduleId, String anotherExpenseTypeId)  throws Exception;
 	public DoctorSchedule transferToAnotherHospital(HisUserContext userContext, String doctorScheduleId, String anotherHospitalId)  throws Exception;
 

	public void delete(HisUserContext userContext, String doctorScheduleId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, DoctorSchedule newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByDoctor(HisUserContext userContext,String doctorId) throws Exception;
	public Object listPageByDoctor(HisUserContext userContext,String doctorId, int start, int count) throws Exception;
  
	public Object listByPeriod(HisUserContext userContext,String periodId) throws Exception;
	public Object listPageByPeriod(HisUserContext userContext,String periodId, int start, int count) throws Exception;
  
	public Object listByDepartment(HisUserContext userContext,String departmentId) throws Exception;
	public Object listPageByDepartment(HisUserContext userContext,String departmentId, int start, int count) throws Exception;
  
	public Object listByExpenseType(HisUserContext userContext,String expenseTypeId) throws Exception;
	public Object listPageByExpenseType(HisUserContext userContext,String expenseTypeId, int start, int count) throws Exception;
  
	public Object listByHospital(HisUserContext userContext,String hospitalId) throws Exception;
	public Object listPageByHospital(HisUserContext userContext,String hospitalId, int start, int count) throws Exception;
  

}


