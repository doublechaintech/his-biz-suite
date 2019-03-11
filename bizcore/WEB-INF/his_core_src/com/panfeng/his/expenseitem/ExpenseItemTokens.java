
package com.panfeng.his.expenseitem;
import com.panfeng.his.CommonTokens;
import java.util.Map;
public class ExpenseItemTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="expenseItem";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected ExpenseItemTokens(){
		//ensure not initialized outside the class
	}
	public  static  ExpenseItemTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ExpenseItemTokens tokens = new ExpenseItemTokens(options);
		return tokens;
		
	}
	protected ExpenseItemTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ExpenseItemTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ExpenseItemTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ExpenseItemTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ExpenseItemTokens start(){
		return new ExpenseItemTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ExpenseItemTokens allTokens(){
		
		return start()
			.withExpenseType()
			.withHospital();
	
	}
	public static ExpenseItemTokens withoutListsTokens(){
		
		return start()
			.withExpenseType()
			.withHospital();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}
	
	public ExpenseItemTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String EXPENSETYPE = "expenseType";
	public String getExpenseType(){
		return EXPENSETYPE;
	}
	public ExpenseItemTokens withExpenseType(){		
		addSimpleOptions(EXPENSETYPE);
		return this;
	}
	
	
	protected static final String HOSPITAL = "hospital";
	public String getHospital(){
		return HOSPITAL;
	}
	public ExpenseItemTokens withHospital(){		
		addSimpleOptions(HOSPITAL);
		return this;
	}
	
	
	
	public  ExpenseItemTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

