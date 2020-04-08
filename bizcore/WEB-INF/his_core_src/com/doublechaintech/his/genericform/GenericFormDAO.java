
package com.doublechaintech.his.genericform;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.his.BaseDAO;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;

import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;
import com.doublechaintech.his.formaction.FormAction;
import com.doublechaintech.his.formmessage.FormMessage;

import com.doublechaintech.his.formmessage.FormMessageDAO;
import com.doublechaintech.his.formfieldmessage.FormFieldMessageDAO;
import com.doublechaintech.his.formfield.FormFieldDAO;
import com.doublechaintech.his.formaction.FormActionDAO;


public interface GenericFormDAO extends BaseDAO{

	public SmartList<GenericForm> loadAll();
	public GenericForm load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<GenericForm> genericFormList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public GenericForm present(GenericForm genericForm,Map<String,Object> options) throws Exception;
	public GenericForm clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public GenericForm save(GenericForm genericForm,Map<String,Object> options);
	public SmartList<GenericForm> saveGenericFormList(SmartList<GenericForm> genericFormList,Map<String,Object> options);
	public SmartList<GenericForm> removeGenericFormList(SmartList<GenericForm> genericFormList,Map<String,Object> options);
	public SmartList<GenericForm> findGenericFormWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countGenericFormWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countGenericFormWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String genericFormId, int version) throws Exception;
	public GenericForm disconnectFromAll(String genericFormId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public FormMessageDAO getFormMessageDAO();
		
	public FormFieldMessageDAO getFormFieldMessageDAO();
		
	public FormFieldDAO getFormFieldDAO();
		
	public FormActionDAO getFormActionDAO();
		
	
 	public SmartList<GenericForm> requestCandidateGenericFormForFormMessage(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<GenericForm> requestCandidateGenericFormForFormFieldMessage(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<GenericForm> requestCandidateGenericFormForFormField(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<GenericForm> requestCandidateGenericFormForFormAction(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public GenericForm planToRemoveFormMessageList(GenericForm genericForm, String formMessageIds[], Map<String,Object> options)throws Exception;


	public GenericForm planToRemoveFormFieldMessageList(GenericForm genericForm, String formFieldMessageIds[], Map<String,Object> options)throws Exception;


	public GenericForm planToRemoveFormFieldList(GenericForm genericForm, String formFieldIds[], Map<String,Object> options)throws Exception;


	public GenericForm planToRemoveFormActionList(GenericForm genericForm, String formActionIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<GenericForm> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateGenericForm executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:FormMessage的form的FormMessageList
	public SmartList<FormMessage> loadOurFormMessageList(HisUserContext userContext, List<GenericForm> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:FormFieldMessage的form的FormFieldMessageList
	public SmartList<FormFieldMessage> loadOurFormFieldMessageList(HisUserContext userContext, List<GenericForm> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:FormField的form的FormFieldList
	public SmartList<FormField> loadOurFormFieldList(HisUserContext userContext, List<GenericForm> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:FormAction的form的FormActionList
	public SmartList<FormAction> loadOurFormActionList(HisUserContext userContext, List<GenericForm> us, Map<String,Object> options) throws Exception;
	
}


