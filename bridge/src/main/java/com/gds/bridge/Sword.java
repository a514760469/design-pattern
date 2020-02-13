package com.gds.bridge;

/**
 * @author zhanglifeng
 * @since 2020-01-21 10:34
 */
public class Sword implements Weapon {

    private final Enchantment enchantment;

    public Sword(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    @Override
    public void wield() {
        System.out.println("剑出鞘了。");
        enchantment.onActivate();
    }

    @Override
    public void swing() {
        System.out.println("剑在挥动。");
        enchantment.apply();
    }

    @Override
    public void unwield() {
        System.out.println("剑被收起。");
        enchantment.onDeactivate();
    }

    @Override
    public Enchantment getEnchantment() {
        return enchantment;
    }
}
