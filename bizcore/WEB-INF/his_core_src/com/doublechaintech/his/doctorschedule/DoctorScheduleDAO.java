
package com.doublechaintech.his.doctorschedule;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.his.BaseDAO;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;

import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;

import com.doublechaintech.his.department.DepartmentDAO;
import com.doublechaintech.his.doctor.DoctorDAO;
import com.doublechaintech.his.expensetype.ExpenseTypeDAO;
import com.doublechaintech.his.period.PeriodDAO;
import com.doublechaintech.his.hospital.HospitalDAO;


public interface DoctorScheduleDAO extends BaseDAO{

	public SmartList<DoctorSchedule> loadAll();
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
	public int count(String sql, Object ... parmeters);
	public CandidateDoctorSchedule executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<DoctorSchedule> findDoctorScheduleByDoctor(String doctorId, Map<String,Object> options);
 	public int countDoctorScheduleByDoctor(String doctorId, Map<String,Object> options);
 	public Map<String, Integer> countDoctorScheduleByDoctorIds(String[] ids, Map<String,Object> options);
 	public SmartList<DoctorSchedule> findDoctorScheduleByDoctor(String doctorId, int start, int count, Map<String,Object> options);
 	public void analyzeDoctorScheduleByDoctor(SmartList<DoctorSchedule> resultList, String doctorId, Map<String,Object> options);

 
  
 	public SmartList<DoctorSchedule> findDoctorScheduleByPeriod(String periodId, Map<String,Object> options);
 	public int countDoctorScheduleByPeriod(String periodId, Map<String,Object> options);
 	public Map<String, Integer> countDoctorScheduleByPeriodIds(String[] ids, Map<String,Object> options);
 	public SmartList<DoctorSchedule> findDoctorScheduleByPeriod(String periodId, int start, int count, Map<String,Object> options);
 	public void analyzeDoctorScheduleByPeriod(SmartList<DoctorSchedule> resultList, String periodId, Map<String,Object> options);

 
  
 	public SmartList<DoctorSchedule> findDoctorScheduleByDepartment(String departmentId, Map<String,Object> options);
 	public int countDoctorScheduleByDepartment(String departmentId, Map<String,Object> options);
 	public Map<String, Integer> countDoctorScheduleByDepartmentIds(String[] ids, Map<String,Object> options);
 	public SmartList<DoctorSchedule> findDoctorScheduleByDepartment(String departmentId, int start, int count, Map<String,Object> options);
 	public void analyzeDoctorScheduleByDepartment(SmartList<DoctorSchedule> resultList, String departmentId, Map<String,Object> options);

 
  
 	public SmartList<DoctorSchedule> findDoctorScheduleByExpenseType(String expenseTypeId, Map<String,Object> options);
 	public int countDoctorScheduleByExpenseType(String expenseTypeId, Map<String,Object> options);
 	public Map<String, Integer> countDoctorScheduleByExpenseTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<DoctorSchedule> findDoctorScheduleByExpenseType(String expenseTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeDoctorScheduleByExpenseType(SmartList<DoctorSchedule> resultList, String expenseTypeId, Map<String,Object> options);

 
  
 	public SmartList<DoctorSchedule> findDoctorScheduleByHospital(String hospitalId, Map<String,Object> options);
 	public int countDoctorScheduleByHospital(String hospitalId, Map<String,Object> options);
 	public Map<String, Integer> countDoctorScheduleByHospitalIds(String[] ids, Map<String,Object> options);
 	public SmartList<DoctorSchedule> findDoctorScheduleByHospital(String hospitalId, int start, int count, Map<String,Object> options);
 	public void analyzeDoctorScheduleByHospital(SmartList<DoctorSchedule> resultList, String hospitalId, Map<String,Object> options);

 
 
}


