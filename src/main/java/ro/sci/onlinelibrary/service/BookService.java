package ro.sci.onlinelibrary.service;

import ro.sci.onlinelibrary.model.book.Book;
import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public interface BookService {

    List<Book> getAll();

    List<Book> findByField(String field);

    void add(Book book);

    void delete(int id);

    void update(Book book);

    Book searchById(int bookId);
}