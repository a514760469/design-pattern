package com.gds.linux;

import com.gds.linux.command.Command;
import com.gds.linux.command.CommandVO;

/**
 * @author zhanglifeng
 * @since 2020-03-23 16:45
 */
public class Invoker {

    public String exec(String commandStr) {
        String result = "";
        CommandVO vo = new CommandVO(commandStr);
        if (CommandEnum.getNames().contains(vo.getCommandName().toUpperCase())) {
            // 产生命令对象
            String className = CommandEnum.valueOf(vo.getCommandName().toUpperCase()).getValue();
            Command command;
            try {
                command = (Command) Class.forName(className).newInstance();
                result = command.execute(vo);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            result = "无法执行命令，请检查命令格式";
        }
        return result;
    }
}
