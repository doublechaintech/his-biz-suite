
package com.panfeng.his.department;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.panfeng.his.HisUserContext;
import com.panfeng.his.BaseEntity;
import com.panfeng.his.SmartList;

public interface DepartmentManager{

		

	public Department createDepartment(HisUserContext userContext, String name, String hospitalId) throws Exception;	
	public Department updateDepartment(HisUserContext userContext,String departmentId, int departmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Department loadDepartment(HisUserContext userContext, String departmentId, String [] tokensExpr) throws Exception;
	public Department internalSaveDepartment(HisUserContext userContext, Department department) throws Exception;
	public Department internalSaveDepartment(HisUserContext userContext, Department department,Map<String,Object>option) throws Exception;
	
	public Department transferToAnotherHospital(HisUserContext userContext, String departmentId, String anotherHospitalId)  throws Exception;
 

	public void delete(HisUserContext userContext, String departmentId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, Department newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  DoctorAssignmentManager getDoctorAssignmentManager(HisUserContext userContext, String departmentId, String name, String doctorId ,String [] tokensExpr)  throws Exception;
	
	public  Department addDoctorAssignment(HisUserContext userContext, String departmentId, String name, String doctorId , String [] tokensExpr)  throws Exception;
	public  Department removeDoctorAssignment(HisUserContext userContext, String departmentId, String doctorAssignmentId, int doctorAssignmentVersion,String [] tokensExpr)  throws Exception;
	public  Department updateDoctorAssignment(HisUserContext userContext, String departmentId, String doctorAssignmentId, int doctorAssignmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  DoctorScheduleManager getDoctorScheduleManager(HisUserContext userContext, String departmentId, String name, Date scheduleDate, String period, String doctorId, int available, BigDecimal price, String expenseTypeId ,String [] tokensExpr)  throws Exception;
	
	public  Department addDoctorSchedule(HisUserContext userContext, String departmentId, String name, Date scheduleDate, String period, String doctorId, int available, BigDecimal price, String expenseTypeId , String [] tokensExpr)  throws Exception;
	public  Department removeDoctorSchedule(HisUserContext userContext, String departmentId, String doctorScheduleId, int doctorScheduleVersion,String [] tokensExpr)  throws Exception;
	public  Department updateDoctorSchedule(HisUserContext userContext, String departmentId, String doctorScheduleId, int doctorScheduleVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


