
package com.doublechaintech.his.doctorassignment;
import com.doublechaintech.his.AccessKey;


public class DoctorAssignmentTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="doctor_assignment_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_DOCTOR = "doctor";
	static final String COLUMN_DEPARTMENT = "department";
	static final String COLUMN_UPDATE_TIME = "update_time";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_DOCTOR,COLUMN_DEPARTMENT,COLUMN_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_DOCTOR,COLUMN_DEPARTMENT,COLUMN_UPDATE_TIME};
	
	
}


