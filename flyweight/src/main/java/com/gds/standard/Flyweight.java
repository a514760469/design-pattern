package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-02 18:15
 * 抽象享元类。
 * 所有具体享元类的超类或者接口，通过这个接口，
 * Flyweight可以接受并作用于外部专题
 */
public abstract class Flyweight {

    /**
     * 内部状态 可共享出来的信息
     * (Intrinsic State)
     */
    private String inState;

    /**
     * 外部状态 需要外部环境来设置的不能共享的内容
     * (Extrinsic State)
     */
    protected final String outState;

    protected Flyweight(String outState) {
        this.outState = outState;
    }

    public abstract void operation();

    public String getInState() {
        return inState;
    }

    public void setInState(String inState) {
        this.inState = inState;
    }

    public String getOutState() {
        return outState;
    }
}
