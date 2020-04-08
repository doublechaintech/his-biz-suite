
package com.doublechaintech.his.secuser;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface SecUserManager extends BaseManager{

		


	public SecUser loadSecUserWithLogin(HisUserContext userContext, String login, Map<String,Object>tokens) throws Exception;

	 


	public SecUser loadSecUserWithEmail(HisUserContext userContext, String email, Map<String,Object>tokens) throws Exception;

	 


	public SecUser loadSecUserWithMobile(HisUserContext userContext, String mobile, Map<String,Object>tokens) throws Exception;

	 

	public SecUser createSecUser(HisUserContext userContext, String login,String mobile,String email,String pwd,String weixinOpenid,String weixinAppid,String accessToken,int verificationCode,DateTime verificationCodeExpire,DateTime lastLoginTime,String domainId) throws Exception;
	public SecUser updateSecUser(HisUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SecUser loadSecUser(HisUserContext userContext, String secUserId, String [] tokensExpr) throws Exception;
	public SecUser internalSaveSecUser(HisUserContext userContext, SecUser secUser) throws Exception;
	public SecUser internalSaveSecUser(HisUserContext userContext, SecUser secUser,Map<String,Object>option) throws Exception;

	public SecUser transferToAnotherDomain(HisUserContext userContext, String secUserId, String anotherDomainId)  throws Exception;
 

	public void delete(HisUserContext userContext, String secUserId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, SecUser newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  UserAppManager getUserAppManager(HisUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location ,String [] tokensExpr)  throws Exception;

	public  SecUser addUserApp(HisUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location , String [] tokensExpr)  throws Exception;
	public  SecUser removeUserApp(HisUserContext userContext, String secUserId, String userAppId, int userAppVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateUserApp(HisUserContext userContext, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  LoginHistoryManager getLoginHistoryManager(HisUserContext userContext, String secUserId, String fromIp, String description ,String [] tokensExpr)  throws Exception;

	public  SecUser addLoginHistory(HisUserContext userContext, String secUserId, String fromIp, String description , String [] tokensExpr)  throws Exception;
	public  SecUser removeLoginHistory(HisUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateLoginHistory(HisUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WechatWorkappIdentifyManager getWechatWorkappIdentifyManager(HisUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;

	public  SecUser addWechatWorkappIdentify(HisUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  SecUser removeWechatWorkappIdentify(HisUserContext userContext, String secUserId, String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateWechatWorkappIdentify(HisUserContext userContext, String secUserId, String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WechatMiniappIdentifyManager getWechatMiniappIdentifyManager(HisUserContext userContext, String secUserId, String openId, String appId, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;

	public  SecUser addWechatMiniappIdentify(HisUserContext userContext, String secUserId, String openId, String appId, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  SecUser removeWechatMiniappIdentify(HisUserContext userContext, String secUserId, String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateWechatMiniappIdentify(HisUserContext userContext, String secUserId, String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByDomain(HisUserContext userContext,String domainId) throws Exception;
	public Object listPageByDomain(HisUserContext userContext,String domainId, int start, int count) throws Exception;
  

}


