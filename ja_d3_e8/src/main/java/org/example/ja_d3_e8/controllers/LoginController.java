package org.example.ja_d3_e8.controllers;

import org.example.ja_d3_e8.model.User;
import org.example.ja_d3_e8.services.LoginService;
import org.example.ja_d3_e8.services.exceptions.AuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody final User user) {
        try {
            User response = loginService.login(user.getUsername(), user.getPassword());
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
