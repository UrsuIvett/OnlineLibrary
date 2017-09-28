package ro.sci.onlinelibrary.service;

import ro.sci.onlinelibrary.model.customer.User;
import ro.sci.onlinelibrary.repository.UserRepository;
import ro.sci.onlinelibrary.repository.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public class UserServiceImpl implements UserService<User> {

    private UserRepository<User> customerRepository;

    public UserServiceImpl(UserRepository<User> customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<User> findAll(User customers) {
        return null;
    }

    public List<User> findCustomerByLastName(String lastName) {
        List<User> foundCustomers = new ArrayList<User>();

        for (User customer : customerRepository.getAll()) {
            if (customer.getLastName().equalsIgnoreCase(lastName)) {
                foundCustomers.add(customer);
            }

        }

        return foundCustomers;

    }

    public List<User> findCustomerByFullName(String fullName) {

        List<User> foundCustomers = new ArrayList<User>();

        for (User customer : customerRepository.getAll()) {
//            if (customer.getFullName().equalsIgnoreCase(fullName)) {
//                foundCustomers.add(customer);
//            }

        }

        return foundCustomers;
    }

    public List<User> findCustomerByEmail(String email) {
        List<User> foundCustomers = new ArrayList<User>();

        for (User customer : customerRepository.getAll()) {
            if (customer.getEmail().equalsIgnoreCase(email)) {
                foundCustomers.add(customer);
            }

        }

        return foundCustomers;
    }

    public Repository<User> getCustomerRepository() {
        return customerRepository;
    }
}
