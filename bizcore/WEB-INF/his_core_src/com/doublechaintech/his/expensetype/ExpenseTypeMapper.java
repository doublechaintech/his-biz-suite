
package com.doublechaintech.his.expensetype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.his.BaseRowMapper;
import com.doublechaintech.his.hospital.Hospital;

public class ExpenseTypeMapper extends BaseRowMapper<ExpenseType>{
	
	protected ExpenseType internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ExpenseType expenseType = getExpenseType();		
		 		
 		setId(expenseType, rs, rowNumber); 		
 		setName(expenseType, rs, rowNumber); 		
 		setHelperChars(expenseType, rs, rowNumber); 		
 		setStatus(expenseType, rs, rowNumber); 		
 		setHospital(expenseType, rs, rowNumber); 		
 		setDescription(expenseType, rs, rowNumber); 		
 		setUpdateTime(expenseType, rs, rowNumber); 		
 		setVersion(expenseType, rs, rowNumber);

		return expenseType;
	}
	
	protected ExpenseType getExpenseType(){
		return new ExpenseType();
	}		
		
	protected void setId(ExpenseType expenseType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(ExpenseTypeTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		expenseType.setId(id);
	}
		
	protected void setName(ExpenseType expenseType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(ExpenseTypeTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		expenseType.setName(name);
	}
		
	protected void setHelperChars(ExpenseType expenseType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String helperChars = rs.getString(ExpenseTypeTable.COLUMN_HELPER_CHARS);
		
		if(helperChars == null){
			//do nothing when nothing found in database
			return;
		}
		
		expenseType.setHelperChars(helperChars);
	}
		
	protected void setStatus(ExpenseType expenseType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String status = rs.getString(ExpenseTypeTable.COLUMN_STATUS);
		
		if(status == null){
			//do nothing when nothing found in database
			return;
		}
		
		expenseType.setStatus(status);
	}
		 		
 	protected void setHospital(ExpenseType expenseType, ResultSet rs, int rowNumber) throws SQLException{
 		String hospitalId = rs.getString(ExpenseTypeTable.COLUMN_HOSPITAL);
 		if( hospitalId == null){
 			return;
 		}
 		if( hospitalId.isEmpty()){
 			return;
 		}
 		Hospital hospital = expenseType.getHospital();
 		if( hospital != null ){
 			//if the root object 'expenseType' already have the property, just set the id for it;
 			hospital.setId(hospitalId);
 			
 			return;
 		}
 		expenseType.setHospital(createEmptyHospital(hospitalId));
 	}
 	
	protected void setDescription(ExpenseType expenseType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(ExpenseTypeTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		expenseType.setDescription(description);
	}
		
	protected void setUpdateTime(ExpenseType expenseType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date updateTime = rs.getTimestamp(ExpenseTypeTable.COLUMN_UPDATE_TIME);
		
		if(updateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		expenseType.setUpdateTime(convertToDateTime(updateTime));
	}
		
	protected void setVersion(ExpenseType expenseType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(ExpenseTypeTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		expenseType.setVersion(version);
	}
		
		

 	protected Hospital  createEmptyHospital(String hospitalId){
 		Hospital hospital = new Hospital();
 		hospital.setId(hospitalId);
 		hospital.setVersion(Integer.MAX_VALUE);
 		return hospital;
 	}
 	
}


