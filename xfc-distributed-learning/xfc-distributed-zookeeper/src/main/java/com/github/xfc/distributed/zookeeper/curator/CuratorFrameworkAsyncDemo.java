package com.github.xfc.distributed.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : chenxingfei
 * @date: 2019-05-03  10:14
 * @description: curator测试
 */
public class CuratorFrameworkAsyncDemo {

    private static final String connectString = "192.168.22.129:2181,192.168.22.130:2181,192.168.22.131:2181";


    public static void main(String[] args) throws Exception {

        CuratorFramework instance = CuratorFrameworkUtil.getInstance();
        // 异步创建，同理可进行异步更新等操作
        // String s = instance.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).inBackground().forPath("/inbackground", "异步创建".getBytes());

        ExecutorService executor = Executors.newFixedThreadPool(1);
        /*instance.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                System.out.println(Thread.currentThread().getName()+" :"+curatorEvent.getType());

            }
        }, executor).forPath("/inbackground1","123".getBytes());*/

        // 更新节点
        /*instance.setData().inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                System.out.println(Thread.currentThread().getName()+" :"+curatorEvent.getType());
            }
        },executor).forPath("/inbackground1","321".getBytes());*/

        // 删除操作
        instance.delete().inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                System.out.println(Thread.currentThread().getName() + " :" + curatorEvent.getType());
            }
        }, executor).forPath("/inbackground1");
        TimeUnit.SECONDS.sleep(5);
        executor.shutdown();

    }
}
