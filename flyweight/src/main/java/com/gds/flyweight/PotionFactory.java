package com.gds.flyweight;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author zhanglifeng
 * @since 2020-03-02 17:19
 */
public class PotionFactory {

    private final Map<PotionType, Potion> potions;

    public PotionFactory() {
        potions = new EnumMap<>(PotionType.class);
    }

    Potion createPotion(PotionType potionType) {
        Potion potion = potions.get(potionType);
        if (potion == null) {
            switch (potionType) {
                case HEALING:
                    potion = new HealingPotion();
                    potions.put(potionType, potion);
                    break;
                case HOLY_WATER:
                    potion = new HolyWaterPotion();
                    potions.put(potionType, potion);
                    break;
                case INVISIBILITY:
                    potion = new InvisibilityPotion();
                    potions.put(potionType, potion);
                    break;
                default:
                    break;
            }
        }
        return potion;
    }

    enum PotionType {

        HEALING, INVISIBILITY, STRENGTH, HOLY_WATER, POISON
    }

}
