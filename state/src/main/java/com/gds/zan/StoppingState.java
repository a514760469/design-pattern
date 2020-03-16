package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-16 16:35
 */
public class StoppingState extends LiftState {

    @Override
    public void open() {
        lift.changeLiftState(new OpeningState());
        lift.open();
    }

    @Override
    public void close() {

    }

    @Override
    public void run() {
        lift.changeLiftState(new RunningState());
        lift.run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止");
    }
}
