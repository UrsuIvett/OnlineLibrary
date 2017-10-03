package ro.sci.onlinelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.onlinelibrary.model.User;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.getAll();
    }

    @Override
    public List<User> findUserByLastName(String lastName) {
        List<User> foundUsers = new ArrayList<User>();
        for (User user : userRepository.getAll()) {
            if (user.getLastName().toLowerCase().startsWith(lastName.toLowerCase())) {
                foundUsers.add(user);
            }
        }
        return foundUsers;
    }

    @Override
    public List<User> findUserByFullName(String fullName) {
        List<User> foundUsers = new ArrayList<User>();
        for (User user : userRepository.getAll()) {
            if (user.getLastName().toLowerCase().startsWith(fullName.toLowerCase())) {
                foundUsers.add(user);
            }
        }
        return foundUsers;
    }

    @Override
    public List<User> findUserByEmail(String email) {
        List<User> foundUsers = new ArrayList<User>();
        for (User user : userRepository.getAll()) {
            if (user.getEmail().toLowerCase().startsWith(email.toLowerCase())) {
                foundUsers.add(user);
            }
        }
        return foundUsers;
    }
}

