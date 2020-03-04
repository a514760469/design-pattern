package com.gds.proxy;

/**
 * @author zhanglifeng
 * @since 2020-03-03 11:09
 */
public class Wizard {

    private final String name;

    public Wizard(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
