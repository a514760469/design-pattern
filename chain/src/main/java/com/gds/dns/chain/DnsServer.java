package com.gds.dns.chain;

import java.util.Random;

/**
 * 抽象DNS 服务器
 * 每个DNS （LocalDns）只保留自己区域的域名解析，
 * 对于不能解析的域名，则提交上级域名解析器解析，最终由顶级DNS解析
 * @author zhanglifeng
 * @since 2020-04-03 17:58
 */
public abstract class DnsServer {
    /**
     * 上级DNS 服务器
     */
    private DnsServer upperDnsServer;

    public void setUpperDnsServer(DnsServer upperDnsServer) {
        this.upperDnsServer = upperDnsServer;
    }

    public final Recorder resolve(String domain) {
        if (isLocal(domain)) {
            return echo(domain);
        } else {
            return upperDnsServer.resolve(domain);
        }
    }


    /**
     * 每个DNS都有一个数据区，检查域名是否在本区中
     * @param domain 域名
     */
    protected abstract boolean isLocal(String domain);

    /**
     * 解析
     * @param domain 域名
     */
    protected Recorder echo(String domain) {
        Recorder recorder = new Recorder();
        recorder.setDomain(domain);
        recorder.setIp(genIpAddress());
        return recorder;
    }

    /**
     * 模拟产生一个IP地址
     */
    private String genIpAddress() {
        Random rand = new Random();
        return rand.nextInt(255) + "." + rand.nextInt(255) + "."+ rand.nextInt(255) + "."+ rand.nextInt(255);
    }
}
