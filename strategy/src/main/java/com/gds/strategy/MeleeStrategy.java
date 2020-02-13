package com.gds.strategy;

/**
 * @author zhanglifeng
 * @since 2020-01-19 16:39
 */
public class MeleeStrategy implements DragonSlayingStrategy {
    @Override
    public void execute() {
        System.out.println("用你的神剑你砍下了龙头!");
    }
}
