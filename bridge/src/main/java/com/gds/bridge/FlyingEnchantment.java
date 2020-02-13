package com.gds.bridge;

/**
 * @author zhanglifeng
 * @since 2020-01-21 10:45
 */
public class FlyingEnchantment implements Enchantment {

    @Override
    public void onActivate() {
        System.out.println("物品开始微微发光。");
    }

    @Override
    public void apply() {
        System.out.println("该物品飞行和打击敌人，最后回到主人的手。");
    }

    @Override
    public void onDeactivate() {
        System.out.println("物品的辉光消失。");
    }
}
