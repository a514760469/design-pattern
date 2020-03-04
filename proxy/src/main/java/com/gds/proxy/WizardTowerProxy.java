package com.gds.proxy;

/**
 * @author zhanglifeng
 * @since 2020-03-03 11:12
 */
public class WizardTowerProxy implements WizardTower {

    private static final int NUM_WIZARDS_ALLOWED = 3;

    private int numWizards;

    private final WizardTower wizardTower;

    public WizardTowerProxy(WizardTower wizardTower) {
        this.wizardTower = wizardTower;
    }

    @Override
    public void enter(Wizard wizard) {
        if (numWizards < NUM_WIZARDS_ALLOWED) {
            wizardTower.enter(wizard);
            numWizards++;
        } else {
            System.out.println(wizard + " 不允许进入。");
        }
    }
}
