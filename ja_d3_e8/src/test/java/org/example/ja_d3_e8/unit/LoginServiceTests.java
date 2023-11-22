package org.example.ja_d3_e8.unit;

import org.example.ja_d3_e8.model.User;
import org.example.ja_d3_e8.repositories.UserRepository;
import org.example.ja_d3_e8.services.LoginService;
import org.example.ja_d3_e8.services.exceptions.AuthenticationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginServiceTests {

    /*
    - o metoda care primeste ca parametri username si parola
    - metoda returneaza o instanta a clasei User ce contine totate detaliile despre utilizatorul identificat la autentificare
    - daca autentificarea esueaza, metoda arunca AuthenticationException
     */

    /*
    @BeforeEach   ->  metoda non-statica si aceasta va fi executata intainte de apelul fiecarei metode @Test
    @BeforeAll    ->  metoda statica si acesta este apelata o singura data intaintea intregii suite de teste
    @AfterEach    ->  metoda non-statica si aceasta va fi executata dupa de apelul fiecarei metode @Test
    @AfterAll     ->  metoda statica si acesta este apelata o singura data dupa executia intregii suite de teste
    */

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

        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findUserByUsername(username))
                .thenReturn(Optional.empty());

        LoginService loginService = new LoginService(userRepository);

        assertThrows(
                AuthenticationException.class,
                () -> loginService.login(username, password)
        );
    }

    @Test
    @DisplayName(
            """
            WHEN calling the authentication
             WITH a username that exists
             AND a password that is not correct
             THEN the method throws AuthenticationException
            """
    )
    void test2() {
        String username = "username";
        String password = "password";
        User user = new User(username , "otherpassword");

        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findUserByUsername(username))
                .thenReturn(Optional.of(user));

        LoginService loginService = new LoginService(userRepository);

        assertThrows(
                AuthenticationException.class,
                () -> loginService.login(username, password)
        );
    }

    @Test
    @DisplayName(
            """
            WHEN calling the authentication
             WITH a username that exists
             AND a correct password
             THEN the method return the user details
            """
    )
    public void test3() {
        String username = "username";
        String password = "password";

        User user = new User(username, password);

        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findUserByUsername(username))
                .thenReturn(Optional.of(user));

        LoginService loginService = new LoginService(userRepository);

        User resultUser = loginService.login(username, password);

        assertEquals(resultUser.getUsername(), username);
    }
}
