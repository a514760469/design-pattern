package com.gds.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhanglifeng
 * @since 2020-02-21 17:42
 */
public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        Troll troll = new SimpleTroll();
        troll.attack();
        troll.fleeBattle();
        LOGGER.info("Simple troll power {}.\n", troll.getAttackPower());

        LOGGER.info("一个拿着大棒子的巨魔会让你大吃一惊.");
        Troll clubbedTroll = new ClubbedTroll(troll);
        clubbedTroll.attack();
        clubbedTroll.fleeBattle();
        LOGGER.info("Clubbed troll power {}.\n", clubbedTroll.getAttackPower());
    }
}
