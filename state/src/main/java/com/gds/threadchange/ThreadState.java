package com.gds.threadchange;

/**
 * 抽象线程状态
 * 具体状态类:
 * 新建状态（New）、就绪状态（Runnable ）、
 * 运行状态（Running）、阻塞状态（Blocked）和死亡状态（Dead）
 * @author zhanglifeng
 * @since 2020-03-17 13:26
 */
public abstract class ThreadState {

    protected String stateName;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
