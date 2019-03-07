
package com.doublechaintech.his.platform;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.doctor.DoctorDAO;
import com.doublechaintech.his.profile.ProfileDAO;
import com.doublechaintech.his.registration.RegistrationDAO;


public interface PlatformDAO{

	
	public Platform load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Platform> platformList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Platform present(Platform platform,Map<String,Object> options) throws Exception;
	public Platform clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Platform save(Platform platform,Map<String,Object> options);
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String platformId, int version) throws Exception;
	public Platform disconnectFromAll(String platformId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public DoctorDAO getDoctorDAO();
		
	public ProfileDAO getProfileDAO();
		
	public RegistrationDAO getRegistrationDAO();
		
	
 	public SmartList<Platform> requestCandidatePlatformForDoctor(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForProfile(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForRegistration(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Platform planToRemoveDoctorList(Platform platform, String doctorIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveProfileList(Platform platform, String profileIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveRegistrationList(Platform platform, String registrationIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with patient in Registration
	public Platform planToRemoveRegistrationListWithPatient(Platform platform, String patientId, Map<String,Object> options)throws Exception;
	public int countRegistrationListWithPatient(String platformId, String patientId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with register in Registration
	public Platform planToRemoveRegistrationListWithRegister(Platform platform, String registerId, Map<String,Object> options)throws Exception;
	public int countRegistrationListWithRegister(String platformId, String registerId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Platform> queryList(String sql, Object ... parmeters);
}


