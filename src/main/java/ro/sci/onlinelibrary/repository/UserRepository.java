package ro.sci.onlinelibrary.repository;

<<<<<<< HEAD:src/main/java/ro/sci/onlinelibrary/repository/UserRepository.java
import ro.sci.onlinelibrary.model.user.Customer;
=======
import ro.sci.onlinelibrary.model.customer.User;
>>>>>>> origin/Iulia:src/main/java/ro/sci/onlinelibrary/repository/UserRepository.java

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
<<<<<<< HEAD:src/main/java/ro/sci/onlinelibrary/repository/UserRepository.java
public interface UserRepository<T extends Customer> extends Repository<T> {
=======
public interface UserRepository<T extends User> extends Repository<T> {
>>>>>>> origin/Iulia:src/main/java/ro/sci/onlinelibrary/repository/UserRepository.java
    List<T> getAll();

    List<T> getCustomersByLastName();

    List<T> getCustomersByEmail();

    void add (T t);

    void delete (T t);

    void update (T t);

}

