package com.example.AtomicaServer.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogInRequest {
    private String username;
    private String email;
    private String password;
    private String role;
}
