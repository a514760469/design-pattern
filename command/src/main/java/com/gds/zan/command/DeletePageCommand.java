package com.gds.zan.command;

/**
 * @author zhanglifeng
 * @since 2020-03-03 18:22
 */
public class DeletePageCommand extends Command {

    @Override
    public void execute() {
        pg.find();
        pg.delete();
        pg.plan();
    }
}
