
package com.doublechaintech.his.listaccess;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface ListAccessManager extends BaseManager{

		

	public ListAccess createListAccess(HisUserContext userContext, String name,String internalName,boolean readPermission,boolean createPermission,boolean deletePermission,boolean updatePermission,boolean executionPermission,String appId) throws Exception;
	public ListAccess updateListAccess(HisUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ListAccess loadListAccess(HisUserContext userContext, String listAccessId, String [] tokensExpr) throws Exception;
	public ListAccess internalSaveListAccess(HisUserContext userContext, ListAccess listAccess) throws Exception;
	public ListAccess internalSaveListAccess(HisUserContext userContext, ListAccess listAccess,Map<String,Object>option) throws Exception;

	public ListAccess transferToAnotherApp(HisUserContext userContext, String listAccessId, String anotherAppId)  throws Exception;
 

	public void delete(HisUserContext userContext, String listAccessId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, ListAccess newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByApp(HisUserContext userContext,String appId) throws Exception;
	public Object listPageByApp(HisUserContext userContext,String appId, int start, int count) throws Exception;
  

}


