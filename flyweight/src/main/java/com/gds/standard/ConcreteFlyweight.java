package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-02 18:25
 * 具体享元类。指定内部状态，为内部状态增加存储空间。
 */
public class ConcreteFlyweight extends Flyweight {


    protected ConcreteFlyweight(String outState) {
        super(outState);
    }

    @Override
    public void operation() {
        System.out.println("ConcreteFlyweight.operation");
    }
}
