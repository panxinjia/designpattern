package com.xiaopantx.design.proxy.dynamic;

import com.xiaopantx.design.proxy.Car;
import com.xiaopantx.design.proxy.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 *
 * 基于jdk动态代理
 * @author panxj
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        final Moveable car = new Car();
        // 保留在内存中生成的代理类
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        Moveable proxy = ((Moveable) Proxy.newProxyInstance(
                car.getClass().getClassLoader(), // 代理类 与 被代理类使用相同的类加载器加载
                car.getClass().getInterfaces(),  // jdk 动态代理基于接口实现
                new InvocationHandler() { // 被代理类的方法调动处理 ☆
                    /**
                     *
                     * @param proxy 代理类， 慎用， stack over flow
                     * @param method 调用方法
                     * @param args 方法参数
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before............");
                        Object retVal = method.invoke(car, args);
                        System.out.println("after............");
                        return retVal;
                    }
                }
        ));
        proxy.move();
    }
}
