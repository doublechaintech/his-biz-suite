
package com.doublechaintech.his.page;
import com.doublechaintech.his.AccessKey;


public class PageTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="page_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_PAGE_TITLE = "page_title";
	static final String COLUMN_LINK_TO_URL = "link_to_url";
	static final String COLUMN_PAGE_TYPE = "page_type";
	static final String COLUMN_MOBILE_APP = "mobile_app";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_PAGE_TITLE,COLUMN_LINK_TO_URL,COLUMN_PAGE_TYPE,COLUMN_MOBILE_APP,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_PAGE_TITLE,COLUMN_LINK_TO_URL,COLUMN_PAGE_TYPE,COLUMN_MOBILE_APP};
	
	
}


