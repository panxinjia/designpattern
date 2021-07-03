package com.xiaopantx.design.tempaltemethod;

/**
 * 模板方法模式
 * @author panxj
 */
public abstract class SuperClass {
    // 模板方法
    public void templateMethod() {
        this.op1();
        System.out.println("中间操作");
        this.op2();
    }
    // 抽象方法， 由子类实现
    public abstract void op1();
    public abstract void op2();

    public static void main(String[] args) {
        SuperClass obj1 = new SubClassA();
        obj1.templateMethod();  // jwt swing中 paint()调用过程和这个相同
        System.out.println("-----------------------------------");
        SuperClass obj2 = new SubClassB();
        obj2.templateMethod();
    }
}
class SubClassA extends SuperClass {
    @Override
    public void op1() {
        System.out.println("SubClassA 。。。 op1");
    }
    @Override
    public void op2() {
        System.out.println("SubClassA 。。。 op2");
    }
}
class SubClassB extends SuperClass {
    @Override
    public void op1() {
        System.out.println("SubClassB 。。。 op1");
    }
    @Override
    public void op2() {
        System.out.println("SubClassB 。。。 op2");
    }
}
