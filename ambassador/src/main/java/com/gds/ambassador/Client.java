package com.gds.ambassador;

/**
 * @author zhanglifeng
 * @since 2020-03-30 15:48
 */
public class Client {

    private final ServiceAmbassador serviceAmbassador = new ServiceAmbassador();

    long useService(int value) {
        long result = serviceAmbassador.doRemoteFunction(value);
        System.out.println("Service 结果：" + result);
        return result;
    }
}
