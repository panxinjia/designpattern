package com.xiaopantx.design.proxy.staticproxy;

import com.xiaopantx.design.proxy.Car;
import com.xiaopantx.design.proxy.Moveable;

/**
 * @author panxj
 */
public class MainTest {

    public static void main(String[] args) {
        // target 被代理类
        Moveable target = new Car();

        // 代理类
        Moveable proxy = new MoveTimeProxy(
                new MoveLogProxy(
                        target
                )
        );
        proxy.move();
    }
}
