
package com.doublechaintech.his.genericform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface GenericFormManager extends BaseManager{

		

	public GenericForm createGenericForm(HisUserContext userContext, String title,String description) throws Exception;
	public GenericForm updateGenericForm(HisUserContext userContext,String genericFormId, int genericFormVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public GenericForm loadGenericForm(HisUserContext userContext, String genericFormId, String [] tokensExpr) throws Exception;
	public GenericForm internalSaveGenericForm(HisUserContext userContext, GenericForm genericForm) throws Exception;
	public GenericForm internalSaveGenericForm(HisUserContext userContext, GenericForm genericForm,Map<String,Object>option) throws Exception;



	public void delete(HisUserContext userContext, String genericFormId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, GenericForm newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  FormMessageManager getFormMessageManager(HisUserContext userContext, String genericFormId, String title, String level ,String [] tokensExpr)  throws Exception;

	public  GenericForm addFormMessage(HisUserContext userContext, String genericFormId, String title, String level , String [] tokensExpr)  throws Exception;
	public  GenericForm removeFormMessage(HisUserContext userContext, String genericFormId, String formMessageId, int formMessageVersion,String [] tokensExpr)  throws Exception;
	public  GenericForm updateFormMessage(HisUserContext userContext, String genericFormId, String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  FormFieldMessageManager getFormFieldMessageManager(HisUserContext userContext, String genericFormId, String title, String parameterName, String level ,String [] tokensExpr)  throws Exception;

	public  GenericForm addFormFieldMessage(HisUserContext userContext, String genericFormId, String title, String parameterName, String level , String [] tokensExpr)  throws Exception;
	public  GenericForm removeFormFieldMessage(HisUserContext userContext, String genericFormId, String formFieldMessageId, int formFieldMessageVersion,String [] tokensExpr)  throws Exception;
	public  GenericForm updateFormFieldMessage(HisUserContext userContext, String genericFormId, String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  FormFieldManager getFormFieldManager(HisUserContext userContext, String genericFormId, String label, String localeKey, String parameterName, String type, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues ,String [] tokensExpr)  throws Exception;

	public  GenericForm addFormField(HisUserContext userContext, String genericFormId, String label, String localeKey, String parameterName, String type, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues , String [] tokensExpr)  throws Exception;
	public  GenericForm removeFormField(HisUserContext userContext, String genericFormId, String formFieldId, int formFieldVersion,String [] tokensExpr)  throws Exception;
	public  GenericForm updateFormField(HisUserContext userContext, String genericFormId, String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  FormActionManager getFormActionManager(HisUserContext userContext, String genericFormId, String label, String localeKey, String actionKey, String level, String url ,String [] tokensExpr)  throws Exception;

	public  GenericForm addFormAction(HisUserContext userContext, String genericFormId, String label, String localeKey, String actionKey, String level, String url , String [] tokensExpr)  throws Exception;
	public  GenericForm removeFormAction(HisUserContext userContext, String genericFormId, String formActionId, int formActionVersion,String [] tokensExpr)  throws Exception;
	public  GenericForm updateFormAction(HisUserContext userContext, String genericFormId, String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


