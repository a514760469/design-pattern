package com.gds.threadchange.concrete;

import com.gds.threadchange.ThreadState;

/**
 * 死亡状态
 * @author zhanglifeng
 * @since 2020-03-17 13:36
 */
public class Dead extends ThreadState {

    public Dead() {
        setStateName("死亡状态");
        System.out.println("当前线程处于：" + getStateName());
    }
}
