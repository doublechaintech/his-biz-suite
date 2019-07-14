
package com.doublechaintech.his.secuser;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import com.skynet.infrastructure.CacheService;
import com.skynet.infrastructure.ESClient;
import com.skynet.infrastructure.EventService;
import com.skynet.infrastructure.GraphService;
import com.skynet.infrastructure.SMTPService;
import com.skynet.infrastructure.MessageService;


import com.doublechaintech.his.HisUserContextImpl;
import com.doublechaintech.his.LoginForm;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.CommonError;
import com.doublechaintech.his.DAOGroup;
import com.doublechaintech.his.ManagerGroup;

import com.doublechaintech.his.UserContextImpl;
import com.doublechaintech.his.userapp.UserApp;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.userapp.*;
import com.doublechaintech.his.listaccess.*;
import com.doublechaintech.his.objectaccess.*;
import com.doublechaintech.his.HisChecker;
import com.doublechaintech.his.loginhistory.LoginHistory;
import com.doublechaintech.his.Message;



import com.terapico.uccaf.BaseUserContext;
import com.terapico.uccaf.UserContextProvider;
import com.terapico.caf.BeanFactory;
import com.terapico.utils.TextUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class CustomSecUserManagerImpl extends SecUserManagerImpl implements
        UserContextProvider {
       protected String environmentName;
    protected Boolean productEnvironment;
    protected DAOGroup daoGroup;
    protected ManagerGroup managerGroup;
    protected EventService eventService;
    protected String checkerBeanName = "checker";
    public String getCheckerBeanName() {
		return checkerBeanName;
	}
	public void setCheckerBeanName(String checkerBeanName) {
		this.checkerBeanName = checkerBeanName;
	}
    public EventService getEventService() {
        return eventService;
    }
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
    public String getEnvironmentName() {
        return environmentName;
    }
    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }
    public DAOGroup getDaoGroup() {
        return daoGroup;
    }
    public void setDaoGroup(DAOGroup daoGroup) {
        this.daoGroup = daoGroup;
    }
    public ManagerGroup getManagerGroup() {
        return managerGroup;
    }
    public void setManagerGroup(ManagerGroup managerGroup) {
        this.managerGroup = managerGroup;
    }
    public Boolean getProductEnvironment() {
        return productEnvironment;
    }

    public void setProductEnvironment(Boolean productEnvironment) {
        this.productEnvironment = productEnvironment;
    }
    
    public CustomSecUserManagerImpl() {
        // TODO Auto-generated constructor stub
    }
    
    public String confirmSession(HisUserContext userContext){
        SecUser user = cachedUser(userContext);
        if(user==null){
            return "FAIL";
        }
        return "OK";
    }
    
    public Object resetPassword(HisUserContext userContext, String mobile, int verifycationCode, String newPassword) {
        
        
        SecUser user;
        try {
            user = this.loadUserWith(userContext, "mobile", mobile);
            if(isVerificationCodeExpired(user)){
                return "VERIFIICATION_CODE_EXPIRED";
            }
            if(verifycationCode != user.getVerificationCode()){
                return "VERIFIICATION_CODE_NOT_MATCH";
            }

            String hasedPassword = this.hashStringWithSHA256(newPassword, user.getId());
            user.setPwd(hasedPassword);
            this.saveSecUser(userContext, user, SecUserTokens.withoutLists());
            return this.loginWithMobile(userContext, mobile, newPassword);
            
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return "FAIL";
        }
        
        //return this.getSecUserDAO().clone(fromSecUserId, this.allTokens());
    }
    
    public Object resetPasswordWithoutLogin(HisUserContext userContext, String loginType, String loginKey, int verifycationCode, String newPassword) {
        SecUser user;
        try {
            user = this.loadUserWith(userContext, loginType, loginKey);
            if(isVerificationCodeExpired(user)){
                return "VERIFIICATION_CODE_EXPIRED";
            }
            if(verifycationCode != user.getVerificationCode()){
                return "VERIFIICATION_CODE_NOT_MATCH";
            }

            // String hasedPassword = this.hashStringWithSHA256(newPassword, user.getId());
            user.updatePwd(newPassword);
            return this.saveSecUser(userContext, user, SecUserTokens.empty());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return "FAIL";
        }
    }
    
    protected boolean isVerificationCodeExpired(SecUser user) {
        // TODO Auto-generated method stub
        return false;
    }

    public Object selectApp(HisUserContext userContext,
            String appId) throws Exception {
        SecUser user = cachedUser(userContext);
        if(user==null){
            return errorLogin("对不起，你的会话过期，请重新登录");
        }
        List<UserApp> userApps = user.getUserAppList();
        for (UserApp app : userApps) {
            if (app.getId().equals(appId)) {
                
                
                return gotoApp(userContext,app);
            }
        }
        return user;
    }
    
    public SecUser manage(HisUserContext userContext) throws Exception{
        SecUser user = cachedUser(userContext);
        SecUser user2 = this.loadSecUser(userContext, user.getId(), this.allTokens());
        return this.present(userContext, user2, this.allTokens());
        
    }
    
    protected SecUser cachedUser(HisUserContext userContext)
    {
        return (SecUser)userContext.getCachedObject(this.getUserKey(userContext), SecUser.class);
    }
    
    public SecUser getCachedSecUser(HisUserContext userContext) {
		return cachedUser(userContext);
	}
    
    protected BaseEntity error(String message){
        BaseEntity entity = new CommonError();
        entity.addErrorMessage(message, null);
        return entity;
    }
    
   

    protected Object gotoApp(HisUserContext userContext, UserApp app) throws Exception {
        
        UserApp fullAppData = userContext.getDAOGroup().getUserAppDAO().load(app.getId(), UserAppTokens.all());
        userContext.putToCache(getCurrentAppKey(userContext), fullAppData, 1000000);
        // the app has all the accessable objects
        String targetBeanName = getBeanName( userContext,  app);
        if(targetBeanName == null){
            return error("targetBeanName is null");
        }
        Object targetObject = userContext.getBean(targetBeanName );
        if(targetObject == null){
            return error("targetObject is null");
        }

        String targetId = getTargetObjectId( userContext,  app);
        if(targetId == null){
            return error("targetId is null");
        }
        String serviceType = getServiceType( userContext,  app);
        if(serviceType == null){
            return error("serviceType is null");
        }
        String methodName = getMethodName( userContext,  app);
        if(methodName == null){
            return error("methodName is null");
        }
        
        ObjectAccess oa = findAppliedObjectAccess(fullAppData,serviceType);
        Map<String,Object > tokens =  packTokens(oa);
        

        userContext.addAccessTokens(tokens);
        //String 
        try {
            
            String className =ucClassNameOf(serviceType);
            return invokeWithOneString(userContext,targetBeanName,methodName,className,targetId);
        } catch (NoSuchMethodException e) {
            
            return error("NoSuchMethodException: "+ e.getMessage());
        } catch (SecurityException e) {
            
            return error("SecurityException: "+ e.getMessage());
        } catch (IllegalAccessException e) {
            
            return error("IllegalAccessException: "+ e.getMessage());
        } catch (IllegalArgumentException e) {
            
            return error("IllegalArgumentException: "+ e.getMessage());
        } catch (InvocationTargetException e) {
            
            return error("InvocationTargetException: "+ e.getTargetException().getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            return error("Exception1: "+ e.getMessage());
        }

    }
    
    
    public String showMessage(BaseUserContext baseUserContext){
        return "hello";
    }
    
    
    public String getVerificationCode(HisUserContext userContext,String mobile){
        
        try {
            SecUser user = this.loadUserWith(userContext, "mobile", mobile);
            int verificationCode = getRandomVerificationCode(userContext,6);
            user.setVerificationCode(verificationCode);
            user.setVerificationCodeExpire(userContext.now());
            /*
            userContext.sendEmail(
                    "philip_chang@163.com,kala.niubility@gmail.com", 
                    "verificationCode:"+verificationCode +" for "+mobile+"@"+userContext.now() , 
                    "verificationCode:"+verificationCode );
            
            */
            sendVerificationCode(userContext, mobile,verificationCode+"");
            
            
            this.saveSecUser(userContext, user, SecUserTokens.withoutLists());
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return "USER_NOT_FOUNT";
        }
        
        return "OK";
    }
    
    protected void sendVerificationCode(HisUserContext userContext, String mobile,String code) throws Exception{
        Map<String, String> parameters = new HashMap<String, String>();
        
        parameters.put("passcode", code);

        userContext.sendMessage("13880964614", "开心帮帮兔", "SMS_33585577", parameters);
    }
    
    protected int getRandomVerificationCode(HisUserContext userContex, int length){
        int base = (int)Math.pow(10, length-1);
        return base+(int)(9*base*Math.random());
        //like 100+900*random
        
        
    }
    public String showMessage2(BaseUserContext baseUserContext){
        return "hello";
    }
    protected String ucClassNameOf(String type){
        //com.skynet.scm;
        String packageName = "com.skynet.scm";
        return packageName +"."+type.toLowerCase()+"."+type+"UserContext";
        
    }
    
    protected String getBeanName(HisUserContext userContext, UserApp app){

        String target = app.getObjectType();
        String lowerCase = target.substring(0,1).toLowerCase()+target.substring(1);
        return lowerCase+"Manager";
        
    }
    protected String getTargetObjectId(HisUserContext userContext, UserApp app){
        
        return  app.getObjectId();
        
    }
    protected String getServiceType(HisUserContext userContext, UserApp app){
        
        return app.getObjectType();
    }
    protected String getMethodName(HisUserContext userContext, UserApp app){
        //return "load"+app.getObjectType()+"Detail";
        return "view";
    }

    
    
    public Object home(HisUserContext userContext) {
        SecUser user = (SecUser) userContext.getCachedObject(
                getUserKey(userContext), SecUser.class);
        if (user == null) {
            return showSessionExpired(userContext);
        }
        CustomSecUser customUser = new CustomSecUser();
        user.copyTo(customUser);
        return customUser;
    }

    public Object loginWithEmail(HisUserContext userContext, String email,
            String password) {

        return loginInternal(userContext,"email",email, password);
    
    }
    public Object login(HisUserContext userContext, String email,
            String password) {
		if (email.matches("1[3-9]\\d{9}")) {
    		return loginWithMobile(userContext, email, password);
    	}
        return loginInternal(userContext,"userId",email, password);
    
    }
    public Object loginWithLogin(HisUserContext userContext, String email,
            String password) {

        return loginInternal(userContext,"login",email, password);
    
    }
    public Object loginWithMobile(HisUserContext userContext, String email,
            String password) {
        return loginInternal(userContext,"mobile",email, password);
    
    }
    protected SecUser loadUserWith(HisUserContext userContext, String type, String userId) throws Exception{
        if("email".equals(type)){
            return this.loadSecUserWithEmail(userContext, userId, this.allTokens());
        }
        if("mobile".equals(type)){
            return this.loadSecUserWithMobile(userContext, userId, this.allTokens());
        }
        if("login".equals(type)){
            return this.loadSecUserWithLogin(userContext, userId, this.allTokens());
        }
        return this.loadSecUser(userContext, userId , this.allTokens());
    }
    // return a form or a user
    protected Object loginInternal(HisUserContext userContext, String type, String userId,
            String password) {

        try {
            SecUser user = this.loadUserWith(userContext, type, userId);
            
            String hashedPassed = this.hashStringWithSHA256(password, user.getId());
            log("hashed pass: "+ hashedPassed);
            log("stored pass: "+user.getPwd());
            
            if (!user.getPwd().equals(hashedPassed)) {
                this.addLoginHistory(userContext, user.getId(), userContext.getRemoteIP(), "密码错误", "x".split("."));
                return errorLogin("密码错了!");
            }
            
            return loginTheSecUserInternal(userContext, user, "成功登陆");
        } catch (SecUserNotFoundException e) {
            return errorLogin("对不起，不认识你");
        } catch (Exception e) {
            return errorLogin("对不起, 系统出错，跟你没关系哈，你等会再试下" + e.getMessage());
        }

    }
    /**
     * 内部登录。使用场景是当通过其他方式（微信，短信码等）验证了用户身份后，直接使用secUser对象登录。
     */
    protected Object loginTheSecUserInternal(HisUserContext userContext, SecUser user, String loginComments) throws Exception {
		// save it to Redis, then use it later
		Map<String, Object> tokens = new HashMap<String, Object>();
		tokens.put("userAppList", "userAppList");
		tokens.put("secUserList", "secUserList");
		tokens.put("objectAccessList", "objectAccessList");
		userContext.addAccessTokens(tokens);
	
		userContext.putToCache(getUserKey(userContext), user, 100000);
	
		CustomSecUser customUser = new CustomSecUser();
		user.copyTo(customUser);

		user.addLoginHistory(this.createLoginHistory(userContext, userContext.getRemoteIP(), TextUtil.firstChars(loginComments, 16)));
		user.setLastLoginTime(userContext.now());
		this.saveSecUser(userContext, user, this.allTokens());
	
		return customUser;
    }

    public Object showlogin(HisUserContext userContext) {
        
        userContext.removeFromCache(getUserKey(userContext));
        
        LoginForm form = new LoginForm();

        return form;

    }

    protected LoginForm showSessionExpired(HisUserContext userContext) {

        LoginForm form = new LoginForm();
        form.addErrorMessage("登录过期了", null);
        // form.addErrorMessage(errorMessage, null);
        return form;

    }

    private void log(String message) {
        System.out.println("Message: " + message);
    }

    protected LoginForm errorLogin(String errorMessage) {
        LoginForm form = new LoginForm();
        form.addErrorMessage(errorMessage, null);
        return form;
    }

    public BaseUserContext loadUserConext(HttpServletRequest request)
            throws Exception {
        String path = getRequestPath(request);
        HisUserContextImpl uc = createNewConext(path);
        init(uc, request);
        return uc;
    }

    private CacheService cacheService;

    public CacheService getCacheService() {
        return cacheService;
    }

    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }
    protected ESClient esClient;
    public ESClient getEsClient() {
        return esClient;
    }
    public void setEsClient(ESClient esClient) {
        this.esClient = esClient;
    }
    
    private SMTPService smtpService;

    public SMTPService getSmtpService() {
        return smtpService;
    }

    public void setSmtpService(SMTPService smtpService) {
        this.smtpService = smtpService;
    }
    
    private MessageService messageService;
    
    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    private GraphService graphService;

    public GraphService getGraphService() {
        return graphService;
    }

    public void setGraphService(GraphService graphService) {
        this.graphService = graphService;
    }

    protected String publicMediaServicePrefix;
    public String getPublicMediaServicePrefix() {
        return publicMediaServicePrefix;
    }
    public void setPublicMediaServicePrefix(String publicMediaServicePrefix) {
        this.publicMediaServicePrefix = publicMediaServicePrefix;
    }
    
    protected HisChecker checker;
    public HisChecker getChecker(){
        return checker;
    }
    
    public void setChecker(HisChecker checker){
        this.checker = checker;
    }
    
    protected void init(UserContextImpl userContext, HttpServletRequest request) {
        
        BeanFactory beanFactory = (BeanFactory)request.getAttribute("beanFactory");
        userContext.setProductEnvironment(getProductEnvironment());
        userContext.setEnvironmentName(getEnvironmentName());
        userContext.setBeanFactory(beanFactory);
        userContext.setRemoteIP(getRemoteIP(request));
        userContext.setCacheService(cacheService);
        userContext.setChecker((HisChecker)beanFactory.getBean(getCheckerBeanName()));
        userContext.setEsClient(esClient);
        userContext.setSmtpService(smtpService);
        userContext.setGraphService(graphService);
        userContext.setMessageService(messageService);
        userContext.setTokenId(request.getSession().getId());
        userContext.setUserAgent(request.getHeader("User-Agent"));
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
        	while(headerNames.hasMoreElements()) {
        		String name = headerNames.nextElement();
        		String value = request.getHeader(name);
        		userContext.putHeader(name, value);
        	}
        }
        userContext.setPublicMediaServicePrefix(getPublicMediaServicePrefix());
       
        userContext.setRequestParameters((Map)request.getParameterMap());
        userContext.setDaoGroup(getDaoGroup());
        userContext.setEventService(this.getEventService());
        userContext.setManagerGroup(getManagerGroup());
        // 原则上不要自己读取request的内容. 特殊情况下读取, 请注明原因. 以下为读取POST的body的例子.
		//        ServletInputStream ins;
		//        try {
		//        	if (request.getMethod().equalsIgnoreCase("post")) {
		//	            ins = request.getInputStream();
		//	
		//	            if (ins != null) {
		//	                if (ins.available() > 0) {
		//	                    System.out.println("input stream can read");
		//	                    ByteArrayOutputStream bout = new ByteArrayOutputStream();
		//	                    byte[] buff = new byte[1024];
		//	                    int n = 0;
		//	                    while ((n = ins.read(buff)) > 0) {
		//	                        bout.write(buff, 0, n);
		//	                    }
		//	
		//	                    userContext.setRequestBody(bout.toByteArray());
		//	                } else {
		//	                    System.out.println("input stream cannot read");
		//	                }
		//	            }
		//        	}
		//        } catch (IOException e) {
		//            e.printStackTrace();
		//        }
    }
    
    protected String getRemoteIP(HttpServletRequest request){
        String remoteHost = request.getHeader("X-Forwarded-For");
        if(remoteHost != null){
            return remoteHost;    
        }
        return request.getRemoteAddr();
    }


    protected String getRequestPath(HttpServletRequest request) {
        String path = request.getRequestURI().substring(request.getContextPath().length());
        return path;
    }

    protected HisUserContextImpl createNewConext(String path) {

        return new HisUserContextImpl();

    }

    public void saveUserContext(BaseUserContext uc) throws Exception {
        // TODO Auto-generated method stub
        
    }
    
    
    public Object checkOtherLogin(HisUserContext userContext) throws Exception {
    	
    	SecUser user = (SecUser) userContext.getCachedObject(
                getUserKey(userContext), SecUser.class);
    	//compare the user in db;
    	String tokens [] = SecUserTokens.start().withLoginHistoryList().sortLoginHistoryListWith(LoginHistory.LOGIN_TIME_PROPERTY, "desc").toArray();
    	
    	SecUser userInDB = userContext.getManagerGroup().getSecUserManager().loadSecUser(userContext, user.getId(), tokens);
    	if(user.getLastLoginTime().after(userInDB.getLastLoginTime())) {
    		//如果不一样，而且比缓存里面的用户更新一些
    		return "OK";
    	}
    	//如果标记为已经处理过了，则不显示消息。
    	String key = getUserKey(userContext)+":loginfromotherip";
    	String fromIp = userInDB.getLoginHistoryList().first().getFromIp();
    	String proceedIp = (String)userContext.getCachedObject(key, String.class);
    	if(fromIp.equals(proceedIp)) {
    		
    		return "PROCEED";
    	}

    	userContext.putToCache(key,fromIp , 86400);
    	return "有其他人用跟你同一个账号在"+fromIp+"登录";
    	//有其他人登录
    	
    	
    	
    }
    
    ////////////////////////////START OF THE CUSTOM IMPL FUNCITONS///////////////////////////////////
    
    boolean isOneOf(String value, String candiates[]) {
		for (String candidate : candiates) {
			if (value.equals(candidate)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
	
		if(methodName.startsWith("login")){
            return accessOK();
        }
        if(methodName.startsWith("show")){
            return accessOK();
        }
        if(methodName.startsWith("selectApp")){
            return accessOK();
        }
        if(methodName.startsWith("home")){
            return accessOK();
        }
        if(methodName.startsWith("resetPassForm")){
            return accessOK();
        }
        if(methodName.startsWith("verificationCodeForm")){
            return accessOK();
        }

		String managementAccessMethods[] = new String[] { "updateAppPermission","updateListAccess" ,"loadUserAppWithUser" ,"updateListAccess" };

		if(this.isOneOf(methodName, managementAccessMethods)) {
			
			
			
			return this.accessOK();
			
		}
		
		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	protected boolean isMe(UserApp app, String objectType, String objectId) {

		if (!app.getObjectType().equals(objectType)) {
			return false;
		}
		if (app.getObjectId().equals(objectId)) {
			return false;
		}
		return true;
	}

	protected void checkUserHasManagementAccess(HisUserContext userContext, String objectType, String objectId)
			throws SecUserManagerException {

		final String MANAGEMENT_TOKEN = "M";
		UserApp app = (UserApp) userContext.getCachedObject(this.getCurrentAppKey(userContext), UserApp.class);

		if (app == null) {
			userContext.log("app is null!");
			this.throwExceptionWithMessage("你没有管理该对象的权限，");
		}

		if (isMe(app, objectType, objectId)) {
			String permission = app.getPermission();
			if (permission.contains(MANAGEMENT_TOKEN)) {
				return; // has direct access
			}

		}
		// 不是本级权限，需要查询关系

		List<String[]> relations = userContext.relationBetween(objectType, objectId, app.getObjectType(),
				app.getObjectId());
		if (this.hasIndirectRight(userContext, app.getPermission(), MANAGEMENT_TOKEN, relations)) {
			return;
		}

		this.throwExceptionWithMessage("你没有管理该对象的权限，");

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Start Of privilege control
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	protected SecUserTokens buildLoadTokens(String objectType, String objectId) {
		SecUserTokens tokens = SecUserTokens.start().withUserAppList()
				.searchUserAppListWith(UserApp.OBJECT_TYPE_PROPERTY, "eq", objectType)
				.searchUserAppListWith(UserApp.OBJECT_ID_PROPERTY, "eq", objectId);

		return tokens;
	}

	public UserApp updateAppPermission(HisUserContext userContext, String secUserId, String userAppId, int version,
			String permission) throws Exception {

		String targetPermission = permission;
		return userContext.getManagerGroup().getUserAppManager().updateUserApp(userContext, userAppId, version,
				"permission", targetPermission, UserAppTokens.mergeAll(new String[] {}).toArray());

	}

	protected UserApp patchWithTokens(UserApp userApp, String tokensExpr, String displayName) {

		//this.checkUserHasManagementAccess(userContext, userApp.getObjectType(), userApp.getObjectId());
		
		
		for (ListAccess access : userApp.getListAccessList()) {
			resetListAccess(access);
		}

		if (tokensExpr == null) {
			return userApp;
		}
		String tokens[] = tokensExpr.split(",");

		for (String token : tokens) {

			String keyValuePair[] = token.split("\\.");
			if (keyValuePair.length < 2) {
				continue;
			}
			String key = keyValuePair[0];
			ListAccess access = searchOrCreateListAccess(userApp, key);
			access.updateName(displayName);
			String value = keyValuePair[1];
			eval(access, value);

		}

		return userApp;

	}

	protected void resetListAccess(ListAccess access) {
		// TODO Auto-generated method stub
		access.updateReadPermission(false);
		access.updateCreatePermission(false);
		access.updateUpdatePermission(false);
		access.updateDeletePermission(false);
		access.updateExecutionPermission(false);

	}

	protected ListAccess eval(ListAccess access, String value) {
		// 其他的情况不改
		if (value.endsWith("Permission")) {
			access.changeProperty(value, "true");
		}

		return access;

	}

	protected ListAccess searchOrCreateListAccess(UserApp userApp, String key) {

		for (ListAccess access : userApp.getListAccessList()) {
			if (access.getInternalName().equals(key)) {
				return access;
			}
		}
		ListAccess listAccess = new ListAccess();
		listAccess.setInternalName(key);
		userApp.addListAccess(listAccess);

		return listAccess;
	}

	public UserApp updateListAccess(HisUserContext userContext, String secUserId, String userAppId, String displayName,
			String permissionTokens) throws Exception {
		
		UserAppTokens token = UserAppTokens.start().withListAccessList();

		UserApp userApp = userContext.getManagerGroup().getUserAppManager().loadUserApp(userContext, userAppId,
				token.toArray());

		this.checkUserHasManagementAccess(userContext, userApp.getObjectType(), userApp.getObjectId());
		
		this.patchWithTokens(userApp, permissionTokens, displayName);

		return userContext.getManagerGroup().getUserAppManager().internalSaveUserApp(userContext, userApp,
				token.done());

	}

	public UserApp loadUserAppWithUser(HisUserContext userContext, String secUserId, String objectType,
			String objectId, String title, String appIcon) throws Exception {

		
		userContext.getChecker()
			.checkIdOfSecUser(secUserId)
			.checkObjectTypeOfUserApp(objectType)
			.checkObjectIdOfUserApp(objectId)
			.throwExceptionIfHasErrors(SecUserManagerException.class);

		this.checkUserHasManagementAccess(userContext, objectType, objectId);
		
		SecUser secUser = this.loadSecUser(userContext, secUserId, buildLoadTokens(objectType, objectId).done());

		if (secUser.getUserAppList().isEmpty()) {

			UserApp newApp = new UserApp();

			newApp.updateTitle(title).updateAppIcon(appIcon).updateObjectType(objectType).updateObjectId(objectId)
					.updateFullAccess(true).updateLocation("nolink");

			secUser.addUserApp(newApp);
			this.saveSecUser(userContext, secUser, this.tokens().withUserAppList().done());

			return newApp;
		}

		UserApp userApp = secUser.getUserAppList().first();

		UserAppTokens token = UserAppTokens.start().withListAccessList();

		UserApp userAppInDB = userContext.getManagerGroup().getUserAppManager().loadUserApp(userContext,
				userApp.getId(), token.toArray());

		return userAppInDB;

	}
    
    public Object changeCurUserPassword(HisUserContext userContext, String currentPassword, String newPassword)
			throws Exception {
		SecUser curUser = cachedUser(userContext);
		
		if(curUser==null) {
			this.throwExceptionWithMessage("修改密码之前必须登录，如果当前您已经登录，请退出后再试");
		}
		
		
		curUser = this.loadSecUser(userContext, curUser.getId(), new String[] {});
		
		String hasedPassword = this.hashStringWithSHA256(currentPassword, curUser.getId());
		
		if (!hasedPassword.equals(curUser.getPwd())) {
			throw new SecUserManagerException("当前密码输入错误, 请重新输入");
		}
		String newHasedPassword = this.hashStringWithSHA256(newPassword, curUser.getId());
		curUser.updatePwd(newPassword);
		this.saveSecUser(userContext, curUser, SecUserTokens.withoutLists());
		return "OK";
	}
	
	public String testIfHasManagementAccess(HisUserContext userContext,String objectType,String objectId) {
		try {
			this.checkUserHasManagementAccess(userContext, objectType, objectId);
			return "OK";
		}catch(Exception e){
			return "FAIL";
		}
		
	}
    

}












