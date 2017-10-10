//package ro.sci.onlinelibrary.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import ro.sci.onlinelibrary.model.user.User;
//import ro.sci.onlinelibrary.repository.UserRepository;
//import ro.sci.onlinelibrary.repository.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by iulia on 9/15/2017.
// */
//@Service
//public class UserServiceImpl implements UserService<User> {
//
//    @Autowired
//
//    private UserRepository userRepository;
//
//    public List<User> findAll() {return null;}
//
//    @Override
//    public List<User> findUserByLastName(String lastName) {
//        List<User> foundUsers = new ArrayList<User>();
//
//        for (User user : userRepository.getAll()) {
//            if (user.getLastName().equalsIgnoreCase(lastName)) {
//                foundUser.add(user);
//            }
//
//        }
//
//        return foundUser;
//
//    }
//
//    @Override
//    public List<User> findUserByFullName(String fullName) {
//        List<User> foundCustomers = new ArrayList<User>();
//
//        for (User customer : customerRepository.getAll()) {
//            if (user.getFullName().equalsIgnoreCase(fullName)) {
//                foundCustomers.add(user);
//            }
//
//        }
//
//        return foundCustomers;
//    }
//
//}
//
//    @Override
//    public List<User> findUserByEmail(String email) {
//        return null;
//    }
//
//
//
//    public List<User> findCustomerByFullName(String fullName) {
//
//        List<User> foundCustomers = new ArrayList<User>();
//
//        for (User customer : customerRepository.getAll()) {
//            if (user.getFullName().equalsIgnoreCase(fullName)) {
//                foundCustomers.add(user);
//            }
//
//        }
//
//        return foundCustomers;
//    }
//
//    public List<User> findCustomerByEmail(String email) {
//        List<User> foundCustomers = new ArrayList<User>();
//
//        for (User customer : customerRepository.getAll()) {
//            if (customer.getEmail().equalsIgnoreCase(email)) {
//                foundCustomers.add(customer);
//            }
//
//        }
//
//        return foundCustomers;
//    }
//
//    public Repository<User> getCustomerRepository() {
//        return customerRepository;
//    }
//}
