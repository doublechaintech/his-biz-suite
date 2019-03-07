
package com.doublechaintech.his.registration;
import com.doublechaintech.his.AccessKey;


public class RegistrationTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="registration_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_PATIENT = "patient";
	static final String COLUMN_REGISTER = "register";
	static final String COLUMN_CONTENT = "content";
	static final String COLUMN_UPDATE_TIME = "update_time";
	static final String COLUMN_STATUS = "status";
	static final String COLUMN_PLATFORM = "platform";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_TITLE, COLUMN_PATIENT, COLUMN_REGISTER, COLUMN_CONTENT, COLUMN_UPDATE_TIME, COLUMN_STATUS, COLUMN_PLATFORM, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_TITLE, COLUMN_PATIENT, COLUMN_REGISTER, COLUMN_CONTENT, COLUMN_UPDATE_TIME, COLUMN_STATUS, COLUMN_PLATFORM
		};
	
	
}


