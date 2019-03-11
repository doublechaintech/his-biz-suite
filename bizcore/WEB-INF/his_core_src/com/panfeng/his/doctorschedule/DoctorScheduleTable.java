
package com.panfeng.his.doctorschedule;
import com.panfeng.his.AccessKey;


public class DoctorScheduleTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="doctor_schedule_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_SCHEDULE_DATE = "schedule_date";
	static final String COLUMN_PERIOD = "period";
	static final String COLUMN_DOCTOR = "doctor";
	static final String COLUMN_AVAILABLE = "available";
	static final String COLUMN_PRICE = "price";
	static final String COLUMN_EXPENSE_TYPE = "expense_type";
	static final String COLUMN_DEPARTMENT = "department";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_SCHEDULE_DATE, COLUMN_PERIOD, COLUMN_DOCTOR, COLUMN_AVAILABLE, COLUMN_PRICE, COLUMN_EXPENSE_TYPE, COLUMN_DEPARTMENT, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_SCHEDULE_DATE, COLUMN_PERIOD, COLUMN_DOCTOR, COLUMN_AVAILABLE, COLUMN_PRICE, COLUMN_EXPENSE_TYPE, COLUMN_DEPARTMENT
		};
	
	
}


