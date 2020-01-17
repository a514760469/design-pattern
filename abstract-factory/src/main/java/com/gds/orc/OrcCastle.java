package com.gds.orc;

import com.gds.Castle;

/**
 * @author zhanglifeng
 * @since 2020-01-13 18:22
 */
public class OrcCastle implements Castle {

    static final String DESCRIPTION = "This is the 兽人城堡!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
