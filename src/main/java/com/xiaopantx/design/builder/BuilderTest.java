package com.xiaopantx.design.builder;

/**
 *
 * 常见开源框架的核心对象经常见到 builder模式， 创建型设计模式的一种。
 * @author panxj
 */
public class BuilderTest {

    public static void main(String[] args) {
        Person p1 = new Person.PersonBuilder()
                .name("zhangsan")
                .age(27)
                .loc(new Location("中国", "..."))
                .build();

        Person p2 = new Person.PersonBuilder()
                .name("jack")
                .build();
        System.out.println(p1);
        System.out.println(p2);
    }
}
