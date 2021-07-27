package com.xfc.redis.pubsub.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

/**
 * redis消息消费监听器
 *
 * @author xf.chen
 * @date 2021/7/27 3:07 下午
 * @since 1.0.0
 */
@Component
public class RedisMessageListener extends MessageListenerAdapter {

    /**
     * Standard Redis {@link MessageListener} entry point.
     * <p>
     * Delegates the message to the target listener method, with appropriate conversion of the message argument. In case
     * of an exception, the {@link #handleListenerException(Throwable)} method will be invoked.
     *
     * @param message the incoming Redis message
     * @param pattern
     * @see #handleListenerException
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("接收数据:"+message.toString());
        System.out.println("订阅频道:"+new String(message.getChannel()));
    }

}
