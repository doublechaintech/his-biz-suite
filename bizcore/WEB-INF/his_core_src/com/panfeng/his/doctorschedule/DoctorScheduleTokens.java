
package com.panfeng.his.doctorschedule;
import com.panfeng.his.CommonTokens;
import java.util.Map;
public class DoctorScheduleTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="doctorSchedule";
	
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
	protected DoctorScheduleTokens(){
		//ensure not initialized outside the class
	}
	public  static  DoctorScheduleTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		DoctorScheduleTokens tokens = new DoctorScheduleTokens(options);
		return tokens;
		
	}
	protected DoctorScheduleTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public DoctorScheduleTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static DoctorScheduleTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected DoctorScheduleTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static DoctorScheduleTokens start(){
		return new DoctorScheduleTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static DoctorScheduleTokens allTokens(){
		
		return start()
			.withDoctor()
			.withExpenseType()
			.withDepartment();
	
	}
	public static DoctorScheduleTokens withoutListsTokens(){
		
		return start()
			.withDoctor()
			.withExpenseType()
			.withDepartment();
	
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
	
	public DoctorScheduleTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String DOCTOR = "doctor";
	public String getDoctor(){
		return DOCTOR;
	}
	public DoctorScheduleTokens withDoctor(){		
		addSimpleOptions(DOCTOR);
		return this;
	}
	
	
	protected static final String EXPENSETYPE = "expenseType";
	public String getExpenseType(){
		return EXPENSETYPE;
	}
	public DoctorScheduleTokens withExpenseType(){		
		addSimpleOptions(EXPENSETYPE);
		return this;
	}
	
	
	protected static final String DEPARTMENT = "department";
	public String getDepartment(){
		return DEPARTMENT;
	}
	public DoctorScheduleTokens withDepartment(){		
		addSimpleOptions(DEPARTMENT);
		return this;
	}
	
	
	
	public  DoctorScheduleTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

