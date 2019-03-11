
package com.panfeng.his.doctorassignment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.panfeng.his.BaseRowMapper;
import com.panfeng.his.doctor.Doctor;
import com.panfeng.his.department.Department;

public class DoctorAssignmentMapper extends BaseRowMapper<DoctorAssignment>{
	
	protected DoctorAssignment internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		DoctorAssignment doctorAssignment = getDoctorAssignment();		
		 		
 		setId(doctorAssignment, rs, rowNumber); 		
 		setName(doctorAssignment, rs, rowNumber); 		
 		setDoctor(doctorAssignment, rs, rowNumber); 		
 		setDepartment(doctorAssignment, rs, rowNumber); 		
 		setVersion(doctorAssignment, rs, rowNumber);

		return doctorAssignment;
	}
	
	protected DoctorAssignment getDoctorAssignment(){
		return new DoctorAssignment();
	}		
		
	protected void setId(DoctorAssignment doctorAssignment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(DoctorAssignmentTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		doctorAssignment.setId(id);
	}
		
	protected void setName(DoctorAssignment doctorAssignment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(DoctorAssignmentTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		doctorAssignment.setName(name);
	}
		 		
 	protected void setDoctor(DoctorAssignment doctorAssignment, ResultSet rs, int rowNumber) throws SQLException{
 		String doctorId = rs.getString(DoctorAssignmentTable.COLUMN_DOCTOR);
 		if( doctorId == null){
 			return;
 		}
 		if( doctorId.isEmpty()){
 			return;
 		}
 		Doctor doctor = doctorAssignment.getDoctor();
 		if( doctor != null ){
 			//if the root object 'doctorAssignment' already have the property, just set the id for it;
 			doctor.setId(doctorId);
 			
 			return;
 		}
 		doctorAssignment.setDoctor(createEmptyDoctor(doctorId));
 	}
 	 		
 	protected void setDepartment(DoctorAssignment doctorAssignment, ResultSet rs, int rowNumber) throws SQLException{
 		String departmentId = rs.getString(DoctorAssignmentTable.COLUMN_DEPARTMENT);
 		if( departmentId == null){
 			return;
 		}
 		if( departmentId.isEmpty()){
 			return;
 		}
 		Department department = doctorAssignment.getDepartment();
 		if( department != null ){
 			//if the root object 'doctorAssignment' already have the property, just set the id for it;
 			department.setId(departmentId);
 			
 			return;
 		}
 		doctorAssignment.setDepartment(createEmptyDepartment(departmentId));
 	}
 	
	protected void setVersion(DoctorAssignment doctorAssignment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(DoctorAssignmentTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		doctorAssignment.setVersion(version);
	}
		
		

 	protected Doctor  createEmptyDoctor(String doctorId){
 		Doctor doctor = new Doctor();
 		doctor.setId(doctorId);
 		doctor.setVersion(Integer.MAX_VALUE);
 		return doctor;
 	}
 	
 	protected Department  createEmptyDepartment(String departmentId){
 		Department department = new Department();
 		department.setId(departmentId);
 		department.setVersion(Integer.MAX_VALUE);
 		return department;
 	}
 	
}


