
package com.doublechaintech.his.platform;
import com.doublechaintech.his.CommonTokens;
import java.util.Map;
public class PlatformTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="platform";
	
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
	protected PlatformTokens(){
		//ensure not initialized outside the class
	}
	public  static  PlatformTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		PlatformTokens tokens = new PlatformTokens(options);
		return tokens;
		
	}
	protected PlatformTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public PlatformTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static PlatformTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected PlatformTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static PlatformTokens start(){
		return new PlatformTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static PlatformTokens allTokens(){
		
		return start()
			.withDoctorList()
			.withProfileList()
			.withRegistrationList();
	
	}
	public static PlatformTokens withoutListsTokens(){
		
		return start();
	
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
	
	public PlatformTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String DOCTOR_LIST = "doctorList";
	public String getDoctorList(){
		return DOCTOR_LIST;
	}
	public PlatformTokens withDoctorList(){		
		addSimpleOptions(DOCTOR_LIST);
		return this;
	}
	public PlatformTokens analyzeDoctorList(){		
		addSimpleOptions(DOCTOR_LIST+".anaylze");
		return this;
	}
	public boolean analyzeDoctorListEnabled(){		
		
		if(checkOptions(this.options(), DOCTOR_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PlatformTokens extractMoreFromDoctorList(String idsSeperatedWithComma){		
		addSimpleOptions(DOCTOR_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int doctorListSortCounter = 0;
	public PlatformTokens sortDoctorListWith(String field, String descOrAsc){		
		addSortMoreOptions(DOCTOR_LIST,doctorListSortCounter++, field, descOrAsc);
		return this;
	}
	private int doctorListSearchCounter = 0;
	public PlatformTokens searchDoctorListWith(String field, String verb, String value){		
		addSearchMoreOptions(DOCTOR_LIST,doctorListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfDoctorList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(DOCTOR_LIST,doctorListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfDoctorList(int rowsPerPage){		
		addSimpleOptions(DOCTOR_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfDoctorList(int currentPageNumber){		
		addSimpleOptions(DOCTOR_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfDoctorList(String[] columns){		
		addSimpleOptions(DOCTOR_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfDoctorList(String[] columns){		
		addSimpleOptions(DOCTOR_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String PROFILE_LIST = "profileList";
	public String getProfileList(){
		return PROFILE_LIST;
	}
	public PlatformTokens withProfileList(){		
		addSimpleOptions(PROFILE_LIST);
		return this;
	}
	public PlatformTokens analyzeProfileList(){		
		addSimpleOptions(PROFILE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeProfileListEnabled(){		
		
		if(checkOptions(this.options(), PROFILE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PlatformTokens extractMoreFromProfileList(String idsSeperatedWithComma){		
		addSimpleOptions(PROFILE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int profileListSortCounter = 0;
	public PlatformTokens sortProfileListWith(String field, String descOrAsc){		
		addSortMoreOptions(PROFILE_LIST,profileListSortCounter++, field, descOrAsc);
		return this;
	}
	private int profileListSearchCounter = 0;
	public PlatformTokens searchProfileListWith(String field, String verb, String value){		
		addSearchMoreOptions(PROFILE_LIST,profileListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfProfileList(String verb, String value){	
		String field = "id|name|gender|identificationNumber|mobile";
		addSearchMoreOptions(PROFILE_LIST,profileListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfProfileList(int rowsPerPage){		
		addSimpleOptions(PROFILE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfProfileList(int currentPageNumber){		
		addSimpleOptions(PROFILE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfProfileList(String[] columns){		
		addSimpleOptions(PROFILE_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfProfileList(String[] columns){		
		addSimpleOptions(PROFILE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String REGISTRATION_LIST = "registrationList";
	public String getRegistrationList(){
		return REGISTRATION_LIST;
	}
	public PlatformTokens withRegistrationList(){		
		addSimpleOptions(REGISTRATION_LIST);
		return this;
	}
	public PlatformTokens analyzeRegistrationList(){		
		addSimpleOptions(REGISTRATION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRegistrationListEnabled(){		
		
		if(checkOptions(this.options(), REGISTRATION_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PlatformTokens extractMoreFromRegistrationList(String idsSeperatedWithComma){		
		addSimpleOptions(REGISTRATION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int registrationListSortCounter = 0;
	public PlatformTokens sortRegistrationListWith(String field, String descOrAsc){		
		addSortMoreOptions(REGISTRATION_LIST,registrationListSortCounter++, field, descOrAsc);
		return this;
	}
	private int registrationListSearchCounter = 0;
	public PlatformTokens searchRegistrationListWith(String field, String verb, String value){		
		addSearchMoreOptions(REGISTRATION_LIST,registrationListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfRegistrationList(String verb, String value){	
		String field = "id|title|content|status";
		addSearchMoreOptions(REGISTRATION_LIST,registrationListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfRegistrationList(int rowsPerPage){		
		addSimpleOptions(REGISTRATION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfRegistrationList(int currentPageNumber){		
		addSimpleOptions(REGISTRATION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfRegistrationList(String[] columns){		
		addSimpleOptions(REGISTRATION_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfRegistrationList(String[] columns){		
		addSimpleOptions(REGISTRATION_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  PlatformTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfDoctorList(verb, value);	
		searchAllTextOfProfileList(verb, value);	
		searchAllTextOfRegistrationList(verb, value);	
		return this;
	}
}

