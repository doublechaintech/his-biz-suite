
package com.doublechaintech.his.profile;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.platform.PlatformDAO;
import com.doublechaintech.his.registration.RegistrationDAO;


public interface ProfileDAO{

	
	public Profile load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Profile> profileList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Profile present(Profile profile,Map<String,Object> options) throws Exception;
	public Profile clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Profile save(Profile profile,Map<String,Object> options);
	public SmartList<Profile> saveProfileList(SmartList<Profile> profileList,Map<String,Object> options);
	public SmartList<Profile> removeProfileList(SmartList<Profile> profileList,Map<String,Object> options);
	public SmartList<Profile> findProfileWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countProfileWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countProfileWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String profileId, int version) throws Exception;
	public Profile disconnectFromAll(String profileId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RegistrationDAO getRegistrationDAO();
		
	
 	public SmartList<Profile> requestCandidateProfileForRegistrationAsPatient(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Profile> requestCandidateProfileForRegistrationAsRegister(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Profile planToRemoveRegistrationListAsPatient(Profile profile, String registrationIds[], Map<String,Object> options)throws Exception;


	//disconnect Profile with platform in Registration
	public Profile planToRemoveRegistrationListAsPatientWithPlatform(Profile profile, String platformId, Map<String,Object> options)throws Exception;
	public int countRegistrationListAsPatientWithPlatform(String profileId, String platformId, Map<String,Object> options)throws Exception;
	
	public Profile planToRemoveRegistrationListAsRegister(Profile profile, String registrationIds[], Map<String,Object> options)throws Exception;


	//disconnect Profile with platform in Registration
	public Profile planToRemoveRegistrationListAsRegisterWithPlatform(Profile profile, String platformId, Map<String,Object> options)throws Exception;
	public int countRegistrationListAsRegisterWithPlatform(String profileId, String platformId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Profile> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Profile> findProfileByPlatform(String platformId, Map<String,Object> options);
 	public int countProfileByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countProfileByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<Profile> findProfileByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeProfileByPlatform(SmartList<Profile> resultList, String platformId, Map<String,Object> options);

 
 }


