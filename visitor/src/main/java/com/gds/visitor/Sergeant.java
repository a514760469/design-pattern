package com.gds.visitor;

/**
 * @author zhanglifeng
 * @since 2020-03-19 17:36
 */
public class Sergeant extends Unit {

    public Sergeant(Unit... children) {
        super(children);
    }


    @Override
    public void accept(UnitVisitor visitor) {
        visitor.visitSergeant(this);
        super.accept(visitor);
    }

    @Override
    public String toString() {
        return "Sergeant ";
    }
}
