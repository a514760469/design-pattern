package com.gds.adapter.zan.out2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanglifeng
 * @since 2020-01-21 9:55
 */
public class OutUserBaseInfo implements IOutUserBaseInfo {

    @SuppressWarnings("unchecked")
    @Override
    public Map getUserBaseInfo() {
        HashMap baseInfoMap = new HashMap();
        baseInfoMap.put("userName", "这个员工叫混世魔王...");
        baseInfoMap.put("mobileNumber", "这个员工电话是...");
        return baseInfoMap;
    }
}
