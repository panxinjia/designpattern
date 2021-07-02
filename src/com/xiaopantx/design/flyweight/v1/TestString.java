package com.xiaopantx.design.flyweight.v1;

/**
 * 字节码文件
 *  常量池 - 享元模式
 *
 * @author panxj
 */
public class TestString {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println(s1 == s2); // true
        System.out.println(s2 == s3); // false
        System.out.println(s3 == s4); // false

        /**
         * jdk intern() 方法注释， 一个字符串值， 持有 class 相关的私有常量
         * A pool of strings, initially empty, is maintained privately by the
         * class {@code String}.
         *
         */
        System.out.println(s1.intern() == s2); // true
        System.out.println(s3.intern() == s4.intern()); // true
    }
}
