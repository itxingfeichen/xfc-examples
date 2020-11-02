package com.xfc.design.patterns.prototype;

/**
 * 原型
 *
 * @author xf.chen
 * @date 2020/11/2 17:26
 * @since 1.2.0
 */
public class Rectangle extends Shape {

    public int width;
    public int height;

    public Rectangle() {
    }

    private Rectangle(Rectangle circle) {
        super(circle);
        if (circle != null) {
            this.width = circle.width;
            this.height = circle.height;
        }
    }

    /**
     * 克隆
     *
     * @return
     */
    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Rectangle) || !super.equals(object2)) return false;
        Rectangle shape2 = (Rectangle) object2;
        return shape2.width == width && shape2.height == height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", x=" + x +
                ", y=" + y +
                ", color='" + color + '\'' +
                '}' + "  hashcode=" + this.hashCode();
    }
}
