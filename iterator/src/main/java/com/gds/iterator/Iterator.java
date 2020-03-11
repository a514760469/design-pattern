package com.gds.iterator;

/**
 * @author zhanglifeng
 * @since 2020-03-06 16:05
 */
public interface Iterator<T> {

    boolean hasNext();

    T next();
}
