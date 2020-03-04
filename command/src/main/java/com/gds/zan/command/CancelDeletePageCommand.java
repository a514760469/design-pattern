package com.gds.zan.command;

/**
 * @author zhanglifeng
 * @since 2020-03-04 10:26
 */
public class CancelDeletePageCommand extends Command {

    @Override
    public void execute() {
        rg.rollback();
    }
}
