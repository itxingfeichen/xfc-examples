package com.github.xfc.chain;

/**
 * @author : chenxingfei
 * @date: 2019-10-08  11:30
 * @description: 打印A
 */
public class PrintAHandlerChain implements HandlerChain {
    /**
     * 主要处理方法
     *
     * @param requestSource
     */
    @Override
    public void doChain(RequestSource requestSource) {
        System.out.println("AAA");
        requestSource.setAge(1000);
    }
}
