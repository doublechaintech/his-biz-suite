
package com.doublechaintech.his.expensetype;
import com.doublechaintech.his.CommonTokens;
import java.util.Map;
public class ExpenseTypeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="expenseType";
	
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
	protected ExpenseTypeTokens(){
		//ensure not initialized outside the class
	}
	public  static  ExpenseTypeTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ExpenseTypeTokens tokens = new ExpenseTypeTokens(options);
		return tokens;
		
	}
	protected ExpenseTypeTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ExpenseTypeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ExpenseTypeTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ExpenseTypeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ExpenseTypeTokens start(){
		return new ExpenseTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ExpenseTypeTokens allTokens(){
		
		return start()
			.withHospital()
			.withExpenseItemList()
			.withDoctorScheduleList();
	
	}
	public static ExpenseTypeTokens withoutListsTokens(){
		
		return start()
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
	
	public ExpenseTypeTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String HOSPITAL = "hospital";
	public String getHospital(){
		return HOSPITAL;
	}
	public ExpenseTypeTokens withHospital(){		
		addSimpleOptions(HOSPITAL);
		return this;
	}
	
	
	protected static final String EXPENSE_ITEM_LIST = "expenseItemList";
	public String getExpenseItemList(){
		return EXPENSE_ITEM_LIST;
	}
	public ExpenseTypeTokens withExpenseItemList(){		
		addSimpleOptions(EXPENSE_ITEM_LIST);
		return this;
	}
	public ExpenseTypeTokens analyzeExpenseItemList(){		
		addSimpleOptions(EXPENSE_ITEM_LIST+".anaylze");
		return this;
	}
	public boolean analyzeExpenseItemListEnabled(){		
		
		if(checkOptions(this.options(), EXPENSE_ITEM_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public ExpenseTypeTokens extractMoreFromExpenseItemList(String idsSeperatedWithComma){		
		addSimpleOptions(EXPENSE_ITEM_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int expenseItemListSortCounter = 0;
	public ExpenseTypeTokens sortExpenseItemListWith(String field, String descOrAsc){		
		addSortMoreOptions(EXPENSE_ITEM_LIST,expenseItemListSortCounter++, field, descOrAsc);
		return this;
	}
	private int expenseItemListSearchCounter = 0;
	public ExpenseTypeTokens searchExpenseItemListWith(String field, String verb, String value){		
		
		withExpenseItemList();
		addSearchMoreOptions(EXPENSE_ITEM_LIST,expenseItemListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ExpenseTypeTokens searchAllTextOfExpenseItemList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(EXPENSE_ITEM_LIST,expenseItemListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ExpenseTypeTokens rowsPerPageOfExpenseItemList(int rowsPerPage){		
		addSimpleOptions(EXPENSE_ITEM_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ExpenseTypeTokens currentPageNumberOfExpenseItemList(int currentPageNumber){		
		addSimpleOptions(EXPENSE_ITEM_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ExpenseTypeTokens retainColumnsOfExpenseItemList(String[] columns){		
		addSimpleOptions(EXPENSE_ITEM_LIST+"RetainColumns",columns);
		return this;
	}
	public ExpenseTypeTokens excludeColumnsOfExpenseItemList(String[] columns){		
		addSimpleOptions(EXPENSE_ITEM_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String DOCTOR_SCHEDULE_LIST = "doctorScheduleList";
	public String getDoctorScheduleList(){
		return DOCTOR_SCHEDULE_LIST;
	}
	public ExpenseTypeTokens withDoctorScheduleList(){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST);
		return this;
	}
	public ExpenseTypeTokens analyzeDoctorScheduleList(){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeDoctorScheduleListEnabled(){		
		
		if(checkOptions(this.options(), DOCTOR_SCHEDULE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public ExpenseTypeTokens extractMoreFromDoctorScheduleList(String idsSeperatedWithComma){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int doctorScheduleListSortCounter = 0;
	public ExpenseTypeTokens sortDoctorScheduleListWith(String field, String descOrAsc){		
		addSortMoreOptions(DOCTOR_SCHEDULE_LIST,doctorScheduleListSortCounter++, field, descOrAsc);
		return this;
	}
	private int doctorScheduleListSearchCounter = 0;
	public ExpenseTypeTokens searchDoctorScheduleListWith(String field, String verb, String value){		
		
		withDoctorScheduleList();
		addSearchMoreOptions(DOCTOR_SCHEDULE_LIST,doctorScheduleListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ExpenseTypeTokens searchAllTextOfDoctorScheduleList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(DOCTOR_SCHEDULE_LIST,doctorScheduleListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ExpenseTypeTokens rowsPerPageOfDoctorScheduleList(int rowsPerPage){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ExpenseTypeTokens currentPageNumberOfDoctorScheduleList(int currentPageNumber){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ExpenseTypeTokens retainColumnsOfDoctorScheduleList(String[] columns){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"RetainColumns",columns);
		return this;
	}
	public ExpenseTypeTokens excludeColumnsOfDoctorScheduleList(String[] columns){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ExpenseTypeTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfExpenseItemList(verb, value);	
		searchAllTextOfDoctorScheduleList(verb, value);	
		return this;
	}
}

