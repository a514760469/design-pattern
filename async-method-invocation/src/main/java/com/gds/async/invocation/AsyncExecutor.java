package com.gds.async.invocation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * 异步任务执行器
 * @author zhanglifeng
 * @since 2020-03-30 16:19
 */
public interface AsyncExecutor {

    /**
     * 开始处理异步任务。立即返回异步结果。
     * @param task 要异步执行的任务
     * @param <T> AsyncResult 的value
     * @return 任务的结果
     */
    <T> AsyncResult<T> startProcess(Callable<T> task);

    /**
     * 开始处理异步任务。立即返回异步结果。并在调用完成后执行回调函数
     * @param task 要异步执行的任务
     * @param <T> AsyncResult 的value
     * @param callback 回调函数
     * @return 任务的结果
     */
    <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback<T> callback);

    /**
     * 结束异步任务的处理。必要时阻塞当前线程并返回已完成任务的计算值。
     * @param asyncResult 异步调用的结果
     * @return 结果
     * @throws ExecutionException 如果执行失败，包含根本原因
     * @throws InterruptedException 如果执行被中断
     */
    <T> T endProcess(AsyncResult<T> asyncResult) throws ExecutionException, InterruptedException;
}
