package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-03 18:40
 * 调用者角色
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }

}
