package com.gds.bridge;

/**
 * @author zhanglifeng
 * @since 2020-01-21 10:33
 */
public interface Weapon {

    void wield();

    void swing();

    void unwield();

    // 附魔
    Enchantment getEnchantment();
}
