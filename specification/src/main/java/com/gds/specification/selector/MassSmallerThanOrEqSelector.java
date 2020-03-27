package com.gds.specification.selector;

import com.gds.specification.creature.Creature;
import com.gds.specification.property.Mass;

/**
 * @author zhanglifeng
 * @since 2020-03-27 11:23
 */
public class MassSmallerThanOrEqSelector extends AbstractSelector<Creature> {

    private final Mass mass;

    public MassSmallerThanOrEqSelector(double mass) {
        this.mass = new Mass(mass);
    }

    @Override
    public boolean test(Creature creature) {
        return creature.getMass().smallerThanOrEq(mass);
    }

    @Override
    public String toString() {
        return "质量小于等于" + mass + "选择器";
    }
}
