package com.gds.facade;

import java.util.Arrays;

/**
 * @author zhanglifeng
 * @since 2020-03-02 15:44
 */
public abstract class DwarvenMineWorker {

    public void goToSleep() {
        System.out.println(name() + " goes to sleep.");
    }

    public void wakeUp() {
        System.out.println(name() + " wakes up.");
    }

    public void goHome() {
        System.out.println(name() + " goes home.");
    }

    public void goToMine() {
        System.out.println(name() + " goes to the mine.");
    }

    private void action(Action action) {
        switch (action) {
            case GO_TO_SLEEP:
                goToSleep();
                break;
            case WAKE_UP:
                wakeUp();
                break;
            case GO_HOME:
                goHome();
                break;
            case GO_TO_MINE:
                goToMine();
                break;
            case WORK:
                work();
                break;
            default:
                System.out.println("Undefined action");
                break;
        }
    }

    public void action(Action... actions) {
        Arrays.stream(actions).forEach(this::action);
    }

    public abstract void work();

    public abstract String name();

    enum Action {
        GO_TO_SLEEP, WAKE_UP, GO_HOME, GO_TO_MINE, WORK
    }

}
