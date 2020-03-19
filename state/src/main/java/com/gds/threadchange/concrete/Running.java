package com.gds.threadchange.concrete;

import com.gds.threadchange.ThreadContext;
import com.gds.threadchange.ThreadState;

/**
 * @author zhanglifeng
 * @since 2020-03-17 13:33
 */
public class Running extends ThreadState {

    public Running() {
        stateName = "运行状态";
        System.out.println("当前线程处于：" + getStateName());
    }

    /**
     * 挂起
     */
    public void suspend(ThreadContext tc) {
        System.out.print("调用suspend()方法-->");
        if (stateName.equals("运行状态")) {
            tc.setThreadState(new Blocked());
        } else {
            System.out.println("当前线程不是运行状态，不能调用suspend()方法.");
        }
    }

    public void stop(ThreadContext tc) {
        System.out.print("调用stop()方法-->");
        if (stateName.equals("运行状态")) {
            tc.setThreadState(new Dead());
        } else {
            System.out.println("当前线程不是运行状态，不能调用stop()方法.");
        }
    }
}
