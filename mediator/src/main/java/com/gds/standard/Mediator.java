package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-13 16:01
 */
public abstract class Mediator {

    protected ConcreteColleague1 colleague1;

    protected ConcreteColleague2 colleague2;

    public void setColleague1(ConcreteColleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(ConcreteColleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    // 中介者业务逻辑
    public abstract void doSomething1();
    public abstract void doSomething2();
}
