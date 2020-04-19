package com.github.xfc.delegation;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  15:31
 * @description: 标准规则
 * 委派模式是一种关心结果的模式
 */
public interface NormalRule {

    /**
     * 做某事
     *
     * @return
     */
    boolean doSomething(String task);

}
