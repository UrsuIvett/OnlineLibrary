package ro.sci.onlinelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.repository.BookRepository;
import ro.sci.onlinelibrary.repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by iulia on 9/15/2017.
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    private static final Logger LOGGER = Logger.getLogger("Online library");

    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAll(){
        List<Book> books = this.bookRepository.getAll();
        return books;
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
    public void delete(int id) {this.bookRepository.delete(id);}

    @Override
    public void update(Book book) {
        bookRepository.update(book);
    }

    @Override
    public Book searchById(int bookId) {
        return this.bookRepository.searchById(bookId);
    }


}
