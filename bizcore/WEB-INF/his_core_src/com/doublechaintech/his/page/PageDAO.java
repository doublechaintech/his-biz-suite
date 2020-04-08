
package com.doublechaintech.his.page;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.his.BaseDAO;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;

import com.doublechaintech.his.uiaction.UiAction;
import com.doublechaintech.his.slide.Slide;
import com.doublechaintech.his.pagetype.PageType;
import com.doublechaintech.his.mobileapp.MobileApp;

import com.doublechaintech.his.slide.SlideDAO;
import com.doublechaintech.his.uiaction.UiActionDAO;
import com.doublechaintech.his.pagetype.PageTypeDAO;
import com.doublechaintech.his.mobileapp.MobileAppDAO;


public interface PageDAO extends BaseDAO{

	public SmartList<Page> loadAll();
	public Page load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Page> pageList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Page present(Page page,Map<String,Object> options) throws Exception;
	public Page clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Page save(Page page,Map<String,Object> options);
	public SmartList<Page> savePageList(SmartList<Page> pageList,Map<String,Object> options);
	public SmartList<Page> removePageList(SmartList<Page> pageList,Map<String,Object> options);
	public SmartList<Page> findPageWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPageWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPageWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String pageId, int version) throws Exception;
	public Page disconnectFromAll(String pageId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public SlideDAO getSlideDAO();
		
	public UiActionDAO getUiActionDAO();
		
	
 	public SmartList<Page> requestCandidatePageForSlide(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Page> requestCandidatePageForUiAction(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Page planToRemoveSlideList(Page page, String slideIds[], Map<String,Object> options)throws Exception;


	public Page planToRemoveUiActionList(Page page, String uiActionIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<Page> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidatePage executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<Page> findPageByPageType(String pageTypeId, Map<String,Object> options);
 	public int countPageByPageType(String pageTypeId, Map<String,Object> options);
 	public Map<String, Integer> countPageByPageTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<Page> findPageByPageType(String pageTypeId, int start, int count, Map<String,Object> options);
 	public void analyzePageByPageType(SmartList<Page> resultList, String pageTypeId, Map<String,Object> options);

 
  
 	public SmartList<Page> findPageByMobileApp(String mobileAppId, Map<String,Object> options);
 	public int countPageByMobileApp(String mobileAppId, Map<String,Object> options);
 	public Map<String, Integer> countPageByMobileAppIds(String[] ids, Map<String,Object> options);
 	public SmartList<Page> findPageByMobileApp(String mobileAppId, int start, int count, Map<String,Object> options);
 	public void analyzePageByMobileApp(SmartList<Page> resultList, String mobileAppId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Slide的page的SlideList
	public SmartList<Slide> loadOurSlideList(HisUserContext userContext, List<Page> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:UiAction的page的UiActionList
	public SmartList<UiAction> loadOurUiActionList(HisUserContext userContext, List<Page> us, Map<String,Object> options) throws Exception;
	
}


