package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-13 16:04
 */
public class ConcreteMediator extends Mediator {

    @Override
    public void doSomething1() {
        colleague1.selfMethod1();
        colleague2.selfMethod2();
    }

    @Override
    public void doSomething2() {
        colleague2.selfMethod2();
        colleague1.selfMethod1();
    }
}
