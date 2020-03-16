package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-16 16:35
 */
public class RunningState extends LiftState {

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public void run() {
        System.out.println("电梯运行");
    }

    @Override
    public void stop() {
        lift.changeLiftState(new StoppingState());
        lift.stop();
    }
}
