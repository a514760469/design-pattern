package com.gds.async.tosync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 循环等待
 * @author zhanglifeng
 * @since 2020-04-08 15:21
 */
@Slf4j
public class LoopQuery {

    private String result;

    /**
     * 循环等待，直到回调完成有结果
     * @param key
     * @return
     */
    public String query(final String key) {
        startQuery(key);
        new Thread(() -> remoteCallback(key)).start();

        String queryResult = endQuery();
        System.out.println("查询结果：" + queryResult);
        return queryResult;
    }

    /**
     * 执行远程回调
     */
    private void remoteCallback(String key) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.result = key + "-result";
        log.info("remoteCallback set result: " + result);
    }

    private void startQuery(final String key) {
        System.out.println("执行查询: " + key);
    }

    /**
     * 结束查询, 如果有结果就返回
     *
     */
    private String endQuery() {
        while (true) {
            if (null == result) {
                log.info("尝试获取结果");
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                return result;
            }
        }
    }

    public static void main(String[] args) {
        new LoopQuery().query("12345");
    }
}
