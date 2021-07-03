package com.xiaopantx.design.proxy.staticproxy;

import com.xiaopantx.design.proxy.Moveable;

/**
 * @author panxj
 */
public class MoveTimeProxy implements Moveable {

    private Moveable target;

    public MoveTimeProxy(Moveable target) {
        this.target = target;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        target.move();
        long end = System.currentTimeMillis();
        System.out.println("move time:" + (end - start) + " ms");
    }
}
