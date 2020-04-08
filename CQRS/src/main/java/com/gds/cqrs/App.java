package com.gds.cqrs;

import com.gds.cqrs.commands.CommandServiceImpl;
import com.gds.cqrs.dto.BookDTO;
import com.gds.cqrs.queries.QueryServiceImpl;
import com.gds.cqrs.util.HibernateUtil;

import java.math.BigInteger;
import java.util.List;

/**
 * @author zhanglifeng
 * @since 2020-04-08 12:21
 */
public class App {

    public static void main(String[] args) {
        CommandServiceImpl command = new CommandServiceImpl();
        command.authorCreated(AppConstants.E_EVANS, "Eric Evans", "evans@email.com");
        command.authorCreated(AppConstants.J_BLOCH, "Joshua Bloch", "jBloch@email.com");
        command.authorCreated(AppConstants.M_FOWLER, "Martin Fowler", "mFowler@email.com");

        command.bookAddedToAuthor("Domain-Driven Design", 60.68, AppConstants.E_EVANS);
        command.bookAddedToAuthor("Effective Java", 40.54, AppConstants.J_BLOCH);
        command.bookAddedToAuthor("Java Puzzlers", 39.99, AppConstants.J_BLOCH);
        command.bookAddedToAuthor("Java Concurrency in Practice", 29.40, AppConstants.J_BLOCH);
        command.bookAddedToAuthor("Patterns of Enterprise Application Architecture", 54.01, AppConstants.M_FOWLER);
        command.bookAddedToAuthor("Domain Specific Languages", 48.89, AppConstants.M_FOWLER);
        command.authorNameUpdated(AppConstants.E_EVANS, "Eric J. Evans");

        QueryServiceImpl query = new QueryServiceImpl();
        List<BookDTO> nullAuthor = query.getAuthorBooks("username");
        System.err.println("username: " + nullAuthor);
        List<BookDTO> evans = query.getAuthorBooks(AppConstants.E_EVANS);
        System.err.println("evans: " + evans);
        BigInteger count = query.getAuthorBooksCount(AppConstants.J_BLOCH);
        System.err.println("jBloch number of books :" + count);
        BookDTO book = query.getBook("Domain-Driven Design");
        System.err.println("DDD book: " + book);
        List<BookDTO> blochBooks = query.getAuthorBooks(AppConstants.J_BLOCH);
        System.err.println("blochBooks: " + blochBooks);

        HibernateUtil.getSessionFactory().close();
    }
}
