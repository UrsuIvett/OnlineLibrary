package ro.sci.onlinelibrary.repository;

import org.apache.ibatis.annotations.*;
import org.springframework.validation.annotation.Validated;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.model.user.Login;
import ro.sci.onlinelibrary.model.user.User;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public interface UserRepository extends Repository<User> {
    @Select("SELECT * FROM users order by id")
    List<User> getAll();

    @Select("SELECT * FROM users WHERE LOWER(firstName) LIKE #{field} or LOWER(lastName) LIKE #{field} or LOWER (email) LIKE #{field}")
    List<User> getByField(@Param("field") String field);

    @Insert("INSERT INTO users(id,firstname,lastname,phone,email) values(#{id},#{firstName},#{lastName},#{phone},#{email})")
    void add (User user);

    @Delete("DELETE FROM users WHERE id=#{userId}")
    void delete (int userId);

//    @Insert("INSERT INTO accountscreated(firstname,lastname,phone,email,username,password) values(#{firstName},#{lastName},#{phone},#{email}, #{username}, #{password})")
//    void create (User user);
//
//    @Select("SELECT EXISTS (SELECT 1 FROM accountscreated WHERE username=#{username})")
//    boolean checkUserExits (@Param("username") String username);

    @Update("UPDATE users SET firstname=#{firstName}, lastname=#{lastName}, phone=#{phone}, email=#{email} WHERE id=#{id}")
    void update (User user);






}
