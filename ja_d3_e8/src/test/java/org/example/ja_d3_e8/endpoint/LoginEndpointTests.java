package org.example.ja_d3_e8.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ja_d3_e8.model.User;
import org.example.ja_d3_e8.repositories.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginEndpointTests {

    @Autowired
    private MockMvc client;

    @MockBean
    private UserRepository userRepository;

    static ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName(
            """
            WHEN calling the authentication
             WITH an inexistent username
             THEN the method throws AuthenticationException
            """
    )
    void test1() throws Exception {
        String username = "username";
        String password = "password";

        User testUser = new User(username, password);

        when(userRepository.findUserByUsername(username))
                .thenReturn(Optional.empty());

        client.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(testUser))
                )
                .andExpect(status().is4xxClientError());
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
    void test2() throws Exception {
        String username = "username";
        String password = "password";

        User user = new User(username , "otherpassword");
        User requestUser = new User(username, password);

        when(userRepository.findUserByUsername(username))
                .thenReturn(Optional.of(user));


        client.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(requestUser))
                )
                .andExpect(status().is4xxClientError());

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
    public void test3() throws Exception {
        String username = "username";
        String password = "password";

        User user = new User(username, password);

        when(userRepository.findUserByUsername(username))
                .thenReturn(Optional.of(user));

        client.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(user))
                )
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(user)));

    }
}
