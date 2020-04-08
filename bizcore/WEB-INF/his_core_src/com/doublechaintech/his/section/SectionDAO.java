
package com.doublechaintech.his.section;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.his.BaseDAO;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;




public interface SectionDAO extends BaseDAO{

	public SmartList<Section> loadAll();
	public Section load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Section> sectionList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Section present(Section section,Map<String,Object> options) throws Exception;
	public Section clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Section save(Section section,Map<String,Object> options);
	public SmartList<Section> saveSectionList(SmartList<Section> sectionList,Map<String,Object> options);
	public SmartList<Section> removeSectionList(SmartList<Section> sectionList,Map<String,Object> options);
	public SmartList<Section> findSectionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSectionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSectionWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String sectionId, int version) throws Exception;
	public Section disconnectFromAll(String sectionId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<Section> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateSection executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

}


