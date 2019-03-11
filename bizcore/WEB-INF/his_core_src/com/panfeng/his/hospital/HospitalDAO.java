
package com.panfeng.his.hospital;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.panfeng.his.BaseEntity;
import com.panfeng.his.SmartList;
import com.panfeng.his.MultipleAccessKey;
import com.panfeng.his.HisUserContext;
import com.panfeng.his.expenseitem.ExpenseItemDAO;
import com.panfeng.his.department.DepartmentDAO;
import com.panfeng.his.expensetype.ExpenseTypeDAO;
import com.panfeng.his.doctor.DoctorDAO;


public interface HospitalDAO{

	
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
		
	public ExpenseItemDAO getExpenseItemDAO();
		
	public DoctorDAO getDoctorDAO();
		
	public DepartmentDAO getDepartmentDAO();
		
	
 	public SmartList<Hospital> requestCandidateHospitalForExpenseType(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Hospital> requestCandidateHospitalForExpenseItem(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Hospital> requestCandidateHospitalForDoctor(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Hospital> requestCandidateHospitalForDepartment(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Hospital planToRemoveExpenseTypeList(Hospital hospital, String expenseTypeIds[], Map<String,Object> options)throws Exception;


	public Hospital planToRemoveExpenseItemList(Hospital hospital, String expenseItemIds[], Map<String,Object> options)throws Exception;


	//disconnect Hospital with expense_type in ExpenseItem
	public Hospital planToRemoveExpenseItemListWithExpenseType(Hospital hospital, String expenseTypeId, Map<String,Object> options)throws Exception;
	public int countExpenseItemListWithExpenseType(String hospitalId, String expenseTypeId, Map<String,Object> options)throws Exception;
	
	public Hospital planToRemoveDoctorList(Hospital hospital, String doctorIds[], Map<String,Object> options)throws Exception;


	public Hospital planToRemoveDepartmentList(Hospital hospital, String departmentIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<Hospital> queryList(String sql, Object ... parmeters);
}


