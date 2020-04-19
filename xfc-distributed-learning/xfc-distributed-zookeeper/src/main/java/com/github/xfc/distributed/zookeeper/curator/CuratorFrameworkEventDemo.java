package com.github.xfc.distributed.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.TimeUnit;

/**
 * @author : chenxingfei
 * @date: 2019-05-03  10:14
 * @description: curator测试(待完善)
 */
public class CuratorFrameworkEventDemo {

    private static final String connectString = "192.168.22.129:2181,192.168.22.130:2181,192.168.22.131:2181";


    /**
     * +   pathCache 监视一个路径下子节点的创建，删除，更新
     * +   NodeCache 监听一个节点的创建，更新，删除
     * +   TreeCache pachcache+nodecache合体（监视路径下的创建，更新，删除事件）
     * +   缓存路径下的所有子节点的数据
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        CuratorFramework instance = CuratorFrameworkUtil.getInstance();

        /*NodeCache cache = new NodeCache(instance, "/inbackground", true);

        cache.start();

        cache.getListenable().addListener(() -> {
            System.out.println("监听节点数据变化，变化后的结果" + new String(cache.getCurrentData().getData()));
        });

        instance.setData().forPath("/inbackground", "测试1".getBytes());

        Thread.sleep(5000L);*/


        PathChildrenCache childrenCache = new PathChildrenCache(instance, "/inbackground", true);

        childrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);

        childrenCache.getListenable().addListener((x, y) -> {
            switch (y.getType()) {
                case CHILD_ADDED:
                    System.out.println("CHILD_ADDED  " + x.getData().toString());
                    break;
                case INITIALIZED:
                    System.out.println("INITIALIZED  " + x.getData().toString());
                    break;
                case CHILD_REMOVED:
                    System.out.println("CHILD_REMOVED  " + x.getData().toString());
                    break;
                case CHILD_UPDATED:
                    System.out.println("CHILD_UPDATED  " + x.getData().toString());
                    break;
                case CONNECTION_LOST:
                    System.out.println("CONNECTION_LOST  " + x.getData().toString());
                    break;
                case CONNECTION_RECONNECTED:
                    System.out.println("CONNECTION_RECONNECTED  " + x.getData().toString());
                    break;
                case CONNECTION_SUSPENDED:
                    System.out.println("CONNECTION_SUSPENDED  " + x.getData().toString());
                    break;
                default:
                    break;
            }

        });

        instance.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/event", "123".getBytes());
        TimeUnit.SECONDS.sleep(1);

        instance.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/event/event11", "123".getBytes());
        TimeUnit.SECONDS.sleep(1);

        instance.delete().deletingChildrenIfNeeded().forPath("/event/event11");
        TimeUnit.SECONDS.sleep(1);

        System.in.read();

    }
}
