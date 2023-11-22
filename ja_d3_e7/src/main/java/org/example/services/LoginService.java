package org.example.services;

import org.example.model.User;
import org.example.repositories.UserRepository;
import org.example.services.exceptions.AuthenticationException;

import java.util.Optional;

public class LoginService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String username, String password) {
        Optional<User> optionalUser = userRepository.findUserByUsername(username);

        User user = optionalUser.orElseThrow(() -> new AuthenticationException());

        if (user.getPassword().equals(password)) {
            return user;
        }

        throw new AuthenticationException();
    }
}
