package com.gds.linux.command.df;

import com.gds.linux.command.Command;
import com.gds.linux.command.CommandVO;

/**
 * @author zhanglifeng
 * @since 2020-03-23 18:23
 */
public class DfCommand extends Command {

    @Override
    public String execute(CommandVO commandVO) {
        return buildChain(AbstractDf.class).get(0).handleMassage(commandVO);
    }
}
