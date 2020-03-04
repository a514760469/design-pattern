package com.gds.command;

/**
 * @author zhanglifeng
 * @since 2020-03-04 13:48
 */
public class App {

    public static void main(String[] args) {
        Wizard wizard = new Wizard();
        Goblin goblin = new Goblin();
        goblin.printStatus();

        wizard.castSpell(new ShrinkSpell(), goblin);
        goblin.printStatus();

        wizard.castSpell(new InvisibilitySpell(), goblin);
        goblin.printStatus();

        wizard.undoLastSpell();
        goblin.printStatus();

        wizard.undoLastSpell();
        goblin.printStatus();

        wizard.redoLastSpell();
        goblin.printStatus();

        wizard.redoLastSpell();
        goblin.printStatus();
    }
}
