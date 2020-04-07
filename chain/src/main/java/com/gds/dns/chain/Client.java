package com.gds.dns.chain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhanglifeng
 * @since 2020-04-03 18:14
 */
public class Client {

    public static void main(String[] args) throws IOException {
        DnsServer sh = new ShDnsServer();
        DnsServer china = new ChinaTopDnsServer();
        DnsServer top = new TopDnsServer();
        sh.setUpperDnsServer(china);
        china.setUpperDnsServer(top);

        System.out.println("=====域名解析模拟器=====");
        while (true) {
            System.out.print("\n请输入域名(输入N退出):");
            String domain = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            if (domain.equalsIgnoreCase("n")) {
                return;
            }
            Recorder recorder = sh.resolve(domain);
            System.out.println("----DNS服务器解析结果----");
            System.out.println(recorder);
        }

    }
}
