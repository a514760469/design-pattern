package com.gds.decorator.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-02 12:04
 */
public abstract class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }

    public static void main(String[] args) {
        Component cc = new ConcreteDecoratorB(new ConcreteDecoratorA(new ConcreteComponent()));
        cc.operation();
    }
}
