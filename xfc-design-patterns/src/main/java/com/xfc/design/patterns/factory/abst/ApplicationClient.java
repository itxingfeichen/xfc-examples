package com.xfc.design.patterns.factory.abst;

/**
 * 客户端
 *
 * @author xf.chen
 * @date 2020/10/31 18:01
 * @since 1.2.0
 */
public class ApplicationClient {

    private Tab tab;

    private Checkbox checkbox;

    public ApplicationClient(OperateSystemUIFactory factory) {
        this.tab = factory.paintTab();
        this.checkbox = factory.paintCheckbox();
    }

    public void paint(){
        this.tab.paint();
        this.checkbox.paint();
    }
}
