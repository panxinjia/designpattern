package com.xiaopantx.design.single;

/**
 * 枚举定义单例模式
 * 1. 保证单例
 * 2. 防止反射
 *
 * @author panxj
 */
public enum Singleton07 {
    // ENUM  默认修饰符 public static final
    INSTANCE;

    //反射源码， 判断了字节码文件的修饰符，如果是枚举，直接抛出异常了
    //if ((clazz.getModifiers() & Modifier.ENUM) != 0)
    //            throw new IllegalArgumentException("Cannot reflectively create enum objects");
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Singleton07 instance = Singleton07.class.newInstance();

        System.out.println(instance);
    }
}
