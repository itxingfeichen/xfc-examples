package com.xfc.redis.pubsub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 内部消息转发
 *
 * @author xf.chen
 * @date 2021/3/31 10:21
 * @since 1.1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RtsMessage implements Serializable {
    /**
     * 业务ID
     */
    private String businessId;
    /**
     * 服务id
     */
    private String serverId;
    /**
     * kafka记录id，用于存储、分析
     *
     */
    private String recordId;
    /**
     * 消息流水id
     */
    private String messageFlowId;

    /**
     * 消息id
     */
    private Integer messageId;

    /**
     * 当前客户id
     */
    private String clientId;

    /**
     * topic
     */
    private String topic;

    /**
     * qos消息标记
     */
    private int mqttQoS = 1;

    /**
     * 数据
     */
    private String mqttBody;

    /**
     * 保留消息
     */
    private boolean retain = false;

    /**
     * 重发标记，默认不是重发
     */
    private boolean dup = false;

    /**
     * 重发次数
     */
    private Integer dupCount = 0;
    /**
     * 跨服务器标志
     */
    private boolean crossDomain = false;
    /**
     * 创建消息时间戳
     */
    private long createTime;

    /**
     *  逾期时间
     */
    private long overDue = 0;

}
