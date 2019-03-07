
package com.doublechaintech.his.doctor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.his.BaseRowMapper;
import com.doublechaintech.his.platform.Platform;

public class DoctorMapper extends BaseRowMapper<Doctor>{
	
	protected Doctor internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Doctor doctor = getDoctor();		
		 		
 		setId(doctor, rs, rowNumber); 		
 		setName(doctor, rs, rowNumber); 		
 		setPlatform(doctor, rs, rowNumber); 		
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
		 		
 	protected void setPlatform(Doctor doctor, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(DoctorTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = doctor.getPlatform();
 		if( platform != null ){
 			//if the root object 'doctor' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		doctor.setPlatform(createEmptyPlatform(platformId));
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
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


