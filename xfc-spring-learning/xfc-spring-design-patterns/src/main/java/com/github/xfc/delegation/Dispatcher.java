package com.github.xfc.delegation;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  15:34
 * @description: 任务委派人
 */
public class Dispatcher implements NormalRule {


    /**
     * 做某事
     *
     * @return
     */
    @Override
    public boolean doSomething(String task) {
        new UserA().doSomething(task);
        new UserB().doSomething(task);
        return true;
    }
}
