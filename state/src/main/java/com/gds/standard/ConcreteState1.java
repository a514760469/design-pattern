package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-16 17:21
 */
public class ConcreteState1 extends State {

    public ConcreteState1() {
        super(new Context());
    }

    @Override
    public void handler1() {
        // 本状态下必须处理的逻辑
        System.out.println("ConcreteState1.handler1");
    }

    @Override
    public void handler2() {
        context.setCurrentState(Context.STATE2);
        context.handler2();
    }

}
