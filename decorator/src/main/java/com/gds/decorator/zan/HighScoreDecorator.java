package com.gds.decorator.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-02 11:35
 */
public class HighScoreDecorator extends Decorator {


    public HighScoreDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    /**
     * 汇报最高成绩
     */
    @Override
    public void report() {
        this.reportHighScore();
        super.report();
    }

    private void reportHighScore(){
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }
}
