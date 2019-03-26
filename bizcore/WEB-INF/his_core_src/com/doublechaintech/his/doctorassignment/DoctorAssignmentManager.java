
package com.doublechaintech.his.doctorassignment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;

public interface DoctorAssignmentManager{

		

	public DoctorAssignment createDoctorAssignment(HisUserContext userContext, String name, String doctorId, String departmentId) throws Exception;	
	public DoctorAssignment updateDoctorAssignment(HisUserContext userContext,String doctorAssignmentId, int doctorAssignmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public DoctorAssignment loadDoctorAssignment(HisUserContext userContext, String doctorAssignmentId, String [] tokensExpr) throws Exception;
	public DoctorAssignment internalSaveDoctorAssignment(HisUserContext userContext, DoctorAssignment doctorAssignment) throws Exception;
	public DoctorAssignment internalSaveDoctorAssignment(HisUserContext userContext, DoctorAssignment doctorAssignment,Map<String,Object>option) throws Exception;
	
	public DoctorAssignment transferToAnotherDoctor(HisUserContext userContext, String doctorAssignmentId, String anotherDoctorId)  throws Exception;
 	public DoctorAssignment transferToAnotherDepartment(HisUserContext userContext, String doctorAssignmentId, String anotherDepartmentId)  throws Exception;
 

	public void delete(HisUserContext userContext, String doctorAssignmentId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, DoctorAssignment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


