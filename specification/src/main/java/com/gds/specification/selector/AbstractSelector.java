package com.gds.specification.selector;

import java.util.function.Predicate;

/**
 * 抽象选择器
 *
 * @author zhanglifeng
 * @since 2020-03-27 10:34
 */
public abstract class AbstractSelector<T> implements Predicate<T> {

    /**
     * @param other
     * @return ConjunctionSelector : 连续选择器 当前选择器和other都通过 则通过
     */
    public AbstractSelector<T> and(AbstractSelector<T> other) {
        return new ConjunctionSelector<>(this, other);
    }

    /**
     * @param other
     * @return DisjunctionSelector 分解选择器 当前选择器和other有一个通过 则通过
     */
    public AbstractSelector<T> or(AbstractSelector<T> other) {
        return new DisjunctionSelector<>(this, other);
    }

    /**
     *
     * @return NegationSelector 否定选择器，当前选择器不通过的 则通过
     */
    public AbstractSelector<T> not() {
        return new NegationSelector<>(this);
    }
}
