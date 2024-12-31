package com.example.AtomicaServer.controllers;

import com.example.AtomicaServer.jwtFIles.JWTUtil;
import com.example.AtomicaServer.models.User;
import com.example.AtomicaServer.reponses.ApiResponse;
import com.example.AtomicaServer.reponses.UserResponse;
import com.example.AtomicaServer.requests.LogInRequest;
import com.example.AtomicaServer.requests.RegisterRequest;
import com.example.AtomicaServer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/register")
    public ApiResponse<User>registerUser(@RequestBody RegisterRequest request)
    {
        //userService.verify(request)
        return null;
    }

    @PostMapping("/public/log-in")
    public ApiResponse<String>logInUser(@RequestBody LogInRequest req)
    {
      String token = null;
        if(userService.verify(req)) token = jwtUtil.createJWTFromUsername(req.getUsername());
        return ApiResponse.onSuccess("Successfully logged in", token);
    }


    private UserResponse transformToResponse(User user)
    {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setPassword(user.getPassword());
        userResponse.setEmail(user.getEmail());
        userResponse.setRole(user.getRole()+"");
        userResponse.setDp(user.getDp());
        userResponse.setAbout(user.getAbout());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setPosts(new ArrayList<>());
        userResponse.setComments(new ArrayList<>());
        return userResponse;
    }

}
