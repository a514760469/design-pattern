package com.gds.standard;

import java.util.Random;

/**
 * @author zhanglifeng
 * @since 2020-03-20 11:16
 */
public class ObjectStructure {

    public static Element createElement() {
        Random rand = new Random();
        if (rand.nextInt(100) > 50) {
            return new ConcreteElementA();
        } else {
            return new ConcreteElementB();
        }
    }
}
