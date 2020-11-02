package com.xfc.design.patterns.factory.abst;

/**
 * 操作系统UI抽象工厂
 *
 * @author xf.chen
 * @date 2020/10/31 17:53
 * @since 1.2.0
 */
public interface OperateSystemUIFactory {

    /**
     * 绘制tab按钮
     * @return tab
     */
    Tab paintTab();

    /**
     * 绘制checkbox
     * @return checkbox
     */
    Checkbox paintCheckbox();

}
