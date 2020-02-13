package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-02-13 16:31
 * 抽象构件
 */
public abstract class Component {
    /**
     * 个体和整体都具有的共享
     */
    public void doSomething() {
        System.out.println("Component doSomething");
    }
}
