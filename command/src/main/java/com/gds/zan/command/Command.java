package com.gds.zan.command;

import com.gds.zan.CodeGroup;
import com.gds.zan.PageGroup;
import com.gds.zan.RequirementGroup;

/**
 * @author zhanglifeng
 * @since 2020-03-03 18:19
 */
public abstract class Command {

    protected RequirementGroup rg = new RequirementGroup();

    protected PageGroup pg = new PageGroup();

    protected CodeGroup cg = new CodeGroup();

    public abstract void execute();

}
