package com.gds.proxy.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-03 13:26
 */
public class RealSubject implements Subject {

    @Override
    public void request() {

        System.out.println("RealSubject.request()");
    }
}
