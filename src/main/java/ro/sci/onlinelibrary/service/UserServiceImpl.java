package ro.sci.onlinelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.onlinelibrary.model.book.Book;
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
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.getById(id);
    }


    public List<User> findByField(String field) {
        String likeField = ("%" + field + "%").toLowerCase();

        return userRepository.getByField(likeField);
    }


    public Repository<User> getUserRepository() {
        return userRepository;
    }
}
