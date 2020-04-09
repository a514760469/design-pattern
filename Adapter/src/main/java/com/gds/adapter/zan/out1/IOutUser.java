package com.gds.adapter.zan.out1;

import java.util.Map;

/**
 * @author zhanglifeng
 * @since 2020-01-20 17:03
 */
public interface IOutUser {
    //基本信息，比如名称、性别、手机号码等
    Map getUserBaseInfo();
    //工作区域信息
    Map getUserOfficeInfo();
    //用户的家庭信息
    Map getUserHomeInfo();
}
