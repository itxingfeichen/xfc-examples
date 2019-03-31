package com.github.xfc.current;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : chenxingfei
 * @date: 2019-03-31  19:53
 * @description: 使用wait和notify实现队列测试
 */
public class WaitAndNotifyQueue {


    /**
     * 1：构建一个储存数据的容器
     */
    private final List<Object> datas = new ArrayList<>();

    /**
     * 容器数据大小计数器
     */
    private final AtomicInteger count = new AtomicInteger(0);

    /**
     * 2：构建队列的最小长度（默认为0）
     */
    private final Integer minLength = 0;

    /**
     * 3：构建队列的最大长度
     */
    private final Integer maxLength;

    /**
     * 通过构造函数初始化（初始化是需要制定最大长度）
     */
    public WaitAndNotifyQueue(Integer maxLength) {
        if (maxLength < 1) {
            throw new IllegalArgumentException("maxLength invalid");
        }
        this.maxLength = maxLength;
    }

    /**
     * 提供put方法
     *
     * @param object
     */
    public void put(Object object) {
        synchronized (this) {
            if (count.get() == this.maxLength) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 添加数据
            datas.add(object);
            // 计数器加1
            count.incrementAndGet();
            // 唤醒线程
            this.notify();

        }

    }

    /**
     * 从队列中获取一个元素
     *
     * @return
     */
    public Object take() {
        Object ret = null;
        synchronized (this) {
            if (count.get() <= minLength) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ret = datas.get(0);
            datas.remove(ret);
            count.decrementAndGet();
            this.notify();
            return ret;
        }

    }

    /**
     * 返回所有元素
     *
     * @return
     */
    public List<Object> getAllElement() {

        return datas;
    }

}
