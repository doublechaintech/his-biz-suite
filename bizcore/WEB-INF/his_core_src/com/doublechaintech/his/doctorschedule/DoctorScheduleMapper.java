
package com.doublechaintech.his.doctorschedule;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.his.BaseRowMapper;
import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;

public class DoctorScheduleMapper extends BaseRowMapper<DoctorSchedule>{
	
	protected DoctorSchedule internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		DoctorSchedule doctorSchedule = getDoctorSchedule();		
		 		
 		setId(doctorSchedule, rs, rowNumber); 		
 		setName(doctorSchedule, rs, rowNumber); 		
 		setDoctor(doctorSchedule, rs, rowNumber); 		
 		setScheduleDate(doctorSchedule, rs, rowNumber); 		
 		setPeriod(doctorSchedule, rs, rowNumber); 		
 		setDepartment(doctorSchedule, rs, rowNumber); 		
 		setAvailable(doctorSchedule, rs, rowNumber); 		
 		setPrice(doctorSchedule, rs, rowNumber); 		
 		setExpenseType(doctorSchedule, rs, rowNumber); 		
 		setCreateTime(doctorSchedule, rs, rowNumber); 		
 		setUpdateTime(doctorSchedule, rs, rowNumber); 		
 		setHospital(doctorSchedule, rs, rowNumber); 		
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
		 		
 	protected void setDoctor(DoctorSchedule doctorSchedule, ResultSet rs, int rowNumber) throws SQLException{
 		String doctorId = rs.getString(DoctorScheduleTable.COLUMN_DOCTOR);
 		if( doctorId == null){
 			return;
 		}
 		if( doctorId.isEmpty()){
 			return;
 		}
 		Doctor ldoctor = doctorSchedule.getDoctor();
 		if( ldoctor != null ){
 			//if the root object 'doctorSchedule' already have the property, just set the id for it;
 			ldoctor.setId(doctorId);
 			
 			return;
 		}
 		doctorSchedule.setDoctor(createEmptyDoctor(doctorId));
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
 		String periodId = rs.getString(DoctorScheduleTable.COLUMN_PERIOD);
 		if( periodId == null){
 			return;
 		}
 		if( periodId.isEmpty()){
 			return;
 		}
 		Period lperiod = doctorSchedule.getPeriod();
 		if( lperiod != null ){
 			//if the root object 'doctorSchedule' already have the property, just set the id for it;
 			lperiod.setId(periodId);
 			
 			return;
 		}
 		doctorSchedule.setPeriod(createEmptyPeriod(periodId));
 	}
 	 		
 	protected void setDepartment(DoctorSchedule doctorSchedule, ResultSet rs, int rowNumber) throws SQLException{
 		String departmentId = rs.getString(DoctorScheduleTable.COLUMN_DEPARTMENT);
 		if( departmentId == null){
 			return;
 		}
 		if( departmentId.isEmpty()){
 			return;
 		}
 		Department ldepartment = doctorSchedule.getDepartment();
 		if( ldepartment != null ){
 			//if the root object 'doctorSchedule' already have the property, just set the id for it;
 			ldepartment.setId(departmentId);
 			
 			return;
 		}
 		doctorSchedule.setDepartment(createEmptyDepartment(departmentId));
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
 		ExpenseType lexpenseType = doctorSchedule.getExpenseType();
 		if( lexpenseType != null ){
 			//if the root object 'doctorSchedule' already have the property, just set the id for it;
 			lexpenseType.setId(expenseTypeId);
 			
 			return;
 		}
 		doctorSchedule.setExpenseType(createEmptyExpenseType(expenseTypeId));
 	}
 	
	protected void setCreateTime(DoctorSchedule doctorSchedule, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date createTime = rs.getTimestamp(DoctorScheduleTable.COLUMN_CREATE_TIME);
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		doctorSchedule.setCreateTime(convertToDateTime(createTime));
	}
		
	protected void setUpdateTime(DoctorSchedule doctorSchedule, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date updateTime = rs.getTimestamp(DoctorScheduleTable.COLUMN_UPDATE_TIME);
		if(updateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		doctorSchedule.setUpdateTime(convertToDateTime(updateTime));
	}
		 		
 	protected void setHospital(DoctorSchedule doctorSchedule, ResultSet rs, int rowNumber) throws SQLException{
 		String hospitalId = rs.getString(DoctorScheduleTable.COLUMN_HOSPITAL);
 		if( hospitalId == null){
 			return;
 		}
 		if( hospitalId.isEmpty()){
 			return;
 		}
 		Hospital lhospital = doctorSchedule.getHospital();
 		if( lhospital != null ){
 			//if the root object 'doctorSchedule' already have the property, just set the id for it;
 			lhospital.setId(hospitalId);
 			
 			return;
 		}
 		doctorSchedule.setHospital(createEmptyHospital(hospitalId));
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
 	
 	protected Period  createEmptyPeriod(String periodId){
 		Period period = new Period();
 		period.setId(periodId);
 		period.setVersion(Integer.MAX_VALUE);
 		return period;
 	}
 	
 	protected Department  createEmptyDepartment(String departmentId){
 		Department department = new Department();
 		department.setId(departmentId);
 		department.setVersion(Integer.MAX_VALUE);
 		return department;
 	}
 	
 	protected ExpenseType  createEmptyExpenseType(String expenseTypeId){
 		ExpenseType expenseType = new ExpenseType();
 		expenseType.setId(expenseTypeId);
 		expenseType.setVersion(Integer.MAX_VALUE);
 		return expenseType;
 	}
 	
 	protected Hospital  createEmptyHospital(String hospitalId){
 		Hospital hospital = new Hospital();
 		hospital.setId(hospitalId);
 		hospital.setVersion(Integer.MAX_VALUE);
 		return hospital;
 	}
 	
}


