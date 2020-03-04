package com.gds.command;

/**
 * @author zhanglifeng
 * @since 2020-03-04 10:37
 */
public abstract class Command {

    public abstract void execute(Target target);

    /**
     * 撤销
     */
    public abstract void undo();

    /**
     * 重做
     */
    public abstract void redo();

    @Override
    public abstract String toString();

}
