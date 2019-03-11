
package com.panfeng.his.hospital;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.panfeng.his.BaseRowMapper;

public class HospitalMapper extends BaseRowMapper<Hospital>{
	
	protected Hospital internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Hospital hospital = getHospital();		
		 		
 		setId(hospital, rs, rowNumber); 		
 		setName(hospital, rs, rowNumber); 		
 		setAddress(hospital, rs, rowNumber); 		
 		setTelephone(hospital, rs, rowNumber); 		
 		setVersion(hospital, rs, rowNumber);

		return hospital;
	}
	
	protected Hospital getHospital(){
		return new Hospital();
	}		
		
	protected void setId(Hospital hospital, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(HospitalTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		hospital.setId(id);
	}
		
	protected void setName(Hospital hospital, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(HospitalTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		hospital.setName(name);
	}
		
	protected void setAddress(Hospital hospital, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String address = rs.getString(HospitalTable.COLUMN_ADDRESS);
		if(address == null){
			//do nothing when nothing found in database
			return;
		}
		
		hospital.setAddress(address);
	}
		
	protected void setTelephone(Hospital hospital, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String telephone = rs.getString(HospitalTable.COLUMN_TELEPHONE);
		if(telephone == null){
			//do nothing when nothing found in database
			return;
		}
		
		hospital.setTelephone(telephone);
	}
		
	protected void setVersion(Hospital hospital, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(HospitalTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		hospital.setVersion(version);
	}
		
		

}


