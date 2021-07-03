package com.xiaopantx.design.factory.abstractfactory;

import com.xiaopantx.design.factory.Moveable;

/**
 * @author panxj
 */
public abstract class AbstractFactory {

    abstract public Moveable createMoveable();

    abstract public Food createFood();

    abstract public Weapon createWeapon();

}
