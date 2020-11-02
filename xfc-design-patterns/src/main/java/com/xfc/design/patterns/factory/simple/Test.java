package com.xfc.design.patterns.factory.simple;

import java.util.Objects;

/**
 * 测试类
 *
 * @author xf.chen
 * @date 2020/10/31 16:07
 * @since 1.2.0
 */
public class Test {

    public static void main(String[] args) {
        getButtonByOs().render();
    }

    private static Button getButtonByOs() {
        String property = System.getProperty("os.name");
        String system = "Windows 10";
        if (Objects.equals(property, system)) {
            return new WindowsDialog().createButton();
        } else {
            return new WebDialog().createButton();
        }
    }
}
