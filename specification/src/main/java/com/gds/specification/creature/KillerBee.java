package com.gds.specification.creature;

import com.gds.specification.property.Color;
import com.gds.specification.property.Mass;
import com.gds.specification.property.Movement;
import com.gds.specification.property.Size;

/**
 * @author zhanglifeng
 * @since 2020-03-27 16:08
 */
public class KillerBee extends AbstractCreature {

    public KillerBee() {
        this(new Mass(6.7));
    }

    public KillerBee(Mass mass) {
        super("KillerBee", Size.SMALL, Movement.FLYING, Color.LIGHT, mass);
    }
}
