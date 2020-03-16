package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-16 16:34
 */
public class OpeningState extends LiftState {


    @Override
    public void open() {
        System.out.println("开门");
    }

    @Override
    public void close() {
        super.lift.changeLiftState(new ClosingState());
        super.lift.close();
    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }
}
