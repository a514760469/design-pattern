package com.gds.specification.creature;

import com.gds.specification.property.Color;
import com.gds.specification.property.Mass;
import com.gds.specification.property.Movement;
import com.gds.specification.property.Size;

/**
 * 生物
 * @author zhanglifeng
 * @since 2020-03-26 15:46
 */
public interface Creature {

    String getName();

    Size getSize();

    Movement getMovement();

    Color getColor();

    Mass getMass();

}
