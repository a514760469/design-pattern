package com.gds.facade;

/**
 * @author zhanglifeng
 * @since 2020-03-02 15:51
 */
public class DwarvenTunnelDigger extends DwarvenMineWorker {

    @Override
    public void work() {
        System.out.println(name() + " creates another promising tunnel.");
    }

    @Override
    public String name() {
        return getClass().getSimpleName();
    }
}
