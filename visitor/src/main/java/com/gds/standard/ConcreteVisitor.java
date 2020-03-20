package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-20 11:14
 */
public class ConcreteVisitor implements IVisitor {

    @Override
    public void visit(ConcreteElementA elementA) {
        elementA.doSomething();
        // ...
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        elementB.doSomething();
    }
}
