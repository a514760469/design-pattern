package com.gds.state;

/**
 * @author zhanglifeng
 * @since 2020-03-16 15:45
 */
public class AngryState implements State {

    private Mammoth mammoth;

    public AngryState(Mammoth mammoth) {
        this.mammoth = mammoth;
    }

    @Override
    public void onEnterState() {
        System.out.println(mammoth + "生气了！");
    }

    @Override
    public void observe() {
        System.out.println(mammoth + "是愤怒的");
    }
}
