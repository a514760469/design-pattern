package com.gds.standard;

/**
 * 抽象状态类
 * @author zhanglifeng
 * @since 2020-03-16 17:16
 */
public abstract class State {

    protected Context context;

    public State(Context context) {
        this.context = context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * 行为
     */
    public abstract void handler1();


    public abstract void handler2();
}
