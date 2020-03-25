package com.gds.linux.command;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author zhanglifeng
 * @since 2020-03-23 13:55
 */
public class CommandVO {

    // 定义参数名与参数的分隔符号,一般是空格
    private final static String DIVIDE_FLAG = " ";

    // 定义参数前的符号，Unix一般是-,如ls -la
    private final static String PREFIX = "-";

    // 命令名，如ls、du
    private String commandName = "";

    // 参数列表
    private List<String> paramList = new ArrayList<>();

    // 操作数列表
    private List<String> dataList = new ArrayList<>();

    public CommandVO(String commandStr) {

        if (commandStr != null && commandStr.length() != 0) {
            // 根据分隔符号拆分出执行符号
            String[] complexStr = commandStr.split(CommandVO.DIVIDE_FLAG);
            // 第一个参数是执行符号
            this.commandName = complexStr[0].trim();
            // 把参数放到List中
            for (int i = 1; i < complexStr.length; i++) {
                String str = complexStr[i];
                // 包含前缀符号，认为是参数
                if (str.indexOf(CommandVO.PREFIX) == 0) {
                    this.paramList.add(str.replace(CommandVO.PREFIX, "").trim());
                } else {
                    this.dataList.add(str.trim());
                }
            }

        } else {
            System.out.println("命令解析失败，必须传递一个命令才能执行！");
        }

    }

    public String getCommandName() {
        return commandName;
    }

    public List<String> getParamList() {
        if (this.paramList.isEmpty()){
            this.paramList.add("");
        }
        return new ArrayList<>(new HashSet<>((this.paramList)));
    }

    public List<String> getDataList() {
        return dataList;
    }
}
