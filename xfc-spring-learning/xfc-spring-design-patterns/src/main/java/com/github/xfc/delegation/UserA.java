package com.github.xfc.delegation;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  15:33
 * @description: 用户A
 */
public class UserA implements NormalRule {
    /**
     * 做某事
     *
     * @return
     */
    @Override
    public boolean doSomething(String task) {
        System.out.println("已完成 "+task+" 事儿");
        return true;
    }
}
