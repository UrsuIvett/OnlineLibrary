package ro.sci.onlinelibrary.service;

import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.repository.BookRepository;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public interface BookService<T extends Book> {

    List<T> findAll ();

    List<T> findByField (String field);

    void add(Book book);

    void delete (int id);

    void update (int id);

    T searchById(Integer bookId);

    void setBookRepository(BookRepository bookRepository);
}