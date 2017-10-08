package ro.sci.onlinelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.repository.BookRepository;
import ro.sci.onlinelibrary.repository.Repository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService<Book> {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.getAll();
    }

    @Override
    public List findBookByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<Book>();

        List<Book> books = bookRepository.getAll();
        for (Book book : books) {
            if (book.getAuthor()!=null && book.getAuthor().toLowerCase().startsWith(author.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> findByField(String field) {
        String likeField = ("%" + field + "%").toLowerCase();
        return bookRepository.getByField(likeField);
    }


    @Override
    public List findBookByPublishingHouse(String publishingHouse) {
        List<Book> foundBooks = new ArrayList<Book>();

        for (Book book : bookRepository.getAll()) {
            if (book.getPublishingHouse().equalsIgnoreCase(publishingHouse)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public List findBookByAuthorAndPublishingHouse(String author, String publishingHouse) {
        List<Book> foundBooks = new ArrayList<Book>();

        for (Book book : bookRepository.getAll()) {
            if (book.getPublishingHouse().equalsIgnoreCase(publishingHouse) && book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public Book searchById(Integer bookId) {
        List<Book> books = bookRepository.getAll();
        Book book =  new Book();
        for (Book b :books ){
            if (b.getId()!=0 && ( b.getId()== bookId)) {
                    book = b;
                }
            }
            return book;
    }

    @Override
    public void add(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Book book) {

    }

    public Repository<Book> getBookRepository() {
    return bookRepository;
   }
}