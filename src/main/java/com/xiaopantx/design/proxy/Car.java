package com.xiaopantx.design.proxy;

import com.xiaopantx.util.TimeUtil;

import java.util.Random;

/**
 * @author panxj
 */
public class Car implements Moveable {
    @Override
    public void move() {
        System.out.println("car move..............");
        int i = new Random().nextInt(1000);
        TimeUtil.sleep((long)i);
    }
}
