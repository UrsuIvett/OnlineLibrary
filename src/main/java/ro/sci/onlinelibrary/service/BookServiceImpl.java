package ro.sci.onlinelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.repository.BookRepository;
import ro.sci.onlinelibrary.repository.Repository;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by iulia on 9/15/2017.
 */
@Service("bookService")
public class BookServiceImpl implements BookService<Book> {

    private static final Logger LOGGER = Logger.getLogger("Online library");

    @Autowired
    private BookRepository bookRepository;


    public List<Book> findAll() {
        return bookRepository.getAll();
    }

    @Override
    public List<Book> findByField(String field) {
        String likeField = ("%" + field + "%").toLowerCase();

        return bookRepository.getByField(likeField);
    }

    @Override
    public void add (Book book) {
        this.bookRepository.add(book);
    }

    @Override
    public void delete(int id) {
        this.bookRepository.delete(id);
    }

    @Override
    public void update(int id) {
        this.bookRepository.update(id);
    }

    @Override
    public Book searchById(Integer bookId) {
        Book book = this.bookRepository.searchById(bookId);
        return book;
    }

    @Override
    public void setBookRepository(BookRepository bookRepository) {
    }


    public Repository<Book> getBookRepository() {
        return bookRepository;
    }
}