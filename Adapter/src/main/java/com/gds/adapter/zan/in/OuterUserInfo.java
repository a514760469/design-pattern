package com.gds.adapter.zan.in;

import com.gds.adapter.zan.out2.IOutUserBaseInfo;
import com.gds.adapter.zan.out2.IOutUserHomeInfo;
import com.gds.adapter.zan.out2.IOutUserOfficeInfo;

import java.util.Map;

/**
 * @author zhanglifeng
 * @since 2020-01-21 9:59
 */
public class OuterUserInfo implements IUserInfo {

//    private IOutUserBaseInfo userBaseInfo;
//
//    private IOutUserOfficeInfo userOfficeInfo;
//
//    private IOutUserHomeInfo userHomeInfo;

    private Map baseMap;

    private Map homeMap;

    private Map officeMap;

    public OuterUserInfo(IOutUserBaseInfo userBaseInfo, IOutUserOfficeInfo userOfficeInfo, IOutUserHomeInfo userHomeInfo) {
//        this.userBaseInfo = userBaseInfo;
//        this.userOfficeInfo = userOfficeInfo;
//        this.userHomeInfo = userHomeInfo;

        this.baseMap = userBaseInfo.getUserBaseInfo();
        this.homeMap = userHomeInfo.getUserHomeInfo();
        this.officeMap = userOfficeInfo.getUserOfficeInfo();
    }

    @Override
    public String getUserName() {
        return (String) baseMap.get("userName");
    }

    @Override
    public String getHomeAddress() {
        return (String) homeMap.get("homeAddress");
    }

    @Override
    public String getMobileNumber() {
        return (String) baseMap.get("mobileNumber");
    }

    @Override
    public String getOfficeTelNumber() {
        return (String) officeMap.get("officeTelNumber");
    }

    @Override
    public String getJobPosition() {
        return (String) officeMap.get("jobPosition");
    }

    @Override
    public String getHomeTelNumber() {
        return (String) homeMap.get("homeTelNumber");
    }
}
