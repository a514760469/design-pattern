package com.gds.facade;

/**
 * @author zhanglifeng
 * @since 2020-03-02 15:52
 */
public class DwarvenGoldDigger extends DwarvenMineWorker {

    @Override
    public void work() {
        System.out.println(name() + " digs for gold.");
    }

    @Override
    public String name() {
        return getClass().getSimpleName();
    }
}
