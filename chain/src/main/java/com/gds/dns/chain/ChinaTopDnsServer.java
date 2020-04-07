package com.gds.dns.chain;

/**
 * @author zhanglifeng
 * @since 2020-04-03 18:12
 */
public class ChinaTopDnsServer extends DnsServer {


    @Override
    protected boolean isLocal(String domain) {
        return domain.endsWith(".cn");
    }

    @Override
    protected Recorder echo(String domain) {
        Recorder echo = super.echo(domain);
        echo.setOwner("中国顶级DNS");
        return echo;
    }
}
