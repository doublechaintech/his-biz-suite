
package com.doublechaintech.his.page;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface PageManager extends BaseManager{

		

	public Page createPage(HisUserContext userContext, String pageTitle,String linkToUrl,String pageTypeId,String mobileAppId) throws Exception;
	public Page updatePage(HisUserContext userContext,String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Page loadPage(HisUserContext userContext, String pageId, String [] tokensExpr) throws Exception;
	public Page internalSavePage(HisUserContext userContext, Page page) throws Exception;
	public Page internalSavePage(HisUserContext userContext, Page page,Map<String,Object>option) throws Exception;

	public Page transferToAnotherPageType(HisUserContext userContext, String pageId, String anotherPageTypeId)  throws Exception;
 	public Page transferToAnotherMobileApp(HisUserContext userContext, String pageId, String anotherMobileAppId)  throws Exception;
 

	public void delete(HisUserContext userContext, String pageId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, Page newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  SlideManager getSlideManager(HisUserContext userContext, String pageId, int displayOrder, String name, String imageUrl, String videoUrl, String linkToUrl ,String [] tokensExpr)  throws Exception;

	public  Page addSlide(HisUserContext userContext, String pageId, int displayOrder, String name, String imageUrl, String videoUrl, String linkToUrl , String [] tokensExpr)  throws Exception;
	public  Page removeSlide(HisUserContext userContext, String pageId, String slideId, int slideVersion,String [] tokensExpr)  throws Exception;
	public  Page updateSlide(HisUserContext userContext, String pageId, String slideId, int slideVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  UiActionManager getUiActionManager(HisUserContext userContext, String pageId, String code, String icon, String title, String brief, String imageUrl, String linkToUrl, String extraData ,String [] tokensExpr)  throws Exception;

	public  Page addUiAction(HisUserContext userContext, String pageId, String code, String icon, String title, String brief, String imageUrl, String linkToUrl, String extraData , String [] tokensExpr)  throws Exception;
	public  Page removeUiAction(HisUserContext userContext, String pageId, String uiActionId, int uiActionVersion,String [] tokensExpr)  throws Exception;
	public  Page updateUiAction(HisUserContext userContext, String pageId, String uiActionId, int uiActionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByPageType(HisUserContext userContext,String pageTypeId) throws Exception;
	public Object listPageByPageType(HisUserContext userContext,String pageTypeId, int start, int count) throws Exception;
  
	public Object listByMobileApp(HisUserContext userContext,String mobileAppId) throws Exception;
	public Object listPageByMobileApp(HisUserContext userContext,String mobileAppId, int start, int count) throws Exception;
  

}


