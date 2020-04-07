package com.gds.dns.chain;

/**
 * @author zhanglifeng
 * @since 2020-04-03 18:13
 */
public class TopDnsServer extends DnsServer {

    @Override
    protected boolean isLocal(String domain) {
        return true;
    }

    @Override
    protected Recorder echo(String domain) {
        Recorder echo = super.echo(domain);
        echo.setOwner("全球顶级DNS");
        return echo;
    }
}
