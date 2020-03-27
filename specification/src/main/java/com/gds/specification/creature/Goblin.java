package com.gds.specification.creature;

import com.gds.specification.property.Color;
import com.gds.specification.property.Mass;
import com.gds.specification.property.Movement;
import com.gds.specification.property.Size;

/**
 * @author zhanglifeng
 * @since 2020-03-27 13:24
 */
public class Goblin extends AbstractCreature {

    public Goblin() {
        this(new Mass(30.0));
    }

    public Goblin(Mass mass) {
        super("Goblin", Size.SMALL, Movement.WALKING, Color.GREEN, mass);
    }
}
