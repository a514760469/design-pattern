package com.gds.dns.observer;

import com.gds.dns.chain.Recorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhanglifeng
 * @since 2020-04-07 12:28
 */
public class Client {

    public static void main(String[] args) throws IOException {
        ShDnsServer sh = new ShDnsServer();
        ChinaTopDnsServer china = new ChinaTopDnsServer();
        TopDnsServer top = new TopDnsServer();

        sh.setUpperServer(china);
        china.setUpperServer(top);

        System.out.println("=====域名解析模拟器=====");
        while (true) {
            System.out.print("\n请输入域名(输入N退出):");
            String domain = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            if (domain.equalsIgnoreCase("n")) {
                return;
            }
            Recorder recorder = new Recorder();
            recorder.setDomain(domain);
            sh.update(null, recorder);
            System.out.println("----DNS服务器解析结果----");
            System.out.println(recorder);
        }

    }
}
