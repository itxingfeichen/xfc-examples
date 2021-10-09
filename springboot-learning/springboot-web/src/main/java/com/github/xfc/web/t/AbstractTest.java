package com.github.xfc.web.t;

/**
 * 1
 *
 * @author xf.chen
 * @date 2021/9/16 12:02
 * @since 1.0.0
 */
public abstract class AbstractTest {

    public void refresh(){
        initPropertySources();
    }

    protected void initPropertySources() {
        // For subclasses: do nothing by default.

        System.out.println("initPropertySources----------");
    }
}
