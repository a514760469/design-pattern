package com.gds.linux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhanglifeng
 * @since 2020-03-23 13:46
 */
public class LinuxCmd {

    public static void main(String[] args) throws IOException {
        Invoker invoker = new Invoker();
        while (true) {
            // UNIX下的默认提示符号
            System.out.print("#");
            // 捕获输出
            String input = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            // 输入quit或exit则退出
            if (input.equals("quit") || input.equals("exit")) {
                return;
            }
            System.out.println(invoker.exec(input));
        }
    }
}
