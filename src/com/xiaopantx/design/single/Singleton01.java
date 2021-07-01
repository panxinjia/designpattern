package com.xiaopantx.design.single;

/**
 * 单例设计模式 - 懒汉式写法
 * @author xiaopantx
 *
 * 工作中常用: 直接使用懒汉式写法, class一加载完成static初始化,实例就创建了
 *
 * 问题:
 */
public class Singleton01 {

    // 线程安全, JVM保证, 一个class文件只被load一次, load一次, 初始化一次
    private static final Singleton01 INSTANCE = new Singleton01();

    // 1. 私有化构造器
    private Singleton01() {

    }

    // 2. 提供全局访问点
    public static Singleton01 getInstance() {
        return INSTANCE;
    }

    // 3. 测试结果
    public static void main(String[] args) {
        Singleton01 instance01 = Singleton01.getInstance();
        Singleton01 instance02 = Singleton01.getInstance();

        // 同一个实例
        System.out.println(instance01 == instance02);
        // hashcode 相同
        System.out.println(instance01.hashCode() == instance02.hashCode());
    }
}
