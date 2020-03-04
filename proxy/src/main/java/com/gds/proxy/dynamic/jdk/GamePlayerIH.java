package com.gds.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhanglifeng
 * @since 2020-03-03 15:23
 */
public class GamePlayerIH implements InvocationHandler {

    /**
     * 被代理者
     */
    private final Object gamePlayer;

    private Class cls;

    public GamePlayerIH(Object gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        preInvoke(gamePlayer);
        Object invoke = method.invoke(gamePlayer, args);
        // post
        postInvoke(gamePlayer, method);
        return invoke;
    }


    private void preInvoke(Object o) {
        System.out.println("pre");
    }

    private void postInvoke(Object o, Method method) {
        System.out.println("post");
        if (method.getName().equalsIgnoreCase("login")) {
            System.out.println("有人在用我的账号登录");
        }
    }
}
