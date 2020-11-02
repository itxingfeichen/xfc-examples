package com.xfc.design.patterns.factory.simple;

/**
 * windows按钮
 *
 * @author xf.chen
 * @date 2020/10/31 16:03
 * @since 1.2.0
 */
public class WindowsButton implements Button {


    /**
     * 绘制接口
     */
    @Override
    public void render() {
        System.out.println("windows button render!");
    }

    /**
     * 创建按钮
     */
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
