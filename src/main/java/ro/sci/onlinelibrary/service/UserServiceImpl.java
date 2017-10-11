package ro.sci.onlinelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.onlinelibrary.model.user.User;
import ro.sci.onlinelibrary.repository.UserRepository;
import ro.sci.onlinelibrary.repository.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
@Service
public class UserServiceImpl implements UserService<User> {
    @Autowired
    private UserRepository<User> userRepository;

    public UserServiceImpl(UserRepository<User> userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.getAll();
    }

    public List<User> findUsersByLastName(String lastName) {
        List<User> foundUsers = new ArrayList<User>();

        for (User user : userRepository.getAll()) {
            if (user.getLastName().equalsIgnoreCase(lastName)) {
                foundUsers.add(user);
            }

        }

        return foundUsers;

    }

    public List<User> findUsersByFullName(String fullName) {

        List<User> foundUsers = new ArrayList<User>();

        for (User user : userRepository.getAll()) {
//            if (user.getFullName().equalsIgnoreCase(fullName)) {
//                foundUsers.add(user);
//            }

        }

        return foundUsers;
    }

    public List<User> findUsersByEmail(String email) {
        List<User> foundUsers = new ArrayList<User>();

        for (User user : userRepository.getAll()) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                foundUsers.add(user);
            }

        }

        return foundUsers;
    }

    public Repository<User> getUserRepository() {
        return userRepository;
    }
}
