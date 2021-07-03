package com.xiaopantx.design.factory.simplefactory;

import com.xiaopantx.design.factory.Car;
import com.xiaopantx.design.factory.Moveable;
import com.xiaopantx.design.factory.Plane;

/**
 * 简单工厂， 静态工厂， 项目中工厂模式使用方式
 *
 * 灵活控制对象创建过程
 * @author panxj
 */
public class SimpleFactory {

    private static final SimpleFactory SIMPLE_FACTORY = new SimpleFactory();

    private SimpleFactory() {}

    // factory 一般都是单例模式
    public static SimpleFactory getSimpleFactory() {
        return SimpleFactory.SIMPLE_FACTORY;
    }

    /**
     * 简单工厂 工厂方法
     * @return
     */
    public Car createCar() {
        // 不改变原有类代码前提下， 进行修改的一种方式 （工厂， 装饰， 代理， 适配）
        System.out.println("创建car");
        return new Car();
    }

    public Plane createPlane() {
        System.out.println("创建plane");
        return new Plane();
    }



    /**
     * 项目中常用工厂模式
     * @param bizParam
     * @return
     */
    public Moveable getMoveable(int bizParam) {
        if (bizParam == 1)
            return new Car();
        if (bizParam == 2) {
            return new Plane();
        }
        // 简单项目中简单扩展点
        return null;
    }
}
