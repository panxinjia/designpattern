# 前言

​		总结一下设计模式， 虽然在工作中用到设计模式的机会不是很多， 但框架设计中有很多灵活的设计模式应用， 理解常见设计模式对于框架学习和源码阅读非常重要。 

# 1. 单例模式

​	工作中如果需要使用到单例设计模式， 可以直接使用饿汉式或者静态内部类的写法， 没必要追求奇技淫巧， 工程学科以工程为主。

​	**注意事项:** 如果写的类需要被外部团队使用，也可以采用枚举形式， 反射可以绕过 private 关键字来实例化。枚举不支持反射，不支持clone，序列化与反序列化。 

​	![1625132517108](img/1625132517108.png)

## 1.1 模式定义

​		保证在应用程序中只有一个实例，并提供全局唯一的访问点。 

## 1.2 应用

1. *Manager， *Factory，工具类。
2. Spring容器默认为singleton。

## 1.3 例子

### 饿汉式

```java
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
}
```

### 懒汉式

```java
public class Singleton05 {
    private static volatile Singleton05 INSTANCE = null;
    private Singleton05() {}
    public static Singleton05 getInstance() {
        if (INSTANCE == null) {
            // 第一次判断， 高并发场景提升一定效率
            synchronized (Singleton05.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton05(); // 高并发下JIT编译的指令重排可能会导致获取到 INSTANCE = null 的情况
                }
            }
        }
        return INSTANCE;
    }
}
```

### 静态内部类

```java
/**
 * 静态内部类形式 （工作中可用）
 *  1. 实现了懒加载（jvm类加载和static初始化机制）
 *  2. 线程安全(类的加载有JVM保证线程安全）
 *
 * @author panxj
 */
public class Singleton06 {

    private Singleton06() {

    }

    private static class Singleton06Holder {
        public static final Singleton06 INSTANCE = new Singleton06();
    }

    public static Singleton06 getInstance() {
        return Singleton06Holder.INSTANCE;
    }
}
```

### 枚举类

```java
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
}
```

**枚举不支持反射，clone，序列化与反序列化， 反射源码， 当字节码文件是 `enum`修饰时，直接抛出了异常。** 

![1625131566858](img/1625131566858.png)



# 2. 策略模式

## 2.1 模式定义

​		定义一个算法组， 分别封装起来， 让它们之间可以相互替换， 策略模式独立于算法的使用者。 面向接口编程， 将算法定义为接口， java8 之后可以直接将算法定义为函数式接口， 需要不同算法的依赖，使用lambda表达式实现。 



## 2.2 应用

​		策略模式经常和工厂模式一起使用， 根据 client 状态，工厂动态实例化不同的策略实例。 



## 2.3 例子

### 促销打折策略



### 对象创建策略

spring instantiationstrategy 创建实例策略



OA系统审批流选择策略