package com.github.xfc.distributed.zookeeper.curator;

import org.apache.curator.CuratorZookeeperClient;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.GetChildrenBuilder;
import org.apache.curator.retry.RetryOneTime;

import java.util.concurrent.TimeUnit;

/**
 * @author : chenxingfei
 * @date: 2019-05-03  10:14
 * @description: curator测试
 */
public class CuratorFrameworkDemo {

    private static final String connectString = "192.168.22.129:2181,192.168.22.130:2181,192.168.22.131:2181";


    public static void main(String[] args) throws InterruptedException {

        /**
         * 创建会话的两种方式（方式一）
         */
        // 构造curator实例子
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(connectString, 5000, 5000, new RetryOneTime(1000));
        // 启动连接
        curatorFramework.start();

        /**
         * 创建会话的两种方式，fluent风格编码（方式二）
         */
        CuratorFramework curatorFrameworkNew = CuratorFrameworkFactory.builder().connectString(connectString).sessionTimeoutMs(5000).connectionTimeoutMs(5000).retryPolicy(new RetryOneTime(1000)).namespace("/curator").build();
        curatorFrameworkNew.start();

        System.out.println("started");
    }
}
