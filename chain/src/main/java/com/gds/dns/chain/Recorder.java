package com.gds.dns.chain;

/**
 * @author zhanglifeng
 * @since 2020-04-03 17:55
 */
public class Recorder {

    private String domain;// 域名

    private String ip;// ip

    private String owner;// 属主

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "域名=" + domain + '\n' +
                "ip=" + ip + '\n' +
                "解析者=" + owner + '\n';
    }
}
