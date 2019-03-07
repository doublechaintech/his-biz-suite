
package com.doublechaintech.his.registration;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.his.BaseRowMapper;
import com.doublechaintech.his.profile.Profile;
import com.doublechaintech.his.platform.Platform;

public class RegistrationMapper extends BaseRowMapper<Registration>{
	
	protected Registration internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Registration registration = getRegistration();		
		 		
 		setId(registration, rs, rowNumber); 		
 		setTitle(registration, rs, rowNumber); 		
 		setPatient(registration, rs, rowNumber); 		
 		setRegister(registration, rs, rowNumber); 		
 		setContent(registration, rs, rowNumber); 		
 		setUpdateTime(registration, rs, rowNumber); 		
 		setStatus(registration, rs, rowNumber); 		
 		setPlatform(registration, rs, rowNumber); 		
 		setVersion(registration, rs, rowNumber);

		return registration;
	}
	
	protected Registration getRegistration(){
		return new Registration();
	}		
		
	protected void setId(Registration registration, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(RegistrationTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		registration.setId(id);
	}
		
	protected void setTitle(Registration registration, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String title = rs.getString(RegistrationTable.COLUMN_TITLE);
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		registration.setTitle(title);
	}
		 		
 	protected void setPatient(Registration registration, ResultSet rs, int rowNumber) throws SQLException{
 		String profileId = rs.getString(RegistrationTable.COLUMN_PATIENT);
 		if( profileId == null){
 			return;
 		}
 		if( profileId.isEmpty()){
 			return;
 		}
 		Profile profile = registration.getPatient();
 		if( profile != null ){
 			//if the root object 'registration' already have the property, just set the id for it;
 			profile.setId(profileId);
 			
 			return;
 		}
 		registration.setPatient(createEmptyPatient(profileId));
 	}
 	 		
 	protected void setRegister(Registration registration, ResultSet rs, int rowNumber) throws SQLException{
 		String profileId = rs.getString(RegistrationTable.COLUMN_REGISTER);
 		if( profileId == null){
 			return;
 		}
 		if( profileId.isEmpty()){
 			return;
 		}
 		Profile profile = registration.getRegister();
 		if( profile != null ){
 			//if the root object 'registration' already have the property, just set the id for it;
 			profile.setId(profileId);
 			
 			return;
 		}
 		registration.setRegister(createEmptyRegister(profileId));
 	}
 	
	protected void setContent(Registration registration, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String content = rs.getString(RegistrationTable.COLUMN_CONTENT);
		if(content == null){
			//do nothing when nothing found in database
			return;
		}
		
		registration.setContent(content);
	}
		
	protected void setUpdateTime(Registration registration, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date updateTime = rs.getTimestamp(RegistrationTable.COLUMN_UPDATE_TIME);
		if(updateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		registration.setUpdateTime(convertToDateTime(updateTime));
	}
		
	protected void setStatus(Registration registration, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String status = rs.getString(RegistrationTable.COLUMN_STATUS);
		if(status == null){
			//do nothing when nothing found in database
			return;
		}
		
		registration.setStatus(status);
	}
		 		
 	protected void setPlatform(Registration registration, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(RegistrationTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = registration.getPlatform();
 		if( platform != null ){
 			//if the root object 'registration' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		registration.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(Registration registration, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(RegistrationTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		registration.setVersion(version);
	}
		
		

 	protected Profile  createEmptyPatient(String profileId){
 		Profile profile = new Profile();
 		profile.setId(profileId);
 		profile.setVersion(Integer.MAX_VALUE);
 		return profile;
 	}
 	
 	protected Profile  createEmptyRegister(String profileId){
 		Profile profile = new Profile();
 		profile.setId(profileId);
 		profile.setVersion(Integer.MAX_VALUE);
 		return profile;
 	}
 	
 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


