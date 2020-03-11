package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-11 13:41
 */
public interface IProject {

    void addProject(String name, int num, int cost);

    /**
     * Boss 从这里看项目信息
     * @return
     */
    String getProjectInfo();

    /**
     * 获得一个可以被遍历的对象
     * @return
     */
    IProjectIterator iterator();


}
