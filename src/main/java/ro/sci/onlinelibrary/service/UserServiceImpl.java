package ro.sci.onlinelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.onlinelibrary.model.user.Login;
import ro.sci.onlinelibrary.model.user.User;
import ro.sci.onlinelibrary.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by iulia on 9/15/2017.
 */

    @Service("userService")
    public class UserServiceImpl implements UserService<User> {

    private static final Logger LOGGER = Logger.getLogger("Online library");

        @Autowired
        private UserRepository userRepository;

        @Override
        public List<User> findAll() {
            return userRepository.getAll();
        }

        @Override
        public List<User> findByField(String field) {
            String likeField = ("%" + field + "%").toLowerCase();
            return userRepository.getByField(likeField);
        }

        @Override
        public void add(User user) {
            this.userRepository.add(user);
        }

        @Override
        public void delete(int id) {
            this.userRepository.delete(id);
        }

        @Override
        public void update(User user) {
            this.userRepository.update(user);

        }

        @Override
        public User searchById(Integer userId) {
            User user = userRepository.searchById(userId);
            return user;
        }

    @Override
    public User validateUser(login) {
        User user = userRepository.validateUser(login);
        return user;

    }

    @Override
        public void setUserRepository(UserRepository userRepository) {
        }

        public UserRepository getUserRepository() {
            return userRepository;
        }
    }
