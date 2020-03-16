package com.gds.memento;

/**
 * @author zhanglifeng
 * @since 2020-03-13 16:27
 */
public enum StarType {

    SUN("sun"),
    RED_GIANT("red giant"),
    WHITE_DWARF("white dwarf"),
    SUPERNOVA("supernova"),
    DEAD("dead star"),
    UNDEFINED("");

    private String title;

    StarType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
