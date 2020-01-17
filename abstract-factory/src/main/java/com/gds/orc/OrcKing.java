package com.gds.orc;

import com.gds.King;

/**
 * @author zhanglifeng
 * @since 2020-01-13 18:23
 */
public class OrcKing implements King {

    static final String DESCRIPTION = "This is the 兽人国王!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
