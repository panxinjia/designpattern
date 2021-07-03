package com.xiaopantx.design.factory.abstractfactory;

import com.xiaopantx.design.factory.Car;
import com.xiaopantx.design.factory.Moveable;
import com.xiaopantx.design.factory.Plane;

/**
 * @author panxj
 */
public class ConcreteFactoryB extends AbstractFactory {
    @Override
    public Moveable createMoveable() {
        return new Plane();
    }

    @Override
    public Food createFood() {
        return new MushRoom();
    }

    @Override
    public Weapon createWeapon() {
        return new MagicWand();
    }
}
