package com.gds.proxy.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-03 13:26
 */
public class Proxy implements Subject {

    private final Subject subject;

    public Proxy() {
        this.subject = new RealSubject();
    }

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        // 前置通知
        preRequest();
        subject.request();
        // 后置通知
        postRequest();
    }

    private void preRequest() {

    }

    private void postRequest() {

    }
}
