package ro.sci.onlinelibrary.repository;

        import org.apache.ibatis.annotations.*;
        import ro.sci.onlinelibrary.model.book.Book;

        import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */

public interface BookRepository extends Repository<Book> {

    @Select("SELECT * FROM books order by id")
    List<Book> getAll();

    @Insert("INSERT INTO books(title,author,publishinghouse,booktype,booklanguage,nrpages,isbn) values(#{title},#{author},#{publishingHouse},#{bookType},#{bookLanguage},#{nrPages},#{isbn})")
    void add(Book book);

    @Delete("DELETE FROM books WHERE id=#{bookId}")
    void delete(int bookId);

    @Update("UPDATE books SET title=#{title}, author=#{author}, publishinghouse=#{publishingHouse}, booktype=#{bookType}, booklanguage=#{bookLanguage}, nrpages=#{nrPages}, isbn=#{isbn} WHERE id=#{id}")
    void update(Book book);

    @Select("SELECT * FROM books WHERE LOWER(author) LIKE #{field} or LOWER(title) LIKE #{field} or LOWER (publishingHouse) LIKE #{field}")
    List<Book> getByField(@Param("field") String field);

    @Select("SELECT * FROM books WHERE id=#{bookId}")
    Book searchById(int bookId);


}