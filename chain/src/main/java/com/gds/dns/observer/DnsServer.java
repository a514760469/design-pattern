package com.gds.dns.observer;

import com.gds.dns.chain.Recorder;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/**
 * 抽象DNS 服务器 既是观察者也是被观察者，形成观察链
 * @author zhanglifeng
 * @since 2020-04-03 18:37
 */
public abstract class DnsServer extends Observable implements Observer {


    @Override
    public void update(Observable o, Object arg) {
        Recorder recorder = (Recorder) arg;
        if (isLocal(recorder)) {
            recorder.setIp(genIpAddress());
        } else {
            responseFromUpperServer(recorder);
        }
        // 签名
        sign(recorder);
    }

    /**
     * 作为被观察者，允许增加观察者，
     * @param dnsServer
     */
    public void setUpperServer(DnsServer dnsServer) {
        super.deleteObservers();
        super.addObserver(dnsServer);
    }

    /**
     * 向父DNS请求解析，也就是通知观察者
     * @param recorder
     */
    private void responseFromUpperServer(Recorder recorder) {
        super.setChanged();
        super.notifyObservers(recorder);
    }

    /**
     * 当前服务器是否可以处理
     */
    protected abstract boolean isLocal(Recorder recorder);

    /**
     * 签名
     */
    protected abstract void sign(Recorder recorder);

    /**
     * 模拟产生一个IP地址
     */
    private String genIpAddress() {
        Random rand = new Random();
        return rand.nextInt(255) + "." + rand.nextInt(255) + "."+ rand.nextInt(255) + "."+ rand.nextInt(255);
    }
}
