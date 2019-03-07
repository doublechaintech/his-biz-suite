
package com.doublechaintech.his.doctor;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.platform.PlatformDAO;


public interface DoctorDAO{

	
	public Doctor load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Doctor> doctorList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Doctor present(Doctor doctor,Map<String,Object> options) throws Exception;
	public Doctor clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Doctor save(Doctor doctor,Map<String,Object> options);
	public SmartList<Doctor> saveDoctorList(SmartList<Doctor> doctorList,Map<String,Object> options);
	public SmartList<Doctor> removeDoctorList(SmartList<Doctor> doctorList,Map<String,Object> options);
	public SmartList<Doctor> findDoctorWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countDoctorWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countDoctorWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String doctorId, int version) throws Exception;
	public Doctor disconnectFromAll(String doctorId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<Doctor> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Doctor> findDoctorByPlatform(String platformId, Map<String,Object> options);
 	public int countDoctorByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countDoctorByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<Doctor> findDoctorByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeDoctorByPlatform(SmartList<Doctor> resultList, String platformId, Map<String,Object> options);

 
 }


