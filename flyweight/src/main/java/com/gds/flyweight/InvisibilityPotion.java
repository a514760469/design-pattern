package com.gds.flyweight;

/**
 * @author zhanglifeng
 * @since 2020-03-02 17:17
 */
public class InvisibilityPotion implements Potion {

    @Override
    public void drink() {
        System.out.println("You 隐形. (Potion={" + System.identityHashCode(this) + "})");
    }
}
