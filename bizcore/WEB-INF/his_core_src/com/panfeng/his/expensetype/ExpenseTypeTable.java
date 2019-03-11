
package com.panfeng.his.expensetype;
import com.panfeng.his.AccessKey;


public class ExpenseTypeTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="expense_type_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_HELPER_CHARS = "helper_chars";
	static final String COLUMN_STATUS = "status";
	static final String COLUMN_HOSPITAL = "hospital";
	static final String COLUMN_DESCRIPTION = "description";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_HELPER_CHARS, COLUMN_STATUS, COLUMN_HOSPITAL, COLUMN_DESCRIPTION, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_HELPER_CHARS, COLUMN_STATUS, COLUMN_HOSPITAL, COLUMN_DESCRIPTION
		};
	
	
}


