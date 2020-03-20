package com.gds.visitor;

/**
 * @author zhanglifeng
 * @since 2020-03-19 17:40
 */
public class SoldierVisitor implements UnitVisitor {

    @Override
    public void visitSoldier(Soldier soldier) {
        System.out.println("Greetings " + soldier);
    }

    @Override
    public void visitSergeant(Sergeant sergeant) {

    }

    @Override
    public void visitCommander(Commander commander) {

    }
}
