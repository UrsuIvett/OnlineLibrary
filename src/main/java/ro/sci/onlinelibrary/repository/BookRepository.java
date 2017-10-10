package ro.sci.onlinelibrary.repository;

import org.apache.ibatis.annotations.*;
import ro.sci.onlinelibrary.model.book.Book;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */

public interface BookRepository extends Repository<Book> {

    @Select("SELECT * FROM books")
    List<Book> getAll();

    @Insert("INSERT INTO books(id,title,author,publishinghouse,booktype,booklanguage,nrpages,isbn) values(?,?,?,?,?,?,?,?)")
    void add (Book book);

    @Delete("DELETE FROM books WHERE bookId='1'")
    void delete (Book book);

    @Update("UPDATE books SET title='Fluturi Vol1' WHERE title='Fluturi Volumul I'")
    void update (Book book);

    @Select("SELECT * FROM books WHERE LOWER(author) LIKE #{field} or LOWER(title) LIKE #{field} or LOWER (publishingHouse) LIKE #{field}")
    List<Book> getByField(@Param("field") String field);

    Book searchById(Integer bookId);

}
