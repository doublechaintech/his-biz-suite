
package com.doublechaintech.his.userwhitelist;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.his.BaseDAO;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;

import com.doublechaintech.his.userdomain.UserDomain;

import com.doublechaintech.his.userdomain.UserDomainDAO;


public interface UserWhiteListDAO extends BaseDAO{

	public SmartList<UserWhiteList> loadAll();
	public UserWhiteList load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<UserWhiteList> userWhiteListList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public UserWhiteList present(UserWhiteList userWhiteList,Map<String,Object> options) throws Exception;
	public UserWhiteList clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public UserWhiteList save(UserWhiteList userWhiteList,Map<String,Object> options);
	public SmartList<UserWhiteList> saveUserWhiteListList(SmartList<UserWhiteList> userWhiteListList,Map<String,Object> options);
	public SmartList<UserWhiteList> removeUserWhiteListList(SmartList<UserWhiteList> userWhiteListList,Map<String,Object> options);
	public SmartList<UserWhiteList> findUserWhiteListWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countUserWhiteListWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countUserWhiteListWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String userWhiteListId, int version) throws Exception;
	public UserWhiteList disconnectFromAll(String userWhiteListId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<UserWhiteList> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateUserWhiteList executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<UserWhiteList> findUserWhiteListByDomain(String userDomainId, Map<String,Object> options);
 	public int countUserWhiteListByDomain(String userDomainId, Map<String,Object> options);
 	public Map<String, Integer> countUserWhiteListByDomainIds(String[] ids, Map<String,Object> options);
 	public SmartList<UserWhiteList> findUserWhiteListByDomain(String userDomainId, int start, int count, Map<String,Object> options);
 	public void analyzeUserWhiteListByDomain(SmartList<UserWhiteList> resultList, String userDomainId, Map<String,Object> options);

 
 
}


