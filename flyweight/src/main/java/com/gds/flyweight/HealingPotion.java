package com.gds.flyweight;

/**
 * @author zhanglifeng
 * @since 2020-03-02 17:13
 */
public class HealingPotion implements Potion {

    @Override
    public void drink() {
        System.out.println("You feel 治愈. (Potion={" + System.identityHashCode(this) + "})" );
    }
}
