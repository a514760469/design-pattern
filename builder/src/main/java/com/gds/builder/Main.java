package com.gds.builder;

/**
 * @author zhanglifeng
 * @since 2020-01-17 13:50
 */
public class Main {

    public static void main(String[] args) {
        GirlFriend myGirlFriend = Builder.of(GirlFriend::new)
                .with(GirlFriend::setName, "小美")
                .with(GirlFriend::setAge, 18)
                .with(GirlFriend::setBirthday, "2001-10-26")
                .with(GirlFriend::setAddress, "上海浦东")
                .with(GirlFriend::setMobile, "18688888888")
                .with(GirlFriend::setEmail, "pretty-xiaomei@qq.com")
                .with(GirlFriend::setHairColor, "浅棕色带点微卷")
                .with(GirlFriend::setVitalStatistics, 33, 23, 33)
                .with(GirlFriend::addHobby, "逛街")
                .with(GirlFriend::addHobby, "购物")
                .with(GirlFriend::addHobby, "买东西")
                .with(GirlFriend::addGift, "情人节礼物", "LBR 1912女王时代")
                .with(GirlFriend::addGift, "生日礼物", "迪奥烈焰蓝金")
                .with(GirlFriend::addGift, "纪念日礼物", "阿玛尼红管唇釉")
                .build();
        System.out.println(myGirlFriend);
    }
}
