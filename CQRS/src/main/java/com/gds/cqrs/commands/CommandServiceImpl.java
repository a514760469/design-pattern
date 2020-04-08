package com.gds.cqrs.commands;

import com.gds.cqrs.domain.model.Author;
import com.gds.cqrs.domain.model.Book;
import com.gds.cqrs.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * @author zhanglifeng
 * @since 2020-04-08 10:40
 */
public class CommandServiceImpl implements ICommandService {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private Author getAuthorByUsername(String username) {
        Author author;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from Author where username=:username");
            query.setParameter("username", username);
            author = (Author) query.uniqueResult();
        }
        if (author == null) {
            HibernateUtil.getSessionFactory().close();
            throw new NullPointerException("Author " + username + " doesn't exist!");
        }
        return author;
    }

    private Book getBookByTitle(String title) {
        Book book;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from Book where title=:title");
            query.setParameter("title", title);
            book = (Book) query.uniqueResult();
        }
        if (book == null) {
            HibernateUtil.getSessionFactory().close();
            throw new NullPointerException("Book " + title + " doesn't exist!");
        }
        return book;
    }


    @Override
    public void authorCreated(String username, String name, String email) {
        Author author = new Author(username, name, email);
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        }
    }

    @Override
    public void bookAddedToAuthor(String title, double price, String username) {
        Author author = getAuthorByUsername(username);
        Book book = new Book(title, price, author);
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        }
    }

    @Override
    public void authorNameUpdated(String username, String name) {
        Author author = getAuthorByUsername(username);
        author.setName(name);
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        }
    }

    @Override
    public void authorUsernameUpdated(String oldUsername, String newUsername) {
        Author author = getAuthorByUsername(oldUsername);
        author.setUsername(newUsername);
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        }
    }

    @Override
    public void authorEmailUpdated(String username, String email) {
        Author author = getAuthorByUsername(username);
        author.setEmail(email);
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        }
    }

    @Override
    public void bookTitleUpdated(String oldTitle, String newTitle) {
        Book book = getBookByTitle(oldTitle);
        book.setTitle(newTitle);
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        }
    }

    @Override
    public void bookPriceUpdated(String title, double price) {
        Book book = getBookByTitle(title);
        book.setPrice(price);
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        }
    }
}
