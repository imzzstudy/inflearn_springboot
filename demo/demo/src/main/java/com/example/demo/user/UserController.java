package com.example.demo.user;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/hello")
    public @ResponseBody String hello(){//@ResponseBody 생략가능
        return "hello";
    }

    /*
    @PostMapping("/user")
    public @ResponseBody User create(@RequestBody User user){//HttpMessageConverters가 사용이 된다.
        return null;
    }
     */
    @PostMapping("/users/create")
    public User create(@RequestBody User user){
        return user;
    }
}
