package com.gds.zan;

import com.gds.zan.spec.IUserSpecification;

import java.util.List;

/**
 * @author zhanglifeng
 * @since 2020-03-30 10:34
 */
public interface IUserProvider {

    List<User> findUser(IUserSpecification userSpec);
}
