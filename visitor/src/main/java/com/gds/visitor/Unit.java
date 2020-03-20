package com.gds.visitor;

import java.util.Arrays;

/**
 * @author zhanglifeng
 * @since 2020-03-19 17:29
 */
public abstract class Unit {

    private Unit[] children;

    public Unit(Unit... children) {
        this.children = children;
    }

    public void accept(UnitVisitor visitor) {
        Arrays.stream(children).forEach(child -> child.accept(visitor));
    }
}
