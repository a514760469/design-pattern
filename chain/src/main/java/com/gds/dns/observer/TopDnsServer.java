package com.gds.dns.observer;

import com.gds.dns.chain.Recorder;

/**
 * @author zhanglifeng
 * @since 2020-04-07 12:27
 */
public class TopDnsServer extends DnsServer {
    @Override
    protected boolean isLocal(Recorder recorder) {
        return true;
    }

    @Override
    protected void sign(Recorder recorder) {
        recorder.setOwner("全球顶级DNS服务器");
    }
}
