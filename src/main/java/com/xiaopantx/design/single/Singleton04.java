package com.xiaopantx.design.single;

import com.xiaopantx.util.TimeUtil;

import java.util.concurrent.CountDownLatch;

/**
 * 懒汉式写法 - 可以使用， 涉及到线程安全问题，访问点加同步， 锁粒度大， 效率低
 * @author panxj
 */
public class Singleton04 {

    // 延迟加载实例
    private static Singleton04 INSTANCE = null;

    private Singleton04() {

    }

    // Singleton04.class 对象锁， 直接同步
    public static synchronized Singleton04 getInstance() {
        if (INSTANCE == null) {
            // -> 线程调度， 可能产生线程安全问题
            TimeUtil.sleep(5);
            INSTANCE = new Singleton04();
        }
        return INSTANCE;
    }
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                Singleton04 instance = Singleton04.getInstance();
                System.out.println(instance.hashCode()); //
                latch.countDown();
            }).start();
        }
        latch.await();
    }

}
