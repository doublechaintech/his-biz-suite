
package com.panfeng.his.doctor;
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

	public DoctorAssignmentDAO getDoctorAssignmentDAO();
		
	public DoctorScheduleDAO getDoctorScheduleDAO();
		
	
 	public SmartList<Doctor> requestCandidateDoctorForDoctorAssignment(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Doctor> requestCandidateDoctorForDoctorSchedule(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Doctor planToRemoveDoctorAssignmentList(Doctor doctor, String doctorAssignmentIds[], Map<String,Object> options)throws Exception;


	//disconnect Doctor with department in DoctorAssignment
	public Doctor planToRemoveDoctorAssignmentListWithDepartment(Doctor doctor, String departmentId, Map<String,Object> options)throws Exception;
	public int countDoctorAssignmentListWithDepartment(String doctorId, String departmentId, Map<String,Object> options)throws Exception;
	
	public Doctor planToRemoveDoctorScheduleList(Doctor doctor, String doctorScheduleIds[], Map<String,Object> options)throws Exception;


	//disconnect Doctor with expense_type in DoctorSchedule
	public Doctor planToRemoveDoctorScheduleListWithExpenseType(Doctor doctor, String expenseTypeId, Map<String,Object> options)throws Exception;
	public int countDoctorScheduleListWithExpenseType(String doctorId, String expenseTypeId, Map<String,Object> options)throws Exception;
	
	//disconnect Doctor with department in DoctorSchedule
	public Doctor planToRemoveDoctorScheduleListWithDepartment(Doctor doctor, String departmentId, Map<String,Object> options)throws Exception;
	public int countDoctorScheduleListWithDepartment(String doctorId, String departmentId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Doctor> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Doctor> findDoctorByHospital(String hospitalId, Map<String,Object> options);
 	public int countDoctorByHospital(String hospitalId, Map<String,Object> options);
 	public Map<String, Integer> countDoctorByHospitalIds(String[] ids, Map<String,Object> options);
 	public SmartList<Doctor> findDoctorByHospital(String hospitalId, int start, int count, Map<String,Object> options);
 	public void analyzeDoctorByHospital(SmartList<Doctor> resultList, String hospitalId, Map<String,Object> options);

 
 }


