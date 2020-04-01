package com.gds.async.invocation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 异步执行器的实现，为每个任务创建一个新线程。
 * @author zhanglifeng
 * @since 2020-03-30 16:48
 */
public class ThreadAsyncExecutor implements AsyncExecutor {

    /**
     * Index for thread naming.
     */
    private final AtomicInteger idx = new AtomicInteger(0);

    @Override
    public <T> AsyncResult<T> startProcess(Callable<T> task) {
        return startProcess(task, null);
    }

    @Override
    public <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback<T> callback) {
        CompletableResult<T> result = new CompletableResult<>(callback);
        new Thread(() -> {
            try {
                result.setValue(task.call());
            } catch (Exception e) {
                result.setException(e);
            }
        }, "executor-" + idx.decrementAndGet()).start();
        return result;
    }

    @Override
    public <T> T endProcess(AsyncResult<T> asyncResult) throws ExecutionException, InterruptedException {
        if (!asyncResult.isCompleted()) {
            asyncResult.await();
        }
        return asyncResult.getValue();
    }

    /**
     *
     * @param <T>
     */
    private static class CompletableResult<T> implements AsyncResult<T> {

        private static final int RUNNING = 1;
        private static final int FAILED = 2;
        private static final int COMPLETED = 3;

        final Object lock;
        final AsyncCallback<T> callback;

        volatile int state = RUNNING;
        T value;
        Exception exception;

        CompletableResult(AsyncCallback<T> callback) {
            this.callback = callback;
            this.lock = new Object();
        }

        /**
         * 成功时设置成功执行的值，并在可用时执行回调。通知任何 waiting 的线程。
         * @param value 成功执行的值
         */
        public void setValue(T value) {
            this.value = value;
            this.state = COMPLETED;
            if (this.callback != null) {
                this.callback.onComplete(value, exception);
            }

            synchronized (lock) {
                lock.notifyAll();
            }
        }

        /**
         * 失败时从失败的执行中设置异常，并在可用时执行回调。
         * @param exception
         */
        public void setException(Exception exception) {
            this.exception = exception;
            this.state = FAILED;
            if (this.callback != null) {
                this.callback.onComplete(null, exception);
            }

            synchronized (lock) {
                lock.notifyAll();
            }
        }

        @Override
        public boolean isCompleted() {
            return this.state > RUNNING;
        }

        @Override
        public T getValue() throws ExecutionException {
            if (state == COMPLETED) {
                return value;
            } else if (state == FAILED) {
                throw new ExecutionException(exception);
            } else {
                throw new IllegalStateException("执行尚未完成：" + Thread.currentThread().getName());
            }
        }

        @Override
        public void await() throws InterruptedException {
            synchronized (lock) {
                while (!isCompleted()) {
                    // 导致当前线程等待，直到另一个线程调用此对象的notify()方法或notifyAll()方法。
                    lock.wait();
                }
            }
        }
    }
}
