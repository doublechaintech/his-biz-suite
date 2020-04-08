
package com.doublechaintech.his.userdomain;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.his.BaseDAO;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;

import com.doublechaintech.his.userwhitelist.UserWhiteList;
import com.doublechaintech.his.secuser.SecUser;

import com.doublechaintech.his.userwhitelist.UserWhiteListDAO;
import com.doublechaintech.his.secuser.SecUserDAO;


public interface UserDomainDAO extends BaseDAO{

	public SmartList<UserDomain> loadAll();
	public UserDomain load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<UserDomain> userDomainList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public UserDomain present(UserDomain userDomain,Map<String,Object> options) throws Exception;
	public UserDomain clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public UserDomain save(UserDomain userDomain,Map<String,Object> options);
	public SmartList<UserDomain> saveUserDomainList(SmartList<UserDomain> userDomainList,Map<String,Object> options);
	public SmartList<UserDomain> removeUserDomainList(SmartList<UserDomain> userDomainList,Map<String,Object> options);
	public SmartList<UserDomain> findUserDomainWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countUserDomainWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countUserDomainWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String userDomainId, int version) throws Exception;
	public UserDomain disconnectFromAll(String userDomainId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public UserWhiteListDAO getUserWhiteListDAO();
		
	public SecUserDAO getSecUserDAO();
		
	
 	public SmartList<UserDomain> requestCandidateUserDomainForUserWhiteList(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<UserDomain> requestCandidateUserDomainForSecUser(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public UserDomain planToRemoveUserWhiteListList(UserDomain userDomain, String userWhiteListIds[], Map<String,Object> options)throws Exception;


	public UserDomain planToRemoveSecUserList(UserDomain userDomain, String secUserIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<UserDomain> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateUserDomain executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:UserWhiteList的domain的UserWhiteListList
	public SmartList<UserWhiteList> loadOurUserWhiteListList(HisUserContext userContext, List<UserDomain> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SecUser的domain的SecUserList
	public SmartList<SecUser> loadOurSecUserList(HisUserContext userContext, List<UserDomain> us, Map<String,Object> options) throws Exception;
	
}


