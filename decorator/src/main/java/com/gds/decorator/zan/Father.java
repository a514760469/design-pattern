package com.gds.decorator.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-02 11:27
 */
public class Father {
    public static void main(String[] args) {
        SchoolReport sr = new FourthGradeSchoolReport();
        sr = new HighScoreDecorator(sr);// 第一次修饰
        sr = new SortDecorator(sr);// 第二次修饰
        sr.report();
        sr.sign("laosan");

    }
}
