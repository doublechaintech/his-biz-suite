
package com.doublechaintech.his.mobileapp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface MobileAppManager extends BaseManager{

		

	public MobileApp createMobileApp(HisUserContext userContext, String name) throws Exception;
	public MobileApp updateMobileApp(HisUserContext userContext,String mobileAppId, int mobileAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public MobileApp loadMobileApp(HisUserContext userContext, String mobileAppId, String [] tokensExpr) throws Exception;
	public MobileApp internalSaveMobileApp(HisUserContext userContext, MobileApp mobileApp) throws Exception;
	public MobileApp internalSaveMobileApp(HisUserContext userContext, MobileApp mobileApp,Map<String,Object>option) throws Exception;



	public void delete(HisUserContext userContext, String mobileAppId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, MobileApp newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  PageManager getPageManager(HisUserContext userContext, String mobileAppId, String pageTitle, String linkToUrl, String pageTypeId ,String [] tokensExpr)  throws Exception;

	public  MobileApp addPage(HisUserContext userContext, String mobileAppId, String pageTitle, String linkToUrl, String pageTypeId , String [] tokensExpr)  throws Exception;
	public  MobileApp removePage(HisUserContext userContext, String mobileAppId, String pageId, int pageVersion,String [] tokensExpr)  throws Exception;
	public  MobileApp updatePage(HisUserContext userContext, String mobileAppId, String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PageTypeManager getPageTypeManager(HisUserContext userContext, String mobileAppId, String name, String code, boolean footerTab ,String [] tokensExpr)  throws Exception;

	public  MobileApp addPageType(HisUserContext userContext, String mobileAppId, String name, String code, boolean footerTab , String [] tokensExpr)  throws Exception;
	public  MobileApp removePageType(HisUserContext userContext, String mobileAppId, String pageTypeId, int pageTypeVersion,String [] tokensExpr)  throws Exception;
	public  MobileApp updatePageType(HisUserContext userContext, String mobileAppId, String pageTypeId, int pageTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


