package com.gds.orc;

import com.gds.Army;

/**
 * @author zhanglifeng
 * @since 2020-01-13 18:23
 */
public class OrcArmy implements Army {

    static final String DESCRIPTION = "This is the 兽人军队!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

}
