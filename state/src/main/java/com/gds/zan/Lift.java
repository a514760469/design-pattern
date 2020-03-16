package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-16 15:57
 */
public class Lift implements ILift {

    private LiftState state;

    public Lift(LiftState state) {
        changeLiftState(state);
    }

    public void changeLiftState(LiftState state) {
        this.state = state;
        this.state.setLift(this);
    }

    public LiftState getLiftState() {
        return state;
    }

    @Override
    public void open() {
        state.open();
    }

    @Override
    public void close() {
        state.close();
    }

    @Override
    public void run() {
        state.run();
    }

    @Override
    public void stop() {
        state.stop();
    }

//    private void openWithoutLogic() {
//        System.out.println("开门");
//    }
//
//    private void closeWithoutLogic() {
//        System.out.println("关门");
//    }
//
//    private void runWithoutLogic() {
//        System.out.println("运行");
//    }
//
//    private void stopWithoutLogic() {
//        System.out.println("停止");
//    }

}
