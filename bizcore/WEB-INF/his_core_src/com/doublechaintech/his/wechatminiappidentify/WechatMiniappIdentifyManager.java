
package com.doublechaintech.his.wechatminiappidentify;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface WechatMiniappIdentifyManager extends BaseManager{

		

	public WechatMiniappIdentify createWechatMiniappIdentify(HisUserContext userContext, String openId,String appId,String secUserId,DateTime lastLoginTime) throws Exception;
	public WechatMiniappIdentify updateWechatMiniappIdentify(HisUserContext userContext,String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public WechatMiniappIdentify loadWechatMiniappIdentify(HisUserContext userContext, String wechatMiniappIdentifyId, String [] tokensExpr) throws Exception;
	public WechatMiniappIdentify internalSaveWechatMiniappIdentify(HisUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify) throws Exception;
	public WechatMiniappIdentify internalSaveWechatMiniappIdentify(HisUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify,Map<String,Object>option) throws Exception;

	public WechatMiniappIdentify transferToAnotherSecUser(HisUserContext userContext, String wechatMiniappIdentifyId, String anotherSecUserId)  throws Exception;
 

	public void delete(HisUserContext userContext, String wechatMiniappIdentifyId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, WechatMiniappIdentify newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listBySecUser(HisUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(HisUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


