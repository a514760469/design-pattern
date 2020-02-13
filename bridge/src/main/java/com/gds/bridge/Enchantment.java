package com.gds.bridge;

/**
 * @author zhanglifeng
 * @since 2020-01-21 10:35
 */
public interface Enchantment {

    void onActivate();

    void apply();

    void onDeactivate();
}
