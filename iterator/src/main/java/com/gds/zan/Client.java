package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-11 17:51
 */
public class Client {

    public static void main(String[] args) {
        // 定义一个List，存放所有的项目对象
        IProject project = new Project();
        // 增加星球大战项目
        project.addProject("星球大战项目", 10, 100000);
        // 增加扭转时空项目
        project.addProject("扭转时空项目", 100, 10000000);
        // 增加超人改造项目
        project.addProject("超人改造项目", 10000, 1000000000);
        // 这边100个项目
        for (int i = 4; i < 104; i++) {
            project.addProject("第" + i + "个项目", i * 5, i * 1000000);
        }
        // 遍历一下ArrayList，把所有的数据都取出
        IProjectIterator projectIterator = project.iterator();
        while (projectIterator.hasNext()) {
            IProject p = projectIterator.next();
            System.out.println(p.getProjectInfo());
        }

    }
}
