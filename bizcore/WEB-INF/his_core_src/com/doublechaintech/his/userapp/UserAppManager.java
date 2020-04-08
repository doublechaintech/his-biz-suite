
package com.doublechaintech.his.userapp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface UserAppManager extends BaseManager{

		

	public UserApp createUserApp(HisUserContext userContext, String title,String secUserId,String appIcon,boolean fullAccess,String permission,String objectType,String objectId,String location) throws Exception;
	public UserApp updateUserApp(HisUserContext userContext,String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserApp loadUserApp(HisUserContext userContext, String userAppId, String [] tokensExpr) throws Exception;
	public UserApp internalSaveUserApp(HisUserContext userContext, UserApp userApp) throws Exception;
	public UserApp internalSaveUserApp(HisUserContext userContext, UserApp userApp,Map<String,Object>option) throws Exception;

	public UserApp transferToAnotherSecUser(HisUserContext userContext, String userAppId, String anotherSecUserId)  throws Exception;
 

	public void delete(HisUserContext userContext, String userAppId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, UserApp newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  QuickLinkManager getQuickLinkManager(HisUserContext userContext, String userAppId, String name, String icon, String imagePath, String linkTarget ,String [] tokensExpr)  throws Exception;

	public  UserApp addQuickLink(HisUserContext userContext, String userAppId, String name, String icon, String imagePath, String linkTarget , String [] tokensExpr)  throws Exception;
	public  UserApp removeQuickLink(HisUserContext userContext, String userAppId, String quickLinkId, int quickLinkVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateQuickLink(HisUserContext userContext, String userAppId, String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ListAccessManager getListAccessManager(HisUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission ,String [] tokensExpr)  throws Exception;

	public  UserApp addListAccess(HisUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission , String [] tokensExpr)  throws Exception;
	public  UserApp removeListAccess(HisUserContext userContext, String userAppId, String listAccessId, int listAccessVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateListAccess(HisUserContext userContext, String userAppId, String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ObjectAccessManager getObjectAccessManager(HisUserContext userContext, String userAppId, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9 ,String [] tokensExpr)  throws Exception;

	public  UserApp addObjectAccess(HisUserContext userContext, String userAppId, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9 , String [] tokensExpr)  throws Exception;
	public  UserApp removeObjectAccess(HisUserContext userContext, String userAppId, String objectAccessId, int objectAccessVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateObjectAccess(HisUserContext userContext, String userAppId, String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listBySecUser(HisUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(HisUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


