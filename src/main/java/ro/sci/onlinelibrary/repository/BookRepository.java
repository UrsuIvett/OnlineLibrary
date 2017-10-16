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

    @Insert("INSERT INTO books(id,title,author,publishinghouse,booktype,booklanguage,nrpages,isbn) values(#{id},#{title},#{author},#{publishingHouse},#{bookType},#{bookLanguage},#{nrPages},#{isbn})")
    void add (Book book);

    @Delete("DELETE FROM books WHERE id=#{bookId}")
    void delete (int bookId);

    @Update("UPDATE FROM books WHERE id=#{bookId}(id,title,author,publishinghouse,booktype,booklanguage,nrpages,isbn) values(#{id},#{title},#{author},#{publishingHouse},#{bookType},#{bookLanguage},#{nrPages},#{isbn})")
    void update (int bookId);

    @Select("SELECT * FROM books WHERE LOWER(author) LIKE #{field} or LOWER(title) LIKE #{field} or LOWER (publishingHouse) LIKE #{field}")
    List<Book> getByField(@Param("field") String field);

    Book searchById(Integer bookId);

}