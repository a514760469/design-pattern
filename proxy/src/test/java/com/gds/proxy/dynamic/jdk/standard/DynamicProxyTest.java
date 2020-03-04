package com.gds.proxy.dynamic.jdk.standard;

import org.junit.Test;

/**
 * @author zhanglifeng
 * @since 2020-03-03 16:18
 */
public class DynamicProxyTest {

    @Test
    public void testNewProxyInstance() {
        Subject subject = new RealSubject();
        Subject proxy = SubjectDynamicProxy.newProxyInstance(subject);
        proxy.doSomething("finish");
    }
}