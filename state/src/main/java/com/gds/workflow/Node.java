package com.gds.workflow;

/**
 * 相当于State类
 * @author zhanglifeng
 * @since 2020-03-16 18:05
 */
public abstract class Node {

    /**节点名称*/
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 处理
     */
    public abstract void nodeHandler(FlowContext context);

}
