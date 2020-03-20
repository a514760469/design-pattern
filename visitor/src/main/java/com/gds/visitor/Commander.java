package com.gds.visitor;

/**
 * @author zhanglifeng
 * @since 2020-03-19 17:36
 */
public class Commander extends Unit {

    public Commander(Unit... children) {
        super(children);
    }


    @Override
    public void accept(UnitVisitor visitor) {
        visitor.visitCommander(this);
        super.accept(visitor);
    }

    @Override
    public String toString() {
        return "Commander ";
    }
}
