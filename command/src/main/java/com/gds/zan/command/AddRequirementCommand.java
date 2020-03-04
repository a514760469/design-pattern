package com.gds.zan.command;

/**
 * @author zhanglifeng
 * @since 2020-03-03 18:28
 * 把增加需求定义为一个命令类
 */
public class AddRequirementCommand extends Command {


    @Override
    public void execute() {
        super.rg.find();
        super.rg.add();
        super.rg.plan();
    }
}
