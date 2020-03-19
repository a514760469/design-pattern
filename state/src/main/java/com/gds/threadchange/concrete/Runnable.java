package com.gds.threadchange.concrete;

import com.gds.threadchange.ThreadContext;
import com.gds.threadchange.ThreadState;

/**
 * @author zhanglifeng
 * @since 2020-03-17 13:33
 */
public class Runnable extends ThreadState {

    public Runnable() {
        setStateName("就绪状态");
        System.out.println("当前线程处于：" + getStateName());
    }

    public void getCpu(ThreadContext tc) {
        System.out.print("获得CPU时间-->");
        if (stateName.equals("就绪状态")) {
            tc.setThreadState(new Running());
        } else {
            System.out.println("当前线程不是就绪状态，不能获取CPU.");
        }
    }
}
