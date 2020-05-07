package com.gds.circuit.breaker;

/**
 * 断路器模式
 * 断路器
 * @author zhanglifeng
 * @since 2020-05-07 15:04
 */
public class CircuitBreaker {

    private final long futureTime = 1000 * 1000 * 1000 * 1000;

    // 超时时间
    private final long timeout;
    // 重试周期
    private final long retryTimePeriod;
    // 失败阈值
    private final int failureThreshold;

    long lastFailureTime;

    int failureCount;

    private State state;

    /**
     *
     * @param timeout           超时时间，简单的例子中不需要
     * @param failureThreshold  故障数量 state 变为打开之前
     * @param retryTimePeriod   发送请求检查状态的时间段
     */
    CircuitBreaker(long timeout, int failureThreshold, long retryTimePeriod) {
        this.state = State.CLOSED;// 已封闭的状态开始
        this.timeout = timeout;
        this.retryTimePeriod = retryTimePeriod;
        this.failureThreshold = failureThreshold;
        // 一个荒谬的时间量，这基本上表明最后的失败从来没有发生过
        this.lastFailureTime = System.nanoTime() + futureTime;
        this.failureCount = 0;
    }

    private void reset() {
        this.state = State.CLOSED;// 已封闭的状态开始
        // 一个荒谬的时间量，这基本上表明最后的失败从来没有发生过
        this.lastFailureTime = System.nanoTime() + futureTime;
        this.failureCount = 0;
    }

    private void recordFailure() {
        failureCount += 1;
        this.lastFailureTime = System.nanoTime();
        System.out.println(this.lastFailureTime + "--记录失败次数：" + failureCount);
    }

    protected void setState() {
        // 重试次数超过阈值，远程服务器出问题
        if (failureCount > failureThreshold) {
            if ((System.nanoTime() - lastFailureTime) > retryTimePeriod) {
                // 超过阈值且超过重试时间 ：已经停了足够长的时间，应该试着检查一下是否正常
                state = State.HALF_OPEN;
            } else {
                // 超过阈值但是没有超过重试时间：服务可能还是down
                state = State.OPEN;
            }
        } else {
            // 一切正常
            state = State.CLOSED;
        }
    }

    public String getState() {
        return state.name();
    }

    /**
     * 如果已知服务中断，则提前断开;
     * 如果服务提前上线，则手动连接。
     */
    public void setStateForBypass(State state) {
        this.state = state;
    }

    /**
     * 执行服务调用
     * @param serviceToCall   服务的名字，或url
     * @param serverStartTime 实际服务器启动后 调用此服务的时间
     * @return 远程响应的值
     */
    public String call(String serviceToCall, long serverStartTime) throws Exception {
        setState();
        if (state == State.OPEN) {
            System.out.println("开启熔断");
            return "拿出缓存的api响应返回";
        } else {
            // 如果断路器不在打开的状态，发出请求
            if (serviceToCall.equals("delayedService")) {

                DelayedService delayedService = new DelayedService(20);
                String response = delayedService.response(serverStartTime);
                // 这将在一个线程中运行，并利用断路器的超时参数来了解服务是否工作
                if (response.split(" ")[3].equals("working")) {
                    // Yay!! the API responded fine. Let's reset everything.
                    reset();
                    return response;
                } else {
                    // Uh-oh!! the call still failed. Let's update that in our records.
                    recordFailure();
                    throw new Exception("Remote service not responding");
                }

            } else {
                throw new Exception("Unknown Service Name");
            }

        }

    }

    /**
     * 断路器状态
     */
    private enum State {
        CLOSED,
        OPEN,
        HALF_OPEN
    }
}
