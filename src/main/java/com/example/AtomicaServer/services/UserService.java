package com.example.AtomicaServer.services;

import com.example.AtomicaServer.exceptions.UserNotFoundException;
import com.example.AtomicaServer.jwtFIles.JWTUtil;
import com.example.AtomicaServer.models.User;
import com.example.AtomicaServer.repositories.UserRepo;
import com.example.AtomicaServer.requests.LogInRequest;
import com.example.AtomicaServer.requests.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    JWTUtil jwtUtil;
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;

    public User saveNewUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
    public boolean verify(LogInRequest request)
    {
        Authentication authentication = authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                        request.getPassword()));
        return authentication.isAuthenticated();

    }

    public boolean verify(RegisterRequest request)
    {

    }
}
