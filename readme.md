# 前言

​		总结一下设计模式， 虽然在工作中用到设计模式的机会不是很多， 但框架设计中有很多灵活的设计模式应用， 理解常见设计模式对于框架学习和源码阅读非常重要。 

# singleton 单例模式 

​	工作中如果需要使用到单例设计模式， 可以直接使用饿汉式或者静态内部类的写法， 没必要追求奇技淫巧， 工程学科以工程为主。

​	**注意事项:** 如果写的类需要被外部团队使用，也可以采用枚举形式， 反射可以绕过 private 关键字来实例化。枚举不支持反射，不支持clone，序列化与反序列化。 

​	![1625132517108](img/1625132517108.png)

## 模式定义

​		保证在应用程序中只有一个实例，并提供全局唯一的访问点。 

## 应用

1. *Manager， *Factory，工具类。
2. Spring容器默认为singleton。

## 例子

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



# strategy 策略模式 ☆ 

## 模式定义

​		定义一个算法组， 分别封装起来， 让它们之间可以相互替换， 策略模式独立于算法的使用者。 面向接口编程， 将算法定义为接口， java8 之后可以直接将算法定义为函数式接口， 需要不同算法的依赖，使用lambda表达式实现。 



## 应用

​		策略模式经常和工厂模式一起使用， 根据 client 状态，工厂动态实例化不同的策略实例。 



## 例子

### 促销打折策略



### 对象创建策略

spring instantiationstrategy 创建实例策略



OA系统审批流选择策略



# composite 组合模式 

​	处理树状结构的设计模式， 项目中如果需要处理树状结构的场景， 可以根据情况使用组合模式

![1625208652012](img/1625208652012.png)

## 例子

### 代码模拟Linux树状目录结构

代码参考 `com.xiaopantx.design.composite`包

```java
/**
 * @author panxj
 */
public class MainTest {

    public static void main(String[] args) {
        Node root = new BranchNode("/", "根目录",
                Arrays.asList(
                        new BranchNode("/etc", "配置文件目录",
                                Arrays.asList(
                                        new Leaf("/etc/profile", "系统环境配置文件"),
                                        new BranchNode("/etc/sysconfig", "系统配置目录", Collections.emptyList()))),
                        new BranchNode("/proc", "操作系统映射目录", Collections.emptyList()),
                        new BranchNode("/root", "系统用户根目录", Collections.emptyList())));

        tree(root,  0);

    }

    public static void tree(Node node, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        node.print();
        if (node instanceof BranchNode) { // 递归结束条件
            BranchNode branch = (BranchNode) node;
            List<Node> nodes = branch.getNodes();
            depth++;
            for (Node n : nodes) { // 递归体
                tree(n, depth);
            }
        }
    }
}
```



# flyweight 享元模式

​	重复利用对象， 共**享元**数据，经常和 composite （组合模式） 一起使用。 

![1625207570714](img/1625207570714.png)

## 应用

​		各种连接池， 线程池，共享对象的缓存优化。 

## 例子

### GOF 享元模式 - 字处理软件

​		字处理软件中经常需要用到一些小对象，例如我们键盘录入一个字符 A ， 从触发硬件中断到应用程序， 程序中会使用到相关的字符对象， 这些对象是可以复用的， 每次需要用到字符的时候， 直接从 **字符池**中获取。 

### 字符串常量池

```java
/**
         * jdk intern() 方法注释， 一个字符串值， 持有 class 相关的私有常量
         * A pool of strings, initially empty, is maintained privately by the
         * class {@code String}.
         *
         */
System.out.println(s1.intern() == s2); // true
System.out.println(s3.intern() == s4.intern()); // true
```

### IntegerCache

![1625211118601](img/1625211118601.png)

### ThreadPoolExecutor 线程池

### DataSource 数据源连接池



# Factory 工厂模式



# Proxy 代理模式 ☆ 

- 静态代理
- 动态代理
- SpringAOP



# Iterator 迭代器模式



# Builder 构建器模式



# Adaptor 适配器模式



# ChainOfResponsibility 责任链模式



# Observer 观察者模式 ☆ 





# TemplateMethod 模板方法模式

​		**钩子函数**， **面向对象思想中， 类， 抽象类， 一般用来表达抽象，模板，复用的概念， 接口则表达规范，协议的概念。** 模板方法模式是符合自然思考方式的一种设计模式。 

![1625213663560](img/1625213663560.png)

## 例子

```java
public abstract class SuperClass {
    // 模板方法
    public void templateMethod() {
        this.op1();
        System.out.println("中间操作");
        this.op2();
    }
    // 抽象方法， 不确定部分推迟到子类实现
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
```

### jwt 和 swing 组件中大量运用