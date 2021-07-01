package com.xiaopantx.strategy;

/**
 * @author panxj
 */
public class Person {

    private int height;
    private int age;

    public Person() {

    }

    public Person(int height, int age) {
        this.height = height;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", age=" + age +
                '}';
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
