package com.gds.video;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhanglifeng
 * @since 2020-03-25 18:17
 */
public class CmdProcessFactory {

    private String ffmpeg;

    private String targetFile;

    /**
     * 文字或图片路径
     */
    private String text;

    private String outPath;

    public CmdProcessFactory(String ffmpeg, String targetFile, String text, String outPath) {
        this.ffmpeg = ffmpeg;
        this.targetFile = targetFile;
        this.text = text;
        this.outPath = outPath;
    }

    /**
     * 左上角图片
     */
    public ProcessBuilder addTopLeftLogo() {
        List<String> cmd = Arrays.asList(
                ffmpeg + "ffmpeg",
                "-i",
                targetFile,
                "-i",
                text,
                "-filter_complex",
                "overlay=x=10:y=10",
                outPath);
        System.out.println("执行：{}" + String.join(" ", cmd));
        return new ProcessBuilder(cmd);
    }

    /**
     * 添加左上角文字
     */
    public ProcessBuilder addTopLeftText() {
        List<String> cmd = Arrays.asList(
                ffmpeg + "ffmpeg",
                "-i",
                targetFile,
                "-vf",
                "drawtext=fontfile=simhei.ttf: text=" + text + ":x=10:y=10:fontsize=24:fontcolor=white:shadowy=2",
                outPath);
        System.out.println("执行：{}" + String.join(" ", cmd));
        return new ProcessBuilder(cmd);
    }
}
