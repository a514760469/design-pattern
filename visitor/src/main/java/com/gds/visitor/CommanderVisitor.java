package com.gds.visitor;

/**
 * @author zhanglifeng
 * @since 2020-03-19 17:43
 */
public class CommanderVisitor implements UnitVisitor {

    @Override
    public void visitSoldier(Soldier soldier) {

    }

    @Override
    public void visitSergeant(Sergeant sergeant) {

    }

    @Override
    public void visitCommander(Commander commander) {
        System.out.println("good to see you " + commander);
    }
}
