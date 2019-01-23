package com.auditoryworks.service;

import com.alibaba.fastjson.JSON;
import com.auditoryworks.domain.Message;
import com.auditoryworks.pool.RedisPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Date;

@Service
public class RedisService {

    public String user(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    public String getAasrInRedis(){
        Jedis jedis= RedisPool.getJedis();
        String json=jedis.rpop(user());
        if(json==null || json.equals("")){
            RedisPool.returnResource(jedis);
            return JSON.toJSONString(new Message(false,"当前无asr记录",new Date().getTime()));
        }else{
            RedisPool.returnResource(jedis);
            return json;
        }
    }
}