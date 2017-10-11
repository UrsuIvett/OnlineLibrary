package ro.sci.onlinelibrary.repository;

import org.apache.ibatis.annotations.Select;
import ro.sci.onlinelibrary.model.user.User;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public interface UserRepository<T extends User> extends Repository<T> {
    @Select("SELECT * FROM users")
    List<User> getAll();

    List<User> getCustomersByLastName();

    List<User> getCustomersByEmail();

    void add (User user);

    void delete (User user);

    void update (User user);

}

