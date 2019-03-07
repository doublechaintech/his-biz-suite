
package com.doublechaintech.his.profile;
import com.doublechaintech.his.AccessKey;


public class ProfileTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="profile_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_GENDER = "gender";
	static final String COLUMN_AGE = "age";
	static final String COLUMN_IDENTIFICATION_NUMBER = "identification_number";
	static final String COLUMN_MOBILE = "mobile";
	static final String COLUMN_PLATFORM = "platform";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_GENDER, COLUMN_AGE, COLUMN_IDENTIFICATION_NUMBER, COLUMN_MOBILE, COLUMN_PLATFORM, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_GENDER, COLUMN_AGE, COLUMN_IDENTIFICATION_NUMBER, COLUMN_MOBILE, COLUMN_PLATFORM
		};
	
	
}


