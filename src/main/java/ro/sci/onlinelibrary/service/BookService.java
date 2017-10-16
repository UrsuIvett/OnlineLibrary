package ro.sci.onlinelibrary.service;

import ro.sci.onlinelibrary.model.book.Book;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public interface BookService<T extends Book> {

    List<T> getAll();

    List<T> findByField (String field);

    List<T> findById(int id);

    void add(Book book);

    void update(Book book);

    void delete(Book book);
}