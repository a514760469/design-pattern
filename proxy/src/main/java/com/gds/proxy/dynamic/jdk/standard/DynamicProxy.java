package com.gds.proxy.dynamic.jdk.standard;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zhanglifeng
 * @since 2020-03-03 15:57
 */
public class DynamicProxy<T> {

    public static <T> T newProxyInstance(ClassLoader classLoader, Class<?>[] interfaces, InvocationHandler h) {
        boolean tip = Boolean.valueOf("true");
        if (tip) {
            new BeforeAdvice().exec();
        }
        // noinspection unchecked
        return (T) Proxy.newProxyInstance(classLoader, interfaces, h);
    }

}
