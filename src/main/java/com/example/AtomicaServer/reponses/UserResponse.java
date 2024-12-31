package com.example.AtomicaServer.reponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String role; // Representing the Role enum as a String
    private String dp;
    private String about;
    private LocalDateTime createdAt;
    private List<PostReponse>posts;
    private List<CommentResponse>comments;

}
