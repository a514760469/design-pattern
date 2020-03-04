package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-03 18:16
 */
public class PageGroup implements Group {

    @Override
    public void find() {
        System.out.println("找到美工组...");
    }

    @Override
    public void add() {
        System.out.println("客户要求增加一个页面...");
    }

    @Override
    public void delete() {
        System.out.println("客户要求删除一个页面...");
    }

    @Override
    public void change() {
        System.out.println("客户要求修改一个页面...");
    }

    @Override
    public void plan() {
        System.out.println("客户要求页面变更计划...");
    }
}
