package com.xiaopantx.design.factory.abstractfactory;

import com.xiaopantx.design.factory.Car;
import com.xiaopantx.design.factory.Moveable;

/**
 * @author panxj
 */
public class ConcreteFactoryA extends AbstractFactory {
    @Override
    public Moveable createMoveable() {
        return new Car();
    }

    @Override
    public Food createFood() {
        return new Bread();
    }

    @Override
    public Weapon createWeapon() {
        return new AK();
    }
}
