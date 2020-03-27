package com.gds.specification.property;

/**
 * @author zhanglifeng
 * @since 2020-03-26 15:46
 */
public enum Size {

    SMALL("small"), NORMAL("normal"), LARGE("large");

    private String title;

    Size(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
