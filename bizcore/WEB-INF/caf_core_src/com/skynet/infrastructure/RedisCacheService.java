package com.skynet.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisCacheService implements CacheService {
    private String host;
    private int port;
    private int timeout;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    protected Jedis getJedis() {
        Jedis jedis = new Jedis(host, port, timeout);
        if (StringUtils.isNotEmpty(password)) {
            jedis.auth(password);
        }
        return jedis;
    }

   

    protected ObjectMapper getMapper() {
       ObjectMapper mapper;
       mapper = new ObjectMapper();
       mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
       return mapper;
    }
    
    public Object[] mget(String keys[], Class<?>[] clazzes) {
        if (keys == null) {
            return new Object[0];
        }
        if (keys.length == 0) {
            return new Object[0];
        }
        // Ticker ticker = new Ticker();
        Jedis jedis = null;
        try {
            jedis = getJedis();
            log("class"+jedis.getClass());
            // ticker.tick("init getJedis();");

            List<String> values = jedis.mget(keys);
            if (values == null) {
                return null;
            }
            // ticker.tick("jedis.get(key);");
            ObjectMapper mapper = getMapper();
            // ticker.tick(" new ObjectMapper();");


            Object[] result = new Object[keys.length];
            for (int i = 0; i < keys.length; i++) {

                result[i] = mapper.readValue(values.get(i), clazzes[i]);
                // ticker.tick(" mapper.readValue(value,clazz);");

            }
            return result;

        } catch (Exception e) {
            return null;
        } finally {
        	closeConnection(jedis);
        }
        
    }

    public Object get(String key, Class<?> clazz) {
        // Ticker ticker = new Ticker();

        // log("getting " + clazz + " with key: " + key);
        Jedis jedis = null;
        try {
            jedis = getJedis();
            // ticker.tick("init getJedis();");
            String value = jedis.get(key);
            if (value == null) {
                log("getting " + clazz + " with key: " + key + " fail (null)");
                return null;
            }
            // ticker.tick("jedis.get(key);");
            ObjectMapper mapper = getMapper();
            // ticker.tick(" new ObjectMapper();");
            Object object = mapper.readValue(value, clazz);
            // ticker.tick(" mapper.readValue(value,clazz);");
            return object;

        } catch (Exception e) {
            log("getting " + clazz + " with key: " + key + " with an exception" + e.getMessage());
            return null;
        } finally {
        	closeConnection(jedis);
        }

    }

    private void log(String string) {
        System.out.println(string);
    }

    public void put(String key, Object value, int ttlInSeconds) {
        // Silly impl just for POC
        // Jedis jedis = new Jedis("localhost");
        // Ticker ticker = new Ticker();
        Jedis jedis = null;
        try {
            jedis = getJedis();
            // ticker.tick("init getJedis();");
            ObjectMapper mapper = getMapper();
            // ticker.tick(" new ObjectMapper();");
            String json = mapper.writeValueAsString(value);
            // ticker.tick("mapper.writeValueAsString(value)");
            jedis.set(key, json);
            if (ttlInSeconds >= 0) {
                jedis.expire(key, ttlInSeconds);
            }
            // ticker.tick("jedis.set(key, json);jedis.expire(key, ttlInSeconds);");

        } catch (JsonProcessingException e) {
            // is fine
        } finally {
        	closeConnection(jedis);
        }

    }
    protected void closeConnection(Jedis jedis) {
    	
    	if (jedis == null) {
            return;
        }
    	jedis.close();
    }
    public void remove(String key) {

        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.del(key);
        } finally {
        	closeConnection(jedis);
        }
    }


}
