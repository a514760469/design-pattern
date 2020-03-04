package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-03 18:42
 */
public class ConcreteReceiverB implements Receiver {

    @Override
    public void doSomething() {
        System.out.println("ConcreteReceiverB.doSomething");
    }
}
