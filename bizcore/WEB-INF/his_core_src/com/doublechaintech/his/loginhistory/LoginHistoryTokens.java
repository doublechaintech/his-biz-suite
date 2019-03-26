
package com.doublechaintech.his.loginhistory;
import com.doublechaintech.his.CommonTokens;
import java.util.Map;
public class LoginHistoryTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="loginHistory";
	
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
	protected LoginHistoryTokens(){
		//ensure not initialized outside the class
	}
	public  static  LoginHistoryTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		LoginHistoryTokens tokens = new LoginHistoryTokens(options);
		return tokens;
		
	}
	protected LoginHistoryTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public LoginHistoryTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static LoginHistoryTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected LoginHistoryTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static LoginHistoryTokens start(){
		return new LoginHistoryTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static LoginHistoryTokens allTokens(){
		
		return start()
			.withSecUser();
	
	}
	public static LoginHistoryTokens withoutListsTokens(){
		
		return start()
			.withSecUser();
	
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
	
	public LoginHistoryTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String SECUSER = "secUser";
	public String getSecUser(){
		return SECUSER;
	}
	public LoginHistoryTokens withSecUser(){		
		addSimpleOptions(SECUSER);
		return this;
	}
	
	
	
	public  LoginHistoryTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

