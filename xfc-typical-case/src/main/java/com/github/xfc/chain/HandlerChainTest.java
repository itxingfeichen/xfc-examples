package com.github.xfc.chain;

/**
 * @author : chenxingfei
 * @date: 2019-10-08  11:29
 * @description: 责任链测试
 */
public class HandlerChainTest {


    /**
     * 责任链模式代码测试
     * @param args
     */
    public static void main(String[] args) {
        DefaultHandlerChain defaultHandlerChain = new DefaultHandlerChain();

        defaultHandlerChain.addHandler(new PrintAHandlerChain());

        defaultHandlerChain.addHandler(new PrintBHandlerChain());

        RequestSource requestSource =  new RequestSource();
        defaultHandlerChain.doChain(requestSource);

        System.out.println("requestSource = " + requestSource);
    }
}
