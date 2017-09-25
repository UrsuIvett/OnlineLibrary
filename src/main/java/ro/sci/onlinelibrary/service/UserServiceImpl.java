package ro.sci.onlinelibrary.service;

import ro.sci.onlinelibrary.model.user.Customer;
import ro.sci.onlinelibrary.repository.UserRepository;
import ro.sci.onlinelibrary.repository.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public class UserServiceImpl implements UserService<Customer> {

    private UserRepository<Customer> userRepository;

    public UserServiceImpl(UserRepository<Customer> userRepository) {
        this.userRepository = userRepository;
    }

    public List<Customer> findAll(Customer customers) {
        return null;
    }

    public List<Customer> findCustomerByLastName(String lastName) {
        List<Customer> foundCustomers = new ArrayList<Customer>();

        for (Customer customer : userRepository.getAll()) {
            if (customer.getLastName().equalsIgnoreCase(lastName)) {
                foundCustomers.add(customer);
            }

        }

        return foundCustomers;

    }

    public List<Customer> findCustomerByFullName(String fullName) {

        List<Customer> foundCustomers = new ArrayList<Customer>();

        for (Customer customer : userRepository.getAll()) {
//            if (customer.getFullName().equalsIgnoreCase(fullName)) {
//                foundCustomers.add(customer);
//            }

        }

        return foundCustomers;
    }

    public List<Customer> findCustomerByEmail(String email) {
        List<Customer> foundCustomers = new ArrayList<Customer>();

        for (Customer customer : userRepository.getAll()) {
            if (customer.getEmail().equalsIgnoreCase(email)) {
                foundCustomers.add(customer);
            }

        }

        return foundCustomers;
    }

    public Repository<Customer> getUserRepository() {
        return userRepository;
    }
}