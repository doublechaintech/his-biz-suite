
package com.panfeng.his.doctorassignment;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.panfeng.his.BaseEntity;
import com.panfeng.his.SmartList;
import com.panfeng.his.MultipleAccessKey;
import com.panfeng.his.HisUserContext;
import com.panfeng.his.department.DepartmentDAO;
import com.panfeng.his.doctor.DoctorDAO;


public interface DoctorAssignmentDAO{

	
	public DoctorAssignment load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<DoctorAssignment> doctorAssignmentList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public DoctorAssignment present(DoctorAssignment doctorAssignment,Map<String,Object> options) throws Exception;
	public DoctorAssignment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public DoctorAssignment save(DoctorAssignment doctorAssignment,Map<String,Object> options);
	public SmartList<DoctorAssignment> saveDoctorAssignmentList(SmartList<DoctorAssignment> doctorAssignmentList,Map<String,Object> options);
	public SmartList<DoctorAssignment> removeDoctorAssignmentList(SmartList<DoctorAssignment> doctorAssignmentList,Map<String,Object> options);
	public SmartList<DoctorAssignment> findDoctorAssignmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countDoctorAssignmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countDoctorAssignmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String doctorAssignmentId, int version) throws Exception;
	public DoctorAssignment disconnectFromAll(String doctorAssignmentId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<DoctorAssignment> queryList(String sql, Object ... parmeters);
 
 	public SmartList<DoctorAssignment> findDoctorAssignmentByDoctor(String doctorId, Map<String,Object> options);
 	public int countDoctorAssignmentByDoctor(String doctorId, Map<String,Object> options);
 	public Map<String, Integer> countDoctorAssignmentByDoctorIds(String[] ids, Map<String,Object> options);
 	public SmartList<DoctorAssignment> findDoctorAssignmentByDoctor(String doctorId, int start, int count, Map<String,Object> options);
 	public void analyzeDoctorAssignmentByDoctor(SmartList<DoctorAssignment> resultList, String doctorId, Map<String,Object> options);

 
  
 	public SmartList<DoctorAssignment> findDoctorAssignmentByDepartment(String departmentId, Map<String,Object> options);
 	public int countDoctorAssignmentByDepartment(String departmentId, Map<String,Object> options);
 	public Map<String, Integer> countDoctorAssignmentByDepartmentIds(String[] ids, Map<String,Object> options);
 	public SmartList<DoctorAssignment> findDoctorAssignmentByDepartment(String departmentId, int start, int count, Map<String,Object> options);
 	public void analyzeDoctorAssignmentByDepartment(SmartList<DoctorAssignment> resultList, String departmentId, Map<String,Object> options);

 
 }


