package com.gds.video;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author zhanglifeng
 * @since 2020-03-24 13:00
 */
public class Main {

    private static final String[] VIDEO_SUFFIXES = {".avi", ".wmv", ".mp4", ".mpeg", ".rmvb", ".mkv"};

    /**
     * ffmpeg路径：
     * D:\develop\ffmpeg-win64-static\bin\
     * 目标路径：
     * D:\develop\video
     * 输出路径：
     * D:\develop\video\out
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        String workSpace = System.getProperty("user.dir");
        System.out.println("当前进程的工作空间:" + workSpace);
        File workDir = new File(workSpace);
        String[] list = workDir.getParentFile().list();

        Scanner scanner = new Scanner(System.in);
        String ffmpeg;
        if (list != null && Stream.of(list).anyMatch(s -> s.substring(s.lastIndexOf(File.separator)).equals("ffmpeg.exe"))) {
            ffmpeg = System.getProperty("user.dir");
        } else {
            System.out.println("ffmpeg路径：");
            ffmpeg = scanner.next();
        }

        System.out.println("目标路径：");
        String path = scanner.next();
        System.out.println("输出路径：");
        String outPath = scanner.next();
        scanner.close();
        // 创建输出路径
        File outDir = new File(outPath);
        if (!outDir.exists()) {
            if (!outDir.mkdirs()) {
                System.err.println("输出路径异常:" + outPath);
                return;
            }
        }

        File file = new File(path);
        if (!file.isDirectory()) {
            System.out.println("处理文件：" + file.getAbsolutePath());
            execute(ffmpeg, file.getAbsolutePath(), outPath + File.separator + file.getName());
//            System.out.println("1:" + ffmpeg + ", 2：" + file.getAbsolutePath() + ", 3:" + outPath + file.getName());
        } else {
            // 是目录
            File[] videoFiles = file.listFiles((dir, name) -> {
                int i = name.lastIndexOf(".");
                if (i < 0) {
                    return false;
                }
                String suffix = name.substring(i);
                return Stream.of(VIDEO_SUFFIXES).anyMatch(s -> s.equalsIgnoreCase(suffix));
            });
            if (videoFiles != null) {
                for (File videoFile : videoFiles) {
                    execute(ffmpeg, videoFile.getAbsolutePath(), outDir.getAbsolutePath() + File.separator + videoFile.getName());
                }
            }
        }

    }

    public static void print(InputStream input) {
        try (InputStreamReader reader = new InputStreamReader(input, "GBK");
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                System.out.println(line);
            }
        } catch (Exception ignored) {
        }
    }

    public static void execute(String ffmpeg, String targetFile, String outPath)
            throws IOException, InterruptedException {
        List<String> cmd = Arrays.asList(
                ffmpeg + "ffmpeg",
                "-i",
                targetFile,
                "-vf",
                "drawtext=fontfile=simhei.ttf: text=风一样的老子:x=10:y=10:fontsize=24:fontcolor=white:shadowy=2",
                outPath);
        System.out.println("执行：{}" + String.join(" ", cmd));
        ProcessBuilder pb = new ProcessBuilder(cmd);

        Process process = pb.start();

        InputStream errorStream = process.getErrorStream();
        InputStream inputStream = process.getInputStream();
        print(errorStream);
        print(inputStream);
        inputStream.close();
        errorStream.close();

        process.waitFor();
    }
}
