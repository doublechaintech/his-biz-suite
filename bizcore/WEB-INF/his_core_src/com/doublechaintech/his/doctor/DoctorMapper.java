
package com.doublechaintech.his.doctor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.his.BaseRowMapper;
import com.doublechaintech.his.hospital.Hospital;

public class DoctorMapper extends BaseRowMapper<Doctor>{
	
	protected Doctor internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Doctor doctor = getDoctor();		
		 		
 		setId(doctor, rs, rowNumber); 		
 		setName(doctor, rs, rowNumber); 		
 		setShotImage(doctor, rs, rowNumber); 		
 		setHospital(doctor, rs, rowNumber); 		
 		setUpdateTime(doctor, rs, rowNumber); 		
 		setVersion(doctor, rs, rowNumber);

		return doctor;
	}
	
	protected Doctor getDoctor(){
		return new Doctor();
	}		
		
	protected void setId(Doctor doctor, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(DoctorTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		doctor.setId(id);
	}
		
	protected void setName(Doctor doctor, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(DoctorTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		doctor.setName(name);
	}
		
	protected void setShotImage(Doctor doctor, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String shotImage = rs.getString(DoctorTable.COLUMN_SHOT_IMAGE);
		
		if(shotImage == null){
			//do nothing when nothing found in database
			return;
		}
		
		doctor.setShotImage(shotImage);
	}
		 		
 	protected void setHospital(Doctor doctor, ResultSet rs, int rowNumber) throws SQLException{
 		String hospitalId = rs.getString(DoctorTable.COLUMN_HOSPITAL);
 		if( hospitalId == null){
 			return;
 		}
 		if( hospitalId.isEmpty()){
 			return;
 		}
 		Hospital hospital = doctor.getHospital();
 		if( hospital != null ){
 			//if the root object 'doctor' already have the property, just set the id for it;
 			hospital.setId(hospitalId);
 			
 			return;
 		}
 		doctor.setHospital(createEmptyHospital(hospitalId));
 	}
 	
	protected void setUpdateTime(Doctor doctor, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date updateTime = rs.getTimestamp(DoctorTable.COLUMN_UPDATE_TIME);
		
		if(updateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		doctor.setUpdateTime(convertToDateTime(updateTime));
	}
		
	protected void setVersion(Doctor doctor, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(DoctorTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		doctor.setVersion(version);
	}
		
		

 	protected Hospital  createEmptyHospital(String hospitalId){
 		Hospital hospital = new Hospital();
 		hospital.setId(hospitalId);
 		hospital.setVersion(Integer.MAX_VALUE);
 		return hospital;
 	}
 	
}


