package com.gds.zan;

import com.gds.zan.spec.UserByAgeThan;
import com.gds.zan.spec.UserByNameLike;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglifeng
 * @since 2020-03-30 10:57
 */
public class Client {

    public static List<User> init() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("苏大",3));
        userList.add(new User("牛二",8));
        userList.add(new User("张三",10));
        userList.add(new User("李四",15));
        userList.add(new User("王五",18));
        userList.add(new User("赵六",20));
        userList.add(new User("马七",25));
        userList.add(new User("杨八",30));
        userList.add(new User("侯九",35));
        userList.add(new User("布十",40));
        userList.add(new User("苏国庆",23));
        userList.add(new User("国庆牛",82));
        userList.add(new User("张国庆三",10));
        return userList;
    }

    public static void main(String[] args) {
        List<User> userList = init();

        IUserProvider provider = new UserProvider(userList);
        // 年龄大于20
        UserByAgeThan userByAgeThan = new UserByAgeThan(20);
        List<User> result = provider.findUser(userByAgeThan);
        result.forEach(System.out::println);

        System.out.println();
        // 国庆
        UserByNameLike userByNameLike = new UserByNameLike("%国庆%");
        result = provider.findUser(userByNameLike);
        result.forEach(System.out::println);

        System.out.println();
        // 与
        result = provider.findUser(userByAgeThan.and(userByNameLike));
        result.forEach(System.out::println);
    }
}
