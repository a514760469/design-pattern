package com.gds.command;

/**
 * @author zhanglifeng
 * @since 2020-03-04 10:42.
 * 可见性
 */
public enum Visibility {

    /**
     * 可见的
     */
    VISIBLE("visible"),
    /**
     * 不可见的
     */
    INVISIBLE("invisible");

    private String title;

    Visibility(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
