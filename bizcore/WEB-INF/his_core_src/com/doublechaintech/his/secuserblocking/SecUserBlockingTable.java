
package com.doublechaintech.his.secuserblocking;
import com.doublechaintech.his.AccessKey;


public class SecUserBlockingTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="sec_user_blocking_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_WHO = "who";
	static final String COLUMN_BLOCK_TIME = "block_time";
	static final String COLUMN_COMMENTS = "comments";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_WHO, COLUMN_BLOCK_TIME, COLUMN_COMMENTS, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_WHO, COLUMN_BLOCK_TIME, COLUMN_COMMENTS
		};
	
	
}


