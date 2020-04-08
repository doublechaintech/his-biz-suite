
package com.doublechaintech.his.period;
import com.doublechaintech.his.CommonTokens;
import java.util.Map;
public class PeriodTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="period";
	
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
	protected PeriodTokens(){
		//ensure not initialized outside the class
	}
	public  static  PeriodTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		PeriodTokens tokens = new PeriodTokens(options);
		return tokens;
		
	}
	protected PeriodTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public PeriodTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static PeriodTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected PeriodTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static PeriodTokens start(){
		return new PeriodTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static PeriodTokens allTokens(){
		
		return start()
			.withHospital()
			.withDoctorScheduleList();
	
	}
	public static PeriodTokens withoutListsTokens(){
		
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
	
	public PeriodTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String HOSPITAL = "hospital";
	public String getHospital(){
		return HOSPITAL;
	}
	public PeriodTokens withHospital(){		
		addSimpleOptions(HOSPITAL);
		return this;
	}
	
	
	protected static final String DOCTOR_SCHEDULE_LIST = "doctorScheduleList";
	public String getDoctorScheduleList(){
		return DOCTOR_SCHEDULE_LIST;
	}
	public PeriodTokens withDoctorScheduleList(){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST);
		return this;
	}
	public PeriodTokens analyzeDoctorScheduleList(){		
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
	public PeriodTokens extractMoreFromDoctorScheduleList(String idsSeperatedWithComma){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int doctorScheduleListSortCounter = 0;
	public PeriodTokens sortDoctorScheduleListWith(String field, String descOrAsc){		
		addSortMoreOptions(DOCTOR_SCHEDULE_LIST,doctorScheduleListSortCounter++, field, descOrAsc);
		return this;
	}
	private int doctorScheduleListSearchCounter = 0;
	public PeriodTokens searchDoctorScheduleListWith(String field, String verb, String value){		
		
		withDoctorScheduleList();
		addSearchMoreOptions(DOCTOR_SCHEDULE_LIST,doctorScheduleListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PeriodTokens searchAllTextOfDoctorScheduleList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(DOCTOR_SCHEDULE_LIST,doctorScheduleListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PeriodTokens rowsPerPageOfDoctorScheduleList(int rowsPerPage){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PeriodTokens currentPageNumberOfDoctorScheduleList(int currentPageNumber){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PeriodTokens retainColumnsOfDoctorScheduleList(String[] columns){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"RetainColumns",columns);
		return this;
	}
	public PeriodTokens excludeColumnsOfDoctorScheduleList(String[] columns){		
		addSimpleOptions(DOCTOR_SCHEDULE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  PeriodTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfDoctorScheduleList(verb, value);	
		return this;
	}
}

