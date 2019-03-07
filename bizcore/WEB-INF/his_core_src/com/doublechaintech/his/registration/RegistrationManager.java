
package com.doublechaintech.his.registration;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;

public interface RegistrationManager{

		

	public Registration createRegistration(HisUserContext userContext, String title, String patientId, String registerId, String content, String status, String platformId) throws Exception;	
	public Registration updateRegistration(HisUserContext userContext,String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Registration loadRegistration(HisUserContext userContext, String registrationId, String [] tokensExpr) throws Exception;
	public Registration internalSaveRegistration(HisUserContext userContext, Registration registration) throws Exception;
	public Registration internalSaveRegistration(HisUserContext userContext, Registration registration,Map<String,Object>option) throws Exception;
	
	public Registration transferToAnotherPatient(HisUserContext userContext, String registrationId, String anotherPatientId)  throws Exception;
 	public Registration transferToAnotherRegister(HisUserContext userContext, String registrationId, String anotherRegisterId)  throws Exception;
 	public Registration transferToAnotherPlatform(HisUserContext userContext, String registrationId, String anotherPlatformId)  throws Exception;
 

	public void delete(HisUserContext userContext, String registrationId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, Registration newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


