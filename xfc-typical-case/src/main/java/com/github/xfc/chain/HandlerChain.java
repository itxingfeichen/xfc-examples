package com.github.xfc.chain;

/**
 * @author : chenxingfei
 * @date: 2019-10-08  11:23
 * @description: 责任链
 */
public interface HandlerChain {

    /**
     * 主要处理方法
     * @param requestSource
     */
    void doChain(RequestSource requestSource);
}
