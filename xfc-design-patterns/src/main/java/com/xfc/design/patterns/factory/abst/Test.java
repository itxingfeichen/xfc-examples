package com.xfc.design.patterns.factory.abst;

import java.util.Objects;

/**
 * 抽象工厂测试（客户端）
 *
 * @author xf.chen
 * @date 2020/10/31 17:58
 * @since 1.2.0
 */
public class Test {

    public static void main(String[] args) {
        OperateSystemUIFactory factory;
        String property = System.getProperty("os.name");
        String system = "Windows 10";
        if (Objects.equals(property, system)) {
            factory = new WindowsUIFactory();
        } else {
            factory = new MacUIFactory();
        }
        ApplicationClient applicationClient = new ApplicationClient(factory);
        applicationClient.paint();

    }


}
