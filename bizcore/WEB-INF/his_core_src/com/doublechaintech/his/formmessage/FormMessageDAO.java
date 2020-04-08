
package com.doublechaintech.his.formmessage;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.his.BaseDAO;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;

import com.doublechaintech.his.genericform.GenericForm;

import com.doublechaintech.his.genericform.GenericFormDAO;


public interface FormMessageDAO extends BaseDAO{

	public SmartList<FormMessage> loadAll();
	public FormMessage load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<FormMessage> formMessageList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public FormMessage present(FormMessage formMessage,Map<String,Object> options) throws Exception;
	public FormMessage clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public FormMessage save(FormMessage formMessage,Map<String,Object> options);
	public SmartList<FormMessage> saveFormMessageList(SmartList<FormMessage> formMessageList,Map<String,Object> options);
	public SmartList<FormMessage> removeFormMessageList(SmartList<FormMessage> formMessageList,Map<String,Object> options);
	public SmartList<FormMessage> findFormMessageWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countFormMessageWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countFormMessageWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String formMessageId, int version) throws Exception;
	public FormMessage disconnectFromAll(String formMessageId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<FormMessage> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateFormMessage executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<FormMessage> findFormMessageByForm(String genericFormId, Map<String,Object> options);
 	public int countFormMessageByForm(String genericFormId, Map<String,Object> options);
 	public Map<String, Integer> countFormMessageByFormIds(String[] ids, Map<String,Object> options);
 	public SmartList<FormMessage> findFormMessageByForm(String genericFormId, int start, int count, Map<String,Object> options);
 	public void analyzeFormMessageByForm(SmartList<FormMessage> resultList, String genericFormId, Map<String,Object> options);

 
 
}


