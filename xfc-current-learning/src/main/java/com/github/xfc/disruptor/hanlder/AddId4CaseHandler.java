package com.github.xfc.disruptor.hanlder;

import com.github.xfc.model.CaseEvent;
import com.lmax.disruptor.EventHandler;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author : chenxingfei
 * @date: 2019-04-07  22:45
 * @description: 订单号处理器
 */
public class AddId4CaseHandler implements EventHandler<CaseEvent> {

    private AtomicLong atomicLong;

    public AddId4CaseHandler(AtomicLong atomicLong) {
        this.atomicLong = atomicLong;
    }

    @Override
    public void onEvent(CaseEvent caseEvent, long l, boolean b) throws Exception {
        caseEvent.setId(atomicLong.get());
    }
}
