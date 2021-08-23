package com.xfc.kafka.model;

import lombok.Data;

/**
 * model
 *
 * @author xf.chen
 * @date 2021/8/21 15:04
 * @since 1.0.0
 */
@Data
public class Order {


    private Integer orderId;

    public Order(int i, int i1, int i2, double v) {
        this.orderId = i;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
