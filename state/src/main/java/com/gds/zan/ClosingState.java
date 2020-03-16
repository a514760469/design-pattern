package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-16 16:34
 */
public class ClosingState extends LiftState {

    @Override
    public void open() {
        lift.changeLiftState(new OpeningState());
        lift.open();
    }

    @Override
    public void close() {
        System.out.println("电梯门关闭");
    }

    @Override
    public void run() {
        lift.changeLiftState(new RunningState());
        lift.run();
    }

    @Override
    public void stop() {
        lift.changeLiftState(new StoppingState());
        lift.stop();
    }
}
