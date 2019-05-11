package com.xfc.distributed.activemq.broker;

import org.apache.activemq.broker.BrokerService;

/**
 * @author : cxf
 * @date: 2019/5/11  16:38
 * @description: broker测试
 **/
public class CustomBroker {

    /**
     * 自定义的broker
     * @param args
     */
    public static void main(String[] args) {

        BrokerService brokerService = new BrokerService();
        try {
            brokerService.setUseJmx(true);
            brokerService.addConnector("tcp://localhost:16162");
            brokerService.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
