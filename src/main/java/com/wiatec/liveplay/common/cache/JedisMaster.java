package com.wiatec.liveplay.common.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.wiatec.liveplay.common.result.EnumResult;
import com.wiatec.liveplay.common.result.XException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;


/**
 * @author patrick
 */
public class JedisMaster {

    private final Logger logger = LoggerFactory.getLogger(JedisMaster.class);

    private volatile static JedisPool jedisPool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMinIdle(50);
        config.setMaxIdle(3000);
        config.setMaxWaitMillis(5000);
        jedisPool = new JedisPool(config,"localhost", 6379);
    }

    private JedisMaster(){

    }

    private volatile static JedisMaster instance;
    public static synchronized JedisMaster getInstance(){
        if(instance == null){
            synchronized (JedisMaster.class){
                if(instance == null){
                    instance =  new JedisMaster();
                }
            }
        }
        return instance;
    }


    public <T> boolean set(String key, Class<T> clasz, T t){
        return setex(key, clasz, t, 0);
    }

    public <T> boolean setex(String key, Class<T> clasz, T t){
        return setex(key, clasz, t, 3600);
    }

    public <T> boolean setex(String key, Class<T> clasz, T t, int timeout){
        logger.debug("jedis set: {}", key, t);
        Jedis jedis = null;
        RuntimeSchema<T> schema = RuntimeSchema.createFrom(clasz);
        try{
            jedis = jedisPool.getResource();
            byte[] bytes = ProtostuffIOUtil.toByteArray(t, schema,
                    LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
            String s;
            if(timeout <= 0){
                s = jedis.set(key.getBytes(), bytes);
            }else {
                s = jedis.setex(key.getBytes(), timeout, bytes);
            }
            return "ok".equalsIgnoreCase(s);
        }catch (XException e){
            logger.error("XException: ", e);
            throw new XException(e.getCode(), e.getMessage());
        }catch (Exception e){
            logger.error("Exception: ", e);
            throw new XException(EnumResult.ERROR_SERVER_EXCEPTION);
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    public <T> T get(String key, Class<T> clasz){
        logger.debug("jedis get: {}", key);
        Jedis jedis = null;
        RuntimeSchema<T> schema = RuntimeSchema.createFrom(clasz);
        try{
            jedis = jedisPool.getResource();
            byte[] bytes = jedis.get(key.getBytes());
            if(bytes == null) {
                return null;
            }
            T t = schema.newMessage();
            ProtostuffIOUtil.mergeFrom(bytes, t, schema);
            return t;
        }catch (XException e){
            logger.error("XException: ", e);
            throw new XException(e.getCode(), e.getMessage());
        }catch (Exception e){
            logger.error("Exception: ", e);
            throw new XException(EnumResult.ERROR_SERVER_EXCEPTION);
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    public <T> boolean setList(String key, List<T> t, int timeout){
        logger.debug("jedis set: {}", key, t.toString());
        Jedis jedis = null;
        RuntimeSchema<CacheList> schema = RuntimeSchema.createFrom(CacheList.class);
        CacheList<T> cacheList = new CacheList<>(t);
        try{
            jedis = jedisPool.getResource();
            byte[] bytes = ProtostuffIOUtil.toByteArray(cacheList, schema,
                    LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
            String s;
            if(timeout <= 0){
                s = jedis.set(key.getBytes(), bytes);
            }else {
                s = jedis.setex(key.getBytes(), timeout, bytes);
            }
            return "OK".equalsIgnoreCase(s);
        }catch (XException e){
            logger.error("XException: ", e);
            throw new XException(e.getCode(), e.getMessage());
        }catch (Exception e){
            logger.error("Exception: ", e);
            throw new XException(EnumResult.ERROR_SERVER_EXCEPTION);
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    public <T> List<T> getList(String key, Class<T> tClass){
        logger.debug("jedis get: {}", key);
        Jedis jedis = null;
        RuntimeSchema<CacheList> schema = RuntimeSchema.createFrom(CacheList.class);
        try{
            jedis = jedisPool.getResource();
            byte[] bytes = jedis.get(key.getBytes());
            if(bytes == null) {
                return null;
            }
            CacheList<T> t = schema.newMessage();
            ProtostuffIOUtil.mergeFrom(bytes, t, schema);
            return t.getList();
        }catch (XException e){
            logger.error("XException: ", e);
            throw new XException(e.getCode(), e.getMessage());
        }catch (Exception e){
            logger.error("Exception: ", e);
            throw new XException(EnumResult.ERROR_SERVER_EXCEPTION);
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }
}
