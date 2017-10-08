package ro.sci.onlinelibrary.repository;

import org.apache.ibatis.annotations.*;
import ro.sci.onlinelibrary.model.book.Book;

import java.util.List;

public interface BookRepository extends Repository<Book> {

    @Select("SELECT * FROM books")
    List<Book> getAll();

    @Select("SELECT * FROM books WHERE author like %author%")
    List<Book> getBookByAuthor (String author);

    List<Book> getBookByPublishingHouse (String publishingHouse);

    List<Book> getBookByLanguage (String language);

    @Insert("INSERT into books (id,title,author,publishingHouse,bookType,bookLanguage,nrPages,isbn) VALUES(#{id},#{title},#{author},#{publishingHouse},#{bookType},#{bookLanguage},#{nrPages},#{isbn})")
    @SelectKey(statement="call identity()", keyProperty="id", before=false, resultType=Integer.class)
    void add (Book book);

    void delete (Book book);
    @Delete("DELETE FROM books WHERE id=#{id}")

    void update (Book book);

    @Select("SELECT * FROM books WHERE LOWER(author) LIKE #{field} or LOWER(title) LIKE #{field}")
    List<Book> getByField(@Param("field") String field);
}

