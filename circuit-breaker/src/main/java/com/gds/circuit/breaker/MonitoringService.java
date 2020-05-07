package com.gds.circuit.breaker;

/**
 * @author zhanglifeng
 * @since 2020-05-07 17:05
 */
public class MonitoringService {

    private final String serviceName = "delayedService";

    /**
     * @return 假设本地服务不会失败
     */
    public String localResourceResponse() {
        return "Local Service is working";
    }

    /**
     * 尝试从远程服务器获取结果
     */
    public String remoteResourceResponse(CircuitBreaker circuitBreaker, long serverStartTime) {
        try {
            return circuitBreaker.call(serviceName, serverStartTime);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
