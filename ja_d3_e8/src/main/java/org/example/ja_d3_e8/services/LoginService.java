package org.example.ja_d3_e8.services;


import org.example.ja_d3_e8.model.User;
import org.example.ja_d3_e8.repositories.UserRepository;
import org.example.ja_d3_e8.services.exceptions.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
// @Transactional
public class LoginService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // @PreAuthorize @PostAuthorize ...
    public User login(String username, String password) {
        Optional<User> optionalUser = userRepository.findUserByUsername(username);

        User user = optionalUser.orElseThrow(() -> new AuthenticationException());

        if (user.getPassword().equals(password)) {
            return user;
        }

        throw new AuthenticationException();
    }
}
