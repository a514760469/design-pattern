package com.gds.async.invocation;

import java.util.concurrent.ExecutionException;

/**
 * 异步调用的结果
 * @param <T> getValue 返回的类型
 * @author zhanglifeng
 * @since 2020-03-30 16:09
 */
public interface AsyncResult<T> {

    /**
     * 异步任务执行的状态。
     * @return true 如果完成或失败
     */
    boolean isCompleted();

    /**
     * 获取完成后异步任务的值
     * @return 如果成功，返回T
     * @throws ExecutionException 执行失败
     * @throws IllegalStateException 方法未执行完成
     */
    T getValue() throws ExecutionException;

    /**
     * 阻塞当前线程，直到异步任务完成
     * @throws InterruptedException 如果执行被中断
     */
    void await() throws InterruptedException;

}
