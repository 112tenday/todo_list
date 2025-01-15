package com.test.todo_list.service;

import com.test.todo_list.model.User;
import com.test.todo_list.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean validateLogin(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public User registerUser(String username, String email, String password) {

        if (userRepository.findByUsername(username) != null) {
            throw new RuntimeException("Username already exists.");
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password);

        return userRepository.save(newUser); // Simpan user ke database
    }
}
