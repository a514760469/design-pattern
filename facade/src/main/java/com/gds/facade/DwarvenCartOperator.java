package com.gds.facade;

/**
 * @author zhanglifeng
 * @since 2020-03-02 15:53
 */
public class DwarvenCartOperator extends DwarvenMineWorker {

    @Override
    public void work() {
        System.out.println(name() + " moves gold chunks out of the mine.");
    }

    @Override
    public String name() {
        return getClass().getSimpleName();
    }
}
