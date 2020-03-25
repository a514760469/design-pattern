package com.gds.linux.command.df;

import com.gds.linux.DiskManager;
import com.gds.linux.command.CommandVO;

/**
 * @author zhanglifeng
 * @since 2020-03-23 18:17
 */
public class Df extends AbstractDf {
    /**
     * 定义自己能处理什么参数
     */
    @Override
    protected String getOperateParam() {
        return DEFAULT_PARAM;
    }

    @Override
    protected String echo(CommandVO commandVO) {
        return DiskManager.df();
    }
}
