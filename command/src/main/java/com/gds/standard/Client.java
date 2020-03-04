package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-04 10:11
 */
public class Client {

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.setCommand(new ConcreteCommandA(new ConcreteReceiverA()));
        invoker.action();
    }
}
