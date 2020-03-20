package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-20 11:24
 */
public class SalaryVisitor implements IVisitor {

    @Override
    public void visitManager(ManagerEmployee employee) {
        System.out.println("manager:" + employee.getSalary() * 1.5);
    }

    @Override
    public void visitCommonEmployee(CommonEmployee employee) {
        System.out.println("employee:" + employee.getSalary() * 1.2);
    }
}
