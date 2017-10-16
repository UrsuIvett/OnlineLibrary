package ro.sci.onlinelibrary.service;

import ro.sci.onlinelibrary.model.user.User;
import ro.sci.onlinelibrary.repository.UserRepository;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public interface UserService<T extends User> {

    List<T> findAll ();

    List<T> findByField (String field);

    void add(User user);

    void delete (int id);

    void update (User user);

    T searchById(Integer bookId);

    void setUserRepository(UserRepository userRepository);

}