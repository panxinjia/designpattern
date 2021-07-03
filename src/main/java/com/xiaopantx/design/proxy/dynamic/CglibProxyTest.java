package com.xiaopantx.design.proxy.dynamic;

import com.xiaopantx.design.proxy.Car;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author panxj
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        //增强器
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method,
                                    Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before...");
                Object retVal = methodProxy.invokeSuper(o, objects);
                System.out.println("after...");
                return retVal;
            }
        });

        Car c = ((Car) enhancer.create());
        c.move();
    }
}
