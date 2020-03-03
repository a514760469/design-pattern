package com.gds.standard;

import java.util.HashMap;

/**
 * @author zhanglifeng
 * @since 2020-03-02 18:28
 * 享元工厂
 */
public class FlyweightFactory {

    private static HashMap<String, Flyweight> pool = new HashMap<>();


    public static Flyweight getFlyweight(String key) {
        // 需要返回的对象
        Flyweight flyweight;
        // 在池中没有该对象
        if (pool.containsKey(key)) {
            flyweight = pool.get(key);
        } else {
            // 根据外部状态创建享元对象
            flyweight = new ConcreteFlyweight(key);
            pool.put(key, flyweight);
        }
        return flyweight;
    }

}
