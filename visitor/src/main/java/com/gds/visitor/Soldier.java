package com.gds.visitor;

/**
 * @author zhanglifeng
 * @since 2020-03-19 17:35
 */
public class Soldier extends Unit {

    public Soldier(Unit... children) {
        super(children);
    }

    @Override
    public void accept(UnitVisitor visitor) {
        visitor.visitSoldier(this);
        super.accept(visitor);
    }

    @Override
    public String toString() {
        return "Soldier";
    }
}
