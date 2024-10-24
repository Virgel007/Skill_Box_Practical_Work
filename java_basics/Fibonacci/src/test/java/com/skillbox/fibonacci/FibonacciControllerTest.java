package com.skillbox.fibonacci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Test Fibonacci Controller")
class FibonacciControllerTest extends PostgresTestContainerInitializer {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private FibonacciRepository repository;
    @Autowired
    private FibonacciService service;
    @Autowired
    private FibonacciController controller;
    @Test
    @DisplayName("Test get number. If the status is OK - 200")
    public void testGetNumberIfStatusOK() throws Exception {
        mvc.perform(get("/fibonacci/1"))
                .andExpect(status().isOk())
                .andReturn().getRequest();
    }

    @Test
    @DisplayName("Test get number. If the status is Bad Request - 400")
    public void testGetNumberIfStatusBadRequest() throws Exception {
        mvc.perform(get("/fibonacci/-1"))
                .andExpect(status().isBadRequest())
                .andReturn().getRequest();;
    }
}
