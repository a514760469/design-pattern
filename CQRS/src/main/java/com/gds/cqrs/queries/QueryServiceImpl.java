package com.gds.cqrs.queries;

import com.gds.cqrs.AppConstants;
import com.gds.cqrs.dto.AuthorDTO;
import com.gds.cqrs.dto.BookDTO;
import com.gds.cqrs.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.math.BigInteger;
import java.util.List;

/**
 * @author zhanglifeng
 * @since 2020-04-08 11:25
 */
public class QueryServiceImpl implements IQueryService {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public AuthorDTO getAuthorByUsername(String username) {

        AuthorDTO authorDTO;
        try (Session session = sessionFactory.openSession()) {
            Query sqlQuery = session.createSQLQuery("SELECT a.username as username,"
                    + " a.name as \"name\", a.email as \"email\""
                    + "FROM Author a where a.username=:username");
            sqlQuery.setParameter(AppConstants.USER_NAME, username);
            authorDTO = (AuthorDTO) sqlQuery.setResultTransformer(Transformers.aliasToBean(AuthorDTO.class))
                    .uniqueResult();
        }
        return authorDTO;
    }

    @Override
    public BookDTO getBook(String title) {
        BookDTO bookDTO;
        try (Session session = sessionFactory.openSession()) {
            Query sqlQuery = session.createSQLQuery("SELECT b.title as \"title\","
                    + " b.price as \"price\"" + " FROM Book b where b.title=:title");
            sqlQuery.setParameter("title", title);
            bookDTO = (BookDTO) sqlQuery.setResultTransformer(Transformers.aliasToBean(BookDTO.class)).uniqueResult();
        }
        return bookDTO;
    }

    @Override
    public List<BookDTO> getAuthorBooks(String username) {
        List<BookDTO> bookDTOS;
        try (Session session = sessionFactory.openSession()) {
            Query sqlQuery = session.createSQLQuery("SELECT b.title as \"title\", b.price as \"price\""
                    + " FROM Author a , Book b where b.author_id = a.id and a.username=:username");
            sqlQuery.setParameter(AppConstants.USER_NAME, username);
            bookDTOS = sqlQuery.setResultTransformer(Transformers.aliasToBean(BookDTO.class)).list();
        }
        return bookDTOS;

    }

    @Override
    public BigInteger getAuthorBooksCount(String username) {
        BigInteger count;
        try (Session session = sessionFactory.openSession()) {
            Query sqlQuery = session.createSQLQuery(
                    "SELECT count(b.title)" + " FROM  Book b, Author a"
                            + " where b.author_id = a.id and a.username=:username");
            sqlQuery.setParameter(AppConstants.USER_NAME, username);
            count = (BigInteger) sqlQuery.uniqueResult();
        }
        return count;
    }

    @Override
    public BigInteger getAuthorsCount() {
        BigInteger authorCount;
        try (Session session = sessionFactory.openSession()) {
            Query sqlQuery = session.createSQLQuery("SELECT count(id) from Author");
            authorCount = (BigInteger) sqlQuery.uniqueResult();
        }
        return authorCount;
    }
}
