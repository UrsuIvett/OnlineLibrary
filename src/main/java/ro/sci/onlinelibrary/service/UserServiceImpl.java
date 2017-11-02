package ro.sci.onlinelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.onlinelibrary.model.user.User;
import ro.sci.onlinelibrary.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
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
        userRepository.update(user);
    }

    @Override
    public User searchById(Integer userId) {
        return this.userRepository.searchById(userId);
    }
}