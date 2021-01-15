package com.jsondemo.jsondemo.Service;

import com.jsondemo.jsondemo.Repository.UserRepository;
import com.jsondemo.jsondemo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> list() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void save(List<User> users) {
        userRepository.save(users);
    }
//    public Iterable<User> save(List<User> users) {
//        return userRepository.save(users);
//    }

}