
package com.doublechaintech.his.period;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.his.BaseRowMapper;
import com.doublechaintech.his.hospital.Hospital;

public class PeriodMapper extends BaseRowMapper<Period>{
	
	protected Period internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Period period = getPeriod();		
		 		
 		setId(period, rs, rowNumber); 		
 		setName(period, rs, rowNumber); 		
 		setCode(period, rs, rowNumber); 		
 		setHospital(period, rs, rowNumber); 		
 		setVersion(period, rs, rowNumber);

		return period;
	}
	
	protected Period getPeriod(){
		return new Period();
	}		
		
	protected void setId(Period period, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(PeriodTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		period.setId(id);
	}
		
	protected void setName(Period period, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(PeriodTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		period.setName(name);
	}
		
	protected void setCode(Period period, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String code = rs.getString(PeriodTable.COLUMN_CODE);
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		period.setCode(code);
	}
		 		
 	protected void setHospital(Period period, ResultSet rs, int rowNumber) throws SQLException{
 		String hospitalId = rs.getString(PeriodTable.COLUMN_HOSPITAL);
 		if( hospitalId == null){
 			return;
 		}
 		if( hospitalId.isEmpty()){
 			return;
 		}
 		Hospital hospital = period.getHospital();
 		if( hospital != null ){
 			//if the root object 'period' already have the property, just set the id for it;
 			hospital.setId(hospitalId);
 			
 			return;
 		}
 		period.setHospital(createEmptyHospital(hospitalId));
 	}
 	
	protected void setVersion(Period period, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(PeriodTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		period.setVersion(version);
	}
		
		

 	protected Hospital  createEmptyHospital(String hospitalId){
 		Hospital hospital = new Hospital();
 		hospital.setId(hospitalId);
 		hospital.setVersion(Integer.MAX_VALUE);
 		return hospital;
 	}
 	
}


