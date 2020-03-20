package com.gds.visitor;

/**
 * @author zhanglifeng
 * @since 2020-03-19 17:41
 */
public class SergeantVisitor implements UnitVisitor {


    @Override
    public void visitSoldier(Soldier soldier) {

    }

    @Override
    public void visitSergeant(Sergeant sergeant) {
        System.out.println("hello " + sergeant);
    }

    @Override
    public void visitCommander(Commander commander) {

    }
}
