package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-20 11:08
 */
public interface IVisitor {

    // 可以访问哪些对象
    void visit(ConcreteElementA elementA);
    void visit(ConcreteElementB elementB);
}
