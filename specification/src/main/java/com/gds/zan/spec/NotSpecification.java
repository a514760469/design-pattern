package com.gds.zan.spec;

import com.gds.zan.User;

/**
 * @author zhanglifeng
 * @since 2020-03-30 11:27
 */
public class NotSpecification extends BaseUserSpecification {

    private IUserSpecification userSpec;

    public NotSpecification(IUserSpecification userSpec) {
        this.userSpec = userSpec;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return !userSpec.isSatisfiedBy(user);
    }
}
