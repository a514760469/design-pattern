package com.gds.linux;

import java.io.*;

/**
 * @author zhanglifeng
 * @since 2020-03-23 15:28
 */
public class FileManager {

    public static String ls(String path) {
        return "file1\nfile2\nfile3\nfile4";
    }

    public static String ls_l(String path) {
        String str = "drw-rw-rw root system 1024 2009-8-20 10:23 file1\n";
        str = str + "drw-rw-rw root system 1024 2009-8-20 10:23 file2\n";
        str = str + "drw-rw-rw root system 1024 2009-8-20 10:23 file3";
        return str;
    }

    public static String ls_a(String path) {
        return ".\n..\nfile1\nfile2\nfile3";
    }

    public static void main(String[] args) throws IOException {
        Process process = Runtime.getRuntime().exec("ping www.baidu.com");
//        ProcessBuilder pb = new ProcessBuilder("test.bat")
//                .directory(new File("C:\\Users\\EDZ\\Desktop\\cmd"));
//        Process process = pb.start();

        try (InputStream ips = process.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(ips, "GBK"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
