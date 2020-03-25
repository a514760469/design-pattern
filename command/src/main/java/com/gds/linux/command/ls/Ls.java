package com.gds.linux.command.ls;

import com.gds.linux.FileManager;
import com.gds.linux.command.CommandVO;

/**
 * @author zhanglifeng
 * @since 2020-03-23 15:28
 */
public class Ls extends AbstractLs {

    @Override
    protected String getOperateParam() {
        return DEFAULT_PARAM;
    }

    @Override
    protected String echo(CommandVO vo) {
        return FileManager.ls(vo.getCommandName());
    }
}
