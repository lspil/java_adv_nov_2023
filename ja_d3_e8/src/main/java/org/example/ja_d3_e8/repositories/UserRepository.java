package org.example.ja_d3_e8.repositories;


import org.example.ja_d3_e8.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    public Optional<User> findUserByUsername(String username) {
        return null;
    }
}
