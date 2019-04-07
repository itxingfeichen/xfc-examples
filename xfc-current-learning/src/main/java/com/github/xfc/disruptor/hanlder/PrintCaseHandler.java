package com.github.xfc.disruptor.hanlder;

import com.github.xfc.model.CaseEvent;
import com.github.xfc.model.Task;
import com.lmax.disruptor.EventHandler;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author : chenxingfei
 * @date: 2019-04-07  22:45
 * @description: 订单号处理器
 */
public class PrintCaseHandler implements EventHandler<CaseEvent> {


    @Override
    public void onEvent(CaseEvent caseEvent, long l, boolean b) throws Exception {
        System.out.println(caseEvent);
    }
}
