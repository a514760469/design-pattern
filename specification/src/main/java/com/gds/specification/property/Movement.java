package com.gds.specification.property;

/**
 * @author zhanglifeng
 * @since 2020-03-26 15:47
 */
public enum Movement {

    WALKING("walking"), SWIMMING("swimming"), FLYING("FLYING");

    private String title;

    Movement(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

}
