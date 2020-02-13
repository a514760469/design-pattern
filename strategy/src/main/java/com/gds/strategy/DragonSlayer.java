package com.gds.strategy;

/**
 * @author zhanglifeng
 * @since 2020-01-19 16:42
 * DragonSlayer uses different strategies to slay the dragon.
 * 屠龙者使用不同的策略来屠龙。
 */
public class DragonSlayer {

    private DragonSlayingStrategy dragonSlayingStrategy;

    public DragonSlayer(DragonSlayingStrategy dragonSlayingStrategy) {
        this.dragonSlayingStrategy = dragonSlayingStrategy;
    }

    public void changeStrategy(DragonSlayingStrategy strategy) {
        this.dragonSlayingStrategy = strategy;
    }

    public void goToBattle() {
        dragonSlayingStrategy.execute();
    }
}
