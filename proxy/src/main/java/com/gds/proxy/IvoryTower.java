package com.gds.proxy;

/**
 * @author zhanglifeng
 * @since 2020-03-03 11:11
 */
public class IvoryTower implements WizardTower {

    @Override
    public void enter(Wizard wizard) {
        System.out.println(wizard + " 进入塔。");
    }
}
