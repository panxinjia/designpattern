package com.xiaopantx.design.builder;

/**
 * @author panxj
 */
public class Person {

    private String name;
    private int age;
    private Location loc;

    //构建器经常作为内部类存在
    public static class PersonBuilder{
        // 构建目标对象
        private Person person;
        // 链式API
        public PersonBuilder name(String name) {
            person.name = name;
            return this;
        }
        public PersonBuilder age(int age) {
            person.age = age;
            return this;
        }

        public PersonBuilder loc(Location loc) {
            person.loc = loc;
            return this;
        }
        // 返回目标对象
        public Person build() {
            return person;
        }
    }

}
