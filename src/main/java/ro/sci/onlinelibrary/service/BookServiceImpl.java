package ro.sci.onlinelibrary.service;

import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.repository.BookRepository;
import ro.sci.onlinelibrary.repository.BookRepositoryImpl;
import ro.sci.onlinelibrary.repository.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public class BookServiceImpl implements BookService<Book> {

    private BookRepository<Book> bookRepository;

    public BookServiceImpl(BookRepositoryImpl bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List findAll(Book books) {
        return null;
    }

    public List findBookByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<Book>();

        for (Book book : bookRepository.getAll()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }

        }

        return foundBooks;
    }

    public List findBookByPublishingHouse(String publishingHouse) {
        List<Book> foundBooks = new ArrayList<Book>();

        for (Book book : bookRepository.getAll()) {
            if (book.getPublishingHouse().equalsIgnoreCase(publishingHouse)) {
                foundBooks.add(book);
            }

        }

        return foundBooks;
    }

    public List findBookByAuthorAndPublishingHouse(String author, String publishingHouse) {
        List<Book> foundBooks = new ArrayList<Book>();

        for (Book book : bookRepository.getAll()) {
            if (book.getPublishingHouse().equalsIgnoreCase(publishingHouse) && book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }

        }

        return foundBooks;
    }

    public Repository<Book> getBookRepository() {
        return bookRepository;
    }
}
