package com.xfc.distributed.dubbo.common;

import java.io.Serializable;

/**
 * @author : chenxingfei
 * @date: 2019-05-04  21:08
 * @description: 请求参数传输对象
 */
public class RequestDto implements Serializable {


    private String orderNo;

    private Long orderId;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
