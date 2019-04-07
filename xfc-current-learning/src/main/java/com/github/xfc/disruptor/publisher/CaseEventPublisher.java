package com.github.xfc.disruptor.publisher;

import com.github.xfc.model.CaseEvent;
import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author : chenxingfei
 * @date: 2019-04-07  22:58
 * @description: 案件发布
 */
public class CaseEventPublisher implements Runnable {

    private static final Long TASK_COUNT = 100L;

    /**
     * 传入disruptor
     */

    private Disruptor<CaseEvent> disruptor;

    /**
     * 传入线程计数器
     */
    private CountDownLatch countDownLatch;

    private AtomicLong atomicLong;



    public CaseEventPublisher(Disruptor<CaseEvent> disruptor, CountDownLatch countDownLatch,AtomicLong atomicLong) {
        this.disruptor = disruptor;
        this.countDownLatch = countDownLatch;
        this.atomicLong = atomicLong;
    }

    @Override
    public void run() {
        CaseEventTrans caseEventTrans = new CaseEventTrans();
        for (int i = 0; i < TASK_COUNT; i++) {
            atomicLong.incrementAndGet();
            disruptor.publishEvent(caseEventTrans);
        }
        countDownLatch.countDown();
    }


    public static class CaseEventTrans implements EventTranslator<CaseEvent> {

        private Random random = new Random();

        @Override
        public void translateTo(CaseEvent caseEvent, long l) {
            caseEvent.setEventId(Long.valueOf(random.nextInt(999)));
        }
    }
}
