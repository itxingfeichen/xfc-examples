package com.github.xfc.disruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.ProducerType;
import lombok.Data;

import java.util.concurrent.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-07  21:04
 * @description: 通过ringBuffer实现
 */
public class RingBufferLearn {

    /**
     * ring buffer size
     */
    public static final Integer BUFFER_SIZE = 1024;

    /**
     * 定义事件
     */
    @Data
    public static class MessageEvent {

        private long price;
    }


    /**
     * 自定义事件
     */
    public static class MessageEventFactory implements EventFactory<MessageEvent> {
        @Override
        public MessageEvent newInstance() {
            return new MessageEvent();
        }
    }

    /**
     * 定义消息处理器
     */
    public static class MessageEventHandler implements EventHandler<MessageEvent> {

        @Override
        public void onEvent(MessageEvent messageEvent, long l, boolean b) throws Exception {
            System.out.println(messageEvent);
        }
    }

    /**
     * 测试通过ringbuffer实现
     *
     * @param args
     */
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        //YieldingWaitStrategy 的性能是最好的，适合用于低延迟的系统。在要求极高性能且事件处理线数小于CPU逻辑核心数的场景中，推荐使用此策略；例如，CPU开启超线程的特性
        // 创建ringBuffer
        RingBuffer<MessageEvent> ringBuffer = RingBuffer.create(ProducerType.SINGLE, new MessageEventFactory(), BUFFER_SIZE, new YieldingWaitStrategy());

        // 定义栏栅（用于协调生产者和消费者之间的消费速度）
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();

        // 创建消息处理器
        BatchEventProcessor<MessageEvent> eventProcessor = new BatchEventProcessor<>(ringBuffer, sequenceBarrier, new MessageEventHandler());

        // 将消费者的位置信息引用注入到生产者，如果只有一个消费者，则这一步可以省略
        ringBuffer.addGatingSequences(eventProcessor.getSequence());

        // 创建线程池，将消息处理器提交到线程池
        executorService.submit(eventProcessor);

        // 如果存在多个消费者，则重复执行如上3行代码

        // 开始生产数据
        Future<MessageEvent> eventFuture = executorService.submit((Callable<MessageEvent>) () -> {
            for (int i = 0; i < 100; i++) {
                long next = ringBuffer.next();
                System.out.println("ringbuffer槽=" + next);
                ringBuffer.get(next).setPrice((long) (Math.random() * 999));
                // 发布消息到位置为next的ringbuffer槽
                ringBuffer.publish(next);
            }
            return null;
        });
        try {
            eventFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 通知事件处理器可以结束了，并不是直接结束
        eventProcessor.halt();

        executorService.shutdown();

    }
}
