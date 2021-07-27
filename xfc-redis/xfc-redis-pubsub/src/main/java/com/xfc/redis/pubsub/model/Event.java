package com.xfc.redis.pubsub.model;

import lombok.Data;

/**
 * redis被消费的事件
 *
 * @author xf.chen
 * @date 2021/7/27 3:03 下午
 * @since 1.0.0
 */
@Data
public class Event {

    private String eventId;

    private String eventName;

    private String msg;
}
