package com.gds.zan;

import com.gds.zan.command.Command;

/**
 * @author zhanglifeng
 * @since 2020-03-03 18:31
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }

}
