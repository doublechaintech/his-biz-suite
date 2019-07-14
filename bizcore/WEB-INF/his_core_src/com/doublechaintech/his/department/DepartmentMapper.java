
package com.doublechaintech.his.department;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.his.BaseRowMapper;
import com.doublechaintech.his.hospital.Hospital;

public class DepartmentMapper extends BaseRowMapper<Department>{
	
	protected Department internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Department department = getDepartment();		
		 		
 		setId(department, rs, rowNumber); 		
 		setName(department, rs, rowNumber); 		
 		setHospital(department, rs, rowNumber); 		
 		setUpdateTime(department, rs, rowNumber); 		
 		setVersion(department, rs, rowNumber);

		return department;
	}
	
	protected Department getDepartment(){
		return new Department();
	}		
		
	protected void setId(Department department, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(DepartmentTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		department.setId(id);
	}
		
	protected void setName(Department department, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(DepartmentTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		department.setName(name);
	}
		 		
 	protected void setHospital(Department department, ResultSet rs, int rowNumber) throws SQLException{
 		String hospitalId = rs.getString(DepartmentTable.COLUMN_HOSPITAL);
 		if( hospitalId == null){
 			return;
 		}
 		if( hospitalId.isEmpty()){
 			return;
 		}
 		Hospital lhospital = department.getHospital();
 		if( lhospital != null ){
 			//if the root object 'department' already have the property, just set the id for it;
 			lhospital.setId(hospitalId);
 			
 			return;
 		}
 		department.setHospital(createEmptyHospital(hospitalId));
 	}
 	
	protected void setUpdateTime(Department department, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date updateTime = rs.getTimestamp(DepartmentTable.COLUMN_UPDATE_TIME);
		if(updateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		department.setUpdateTime(convertToDateTime(updateTime));
	}
		
	protected void setVersion(Department department, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(DepartmentTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		department.setVersion(version);
	}
		
		

 	protected Hospital  createEmptyHospital(String hospitalId){
 		Hospital hospital = new Hospital();
 		hospital.setId(hospitalId);
 		hospital.setVersion(Integer.MAX_VALUE);
 		return hospital;
 	}
 	
}


