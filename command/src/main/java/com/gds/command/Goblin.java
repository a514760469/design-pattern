package com.gds.command;

/**
 * @author zhanglifeng
 * @since 2020-03-04 11:22
 */
public class Goblin extends Target {

    public Goblin() {
        setSize(Size.NORMAL);
        setVisibility(Visibility.VISIBLE);
    }

    @Override
    public String toString() {
        return "Goblin";
    }
}
