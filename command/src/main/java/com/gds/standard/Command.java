package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-03 18:40
 * 命令角色
 * 需要执行的所有命令都在这里声明
 */
public abstract class Command {
    /**
     * 每个命令类都必须有一个执行命令的方法
     */
    public abstract void execute();
}
