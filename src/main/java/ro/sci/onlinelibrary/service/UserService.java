package ro.sci.onlinelibrary.service;

import ro.sci.onlinelibrary.model.user.Customer;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public interface UserService<T extends User> {

    List<T> findAll ();

    List<T> findUserByLastName(String lastName);

    List<T> findUserByFullName(String fullName);

    List<T> findUserByEmail(String email);

}
