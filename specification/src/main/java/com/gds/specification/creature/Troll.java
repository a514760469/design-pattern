package com.gds.specification.creature;

import com.gds.specification.property.Color;
import com.gds.specification.property.Mass;
import com.gds.specification.property.Movement;
import com.gds.specification.property.Size;

/**
 * @author zhanglifeng
 * @since 2020-03-27 16:26
 */
public class Troll extends AbstractCreature {

    public Troll() {
        this(new Mass(4000.0));
    }

    public Troll(Mass mass) {
        super("Troll", Size.LARGE, Movement.WALKING, Color.DARK, mass);
    }
}
