package com.gds.zan.spec;

import com.gds.zan.User;

/**
 * @author zhanglifeng
 * @since 2020-03-30 11:26
 */
public class OrSpecification extends BaseUserSpecification {

    private IUserSpecification left;

    private IUserSpecification right;

    public OrSpecification(IUserSpecification left, IUserSpecification right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return left.isSatisfiedBy(user) || right.isSatisfiedBy(user);
    }
}
