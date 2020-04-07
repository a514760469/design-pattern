package com.gds.dns.chain;

/**
 * @author zhanglifeng
 * @since 2020-04-03 18:10
 */
public class ShDnsServer extends DnsServer {

    @Override
    protected boolean isLocal(String domain) {
        return domain.endsWith(".sh.cn");
    }

    @Override
    protected Recorder echo(String domain) {
        Recorder echo = super.echo(domain);
        echo.setOwner("上海DNS");
        return echo;
    }
}
