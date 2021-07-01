package com.xiaopantx.design.single;

import java.util.concurrent.CountDownLatch;

/**
 * 静态内部类形式 （工作中可用）
 *  1. 实现了懒加载（jvm类加载和static初始化机制）
 *  2. 线程安全(类的加载有JVM保证线程安全）
 *
 * @author panxj
 */
public class Singleton06 {

    private Singleton06() {

    }

    private static class Singleton06Holder {
        public static final Singleton06 INSTANCE = new Singleton06();
    }

    public static Singleton06 getInstance() {
        return Singleton06Holder.INSTANCE;
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println("Singleton06.getInstance().hashCode() = " + Singleton06.getInstance().hashCode());
                latch.countDown();
            }).start();
        }

        latch.await();
    }


}
