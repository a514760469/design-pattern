package com.gds.cqrs.commands;

/**
 * 这个接口表示CQRS模式的命令。
 * crud中的 c、 u、 d
 *
 * @author zhanglifeng
 * @since 2020-04-08 10:36
 */
public interface ICommandService {

    void authorCreated(String username, String name, String email);

    void bookAddedToAuthor(String title, double price, String username);

    void authorNameUpdated(String username, String name);

    void authorUsernameUpdated(String oldUsername, String newUsername);

    void authorEmailUpdated(String username, String email);

    void bookTitleUpdated(String oldTitle, String newTitle);

    void bookPriceUpdated(String title, double price);
}
