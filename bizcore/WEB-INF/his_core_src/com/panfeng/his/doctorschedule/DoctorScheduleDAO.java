
package com.panfeng.his.doctorschedule;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.panfeng.his.BaseEntity;
import com.panfeng.his.SmartList;
import com.panfeng.his.MultipleAccessKey;
import com.panfeng.his.HisUserContext;
import com.panfeng.his.department.DepartmentDAO;
import com.panfeng.his.expensetype.ExpenseTypeDAO;
import com.panfeng.his.doctor.DoctorDAO;


public interface DoctorScheduleDAO{

	
	public DoctorSchedule load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<DoctorSchedule> doctorScheduleList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public DoctorSchedule present(DoctorSchedule doctorSchedule,Map<String,Object> options) throws Exception;
	public DoctorSchedule clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public DoctorSchedule save(DoctorSchedule doctorSchedule,Map<String,Object> options);
	public SmartList<DoctorSchedule> saveDoctorScheduleList(SmartList<DoctorSchedule> doctorScheduleList,Map<String,Object> options);
	public SmartList<DoctorSchedule> removeDoctorScheduleList(SmartList<DoctorSchedule> doctorScheduleList,Map<String,Object> options);
	public SmartList<DoctorSchedule> findDoctorScheduleWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countDoctorScheduleWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countDoctorScheduleWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String doctorScheduleId, int version) throws Exception;
	public DoctorSchedule disconnectFromAll(String doctorScheduleId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<DoctorSchedule> queryList(String sql, Object ... parmeters);
 
 	public SmartList<DoctorSchedule> findDoctorScheduleByDoctor(String doctorId, Map<String,Object> options);
 	public int countDoctorScheduleByDoctor(String doctorId, Map<String,Object> options);
 	public Map<String, Integer> countDoctorScheduleByDoctorIds(String[] ids, Map<String,Object> options);
 	public SmartList<DoctorSchedule> findDoctorScheduleByDoctor(String doctorId, int start, int count, Map<String,Object> options);
 	public void analyzeDoctorScheduleByDoctor(SmartList<DoctorSchedule> resultList, String doctorId, Map<String,Object> options);

 
  
 	public SmartList<DoctorSchedule> findDoctorScheduleByExpenseType(String expenseTypeId, Map<String,Object> options);
 	public int countDoctorScheduleByExpenseType(String expenseTypeId, Map<String,Object> options);
 	public Map<String, Integer> countDoctorScheduleByExpenseTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<DoctorSchedule> findDoctorScheduleByExpenseType(String expenseTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeDoctorScheduleByExpenseType(SmartList<DoctorSchedule> resultList, String expenseTypeId, Map<String,Object> options);

 
  
 	public SmartList<DoctorSchedule> findDoctorScheduleByDepartment(String departmentId, Map<String,Object> options);
 	public int countDoctorScheduleByDepartment(String departmentId, Map<String,Object> options);
 	public Map<String, Integer> countDoctorScheduleByDepartmentIds(String[] ids, Map<String,Object> options);
 	public SmartList<DoctorSchedule> findDoctorScheduleByDepartment(String departmentId, int start, int count, Map<String,Object> options);
 	public void analyzeDoctorScheduleByDepartment(SmartList<DoctorSchedule> resultList, String departmentId, Map<String,Object> options);

 
 }


