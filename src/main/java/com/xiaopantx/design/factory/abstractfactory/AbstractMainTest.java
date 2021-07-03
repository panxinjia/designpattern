package com.xiaopantx.design.factory.abstractfactory;

import com.xiaopantx.design.factory.Moveable;

/**
 * @author panxj
 */
public class AbstractMainTest {

    public static void main(String[] args) {
        // 抽象工厂， 常见产品族， 简单工厂也是一种抽象工厂， 产品族只有一种产品。
        AbstractFactory concreteA = new ConcreteFactoryA();
        AbstractFactory concreteB = new ConcreteFactoryB();


        Moveable car = concreteA.createMoveable();
        Food bread = concreteA.createFood();
        Weapon ak = concreteA.createWeapon();

        Moveable plane = concreteB.createMoveable();
        Food mushRoom = concreteB.createFood();
        Weapon magicWand = concreteB.createWeapon();


    }
}
