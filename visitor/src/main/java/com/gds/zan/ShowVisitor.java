package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-20 13:28
 */
public class ShowVisitor implements IShowVisitor {

    private String info = "";

    @Override
    public void report() {
        System.out.println(info);
    }

    @Override
    public void visitManager(ManagerEmployee employee) {
        this.info += basicInfo(employee) + "业绩啊：" + employee.getPerformance() + "\t\n";
    }
    // 访问普通员工，组装信息
    @Override
    public void visitCommonEmployee(CommonEmployee employee) {
        this.info += basicInfo(employee) + "工作啊：" + employee.getJob() + "\t\n";
    }


    private String basicInfo(Employee employee) {
        return "姓名：" + employee.getName() + "\t" +
                "性别：" + employee.getSex().getInfo() + "\t" +
                "薪水：" + employee.getSalary() + "\t";
    }
}
