package com.xfc.design.patterns.factory.simple;

/**
 * web对话框
 *
 * @author xf.chen
 * @date 2020/10/31 16:02
 * @since 1.2.0
 */
public class WebDialog implements Dialog {

    /**
     * 创建按钮
     */
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
