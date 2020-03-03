package com.gds.decorator.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-02 12:06
 */
public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        addState();
        super.operation();
    }

    protected void addState() {
        System.out.println("addState");
    }
}
