package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-16 17:21
 */
public class ConcreteState2 extends State {

    public ConcreteState2() {
        super(new Context());
    }

    @Override
    public void handler1() {
        context.setCurrentState(Context.STATE1);
        context.handler1();
    }

    @Override
    public void handler2() {
        // 本状态下必须处理的逻辑
        System.out.println("ConcreteState2.handler2");
    }

}
