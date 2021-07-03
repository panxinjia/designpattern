package com.xiaopantx.design.flyweight.v2;

import java.util.UUID;

/**
 * 子弹类 - 完全可以共享的对象
 * @author panxj
 */
public class Bullet {

    // 随机属性
    public String uuid = UUID.randomUUID().toString().substring(0, 18);
    // 子弹是否存活
    public boolean isAlive = true;

}
