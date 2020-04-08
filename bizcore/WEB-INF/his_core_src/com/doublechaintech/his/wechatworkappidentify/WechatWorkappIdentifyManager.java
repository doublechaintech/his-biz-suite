
package com.doublechaintech.his.wechatworkappidentify;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface WechatWorkappIdentifyManager extends BaseManager{

		

	public WechatWorkappIdentify createWechatWorkappIdentify(HisUserContext userContext, String corpId,String userId,String secUserId,DateTime lastLoginTime) throws Exception;
	public WechatWorkappIdentify updateWechatWorkappIdentify(HisUserContext userContext,String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public WechatWorkappIdentify loadWechatWorkappIdentify(HisUserContext userContext, String wechatWorkappIdentifyId, String [] tokensExpr) throws Exception;
	public WechatWorkappIdentify internalSaveWechatWorkappIdentify(HisUserContext userContext, WechatWorkappIdentify wechatWorkappIdentify) throws Exception;
	public WechatWorkappIdentify internalSaveWechatWorkappIdentify(HisUserContext userContext, WechatWorkappIdentify wechatWorkappIdentify,Map<String,Object>option) throws Exception;

	public WechatWorkappIdentify transferToAnotherSecUser(HisUserContext userContext, String wechatWorkappIdentifyId, String anotherSecUserId)  throws Exception;
 

	public void delete(HisUserContext userContext, String wechatWorkappIdentifyId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, WechatWorkappIdentify newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listBySecUser(HisUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(HisUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


