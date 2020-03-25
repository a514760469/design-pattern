package com.gds.linux.command.ls;

import com.gds.linux.FileManager;
import com.gds.linux.command.CommandVO;

/**
 * ls -a 命令
 * @author zhanglifeng
 * @since 2020-03-23 13:48
 */
public class Ls_a extends AbstractLs {

    @Override
    protected String getOperateParam() {
        return A_PARAM;
    }

    @Override
    protected String echo(CommandVO vo) {
        return FileManager.ls_a(vo.getCommandName());
    }
}
