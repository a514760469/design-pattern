package com.gds.bridge;

import javax.sound.midi.Soundbank;

/**
 * @author zhanglifeng
 * @since 2020-01-21 10:36
 */
public class Hammer implements Weapon {

    private final Enchantment enchantment;

    /**
     * 有参构造，把产品传递进来
     * @param enchantment
     */
    public Hammer(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    @Override
    public void wield() {
        System.out.println("锤子开始使用。");
        enchantment.onActivate();
    }

    @Override
    public void swing() {
        System.out.println("锤子挥了起来");
        enchantment.apply();
    }

    @Override
    public void unwield() {
        System.out.println("锤收起来。");
        enchantment.onDeactivate();
    }

    @Override
    public Enchantment getEnchantment() {
        return enchantment;
    }
}
