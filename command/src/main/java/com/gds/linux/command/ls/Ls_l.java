package com.gds.linux.command.ls;

import com.gds.linux.FileManager;
import com.gds.linux.command.CommandVO;

/**
 * ls -l 命令
 * @author zhanglifeng
 * @since 2020-03-23 13:48
 */
public class Ls_l extends AbstractLs {
    @Override
    protected String getOperateParam() {
        return L_PARAM;
    }

    @Override
    protected String echo(CommandVO commandVO) {
        return FileManager.ls_l(commandVO.getCommandName());
    }
}
