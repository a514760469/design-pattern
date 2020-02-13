package com.gds.adapter.zan.in;

import com.gds.adapter.zan.in.IUserInfo;
import com.gds.adapter.zan.out.OutUser;

import java.util.Map;

/**
 * @author zhanglifeng
 * @since 2020-01-20 17:36
 */
public class OutUserInfo extends OutUser implements IUserInfo {

    private Map baseInfo = super.getUserBaseInfo();
    private Map homeInfo = super.getUserHomeInfo();
    private Map officeInfo = super.getUserOfficeInfo();

    @Override
    public String getUserName() {
        return baseInfo.get("userName").toString();
    }

    @Override
    public String getHomeAddress() {
        return homeInfo.get("homeAddress").toString();
    }

    @Override
    public String getMobileNumber() {
        return baseInfo.get("mobileNumber").toString();
    }

    @Override
    public String getOfficeTelNumber() {
        return officeInfo.get("officeTelNumber").toString();
    }

    @Override
    public String getJobPosition() {
        return officeInfo.get("officeTelNumber").toString();
    }

    @Override
    public String getHomeTelNumber() {
        return homeInfo.get("homeTelNumber").toString();
    }
}
