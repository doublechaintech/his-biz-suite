
package com.panfeng.his.department;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.panfeng.his.BaseEntity;
import com.panfeng.his.SmartList;
import com.panfeng.his.MultipleAccessKey;
import com.panfeng.his.HisUserContext;
import com.panfeng.his.hospital.HospitalDAO;
import com.panfeng.his.doctorassignment.DoctorAssignmentDAO;
import com.panfeng.his.doctorschedule.DoctorScheduleDAO;


public interface DepartmentDAO{

	
	public Department load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Department> departmentList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Department present(Department department,Map<String,Object> options) throws Exception;
	public Department clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Department save(Department department,Map<String,Object> options);
	public SmartList<Department> saveDepartmentList(SmartList<Department> departmentList,Map<String,Object> options);
	public SmartList<Department> removeDepartmentList(SmartList<Department> departmentList,Map<String,Object> options);
	public SmartList<Department> findDepartmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countDepartmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countDepartmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String departmentId, int version) throws Exception;
	public Department disconnectFromAll(String departmentId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public DoctorAssignmentDAO getDoctorAssignmentDAO();
		
	public DoctorScheduleDAO getDoctorScheduleDAO();
		
	
 	public SmartList<Department> requestCandidateDepartmentForDoctorAssignment(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Department> requestCandidateDepartmentForDoctorSchedule(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Department planToRemoveDoctorAssignmentList(Department department, String doctorAssignmentIds[], Map<String,Object> options)throws Exception;


	//disconnect Department with doctor in DoctorAssignment
	public Department planToRemoveDoctorAssignmentListWithDoctor(Department department, String doctorId, Map<String,Object> options)throws Exception;
	public int countDoctorAssignmentListWithDoctor(String departmentId, String doctorId, Map<String,Object> options)throws Exception;
	
	public Department planToRemoveDoctorScheduleList(Department department, String doctorScheduleIds[], Map<String,Object> options)throws Exception;


	//disconnect Department with doctor in DoctorSchedule
	public Department planToRemoveDoctorScheduleListWithDoctor(Department department, String doctorId, Map<String,Object> options)throws Exception;
	public int countDoctorScheduleListWithDoctor(String departmentId, String doctorId, Map<String,Object> options)throws Exception;
	
	//disconnect Department with expense_type in DoctorSchedule
	public Department planToRemoveDoctorScheduleListWithExpenseType(Department department, String expenseTypeId, Map<String,Object> options)throws Exception;
	public int countDoctorScheduleListWithExpenseType(String departmentId, String expenseTypeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Department> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Department> findDepartmentByHospital(String hospitalId, Map<String,Object> options);
 	public int countDepartmentByHospital(String hospitalId, Map<String,Object> options);
 	public Map<String, Integer> countDepartmentByHospitalIds(String[] ids, Map<String,Object> options);
 	public SmartList<Department> findDepartmentByHospital(String hospitalId, int start, int count, Map<String,Object> options);
 	public void analyzeDepartmentByHospital(SmartList<Department> resultList, String hospitalId, Map<String,Object> options);

 
 }


