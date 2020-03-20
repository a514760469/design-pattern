package com.gds.zan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglifeng
 * @since 2020-03-19 18:41
 */
public class Client {

    public static void main(String[] args) {
        List<Employee> list = mockEmployee();
        ShowVisitor showVisitor = new ShowVisitor();
        ITotalVisitor totalVisitor = new TotalVisitor();
        for (Employee emp : list) {
            emp.accept(new Visitor());
            emp.accept(totalVisitor);
//            emp.accept(showVisitor);
//            emp.accept(new SalaryVisitor());
        }
        showVisitor.report();
        totalVisitor.totalSalary();
    }

    // 模拟出公司的人员情况，我们可以想象这个数据是通过持久层传递过来的
    public static List<Employee> mockEmployee(){
        List<Employee> empList = new ArrayList<>();
        // 产生张三这个员工
        CommonEmployee zhangSan = new CommonEmployee();
        zhangSan.setJob("编写Java程序，绝对的蓝领、苦工加搬运工");
        zhangSan.setName("张三");
        zhangSan.setSalary(1800);
        zhangSan.setSex(Employee.Sex.MALE);
        empList.add(zhangSan);
        // 产生李四这个员工
        CommonEmployee liSi = new CommonEmployee();
        liSi.setJob("页面美工，审美素质太不流行了！");
        liSi.setName("李四");
        liSi.setSalary(1900);
        liSi.setSex(Employee.Sex.FEMALE);
        empList.add(liSi);
        // 再产生一个经理
        ManagerEmployee wangWu = new ManagerEmployee();
        wangWu.setName("王五");
        wangWu.setPerformance("基本上是负值，但是我会拍马屁呀");
        wangWu.setSalary(18750);
        wangWu.setSex(Employee.Sex.MALE);
        empList.add(wangWu);
        return empList;
    }
}
