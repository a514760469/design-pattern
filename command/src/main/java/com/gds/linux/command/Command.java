package com.gds.linux.command;

import com.gds.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglifeng
 * @since 2020-03-23 15:45
 */
public abstract class Command {

    public abstract String execute(CommandVO commandVO);

    /**
     * 建立链表 接收一个命令族类就可以建立命令责任链
     * @param cls
     * @return
     */
    protected final List<? extends CommandHandler> buildChain(Class<? extends CommandHandler> cls) {
        List<Class<?>> sonClasses = BeanUtils.getSonClass(cls);
        List<CommandHandler> commandHandlerList = new ArrayList<>();
        for (Class<?> c : sonClasses) {
            CommandHandler commandHandler = null;
            try {
                //  产生实例
                commandHandler = (CommandHandler) Class.forName(c.getName()).newInstance();
            } catch (Exception e){
                e.printStackTrace();
            }
            // 建立链表
            if (commandHandlerList.size() > 0) {
                commandHandlerList.get(commandHandlerList.size() - 1).setNext(commandHandler);
            }
            commandHandlerList.add(commandHandler);
        }

        return commandHandlerList;
    }
}

