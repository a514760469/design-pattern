package com.gds.visitor;

/**
 * @author zhanglifeng
 * @since 2020-03-19 17:30
 */
public interface UnitVisitor {

    void visitSoldier(Soldier soldier);

    void visitSergeant(Sergeant sergeant);

    void visitCommander(Commander commander);

}
