package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-19 18:42
 */
public class Visitor implements IVisitor {

    @Override
    public void visitManager(ManagerEmployee employee) {
        System.out.println(this.getManagerEmployee(employee));
    }

    @Override
    public void visitCommonEmployee(CommonEmployee employee) {
        System.out.println(this.getCommonEmployee(employee));
    }

    /**
     * 基本信息
     */
    private String getBasicInfo(Employee employee) {
        String info = "姓名：" + employee.getName() + "\t";
        info = info + "性别：" + employee.getSex().getInfo() + "\t";
        info = info + "薪水：" + employee.getSalary() + "\t";
        return info;
    }

    /**
     * 普通员工信息
     */
    private String getCommonEmployee(CommonEmployee commonEmployee) {
        String basic = this.getBasicInfo(commonEmployee);
        String otherInfo = "工作：" + commonEmployee.getJob() + "\t";
        return basic + otherInfo;
    }

    /**
     * 经理员工信息
     */
    private String getManagerEmployee(ManagerEmployee managerEmployee) {
        String basic = this.getBasicInfo(managerEmployee);
        String otherInfo = "业绩：" + managerEmployee.getPerformance() + "\t";
        return basic + otherInfo;
    }
}
