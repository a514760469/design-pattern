package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-20 11:09
 */
public class ConcreteElementB extends Element {

    @Override
    public void doSomething() {
        // 业务处理
    }

    @Override
    public void accept(IVisitor visitor) {
        // visitor.visit(this);
    }
}
