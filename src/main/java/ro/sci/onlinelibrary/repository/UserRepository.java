package ro.sci.onlinelibrary.repository;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ro.sci.onlinelibrary.model.user.User;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public interface UserRepository<T extends User> extends Repository<T> {
    @Select("SELECT * FROM users")
    List<User> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    List<User> getById(int id);

    void add (User user);

    void delete (User user);

    void update (User user);

    @Select("SELECT * FROM users WHERE LOWER(firstname) LIKE #{field} or LOWER(lastname) LIKE #{field}")
    List<User> getByField(@Param("field") String field);
}

