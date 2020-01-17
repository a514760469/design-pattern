package com.gds.elf;

import com.gds.Castle;

/**
 * @author zhanglifeng
 * @since 2020-01-13 18:22
 */
public class ElfCastle implements Castle {

    static final String DESCRIPTION = "This is the 精灵城堡!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
