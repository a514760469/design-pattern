package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-03 18:13
 */
public interface Group {

    void find();

    void add();

    void delete();

    void change();

    void plan();

    default void rollback() {
        System.out.println("根据日志进行回滚");
    }
}
