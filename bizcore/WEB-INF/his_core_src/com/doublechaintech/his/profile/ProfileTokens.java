
package com.doublechaintech.his.profile;
import com.doublechaintech.his.CommonTokens;
import java.util.Map;
public class ProfileTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="profile";
	
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
	protected ProfileTokens(){
		//ensure not initialized outside the class
	}
	public  static  ProfileTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ProfileTokens tokens = new ProfileTokens(options);
		return tokens;
		
	}
	protected ProfileTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ProfileTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ProfileTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ProfileTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ProfileTokens start(){
		return new ProfileTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ProfileTokens allTokens(){
		
		return start()
			.withPlatform()
			.withRegistrationListAsPatient()
			.withRegistrationListAsRegister();
	
	}
	public static ProfileTokens withoutListsTokens(){
		
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
	
	public ProfileTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public ProfileTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String REGISTRATION_LIST_AS_PATIENT = "registrationListAsPatient";
	public String getRegistrationListAsPatient(){
		return REGISTRATION_LIST_AS_PATIENT;
	}
	public ProfileTokens withRegistrationListAsPatient(){		
		addSimpleOptions(REGISTRATION_LIST_AS_PATIENT);
		return this;
	}
	public ProfileTokens analyzeRegistrationListAsPatient(){		
		addSimpleOptions(REGISTRATION_LIST_AS_PATIENT+".anaylze");
		return this;
	}
	public boolean analyzeRegistrationListAsPatientEnabled(){		
		
		if(checkOptions(this.options(), REGISTRATION_LIST_AS_PATIENT+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public ProfileTokens extractMoreFromRegistrationListAsPatient(String idsSeperatedWithComma){		
		addSimpleOptions(REGISTRATION_LIST_AS_PATIENT+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int registrationListAsPatientSortCounter = 0;
	public ProfileTokens sortRegistrationListAsPatientWith(String field, String descOrAsc){		
		addSortMoreOptions(REGISTRATION_LIST_AS_PATIENT,registrationListAsPatientSortCounter++, field, descOrAsc);
		return this;
	}
	private int registrationListAsPatientSearchCounter = 0;
	public ProfileTokens searchRegistrationListAsPatientWith(String field, String verb, String value){		
		addSearchMoreOptions(REGISTRATION_LIST_AS_PATIENT,registrationListAsPatientSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProfileTokens searchAllTextOfRegistrationListAsPatient(String verb, String value){	
		String field = "id|title|content|status";
		addSearchMoreOptions(REGISTRATION_LIST_AS_PATIENT,registrationListAsPatientSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProfileTokens rowsPerPageOfRegistrationListAsPatient(int rowsPerPage){		
		addSimpleOptions(REGISTRATION_LIST_AS_PATIENT+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProfileTokens currentPageNumberOfRegistrationListAsPatient(int currentPageNumber){		
		addSimpleOptions(REGISTRATION_LIST_AS_PATIENT+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProfileTokens retainColumnsOfRegistrationListAsPatient(String[] columns){		
		addSimpleOptions(REGISTRATION_LIST_AS_PATIENT+"RetainColumns",columns);
		return this;
	}
	public ProfileTokens excludeColumnsOfRegistrationListAsPatient(String[] columns){		
		addSimpleOptions(REGISTRATION_LIST_AS_PATIENT+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String REGISTRATION_LIST_AS_REGISTER = "registrationListAsRegister";
	public String getRegistrationListAsRegister(){
		return REGISTRATION_LIST_AS_REGISTER;
	}
	public ProfileTokens withRegistrationListAsRegister(){		
		addSimpleOptions(REGISTRATION_LIST_AS_REGISTER);
		return this;
	}
	public ProfileTokens analyzeRegistrationListAsRegister(){		
		addSimpleOptions(REGISTRATION_LIST_AS_REGISTER+".anaylze");
		return this;
	}
	public boolean analyzeRegistrationListAsRegisterEnabled(){		
		
		if(checkOptions(this.options(), REGISTRATION_LIST_AS_REGISTER+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public ProfileTokens extractMoreFromRegistrationListAsRegister(String idsSeperatedWithComma){		
		addSimpleOptions(REGISTRATION_LIST_AS_REGISTER+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int registrationListAsRegisterSortCounter = 0;
	public ProfileTokens sortRegistrationListAsRegisterWith(String field, String descOrAsc){		
		addSortMoreOptions(REGISTRATION_LIST_AS_REGISTER,registrationListAsRegisterSortCounter++, field, descOrAsc);
		return this;
	}
	private int registrationListAsRegisterSearchCounter = 0;
	public ProfileTokens searchRegistrationListAsRegisterWith(String field, String verb, String value){		
		addSearchMoreOptions(REGISTRATION_LIST_AS_REGISTER,registrationListAsRegisterSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProfileTokens searchAllTextOfRegistrationListAsRegister(String verb, String value){	
		String field = "id|title|content|status";
		addSearchMoreOptions(REGISTRATION_LIST_AS_REGISTER,registrationListAsRegisterSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProfileTokens rowsPerPageOfRegistrationListAsRegister(int rowsPerPage){		
		addSimpleOptions(REGISTRATION_LIST_AS_REGISTER+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProfileTokens currentPageNumberOfRegistrationListAsRegister(int currentPageNumber){		
		addSimpleOptions(REGISTRATION_LIST_AS_REGISTER+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProfileTokens retainColumnsOfRegistrationListAsRegister(String[] columns){		
		addSimpleOptions(REGISTRATION_LIST_AS_REGISTER+"RetainColumns",columns);
		return this;
	}
	public ProfileTokens excludeColumnsOfRegistrationListAsRegister(String[] columns){		
		addSimpleOptions(REGISTRATION_LIST_AS_REGISTER+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ProfileTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfRegistrationListAsPatient(verb, value);	
		searchAllTextOfRegistrationListAsRegister(verb, value);	
		return this;
	}
}

