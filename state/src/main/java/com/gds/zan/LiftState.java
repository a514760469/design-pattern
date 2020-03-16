package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-16 16:01
 */
public abstract class LiftState {

    /**电梯*/
    protected Lift lift;

    public void setLift(Lift lift) {
        this.lift = lift;
    }

    protected abstract void open();

    protected abstract void close();

    protected abstract void run();

    protected abstract void stop();

//    public enum State {
//        OPENING_STATE,// 1
//        CLOSING_STATE,// 2
//        RUNNING_STATE,// 3
//        STOPPING_STATE;// 4
//    }


}
