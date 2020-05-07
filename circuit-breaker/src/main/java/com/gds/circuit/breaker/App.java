package com.gds.circuit.breaker;

import java.util.concurrent.TimeUnit;

/**
 * 断路器三中状态 Close、 Half-Open、 Open
 * Close (默认)表示正常；
 * 每次调用失败我们都会记录而且一旦超过阈值，Open，防止对服务的进一步调用；
 * 之后再过一段时间 period(希望这段时间服务恢复), 再次调用, 这种状态为Half-Open。
 * 它将一直保持到服务停止，一旦恢复，它将回到关闭状态，如此循环往复。
 * @author zhanglifeng
 * @since 2020-05-07 16:20
 */
public class App {

    public static void main(String[] args) {
        MonitoringService service = new MonitoringService();

        CircuitBreaker circuitBreaker = new CircuitBreaker(3000, 1, TimeUnit.SECONDS.toNanos(10));

        long serverStartTime = System.nanoTime();

        while (true) {
            System.out.println(service.localResourceResponse());
            System.out.println(service.remoteResourceResponse(circuitBreaker, serverStartTime));
            System.out.println("断路器状态：" + circuitBreaker.getState());
            System.out.println();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }

    }
}
