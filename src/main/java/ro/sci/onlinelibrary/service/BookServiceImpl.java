package ro.sci.onlinelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.repository.BookRepository;
import ro.sci.onlinelibrary.repository.Repository;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
@Service
public class BookServiceImpl implements BookService<Book> {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public List<Book> findByField(String field) {
        String likeField = ("%" + field + "%").toLowerCase();

        return bookRepository.getByField(likeField);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.getById(id);
    }

    @Override
    public void add(Book book) {
        this.bookRepository.add(book);
    }

    @Override
    public void update(Book book) {
        this.bookRepository.update(book);
    }

    @Override
    public void delete(Book book) {
        this.bookRepository.delete(book);
    }


    public Repository<Book> getBookRepository() {
        return bookRepository;
    }
}
