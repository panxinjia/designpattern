package com.xiaopantx.design.proxy.staticproxy;

import com.xiaopantx.design.proxy.Moveable;

/**
 * @author panxj
 */
public class MoveLogProxy implements Moveable {

    private Moveable target;

    public MoveLogProxy(Moveable target) {
        this.target = target;
    }

    @Override
    public void move() {
        this.beforeLog();
        target.move();
        this.afterLog();
    }


    public void beforeLog() {
        System.out.println("before log ...................");
    }

    public void afterLog() {
        System.out.println("after log ....................");
    }
}
