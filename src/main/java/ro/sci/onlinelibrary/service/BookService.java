package ro.sci.onlinelibrary.service;

import ro.sci.onlinelibrary.model.book.Book;

import java.util.List;

/**
 * Created by ivett on 9/15/2017.
 */
public interface BookService<T extends Book> {

    void add(T t);
    void update(T t);
    void delete(T t);
    List<T> findAll ();

    List<T> findBookByAuthor (String author);

    List<T> findBookByTitle (String title);

    List<T> findByField (String field);

    List<T> findBookByPublishingHouse (String publishingHouse);

    List<T> findBookByAuthorAndPublishingHouse (String author, String publishingHouse);

    T searchById(Integer bookId);
}