package ro.sci.onlinelibrary.repository;

import org.apache.ibatis.annotations.Param;
import ro.sci.onlinelibrary.model.book.Book;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */

public interface BookRepository extends Repository<Book> {

    @Select("SELECT * FROM books")
    List<Book> getAll();

    @Select("SELECT * FROM books WHERE id = #{id}")
    List<Book> getById(int id);

    void add (Book book);

    void delete (Book book);

    void update (Book book);

    @Select("SELECT * FROM books WHERE LOWER(author) LIKE #{field} or LOWER(title) LIKE #{field}")
    List<Book> getByField(@Param("field") String field);
}
