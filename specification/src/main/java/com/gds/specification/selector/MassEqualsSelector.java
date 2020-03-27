package com.gds.specification.selector;

import com.gds.specification.creature.Creature;
import com.gds.specification.property.Mass;

/**
 * 质量Mass 与参数完全相等的选择器
 * @author zhanglifeng
 * @since 2020-03-27 11:17
 */
public class MassEqualsSelector extends AbstractSelector<Creature> {

    private final Mass mass;

    public MassEqualsSelector(double mass) {
        this.mass = new Mass(mass);
    }

    @Override
    public boolean test(Creature creature) {
//        System.out.println("当前生物：" + creature);
        return creature.getMass().equals(mass);
    }

    @Override
    public String toString() {
        return "质量等于" + mass + "选择器";
    }
}
