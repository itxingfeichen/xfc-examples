package com.github.xfc.disruptor;

import com.github.xfc.disruptor.hanlder.AddCustomerName4CaseHandler;
import com.github.xfc.disruptor.hanlder.AddId4CaseHandler;
import com.github.xfc.disruptor.hanlder.PrintCaseHandler;
import com.github.xfc.disruptor.publisher.CaseEventPublisher;
import com.github.xfc.model.CaseEvent;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author : chenxingfei
 * @date: 2019-04-07  22:28
 * @description: 多个消费者处理器
 */
public class ManyHandlerLearn {

    private static final int BUFFER_SIZE = 1024;

    private static final AtomicLong atomicLong = new AtomicLong(1);


    /**
     * 测试多个消费者
     *
     * @param args
     */
    public static void main(String[] args) {
        // 初始化
        Disruptor<CaseEvent> disruptor = new Disruptor<>(new CaseEventFactory(), BUFFER_SIZE, new DisruptorSimpleLearn.CustomizeThreadFactory(), ProducerType.SINGLE, new YieldingWaitStrategy());

        // 菱形操作，增加完customerName和id然后最后一个处理器由内部类实现
        disruptor.handleEventsWith(new AddCustomerName4CaseHandler(atomicLong), new AddId4CaseHandler(atomicLong)).then(new PrintCaseHandler());
        // 启动disruptor
        disruptor.start();

        // 开始生产任务
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CountDownLatch countDown = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            CaseEventPublisher caseEventPublisher = new CaseEventPublisher(disruptor, countDown,atomicLong);
            executorService.submit(caseEventPublisher);
        }
        try {
            countDown.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        disruptor.shutdown();


    }
}
