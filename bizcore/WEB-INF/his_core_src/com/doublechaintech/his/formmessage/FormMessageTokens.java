
package com.doublechaintech.his.formmessage;
import com.doublechaintech.his.CommonTokens;
import java.util.Map;
public class FormMessageTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="formMessage";
	
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
	protected FormMessageTokens(){
		//ensure not initialized outside the class
	}
	public  static  FormMessageTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		FormMessageTokens tokens = new FormMessageTokens(options);
		return tokens;
		
	}
	protected FormMessageTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public FormMessageTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static FormMessageTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected FormMessageTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static FormMessageTokens start(){
		return new FormMessageTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static FormMessageTokens allTokens(){
		
		return start()
			.withForm();
	
	}
	public static FormMessageTokens withoutListsTokens(){
		
		return start()
			.withForm();
	
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
	
	public FormMessageTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String FORM = "form";
	public String getForm(){
		return FORM;
	}
	public FormMessageTokens withForm(){		
		addSimpleOptions(FORM);
		return this;
	}
	
	
	
	public  FormMessageTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

