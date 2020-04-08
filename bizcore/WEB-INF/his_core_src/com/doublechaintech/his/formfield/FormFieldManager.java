
package com.doublechaintech.his.formfield;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface FormFieldManager extends BaseManager{

		

	public FormField createFormField(HisUserContext userContext, String label,String localeKey,String parameterName,String type,String formId,String placeholder,String defaultValue,String description,String fieldGroup,String minimumValue,String maximumValue,boolean required,boolean disabled,boolean customRendering,String candidateValues,String suggestValues) throws Exception;
	public FormField updateFormField(HisUserContext userContext,String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormField loadFormField(HisUserContext userContext, String formFieldId, String [] tokensExpr) throws Exception;
	public FormField internalSaveFormField(HisUserContext userContext, FormField formField) throws Exception;
	public FormField internalSaveFormField(HisUserContext userContext, FormField formField,Map<String,Object>option) throws Exception;

	public FormField transferToAnotherForm(HisUserContext userContext, String formFieldId, String anotherFormId)  throws Exception;
 

	public void delete(HisUserContext userContext, String formFieldId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, FormField newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByForm(HisUserContext userContext,String formId) throws Exception;
	public Object listPageByForm(HisUserContext userContext,String formId, int start, int count) throws Exception;
  

}


