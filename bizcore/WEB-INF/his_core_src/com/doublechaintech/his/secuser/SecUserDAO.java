
package com.doublechaintech.his.secuser;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.his.BaseDAO;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;

import com.doublechaintech.his.userapp.UserApp;
import com.doublechaintech.his.userdomain.UserDomain;
import com.doublechaintech.his.loginhistory.LoginHistory;
import com.doublechaintech.his.wechatworkappidentify.WechatWorkappIdentify;
import com.doublechaintech.his.wechatminiappidentify.WechatMiniappIdentify;

import com.doublechaintech.his.loginhistory.LoginHistoryDAO;
import com.doublechaintech.his.userdomain.UserDomainDAO;
import com.doublechaintech.his.userapp.UserAppDAO;
import com.doublechaintech.his.wechatworkappidentify.WechatWorkappIdentifyDAO;
import com.doublechaintech.his.wechatminiappidentify.WechatMiniappIdentifyDAO;


public interface SecUserDAO extends BaseDAO{

	public SmartList<SecUser> loadAll();
	public SecUser load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SecUser> secUserList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SecUser loadByLogin(String login,Map<String,Object> options) throws Exception;
	
	
	public SecUser loadByEmail(String email,Map<String,Object> options) throws Exception;
	
	
	public SecUser loadByMobile(String mobile,Map<String,Object> options) throws Exception;
	
	
	public SecUser present(SecUser secUser,Map<String,Object> options) throws Exception;
	public SecUser clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SecUser cloneByLogin(String login,Map<String,Object> options) throws Exception;
	
	
	public SecUser cloneByEmail(String email,Map<String,Object> options) throws Exception;
	
	
	public SecUser cloneByMobile(String mobile,Map<String,Object> options) throws Exception;
	
	
	public SecUser save(SecUser secUser,Map<String,Object> options);
	public SmartList<SecUser> saveSecUserList(SmartList<SecUser> secUserList,Map<String,Object> options);
	public SmartList<SecUser> removeSecUserList(SmartList<SecUser> secUserList,Map<String,Object> options);
	public SmartList<SecUser> findSecUserWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSecUserWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSecUserWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String secUserId, int version) throws Exception;
	public SecUser disconnectFromAll(String secUserId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public UserAppDAO getUserAppDAO();
		
	public LoginHistoryDAO getLoginHistoryDAO();
		
	public WechatWorkappIdentifyDAO getWechatWorkappIdentifyDAO();
		
	public WechatMiniappIdentifyDAO getWechatMiniappIdentifyDAO();
		
	
 	public SmartList<SecUser> requestCandidateSecUserForUserApp(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SecUser> requestCandidateSecUserForLoginHistory(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SecUser> requestCandidateSecUserForWechatWorkappIdentify(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SecUser> requestCandidateSecUserForWechatMiniappIdentify(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SecUser planToRemoveUserAppList(SecUser secUser, String userAppIds[], Map<String,Object> options)throws Exception;


	//disconnect SecUser with object_id in UserApp
	public SecUser planToRemoveUserAppListWithObjectId(SecUser secUser, String objectIdId, Map<String,Object> options)throws Exception;
	public int countUserAppListWithObjectId(String secUserId, String objectIdId, Map<String,Object> options)throws Exception;
	
	public SecUser planToRemoveLoginHistoryList(SecUser secUser, String loginHistoryIds[], Map<String,Object> options)throws Exception;


	public SecUser planToRemoveWechatWorkappIdentifyList(SecUser secUser, String wechatWorkappIdentifyIds[], Map<String,Object> options)throws Exception;


	//disconnect SecUser with corp_id in WechatWorkappIdentify
	public SecUser planToRemoveWechatWorkappIdentifyListWithCorpId(SecUser secUser, String corpIdId, Map<String,Object> options)throws Exception;
	public int countWechatWorkappIdentifyListWithCorpId(String secUserId, String corpIdId, Map<String,Object> options)throws Exception;
	
	//disconnect SecUser with user_id in WechatWorkappIdentify
	public SecUser planToRemoveWechatWorkappIdentifyListWithUserId(SecUser secUser, String userIdId, Map<String,Object> options)throws Exception;
	public int countWechatWorkappIdentifyListWithUserId(String secUserId, String userIdId, Map<String,Object> options)throws Exception;
	
	public SecUser planToRemoveWechatMiniappIdentifyList(SecUser secUser, String wechatMiniappIdentifyIds[], Map<String,Object> options)throws Exception;


	//disconnect SecUser with open_id in WechatMiniappIdentify
	public SecUser planToRemoveWechatMiniappIdentifyListWithOpenId(SecUser secUser, String openIdId, Map<String,Object> options)throws Exception;
	public int countWechatMiniappIdentifyListWithOpenId(String secUserId, String openIdId, Map<String,Object> options)throws Exception;
	
	//disconnect SecUser with app_id in WechatMiniappIdentify
	public SecUser planToRemoveWechatMiniappIdentifyListWithAppId(SecUser secUser, String appIdId, Map<String,Object> options)throws Exception;
	public int countWechatMiniappIdentifyListWithAppId(String secUserId, String appIdId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SecUser> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateSecUser executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<SecUser> findSecUserByDomain(String userDomainId, Map<String,Object> options);
 	public int countSecUserByDomain(String userDomainId, Map<String,Object> options);
 	public Map<String, Integer> countSecUserByDomainIds(String[] ids, Map<String,Object> options);
 	public SmartList<SecUser> findSecUserByDomain(String userDomainId, int start, int count, Map<String,Object> options);
 	public void analyzeSecUserByDomain(SmartList<SecUser> resultList, String userDomainId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:UserApp的secUser的UserAppList
	public SmartList<UserApp> loadOurUserAppList(HisUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:LoginHistory的secUser的LoginHistoryList
	public SmartList<LoginHistory> loadOurLoginHistoryList(HisUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:WechatWorkappIdentify的secUser的WechatWorkappIdentifyList
	public SmartList<WechatWorkappIdentify> loadOurWechatWorkappIdentifyList(HisUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:WechatMiniappIdentify的secUser的WechatMiniappIdentifyList
	public SmartList<WechatMiniappIdentify> loadOurWechatMiniappIdentifyList(HisUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception;
	
}


