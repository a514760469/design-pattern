package com.gds.ambassador;

import static java.lang.Thread.sleep;

/**
 * @author zhanglifeng
 * @since 2020-03-30 15:16
 */
public class RemoteService implements RemoteServiceInterface {

    private static RemoteService remoteService;

    static synchronized RemoteService getRemoteService() {
        if (remoteService == null) {
            remoteService = new RemoteService();
        }
        return remoteService;
    }

    private RemoteService() {}

    @Override
    public long doRemoteFunction(int value) {
        long waitTime = (long) Math.floor(Math.random() * 1000);

        try {
            sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return waitTime >= 200 ? value * 10 : -1;
    }
}
