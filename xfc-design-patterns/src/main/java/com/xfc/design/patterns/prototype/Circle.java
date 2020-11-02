package com.xfc.design.patterns.prototype;

/**
 * 原型
 *
 * @author xf.chen
 * @date 2020/11/2 17:26
 * @since 1.2.0
 */
public class Circle extends Shape {

    public int radius;

    public Circle() {
    }

    private Circle(Circle circle) {
        super(circle);
        if (circle != null) {
            this.radius = circle.radius;
        }
    }

    /**
     * 克隆
     *
     * @return
     */
    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Circle) || !super.equals(object2)) {
            return false;
        }
        Circle shape2 = (Circle) object2;
        return shape2.radius == radius;
    }


    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", x=" + x +
                ", y=" + y +
                ", color='" + color + '\'' +
                '}' + "  hashcode=" + this.hashCode();
    }
}
