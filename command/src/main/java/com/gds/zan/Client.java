package com.gds.zan;

import com.gds.zan.command.AddRequirementCommand;
import com.gds.zan.command.CancelDeletePageCommand;
import com.gds.zan.command.DeletePageCommand;

/**
 * @author zhanglifeng
 * @since 2020-03-03 18:32
 */
public class Client {

    public static void main(String[] args) {
        Invoker xiaoA = new Invoker(new AddRequirementCommand());
        xiaoA.action();
        xiaoA.setCommand(new DeletePageCommand());
        xiaoA.action();
        xiaoA.setCommand(new CancelDeletePageCommand());
        xiaoA.action();
    }
}
