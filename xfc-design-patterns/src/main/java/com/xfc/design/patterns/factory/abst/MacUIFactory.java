package com.xfc.design.patterns.factory.abst;

/**
 * windowsUI工厂
 *
 * @author xf.chen
 * @date 2020/10/31 17:55
 * @since 1.2.0
 */
public class MacUIFactory implements OperateSystemUIFactory {
    /**
     * 绘制tab按钮
     */
    @Override
    public Tab paintTab() {
        return new MacUITab();
    }

    /**
     * 绘制checkbox
     */
    @Override
    public Checkbox paintCheckbox() {
        return new MacUICheckbox();
    }
}
