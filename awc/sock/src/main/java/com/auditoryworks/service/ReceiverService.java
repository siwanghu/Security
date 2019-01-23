package com.auditoryworks.service;

import com.alibaba.fastjson.JSON;
import com.auditoryworks.domain.AsrMessage;
import com.auditoryworks.domain.MDMessage;
import com.auditoryworks.pool.RedisPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class ReceiverService {
    @Autowired
    MDService mdService;

    Jedis jedis;

    public ReceiverService(){
        jedis=RedisPool.getJedis();
    }

    public void receiveMessage(String json) {
        try {
            AsrMessage asrMessage = JSON.parseObject(json, AsrMessage.class);
            System.out.println(json);
            System.out.println(asrMessage);
            mdService.saveAsrMessage(new MDMessage(asrMessage.getDeviceId(),asrMessage.getSessionId(),asrMessage.getAngle(),
                    asrMessage.getTimestamp(),asrMessage.getUserName(),asrMessage.getContent()));
            jedis.lpush(asrMessage.getUserName(),json);
        }catch (Exception e){
            e.printStackTrace();
            RedisPool.returnResource(jedis);
        }
    }

    public String user(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }
}