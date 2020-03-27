package com.gds.specification.selector;

import com.gds.specification.creature.Creature;
import com.gds.specification.property.Size;

/**
 * @author zhanglifeng
 * @since 2020-03-27 11:26
 */
public class SizeSelector extends AbstractSelector<Creature> {

    private final Size size;

    public SizeSelector(Size size) {
        this.size = size;
    }

    @Override
    public boolean test(Creature creature) {
        return size.equals(creature.getSize());
    }

    @Override
    public String toString() {
        return size + "size选择器";
    }
}
