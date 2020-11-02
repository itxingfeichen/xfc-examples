package com.xfc.design.patterns.factory.abst;

/**
 * windows系统tab标签
 *
 * @author xf.chen
 * @date 2020/10/31 17:49
 * @since 1.2.0
 */
public class WindowsUITab implements Tab {
    /**
     * 绘制
     */
    @Override
    public void paint() {
        System.out.println("windows系统tab标签 创建");
    }
}
