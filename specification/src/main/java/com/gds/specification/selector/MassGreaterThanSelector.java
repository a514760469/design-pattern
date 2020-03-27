package com.gds.specification.selector;

import com.gds.specification.creature.Creature;
import com.gds.specification.property.Mass;

/**
 * 质量Mass 大于参数的选择器
 * @author zhanglifeng
 * @since 2020-03-27 11:20
 */
public class MassGreaterThanSelector extends AbstractSelector<Creature> {

    private final Mass mass;

    public MassGreaterThanSelector(double mass) {
        this.mass = new Mass(mass);
    }

    @Override
    public boolean test(Creature creature) {
//        System.out.println("当前生物：" + creature);
        return creature.getMass().greaterThan(mass);
    }

    @Override
    public String toString() {
        return "质量大于" + mass + "选择器";
    }
}
