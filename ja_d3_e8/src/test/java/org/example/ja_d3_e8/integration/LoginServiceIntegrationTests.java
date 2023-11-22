package org.example.ja_d3_e8.integration;

import org.example.ja_d3_e8.repositories.UserRepository;
import org.example.ja_d3_e8.services.LoginService;
import org.example.ja_d3_e8.services.exceptions.AuthenticationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class LoginServiceIntegrationTests {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private LoginService loginService;

    @Test
    @DisplayName(
            """
            WHEN calling the authentication
             WITH an inexistent username
             THEN the method throws AuthenticationException
            """
    )
    void test1() {
        String username = "username";
        String password = "password";

        when(userRepository.findUserByUsername(username))
                .thenReturn(Optional.empty());

        assertThrows(
                AuthenticationException.class,
                () -> loginService.login(username, password)
        );
    }

}
