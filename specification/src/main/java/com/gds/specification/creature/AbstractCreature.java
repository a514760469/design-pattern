package com.gds.specification.creature;

import com.gds.specification.property.Color;
import com.gds.specification.property.Mass;
import com.gds.specification.property.Movement;
import com.gds.specification.property.Size;

/**
 * @author zhanglifeng
 * @since 2020-03-26 15:53
 */
public abstract class AbstractCreature implements Creature {

    private String name;

    private Size size;

    private Movement movement;

    private Color color;

    private Mass mass;

    public AbstractCreature(String name, Size size, Movement movement, Color color, Mass mass) {
        this.name = name;
        this.size = size;
        this.movement = movement;
        this.color = color;
        this.mass = mass;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public Movement getMovement() {
        return movement;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Mass getMass() {
        return mass;
    }

    @Override
    public String toString() {
        return String.format("%s [size=%s, movement=%s, color=%s, mass=%s]",
                name, size, movement, color, mass);
    }
}
