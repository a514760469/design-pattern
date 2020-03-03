package com.gds.decorator.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-02 12:03
 */
public class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("ConcreteComponent.operation() ");
    }
}
