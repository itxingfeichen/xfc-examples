package com.github.xfc.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenxingfei
 * @date: 2019-10-08  11:26
 * @description: 默认实现
 */
public class DefaultHandlerChain implements HandlerChain {

    List<HandlerChain> handlerChains = new ArrayList<>();


    public void addHandler(HandlerChain handlerChain) {
        handlerChains.add(handlerChain);
    }

    /**
     * 主要处理方法
     *
     * @param requestSource
     */
    @Override
    public void doChain(RequestSource requestSource) {
        handlerChains.forEach(handlerChain -> handlerChain.doChain(requestSource));
    }
}
