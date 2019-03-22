
package com.doublechaintech.his.doctor;
import com.doublechaintech.his.CommonTokens;
import java.util.Map;
public class DoctorTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="doctor";
	
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
	protected DoctorTokens(){
		//ensure not initialized outside the class
	}
	public  static  DoctorTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		DoctorTokens tokens = new DoctorTokens(options);
		return tokens;
		
	}
	protected DoctorTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public DoctorTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static DoctorTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected DoctorTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static DoctorTokens start(){
		return new DoctorTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static DoctorTokens allTokens(){
		
		return start()
			.withHospital()
			.withDoctorAssignmentList()
			.withDoctorScheduleList();
	
	}
	public static DoctorTokens withoutListsTokens(){
		
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
	
	public DoctorTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String HOSPITAL = "hospital";
	public String getHospital(){
		return HOSPITAL;
	}
	public DoctorTokens withHospital(){		
		addSimpleOptions(HOSPITAL);
		return this;
	}
	
	
	protected static final String DOCTOR_ASSIGNMENT_LIST = "doctorAssignmentList";
	public String getDoctorAssignmentList(){
		return DOCTOR_ASSIGNMENT_LIST;
	}
	public DoctorTokens withDoctorAssignmentList(){		
		addSimpleOptions(DOCTOR_ASSIGNMENT_LIST);
		return this;
	}
	public DoctorTokens analyzeDoctorAssignmentList(){		
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
	public DoctorTokens extractMoreFromDoctorAssignmentList(String idsSeperatedWithComma){		
		addSimpleOptions(DOCTOR_ASSIGNMENT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int doctorAssignmentListSortCounter = 0;
	public DoctorTokens sortDoctorAssignmentListWith(String field, String descOrAsc){		
		addSortMoreOptions(DOCTOR_ASSIGNMENT_LIST,doctorAssignmentListSortCounter++, field, descOrAsc);
		return this;
	}
	private int doctorAssignmentListSearchCounter = 0;
	public DoctorTokens searchDoctorAssignmentListWith(String field, String verb, String value){		
		addSearchMoreOptions(DOCTOR_ASSIGNMENT_LIST,doctorAssignmentListSearchCounter++, field, verb, value);
		return this;
	}
	
	public DoctorTokens searchAllTextOfDoctorAssignmentList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(DOCTOR_ASSIGNMENT_LIST,doctorAssignmentListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public DoctorTokens rowsPerPageOfDoctorAssignmentList(int rowsPerPage){		
		addSimpleOptions(DOCTOR_ASSIGNMENT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public DoctorTokens currentPageNumberOfDoctorAssignmentList(int currentPageNumber){		
		addSimpleOptions(DOCTOR_ASSIGNMENT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public DoctorTokens retainColumnsOfDoctorAssignmentList(String[] columns){		
		addSimpleOptions(DOCTOR_ASSIGNMENT_LIST+"RetainColumns",columns);
		return this;
	}
	public DoctorTokens excludeColumnsOfDoctorAssignmentList(String[] columns){		
		addSimpleOptions(DOCTOR_ASSIGNMENT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String DOCTOR_SCHEDULE_LIST = "doctorScheduleList";
	public String getDoctorScheduleList(){
		return DOCTOR_SCHEDULE_LIST;
	}
	public DoctorTokens withDoctorScheduleList(){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST);
		return this;
	}
	public DoctorTokens analyzeDoctorScheduleList(){		
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
	public DoctorTokens extractMoreFromDoctorScheduleList(String idsSeperatedWithComma){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int doctorScheduleListSortCounter = 0;
	public DoctorTokens sortDoctorScheduleListWith(String field, String descOrAsc){		
		addSortMoreOptions(DOCTOR_SCHEDULE_LIST,doctorScheduleListSortCounter++, field, descOrAsc);
		return this;
	}
	private int doctorScheduleListSearchCounter = 0;
	public DoctorTokens searchDoctorScheduleListWith(String field, String verb, String value){		
		addSearchMoreOptions(DOCTOR_SCHEDULE_LIST,doctorScheduleListSearchCounter++, field, verb, value);
		return this;
	}
	
	public DoctorTokens searchAllTextOfDoctorScheduleList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(DOCTOR_SCHEDULE_LIST,doctorScheduleListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public DoctorTokens rowsPerPageOfDoctorScheduleList(int rowsPerPage){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public DoctorTokens currentPageNumberOfDoctorScheduleList(int currentPageNumber){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public DoctorTokens retainColumnsOfDoctorScheduleList(String[] columns){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"RetainColumns",columns);
		return this;
	}
	public DoctorTokens excludeColumnsOfDoctorScheduleList(String[] columns){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  DoctorTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfDoctorAssignmentList(verb, value);	
		searchAllTextOfDoctorScheduleList(verb, value);	
		return this;
	}
}

