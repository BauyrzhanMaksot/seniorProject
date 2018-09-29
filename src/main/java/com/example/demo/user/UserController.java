package com.example.demo.user;

import com.example.demo.user.User;
import com.example.demo.user.UserDto;
import com.example.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bauka on 27-Sep-18
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/bake/register")
    public HttpStatus register(@RequestBody UserDto userDto) {
        userService.register(userDto);
        return HttpStatus.OK;
    }

    @GetMapping("/getUser")
    public User getUser(){
        return userService.getUser();
    }
}
