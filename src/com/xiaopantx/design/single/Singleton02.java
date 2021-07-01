package com.xiaopantx.design.single;

/**
 *
 * 静态初始化
 *
 */
public class Singleton02 {

    private static Singleton02 INSTANCE = null;

    static {
        INSTANCE = new Singleton02();
    }

    private Singleton02() {

    }

    public static Singleton02 getInstance() {
        return INSTANCE;
    }
}
