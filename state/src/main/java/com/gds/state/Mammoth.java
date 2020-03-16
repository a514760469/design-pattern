package com.gds.state;

/**
 * @author zhanglifeng
 * @since 2020-03-16 15:46
 */
public class Mammoth {

    private State state;

    public Mammoth() {
        this.state = new PeacefulState(this);
    }

    public void timePassed() {
        if (state.getClass().equals(PeacefulState.class)) {
            changeStateTo(new AngryState(this));
        } else {
            changeStateTo(new PeacefulState(this));
        }
    }

    private void changeStateTo(State newState) {
        this.state = newState;
        this.state.onEnterState();
    }

    @Override
    public String toString() {
        return "Mammoth ";
    }

    public void observe() {
        this.state.observe();
    }
}
