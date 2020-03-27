package com.gds.specification.creature;

import com.gds.specification.property.Color;
import com.gds.specification.property.Mass;
import com.gds.specification.property.Movement;
import com.gds.specification.property.Size;

/**
 * @author zhanglifeng
 * @since 2020-03-27 16:24
 */
public class Octopus extends AbstractCreature {

    public Octopus() {
        this(new Mass(12.0));
    }

    public Octopus(Mass mass) {
        super("Octopus", Size.NORMAL, Movement.SWIMMING, Color.DARK, mass);
    }
}
