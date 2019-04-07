package com.github.xfc.disruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author : chenxingfei
 * @date: 2019-04-07  16:06
 * @description: disruptor学习
 */
public class DisruptorSimpleLearn {

    public static final Integer RINGBUFFERSIZE = 1024;

    private static final AtomicLong atomicLong = new AtomicLong(0);


    /**
     * 定义一个事件
     */
    @Data
    public static class CustomizeEvent {
        private String message;

        private Integer price;
    }

    /**
     * 构建事件工厂
     */
    public static class CustomizeEventFactory implements EventFactory<CustomizeEvent> {

        @Override
        public CustomizeEvent newInstance() {
            return new CustomizeEvent();
        }
    }

    /**
     * 自定义线程工厂
     */
    public static class CustomizeThreadFactory implements ThreadFactory {

        public static final AtomicInteger atomicInteger = new AtomicInteger(1);

        private final ThreadGroup group;

        public CustomizeThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            this.group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    "customize thread" + atomicInteger.getAndIncrement(),
                    0);
            return t;
        }
    }

    /**
     * 自定义事件处理器
     */
    public static class CustomizeEventHandler implements EventHandler<CustomizeEvent> {

        @Override
        public void onEvent(CustomizeEvent customizeEvent, long l, boolean b) throws Exception {
            customizeEvent.setPrice(new Random().nextInt(10));
            System.out.println("当前处理案件个数"+atomicLong.incrementAndGet());
            System.out.println("事件消费结果" + customizeEvent);
        }
    }

    /**
     * 消息转换器，负责将消息转化为事件
     */
    public static class CustomizeEventTrans implements EventTranslatorOneArg<CustomizeEvent, String> {

        @Override
        public void translateTo(CustomizeEvent customizeEvent, long l, String s) {
            customizeEvent.setMessage(s);
        }
    }

    /**
     * 自定义生产者
     */
    public static class CustomizeProducer {

        private RingBuffer<CustomizeEvent> ringBuffer;

        public CustomizeProducer(RingBuffer<CustomizeEvent> ringBuffer) {
            this.ringBuffer = ringBuffer;
        }

        /**
         * 生产消息
         */
        public void onData(String message) {
            ringBuffer.publishEvent(new CustomizeEventTrans(), message);
        }


    }


    /**
     * 测试disruptor
     *
     * @param args
     */
    public static void main(String[] args) {
        // 第一步，构建Disruptor对象
        Disruptor<CustomizeEvent> disruptor = new Disruptor<>(new CustomizeEventFactory(), RINGBUFFERSIZE, new CustomizeThreadFactory(), ProducerType.MULTI, new BlockingWaitStrategy());
        // 开始构建事件处理器
        disruptor.handleEventsWith(new CustomizeEventHandler());
        // 多个处理其以及多边形处理器单独测试
//        disruptor.handleEventsWith(new CustomizeEventHandler()).handleEventsWith(new CustomizeEventHandler());
        // 开启Disruptor
        RingBuffer<CustomizeEvent> ringBuffer = disruptor.start();

        Map<Integer, CustomizeProducer> map = new HashMap<>(16);
        for (int i = 0; i < 100; i++) {
            CustomizeProducer customizeProducer = new CustomizeProducer(ringBuffer);
            for (int i1 = 0; i1 < 1000; i1++) {
                customizeProducer.onData("hello disruptor " + i);
            }
            map.put(customizeProducer.hashCode(), customizeProducer);
        }
        // 打印map
        System.out.println(map.size() + "  " + map);

    }

}
