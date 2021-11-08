package com.example.clientapp.controller;

import com.example.clientapp.model.User;
import com.example.clientapp.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ClientControllerTest {

    private MockMvc mockMvc;
    @Mock
    private UserService userService;

    @InjectMocks
    private ClientController clientController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }

    @Test
    void findTheEldest_success() throws Exception {
        User ramita = User.builder().name("Ramita").build();
        when(userService.findTheEldest()).thenReturn(ramita);
        MvcResult mvcResult = mockMvc.perform(get("/findTheEldest"))
                .andExpect(status().isOk()).andReturn();
        assertEquals(ramita, new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), User.class));
    }
}