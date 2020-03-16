package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-16 16:23
 */
public class Client {

    public static void main(String[] args) {
        Lift lift = new Lift(new OpeningState());
        lift.close();
        lift.run();
        lift.stop();
        lift.open();
    }
}
