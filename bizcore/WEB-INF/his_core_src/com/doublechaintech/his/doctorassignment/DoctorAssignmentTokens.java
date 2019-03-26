
package com.doublechaintech.his.doctorassignment;
import com.doublechaintech.his.CommonTokens;
import java.util.Map;
public class DoctorAssignmentTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="doctorAssignment";
	
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
	protected DoctorAssignmentTokens(){
		//ensure not initialized outside the class
	}
	public  static  DoctorAssignmentTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		DoctorAssignmentTokens tokens = new DoctorAssignmentTokens(options);
		return tokens;
		
	}
	protected DoctorAssignmentTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public DoctorAssignmentTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static DoctorAssignmentTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected DoctorAssignmentTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static DoctorAssignmentTokens start(){
		return new DoctorAssignmentTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static DoctorAssignmentTokens allTokens(){
		
		return start()
			.withDoctor()
			.withDepartment();
	
	}
	public static DoctorAssignmentTokens withoutListsTokens(){
		
		return start()
			.withDoctor()
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
	
	public DoctorAssignmentTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String DOCTOR = "doctor";
	public String getDoctor(){
		return DOCTOR;
	}
	public DoctorAssignmentTokens withDoctor(){		
		addSimpleOptions(DOCTOR);
		return this;
	}
	
	
	protected static final String DEPARTMENT = "department";
	public String getDepartment(){
		return DEPARTMENT;
	}
	public DoctorAssignmentTokens withDepartment(){		
		addSimpleOptions(DEPARTMENT);
		return this;
	}
	
	
	
	public  DoctorAssignmentTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

