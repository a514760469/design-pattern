package com.gds.bridge;

/**
 * @author zhanglifeng
 * @since 2020-01-21 10:49
 */
public class App {

    public static void main(String[] args) {
        Sword sword = new Sword(new SoulEatingEnchantment());
        sword.wield();
        sword.swing();
        sword.unwield();

        Hammer hammer = new Hammer(new FlyingEnchantment());
        hammer.wield();
        hammer.swing();
        hammer.unwield();

    }
}
