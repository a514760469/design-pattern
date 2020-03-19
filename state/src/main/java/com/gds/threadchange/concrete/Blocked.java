package com.gds.threadchange.concrete;

import com.gds.threadchange.ThreadContext;
import com.gds.threadchange.ThreadState;

/**
 * 阻塞状态
 *
 * @author zhanglifeng
 * @since 2020-03-17 13:35
 */
public class Blocked extends ThreadState {

    public Blocked() {
        setStateName("阻塞状态");
        System.out.println("当前线程处于：" + getStateName());
    }

    /**
     * 唤醒
     */
    public void resume(ThreadContext tc) {
        System.out.print("调用resume()方法-->");
        if (stateName.equals("阻塞状态")) {
            tc.setThreadState(new Runnable());
        } else {
            System.out.println("当前线程不是阻塞状态，不能调用resume()方法.");
        }
    }
}
