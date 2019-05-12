package com.xfc.distributed.kafka.producer;

import kafka.cluster.Partition;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * @author : chenxingfei
 * @date: 2019-05-12  21:06
 * @description:
 */
public class CustomPartition implements Partitioner {


    @Override
    public int partition(String s, Object o, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {

        //拿到主题下的分区个数
        //如果分区数不为3，那么可以进入到0号分区
        Integer count = cluster.partitionCountForTopic("secondar11");
        System.out.println("count = " + count);
//        String keyString = key.toString();
//        if (count == 3 && keyString != null) {
//            if (keyString.startsWith("156")) {//以156开头的手机号属于联通运营商，放入分区0
//                return 0;
//            } else if (keyString.startsWith("139")) {//以139开头的手机号属于移动运营商，放入分区1
//                return 1;
//            } else if (keyString.startsWith("133")) {//以133开头的手机号属于电信运营商，放入分区2
//                return 2;
//            }
//        }
        return 2;

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
