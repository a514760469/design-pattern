package com.gds.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author zhanglifeng
 * @since 2020-01-17 13:19
 * 通用的builder模式构建器
 */
public class Builder<T> {

    private final Supplier<T> instantiator;

    private List<Consumer<T>> modifiers = new ArrayList<>();

    public Builder(Supplier<T> instantiator) {
        this.instantiator = instantiator;
    }

    public static <T> Builder<T> of(Supplier<T> instantiator) {
        return new Builder<T>(instantiator);
    }

    public <P1> Builder<T> with(Consumer1<T, P1> consumer, P1 p1) {
        Consumer<T> c = instance -> consumer.accept(instance, p1);
        this.modifiers.add(c);
        return this;
    }

    public <P1, P2> Builder<T> with(Consumer2<T, P1, P2> consumer, P1 p1, P2 p2) {
        Consumer<T> c = instance -> consumer.accept(instance, p1, p2);
        this.modifiers.add(c);
        return this;
    }

    public <P1, P2, P3> Builder<T> with(Consumer3<T, P1, P2, P3> consumer, P1 p1, P2 p2, P3 p3) {
        Consumer<T> c = (instance) -> consumer.accept(instance, p1, p2, p3);
        this.modifiers.add(c);
        return this;
    }

    public T build() {
        T t = instantiator.get();
        modifiers.forEach(modifier -> modifier.accept(t));
        modifiers.clear();
        return t;
    }

    /**
     * 1参数
     * @param <T>
     * @param <P1>
     */
    public interface Consumer1<T, P1> {
        void accept(T t, P1 p1);
    }

    /**
     * 2参数
     * @param <T>
     * @param <P1>
     * @param <P2>
     */
    public interface Consumer2<T, P1, P2> {
        void accept(T t, P1 p1, P2 p2);
    }

    /**
     * 3参数
     * @param <T>
     * @param <P1>
     * @param <P2>
     * @param <P3>
     */
    public interface Consumer3<T, P1, P2, P3> {
        void accept(T t, P1 p1, P2 p2, P3 p3);
    }

}
