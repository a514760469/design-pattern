package com.gds.circuit.breaker;

/**
 * 模拟远程服务，在设定超时时间后响应
 * @author zhanglifeng
 * @since 2020-05-07 15:58
 */
public class DelayedService {

    private final int delay;

    public DelayedService(int delay) {
        this.delay = delay;
    }

    public DelayedService() {
        this(60);
    }

    /**
     *
     * @param serverStartTime 服务启动后，调用此服务的时间
     * @return 服务器状态
     */
    public String response(long serverStartTime) {
        long currentTime = System.nanoTime();
        // 由于currentTime和serverStartTime都是以纳秒为单位的，所以我们将其转换为秒
        // 然后我们检查它是否大于或小于指定的延迟，然后发送回复
        double m = (currentTime - serverStartTime) * 1.0 / (1000 * 1000 * 1000);
        System.out.println("调用延迟：" + m + ", 给定延迟：" + delay);
        if (m < delay) {
            return "Delayed service is down";
        } else {
            return "Delayed service is working";
        }
    }

}
