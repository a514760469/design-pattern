package com.gds.proxy.dynamic.jdk.standard;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhanglifeng
 * @since 2020-03-03 15:56
 */
public class MyInvocationHandler implements InvocationHandler {

    // 被代理类
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(target, args);
    }

}
