package com.gds.state;

/**
 * @author zhanglifeng
 * @since 2020-03-16 15:46
 */
public class PeacefulState implements State {

    private Mammoth mammoth;

    public PeacefulState(Mammoth mammoth) {
        this.mammoth = mammoth;
    }

    @Override
    public void onEnterState() {
        System.out.println(mammoth + "冷静下来。");
    }

    @Override
    public void observe() {
        System.out.println(mammoth + "很平静。");
    }
}
