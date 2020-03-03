package com.gds.decorator.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-02 11:24
 * 学校成绩单
 */
public interface SchoolReport {
    /**
     * 描述成绩
     */
    void report();

    /**
     * 家长签字
     */
    void sign(String name);
}
