
package com.doublechaintech.his.formaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface FormActionManager extends BaseManager{

		

	public FormAction createFormAction(HisUserContext userContext, String label,String localeKey,String actionKey,String level,String url,String formId) throws Exception;
	public FormAction updateFormAction(HisUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormAction loadFormAction(HisUserContext userContext, String formActionId, String [] tokensExpr) throws Exception;
	public FormAction internalSaveFormAction(HisUserContext userContext, FormAction formAction) throws Exception;
	public FormAction internalSaveFormAction(HisUserContext userContext, FormAction formAction,Map<String,Object>option) throws Exception;

	public FormAction transferToAnotherForm(HisUserContext userContext, String formActionId, String anotherFormId)  throws Exception;
 

	public void delete(HisUserContext userContext, String formActionId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, FormAction newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByForm(HisUserContext userContext,String formId) throws Exception;
	public Object listPageByForm(HisUserContext userContext,String formId, int start, int count) throws Exception;
  

}


