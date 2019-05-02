package com.github.xfc.distributed.zookeeper.javaapi;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author : chenxingfei
 * @date: 2019-05-02  14:47
 * @description: zkjavaapi测试(NodeDelete监听未模拟出来)
 */
public class ZKJavaApi {

    private static final String connectString = "192.168.22.129:2181,192.168.22.130:2181,192.168.22.131:2181";

    private static ZooKeeper zooKeeper;
    private static Stat stat = new Stat();

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

        zooKeeper = new ZooKeeper(connectString, 5000, event -> {
            try {
                if (event.getState() == Watcher.Event.KeeperState.SyncConnected) {
                    Watcher.Event.EventType type = event.getType();
                    System.out.println(type);
                    switch (type) {
                        // 创建子节点时会被触发
                        case NodeCreated:
                            System.out.println("NodeCreated节点事件被触发");
                            System.out.println("NodeCreated节点创件被触发" + event.getPath());
                            break;
                        case None:
                            System.out.println("None节点事件被触发");
                            System.out.println("None节点事件被触发" + event.getPath());
                            break;
                        case NodeDeleted:
                            //子节点删除会触发
                            System.out.println("NodeDeleted节点事件被触发");
                            System.out.println("NodeDeleted节点事件被触发" + event.getPath());
                            break;
                        case NodeDataChanged:
                            System.out.println("NodeDataChanged节点事件被触发");
                            System.out.println("NodeDataChanged节点事件被触发" + zooKeeper.getData(event.getPath(), true, stat));
                            break;
                        case NodeChildrenChanged:
                            System.out.println("NodeChildrenChanged节点事件被触发");
                            System.out.println("NodeChildrenChanged节点事件被触发" + zooKeeper.getData(event.getPath(), true, stat));
                            break;
                        default:
                            break;
                    }
                }
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        TimeUnit.SECONDS.sleep(2);
        // state连接过程 not_connected-->connection-->connected-->close
        System.out.println(zooKeeper.getState());
//        deletePersistNode(zooKeeper);
        // 创建节点(临时节点)
//        createTempNode(zooKeeper);
//        Stat stat = zooKeeper.exists("/persistNode/node1/node2", true);
//        if (stat == null) {
//            createPersistNode(zooKeeper);
//            TimeUnit.SECONDS.sleep(1);
//        }
//        setData(zooKeeper);
//        setPersistData(zooKeeper);
//        TimeUnit.SECONDS.sleep(1);
//        deleteNode(zooKeeper);

//        TimeUnit.SECONDS.sleep(5);

        getChild(zooKeeper);


    }

    /**
     * 创建节点测试
     *
     * @param zooKeeper
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static String createTempNode(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        // 临时节点创建，临时节点的特点是会话结束，节点就会被清理，临时节点不能创建子节点
//        String result = zooKeeper.create("/xfc1", "data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        // 持久化节点创建
        String result = zooKeeper.create("/xfc1/node1", "data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zooKeeper.getData("/xfc1", true, new Stat());
        System.out.println("result = " + result);
        return result;
    }

    public static void setTempData(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {

        Stat stat = zooKeeper.setData("/xfc1/", "123".getBytes(), -1);
        System.out.println(stat);
        System.out.println("数据更新");

    }


    public static void deleteTempNode(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        zooKeeper.delete("/xfc1", -1);
        System.out.println("删除节点");

    }


    /**
     * 创建节点测试
     *
     * @param zooKeeper
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static String createPersistNode(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        // 持久化节点创建
        String result = zooKeeper.create("/persistNode/node1/node2", "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        byte[] data = zooKeeper.getData("/persistNode/node1", true, stat);
        String value = String.valueOf(data);
        System.out.println("value = " + value);
        return result;
    }

    /**
     * 持久化节点修改
     * @param zooKeeper
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static void setPersistData(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {

        Stat stat = zooKeeper.setData("/persistNode/node1", "321".getBytes(), -1);
        System.out.println(stat);
        System.out.println("数据更新");

    }

    /**
     * 持久化节点删除
     * @param zooKeeper
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static void deletePersistNode(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        zooKeeper.delete("/persistNode/node1/node2", -1);
        System.out.println("删除节点");

    }

    /**
     * 获取指定节点下的所有子节点
     * @param zooKeeper
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static void getChild(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {

        List<String> children = zooKeeper.getChildren("/persistNode", true);
        System.out.println(children);

    }
}
