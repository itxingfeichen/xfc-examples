package com.xfc.design.patterns.factory.simple;

/**
 * 按钮接口
 *
 * @author xf.chen
 * @date 2020/10/31 16:03
 * @since 1.2.0
 */
public interface Button {

    /**
     * 绘制接口
     */
    void render();

    /**
     * 创建按钮
     */
    Button createButton();
}
