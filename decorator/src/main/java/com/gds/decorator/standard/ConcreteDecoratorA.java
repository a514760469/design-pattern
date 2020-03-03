package com.gds.decorator.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-02 12:06
 */
public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {

        super.operation();
        addBehavior();
    }

    protected void addBehavior() {
        System.out.println("addBehavior");
    }

}
