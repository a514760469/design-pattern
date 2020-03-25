package com.gds.linux.command.df;

import com.gds.linux.DiskManager;
import com.gds.linux.command.CommandVO;

/**
 * @author zhanglifeng
 * @since 2020-03-23 18:20
 */
public class Df_g extends AbstractDf {


    @Override
    protected String getOperateParam() {
        return G_PARAM;
    }

    @Override
    protected String echo(CommandVO commandVO) {
        return DiskManager.df_g();
    }
}
