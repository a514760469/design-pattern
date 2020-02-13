package com.gds.strategy;

/**
 * @author zhanglifeng
 * @since 2020-01-19 16:38
 */
public class ProjectileStrategy implements DragonSlayingStrategy {

    @Override
    public void execute() {
        System.out.println("你用魔法弩射龙，它倒在地上死了");
    }
}
