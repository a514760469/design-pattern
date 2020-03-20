package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-20 13:37
 */
public class TotalVisitor implements ITotalVisitor {

    //部门经理的工资系数是5
    private final static int MANAGER_COEFFICIENT = 5;
    //员工的工资系数是2
    private final static int COMMONEMPLOYEE_COEFFICIENT = 2;
    //普通员工的工资总和
    private int commonTotalSalary;
    //部门经理的工资总和
    private int managerTotalSalary;

    @Override
    public void totalSalary() {
        System.out.println("总额是：" + (this.commonTotalSalary + this.managerTotalSalary));
    }

    @Override
    public void visitManager(ManagerEmployee employee) {
        this.managerTotalSalary += employee.getSalary() * MANAGER_COEFFICIENT;
    }

    @Override
    public void visitCommonEmployee(CommonEmployee employee) {
        this.commonTotalSalary += employee.getSalary() * COMMONEMPLOYEE_COEFFICIENT;
    }
}
