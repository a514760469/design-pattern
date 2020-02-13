package com.gds.adapter.zan.out2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanglifeng
 * @since 2020-01-21 9:56
 */
public class OutUserHomeInfo implements IOutUserHomeInfo {

    @SuppressWarnings("unchecked")
    @Override
    public Map getUserHomeInfo() {
        HashMap homeInfo = new HashMap();
        homeInfo.put("homeTelNumber", "员工的家庭电话是...");
        homeInfo.put("homeAddress", "员工的家庭地址是...");
        return homeInfo;
    }
}
