
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
			.withPlatform();
	
	}
	public static DoctorTokens withoutListsTokens(){
		
		return start()
			.withPlatform();
	
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

	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public DoctorTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	
	public  DoctorTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

