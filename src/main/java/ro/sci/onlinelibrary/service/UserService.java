package ro.sci.onlinelibrary.service;

<<<<<<< HEAD:src/main/java/ro/sci/onlinelibrary/service/UserService.java
import ro.sci.onlinelibrary.model.user.Customer;
=======
import ro.sci.onlinelibrary.model.customer.User;
>>>>>>> origin/Iulia:src/main/java/ro/sci/onlinelibrary/service/UserService.java

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
<<<<<<< HEAD:src/main/java/ro/sci/onlinelibrary/service/UserService.java
public interface UserService<T extends Customer> {
=======
public interface UserService<T extends User> {
>>>>>>> origin/Iulia:src/main/java/ro/sci/onlinelibrary/service/UserService.java

    List<T> findAll (T customers);

    List<T> findCustomerByLastName(String lastName);

    List<T> findCustomerByFullName(String fullName);


    List<T> findCustomerByEmail(String email);

}
