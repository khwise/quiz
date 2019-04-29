package com.quiz.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quiz.web.dto.SigninRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {RootContextConfiguration.class, SigninController.class})
@AutoConfigureMockMvc
public class SigninControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    // TODO : HttpStatus : 415 인 원인을 찾으시오.!!

    @Test
    public void testSignin() throws Exception {

        SigninRequest request = new SigninRequest();
        request.setUserId("test");
        request.setPassword("test");

        String jsonParam = objectMapper.writeValueAsString(request);

        mvc.perform(
                post("/signin")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonParam))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.message").value("SUCCESS"));
    }

}