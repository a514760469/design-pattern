package com.gds.elf;

import com.gds.King;

/**
 * @author zhanglifeng
 * @since 2020-01-13 18:23
 */
public class ElfKing implements King {

    static final String DESCRIPTION = "This is the 精灵国王!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
