package ro.sci.onlinelibrary.service;

import ro.sci.onlinelibrary.model.user.User;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public interface UserService<T extends User> {

    List<T> getAll();

    T findById(int id);

    List<T> findByField (String field);
}
