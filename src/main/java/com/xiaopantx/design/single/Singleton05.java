package com.xiaopantx.design.single;

import com.xiaopantx.util.TimeUtil;

import java.util.concurrent.CountDownLatch;

/**
 * double check 双重检查单例模式， 面试可能会问
 * @author panxj
 */
public class Singleton05 {

    private static volatile Singleton05 INSTANCE = null;

    private Singleton05() {

    }

    public static Singleton05 getInstance() {
        if (INSTANCE == null) {
            // 第一次判断， 高并发场景提升一定效率
            synchronized (Singleton05.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton05(); // 高并发下JIT编译的指令重排可能会导致获取到 INSTANCE = null 的情况
                }
            }
        }
        return INSTANCE;
    }
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                Singleton05 instance = Singleton05.getInstance();
                System.out.println(instance.hashCode()); //
                latch.countDown();
            }).start();
        }
        latch.await();
    }

}
