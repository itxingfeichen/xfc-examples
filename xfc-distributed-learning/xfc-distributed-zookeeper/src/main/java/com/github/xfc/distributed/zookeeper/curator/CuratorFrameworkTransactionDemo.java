package com.github.xfc.distributed.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;

/**
 * @author : chenxingfei
 * @date: 2019-05-03  10:14
 * @description: curator测试
 */
public class CuratorFrameworkTransactionDemo {

    private static final String connectString = "192.168.22.129:2181,192.168.22.130:2181,192.168.22.131:2181";


    public static void main(String[] args) throws Exception {

        CuratorFramework instance = CuratorFrameworkUtil.getInstance();
        // 事务失败演示，结果分析，事务失败，transaction节点也回滚,与预期一致
        /*instance.inTransaction().create().withMode(CreateMode.PERSISTENT).forPath("/transaction","123".getBytes())
                .and().setData().forPath("/xxx","333".getBytes()).and().commit();*/

        // 事务失败演示，结果分析，事务成功，inbackground1节点数据修改,与预期一致
        instance.inTransaction().create().withMode(CreateMode.PERSISTENT).forPath("/transaction", "123".getBytes())
                .and().setData().forPath("/inbackground", "333".getBytes()).and().commit();

    }
}
