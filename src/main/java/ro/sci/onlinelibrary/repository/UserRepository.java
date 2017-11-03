package ro.sci.onlinelibrary.repository;

import org.apache.ibatis.annotations.*;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.model.user.User;

import java.util.List;

/**
 * Created by Ivett on 9/15/2017.
 */
public interface UserRepository extends Repository<User> {

    @Select("SELECT * FROM users order by id")
    List<User> getAll();

    @Select("SELECT * FROM users WHERE LOWER(firstName) LIKE #{field} or LOWER(lastName) LIKE #{field} or LOWER (email) LIKE #{field}")
    List<User> getByField(@Param("field") String field);

    @Insert("INSERT INTO users(firstname,lastname,phone,email,paid) values(#{firstName},#{lastName},#{phone},#{email},#{paid})")
    void add (User user);

    @Update("UPDATE users SET firstname=#{firstName}, lastname=#{lastName}, phone=#{phone}, email=#{email}, paid=#{paid} WHERE id=#{id}")
    void update (User user);

    @Delete("DELETE FROM users WHERE id=#{userId}")
    void delete (int userId);

    @Select("SELECT * FROM users WHERE id=#{userId}")
    User searchById(int userId);
}