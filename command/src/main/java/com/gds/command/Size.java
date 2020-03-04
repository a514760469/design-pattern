package com.gds.command;

/**
 * @author zhanglifeng
 * @since 2020-03-04 10:41
 */
public enum Size {

    SMALL("small"), NORMAL("normal");

    private String title;

    Size(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
