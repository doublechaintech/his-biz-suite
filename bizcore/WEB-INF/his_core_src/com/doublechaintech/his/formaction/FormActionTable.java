
package com.doublechaintech.his.formaction;
import com.doublechaintech.his.AccessKey;


public class FormActionTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="form_action_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_LABEL = "label";
	static final String COLUMN_LOCALE_KEY = "locale_key";
	static final String COLUMN_ACTION_KEY = "action_key";
	static final String COLUMN_LEVEL = "level";
	static final String COLUMN_URL = "url";
	static final String COLUMN_FORM = "form";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_LABEL, COLUMN_LOCALE_KEY, COLUMN_ACTION_KEY, COLUMN_LEVEL, COLUMN_URL, COLUMN_FORM, 
		COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {
		COLUMN_LABEL, COLUMN_LOCALE_KEY, COLUMN_ACTION_KEY, COLUMN_LEVEL, COLUMN_URL, COLUMN_FORM
		};
	
	
}


