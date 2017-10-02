package ro.sci.onlinelibrary.repository;

import org.apache.ibatis.annotations.Select;
import ro.sci.onlinelibrary.model.User;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.model.user.Customer;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public interface UserRepository extends Repository<User> {

    @Select("SELECT * FROM users")
    List<User> getAll();

    @Select("SELECT * FROM users WHERE firstName like %firstName%")
    List<User> getBookByAuthor (String author);

    List<User> getBookByPublishingHouse (String publishingHouse);

    List<User> getBookByLanguage (String language);

    void add (User user);

    void delete (User user);

    void update (User user);
}

