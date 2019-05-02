package com.github.xfc.distributed.zookeeper.zkclient;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author : chenxingfei
 * @date: 2019-05-02  20:27
 * @description: ZkClient是一个业界较为有名的zk客户端，底层封装了zk的原生操作api，便于使用
 */
public class ZkClientDemo {

    private static final String connectString = "192.168.22.129:2181,192.168.22.130:2181,192.168.22.131:2181";

    private static ZkClient zkClient;

    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    private static String nodeName = "/101etc";

    public static void main(String[] args) throws InterruptedException {
        zkClient = new ZkClient(connectString, 5000);
        subscribeDataChanges();
//        createNode();
        updateNode();
        TimeUnit.SECONDS.sleep(2);
        deleteNode();
        countDownLatch.await();
//        getChild();



    }

    /**
     * zkClient监听器
     */
    private static void subscribeDataChanges(){
        zkClient.subscribeDataChanges("/101etc/test101", new IZkDataListener() {
            /**
             * 数据改变监听
             * @param dataPath
             * @param data
             * @throws Exception
             */
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                countDownLatch.countDown();
                System.out.println("dataPath = [" + dataPath + "], data = [" + data + "]");
            }

            /**
             * 节点删除监听
             * @param dataPath
             * @throws Exception
             */
            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                countDownLatch.countDown();
                System.out.println("dataPath = [" + dataPath + "]");
            }
        });
    }


    /**
     * 创建节点
     */
    private static void createNode() {
        // 创建临时节点
//        zkClient.createEphemeral("/101etc","101tex".getBytes());
        // 创建持久化节点
//        zkClient.createPersistent("/101etc","101tex".getBytes());
        // 创建持久化的多层节点(查看源码，原生zk的api不支持一次性创建多级节点，101通过递归可以完成一次创建多级节点)
        zkClient.createPersistent("/101etc/test101", "101tex".getBytes());
        System.out.println("创建节点成功");
    }


    /**
     * 创建节点
     */
    private static void updateNode() {
        // 创建临时节点
//        zkClient.createEphemeral("/101etc","101tex".getBytes());
        zkClient.writeData("/101etc/test101", "101tex1".getBytes());
        System.out.println("更新节点成功");
    }


    /**
     * 删除节点
     */
    private static void deleteNode() {
        // 创建临时节点
//        zkClient.createEphemeral("/101etc","101tex".getBytes());
        zkClient.delete("/101etc/test101");
        System.out.println("删除节点成功");
    }


    /**
     * 获取指定的节点下的所有子节点
     *
     * @return
     */
    private static List<String> getChild() {
        List<String> children = zkClient.getChildren(nodeName);
        for (String child : children) {
            System.out.println("child = " + child);
        }
        System.out.println("获取子节点成功");
        return children;
    }
}
