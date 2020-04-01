package com.gds.ambassador;

/**
 * 添加附加功能(如日志记录、延迟检查) 的 service ambassador
 * @author zhanglifeng
 * @since 2020-03-30 15:25
 */
public class ServiceAmbassador implements RemoteServiceInterface {

    private static final int RETRIES = 3;

    private static final int DELAY_MS = 3000;

    @Override
    public long doRemoteFunction(int value) {
        return safeCall(value);
    }

    private long safeCall(int value) {
        int retries = 0;
        long result = FAILURE;

        for (int i = 0; i < RETRIES; i++) {

            if (retries >= RETRIES) {
                return FAILURE;
            }

            if ((result = checkLatency(value)) == FAILURE) {
                System.out.println("远程调用失败:(" + (i + 1) + ")");
                try {
                    Thread.sleep(DELAY_MS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                retries++;
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * 检查延迟
     * @param value
     * @return
     */
    private long checkLatency(int value) {
        long startTime = System.currentTimeMillis();
        long result = RemoteService.getRemoteService().doRemoteFunction(value);

        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("Time taken (ms):" + timeTaken);
        return result;
    }
}
