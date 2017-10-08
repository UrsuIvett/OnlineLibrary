package ro.sci.onlinelibrary.service;

import ro.sci.onlinelibrary.model.book.Book;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public interface BookService<T extends Book> {

    List<T> findAll ();

    List<T> findBookByAuthor (String author);

    List<T> findByField (String field);

    List<T> findBookByPublishingHouse (String publishingHouse);

    List<T> findBookByAuthorAndPublishingHouse (String author, String publishingHouse);

    void add(T t);
    void update(T t);
}