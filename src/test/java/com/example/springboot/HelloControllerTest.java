package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private HelloController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void index() throws Exception {
        assertEquals("Rockcairn: Greetings from Spring Boot + Tanzu! <ul><li><a href=\"mountain\">mountain</a></li><li><a href=\"trip\">trip</a></li></ul>", controller.index());

        mockMvc
            .perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().string("Rockcairn: Greetings from Spring Boot + Tanzu! <ul><li><a href=\"mountain\">mountain</a></li><li><a href=\"trip\">trip</a></li></ul>"));
    }

    @Test
    void mountain() throws Exception {
        assertEquals("Rockcairn: Capital Peak!", controller.mountain());

        mockMvc
                .perform(get("/mountain"))
                .andExpect(status().isOk())
                .andExpect(content().string("Rockcairn: Capital Peak!"));
    }


    @Test
    void trip() throws Exception {
        assertEquals("Rockcairn: Alaska!", controller.trip());

        mockMvc
                .perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Rockcairn: Alaska!"));
    }
}
