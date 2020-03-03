package com.gds.flyweight;

/**
 * @author zhanglifeng
 * @since 2020-03-02 17:15
 */
public class HolyWaterPotion implements Potion {

    @Override
    public void drink() {
        System.out.println("You feel 幸福. (Potion={" + System.identityHashCode(this) + "})");
    }
}
