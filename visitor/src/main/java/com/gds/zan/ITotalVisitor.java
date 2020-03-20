package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-20 13:36
 */
public interface ITotalVisitor extends IVisitor {
    // 统计所有员工工资总和
    void totalSalary();
}
