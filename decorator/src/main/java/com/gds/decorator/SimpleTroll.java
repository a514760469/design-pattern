package com.gds.decorator;

/**
 * @author zhanglifeng
 * @since 2020-02-21 17:36
 */
public class SimpleTroll implements Troll {

    @Override
    public void attack() {
        System.out.println("巨魔想抓住你!");
    }

    @Override
    public int getAttackPower() {
        return 10;
    }

    @Override
    public void fleeBattle() {
        System.out.println("巨魔惊恐地尖叫着逃跑了!");
    }
}
