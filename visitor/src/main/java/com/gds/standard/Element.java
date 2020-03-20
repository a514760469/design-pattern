package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-20 11:07
 */
public abstract class Element {

    // 业务逻辑
    public abstract void doSomething();

    // 访问方法
    public abstract void accept(IVisitor visitor);
}
