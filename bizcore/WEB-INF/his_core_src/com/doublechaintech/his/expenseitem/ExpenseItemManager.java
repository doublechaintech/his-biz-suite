
package com.doublechaintech.his.expenseitem;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;

public interface ExpenseItemManager{

		

	public ExpenseItem createExpenseItem(HisUserContext userContext, String name, BigDecimal price, String expenseTypeId, String hospitalId) throws Exception;	
	public ExpenseItem updateExpenseItem(HisUserContext userContext,String expenseItemId, int expenseItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ExpenseItem loadExpenseItem(HisUserContext userContext, String expenseItemId, String [] tokensExpr) throws Exception;
	public ExpenseItem internalSaveExpenseItem(HisUserContext userContext, ExpenseItem expenseItem) throws Exception;
	public ExpenseItem internalSaveExpenseItem(HisUserContext userContext, ExpenseItem expenseItem,Map<String,Object>option) throws Exception;
	
	public ExpenseItem transferToAnotherExpenseType(HisUserContext userContext, String expenseItemId, String anotherExpenseTypeId)  throws Exception;
 	public ExpenseItem transferToAnotherHospital(HisUserContext userContext, String expenseItemId, String anotherHospitalId)  throws Exception;
 

	public void delete(HisUserContext userContext, String expenseItemId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, ExpenseItem newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


