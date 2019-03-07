
package com.doublechaintech.his.platform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;

public interface PlatformManager{

		

	public Platform createPlatform(HisUserContext userContext, String name, String introduction, String currentVersion) throws Exception;	
	public Platform updatePlatform(HisUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Platform loadPlatform(HisUserContext userContext, String platformId, String [] tokensExpr) throws Exception;
	public Platform internalSavePlatform(HisUserContext userContext, Platform platform) throws Exception;
	public Platform internalSavePlatform(HisUserContext userContext, Platform platform,Map<String,Object>option) throws Exception;
	


	public void delete(HisUserContext userContext, String platformId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, Platform newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  DoctorManager getDoctorManager(HisUserContext userContext, String platformId, String name ,String [] tokensExpr)  throws Exception;
	
	public  Platform addDoctor(HisUserContext userContext, String platformId, String name , String [] tokensExpr)  throws Exception;
	public  Platform removeDoctor(HisUserContext userContext, String platformId, String doctorId, int doctorVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateDoctor(HisUserContext userContext, String platformId, String doctorId, int doctorVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ProfileManager getProfileManager(HisUserContext userContext, String platformId, String name, String gender, int age, String identificationNumber, String mobile ,String [] tokensExpr)  throws Exception;
	
	public  Platform addProfile(HisUserContext userContext, String platformId, String name, String gender, int age, String identificationNumber, String mobile , String [] tokensExpr)  throws Exception;
	public  Platform removeProfile(HisUserContext userContext, String platformId, String profileId, int profileVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateProfile(HisUserContext userContext, String platformId, String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RegistrationManager getRegistrationManager(HisUserContext userContext, String platformId, String title, String patientId, String registerId, String content, String status ,String [] tokensExpr)  throws Exception;
	
	public  Platform addRegistration(HisUserContext userContext, String platformId, String title, String patientId, String registerId, String content, String status , String [] tokensExpr)  throws Exception;
	public  Platform removeRegistration(HisUserContext userContext, String platformId, String registrationId, int registrationVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateRegistration(HisUserContext userContext, String platformId, String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


