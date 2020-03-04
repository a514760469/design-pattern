package com.gds.proxy;

/**
 * @author zhanglifeng
 * @since 2020-03-03 11:15
 */
public class App {
    public static void main(String[] args) {

        WizardTowerProxy proxy = new WizardTowerProxy(new IvoryTower());
        proxy.enter(new Wizard("Red wizard"));
        proxy.enter(new Wizard("White wizard"));
        proxy.enter(new Wizard("Black wizard"));
        proxy.enter(new Wizard("Green wizard"));
        proxy.enter(new Wizard("Brown wizard"));


    }
}
