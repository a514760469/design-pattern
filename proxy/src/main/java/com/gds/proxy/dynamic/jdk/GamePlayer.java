package com.gds.proxy.dynamic.jdk;

/**
 * @author zhanglifeng
 * @since 2020-03-03 14:43
 */
public class GamePlayer implements IGamePlayer {

    private String name;

    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void login(String username, String password) {
        System.out.println("登录：username：" + username + ", password:" + password);
    }

    @Override
    public void killBoss() {
        System.out.println(name + ":打怪");
    }

    @Override
    public void upgrade() {
        System.out.println(name + ":升级");
    }
}
