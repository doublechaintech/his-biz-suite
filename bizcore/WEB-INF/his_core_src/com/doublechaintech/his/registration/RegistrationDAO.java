
package com.doublechaintech.his.registration;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.platform.PlatformDAO;
import com.doublechaintech.his.profile.ProfileDAO;


public interface RegistrationDAO{

	
	public Registration load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Registration> registrationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Registration present(Registration registration,Map<String,Object> options) throws Exception;
	public Registration clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Registration save(Registration registration,Map<String,Object> options);
	public SmartList<Registration> saveRegistrationList(SmartList<Registration> registrationList,Map<String,Object> options);
	public SmartList<Registration> removeRegistrationList(SmartList<Registration> registrationList,Map<String,Object> options);
	public SmartList<Registration> findRegistrationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRegistrationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRegistrationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String registrationId, int version) throws Exception;
	public Registration disconnectFromAll(String registrationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<Registration> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Registration> findRegistrationByPatient(String profileId, Map<String,Object> options);
 	public int countRegistrationByPatient(String profileId, Map<String,Object> options);
 	public Map<String, Integer> countRegistrationByPatientIds(String[] ids, Map<String,Object> options);
 	public SmartList<Registration> findRegistrationByPatient(String profileId, int start, int count, Map<String,Object> options);
 	public void analyzeRegistrationByPatient(SmartList<Registration> resultList, String profileId, Map<String,Object> options);

 
  
 	public SmartList<Registration> findRegistrationByRegister(String profileId, Map<String,Object> options);
 	public int countRegistrationByRegister(String profileId, Map<String,Object> options);
 	public Map<String, Integer> countRegistrationByRegisterIds(String[] ids, Map<String,Object> options);
 	public SmartList<Registration> findRegistrationByRegister(String profileId, int start, int count, Map<String,Object> options);
 	public void analyzeRegistrationByRegister(SmartList<Registration> resultList, String profileId, Map<String,Object> options);

 
  
 	public SmartList<Registration> findRegistrationByPlatform(String platformId, Map<String,Object> options);
 	public int countRegistrationByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countRegistrationByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<Registration> findRegistrationByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeRegistrationByPlatform(SmartList<Registration> resultList, String platformId, Map<String,Object> options);

 
 }


