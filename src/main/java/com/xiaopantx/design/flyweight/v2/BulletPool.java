package com.xiaopantx.design.flyweight.v2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 例子来自于 tank 游戏
 * @author panxj
 */
public class BulletPool {
    // 子弹池缓存子弹数量上限
    private static final Integer MAX_SIZE = 50;

    // 当前缓存了多少
    private int size;

    // 子弹池
    public List<Bullet> bullets = Collections.EMPTY_LIST;

    // 初始5个
    {
        bullets.add(new Bullet());
        bullets.add(new Bullet());
        bullets.add(new Bullet());
        bullets.add(new Bullet());
        bullets.add(new Bullet());
        this.size = 5;
    }

    public Bullet getBullet() {
        for (Bullet bullet : bullets) {
            if (!bullet.isAlive) // 返回给使用者一个存活的子弹
                return bullet;
        } // 遍历完成， 没有存活的子弹

        // 新增子弹， 新增成功返回， 否则返回null
        Bullet bullet = new Bullet();
        return this.add(bullet) ? bullet : null; // 添加成功时返回
    }

    public boolean add() {
        return this.add(new Bullet());
    }

    public boolean add(Bullet bullet) {
        if (this.size == MAX_SIZE) {
            // throw new RuntimeException("子弹池超出上限，无法添加");
            return false;
        }
        return this.bullets.add(bullet);
    }
}
