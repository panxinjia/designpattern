package com.xiaopantx.design.single;

import com.xiaopantx.util.TimeUtil;

import java.util.concurrent.CountDownLatch;

/**
 * 懒汉式写法 - 不常用， 涉及到线程安全问题
 * @author panxj
 */
public class Singleton03 {

    // 延迟加载实例
    private static Singleton03 INSTANCE = null;

    private Singleton03() {

    }

    public static Singleton03 getInstance() {
        if (INSTANCE == null) {
            // -> 线程调度， 可能产生线程安全问题
            TimeUtil.sleep(5);
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) throws InterruptedException {
        //Singleton03 ins1 = Singleton03.getInstance();
        //Singleton03 ins2 = Singleton03.getInstance();
        // System.out.println(ins1.hashCode() == ins2.hashCode()); // 可能不同

        CountDownLatch latch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                Singleton03 instance = Singleton03.getInstance();
                System.out.println(instance.hashCode()); //
                latch.countDown();
            }).start();
        }

        latch.await();



    }

}
