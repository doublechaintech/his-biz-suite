
package com.doublechaintech.his.expenseitem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.his.BaseRowMapper;
import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.expensetype.ExpenseType;

public class ExpenseItemMapper extends BaseRowMapper<ExpenseItem>{
	
	protected ExpenseItem internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ExpenseItem expenseItem = getExpenseItem();		
		 		
 		setId(expenseItem, rs, rowNumber); 		
 		setName(expenseItem, rs, rowNumber); 		
 		setPrice(expenseItem, rs, rowNumber); 		
 		setExpenseType(expenseItem, rs, rowNumber); 		
 		setHospital(expenseItem, rs, rowNumber); 		
 		setUpdateTime(expenseItem, rs, rowNumber); 		
 		setVersion(expenseItem, rs, rowNumber);

		return expenseItem;
	}
	
	protected ExpenseItem getExpenseItem(){
		return new ExpenseItem();
	}		
		
	protected void setId(ExpenseItem expenseItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(ExpenseItemTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		expenseItem.setId(id);
	}
		
	protected void setName(ExpenseItem expenseItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(ExpenseItemTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		expenseItem.setName(name);
	}
		
	protected void setPrice(ExpenseItem expenseItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal price = rs.getBigDecimal(ExpenseItemTable.COLUMN_PRICE);
		
		if(price == null){
			//do nothing when nothing found in database
			return;
		}
		
		expenseItem.setPrice(price);
	}
		 		
 	protected void setExpenseType(ExpenseItem expenseItem, ResultSet rs, int rowNumber) throws SQLException{
 		String expenseTypeId = rs.getString(ExpenseItemTable.COLUMN_EXPENSE_TYPE);
 		if( expenseTypeId == null){
 			return;
 		}
 		if( expenseTypeId.isEmpty()){
 			return;
 		}
 		ExpenseType expenseType = expenseItem.getExpenseType();
 		if( expenseType != null ){
 			//if the root object 'expenseItem' already have the property, just set the id for it;
 			expenseType.setId(expenseTypeId);
 			
 			return;
 		}
 		expenseItem.setExpenseType(createEmptyExpenseType(expenseTypeId));
 	}
 	 		
 	protected void setHospital(ExpenseItem expenseItem, ResultSet rs, int rowNumber) throws SQLException{
 		String hospitalId = rs.getString(ExpenseItemTable.COLUMN_HOSPITAL);
 		if( hospitalId == null){
 			return;
 		}
 		if( hospitalId.isEmpty()){
 			return;
 		}
 		Hospital hospital = expenseItem.getHospital();
 		if( hospital != null ){
 			//if the root object 'expenseItem' already have the property, just set the id for it;
 			hospital.setId(hospitalId);
 			
 			return;
 		}
 		expenseItem.setHospital(createEmptyHospital(hospitalId));
 	}
 	
	protected void setUpdateTime(ExpenseItem expenseItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date updateTime = rs.getTimestamp(ExpenseItemTable.COLUMN_UPDATE_TIME);
		
		if(updateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		expenseItem.setUpdateTime(convertToDateTime(updateTime));
	}
		
	protected void setVersion(ExpenseItem expenseItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(ExpenseItemTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		expenseItem.setVersion(version);
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


