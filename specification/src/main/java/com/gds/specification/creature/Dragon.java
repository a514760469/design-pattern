package com.gds.specification.creature;

import com.gds.specification.property.Color;
import com.gds.specification.property.Mass;
import com.gds.specification.property.Movement;
import com.gds.specification.property.Size;

/**
 * @author zhanglifeng
 * @since 2020-03-26 15:56
 */
public class Dragon extends AbstractCreature {

    public Dragon() {
        this(new Mass(39300.0));
    }

    public Dragon(Mass mass) {
        super("Dragon", Size.LARGE, Movement.FLYING, Color.RED, mass);
    }
}
