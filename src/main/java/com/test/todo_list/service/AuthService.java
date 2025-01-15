package com.test.todo_list.service;


import com.test.todo_list.model.User;
import com.test.todo_list.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User loginUser(String username) {
        return userRepository.findByUsername(username);
    }
}

