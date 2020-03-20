package com.gds.zan;

/**
 * 该接口可以访问两个对象，一个是普通员工，一个是高层员工
 * @author zhanglifeng
 * @since 2020-03-19 18:23
 */
public interface IVisitor {

    void visitManager(ManagerEmployee employee);

    void visitCommonEmployee(CommonEmployee employee);
}
