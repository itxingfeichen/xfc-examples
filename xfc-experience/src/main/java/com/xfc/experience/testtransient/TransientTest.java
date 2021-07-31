package com.xfc.experience.testtransient;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * transient测试
 *
 * @author xf.chen
 * @date 2021/7/30 23:34 下午
 * @since 1.0.0
 */
public class TransientTest {

    /**
     * 临时容器，模拟分布式缓存
     */
    private static final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {

        final TransientModel transientModel = new TransientModel();
        // id = 1
        transientModel.setId(transientModel.nextId());
        transientModel.setName("test" + transientModel.getId());
        final String jsonData = JSON.toJSONString(transientModel);
        queue.add(jsonData);

        // id =2
        transientModel.setId(transientModel.nextId());
        transientModel.setName("test" + transientModel.getId());
        final String jsonData1 = JSON.toJSONString(transientModel);
        queue.add(jsonData1);

        final String poll = queue.peek();
        // 反序列化
        final TransientModel transientModel1 = JSON.parseObject(poll, TransientModel.class);
        assert transientModel1 != null;
        // 这里应该期望是 id = 3
        transientModel1.setId(transientModel1.nextId());
        transientModel1.setName("test" + transientModel.getId());
        final String jsonData2 = JSON.toJSONString(transientModel1);
        queue.add(jsonData2);

        // 打印
        for (String s : queue) {
            System.out.println(s);
        }

    }
}
