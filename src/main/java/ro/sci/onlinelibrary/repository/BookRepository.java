package ro.sci.onlinelibrary.repository;

import ro.sci.onlinelibrary.model.book.Book;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */

public interface BookRepository extends Repository<Book> {

    @Select("SELECT * FROM books")
    List<Book> getAll();

    @Select("SELECT * FROM books WHERE author like %author%")
    List<Book> getBookByAuthor (String author);

    List<Book> getBookByPublishingHouse (String publishingHouse);

    List<Book> getBookByLanguage (String language);

    void add (Book book);

    void delete (Book book);

    void update (Book book);
}