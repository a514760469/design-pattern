package com.gds.adapter.zan.out2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanglifeng
 * @since 2020-01-21 9:56
 */
public class OutUserOfficeInfo implements IOutUserOfficeInfo {

    @SuppressWarnings("unchecked")
    @Override
    public Map getUserOfficeInfo() {
        HashMap officeInfo = new HashMap();
        officeInfo.put("jobPosition","这个人的职位是BOSS...");
        officeInfo.put("officeTelNumber", "员工的办公电话是...");
        return officeInfo;
    }

}
