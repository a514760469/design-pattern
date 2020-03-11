package com.gds.zan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglifeng
 * @since 2020-03-11 13:44
 */
public class Project implements IProject {

    /**
     * 定义一个项目列表
     */
    private List<IProject> projectList = new ArrayList<>();

    private String name;

    private int num;

    private int cost;

    public Project() {
    }

    public Project(String name, int num, int cost) {
        this.name = name;
        this.num = num;
        this.cost = cost;
    }

    @Override
    public void addProject(String name, int num, int cost) {
        this.projectList.add(new Project(name, num, cost));
    }

    @Override
    public String getProjectInfo() {
        String info = "";
        // 获得项目的名称
        info = info+ "项目名称是：" + this.name;
        // 获得项目人数
        info = info + "\t项目人数："+ this.num;
        // 项目费用
        info = info+ "\t项目费用："+ this.cost;
        return info;
    }

    @Override
    public IProjectIterator iterator() {
        return new ProjectIterator(this.projectList);
    }
}
