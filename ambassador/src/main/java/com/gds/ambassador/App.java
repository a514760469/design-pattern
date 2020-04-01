package com.gds.ambassador;

/**
 * @author zhanglifeng
 * @since 2020-03-30 15:49
 */
public class App {

    /**
     * 这里是使用该服务的两个客户端。
     */
    public static void main(String[] args) {
        Client host1 = new Client();
        Client host2 = new Client();
        host1.useService(12);
        host2.useService(73);
    }
}
