
package com.doublechaintech.his.hospital;
import com.doublechaintech.his.CommonTokens;
import java.util.Map;
public class HospitalTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="hospital";
	
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
	protected HospitalTokens(){
		//ensure not initialized outside the class
	}
	public  static  HospitalTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		HospitalTokens tokens = new HospitalTokens(options);
		return tokens;
		
	}
	protected HospitalTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public HospitalTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static HospitalTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected HospitalTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static HospitalTokens start(){
		return new HospitalTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static HospitalTokens allTokens(){
		
		return start()
			.withExpenseTypeList()
			.withPeriodList()
			.withExpenseItemList()
			.withDoctorList()
			.withDepartmentList()
			.withDoctorScheduleList();
	
	}
	public static HospitalTokens withoutListsTokens(){
		
		return start();
	
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
	
	public HospitalTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String EXPENSE_TYPE_LIST = "expenseTypeList";
	public String getExpenseTypeList(){
		return EXPENSE_TYPE_LIST;
	}
	public HospitalTokens withExpenseTypeList(){		
		addSimpleOptions(EXPENSE_TYPE_LIST);
		return this;
	}
	public HospitalTokens analyzeExpenseTypeList(){		
		addSimpleOptions(EXPENSE_TYPE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeExpenseTypeListEnabled(){		
		
		if(checkOptions(this.options(), EXPENSE_TYPE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public HospitalTokens extractMoreFromExpenseTypeList(String idsSeperatedWithComma){		
		addSimpleOptions(EXPENSE_TYPE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int expenseTypeListSortCounter = 0;
	public HospitalTokens sortExpenseTypeListWith(String field, String descOrAsc){		
		addSortMoreOptions(EXPENSE_TYPE_LIST,expenseTypeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int expenseTypeListSearchCounter = 0;
	public HospitalTokens searchExpenseTypeListWith(String field, String verb, String value){		
		addSearchMoreOptions(EXPENSE_TYPE_LIST,expenseTypeListSearchCounter++, field, verb, value);
		return this;
	}
	
	public HospitalTokens searchAllTextOfExpenseTypeList(String verb, String value){	
		String field = "id|name|helperChars|status|description";
		addSearchMoreOptions(EXPENSE_TYPE_LIST,expenseTypeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HospitalTokens rowsPerPageOfExpenseTypeList(int rowsPerPage){		
		addSimpleOptions(EXPENSE_TYPE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public HospitalTokens currentPageNumberOfExpenseTypeList(int currentPageNumber){		
		addSimpleOptions(EXPENSE_TYPE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public HospitalTokens retainColumnsOfExpenseTypeList(String[] columns){		
		addSimpleOptions(EXPENSE_TYPE_LIST+"RetainColumns",columns);
		return this;
	}
	public HospitalTokens excludeColumnsOfExpenseTypeList(String[] columns){		
		addSimpleOptions(EXPENSE_TYPE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String PERIOD_LIST = "periodList";
	public String getPeriodList(){
		return PERIOD_LIST;
	}
	public HospitalTokens withPeriodList(){		
		addSimpleOptions(PERIOD_LIST);
		return this;
	}
	public HospitalTokens analyzePeriodList(){		
		addSimpleOptions(PERIOD_LIST+".anaylze");
		return this;
	}
	public boolean analyzePeriodListEnabled(){		
		
		if(checkOptions(this.options(), PERIOD_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public HospitalTokens extractMoreFromPeriodList(String idsSeperatedWithComma){		
		addSimpleOptions(PERIOD_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int periodListSortCounter = 0;
	public HospitalTokens sortPeriodListWith(String field, String descOrAsc){		
		addSortMoreOptions(PERIOD_LIST,periodListSortCounter++, field, descOrAsc);
		return this;
	}
	private int periodListSearchCounter = 0;
	public HospitalTokens searchPeriodListWith(String field, String verb, String value){		
		addSearchMoreOptions(PERIOD_LIST,periodListSearchCounter++, field, verb, value);
		return this;
	}
	
	public HospitalTokens searchAllTextOfPeriodList(String verb, String value){	
		String field = "id|name|code";
		addSearchMoreOptions(PERIOD_LIST,periodListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HospitalTokens rowsPerPageOfPeriodList(int rowsPerPage){		
		addSimpleOptions(PERIOD_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public HospitalTokens currentPageNumberOfPeriodList(int currentPageNumber){		
		addSimpleOptions(PERIOD_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public HospitalTokens retainColumnsOfPeriodList(String[] columns){		
		addSimpleOptions(PERIOD_LIST+"RetainColumns",columns);
		return this;
	}
	public HospitalTokens excludeColumnsOfPeriodList(String[] columns){		
		addSimpleOptions(PERIOD_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String EXPENSE_ITEM_LIST = "expenseItemList";
	public String getExpenseItemList(){
		return EXPENSE_ITEM_LIST;
	}
	public HospitalTokens withExpenseItemList(){		
		addSimpleOptions(EXPENSE_ITEM_LIST);
		return this;
	}
	public HospitalTokens analyzeExpenseItemList(){		
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
	public HospitalTokens extractMoreFromExpenseItemList(String idsSeperatedWithComma){		
		addSimpleOptions(EXPENSE_ITEM_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int expenseItemListSortCounter = 0;
	public HospitalTokens sortExpenseItemListWith(String field, String descOrAsc){		
		addSortMoreOptions(EXPENSE_ITEM_LIST,expenseItemListSortCounter++, field, descOrAsc);
		return this;
	}
	private int expenseItemListSearchCounter = 0;
	public HospitalTokens searchExpenseItemListWith(String field, String verb, String value){		
		addSearchMoreOptions(EXPENSE_ITEM_LIST,expenseItemListSearchCounter++, field, verb, value);
		return this;
	}
	
	public HospitalTokens searchAllTextOfExpenseItemList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(EXPENSE_ITEM_LIST,expenseItemListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HospitalTokens rowsPerPageOfExpenseItemList(int rowsPerPage){		
		addSimpleOptions(EXPENSE_ITEM_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public HospitalTokens currentPageNumberOfExpenseItemList(int currentPageNumber){		
		addSimpleOptions(EXPENSE_ITEM_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public HospitalTokens retainColumnsOfExpenseItemList(String[] columns){		
		addSimpleOptions(EXPENSE_ITEM_LIST+"RetainColumns",columns);
		return this;
	}
	public HospitalTokens excludeColumnsOfExpenseItemList(String[] columns){		
		addSimpleOptions(EXPENSE_ITEM_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String DOCTOR_LIST = "doctorList";
	public String getDoctorList(){
		return DOCTOR_LIST;
	}
	public HospitalTokens withDoctorList(){		
		addSimpleOptions(DOCTOR_LIST);
		return this;
	}
	public HospitalTokens analyzeDoctorList(){		
		addSimpleOptions(DOCTOR_LIST+".anaylze");
		return this;
	}
	public boolean analyzeDoctorListEnabled(){		
		
		if(checkOptions(this.options(), DOCTOR_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public HospitalTokens extractMoreFromDoctorList(String idsSeperatedWithComma){		
		addSimpleOptions(DOCTOR_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int doctorListSortCounter = 0;
	public HospitalTokens sortDoctorListWith(String field, String descOrAsc){		
		addSortMoreOptions(DOCTOR_LIST,doctorListSortCounter++, field, descOrAsc);
		return this;
	}
	private int doctorListSearchCounter = 0;
	public HospitalTokens searchDoctorListWith(String field, String verb, String value){		
		addSearchMoreOptions(DOCTOR_LIST,doctorListSearchCounter++, field, verb, value);
		return this;
	}
	
	public HospitalTokens searchAllTextOfDoctorList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(DOCTOR_LIST,doctorListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HospitalTokens rowsPerPageOfDoctorList(int rowsPerPage){		
		addSimpleOptions(DOCTOR_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public HospitalTokens currentPageNumberOfDoctorList(int currentPageNumber){		
		addSimpleOptions(DOCTOR_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public HospitalTokens retainColumnsOfDoctorList(String[] columns){		
		addSimpleOptions(DOCTOR_LIST+"RetainColumns",columns);
		return this;
	}
	public HospitalTokens excludeColumnsOfDoctorList(String[] columns){		
		addSimpleOptions(DOCTOR_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String DEPARTMENT_LIST = "departmentList";
	public String getDepartmentList(){
		return DEPARTMENT_LIST;
	}
	public HospitalTokens withDepartmentList(){		
		addSimpleOptions(DEPARTMENT_LIST);
		return this;
	}
	public HospitalTokens analyzeDepartmentList(){		
		addSimpleOptions(DEPARTMENT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeDepartmentListEnabled(){		
		
		if(checkOptions(this.options(), DEPARTMENT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public HospitalTokens extractMoreFromDepartmentList(String idsSeperatedWithComma){		
		addSimpleOptions(DEPARTMENT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int departmentListSortCounter = 0;
	public HospitalTokens sortDepartmentListWith(String field, String descOrAsc){		
		addSortMoreOptions(DEPARTMENT_LIST,departmentListSortCounter++, field, descOrAsc);
		return this;
	}
	private int departmentListSearchCounter = 0;
	public HospitalTokens searchDepartmentListWith(String field, String verb, String value){		
		addSearchMoreOptions(DEPARTMENT_LIST,departmentListSearchCounter++, field, verb, value);
		return this;
	}
	
	public HospitalTokens searchAllTextOfDepartmentList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(DEPARTMENT_LIST,departmentListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HospitalTokens rowsPerPageOfDepartmentList(int rowsPerPage){		
		addSimpleOptions(DEPARTMENT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public HospitalTokens currentPageNumberOfDepartmentList(int currentPageNumber){		
		addSimpleOptions(DEPARTMENT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public HospitalTokens retainColumnsOfDepartmentList(String[] columns){		
		addSimpleOptions(DEPARTMENT_LIST+"RetainColumns",columns);
		return this;
	}
	public HospitalTokens excludeColumnsOfDepartmentList(String[] columns){		
		addSimpleOptions(DEPARTMENT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String DOCTOR_SCHEDULE_LIST = "doctorScheduleList";
	public String getDoctorScheduleList(){
		return DOCTOR_SCHEDULE_LIST;
	}
	public HospitalTokens withDoctorScheduleList(){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST);
		return this;
	}
	public HospitalTokens analyzeDoctorScheduleList(){		
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
	public HospitalTokens extractMoreFromDoctorScheduleList(String idsSeperatedWithComma){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int doctorScheduleListSortCounter = 0;
	public HospitalTokens sortDoctorScheduleListWith(String field, String descOrAsc){		
		addSortMoreOptions(DOCTOR_SCHEDULE_LIST,doctorScheduleListSortCounter++, field, descOrAsc);
		return this;
	}
	private int doctorScheduleListSearchCounter = 0;
	public HospitalTokens searchDoctorScheduleListWith(String field, String verb, String value){		
		addSearchMoreOptions(DOCTOR_SCHEDULE_LIST,doctorScheduleListSearchCounter++, field, verb, value);
		return this;
	}
	
	public HospitalTokens searchAllTextOfDoctorScheduleList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(DOCTOR_SCHEDULE_LIST,doctorScheduleListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HospitalTokens rowsPerPageOfDoctorScheduleList(int rowsPerPage){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public HospitalTokens currentPageNumberOfDoctorScheduleList(int currentPageNumber){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public HospitalTokens retainColumnsOfDoctorScheduleList(String[] columns){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"RetainColumns",columns);
		return this;
	}
	public HospitalTokens excludeColumnsOfDoctorScheduleList(String[] columns){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  HospitalTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfExpenseTypeList(verb, value);	
		searchAllTextOfPeriodList(verb, value);	
		searchAllTextOfExpenseItemList(verb, value);	
		searchAllTextOfDoctorList(verb, value);	
		searchAllTextOfDepartmentList(verb, value);	
		searchAllTextOfDoctorScheduleList(verb, value);	
		return this;
	}
}

