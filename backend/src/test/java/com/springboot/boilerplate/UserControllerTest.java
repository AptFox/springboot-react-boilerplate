package com.springboot.boilerplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    private static String USERS_CONTROLLER_ENDPOINT = "/api/users/";

    @InjectMocks
    UserController userController;

    @MockBean
    UserRepository userRepository;

    @Autowired
    public MockMvc mockMvc;

    @Test
    void getUser() {
    }

    @Test
    void createUser() throws Exception {
        User testUser = new User();
        String postContent = serializeObjectToString(testUser);
        mockMvc.perform(MockMvcRequestBuilders
                .post(USERS_CONTROLLER_ENDPOINT)
                .contentType(APPLICATION_JSON)
                .content(postContent)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        verify(userRepository).save(testUser);
    }

    protected String serializeObjectToString(final Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }

}