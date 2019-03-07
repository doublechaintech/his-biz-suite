
package com.doublechaintech.his.doctor;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;

public interface DoctorManager{

		

	public Doctor createDoctor(HisUserContext userContext, String name, String platformId) throws Exception;	
	public Doctor updateDoctor(HisUserContext userContext,String doctorId, int doctorVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Doctor loadDoctor(HisUserContext userContext, String doctorId, String [] tokensExpr) throws Exception;
	public Doctor internalSaveDoctor(HisUserContext userContext, Doctor doctor) throws Exception;
	public Doctor internalSaveDoctor(HisUserContext userContext, Doctor doctor,Map<String,Object>option) throws Exception;
	
	public Doctor transferToAnotherPlatform(HisUserContext userContext, String doctorId, String anotherPlatformId)  throws Exception;
 

	public void delete(HisUserContext userContext, String doctorId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, Doctor newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


