package com.gds.bridge;

/**
 * @author zhanglifeng
 * @since 2020-01-21 10:46
 */
public class SoulEatingEnchantment implements Enchantment {

    @Override
    public void onActivate() {
        System.out.println("物品释放嗜血");
    }

    @Override
    public void apply() {
        System.out.println("该物品会吞噬敌人的灵魂。");
    }

    @Override
    public void onDeactivate() {
        System.out.println("嗜血慢慢消失了。");
    }
}
