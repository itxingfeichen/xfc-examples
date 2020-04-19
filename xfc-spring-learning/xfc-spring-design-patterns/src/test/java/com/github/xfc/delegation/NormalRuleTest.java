package com.github.xfc.delegation;

import org.junit.Test;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  15:37
 * @description: 任务指定人（委派）
 */
public class NormalRuleTest {

    @Test
    public void testDelegation() {
        Dispatcher dispatcher = new Dispatcher();
        System.out.println(dispatcher.doSomething("开发新系统"));
    }

}