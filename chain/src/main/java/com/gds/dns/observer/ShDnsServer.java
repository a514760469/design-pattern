package com.gds.dns.observer;

import com.gds.dns.chain.Recorder;

/**
 * @author zhanglifeng
 * @since 2020-04-07 11:23
 */
public class ShDnsServer extends DnsServer {

    @Override
    protected boolean isLocal(Recorder recorder) {
        return recorder.getDomain().endsWith(".sh.cn");
    }

    @Override
    protected void sign(Recorder recorder) {
        recorder.setOwner("上海DNS服务器");
    }
}
