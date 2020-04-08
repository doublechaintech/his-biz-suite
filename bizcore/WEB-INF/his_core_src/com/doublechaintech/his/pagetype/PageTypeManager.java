
package com.doublechaintech.his.pagetype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface PageTypeManager extends BaseManager{

		


	public PageType loadPageTypeWithCode(HisUserContext userContext, String code, Map<String,Object>tokens) throws Exception;

	 

	public PageType createPageType(HisUserContext userContext, String name,String code,String mobileAppId,boolean footerTab) throws Exception;
	public PageType updatePageType(HisUserContext userContext,String pageTypeId, int pageTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PageType loadPageType(HisUserContext userContext, String pageTypeId, String [] tokensExpr) throws Exception;
	public PageType internalSavePageType(HisUserContext userContext, PageType pageType) throws Exception;
	public PageType internalSavePageType(HisUserContext userContext, PageType pageType,Map<String,Object>option) throws Exception;

	public PageType transferToAnotherMobileApp(HisUserContext userContext, String pageTypeId, String anotherMobileAppId)  throws Exception;
 

	public void delete(HisUserContext userContext, String pageTypeId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, PageType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  PageManager getPageManager(HisUserContext userContext, String pageTypeId, String pageTitle, String linkToUrl, String mobileAppId ,String [] tokensExpr)  throws Exception;

	public  PageType addPage(HisUserContext userContext, String pageTypeId, String pageTitle, String linkToUrl, String mobileAppId , String [] tokensExpr)  throws Exception;
	public  PageType removePage(HisUserContext userContext, String pageTypeId, String pageId, int pageVersion,String [] tokensExpr)  throws Exception;
	public  PageType updatePage(HisUserContext userContext, String pageTypeId, String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByMobileApp(HisUserContext userContext,String mobileAppId) throws Exception;
	public Object listPageByMobileApp(HisUserContext userContext,String mobileAppId, int start, int count) throws Exception;
  

}


