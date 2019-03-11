
package com.panfeng.his.doctorschedule;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.panfeng.his.BaseRowMapper;
import com.panfeng.his.doctor.Doctor;
import com.panfeng.his.department.Department;
import com.panfeng.his.expensetype.ExpenseType;

public class DoctorScheduleMapper extends BaseRowMapper<DoctorSchedule>{
	
	protected DoctorSchedule internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		DoctorSchedule doctorSchedule = getDoctorSchedule();		
		 		
 		setId(doctorSchedule, rs, rowNumber); 		
 		setName(doctorSchedule, rs, rowNumber); 		
 		setScheduleDate(doctorSchedule, rs, rowNumber); 		
 		setPeriod(doctorSchedule, rs, rowNumber); 		
 		setDoctor(doctorSchedule, rs, rowNumber); 		
 		setAvailable(doctorSchedule, rs, rowNumber); 		
 		setPrice(doctorSchedule, rs, rowNumber); 		
 		setExpenseType(doctorSchedule, rs, rowNumber); 		
 		setDepartment(doctorSchedule, rs, rowNumber); 		
 		setVersion(doctorSchedule, rs, rowNumber);

		return doctorSchedule;
	}
	
	protected DoctorSchedule getDoctorSchedule(){
		return new DoctorSchedule();
	}		
		
	protected void setId(DoctorSchedule doctorSchedule, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(DoctorScheduleTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		doctorSchedule.setId(id);
	}
		
	protected void setName(DoctorSchedule doctorSchedule, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(DoctorScheduleTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		doctorSchedule.setName(name);
	}
		
	protected void setScheduleDate(DoctorSchedule doctorSchedule, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date scheduleDate = rs.getDate(DoctorScheduleTable.COLUMN_SCHEDULE_DATE);
		if(scheduleDate == null){
			//do nothing when nothing found in database
			return;
		}
		
		doctorSchedule.setScheduleDate(scheduleDate);
	}
		
	protected void setPeriod(DoctorSchedule doctorSchedule, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String period = rs.getString(DoctorScheduleTable.COLUMN_PERIOD);
		if(period == null){
			//do nothing when nothing found in database
			return;
		}
		
		doctorSchedule.setPeriod(period);
	}
		 		
 	protected void setDoctor(DoctorSchedule doctorSchedule, ResultSet rs, int rowNumber) throws SQLException{
 		String doctorId = rs.getString(DoctorScheduleTable.COLUMN_DOCTOR);
 		if( doctorId == null){
 			return;
 		}
 		if( doctorId.isEmpty()){
 			return;
 		}
 		Doctor doctor = doctorSchedule.getDoctor();
 		if( doctor != null ){
 			//if the root object 'doctorSchedule' already have the property, just set the id for it;
 			doctor.setId(doctorId);
 			
 			return;
 		}
 		doctorSchedule.setDoctor(createEmptyDoctor(doctorId));
 	}
 	
	protected void setAvailable(DoctorSchedule doctorSchedule, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer available = rs.getInt(DoctorScheduleTable.COLUMN_AVAILABLE);
		if(available == null){
			//do nothing when nothing found in database
			return;
		}
		
		doctorSchedule.setAvailable(available);
	}
		
	protected void setPrice(DoctorSchedule doctorSchedule, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal price = rs.getBigDecimal(DoctorScheduleTable.COLUMN_PRICE);
		if(price == null){
			//do nothing when nothing found in database
			return;
		}
		
		doctorSchedule.setPrice(price);
	}
		 		
 	protected void setExpenseType(DoctorSchedule doctorSchedule, ResultSet rs, int rowNumber) throws SQLException{
 		String expenseTypeId = rs.getString(DoctorScheduleTable.COLUMN_EXPENSE_TYPE);
 		if( expenseTypeId == null){
 			return;
 		}
 		if( expenseTypeId.isEmpty()){
 			return;
 		}
 		ExpenseType expenseType = doctorSchedule.getExpenseType();
 		if( expenseType != null ){
 			//if the root object 'doctorSchedule' already have the property, just set the id for it;
 			expenseType.setId(expenseTypeId);
 			
 			return;
 		}
 		doctorSchedule.setExpenseType(createEmptyExpenseType(expenseTypeId));
 	}
 	 		
 	protected void setDepartment(DoctorSchedule doctorSchedule, ResultSet rs, int rowNumber) throws SQLException{
 		String departmentId = rs.getString(DoctorScheduleTable.COLUMN_DEPARTMENT);
 		if( departmentId == null){
 			return;
 		}
 		if( departmentId.isEmpty()){
 			return;
 		}
 		Department department = doctorSchedule.getDepartment();
 		if( department != null ){
 			//if the root object 'doctorSchedule' already have the property, just set the id for it;
 			department.setId(departmentId);
 			
 			return;
 		}
 		doctorSchedule.setDepartment(createEmptyDepartment(departmentId));
 	}
 	
	protected void setVersion(DoctorSchedule doctorSchedule, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(DoctorScheduleTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		doctorSchedule.setVersion(version);
	}
		
		

 	protected Doctor  createEmptyDoctor(String doctorId){
 		Doctor doctor = new Doctor();
 		doctor.setId(doctorId);
 		doctor.setVersion(Integer.MAX_VALUE);
 		return doctor;
 	}
 	
 	protected ExpenseType  createEmptyExpenseType(String expenseTypeId){
 		ExpenseType expenseType = new ExpenseType();
 		expenseType.setId(expenseTypeId);
 		expenseType.setVersion(Integer.MAX_VALUE);
 		return expenseType;
 	}
 	
 	protected Department  createEmptyDepartment(String departmentId){
 		Department department = new Department();
 		department.setId(departmentId);
 		department.setVersion(Integer.MAX_VALUE);
 		return department;
 	}
 	
}


