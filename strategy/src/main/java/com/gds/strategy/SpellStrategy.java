package com.gds.strategy;

/**
 * @author zhanglifeng
 * @since 2020-01-19 16:40
 */
public class SpellStrategy implements DragonSlayingStrategy {

    @Override
    public void execute() {
        System.out.println("你施放了解离咒，龙就在一堆尘埃中蒸发了!");
    }
}
