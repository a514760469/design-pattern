package com.gds.threadchange.concrete;

import com.gds.threadchange.ThreadContext;
import com.gds.threadchange.ThreadState;

/**
 * 新建状态
 *
 * @author zhanglifeng
 * @since 2020-03-17 13:28
 */
public class New extends ThreadState {

    public New() {
        stateName = "新建状态";
        System.out.println("当前线程处于：新建状态.");
    }

    /**
     * start方法
     */
    public void start(ThreadContext tc) {
        System.out.print("调用start()方法-->");
        if (stateName.equals("新建状态")) {
            // 切换状态
            tc.setThreadState(new Runnable());
        } else {
            System.out.println("当前线程不是新建状态，不能调用start()方法.");
        }
    }

}
