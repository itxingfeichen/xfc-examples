package com.xfc.design.patterns.factory.simple;

/**
 * windows对话框
 *
 * @author xf.chen
 * @date 2020/10/31 16:02
 * @since 1.2.0
 */
public class WindowsDialog implements Dialog {

    /**
     * 创建按钮
     */
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
