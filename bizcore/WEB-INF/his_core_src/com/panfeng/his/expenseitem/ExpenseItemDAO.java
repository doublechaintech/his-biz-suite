
package com.panfeng.his.expenseitem;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.panfeng.his.BaseEntity;
import com.panfeng.his.SmartList;
import com.panfeng.his.MultipleAccessKey;
import com.panfeng.his.HisUserContext;
import com.panfeng.his.hospital.HospitalDAO;
import com.panfeng.his.expensetype.ExpenseTypeDAO;


public interface ExpenseItemDAO{

	
	public ExpenseItem load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ExpenseItem> expenseItemList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ExpenseItem present(ExpenseItem expenseItem,Map<String,Object> options) throws Exception;
	public ExpenseItem clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ExpenseItem save(ExpenseItem expenseItem,Map<String,Object> options);
	public SmartList<ExpenseItem> saveExpenseItemList(SmartList<ExpenseItem> expenseItemList,Map<String,Object> options);
	public SmartList<ExpenseItem> removeExpenseItemList(SmartList<ExpenseItem> expenseItemList,Map<String,Object> options);
	public SmartList<ExpenseItem> findExpenseItemWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countExpenseItemWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countExpenseItemWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String expenseItemId, int version) throws Exception;
	public ExpenseItem disconnectFromAll(String expenseItemId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ExpenseItem> queryList(String sql, Object ... parmeters);
 
 	public SmartList<ExpenseItem> findExpenseItemByExpenseType(String expenseTypeId, Map<String,Object> options);
 	public int countExpenseItemByExpenseType(String expenseTypeId, Map<String,Object> options);
 	public Map<String, Integer> countExpenseItemByExpenseTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<ExpenseItem> findExpenseItemByExpenseType(String expenseTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeExpenseItemByExpenseType(SmartList<ExpenseItem> resultList, String expenseTypeId, Map<String,Object> options);

 
  
 	public SmartList<ExpenseItem> findExpenseItemByHospital(String hospitalId, Map<String,Object> options);
 	public int countExpenseItemByHospital(String hospitalId, Map<String,Object> options);
 	public Map<String, Integer> countExpenseItemByHospitalIds(String[] ids, Map<String,Object> options);
 	public SmartList<ExpenseItem> findExpenseItemByHospital(String hospitalId, int start, int count, Map<String,Object> options);
 	public void analyzeExpenseItemByHospital(SmartList<ExpenseItem> resultList, String hospitalId, Map<String,Object> options);

 
 }


