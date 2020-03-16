package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-16 17:23
 */
public class Context {

    public static final State STATE1 = new ConcreteState1();
    public static final State STATE2 = new ConcreteState2();

    private State currentState;

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        // 切换状态
        this.currentState.setContext(this);
    }

    /**
     * 行为委托
     */
    public void handler1() {
        currentState.handler1();
    }

    public void handler2() {
        currentState.handler2();
    }
}
