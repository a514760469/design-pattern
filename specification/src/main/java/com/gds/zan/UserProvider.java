package com.gds.zan;

import com.gds.zan.spec.IUserSpecification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglifeng
 * @since 2020-03-30 10:48
 */
public class UserProvider implements IUserProvider {

    private List<User> userList;

    public UserProvider(List<User> userList) {
        this.userList = userList;
    }

    /**
     * 根据指定的规格查找用户
     * @param userSpec 规格
     * @return
     */
    @Override
    public List<User> findUser(IUserSpecification userSpec) {
        List<User> result = new ArrayList<>();
        for (User user : userList) {
            if (userSpec.isSatisfiedBy(user)) {
                result.add(user);
            }
        }
        return result;
    }
}
