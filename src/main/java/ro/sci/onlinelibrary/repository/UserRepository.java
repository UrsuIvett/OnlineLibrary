package ro.sci.onlinelibrary.repository;

import org.apache.ibatis.annotations.*;
import ro.sci.onlinelibrary.model.user.User;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public interface UserRepository extends Repository<User> {
    @Select("SELECT * FROM users ORDER by id")
    List<User> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    User getById(int userId);

    @Insert("INSERT INTO users(id,firstname,lastname,phone,email) values(#{id},#{firstName},#{lastName},#{phone},#{email})")
    void add (User user);

    @Delete("DELETE FROM users WHERE id=#{userId}")
    void delete (int userId);

    @Update("UPDATE users SET firstname=#{firstName}, lastname=#{lastName}, phone=#{phone}, email=#{email} WHERE id=#{id}")
    void update (User user);

    @Select("SELECT * FROM users WHERE LOWER(firstname) LIKE #{field} or LOWER(lastname) LIKE #{field}")
    List<User> getByField(@Param("field") String field);
}

