package com.gds.adapter.zan;

import com.gds.adapter.zan.in.IUserInfo;
import com.gds.adapter.zan.in.OutUserInfo;
import com.gds.adapter.zan.in.OuterUserInfo;
import com.gds.adapter.zan.out2.OutUserBaseInfo;
import com.gds.adapter.zan.out2.OutUserHomeInfo;
import com.gds.adapter.zan.out2.OutUserOfficeInfo;

/**
 * @author zhanglifeng
 * @since 2020-01-20 17:39
 */
public class Client {

    public static void main(String[] args) {
        IUserInfo outUserInfo = new OutUserInfo();
        System.out.println(outUserInfo.getHomeAddress());
        System.out.println(outUserInfo.getUserName());


        IUserInfo youngGirl = new OuterUserInfo(new OutUserBaseInfo(), new OutUserOfficeInfo(), new OutUserHomeInfo());
        System.out.println(outUserInfo.getHomeAddress());
        System.out.println(outUserInfo.getUserName());
        // 从数据库中查到101个
        for (int i = 0; i < 101; i++) {
            System.out.println(youngGirl.getMobileNumber());
        }

    }
}
