
package com.panfeng.his.expenseitem;
import com.panfeng.his.AccessKey;


public class ExpenseItemTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="expense_item_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_PRICE = "price";
	static final String COLUMN_EXPENSE_TYPE = "expense_type";
	static final String COLUMN_HOSPITAL = "hospital";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_PRICE, COLUMN_EXPENSE_TYPE, COLUMN_HOSPITAL, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_PRICE, COLUMN_EXPENSE_TYPE, COLUMN_HOSPITAL
		};
	
	
}


