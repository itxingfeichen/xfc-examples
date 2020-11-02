package com.xfc.design.patterns.prototype;

import java.util.Objects;

/**
 * 简单形状
 *
 * @author xf.chen
 * @date 2020/11/2 17:24
 * @since 1.2.0
 */
public abstract class Shape {

    public int x;
    public int y;
    public String color;

    public Shape() {
    }

    public Shape(Shape target) {
        if (target != null) {
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }

    /**
     * 克隆
     *
     * @return
     */
    public abstract Shape clone();

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Shape)) return false;
        Shape shape2 = (Shape) object2;
        return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);
    }

}
