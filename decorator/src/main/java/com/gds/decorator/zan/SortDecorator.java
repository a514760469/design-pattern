package com.gds.decorator.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-02 11:38
 */
public class SortDecorator extends Decorator {

    public SortDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    /**
     * 告诉老爸学校的排名情况, 老爸看完成绩单后再告诉他，加强作用
     */
    @Override
    public void report() {
        super.report();
        this.reportSort();
    }

    private void reportSort(){
        System.out.println("我是排名第38名...");
    }
}
