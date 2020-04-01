package com.gds.async.invocation;

import java.util.Optional;

/**
 * @author zhanglifeng
 * @since 2020-03-30 16:27
 */
@FunctionalInterface
public interface AsyncCallback<T> {

    /**
     * 完成处理程序，它在异步任务完成或执行失败时执行。
     * @param value
     * @param ex
     */
    void onComplete(T value, Exception ex);
}
