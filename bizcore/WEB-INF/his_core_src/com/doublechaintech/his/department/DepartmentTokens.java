
package com.doublechaintech.his.department;
import com.doublechaintech.his.CommonTokens;
import java.util.Map;
public class DepartmentTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="department";
	
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
	protected DepartmentTokens(){
		//ensure not initialized outside the class
	}
	public  static  DepartmentTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		DepartmentTokens tokens = new DepartmentTokens(options);
		return tokens;
		
	}
	protected DepartmentTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public DepartmentTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static DepartmentTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected DepartmentTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static DepartmentTokens start(){
		return new DepartmentTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static DepartmentTokens allTokens(){
		
		return start()
			.withHospital()
			.withDoctorAssignmentList()
			.withDoctorScheduleList();
	
	}
	public static DepartmentTokens withoutListsTokens(){
		
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
	
	public DepartmentTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String HOSPITAL = "hospital";
	public String getHospital(){
		return HOSPITAL;
	}
	public DepartmentTokens withHospital(){		
		addSimpleOptions(HOSPITAL);
		return this;
	}
	
	
	protected static final String DOCTOR_ASSIGNMENT_LIST = "doctorAssignmentList";
	public String getDoctorAssignmentList(){
		return DOCTOR_ASSIGNMENT_LIST;
	}
	public DepartmentTokens withDoctorAssignmentList(){		
		addSimpleOptions(DOCTOR_ASSIGNMENT_LIST);
		return this;
	}
	public DepartmentTokens analyzeDoctorAssignmentList(){		
		addSimpleOptions(DOCTOR_ASSIGNMENT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeDoctorAssignmentListEnabled(){		
		
		if(checkOptions(this.options(), DOCTOR_ASSIGNMENT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public DepartmentTokens extractMoreFromDoctorAssignmentList(String idsSeperatedWithComma){		
		addSimpleOptions(DOCTOR_ASSIGNMENT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int doctorAssignmentListSortCounter = 0;
	public DepartmentTokens sortDoctorAssignmentListWith(String field, String descOrAsc){		
		addSortMoreOptions(DOCTOR_ASSIGNMENT_LIST,doctorAssignmentListSortCounter++, field, descOrAsc);
		return this;
	}
	private int doctorAssignmentListSearchCounter = 0;
	public DepartmentTokens searchDoctorAssignmentListWith(String field, String verb, String value){		
		
		withDoctorAssignmentList();
		addSearchMoreOptions(DOCTOR_ASSIGNMENT_LIST,doctorAssignmentListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public DepartmentTokens searchAllTextOfDoctorAssignmentList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(DOCTOR_ASSIGNMENT_LIST,doctorAssignmentListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public DepartmentTokens rowsPerPageOfDoctorAssignmentList(int rowsPerPage){		
		addSimpleOptions(DOCTOR_ASSIGNMENT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public DepartmentTokens currentPageNumberOfDoctorAssignmentList(int currentPageNumber){		
		addSimpleOptions(DOCTOR_ASSIGNMENT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public DepartmentTokens retainColumnsOfDoctorAssignmentList(String[] columns){		
		addSimpleOptions(DOCTOR_ASSIGNMENT_LIST+"RetainColumns",columns);
		return this;
	}
	public DepartmentTokens excludeColumnsOfDoctorAssignmentList(String[] columns){		
		addSimpleOptions(DOCTOR_ASSIGNMENT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String DOCTOR_SCHEDULE_LIST = "doctorScheduleList";
	public String getDoctorScheduleList(){
		return DOCTOR_SCHEDULE_LIST;
	}
	public DepartmentTokens withDoctorScheduleList(){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST);
		return this;
	}
	public DepartmentTokens analyzeDoctorScheduleList(){		
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
	public DepartmentTokens extractMoreFromDoctorScheduleList(String idsSeperatedWithComma){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int doctorScheduleListSortCounter = 0;
	public DepartmentTokens sortDoctorScheduleListWith(String field, String descOrAsc){		
		addSortMoreOptions(DOCTOR_SCHEDULE_LIST,doctorScheduleListSortCounter++, field, descOrAsc);
		return this;
	}
	private int doctorScheduleListSearchCounter = 0;
	public DepartmentTokens searchDoctorScheduleListWith(String field, String verb, String value){		
		
		withDoctorScheduleList();
		addSearchMoreOptions(DOCTOR_SCHEDULE_LIST,doctorScheduleListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public DepartmentTokens searchAllTextOfDoctorScheduleList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(DOCTOR_SCHEDULE_LIST,doctorScheduleListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public DepartmentTokens rowsPerPageOfDoctorScheduleList(int rowsPerPage){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public DepartmentTokens currentPageNumberOfDoctorScheduleList(int currentPageNumber){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public DepartmentTokens retainColumnsOfDoctorScheduleList(String[] columns){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"RetainColumns",columns);
		return this;
	}
	public DepartmentTokens excludeColumnsOfDoctorScheduleList(String[] columns){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  DepartmentTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfDoctorAssignmentList(verb, value);	
		searchAllTextOfDoctorScheduleList(verb, value);	
		return this;
	}
}

