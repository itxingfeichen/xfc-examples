package com.xfc.design.patterns.factory.abst;

/**
 * mac系统tab标签
 *
 * @author xf.chen
 * @date 2020/10/31 17:49
 * @since 1.2.0
 */
public class MacUITab implements Tab {
    /**
     * 绘制
     */
    @Override
    public void paint() {
        System.out.println("mac系统tab标签 创建");
    }
}
