package ro.sci.onlinelibrary.repository;

import ro.sci.onlinelibrary.model.book.Book;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */

public interface BookRepository<T extends Book> extends Repository<T> {
    List<T> getAll();

    List<T> getBookByAuthor (String author);

    List<T> getBookByPublishingHouse (String publishingHouse);

    List<T> getBookByLanguage (String language);

    void add (T t);

    void delete (T t);

    void update (T t);
}
