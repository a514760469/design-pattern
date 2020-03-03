package com.gds.flyweight;

import com.gds.flyweight.PotionFactory.PotionType;

/**
 * @author zhanglifeng
 * @since 2020-03-02 17:27
 */
public class App {

    public static void main(String[] args) {
        PotionFactory factory = new PotionFactory();
        factory.createPotion(PotionType.INVISIBILITY).drink();
        factory.createPotion(PotionType.HEALING).drink();
        factory.createPotion(PotionType.HOLY_WATER).drink();

        factory.createPotion(PotionType.HEALING).drink();
        factory.createPotion(PotionType.INVISIBILITY).drink();
    }
}
