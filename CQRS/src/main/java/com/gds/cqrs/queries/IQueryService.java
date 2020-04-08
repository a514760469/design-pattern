package com.gds.cqrs.queries;

import com.gds.cqrs.domain.model.Author;
import com.gds.cqrs.domain.model.Book;
import com.gds.cqrs.dto.AuthorDTO;
import com.gds.cqrs.dto.BookDTO;

import java.math.BigInteger;
import java.util.List;

/**
 * 这个接口表示CQRS模式的查询方法。
 * @author zhanglifeng
 * @since 2020-04-08 11:23
 */
public interface IQueryService {

    AuthorDTO getAuthorByUsername(String username);

    BookDTO getBook(String title);

    List<BookDTO> getAuthorBooks(String username);

    BigInteger getAuthorBooksCount(String username);

    BigInteger getAuthorsCount();

}
