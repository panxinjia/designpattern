package com.xiaopantx.strategy;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author panxj
 */
public class StrategyTest {

    public static void main(String[] args) {
        Person[] ps = new Person[]{
                new Person(180, 20),
                new Person(170, 21),
                new Person(160, 22),
                new Person(150, 23),
                new Person(140, 24)
        };

        // java8之后策略算法可以直接定义为函数式接口，lambda表达式实现
        // 年龄降序排列
        //Arrays.sort(ps, (p1, p2) -> p2.getAge() - p1.getAge());
        // 身高升序排列
        //Arrays.sort(ps, (p1, p2) -> p2.getHeight() - p1.getHeight());

        // 年龄升序排列
        //Arrays.sort(ps, new SortByAgeAsc());

        // 身高升序排列
        Arrays.sort(ps, new SortByHeightAsc());


        System.out.println("Arrays.toString(ps) = " + Arrays.toString(ps));
    }
}

// 身高升序比较算法
class SortByHeightAsc implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getHeight() - o2.getHeight();
    }
}

// 年龄升序比较算法
class SortByAgeAsc implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
