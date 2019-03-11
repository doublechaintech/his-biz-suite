
package com.panfeng.his.doctor;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.panfeng.his.HisUserContext;
import com.panfeng.his.BaseEntity;
import com.panfeng.his.SmartList;

public interface DoctorManager{

		

	public Doctor createDoctor(HisUserContext userContext, String name, String hospitalId) throws Exception;	
	public Doctor updateDoctor(HisUserContext userContext,String doctorId, int doctorVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Doctor loadDoctor(HisUserContext userContext, String doctorId, String [] tokensExpr) throws Exception;
	public Doctor internalSaveDoctor(HisUserContext userContext, Doctor doctor) throws Exception;
	public Doctor internalSaveDoctor(HisUserContext userContext, Doctor doctor,Map<String,Object>option) throws Exception;
	
	public Doctor transferToAnotherHospital(HisUserContext userContext, String doctorId, String anotherHospitalId)  throws Exception;
 

	public void delete(HisUserContext userContext, String doctorId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, Doctor newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  DoctorAssignmentManager getDoctorAssignmentManager(HisUserContext userContext, String doctorId, String name, String departmentId ,String [] tokensExpr)  throws Exception;
	
	public  Doctor addDoctorAssignment(HisUserContext userContext, String doctorId, String name, String departmentId , String [] tokensExpr)  throws Exception;
	public  Doctor removeDoctorAssignment(HisUserContext userContext, String doctorId, String doctorAssignmentId, int doctorAssignmentVersion,String [] tokensExpr)  throws Exception;
	public  Doctor updateDoctorAssignment(HisUserContext userContext, String doctorId, String doctorAssignmentId, int doctorAssignmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  DoctorScheduleManager getDoctorScheduleManager(HisUserContext userContext, String doctorId, String name, Date scheduleDate, String period, int available, BigDecimal price, String expenseTypeId, String departmentId ,String [] tokensExpr)  throws Exception;
	
	public  Doctor addDoctorSchedule(HisUserContext userContext, String doctorId, String name, Date scheduleDate, String period, int available, BigDecimal price, String expenseTypeId, String departmentId , String [] tokensExpr)  throws Exception;
	public  Doctor removeDoctorSchedule(HisUserContext userContext, String doctorId, String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr)  throws Exception;
	public  Doctor updateDoctorSchedule(HisUserContext userContext, String doctorId, String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


