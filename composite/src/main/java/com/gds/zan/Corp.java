package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-01-21 16:56
 * 变ICorp接口为抽象类
 */
public abstract class Corp {

    private String name;
    private String position;
    private int salary;

    public Corp(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getInfo() {
        return "姓名：" + this.name +
                "\t职位：" + this.position +
                "\t薪水：" + this.salary;
    }
}
