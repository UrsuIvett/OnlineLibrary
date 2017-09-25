package ro.sci.onlinelibrary.service;

import ro.sci.onlinelibrary.model.user.Customer;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public interface UserService<T extends Customer> {

    List<T> findAll (T customers);

    List<T> findCustomerByLastName(String lastName);

    List<T> findCustomerByFullName(String fullName);

    List<T> findCustomerByEmail(String email);

}
