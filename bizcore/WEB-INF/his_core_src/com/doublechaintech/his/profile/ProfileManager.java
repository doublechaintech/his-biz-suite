
package com.doublechaintech.his.profile;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;

public interface ProfileManager{

		

	public Profile createProfile(HisUserContext userContext, String name, String gender, int age, String identificationNumber, String mobile, String platformId) throws Exception;	
	public Profile updateProfile(HisUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Profile loadProfile(HisUserContext userContext, String profileId, String [] tokensExpr) throws Exception;
	public Profile internalSaveProfile(HisUserContext userContext, Profile profile) throws Exception;
	public Profile internalSaveProfile(HisUserContext userContext, Profile profile,Map<String,Object>option) throws Exception;
	
	public Profile transferToAnotherPlatform(HisUserContext userContext, String profileId, String anotherPlatformId)  throws Exception;
 

	public void delete(HisUserContext userContext, String profileId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, Profile newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  RegistrationManager getRegistrationManager(HisUserContext userContext, String profileId, String title, String content, String status, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addRegistrationAsPatient(HisUserContext userContext, String profileId, String title, String content, String status, String platformId , String [] tokensExpr)  throws Exception;
	public  Profile removeRegistrationAsPatient(HisUserContext userContext, String profileId, String registrationId, int registrationVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateRegistrationAsPatient(HisUserContext userContext, String profileId, String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RegistrationManager getRegistrationManager(HisUserContext userContext, String profileId, String title, String content, String status, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addRegistrationAsRegister(HisUserContext userContext, String profileId, String title, String content, String status, String platformId , String [] tokensExpr)  throws Exception;
	public  Profile removeRegistrationAsRegister(HisUserContext userContext, String profileId, String registrationId, int registrationVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateRegistrationAsRegister(HisUserContext userContext, String profileId, String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


