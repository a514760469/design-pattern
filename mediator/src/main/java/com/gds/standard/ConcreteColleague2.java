package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-13 16:02
 */
public class ConcreteColleague2 extends Colleague {

    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void selfMethod2() {

    }

    public void depMethod() {
        mediator.doSomething2();
    }
}
