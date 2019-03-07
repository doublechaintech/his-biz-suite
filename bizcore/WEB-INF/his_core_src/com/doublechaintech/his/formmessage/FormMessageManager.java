
package com.doublechaintech.his.formmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;

public interface FormMessageManager{

		

	public FormMessage createFormMessage(HisUserContext userContext, String title, String formId, String level) throws Exception;	
	public FormMessage updateFormMessage(HisUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormMessage loadFormMessage(HisUserContext userContext, String formMessageId, String [] tokensExpr) throws Exception;
	public FormMessage internalSaveFormMessage(HisUserContext userContext, FormMessage formMessage) throws Exception;
	public FormMessage internalSaveFormMessage(HisUserContext userContext, FormMessage formMessage,Map<String,Object>option) throws Exception;
	
	public FormMessage transferToAnotherForm(HisUserContext userContext, String formMessageId, String anotherFormId)  throws Exception;
 

	public void delete(HisUserContext userContext, String formMessageId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, FormMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


