package ro.sci.onlinelibrary.service;

import ro.sci.onlinelibrary.model.user.Login;
import ro.sci.onlinelibrary.model.user.User;
import ro.sci.onlinelibrary.repository.UserRepository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public interface UserService{

    List<User> getAll ();

    List<User> findByField (String field);

    void add(User user);

    void delete (int id);

    void update (User user);

    User searchById(Integer bookId);

    User validateUser(Login login);

}