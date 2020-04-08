
package com.doublechaintech.his.hospital;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.his.BaseDAO;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;

import com.doublechaintech.his.doctorschedule.DoctorSchedule;
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.expenseitem.ExpenseItem;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;

import com.doublechaintech.his.expenseitem.ExpenseItemDAO;
import com.doublechaintech.his.doctorschedule.DoctorScheduleDAO;
import com.doublechaintech.his.department.DepartmentDAO;
import com.doublechaintech.his.doctor.DoctorDAO;
import com.doublechaintech.his.expensetype.ExpenseTypeDAO;
import com.doublechaintech.his.period.PeriodDAO;


public interface HospitalDAO extends BaseDAO{

	public SmartList<Hospital> loadAll();
	public Hospital load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Hospital> hospitalList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Hospital present(Hospital hospital,Map<String,Object> options) throws Exception;
	public Hospital clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Hospital save(Hospital hospital,Map<String,Object> options);
	public SmartList<Hospital> saveHospitalList(SmartList<Hospital> hospitalList,Map<String,Object> options);
	public SmartList<Hospital> removeHospitalList(SmartList<Hospital> hospitalList,Map<String,Object> options);
	public SmartList<Hospital> findHospitalWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countHospitalWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countHospitalWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String hospitalId, int version) throws Exception;
	public Hospital disconnectFromAll(String hospitalId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ExpenseTypeDAO getExpenseTypeDAO();
		
	public PeriodDAO getPeriodDAO();
		
	public ExpenseItemDAO getExpenseItemDAO();
		
	public DoctorDAO getDoctorDAO();
		
	public DepartmentDAO getDepartmentDAO();
		
	public DoctorScheduleDAO getDoctorScheduleDAO();
		
	
 	public SmartList<Hospital> requestCandidateHospitalForExpenseType(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Hospital> requestCandidateHospitalForPeriod(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Hospital> requestCandidateHospitalForExpenseItem(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Hospital> requestCandidateHospitalForDoctor(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Hospital> requestCandidateHospitalForDepartment(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Hospital> requestCandidateHospitalForDoctorSchedule(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Hospital planToRemoveExpenseTypeList(Hospital hospital, String expenseTypeIds[], Map<String,Object> options)throws Exception;


	public Hospital planToRemovePeriodList(Hospital hospital, String periodIds[], Map<String,Object> options)throws Exception;


	public Hospital planToRemoveExpenseItemList(Hospital hospital, String expenseItemIds[], Map<String,Object> options)throws Exception;


	//disconnect Hospital with expense_type in ExpenseItem
	public Hospital planToRemoveExpenseItemListWithExpenseType(Hospital hospital, String expenseTypeId, Map<String,Object> options)throws Exception;
	public int countExpenseItemListWithExpenseType(String hospitalId, String expenseTypeId, Map<String,Object> options)throws Exception;
	
	public Hospital planToRemoveDoctorList(Hospital hospital, String doctorIds[], Map<String,Object> options)throws Exception;


	public Hospital planToRemoveDepartmentList(Hospital hospital, String departmentIds[], Map<String,Object> options)throws Exception;


	public Hospital planToRemoveDoctorScheduleList(Hospital hospital, String doctorScheduleIds[], Map<String,Object> options)throws Exception;


	//disconnect Hospital with doctor in DoctorSchedule
	public Hospital planToRemoveDoctorScheduleListWithDoctor(Hospital hospital, String doctorId, Map<String,Object> options)throws Exception;
	public int countDoctorScheduleListWithDoctor(String hospitalId, String doctorId, Map<String,Object> options)throws Exception;
	
	//disconnect Hospital with period in DoctorSchedule
	public Hospital planToRemoveDoctorScheduleListWithPeriod(Hospital hospital, String periodId, Map<String,Object> options)throws Exception;
	public int countDoctorScheduleListWithPeriod(String hospitalId, String periodId, Map<String,Object> options)throws Exception;
	
	//disconnect Hospital with department in DoctorSchedule
	public Hospital planToRemoveDoctorScheduleListWithDepartment(Hospital hospital, String departmentId, Map<String,Object> options)throws Exception;
	public int countDoctorScheduleListWithDepartment(String hospitalId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect Hospital with expense_type in DoctorSchedule
	public Hospital planToRemoveDoctorScheduleListWithExpenseType(Hospital hospital, String expenseTypeId, Map<String,Object> options)throws Exception;
	public int countDoctorScheduleListWithExpenseType(String hospitalId, String expenseTypeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Hospital> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateHospital executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:ExpenseType的hospital的ExpenseTypeList
	public SmartList<ExpenseType> loadOurExpenseTypeList(HisUserContext userContext, List<Hospital> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Period的hospital的PeriodList
	public SmartList<Period> loadOurPeriodList(HisUserContext userContext, List<Hospital> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ExpenseItem的hospital的ExpenseItemList
	public SmartList<ExpenseItem> loadOurExpenseItemList(HisUserContext userContext, List<Hospital> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Doctor的hospital的DoctorList
	public SmartList<Doctor> loadOurDoctorList(HisUserContext userContext, List<Hospital> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Department的hospital的DepartmentList
	public SmartList<Department> loadOurDepartmentList(HisUserContext userContext, List<Hospital> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:DoctorSchedule的hospital的DoctorScheduleList
	public SmartList<DoctorSchedule> loadOurDoctorScheduleList(HisUserContext userContext, List<Hospital> us, Map<String,Object> options) throws Exception;
	
}


