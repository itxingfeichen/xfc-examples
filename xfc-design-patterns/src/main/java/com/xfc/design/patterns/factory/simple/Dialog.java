package com.xfc.design.patterns.factory.simple;

/**
 * 对话框接口
 *
 * @author xf.chen
 * @date 2020/10/31 16:01
 * @since 1.2.0
 */
public interface Dialog {

    /**
     * 绘制接口
     */
   default void render(){
       createButton().render();
   }

    /**
     * 创建按钮
     * @return Button
     */
    Button createButton();
}
