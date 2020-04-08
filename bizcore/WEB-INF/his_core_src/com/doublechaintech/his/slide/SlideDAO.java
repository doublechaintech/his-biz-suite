
package com.doublechaintech.his.slide;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.his.BaseDAO;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;

import com.doublechaintech.his.page.Page;

import com.doublechaintech.his.page.PageDAO;


public interface SlideDAO extends BaseDAO{

	public SmartList<Slide> loadAll();
	public Slide load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Slide> slideList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Slide present(Slide slide,Map<String,Object> options) throws Exception;
	public Slide clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Slide save(Slide slide,Map<String,Object> options);
	public SmartList<Slide> saveSlideList(SmartList<Slide> slideList,Map<String,Object> options);
	public SmartList<Slide> removeSlideList(SmartList<Slide> slideList,Map<String,Object> options);
	public SmartList<Slide> findSlideWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSlideWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSlideWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String slideId, int version) throws Exception;
	public Slide disconnectFromAll(String slideId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<Slide> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateSlide executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<Slide> findSlideByPage(String pageId, Map<String,Object> options);
 	public int countSlideByPage(String pageId, Map<String,Object> options);
 	public Map<String, Integer> countSlideByPageIds(String[] ids, Map<String,Object> options);
 	public SmartList<Slide> findSlideByPage(String pageId, int start, int count, Map<String,Object> options);
 	public void analyzeSlideByPage(SmartList<Slide> resultList, String pageId, Map<String,Object> options);

 
 
}


