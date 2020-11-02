package com.xfc.design.patterns.prototype;

/**
 * 测试
 *
 * @author xf.chen
 * @date 2020/11/2 17:31
 * @since 1.2.0
 */
public class Test {

    public static void main(String[] args) {

        Circle circle = new Circle();
        circle.x = 1;
        circle.y = 2;
        circle.radius = 100;
        System.out.println(circle);
        System.out.println(circle.clone());

        Rectangle rectangle = new Rectangle();
        rectangle.x = 11;
        rectangle.y = 22;
        rectangle.height = 100;
        rectangle.width = 200;

        System.out.println(rectangle);
        System.out.println(rectangle.clone());
    }
}
