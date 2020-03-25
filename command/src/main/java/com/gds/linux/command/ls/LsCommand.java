package com.gds.linux.command.ls;

import com.gds.linux.command.Command;
import com.gds.linux.command.CommandHandler;
import com.gds.linux.command.CommandVO;

import java.util.List;

/**
 * @author zhanglifeng
 * @since 2020-03-23 16:30
 */
public class LsCommand extends Command {

    @Override
    public String execute(CommandVO commandVO) {
        List<? extends CommandHandler> commandNames = buildChain(AbstractLs.class);
        CommandHandler firstNode = commandNames.get(0);
        return firstNode.handleMassage(commandVO);
    }
}
