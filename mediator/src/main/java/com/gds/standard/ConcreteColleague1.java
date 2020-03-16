package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-13 16:02
 */
public class ConcreteColleague1 extends Colleague {

    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void selfMethod1() {

    }

    public void depMethod() {
        mediator.doSomething1();
    }
}
