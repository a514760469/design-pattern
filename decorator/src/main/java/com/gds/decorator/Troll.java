package com.gds.decorator;

/**
 * @author zhanglifeng
 * @since 2020-02-21 17:34
 */
public interface Troll {
    /**
     * 攻击
     */
    void attack();

    /**
     * 获取攻击强度
     * @return
     */
    int getAttackPower();

    /**
     * 脱离战斗
     */
    void fleeBattle();

}
