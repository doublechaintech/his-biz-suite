
package com.doublechaintech.his.platform;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.his.BaseRowMapper;

public class PlatformMapper extends BaseRowMapper<Platform>{
	
	protected Platform internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Platform platform = getPlatform();		
		 		
 		setId(platform, rs, rowNumber); 		
 		setName(platform, rs, rowNumber); 		
 		setIntroduction(platform, rs, rowNumber); 		
 		setCurrentVersion(platform, rs, rowNumber); 		
 		setVersion(platform, rs, rowNumber);

		return platform;
	}
	
	protected Platform getPlatform(){
		return new Platform();
	}		
		
	protected void setId(Platform platform, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(PlatformTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		platform.setId(id);
	}
		
	protected void setName(Platform platform, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(PlatformTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		platform.setName(name);
	}
		
	protected void setIntroduction(Platform platform, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String introduction = rs.getString(PlatformTable.COLUMN_INTRODUCTION);
		if(introduction == null){
			//do nothing when nothing found in database
			return;
		}
		
		platform.setIntroduction(introduction);
	}
		
	protected void setCurrentVersion(Platform platform, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String currentVersion = rs.getString(PlatformTable.COLUMN_CURRENT_VERSION);
		if(currentVersion == null){
			//do nothing when nothing found in database
			return;
		}
		
		platform.setCurrentVersion(currentVersion);
	}
		
	protected void setVersion(Platform platform, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(PlatformTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		platform.setVersion(version);
	}
		
		

}


