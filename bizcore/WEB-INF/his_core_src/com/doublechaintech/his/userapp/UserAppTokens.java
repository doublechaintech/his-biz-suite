
package com.doublechaintech.his.userapp;
import com.doublechaintech.his.CommonTokens;
import java.util.Map;
public class UserAppTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="userApp";
	
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
	protected UserAppTokens(){
		//ensure not initialized outside the class
	}
	public  static  UserAppTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		UserAppTokens tokens = new UserAppTokens(options);
		return tokens;
		
	}
	protected UserAppTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public UserAppTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static UserAppTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected UserAppTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static UserAppTokens start(){
		return new UserAppTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static UserAppTokens allTokens(){
		
		return start()
			.withSecUser()
			.withListAccessList()
			.withObjectAccessList();
	
	}
	public static UserAppTokens withoutListsTokens(){
		
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
	
	public UserAppTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String SECUSER = "secUser";
	public String getSecUser(){
		return SECUSER;
	}
	public UserAppTokens withSecUser(){		
		addSimpleOptions(SECUSER);
		return this;
	}
	
	
	protected static final String LIST_ACCESS_LIST = "listAccessList";
	public String getListAccessList(){
		return LIST_ACCESS_LIST;
	}
	public UserAppTokens withListAccessList(){		
		addSimpleOptions(LIST_ACCESS_LIST);
		return this;
	}
	public UserAppTokens analyzeListAccessList(){		
		addSimpleOptions(LIST_ACCESS_LIST+".anaylze");
		return this;
	}
	public boolean analyzeListAccessListEnabled(){		
		
		if(checkOptions(this.options(), LIST_ACCESS_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public UserAppTokens extractMoreFromListAccessList(String idsSeperatedWithComma){		
		addSimpleOptions(LIST_ACCESS_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int listAccessListSortCounter = 0;
	public UserAppTokens sortListAccessListWith(String field, String descOrAsc){		
		addSortMoreOptions(LIST_ACCESS_LIST,listAccessListSortCounter++, field, descOrAsc);
		return this;
	}
	private int listAccessListSearchCounter = 0;
	public UserAppTokens searchListAccessListWith(String field, String verb, String value){		
		addSearchMoreOptions(LIST_ACCESS_LIST,listAccessListSearchCounter++, field, verb, value);
		return this;
	}
	
	public UserAppTokens searchAllTextOfListAccessList(String verb, String value){	
		String field = "id|name|internalName";
		addSearchMoreOptions(LIST_ACCESS_LIST,listAccessListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public UserAppTokens rowsPerPageOfListAccessList(int rowsPerPage){		
		addSimpleOptions(LIST_ACCESS_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public UserAppTokens currentPageNumberOfListAccessList(int currentPageNumber){		
		addSimpleOptions(LIST_ACCESS_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public UserAppTokens retainColumnsOfListAccessList(String[] columns){		
		addSimpleOptions(LIST_ACCESS_LIST+"RetainColumns",columns);
		return this;
	}
	public UserAppTokens excludeColumnsOfListAccessList(String[] columns){		
		addSimpleOptions(LIST_ACCESS_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String OBJECT_ACCESS_LIST = "objectAccessList";
	public String getObjectAccessList(){
		return OBJECT_ACCESS_LIST;
	}
	public UserAppTokens withObjectAccessList(){		
		addSimpleOptions(OBJECT_ACCESS_LIST);
		return this;
	}
	public UserAppTokens analyzeObjectAccessList(){		
		addSimpleOptions(OBJECT_ACCESS_LIST+".anaylze");
		return this;
	}
	public boolean analyzeObjectAccessListEnabled(){		
		
		if(checkOptions(this.options(), OBJECT_ACCESS_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public UserAppTokens extractMoreFromObjectAccessList(String idsSeperatedWithComma){		
		addSimpleOptions(OBJECT_ACCESS_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int objectAccessListSortCounter = 0;
	public UserAppTokens sortObjectAccessListWith(String field, String descOrAsc){		
		addSortMoreOptions(OBJECT_ACCESS_LIST,objectAccessListSortCounter++, field, descOrAsc);
		return this;
	}
	private int objectAccessListSearchCounter = 0;
	public UserAppTokens searchObjectAccessListWith(String field, String verb, String value){		
		addSearchMoreOptions(OBJECT_ACCESS_LIST,objectAccessListSearchCounter++, field, verb, value);
		return this;
	}
	
	public UserAppTokens searchAllTextOfObjectAccessList(String verb, String value){	
		String field = "id|name|objectType|list1|list2|list3|list4|list5|list6|list7|list8|list9";
		addSearchMoreOptions(OBJECT_ACCESS_LIST,objectAccessListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public UserAppTokens rowsPerPageOfObjectAccessList(int rowsPerPage){		
		addSimpleOptions(OBJECT_ACCESS_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public UserAppTokens currentPageNumberOfObjectAccessList(int currentPageNumber){		
		addSimpleOptions(OBJECT_ACCESS_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public UserAppTokens retainColumnsOfObjectAccessList(String[] columns){		
		addSimpleOptions(OBJECT_ACCESS_LIST+"RetainColumns",columns);
		return this;
	}
	public UserAppTokens excludeColumnsOfObjectAccessList(String[] columns){		
		addSimpleOptions(OBJECT_ACCESS_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  UserAppTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfListAccessList(verb, value);	
		searchAllTextOfObjectAccessList(verb, value);	
		return this;
	}
}

