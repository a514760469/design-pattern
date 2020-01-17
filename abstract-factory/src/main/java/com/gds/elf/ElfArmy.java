package com.gds.elf;

import com.gds.Army;

/**
 * @author zhanglifeng
 * @since 2020-01-13 18:23
 */
public class ElfArmy implements Army {

    static final String DESCRIPTION = "This is the 精灵军队!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

}
