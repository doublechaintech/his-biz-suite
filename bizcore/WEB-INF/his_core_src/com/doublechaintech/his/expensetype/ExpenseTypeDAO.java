
package com.doublechaintech.his.expensetype;
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
import com.doublechaintech.his.doctorschedule.DoctorSchedule;
import com.doublechaintech.his.expenseitem.ExpenseItem;

import com.doublechaintech.his.expenseitem.ExpenseItemDAO;
import com.doublechaintech.his.doctorschedule.DoctorScheduleDAO;
import com.doublechaintech.his.hospital.HospitalDAO;


public interface ExpenseTypeDAO extends BaseDAO{

	public SmartList<ExpenseType> loadAll();
	public ExpenseType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ExpenseType> expenseTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ExpenseType present(ExpenseType expenseType,Map<String,Object> options) throws Exception;
	public ExpenseType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ExpenseType save(ExpenseType expenseType,Map<String,Object> options);
	public SmartList<ExpenseType> saveExpenseTypeList(SmartList<ExpenseType> expenseTypeList,Map<String,Object> options);
	public SmartList<ExpenseType> removeExpenseTypeList(SmartList<ExpenseType> expenseTypeList,Map<String,Object> options);
	public SmartList<ExpenseType> findExpenseTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countExpenseTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countExpenseTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String expenseTypeId, int version) throws Exception;
	public ExpenseType disconnectFromAll(String expenseTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ExpenseItemDAO getExpenseItemDAO();
		
	public DoctorScheduleDAO getDoctorScheduleDAO();
		
	
 	public SmartList<ExpenseType> requestCandidateExpenseTypeForExpenseItem(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<ExpenseType> requestCandidateExpenseTypeForDoctorSchedule(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public ExpenseType planToRemoveExpenseItemList(ExpenseType expenseType, String expenseItemIds[], Map<String,Object> options)throws Exception;


	//disconnect ExpenseType with hospital in ExpenseItem
	public ExpenseType planToRemoveExpenseItemListWithHospital(ExpenseType expenseType, String hospitalId, Map<String,Object> options)throws Exception;
	public int countExpenseItemListWithHospital(String expenseTypeId, String hospitalId, Map<String,Object> options)throws Exception;
	
	public ExpenseType planToRemoveDoctorScheduleList(ExpenseType expenseType, String doctorScheduleIds[], Map<String,Object> options)throws Exception;


	//disconnect ExpenseType with doctor in DoctorSchedule
	public ExpenseType planToRemoveDoctorScheduleListWithDoctor(ExpenseType expenseType, String doctorId, Map<String,Object> options)throws Exception;
	public int countDoctorScheduleListWithDoctor(String expenseTypeId, String doctorId, Map<String,Object> options)throws Exception;
	
	//disconnect ExpenseType with period in DoctorSchedule
	public ExpenseType planToRemoveDoctorScheduleListWithPeriod(ExpenseType expenseType, String periodId, Map<String,Object> options)throws Exception;
	public int countDoctorScheduleListWithPeriod(String expenseTypeId, String periodId, Map<String,Object> options)throws Exception;
	
	//disconnect ExpenseType with department in DoctorSchedule
	public ExpenseType planToRemoveDoctorScheduleListWithDepartment(ExpenseType expenseType, String departmentId, Map<String,Object> options)throws Exception;
	public int countDoctorScheduleListWithDepartment(String expenseTypeId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect ExpenseType with hospital in DoctorSchedule
	public ExpenseType planToRemoveDoctorScheduleListWithHospital(ExpenseType expenseType, String hospitalId, Map<String,Object> options)throws Exception;
	public int countDoctorScheduleListWithHospital(String expenseTypeId, String hospitalId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<ExpenseType> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateExpenseType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<ExpenseType> findExpenseTypeByHospital(String hospitalId, Map<String,Object> options);
 	public int countExpenseTypeByHospital(String hospitalId, Map<String,Object> options);
 	public Map<String, Integer> countExpenseTypeByHospitalIds(String[] ids, Map<String,Object> options);
 	public SmartList<ExpenseType> findExpenseTypeByHospital(String hospitalId, int start, int count, Map<String,Object> options);
 	public void analyzeExpenseTypeByHospital(SmartList<ExpenseType> resultList, String hospitalId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:ExpenseItem的expenseType的ExpenseItemList
	public SmartList<ExpenseItem> loadOurExpenseItemList(HisUserContext userContext, List<ExpenseType> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:DoctorSchedule的expenseType的DoctorScheduleList
	public SmartList<DoctorSchedule> loadOurDoctorScheduleList(HisUserContext userContext, List<ExpenseType> us, Map<String,Object> options) throws Exception;
	
}


