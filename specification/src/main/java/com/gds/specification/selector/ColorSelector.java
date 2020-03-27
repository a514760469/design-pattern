package com.gds.specification.selector;

import com.gds.specification.creature.Creature;
import com.gds.specification.property.Color;

/**
 * 颜色选择器
 * @author zhanglifeng
 * @since 2020-03-27 10:36
 */
public class ColorSelector extends AbstractSelector<Creature> {

    private final Color color;

    public ColorSelector(Color color) {
        this.color = color;
    }

    @Override
    public boolean test(Creature creature) {
//        System.out.println("当前生物：" + creature);
        return color.equals(creature.getColor());
    }

    @Override
    public String toString() {
        return color + "color选择器";
    }
}
