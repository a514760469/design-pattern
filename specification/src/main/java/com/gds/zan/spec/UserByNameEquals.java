package com.gds.zan.spec;

import com.gds.zan.User;

/**
 * @author zhanglifeng
 * @since 2020-03-30 10:42
 */
public class UserByNameEquals extends BaseUserSpecification {

    private String name;

    public UserByNameEquals(String name) {
        this.name = name;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return user.getName().equals(name);
    }
}
