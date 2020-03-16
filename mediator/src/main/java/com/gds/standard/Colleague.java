package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-13 16:02
 */
public abstract class Colleague {

    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
