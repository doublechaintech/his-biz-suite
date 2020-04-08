
package com.doublechaintech.his.page;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.TextUtil;

import com.doublechaintech.his.HisBaseDAOImpl;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.AccessKey;
import com.doublechaintech.his.DateKey;
import com.doublechaintech.his.StatsInfo;
import com.doublechaintech.his.StatsItem;

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



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class PageJDBCTemplateDAO extends HisBaseDAOImpl implements PageDAO{
 
 	
 	private  PageTypeDAO  pageTypeDAO;
 	public void setPageTypeDAO(PageTypeDAO pageTypeDAO){
	 	this.pageTypeDAO = pageTypeDAO;
 	}
 	public PageTypeDAO getPageTypeDAO(){
	 	return this.pageTypeDAO;
 	}
 
 	
 	private  MobileAppDAO  mobileAppDAO;
 	public void setMobileAppDAO(MobileAppDAO mobileAppDAO){
	 	this.mobileAppDAO = mobileAppDAO;
 	}
 	public MobileAppDAO getMobileAppDAO(){
	 	return this.mobileAppDAO;
 	}


			
		
	
  	private  SlideDAO  slideDAO;
 	public void setSlideDAO(SlideDAO pSlideDAO){
 	
 		if(pSlideDAO == null){
 			throw new IllegalStateException("Do not try to set slideDAO to null.");
 		}
	 	this.slideDAO = pSlideDAO;
 	}
 	public SlideDAO getSlideDAO(){
 		if(this.slideDAO == null){
 			throw new IllegalStateException("The slideDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.slideDAO;
 	}	
 	
			
		
	
  	private  UiActionDAO  uiActionDAO;
 	public void setUiActionDAO(UiActionDAO pUiActionDAO){
 	
 		if(pUiActionDAO == null){
 			throw new IllegalStateException("Do not try to set uiActionDAO to null.");
 		}
	 	this.uiActionDAO = pUiActionDAO;
 	}
 	public UiActionDAO getUiActionDAO(){
 		if(this.uiActionDAO == null){
 			throw new IllegalStateException("The uiActionDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.uiActionDAO;
 	}	
 	
			
		

	
	/*
	protected Page load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPage(accessKey, options);
	}
	*/
	
	public SmartList<Page> loadAll() {
	    return this.loadAll(getPageMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Page load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPage(PageTable.withId(id), options);
	}
	
	
	
	public Page save(Page page,Map<String,Object> options){
		
		String methodName="save(Page page,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(page, methodName, "page");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPage(page,options);
	}
	public Page clone(String pageId, Map<String,Object> options) throws Exception{
	
		return clone(PageTable.withId(pageId),options);
	}
	
	protected Page clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String pageId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Page newPage = loadInternalPage(accessKey, options);
		newPage.setVersion(0);
		
		
 		
 		if(isSaveSlideListEnabled(options)){
 			for(Slide item: newPage.getSlideList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveUiActionListEnabled(options)){
 			for(UiAction item: newPage.getUiActionList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalPage(newPage,options);
		
		return newPage;
	}
	
	
	
	

	protected void throwIfHasException(String pageId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PageVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PageNotFoundException(
					"The " + this.getTableName() + "(" + pageId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String pageId, int version) throws Exception{
	
		String methodName="delete(String pageId, int version)";
		assertMethodArgumentNotNull(pageId, methodName, "pageId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{pageId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(pageId,version);
		}
		
	
	}
	
	
	
	
	

	public Page disconnectFromAll(String pageId, int version) throws Exception{
	
		
		Page page = loadInternalPage(PageTable.withId(pageId), emptyOptions());
		page.clearFromAll();
		this.savePage(page);
		return page;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return PageTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "page";
	}
	@Override
	protected String getBeanName() {
		
		return "page";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PageTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPageTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PageTokens.PAGETYPE);
 	}

 	protected boolean isSavePageTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PageTokens.PAGETYPE);
 	}
 	

 	
  

 	protected boolean isExtractMobileAppEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PageTokens.MOBILEAPP);
 	}

 	protected boolean isSaveMobileAppEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PageTokens.MOBILEAPP);
 	}
 	

 	
 
		
	
	protected boolean isExtractSlideListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PageTokens.SLIDE_LIST);
 	}
 	protected boolean isAnalyzeSlideListEnabled(Map<String,Object> options){		 		
 		return PageTokens.of(options).analyzeSlideListEnabled();
 	}
	
	protected boolean isSaveSlideListEnabled(Map<String,Object> options){
		return checkOptions(options, PageTokens.SLIDE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractUiActionListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PageTokens.UI_ACTION_LIST);
 	}
 	protected boolean isAnalyzeUiActionListEnabled(Map<String,Object> options){		 		
 		return PageTokens.of(options).analyzeUiActionListEnabled();
 	}
	
	protected boolean isSaveUiActionListEnabled(Map<String,Object> options){
		return checkOptions(options, PageTokens.UI_ACTION_LIST);
		
 	}
 	
		

	

	protected PageMapper getPageMapper(){
		return new PageMapper();
	}

	
	
	protected Page extractPage(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Page page = loadSingleObject(accessKey, getPageMapper());
			return page;
		}catch(EmptyResultDataAccessException e){
			throw new PageNotFoundException("Page("+accessKey+") is not found!");
		}

	}

	
	

	protected Page loadInternalPage(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Page page = extractPage(accessKey, loadOptions);
 	
 		if(isExtractPageTypeEnabled(loadOptions)){
	 		extractPageType(page, loadOptions);
 		}
  	
 		if(isExtractMobileAppEnabled(loadOptions)){
	 		extractMobileApp(page, loadOptions);
 		}
 
		
		if(isExtractSlideListEnabled(loadOptions)){
	 		extractSlideList(page, loadOptions);
 		}	
 		if(isAnalyzeSlideListEnabled(loadOptions)){
	 		analyzeSlideList(page, loadOptions);
 		}
 		
		
		if(isExtractUiActionListEnabled(loadOptions)){
	 		extractUiActionList(page, loadOptions);
 		}	
 		if(isAnalyzeUiActionListEnabled(loadOptions)){
	 		analyzeUiActionList(page, loadOptions);
 		}
 		
		
		return page;
		
	}

	 

 	protected Page extractPageType(Page page, Map<String,Object> options) throws Exception{

		if(page.getPageType() == null){
			return page;
		}
		String pageTypeId = page.getPageType().getId();
		if( pageTypeId == null){
			return page;
		}
		PageType pageType = getPageTypeDAO().load(pageTypeId,options);
		if(pageType != null){
			page.setPageType(pageType);
		}
		
 		
 		return page;
 	}
 		
  

 	protected Page extractMobileApp(Page page, Map<String,Object> options) throws Exception{

		if(page.getMobileApp() == null){
			return page;
		}
		String mobileAppId = page.getMobileApp().getId();
		if( mobileAppId == null){
			return page;
		}
		MobileApp mobileApp = getMobileAppDAO().load(mobileAppId,options);
		if(mobileApp != null){
			page.setMobileApp(mobileApp);
		}
		
 		
 		return page;
 	}
 		
 
		
	protected void enhanceSlideList(SmartList<Slide> slideList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Page extractSlideList(Page page, Map<String,Object> options){
		
		
		if(page == null){
			return null;
		}
		if(page.getId() == null){
			return page;
		}

		
		
		SmartList<Slide> slideList = getSlideDAO().findSlideByPage(page.getId(),options);
		if(slideList != null){
			enhanceSlideList(slideList,options);
			page.setSlideList(slideList);
		}
		
		return page;
	
	}	
	
	protected Page analyzeSlideList(Page page, Map<String,Object> options){
		
		
		if(page == null){
			return null;
		}
		if(page.getId() == null){
			return page;
		}

		
		
		SmartList<Slide> slideList = page.getSlideList();
		if(slideList != null){
			getSlideDAO().analyzeSlideByPage(slideList, page.getId(), options);
			
		}
		
		return page;
	
	}	
	
		
	protected void enhanceUiActionList(SmartList<UiAction> uiActionList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Page extractUiActionList(Page page, Map<String,Object> options){
		
		
		if(page == null){
			return null;
		}
		if(page.getId() == null){
			return page;
		}

		
		
		SmartList<UiAction> uiActionList = getUiActionDAO().findUiActionByPage(page.getId(),options);
		if(uiActionList != null){
			enhanceUiActionList(uiActionList,options);
			page.setUiActionList(uiActionList);
		}
		
		return page;
	
	}	
	
	protected Page analyzeUiActionList(Page page, Map<String,Object> options){
		
		
		if(page == null){
			return null;
		}
		if(page.getId() == null){
			return page;
		}

		
		
		SmartList<UiAction> uiActionList = page.getUiActionList();
		if(uiActionList != null){
			getUiActionDAO().analyzeUiActionByPage(uiActionList, page.getId(), options);
			
		}
		
		return page;
	
	}	
	
		
		
  	
 	public SmartList<Page> findPageByPageType(String pageTypeId,Map<String,Object> options){
 	
  		SmartList<Page> resultList = queryWith(PageTable.COLUMN_PAGE_TYPE, pageTypeId, options, getPageMapper());
		// analyzePageByPageType(resultList, pageTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Page> findPageByPageType(String pageTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Page> resultList =  queryWithRange(PageTable.COLUMN_PAGE_TYPE, pageTypeId, options, getPageMapper(), start, count);
 		//analyzePageByPageType(resultList, pageTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzePageByPageType(SmartList<Page> resultList, String pageTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Page.PAGE_TYPE_PROPERTY, pageTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countPageByPageType(String pageTypeId,Map<String,Object> options){

 		return countWith(PageTable.COLUMN_PAGE_TYPE, pageTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countPageByPageTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(PageTable.COLUMN_PAGE_TYPE, ids, options);
	}
 	
  	
 	public SmartList<Page> findPageByMobileApp(String mobileAppId,Map<String,Object> options){
 	
  		SmartList<Page> resultList = queryWith(PageTable.COLUMN_MOBILE_APP, mobileAppId, options, getPageMapper());
		// analyzePageByMobileApp(resultList, mobileAppId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Page> findPageByMobileApp(String mobileAppId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Page> resultList =  queryWithRange(PageTable.COLUMN_MOBILE_APP, mobileAppId, options, getPageMapper(), start, count);
 		//analyzePageByMobileApp(resultList, mobileAppId, options);
 		return resultList;
 		
 	}
 	public void analyzePageByMobileApp(SmartList<Page> resultList, String mobileAppId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Page.MOBILE_APP_PROPERTY, mobileAppId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countPageByMobileApp(String mobileAppId,Map<String,Object> options){

 		return countWith(PageTable.COLUMN_MOBILE_APP, mobileAppId, options);
 	}
 	@Override
	public Map<String, Integer> countPageByMobileAppIds(String[] ids, Map<String, Object> options) {
		return countWithIds(PageTable.COLUMN_MOBILE_APP, ids, options);
	}
 	
 	
		
		
		

	

	protected Page savePage(Page  page){
		
		if(!page.isChanged()){
			return page;
		}
		
		
		String SQL=this.getSavePageSQL(page);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePageParameters(page);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		page.incVersion();
		return page;
	
	}
	public SmartList<Page> savePageList(SmartList<Page> pageList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPageList(pageList);
		
		batchPageCreate((List<Page>)lists[CREATE_LIST_INDEX]);
		
		batchPageUpdate((List<Page>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Page page:pageList){
			if(page.isChanged()){
				page.incVersion();
			}
			
		
		}
		
		
		return pageList;
	}

	public SmartList<Page> removePageList(SmartList<Page> pageList,Map<String,Object> options){
		
		
		super.removeList(pageList, options);
		
		return pageList;
		
		
	}
	
	protected List<Object[]> preparePageBatchCreateArgs(List<Page> pageList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Page page:pageList ){
			Object [] parameters = preparePageCreateParameters(page);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePageBatchUpdateArgs(List<Page> pageList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Page page:pageList ){
			if(!page.isChanged()){
				continue;
			}
			Object [] parameters = preparePageUpdateParameters(page);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPageCreate(List<Page> pageList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePageBatchCreateArgs(pageList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPageUpdate(List<Page> pageList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePageBatchUpdateArgs(pageList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPageList(List<Page> pageList){
		
		List<Page> pageCreateList=new ArrayList<Page>();
		List<Page> pageUpdateList=new ArrayList<Page>();
		
		for(Page page: pageList){
			if(isUpdateRequest(page)){
				pageUpdateList.add( page);
				continue;
			}
			pageCreateList.add(page);
		}
		
		return new Object[]{pageCreateList,pageUpdateList};
	}
	
	protected boolean isUpdateRequest(Page page){
 		return page.getVersion() > 0;
 	}
 	protected String getSavePageSQL(Page page){
 		if(isUpdateRequest(page)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePageParameters(Page page){
 		if(isUpdateRequest(page) ){
 			return preparePageUpdateParameters(page);
 		}
 		return preparePageCreateParameters(page);
 	}
 	protected Object[] preparePageUpdateParameters(Page page){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = page.getPageTitle();
 		
 		
 		parameters[1] = page.getLinkToUrl();
 		 	
 		if(page.getPageType() != null){
 			parameters[2] = page.getPageType().getId();
 		}
  	
 		if(page.getMobileApp() != null){
 			parameters[3] = page.getMobileApp().getId();
 		}
 		
 		parameters[4] = page.nextVersion();
 		parameters[5] = page.getId();
 		parameters[6] = page.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePageCreateParameters(Page page){
		Object[] parameters = new Object[5];
		String newPageId=getNextId();
		page.setId(newPageId);
		parameters[0] =  page.getId();
 
 		
 		parameters[1] = page.getPageTitle();
 		
 		
 		parameters[2] = page.getLinkToUrl();
 		 	
 		if(page.getPageType() != null){
 			parameters[3] = page.getPageType().getId();
 		
 		}
 		 	
 		if(page.getMobileApp() != null){
 			parameters[4] = page.getMobileApp().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Page saveInternalPage(Page page, Map<String,Object> options){
		
		savePage(page);
 	
 		if(isSavePageTypeEnabled(options)){
	 		savePageType(page, options);
 		}
  	
 		if(isSaveMobileAppEnabled(options)){
	 		saveMobileApp(page, options);
 		}
 
		
		if(isSaveSlideListEnabled(options)){
	 		saveSlideList(page, options);
	 		//removeSlideList(page, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveUiActionListEnabled(options)){
	 		saveUiActionList(page, options);
	 		//removeUiActionList(page, options);
	 		//Not delete the record
	 		
 		}		
		
		return page;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Page savePageType(Page page, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(page.getPageType() == null){
 			return page;//do nothing when it is null
 		}
 		
 		getPageTypeDAO().save(page.getPageType(),options);
 		return page;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Page saveMobileApp(Page page, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(page.getMobileApp() == null){
 			return page;//do nothing when it is null
 		}
 		
 		getMobileAppDAO().save(page.getMobileApp(),options);
 		return page;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Page planToRemoveSlideList(Page page, String slideIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Slide.PAGE_PROPERTY, page.getId());
		key.put(Slide.ID_PROPERTY, slideIds);
		
		SmartList<Slide> externalSlideList = getSlideDAO().
				findSlideWithKey(key, options);
		if(externalSlideList == null){
			return page;
		}
		if(externalSlideList.isEmpty()){
			return page;
		}
		
		for(Slide slideItem: externalSlideList){

			slideItem.clearFromAll();
		}
		
		
		SmartList<Slide> slideList = page.getSlideList();		
		slideList.addAllToRemoveList(externalSlideList);
		return page;	
	
	}


	public Page planToRemoveUiActionList(Page page, String uiActionIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UiAction.PAGE_PROPERTY, page.getId());
		key.put(UiAction.ID_PROPERTY, uiActionIds);
		
		SmartList<UiAction> externalUiActionList = getUiActionDAO().
				findUiActionWithKey(key, options);
		if(externalUiActionList == null){
			return page;
		}
		if(externalUiActionList.isEmpty()){
			return page;
		}
		
		for(UiAction uiActionItem: externalUiActionList){

			uiActionItem.clearFromAll();
		}
		
		
		SmartList<UiAction> uiActionList = page.getUiActionList();		
		uiActionList.addAllToRemoveList(externalUiActionList);
		return page;	
	
	}



		
	protected Page saveSlideList(Page page, Map<String,Object> options){
		
		
		
		
		SmartList<Slide> slideList = page.getSlideList();
		if(slideList == null){
			//null list means nothing
			return page;
		}
		SmartList<Slide> mergedUpdateSlideList = new SmartList<Slide>();
		
		
		mergedUpdateSlideList.addAll(slideList); 
		if(slideList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateSlideList.addAll(slideList.getToRemoveList());
			slideList.removeAll(slideList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getSlideDAO().saveSlideList(mergedUpdateSlideList,options);
		
		if(slideList.getToRemoveList() != null){
			slideList.removeAll(slideList.getToRemoveList());
		}
		
		
		return page;
	
	}
	
	protected Page removeSlideList(Page page, Map<String,Object> options){
	
	
		SmartList<Slide> slideList = page.getSlideList();
		if(slideList == null){
			return page;
		}	
	
		SmartList<Slide> toRemoveSlideList = slideList.getToRemoveList();
		
		if(toRemoveSlideList == null){
			return page;
		}
		if(toRemoveSlideList.isEmpty()){
			return page;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSlideDAO().removeSlideList(toRemoveSlideList,options);
		
		return page;
	
	}
	
	

 	
 	
	
	
	
		
	protected Page saveUiActionList(Page page, Map<String,Object> options){
		
		
		
		
		SmartList<UiAction> uiActionList = page.getUiActionList();
		if(uiActionList == null){
			//null list means nothing
			return page;
		}
		SmartList<UiAction> mergedUpdateUiActionList = new SmartList<UiAction>();
		
		
		mergedUpdateUiActionList.addAll(uiActionList); 
		if(uiActionList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateUiActionList.addAll(uiActionList.getToRemoveList());
			uiActionList.removeAll(uiActionList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getUiActionDAO().saveUiActionList(mergedUpdateUiActionList,options);
		
		if(uiActionList.getToRemoveList() != null){
			uiActionList.removeAll(uiActionList.getToRemoveList());
		}
		
		
		return page;
	
	}
	
	protected Page removeUiActionList(Page page, Map<String,Object> options){
	
	
		SmartList<UiAction> uiActionList = page.getUiActionList();
		if(uiActionList == null){
			return page;
		}	
	
		SmartList<UiAction> toRemoveUiActionList = uiActionList.getToRemoveList();
		
		if(toRemoveUiActionList == null){
			return page;
		}
		if(toRemoveUiActionList.isEmpty()){
			return page;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getUiActionDAO().removeUiActionList(toRemoveUiActionList,options);
		
		return page;
	
	}
	
	

 	
 	
	
	
	
		

	public Page present(Page page,Map<String, Object> options){
	
		presentSlideList(page,options);
		presentUiActionList(page,options);

		return page;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Page presentSlideList(
			Page page,
			Map<String, Object> options) {

		SmartList<Slide> slideList = page.getSlideList();		
				SmartList<Slide> newList= presentSubList(page.getId(),
				slideList,
				options,
				getSlideDAO()::countSlideByPage,
				getSlideDAO()::findSlideByPage
				);

		
		page.setSlideList(newList);
		

		return page;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Page presentUiActionList(
			Page page,
			Map<String, Object> options) {

		SmartList<UiAction> uiActionList = page.getUiActionList();		
				SmartList<UiAction> newList= presentSubList(page.getId(),
				uiActionList,
				options,
				getUiActionDAO()::countUiActionByPage,
				getUiActionDAO()::findUiActionByPage
				);

		
		page.setUiActionList(newList);
		

		return page;
	}			
		

	
    public SmartList<Page> requestCandidatePageForSlide(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PageTable.COLUMN_PAGE_TITLE, PageTable.COLUMN_PAGE_TYPE, filterKey, pageNo, pageSize, getPageMapper());
    }
		
    public SmartList<Page> requestCandidatePageForUiAction(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PageTable.COLUMN_PAGE_TITLE, PageTable.COLUMN_PAGE_TYPE, filterKey, pageNo, pageSize, getPageMapper());
    }
		

	protected String getTableName(){
		return PageTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Page> pageList) {		
		this.enhanceListInternal(pageList, this.getPageMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:Slide的page的SlideList
	public SmartList<Slide> loadOurSlideList(HisUserContext userContext, List<Page> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Slide.PAGE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Slide> loadedObjs = userContext.getDAOGroup().getSlideDAO().findSlideWithKey(key, options);
		Map<String, List<Slide>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPage().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Slide> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Slide> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setSlideList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:UiAction的page的UiActionList
	public SmartList<UiAction> loadOurUiActionList(HisUserContext userContext, List<Page> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UiAction.PAGE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<UiAction> loadedObjs = userContext.getDAOGroup().getUiActionDAO().findUiActionWithKey(key, options);
		Map<String, List<UiAction>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPage().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<UiAction> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<UiAction> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setUiActionList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Page> pageList = ownerEntity.collectRefsWithType(Page.INTERNAL_TYPE);
		this.enhanceList(pageList);
		
	}
	
	@Override
	public SmartList<Page> findPageWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getPageMapper());

	}
	@Override
	public int countPageWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countPageWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Page> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPageMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidatePage executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidatePage result = new CandidatePage();
		int pageNo = Math.max(1, query.getPageNo());
		result.setOwnerClass(TextUtil.toCamelCase(query.getOwnerType()));
		result.setOwnerId(query.getOwnerId());
		result.setFilterKey(query.getFilterKey());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase("displayName")));
		result.setGroupByFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase(query.getGroupBy())));

		SmartList candidateList = queryList(sql, parmeters);
		this.alias(candidateList);
		result.setCandidates(candidateList);
		int offSet = (pageNo - 1 ) * query.getPageSize();
		if (candidateList.size() > query.getPageSize()) {
			result.setTotalPage(pageNo+1);
		}else {
			result.setTotalPage(pageNo);
		}
		return result;
	}
	
	

}


