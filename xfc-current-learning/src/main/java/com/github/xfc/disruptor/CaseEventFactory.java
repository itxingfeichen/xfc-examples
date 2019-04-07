package com.github.xfc.disruptor;

import com.github.xfc.model.CaseEvent;
import com.lmax.disruptor.EventFactory;

/**
 * @author : chenxingfei
 * @date: 2019-04-07  22:40
 * @description: 案件事件工厂
 */
public class CaseEventFactory implements EventFactory<CaseEvent> {

    @Override
    public CaseEvent newInstance() {
        return new CaseEvent();
    }
}
