package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-16 17:42
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.setCurrentState(new ConcreteState1());
        context.handler1();
        context.handler2();
    }
}
