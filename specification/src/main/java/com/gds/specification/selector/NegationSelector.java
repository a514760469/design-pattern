package com.gds.specification.selector;

/**
 * 否定选择器
 * @author zhanglifeng
 * @since 2020-03-27 11:28
 */
public class NegationSelector<T> extends AbstractSelector<T> {

    private AbstractSelector<T> component;

    NegationSelector(AbstractSelector<T> component) {
        this.component = component;
    }

    @Override
    public boolean test(T t) {
        return !component.test(t);
    }

    @Override
    public String toString() {
        return "Negation选择器";
    }
}
