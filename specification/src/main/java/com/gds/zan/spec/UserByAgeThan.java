package com.gds.zan.spec;

import com.gds.zan.User;

/**
 * @author zhanglifeng
 * @since 2020-03-30 10:43
 */
public class UserByAgeThan extends BaseUserSpecification {

    private int age;

    public UserByAgeThan(int age) {
        this.age = age;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return user.getAge() > age;
    }
}
