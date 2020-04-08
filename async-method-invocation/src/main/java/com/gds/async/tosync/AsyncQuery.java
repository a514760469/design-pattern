package com.gds.async.tosync;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 异步转同步 利用CountDownLatch
 * @author zhanglifeng
 * @since 2020-04-08 13:41
 */
public class AsyncQuery {


    private String result;

    /**
     * 异步查询，CountDownLatch 初始化1， 阻塞查询结果直到回调完成，即countDown方法被调用。
     * @param key
     */
    public void asyncQuery(final String key) {
        CountDownLatch latch = new CountDownLatch(1);
        startQuery(key);
        new Thread(() -> {
            System.out.println("远程回调线程开始");
            remoteCallback(key, latch);
            System.out.println("远程回调线程结束");
        }).start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        endQuery();
    }

    /**
     * 执行远程回调
     * @param key
     * @param latch
     */
    private void remoteCallback(String key, CountDownLatch latch) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.result = key + "-result";
        // 减少锁存计数器的个数，如果个数为0，则继续所有阻塞的线程
        latch.countDown();
    }

    private void startQuery(final String key) {
        System.out.println("执行查询：" + key);
    }

    private void endQuery() {
        System.out.println("查询结果: " + result);
    }


    public static void main(String[] args) {
        AsyncQuery async = new AsyncQuery();
        async.asyncQuery("132456");
    }
}
