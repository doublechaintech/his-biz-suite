
package com.doublechaintech.his.uiaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface UiActionManager extends BaseManager{

		

	public UiAction createUiAction(HisUserContext userContext, String code,String icon,String title,String brief,String imageUrl,String linkToUrl,String extraData,String pageId) throws Exception;
	public UiAction updateUiAction(HisUserContext userContext,String uiActionId, int uiActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UiAction loadUiAction(HisUserContext userContext, String uiActionId, String [] tokensExpr) throws Exception;
	public UiAction internalSaveUiAction(HisUserContext userContext, UiAction uiAction) throws Exception;
	public UiAction internalSaveUiAction(HisUserContext userContext, UiAction uiAction,Map<String,Object>option) throws Exception;

	public UiAction transferToAnotherPage(HisUserContext userContext, String uiActionId, String anotherPageId)  throws Exception;
 

	public void delete(HisUserContext userContext, String uiActionId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, UiAction newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByPage(HisUserContext userContext,String pageId) throws Exception;
	public Object listPageByPage(HisUserContext userContext,String pageId, int start, int count) throws Exception;
  

}


