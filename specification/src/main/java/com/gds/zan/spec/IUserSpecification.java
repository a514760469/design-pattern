package com.gds.zan.spec;

import com.gds.zan.User;

/**
 * 规格类
 * @author zhanglifeng
 * @since 2020-03-30 10:39
 */
public interface IUserSpecification {

    /**
     * 候选对象是否满足
     */
    boolean isSatisfiedBy(User user);

    // 与
    IUserSpecification and(IUserSpecification userSpec);

    // 或
    IUserSpecification or(IUserSpecification userSpec);

    // 非
    IUserSpecification not();
}
