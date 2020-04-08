
package com.doublechaintech.his.mobileapp;
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
import com.doublechaintech.his.pagetype.PageType;

import com.doublechaintech.his.page.PageDAO;
import com.doublechaintech.his.pagetype.PageTypeDAO;


public interface MobileAppDAO extends BaseDAO{

	public SmartList<MobileApp> loadAll();
	public MobileApp load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<MobileApp> mobileAppList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public MobileApp present(MobileApp mobileApp,Map<String,Object> options) throws Exception;
	public MobileApp clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public MobileApp save(MobileApp mobileApp,Map<String,Object> options);
	public SmartList<MobileApp> saveMobileAppList(SmartList<MobileApp> mobileAppList,Map<String,Object> options);
	public SmartList<MobileApp> removeMobileAppList(SmartList<MobileApp> mobileAppList,Map<String,Object> options);
	public SmartList<MobileApp> findMobileAppWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countMobileAppWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countMobileAppWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String mobileAppId, int version) throws Exception;
	public MobileApp disconnectFromAll(String mobileAppId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public PageDAO getPageDAO();
		
	public PageTypeDAO getPageTypeDAO();
		
	
 	public SmartList<MobileApp> requestCandidateMobileAppForPage(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<MobileApp> requestCandidateMobileAppForPageType(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public MobileApp planToRemovePageList(MobileApp mobileApp, String pageIds[], Map<String,Object> options)throws Exception;


	//disconnect MobileApp with page_type in Page
	public MobileApp planToRemovePageListWithPageType(MobileApp mobileApp, String pageTypeId, Map<String,Object> options)throws Exception;
	public int countPageListWithPageType(String mobileAppId, String pageTypeId, Map<String,Object> options)throws Exception;
	
	public MobileApp planToRemovePageTypeList(MobileApp mobileApp, String pageTypeIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<MobileApp> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateMobileApp executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:Page的mobileApp的PageList
	public SmartList<Page> loadOurPageList(HisUserContext userContext, List<MobileApp> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:PageType的mobileApp的PageTypeList
	public SmartList<PageType> loadOurPageTypeList(HisUserContext userContext, List<MobileApp> us, Map<String,Object> options) throws Exception;
	
}


