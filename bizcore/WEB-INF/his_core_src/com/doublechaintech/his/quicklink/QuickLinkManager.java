
package com.doublechaintech.his.quicklink;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;

public interface QuickLinkManager{

		

	public QuickLink createQuickLink(HisUserContext userContext, String name, String icon, String imagePath, String linkTarget, String appId) throws Exception;	
	public QuickLink updateQuickLink(HisUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public QuickLink loadQuickLink(HisUserContext userContext, String quickLinkId, String [] tokensExpr) throws Exception;
	public QuickLink internalSaveQuickLink(HisUserContext userContext, QuickLink quickLink) throws Exception;
	public QuickLink internalSaveQuickLink(HisUserContext userContext, QuickLink quickLink,Map<String,Object>option) throws Exception;
	
	public QuickLink transferToAnotherApp(HisUserContext userContext, String quickLinkId, String anotherAppId)  throws Exception;
 

	public void delete(HisUserContext userContext, String quickLinkId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, QuickLink newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


