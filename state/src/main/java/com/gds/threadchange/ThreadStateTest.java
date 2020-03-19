package com.gds.threadchange;

/**
 * @author zhanglifeng
 * @since 2020-03-17 14:11
 */
public class ThreadStateTest {

    public static void main(String[] args) {
        ThreadContext context = new ThreadContext();
        context.start();
        context.getCPU();
        context.suspend();
        context.resume();
        context.getCPU();
        context.stop();
    }
}
