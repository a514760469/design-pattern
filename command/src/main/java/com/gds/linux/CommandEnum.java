package com.gds.linux;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglifeng
 * @since 2020-03-23 16:46
 */
public enum CommandEnum {

    LS("com.gds.linux.command.ls.LsCommand"),
    DF("com.gds.linux.command.df.DfCommand");

    private String value;

    CommandEnum(String value) {
        this.value = value;
    }

    public static List<String> getNames() {
        CommandEnum[] values = CommandEnum.values();
        List<String> names = new ArrayList<>();
        for (CommandEnum value : values) {
            names.add(value.name());
        }
        return names;
    }

    public String getValue() {
        return value;
    }
}
