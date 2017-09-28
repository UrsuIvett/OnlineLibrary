package ro.sci.onlinelibrary.repository;

import ro.sci.onlinelibrary.model.customer.User;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public interface UserRepository<T extends User> extends Repository<T> {
    List<T> getAll();

    List<T> getCustomersByLastName();

    List<T> getCustomersByEmail();

    void add (T t);

    void delete (T t);

    void update (T t);

}

