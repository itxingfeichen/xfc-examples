package com.xfc.redis.pubsub.pub;

import com.xfc.redis.pubsub.model.Event;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis发布测试类
 *
 * @author xf.chen
 * @date 2021/7/27 3:01 下午
 * @since 1.0.0
 */
@RestController
public class RedisPublishController {

    private final RedisTemplate<String, Object> redisTemplate;


    public RedisPublishController(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @RequestMapping("/testPublish")
    public void publish() {
        System.out.println("执行发布");
        final Event event = new Event();
        event.setEventId("1");
        event.setEventName("chenxingfei");
        event.setMsg("Hello, xfc");
        redisTemplate.convertAndSend("channel1", event);
        redisTemplate.convertAndSend("channel2", event);
    }
}

