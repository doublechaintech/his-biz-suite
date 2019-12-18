
package com.doublechaintech.his.doctor;
import com.doublechaintech.his.AccessKey;


public class DoctorTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="doctor_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_SHOT_IMAGE = "shot_image";
	static final String COLUMN_HOSPITAL = "hospital";
	static final String COLUMN_UPDATE_TIME = "update_time";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_SHOT_IMAGE, COLUMN_HOSPITAL, COLUMN_UPDATE_TIME, 
		COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_SHOT_IMAGE, COLUMN_HOSPITAL, COLUMN_UPDATE_TIME
		};
	
	
}


