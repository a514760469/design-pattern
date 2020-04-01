package com.gds.ambassador;

/**
 * @author zhanglifeng
 * @since 2020-03-30 15:15
 */
public interface RemoteServiceInterface {

    int FAILURE = -1;

    long doRemoteFunction(int value) throws Exception;
}
