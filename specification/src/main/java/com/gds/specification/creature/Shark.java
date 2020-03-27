package com.gds.specification.creature;

import com.gds.specification.property.Color;
import com.gds.specification.property.Mass;
import com.gds.specification.property.Movement;
import com.gds.specification.property.Size;

/**
 * @author zhanglifeng
 * @since 2020-03-27 16:25
 */
public class Shark extends AbstractCreature {

    public Shark() {
        this(new Mass(500.0));
    }

    public Shark(Mass mass) {
        super("Shark", Size.NORMAL, Movement.SWIMMING, Color.LIGHT, mass);
    }
}
