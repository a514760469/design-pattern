package com.gds.dns.observer;

import com.gds.dns.chain.Recorder;

/**
 * @author zhanglifeng
 * @since 2020-04-07 11:26
 */
public class ChinaTopDnsServer extends DnsServer {

    @Override
    protected boolean isLocal(Recorder recorder) {
        return recorder.getDomain().endsWith(".cn");
    }

    @Override
    protected void sign(Recorder recorder) {
        recorder.setOwner("中国顶级DNS服务器");
    }
}
