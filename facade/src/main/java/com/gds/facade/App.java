package com.gds.facade;

/**
 * @author zhanglifeng
 * @since 2020-03-02 15:57
 */
public class App {

    public static void main(String[] args) {

        DwarvenGoldmineFacade facade = new DwarvenGoldmineFacade();
        facade.startNewDay();

        facade.digOutGold();

        facade.endDay();

    }
}
