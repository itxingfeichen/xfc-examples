package com.github.xfc.model;

import lombok.Data;

/**
 * @author : chenxingfei
 * @date: 2019-04-07  22:37
 * @description: 案件处理事件
 */
@Data
public class CaseEvent {

    private String orderNo;
    private Double modelScore;
    private Long id;
    private String customerName;
    private Long customerId;
    private Task task;
    private Long eventId;

}
