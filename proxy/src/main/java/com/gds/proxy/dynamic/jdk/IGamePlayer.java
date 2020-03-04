package com.gds.proxy.dynamic.jdk;

/**
 * @author zhanglifeng
 * @since 2020-03-03 14:42
 */
public interface IGamePlayer {

    void login(String username, String password);

    void killBoss();

    void upgrade();
}
