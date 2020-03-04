package com.gds.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zhanglifeng
 * @since 2020-03-03 15:30
 */
public class Client {

    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("张三");
        InvocationHandler ih = new GamePlayerIH(player);
        IGamePlayer o = (IGamePlayer) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IGamePlayer.class}, ih);
        o.login("zhangsan", "123456");
        o.killBoss();
        o.upgrade();
    }

}
