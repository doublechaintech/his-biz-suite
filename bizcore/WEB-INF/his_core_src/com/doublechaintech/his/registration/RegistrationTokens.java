
package com.doublechaintech.his.registration;
import com.doublechaintech.his.CommonTokens;
import java.util.Map;
public class RegistrationTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="registration";
	
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
	protected RegistrationTokens(){
		//ensure not initialized outside the class
	}
	public  static  RegistrationTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		RegistrationTokens tokens = new RegistrationTokens(options);
		return tokens;
		
	}
	protected RegistrationTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public RegistrationTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static RegistrationTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected RegistrationTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static RegistrationTokens start(){
		return new RegistrationTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static RegistrationTokens allTokens(){
		
		return start()
			.withPatient()
			.withRegister()
			.withPlatform();
	
	}
	public static RegistrationTokens withoutListsTokens(){
		
		return start()
			.withPatient()
			.withRegister()
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
	
	public RegistrationTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String PATIENT = "patient";
	public String getPatient(){
		return PATIENT;
	}
	public RegistrationTokens withPatient(){		
		addSimpleOptions(PATIENT);
		return this;
	}
	
	
	protected static final String REGISTER = "register";
	public String getRegister(){
		return REGISTER;
	}
	public RegistrationTokens withRegister(){		
		addSimpleOptions(REGISTER);
		return this;
	}
	
	
	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public RegistrationTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	
	public  RegistrationTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

