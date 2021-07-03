package com.xiaopantx.design.factory.simplefactory;

import com.xiaopantx.design.factory.Moveable;

/**
 * @author panxj
 */
public class SimpleMainTest {

    public static void main(String[] args) {
        // 业务代码中没有具体交通工具的依赖， 只有对工厂的依赖，
        // 复杂场景下可以再对工厂进行抽象， example： SpringIOC
        SimpleFactory factory = SimpleFactory.getSimpleFactory();

        // 创建过程单独增强
        Moveable car = factory.createCar();
        car.go();

        // 创建过程单独增强
        Moveable plane = factory.createPlane();
        plane.go();

        // 解耦合
        Moveable car2 = factory.getMoveable(1);
        car2.go();

        Moveable plane2 = factory.getMoveable(2);
        plane2.go();

    }
}
