package ro.sci.onlinelibrary.repository;

import ro.sci.onlinelibrary.model.book.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public class BookRepositoryImpl implements BookRepository<Book> {

    private List<Book> books = new ArrayList<Book>();

    public List<Book> getAll() {
        return null;
    }

    public List<Book> getBookByAuthor(String author) {
        return null;
    }

    public List<Book> getBookByPublishingHouse(String publishingHouse) {
        return null;
    }

    public List<Book> getBookByLanguage(String language) {
        return null;
    }

    public void add(Book book) {
        books.add(book);

    }

    public void delete(Book book) {
        books.remove(book);

    }

    public void update(Book book) {
        books.set(books.indexOf(book), book);

    }
}
