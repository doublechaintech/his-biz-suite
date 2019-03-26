
package com.doublechaintech.his.formfieldmessage;
import com.doublechaintech.his.CommonTokens;
import java.util.Map;
public class FormFieldMessageTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="formFieldMessage";
	
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
	protected FormFieldMessageTokens(){
		//ensure not initialized outside the class
	}
	public  static  FormFieldMessageTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		FormFieldMessageTokens tokens = new FormFieldMessageTokens(options);
		return tokens;
		
	}
	protected FormFieldMessageTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public FormFieldMessageTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static FormFieldMessageTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected FormFieldMessageTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static FormFieldMessageTokens start(){
		return new FormFieldMessageTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static FormFieldMessageTokens allTokens(){
		
		return start()
			.withForm();
	
	}
	public static FormFieldMessageTokens withoutListsTokens(){
		
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
	
	public FormFieldMessageTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String FORM = "form";
	public String getForm(){
		return FORM;
	}
	public FormFieldMessageTokens withForm(){		
		addSimpleOptions(FORM);
		return this;
	}
	
	
	
	public  FormFieldMessageTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

