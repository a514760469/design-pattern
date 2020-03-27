package com.gds.specification.selector;

import com.gds.specification.creature.Creature;
import com.gds.specification.property.Movement;

/**
 * @author zhanglifeng
 * @since 2020-03-27 11:25
 */
public class MovementSelector extends AbstractSelector<Creature> {

    private final Movement movement;

    public MovementSelector(Movement movement) {
        this.movement = movement;
    }

    @Override
    public boolean test(Creature creature) {
//        System.out.println("当前生物：" + creature);
        return movement.equals(creature.getMovement());
    }

    @Override
    public String toString() {
        return movement + "movement选择器";
    }
}
