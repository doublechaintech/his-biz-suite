
package com.doublechaintech.his.pagetype;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.his.*;
import com.doublechaintech.his.tree.*;
import com.doublechaintech.his.treenode.*;
import com.doublechaintech.his.HisUserContextImpl;
import com.doublechaintech.his.iamservice.*;
import com.doublechaintech.his.services.IamService;
import com.doublechaintech.his.secuser.SecUser;
import com.doublechaintech.his.userapp.UserApp;
import com.doublechaintech.his.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.doublechaintech.his.page.Page;
import com.doublechaintech.his.mobileapp.MobileApp;

import com.doublechaintech.his.mobileapp.CandidateMobileApp;

import com.doublechaintech.his.pagetype.PageType;
import com.doublechaintech.his.mobileapp.MobileApp;






public class PageTypeManagerImpl extends CustomHisCheckerManager implements PageTypeManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "PageType";
	@Override
	public PageTypeDAO daoOf(HisUserContext userContext) {
		return pageTypeDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws PageTypeManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new PageTypeManagerException(message);

	}



 	protected PageType savePageType(HisUserContext userContext, PageType pageType, String [] tokensExpr) throws Exception{	
 		//return getPageTypeDAO().save(pageType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePageType(userContext, pageType, tokens);
 	}
 	
 	protected PageType savePageTypeDetail(HisUserContext userContext, PageType pageType) throws Exception{	

 		
 		return savePageType(userContext, pageType, allTokens());
 	}
 	
 	public PageType loadPageType(HisUserContext userContext, String pageTypeId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPageType(pageTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( PageTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		PageType pageType = loadPageType( userContext, pageTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,pageType, tokens);
 	}
 	
 	
 	 public PageType searchPageType(HisUserContext userContext, String pageTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPageType(pageTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( PageTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		PageType pageType = loadPageType( userContext, pageTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,pageType, tokens);
 	}
 	
 	

 	protected PageType present(HisUserContext userContext, PageType pageType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,pageType,tokens);
		
		
		PageType  pageTypeToPresent = pageTypeDaoOf(userContext).present(pageType, tokens);
		
		List<BaseEntity> entityListToNaming = pageTypeToPresent.collectRefercencesFromLists();
		pageTypeDaoOf(userContext).alias(entityListToNaming);
		
		return  pageTypeToPresent;
		
		
	}
 
 	
 	
 	public PageType loadPageTypeDetail(HisUserContext userContext, String pageTypeId) throws Exception{	
 		PageType pageType = loadPageType( userContext, pageTypeId, allTokens());
 		return present(userContext,pageType, allTokens());
		
 	}
 	
 	public Object view(HisUserContext userContext, String pageTypeId) throws Exception{	
 		PageType pageType = loadPageType( userContext, pageTypeId, viewTokens());
 		return present(userContext,pageType, allTokens());
		
 	}
 	protected PageType savePageType(HisUserContext userContext, PageType pageType, Map<String,Object>tokens) throws Exception{	
 		return pageTypeDaoOf(userContext).save(pageType, tokens);
 	}
 	protected PageType loadPageType(HisUserContext userContext, String pageTypeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfPageType(pageTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( PageTypeManagerException.class);

 
 		return pageTypeDaoOf(userContext).load(pageTypeId, tokens);
 	}

	
	

	public PageType loadPageTypeWithCode(HisUserContext userContext, String code, Map<String,Object>tokens) throws Exception{	
 		return pageTypeDaoOf(userContext).loadByCode(code, tokens);
 	}

	 


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HisUserContext userContext, PageType pageType, Map<String, Object> tokens){
		super.addActions(userContext, pageType, tokens);
		
		addAction(userContext, pageType, tokens,"@create","createPageType","createPageType/","main","primary");
		addAction(userContext, pageType, tokens,"@update","updatePageType","updatePageType/"+pageType.getId()+"/","main","primary");
		addAction(userContext, pageType, tokens,"@copy","clonePageType","clonePageType/"+pageType.getId()+"/","main","primary");
		
		addAction(userContext, pageType, tokens,"page_type.transfer_to_mobile_app","transferToAnotherMobileApp","transferToAnotherMobileApp/"+pageType.getId()+"/","main","primary");
		addAction(userContext, pageType, tokens,"page_type.addPage","addPage","addPage/"+pageType.getId()+"/","pageList","primary");
		addAction(userContext, pageType, tokens,"page_type.removePage","removePage","removePage/"+pageType.getId()+"/","pageList","primary");
		addAction(userContext, pageType, tokens,"page_type.updatePage","updatePage","updatePage/"+pageType.getId()+"/","pageList","primary");
		addAction(userContext, pageType, tokens,"page_type.copyPageFrom","copyPageFrom","copyPageFrom/"+pageType.getId()+"/","pageList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HisUserContext userContext, PageType pageType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public PageType createPageType(HisUserContext userContext, String name,String code,String mobileAppId,boolean footerTab) throws Exception
	//public PageType createPageType(HisUserContext userContext,String name, String code, String mobileAppId, boolean footerTab) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfPageType(name);
		checkerOf(userContext).checkCodeOfPageType(code);
		checkerOf(userContext).checkFooterTabOfPageType(footerTab);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PageTypeManagerException.class);


		PageType pageType=createNewPageType();	

		pageType.setName(name);
		pageType.setCode(code);
			
		MobileApp mobileApp = loadMobileApp(userContext, mobileAppId,emptyOptions());
		pageType.setMobileApp(mobileApp);
		
		
		pageType.setFooterTab(footerTab);

		pageType = savePageType(userContext, pageType, emptyOptions());
		
		onNewInstanceCreated(userContext, pageType);
		return pageType;


	}
	protected PageType createNewPageType()
	{

		return new PageType();
	}

	protected void checkParamsForUpdatingPageType(HisUserContext userContext,String pageTypeId, int pageTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfPageType(pageTypeId);
		checkerOf(userContext).checkVersionOfPageType( pageTypeVersion);
		

		if(PageType.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfPageType(parseString(newValueExpr));
		
			
		}
		if(PageType.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfPageType(parseString(newValueExpr));
		
			
		}		

		
		if(PageType.FOOTER_TAB_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFooterTabOfPageType(parseBoolean(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(PageTypeManagerException.class);


	}



	public PageType clone(HisUserContext userContext, String fromPageTypeId) throws Exception{

		return pageTypeDaoOf(userContext).clone(fromPageTypeId, this.allTokens());
	}

	public PageType internalSavePageType(HisUserContext userContext, PageType pageType) throws Exception
	{
		return internalSavePageType(userContext, pageType, allTokens());

	}
	public PageType internalSavePageType(HisUserContext userContext, PageType pageType, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingPageType(userContext, pageTypeId, pageTypeVersion, property, newValueExpr, tokensExpr);


		synchronized(pageType){
			//will be good when the pageType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PageType.
			if (pageType.isChanged()){
			
			}
			pageType = savePageType(userContext, pageType, options);
			return pageType;

		}

	}

	public PageType updatePageType(HisUserContext userContext,String pageTypeId, int pageTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPageType(userContext, pageTypeId, pageTypeVersion, property, newValueExpr, tokensExpr);



		PageType pageType = loadPageType(userContext, pageTypeId, allTokens());
		if(pageType.getVersion() != pageTypeVersion){
			String message = "The target version("+pageType.getVersion()+") is not equals to version("+pageTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(pageType){
			//will be good when the pageType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PageType.
			
			pageType.changeProperty(property, newValueExpr);
			pageType = savePageType(userContext, pageType, tokens().done());
			return present(userContext,pageType, mergedAllTokens(tokensExpr));
			//return savePageType(userContext, pageType, tokens().done());
		}

	}

	public PageType updatePageTypeProperty(HisUserContext userContext,String pageTypeId, int pageTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPageType(userContext, pageTypeId, pageTypeVersion, property, newValueExpr, tokensExpr);

		PageType pageType = loadPageType(userContext, pageTypeId, allTokens());
		if(pageType.getVersion() != pageTypeVersion){
			String message = "The target version("+pageType.getVersion()+") is not equals to version("+pageTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(pageType){
			//will be good when the pageType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PageType.

			pageType.changeProperty(property, newValueExpr);
			
			pageType = savePageType(userContext, pageType, tokens().done());
			return present(userContext,pageType, mergedAllTokens(tokensExpr));
			//return savePageType(userContext, pageType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected PageTypeTokens tokens(){
		return PageTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PageTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortPageListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PageTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherMobileApp(HisUserContext userContext, String pageTypeId, String anotherMobileAppId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfPageType(pageTypeId);
 		checkerOf(userContext).checkIdOfMobileApp(anotherMobileAppId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(PageTypeManagerException.class);

 	}
 	public PageType transferToAnotherMobileApp(HisUserContext userContext, String pageTypeId, String anotherMobileAppId) throws Exception
 	{
 		checkParamsForTransferingAnotherMobileApp(userContext, pageTypeId,anotherMobileAppId);
 
		PageType pageType = loadPageType(userContext, pageTypeId, allTokens());	
		synchronized(pageType){
			//will be good when the pageType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			MobileApp mobileApp = loadMobileApp(userContext, anotherMobileAppId, emptyOptions());		
			pageType.updateMobileApp(mobileApp);		
			pageType = savePageType(userContext, pageType, emptyOptions());
			
			return present(userContext,pageType, allTokens());
			
		}

 	}

	


	public CandidateMobileApp requestCandidateMobileApp(HisUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateMobileApp result = new CandidateMobileApp();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<MobileApp> candidateList = mobileAppDaoOf(userContext).requestCandidateMobileAppForPageType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected MobileApp loadMobileApp(HisUserContext userContext, String newMobileAppId, Map<String,Object> options) throws Exception
 	{

 		return mobileAppDaoOf(userContext).load(newMobileAppId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(HisUserContext userContext, String pageTypeId, int pageTypeVersion) throws Exception {
		//deleteInternal(userContext, pageTypeId, pageTypeVersion);
	}
	protected void deleteInternal(HisUserContext userContext,
			String pageTypeId, int pageTypeVersion) throws Exception{

		pageTypeDaoOf(userContext).delete(pageTypeId, pageTypeVersion);
	}

	public PageType forgetByAll(HisUserContext userContext, String pageTypeId, int pageTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, pageTypeId, pageTypeVersion);
	}
	protected PageType forgetByAllInternal(HisUserContext userContext,
			String pageTypeId, int pageTypeVersion) throws Exception{

		return pageTypeDaoOf(userContext).disconnectFromAll(pageTypeId, pageTypeVersion);
	}




	public int deleteAll(HisUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PageTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(HisUserContext userContext) throws Exception{
		return pageTypeDaoOf(userContext).deleteAll();
	}


	//disconnect PageType with mobile_app in Page
	protected PageType breakWithPageByMobileApp(HisUserContext userContext, String pageTypeId, String mobileAppId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			PageType pageType = loadPageType(userContext, pageTypeId, allTokens());

			synchronized(pageType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				pageTypeDaoOf(userContext).planToRemovePageListWithMobileApp(pageType, mobileAppId, this.emptyOptions());

				pageType = savePageType(userContext, pageType, tokens().withPageList().done());
				return pageType;
			}
	}






	protected void checkParamsForAddingPage(HisUserContext userContext, String pageTypeId, String pageTitle, String linkToUrl, String mobileAppId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfPageType(pageTypeId);

		
		checkerOf(userContext).checkPageTitleOfPage(pageTitle);
		
		checkerOf(userContext).checkLinkToUrlOfPage(linkToUrl);
		
		checkerOf(userContext).checkMobileAppIdOfPage(mobileAppId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PageTypeManagerException.class);


	}
	public  PageType addPage(HisUserContext userContext, String pageTypeId, String pageTitle, String linkToUrl, String mobileAppId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingPage(userContext,pageTypeId,pageTitle, linkToUrl, mobileAppId,tokensExpr);

		Page page = createPage(userContext,pageTitle, linkToUrl, mobileAppId);

		PageType pageType = loadPageType(userContext, pageTypeId, emptyOptions());
		synchronized(pageType){
			//Will be good when the pageType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			pageType.addPage( page );
			pageType = savePageType(userContext, pageType, tokens().withPageList().done());
			
			userContext.getManagerGroup().getPageManager().onNewInstanceCreated(userContext, page);
			return present(userContext,pageType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingPageProperties(HisUserContext userContext, String pageTypeId,String id,String pageTitle,String linkToUrl,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPageType(pageTypeId);
		checkerOf(userContext).checkIdOfPage(id);

		checkerOf(userContext).checkPageTitleOfPage( pageTitle);
		checkerOf(userContext).checkLinkToUrlOfPage( linkToUrl);

		checkerOf(userContext).throwExceptionIfHasErrors(PageTypeManagerException.class);

	}
	public  PageType updatePageProperties(HisUserContext userContext, String pageTypeId, String id,String pageTitle,String linkToUrl, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPageProperties(userContext,pageTypeId,id,pageTitle,linkToUrl,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withPageListList()
				.searchPageListWith(Page.ID_PROPERTY, "is", id).done();

		PageType pageTypeToUpdate = loadPageType(userContext, pageTypeId, options);

		if(pageTypeToUpdate.getPageList().isEmpty()){
			throw new PageTypeManagerException("Page is NOT FOUND with id: '"+id+"'");
		}

		Page item = pageTypeToUpdate.getPageList().first();

		item.updatePageTitle( pageTitle );
		item.updateLinkToUrl( linkToUrl );


		//checkParamsForAddingPage(userContext,pageTypeId,name, code, used,tokensExpr);
		PageType pageType = savePageType(userContext, pageTypeToUpdate, tokens().withPageList().done());
		synchronized(pageType){
			return present(userContext,pageType, mergedAllTokens(tokensExpr));
		}
	}


	protected Page createPage(HisUserContext userContext, String pageTitle, String linkToUrl, String mobileAppId) throws Exception{

		Page page = new Page();
		
		
		page.setPageTitle(pageTitle);		
		page.setLinkToUrl(linkToUrl);		
		MobileApp  mobileApp = new MobileApp();
		mobileApp.setId(mobileAppId);		
		page.setMobileApp(mobileApp);
	
		
		return page;


	}

	protected Page createIndexedPage(String id, int version){

		Page page = new Page();
		page.setId(id);
		page.setVersion(version);
		return page;

	}

	protected void checkParamsForRemovingPageList(HisUserContext userContext, String pageTypeId,
			String pageIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPageType(pageTypeId);
		for(String pageIdItem: pageIds){
			checkerOf(userContext).checkIdOfPage(pageIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(PageTypeManagerException.class);

	}
	public  PageType removePageList(HisUserContext userContext, String pageTypeId,
			String pageIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingPageList(userContext, pageTypeId,  pageIds, tokensExpr);


			PageType pageType = loadPageType(userContext, pageTypeId, allTokens());
			synchronized(pageType){
				//Will be good when the pageType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				pageTypeDaoOf(userContext).planToRemovePageList(pageType, pageIds, allTokens());
				pageType = savePageType(userContext, pageType, tokens().withPageList().done());
				deleteRelationListInGraph(userContext, pageType.getPageList());
				return present(userContext,pageType, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingPage(HisUserContext userContext, String pageTypeId,
		String pageId, int pageVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPageType( pageTypeId);
		checkerOf(userContext).checkIdOfPage(pageId);
		checkerOf(userContext).checkVersionOfPage(pageVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PageTypeManagerException.class);

	}
	public  PageType removePage(HisUserContext userContext, String pageTypeId,
		String pageId, int pageVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingPage(userContext,pageTypeId, pageId, pageVersion,tokensExpr);

		Page page = createIndexedPage(pageId, pageVersion);
		PageType pageType = loadPageType(userContext, pageTypeId, allTokens());
		synchronized(pageType){
			//Will be good when the pageType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			pageType.removePage( page );
			pageType = savePageType(userContext, pageType, tokens().withPageList().done());
			deleteRelationInGraph(userContext, page);
			return present(userContext,pageType, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingPage(HisUserContext userContext, String pageTypeId,
		String pageId, int pageVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPageType( pageTypeId);
		checkerOf(userContext).checkIdOfPage(pageId);
		checkerOf(userContext).checkVersionOfPage(pageVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PageTypeManagerException.class);

	}
	public  PageType copyPageFrom(HisUserContext userContext, String pageTypeId,
		String pageId, int pageVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingPage(userContext,pageTypeId, pageId, pageVersion,tokensExpr);

		Page page = createIndexedPage(pageId, pageVersion);
		PageType pageType = loadPageType(userContext, pageTypeId, allTokens());
		synchronized(pageType){
			//Will be good when the pageType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			pageType.copyPageFrom( page );
			pageType = savePageType(userContext, pageType, tokens().withPageList().done());
			
			userContext.getManagerGroup().getPageManager().onNewInstanceCreated(userContext, (Page)pageType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,pageType, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingPage(HisUserContext userContext, String pageTypeId, String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPageType(pageTypeId);
		checkerOf(userContext).checkIdOfPage(pageId);
		checkerOf(userContext).checkVersionOfPage(pageVersion);
		

		if(Page.PAGE_TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPageTitleOfPage(parseString(newValueExpr));
		
		}
		
		if(Page.LINK_TO_URL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLinkToUrlOfPage(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PageTypeManagerException.class);

	}

	public  PageType updatePage(HisUserContext userContext, String pageTypeId, String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingPage(userContext, pageTypeId, pageId, pageVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withPageList().searchPageListWith(Page.ID_PROPERTY, "eq", pageId).done();



		PageType pageType = loadPageType(userContext, pageTypeId, loadTokens);

		synchronized(pageType){
			//Will be good when the pageType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//pageType.removePage( page );
			//make changes to AcceleraterAccount.
			Page pageIndex = createIndexedPage(pageId, pageVersion);

			Page page = pageType.findThePage(pageIndex);
			if(page == null){
				throw new PageTypeManagerException(page+" is NOT FOUND" );
			}

			page.changeProperty(property, newValueExpr);
			
			pageType = savePageType(userContext, pageType, tokens().withPageList().done());
			return present(userContext,pageType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(HisUserContext userContext, PageType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(HisUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(HisBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(HisUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(HisBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(HisUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(HisBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(HisUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(HisBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(HisUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		HisUserContextImpl userContext = (HisUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(HisUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(HisUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(HisUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(HisUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(HisUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   PageType newPageType = this.createPageType(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newPageType
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(HisUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, PageType.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(HisUserContext userContext,SmartList<PageType> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<MobileApp> mobileAppList = HisBaseUtils.collectReferencedObjectWithType(userContext, list, MobileApp.class);
		userContext.getDAOGroup().enhanceList(mobileAppList, MobileApp.class);


    }
	
	public Object listByMobileApp(HisUserContext userContext,String mobileAppId) throws Exception {
		return listPageByMobileApp(userContext, mobileAppId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByMobileApp(HisUserContext userContext,String mobileAppId, int start, int count) throws Exception {
		SmartList<PageType> list = pageTypeDaoOf(userContext).findPageTypeByMobileApp(mobileAppId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		HisCommonListOfViewPage page = new HisCommonListOfViewPage();
		page.setClassOfList(PageType.class);
		page.setContainerObject(MobileApp.withId(mobileAppId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("页面类型列表");
		page.setRequestName("listByMobileApp");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByMobileApp/%s/",  getBeanName(), mobileAppId)));

		page.assemblerContent(userContext, "listByMobileApp");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(HisUserContext userContext, String pageTypeId) throws Exception{
	  SerializeScope vscope = HisViewScope.getInstance().getPageTypeDetailScope().clone();
		PageType merchantObj = (PageType) this.view(userContext, pageTypeId);
    String merchantObjId = pageTypeId;
    String linkToUrl =	"pageTypeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "页面类型"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "ID")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "3-code")
				    .put("fieldName", "code")
				    .put("label", "编码")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("code", merchantObj.getCode());

		propList.add(
				MapUtil.put("id", "4-mobileApp")
				    .put("fieldName", "mobileApp")
				    .put("label", "手机应用程序")
				    .put("type", "object")
				    .put("displayField", "name")
				    .put("linkToUrl", "mobileAppManager/wxappview/:id/")
				    .into_map()
		);
		result.put("mobileApp", merchantObj.getMobileApp());

		propList.add(
				MapUtil.put("id", "5-footerTab")
				    .put("fieldName", "footerTab")
				    .put("label", "页脚选项卡")
				    .put("type", "text")
				    .put("displayField", "")
				    .put("linkToUrl", "")
				    .into_map()
		);
		result.put("footerTab", merchantObj.getFooterTab());

		//处理 sectionList

		//处理Section：pageListSection
		Map pageListSection = ListofUtils.buildSection(
		    "pageListSection",
		    "页面列表",
		    null,
		    "",
		    "__no_group",
		    "pageManager/listByPageType/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(pageListSection);

		result.put("pageListSection", ListofUtils.toShortList(merchantObj.getPageList(), "page"));
		vscope.field("pageListSection", HisListOfViewScope.getInstance()
					.getListOfViewScope( Page.class.getName(), null));

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}

}


