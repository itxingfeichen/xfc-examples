package com.github.xfc.distributed.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * @author : chenxingfei
 * @date: 2019-05-03  10:14
 * @description: curator测试
 */
public class CuratorFrameworkDemo1 {

    private static final String connectString = "192.168.22.129:2181,192.168.22.130:2181,192.168.22.131:2181";


    public static void main(String[] args) throws Exception {

        CuratorFramework instance = CuratorFrameworkUtil.getInstance();
        // 创建节点(默认持久化节点)
        // instance.create().creatingParentsIfNeeded().forPath("/node","123".getBytes());

        // 创建临时节点
        // instance.create().creatingParentContainersIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/node2");
        // 更新
        // Stat stat = instance.setData().forPath("/node", "321".getBytes());
        // System.out.println(stat);

        // 删除节点
        //  instance.delete().deletingChildrenIfNeeded().forPath("/node");


    }
}
