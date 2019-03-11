package com.panfeng.his;

import java.util.List;
import java.util.Map;
import java.util.Date;
import com.skynet.infrastructure.ESClient;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.caf.DateTime;
public interface UserContext extends BaseUserContext{
	public DateTime now();
	public String currentUserName();
	public void log(String message);
	public String reportExecution();
	public void putToCache(String key, Object value, int timeToLiveInSeconds);	
	public void cacheUser(Object value);
	public Object userOf(Class<?> clazz);
	public Object getCachedObject(String key,Class<?> clazz);
	public void removeFromCache(String key);
	public void sendEmail(String to, String subject, String content) throws Exception;
	public String tokenId();
	public Object getBean(String beanName);
	public UserContext castTo(Class<UserContext> targetClass) throws Exception;
	public List<String[]> relationBetween(String sourceType,String sourceId,  String targetType, String targetId);
	public void addAccessTokens(Map<String, Object> tokens);
	public Map<String, Object> getAccessTokens();
	public String getRemoteIP();
	public String getUserAgent();
	public String getPublicMediaServicePrefix();
	public void setPublicMediaServicePrefix(String publicMediaServicePrefix);
	
	public void sendMessage(String dest, String fromWho, String template, Map<String,String>parameters) throws Exception;
	public void setEsClient(ESClient esClient);
	public ESClient getEsClient();
	public DAOGroup getDAOGroup();
	public ManagerGroup getManagerGroup();
	public Map<String, Object> getRequestParameters();
	public Map<String, Object> getContextLocalStorage();
	public Object getFromContextLocalStorage(String key);
	public void putIntoContextLocalStorage(String key, Object value);
	public void setContextLocalStorage(Map<String, Object> contextLocalStorage);
	public String getRequestHeader(String name);
	public void setResponseHeader(String name, String value);
	public String getResponseHeadder(String name);
	public void forceResponseXClassHeader(String clazzName);
}






