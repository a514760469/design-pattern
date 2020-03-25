package com.gds.linux.command.df;

import com.gds.linux.DiskManager;
import com.gds.linux.command.CommandVO;

/**
 * @author zhanglifeng
 * @since 2020-03-23 18:19
 */
public class Df_k extends AbstractDf {

    @Override
    protected String getOperateParam() {
        return K_PARAM;
    }

    @Override
    protected String echo(CommandVO commandVO) {
        return DiskManager.df_k();
    }
}
