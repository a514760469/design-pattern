package com.gds.linux.command.ls;

import com.gds.linux.command.CommandHandler;

/**
 *
 * ls 命令抽象类，
 * 每个具体的命令都有一个抽象类
 * @author zhanglifeng
 * @since 2020-03-23 13:46
 */
public abstract class AbstractLs extends CommandHandler {

    protected final static String DEFAULT_PARAM = "";

    protected final static String A_PARAM = "a";

    protected final static String L_PARAM = "l";

}
