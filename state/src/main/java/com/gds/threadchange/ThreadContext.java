package com.gds.threadchange;

import com.gds.threadchange.concrete.Blocked;
import com.gds.threadchange.concrete.New;
import com.gds.threadchange.concrete.Runnable;
import com.gds.threadchange.concrete.Running;

/**
 * 环境类
 *
 * @author zhanglifeng
 * @since 2020-03-17 13:30
 */
public class ThreadContext {

    private ThreadState threadState;

    public ThreadContext() {
        this.threadState = new New();
    }

    public ThreadState getThreadState() {
        return threadState;
    }

    public void setThreadState(ThreadState threadState) {
        this.threadState = threadState;
    }

    public void start() {
        ((New) threadState).start(this);
    }

    public void getCPU() {
        ((Runnable) threadState).getCpu(this);
    }

    public void suspend() {
        ((Running) threadState).suspend(this);
    }

    public void stop() {
        ((Running) threadState).stop(this);
    }

    public void resume() {
        ((Blocked) threadState).resume(this);
    }


}
