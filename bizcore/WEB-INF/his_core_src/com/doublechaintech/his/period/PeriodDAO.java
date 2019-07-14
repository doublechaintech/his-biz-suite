
package com.doublechaintech.his.period;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;

import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.doctorschedule.DoctorSchedule;

import com.doublechaintech.his.doctorschedule.DoctorScheduleDAO;
import com.doublechaintech.his.hospital.HospitalDAO;


public interface PeriodDAO{

	
	public Period load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Period> periodList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Period present(Period period,Map<String,Object> options) throws Exception;
	public Period clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Period save(Period period,Map<String,Object> options);
	public SmartList<Period> savePeriodList(SmartList<Period> periodList,Map<String,Object> options);
	public SmartList<Period> removePeriodList(SmartList<Period> periodList,Map<String,Object> options);
	public SmartList<Period> findPeriodWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPeriodWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPeriodWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String periodId, int version) throws Exception;
	public Period disconnectFromAll(String periodId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public DoctorScheduleDAO getDoctorScheduleDAO();
		
	
 	public SmartList<Period> requestCandidatePeriodForDoctorSchedule(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Period planToRemoveDoctorScheduleList(Period period, String doctorScheduleIds[], Map<String,Object> options)throws Exception;


	//disconnect Period with doctor in DoctorSchedule
	public Period planToRemoveDoctorScheduleListWithDoctor(Period period, String doctorId, Map<String,Object> options)throws Exception;
	public int countDoctorScheduleListWithDoctor(String periodId, String doctorId, Map<String,Object> options)throws Exception;
	
	//disconnect Period with department in DoctorSchedule
	public Period planToRemoveDoctorScheduleListWithDepartment(Period period, String departmentId, Map<String,Object> options)throws Exception;
	public int countDoctorScheduleListWithDepartment(String periodId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect Period with expense_type in DoctorSchedule
	public Period planToRemoveDoctorScheduleListWithExpenseType(Period period, String expenseTypeId, Map<String,Object> options)throws Exception;
	public int countDoctorScheduleListWithExpenseType(String periodId, String expenseTypeId, Map<String,Object> options)throws Exception;
	
	//disconnect Period with hospital in DoctorSchedule
	public Period planToRemoveDoctorScheduleListWithHospital(Period period, String hospitalId, Map<String,Object> options)throws Exception;
	public int countDoctorScheduleListWithHospital(String periodId, String hospitalId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Period> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Period> findPeriodByHospital(String hospitalId, Map<String,Object> options);
 	public int countPeriodByHospital(String hospitalId, Map<String,Object> options);
 	public Map<String, Integer> countPeriodByHospitalIds(String[] ids, Map<String,Object> options);
 	public SmartList<Period> findPeriodByHospital(String hospitalId, int start, int count, Map<String,Object> options);
 	public void analyzePeriodByHospital(SmartList<Period> resultList, String hospitalId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:DoctorSchedule的period的DoctorScheduleList
	public SmartList<DoctorSchedule> loadOurDoctorScheduleList(HisUserContext userContext, List<Period> us, Map<String,Object> options) throws Exception;
	
}


