package com.xfc.redis.pubsub.controller;

import com.xfc.redis.pubsub.model.RtsMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

/**
 * redis批量写入测试
 *
 * @author xf.chen
 * @date 2021/8/8 16:42
 * @since 1.0.0
 */
@RestController
@Slf4j
public class RedisBatchTestController {

    final String key = "batch:insert";


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private RtsMessage rtsMessageDelete = null;

    @GetMapping("/redis/batch")
    public Long batchInsert() {
        Collection redisBatchModels = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            final RtsMessage rtsMessage = new RtsMessage();
            rtsMessage.setMessageId(i);
            rtsMessage.setBusinessId("businessId" + i);
            rtsMessage.setCreateTime(System.currentTimeMillis());
            rtsMessage.setClientId("client" + i);
            rtsMessage.setDupCount(i);
            rtsMessage.setOverDue(System.currentTimeMillis());
            rtsMessage.setRecordId(UUID.randomUUID().toString());
            rtsMessage.setServerId("127.0.0.1");
            rtsMessage.setTopic("myTopic");
            rtsMessage.setMessageFlowId(i + "");
            rtsMessage.setRetain(true);

            if(i == 1000){
                rtsMessageDelete = rtsMessage;
            }
            redisBatchModels.add(rtsMessage);
        }
        final long start = System.currentTimeMillis();
        final Long all = redisTemplate.opsForList().leftPushAll(key, redisBatchModels);
        System.out.println(System.currentTimeMillis() - start);
        return all;
    }

    @GetMapping("/redis/searchCount")
    public Long searchCount() {
        return redisTemplate.opsForList().size(key);
    }

    @GetMapping("/redis/delete")
    public Long delete() {
        return redisTemplate.opsForList().remove(key, 1, rtsMessageDelete);
    }
}
