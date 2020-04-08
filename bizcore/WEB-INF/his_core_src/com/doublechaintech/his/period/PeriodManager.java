
package com.doublechaintech.his.period;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface PeriodManager extends BaseManager{

		


	public Period loadPeriodWithCode(HisUserContext userContext, String code, Map<String,Object>tokens) throws Exception;

	 

	public Period createPeriod(HisUserContext userContext, String name,String code,String hospitalId) throws Exception;
	public Period updatePeriod(HisUserContext userContext,String periodId, int periodVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Period loadPeriod(HisUserContext userContext, String periodId, String [] tokensExpr) throws Exception;
	public Period internalSavePeriod(HisUserContext userContext, Period period) throws Exception;
	public Period internalSavePeriod(HisUserContext userContext, Period period,Map<String,Object>option) throws Exception;

	public Period transferToAnotherHospital(HisUserContext userContext, String periodId, String anotherHospitalId)  throws Exception;
 

	public void delete(HisUserContext userContext, String periodId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, Period newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  DoctorScheduleManager getDoctorScheduleManager(HisUserContext userContext, String periodId, String name, String doctorId, Date scheduleDate, String departmentId, int available, BigDecimal price, String expenseTypeId, String hospitalId ,String [] tokensExpr)  throws Exception;

	public  Period addDoctorSchedule(HisUserContext userContext, String periodId, String name, String doctorId, Date scheduleDate, String departmentId, int available, BigDecimal price, String expenseTypeId, String hospitalId , String [] tokensExpr)  throws Exception;
	public  Period removeDoctorSchedule(HisUserContext userContext, String periodId, String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr)  throws Exception;
	public  Period updateDoctorSchedule(HisUserContext userContext, String periodId, String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByHospital(HisUserContext userContext,String hospitalId) throws Exception;
	public Object listPageByHospital(HisUserContext userContext,String hospitalId, int start, int count) throws Exception;
  

}


