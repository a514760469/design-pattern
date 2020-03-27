package com.gds.specification.property;

/**
 * @author zhanglifeng
 * @since 2020-03-26 15:43
 */
public enum Color {

    DARK("dark"),
    LIGHT("light"),
    GREEN("green"),
    RED("red");

    private String title;

    Color(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
