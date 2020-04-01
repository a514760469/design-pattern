package com.gds.async.invocation;

import java.util.concurrent.Callable;

/**
 * @author zhanglifeng
 * @since 2020-03-30 16:47
 */
public class App {

    public static void main(String[] args) throws Exception {
        ThreadAsyncExecutor executor = new ThreadAsyncExecutor();
        AsyncResult<Integer> asyncResult1 = executor.startProcess(lazyVal(10, 500));
        AsyncResult<String> asyncResult2 = executor.startProcess(lazyVal("test", 300));
        AsyncResult<Long> asyncResult3 = executor.startProcess(lazyVal(50L, 700));
        AsyncResult<Integer> asyncResult4 = executor.startProcess(lazyVal(20, 400), callback("回调 result 4"));
        AsyncResult<String> asyncResult5 = executor.startProcess(lazyVal("Callback", 600), callback("回调 result 5"));

        Thread.sleep(350);
//        Integer result1 = executor.endProcess(asyncResult1);
//        String result2 = executor.endProcess(asyncResult2);
//        Long result3 = executor.endProcess(asyncResult3);
//        asyncResult4.await();
//        asyncResult5.await();

        System.out.println("Result 1: " + asyncResult1.getValue());
        System.out.println("Result 2: " + asyncResult2.getValue());
        System.out.println("Result 3: " + asyncResult3.getValue());
        System.out.println("Result 4: " + asyncResult4.getValue());
        System.out.println("Result 5: " + asyncResult5.getValue());

    }

    private static <T> Callable<T> lazyVal(T value, long delayMillis) {
        return () -> {
            Thread.sleep(delayMillis);
            System.out.println("任务完成: " + value);
            return value;
        };
    }

    private static <T> AsyncCallback<T> callback(String name) {
        return (value, ex) -> {
            if (ex != null) {
                System.err.println(name + " 失败: " + ex.getMessage());
            } else {
                System.out.println(name + " : " + value);
            }
        };
    }
}
