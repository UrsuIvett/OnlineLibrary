package ro.sci.onlinelibrary.service;

import ro.sci.onlinelibrary.model.book.Book;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public interface BookService<T extends Book> {

    List<T> findAll ( T books);

    List<T> findBookByAuthor (String author);

    List<T> findBookByPublishingHouse (String publishingHouse);

    List<T> findBookByAuthorAndPublishingHouse (String author, String publishingHouse);
}
