package com.github.xfc.disruptor;

import com.github.xfc.disruptor.hanlder.*;
import com.github.xfc.disruptor.publisher.CaseEventPublisher;
import com.github.xfc.model.CaseEvent;
import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.time.Year;
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

    private static final AtomicLong atomicLong = new AtomicLong(0);


    /**
     * 测试多个消费者
     *
     * @param args
     */
    public static void main(String[] args) {
        // 初始化
        Disruptor<CaseEvent> disruptor = new Disruptor<>(new CaseEventFactory(), BUFFER_SIZE, new DisruptorSimpleLearn.CustomizeThreadFactory(), ProducerType.SINGLE, new YieldingWaitStrategy());

        // 菱形操作，增加完customerName和id然后最后一个处理器由内部类实现
        // disruptor.handleEventsWith(new AddCustomerName4CaseHandler(atomicLong), new AddId4CaseHandler(atomicLong)).then(new PrintCaseHandler());
        // 顺序操作
//        disruptor.handleEventsWith(new AddCustomerName4CaseHandler(atomicLong)).handleEventsWith(new AddId4CaseHandler(atomicLong)).handleEventsWith(new PrintCaseHandler());
        // 六边形操作
        AddCustomerName4CaseHandler addCustomerName4CaseHandler = new AddCustomerName4CaseHandler(atomicLong);
        AddId4CaseHandler addId4CaseHandler = new AddId4CaseHandler(atomicLong);
        disruptor.handleEventsWith(addCustomerName4CaseHandler, addId4CaseHandler);


        AddTask4CaseHandler addTask4CaseHandler = new AddTask4CaseHandler(atomicLong);
        disruptor.after(addCustomerName4CaseHandler).handleEventsWith(addTask4CaseHandler);


        AddOrderNo4CaseHandler addOrderNo4CaseHandler = new AddOrderNo4CaseHandler(atomicLong);
        disruptor.after(addId4CaseHandler).handleEventsWith(addOrderNo4CaseHandler);


//        AddModelScore4CaseHandler addModelScore4CaseHandler = new AddModelScore4CaseHandler(atomicLong);
//        disruptor.after(addOrderNo4CaseHandler).handleEventsWith(addModelScore4CaseHandler);


        disruptor.after(addOrderNo4CaseHandler,addTask4CaseHandler).handleEventsWith(new PrintCaseHandler());

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
