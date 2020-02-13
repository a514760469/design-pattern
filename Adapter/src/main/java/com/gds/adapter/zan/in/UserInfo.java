package com.gds.adapter.zan.in;

/**
 * @author zhanglifeng
 * @since 2020-01-20 16:58
 */
public class UserInfo implements IUserInfo {

    @Override
    public String getUserName() {
        return "姓名叫做...";
    }

    @Override
    public String getHomeAddress() {
        return "这里是员工的家庭地址...";
    }

    @Override
    public String getMobileNumber() {
        return "这个人的手机号码是0000...";
    }

    @Override
    public String getOfficeTelNumber() {
        return "办公室电话是...";
    }

    @Override
    public String getJobPosition() {
        return "这个人的职位是BOSS...";
    }

    @Override
    public String getHomeTelNumber() {
        return "员工的家庭电话是...";
    }
}
