package com.xiaopantx.design.factory;

/**
 * @author panxj
 */
public class Main {

    public static void main(String[] args) {
//        Car car = new Car();
//        car.go();
//
//        Plane plane = new Plane();
//        plane.go();

//        面向接口编程， 丰富的扩展性
        Moveable vehicle =
                // new Car();
                new Plane();
        vehicle.go();



    }

}
