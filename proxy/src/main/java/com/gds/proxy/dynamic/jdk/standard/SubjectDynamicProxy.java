package com.gds.proxy.dynamic.jdk.standard;

import java.lang.reflect.Proxy;

/**
 * @author zhanglifeng
 * @since 2020-03-03 16:34
 */
public class SubjectDynamicProxy {

    public static <T> T newProxyInstance(Subject subject) {
        ClassLoader classLoader = subject.getClass().getClassLoader();
        Class<?>[] interfaces = subject.getClass().getInterfaces();
        MyInvocationHandler ih = new MyInvocationHandler(subject);
        //noinspection unchecked
        return (T) Proxy.newProxyInstance(classLoader, interfaces, ih);
    }

}
