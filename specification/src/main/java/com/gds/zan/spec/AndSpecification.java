package com.gds.zan.spec;

import com.gds.zan.User;

/**
 * And 操作 对应基类and方法
 * @author zhanglifeng
 * @since 2020-03-30 11:22
 */
public class AndSpecification extends BaseUserSpecification {

    private IUserSpecification left;

    private IUserSpecification right;

    public AndSpecification(IUserSpecification left, IUserSpecification right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return left.isSatisfiedBy(user) && right.isSatisfiedBy(user);
    }
}
