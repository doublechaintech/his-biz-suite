package com.panfeng.his;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.skynet.infrastructure.CacheService;
import com.skynet.infrastructure.ESClient;
import com.skynet.infrastructure.GraphService;
import com.skynet.infrastructure.EventService;
import com.skynet.infrastructure.SMTPService;
import com.terapico.caf.BeanFactory;
import com.terapico.caf.BlobObject;
import com.terapico.caf.InvocationResult;
import com.skynet.infrastructure.MessageService;
//Default implementation
public class UserContextImpl implements UserContext{
	protected CacheService cacheService;
	protected ESClient esClient;
	protected SMTPService smtpService;
	protected String remoteIP;
	protected String tokenId;
	protected String userAgent;
	protected BeanFactory beanFactory;
	protected String publicMediaServicePrefix;
	protected MessageService messageService;
	protected HisCheckerManager customCheckManager;
	protected Map<String, Object> requestParameters;
	protected Map<String, String> requestHeaders;
	protected Map<String, String> responseHeaders;
	protected Map<String, Object> contextLocalStorage;
	protected String assignedRenderingWay;
	protected byte[] requestBody;
	protected String environmentName;
    protected Boolean productEnvironment;
    protected DAOGroup daoGroup;
    protected ManagerGroup managerGroup;
    
    public Map<String, String> getResponseHeaders() {
		return responseHeaders;
	}
	public void setResponseHeaders(Map<String, String> responseHeaders) {
		this.responseHeaders = responseHeaders;
	}
    public DAOGroup getDAOGroup(){
    	return this.daoGroup;
    }
    public void setDaoGroup(DAOGroup daoGroup){
    	this.daoGroup = daoGroup;
    }
    
    public ManagerGroup getManagerGroup(){
    	return this.managerGroup;
    }
    public void setManagerGroup(ManagerGroup managerGroup){
    	this.managerGroup = managerGroup;
    }
    
    public String getEnvironmentName() {
        if (environmentName == null || environmentName.isEmpty()) {
            String name = System.getenv("SKY_ENVIRONMENT_NAME");
            if (name == null || name.isEmpty()) {
                return "dev_default";
            }
            return name;
        }
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    public boolean isProductEnvironment() {
        if (productEnvironment == null) {
            String name = System.getenv("SKY_ENVIRONMENT_NAME");
            if ("product".equals(name)) {
            	return true;
            }
            if (name == null) {
            	return false;
            }
            if (name.startsWith("product_")) {
            	return true;
            }
            return false;
        }
        return productEnvironment.booleanValue();
    }

    public void setProductEnvironment(Boolean productEnvironment) {
        this.productEnvironment = productEnvironment;
    }
    
	@Override
	public void assignRenderingWay(String renderingWay) {
		assignedRenderingWay = renderingWay;
	}

	@Override
	public String getAssignedRederingWay() {
		return assignedRenderingWay;
	}
	
	public byte[] getRequestBody() {
		return requestBody;
	}
	public void setRequestBody(byte[] requestBody) {
		this.requestBody = requestBody;
	}
	
	public Map<String, Object> getRequestParameters() {
		return requestParameters;
	}

	public void setRequestParameters(Map<String, Object> requestParameters) {
		this.requestParameters = requestParameters;
	}
	
	public Map<String, Object> getContextLocalStorage() {
		return contextLocalStorage;
	}

	public void setContextLocalStorage(Map<String, Object> contextLocalStorage) {
		this.contextLocalStorage = contextLocalStorage;
	}
	
	public ESClient getEsClient() {
		return esClient;
	}

	public void setEsClient(ESClient esClient) {
		this.esClient = esClient;
	}
	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	public String getPublicMediaServicePrefix() {
		return publicMediaServicePrefix;
	}

	public void setPublicMediaServicePrefix(String publicMediaServicePrefix) {
		this.publicMediaServicePrefix = publicMediaServicePrefix;
	}
	public HisCheckerManager getCustomCheckManager(){
		return customCheckManager;
	}
	public void setCustomCheckManager(HisCheckerManager customCheckManager){
		this.customCheckManager = customCheckManager;
	}
	
	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public String getRemoteIP() {
		return remoteIP;
	}

	public void setSmtpService(SMTPService smtpService) {
		this.smtpService = smtpService;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setCacheService(CacheService cacheService) {
		
		this.cacheService = cacheService;
	}
	
	public void putToCache(String key, Object value,int timeToLiveInSeconds){
		ensureCacheService();
		cacheService.put(key, value,timeToLiveInSeconds);
	}
	
	public void sendEmail(String to, String subject, String content) throws Exception{
		this.ensureSMTPService();
		smtpService.send(to, subject, content);
		
	}
	
	public void sendEmailWithAttachment(String to, String subject, String content, List<BlobObject> attachments) throws Exception{
		this.ensureSMTPService();
		smtpService.sendWithAttachment(to, subject, content, attachments);
	}
	
	public Object getCachedObject(String key,Class<?> clazz){
		ensureCacheService();
		return cacheService.get(key,clazz);
	}
	protected void ensureCacheService(){
		if(cacheService ==  null){
			throw new IllegalStateException("cacheService is not configured for a instance of UserContextImpl");
		}
	}
	protected void ensureSMTPService(){
		if(smtpService ==  null){
			throw new IllegalStateException("smtpService is not configured for a instance of UserContextImpl");
		}
	}
	
	public void setRemoteIP(String remoteAddr) {
		
		this.remoteIP = remoteAddr;
	}
	
	public void setTokenId(String id) {
		
		this.tokenId = id;
	}
	public String tokenId() {
		
		return this.tokenId;
	}
	public void setUserAgent(String userAgent) {
		
		this.userAgent = userAgent;
	}

	protected String timeExpr(){		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd'T'HH:mm:ss.SSS");
		//It is not thread safe, how silly the JDK is!!!
		return simpleDateFormat.format(new java.util.Date());
	}
	protected StringBuilder logBuffer ;
	
	protected void addLog(String message) {
		if(logBuffer==null) {
			logBuffer = new StringBuilder();
		}
		logBuffer.append(message);
		logBuffer.append("\n");
		
	}
	
	
	public String reportExecution() {
		
		if(logBuffer==null) {
			return "NO LOG";
		}
		return logBuffer.toString();
	}
	
	public void log(String message) {
		String logMessage = timeExpr()+": "+this.tokenId+"@"+this.remoteIP+": "+ message;
		addLog(logMessage);
		System.out.println(logMessage);		
	}
	protected Date getCurrentTime(){
		return new Date();//provide a way to shift the time for some use cases;
	}

	public void cacheUser(Object value) {
		
		this.putToCache(this.tokenId, value,1000);
	}

	public Object userOf(Class<?> clazz) {
		
		return this.getCachedObject(this.tokenId,clazz);
	}

	public void removeFromCache(String key) {
		
		ensureCacheService();
		cacheService.remove(key);
	}

	public Object getBean(String beanName) {
		if(getBeanFactory() == null){
			this.log("getBeanFactory() is not initialized");
			return null;
		}
		
		return getBeanFactory().getBean(beanName);
	}

	public UserContext castTo(Class<UserContext> targetClass) throws InstantiationException, IllegalAccessException {
		UserContextImpl newUserContext =(UserContextImpl) targetClass.newInstance();
		
		newUserContext.setBeanFactory(this.getBeanFactory());
		
		newUserContext.setCacheService(this.cacheService);
		newUserContext.setRemoteIP(this.getRemoteIP());
		newUserContext.setSmtpService(this.smtpService);
		newUserContext.setTokenId(this.tokenId());
		newUserContext.setUserAgent(this.userAgent);
		return newUserContext;
	}
	public void setGraphService(GraphService graphService) {
		this.graphService = graphService;
	}
    public GraphService getGraphService() {
        return graphService;
    }
	private GraphService graphService;
	private EventService eventService;
	public EventService getEventService() {
		return eventService;
	}
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	
	public List<String[]> relationBetween(String sourceType,String sourceId, 
			String targetType, String targetId) {
		
		if(graphService == null){
			throw new IllegalStateException("graphService must be configured");
		}
		return graphService.relationsOf(BaseManagerImpl.getSystemInternalName(), sourceType, sourceId, targetType, targetId);
		
	}
	
	private Map<String,Object> accessTokens;
	public void addAccessTokens(Map<String, Object> tokens) {
		// TODO Auto-generated method stub
		ensureAccessTokens();
		accessTokens.putAll(tokens);
	}
	protected void ensureAccessTokens(){
		if(accessTokens == null){
			accessTokens = new HashMap<String,Object>();
		}
	}
	public Map<String,Object> getAccessTokens(){
		ensureAccessTokens();
		return accessTokens;
	}
	
	public DateTime now() {
		// TODO Auto-generated method stub
		return DateTime.fromDate(new Date());
	}
	public String currentUserName() {
		// TODO Auto-generated method stub
		return "PhilipGreat";
	}
	@Override
	public void sendMessage(String dest, String fromWho, String template,
			Map<String, String> parameters) throws Exception {
		if(getMessageService() == null){
			throw new IllegalStateException("The message service is not configured before is can be used");
		}
		
		this.getMessageService().sendMessage(dest, fromWho, template, parameters);
		
	}
    @Override
    public void forceRenderingAsJson() {
        assignRenderingWay("json");
    }

    @Override
    public void forceRenderingAsHtml() {
        assignRenderingWay("html");
    }

    @Override
    public void forceRenderingAsJavaScript() {
        assignRenderingWay("javascript");
    }
    private String prefferedAppType;
    public void setPrefferedAppType(String prefferedAppType) {
		this.prefferedAppType = prefferedAppType;
	}
	
	@Override
    public Object getFromContextLocalStorage(String key) {
		ensureContextLocalStorage();
		return contextLocalStorage.get(key);
    }
    private void ensureContextLocalStorage() {
		if (contextLocalStorage == null) {
			contextLocalStorage = new HashMap<String, Object>();
		}
    }
    @Override
    public void putIntoContextLocalStorage(String key, Object value) {
		ensureContextLocalStorage();
		contextLocalStorage.put(key, value);
    }
    
    public Map<String, String> getRequestHeaders() {
		return requestHeaders;
	}
	public void setRequestHeaders(Map<String, String> requestHeaders) {
		this.requestHeaders = requestHeaders;
	}
	public void putHeader(String name, String value) {
		ensureHeaders();
		requestHeaders.put(name, value);
	}
	@Override
	public String getRequestHeader(String name) {
		ensureHeaders();
		return requestHeaders.get(name);
	}
	protected void ensureHeaders() {
		if (requestHeaders != null) {
			return;
		}
		requestHeaders = new HashMap<>();
	}
	protected void ensureResHeaders() {
		if (responseHeaders != null) {
			return;
		}
		responseHeaders = new HashMap<>();
	}
	@Override
	public void setResponseHeader(String name, String value) {
		ensureResHeaders();
		responseHeaders.put(name, value);
	}
	@Override
	public String getResponseHeadder(String name) {
		ensureResHeaders();
		return responseHeaders.get(name);
	}
	@Override
	public void forceResponseXClassHeader(String clazzName) {
		setResponseHeader("X-Class", clazzName);
	}
	
	public void setChecker(HisChecker checker) {
		//Let His do the job :)
		
	}
	
}
