package com.example.demo.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import  org.hamcrest.*;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.CoreMatchers.equalTo;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static net.bytebuddy.matcher.ElementMatchers.isEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    public  void hello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void createUser_JSON() throws  Exception{
        String userJson = "{\"username\":\"ji\",\"password\":\"123\"}";
        mockMvc.perform(post("/users/create").contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_XML).content(userJson))
                .andExpect(status().isOk())
                .andExpect(xpath("/User/username").string("ji"))
                .andExpect(xpath("/User/password").string("123"));

    }

}
