package com.xiaopantx.design.single;

/**
 * 单例设计模式 - 饿汉式写法
 * @author xiaopantx
 *
 * 应用: 直接使用饿汉式写法, 字节码一加载完成，static初始化,实例就创建了， 工作中通常是使用Spring框架，
 *  在启动时就完成初始化了。
 *
 * 问题: 实例对象过大时可能会影响启动速度。
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
        // 同一个类的实例， 每一个实例的hashCode唯一
        System.out.println(instance01.hashCode() == instance02.hashCode());
    }
}
