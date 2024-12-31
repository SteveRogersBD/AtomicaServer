package com.example.AtomicaServer.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    @Email(message="Invalid email format")
    private String email;

    @Column(nullable=false)
    //@Size(min=6,max=15,message="Password must me 6 to 15 characters long!!!" )
    private String password;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Role role;

    private String dp;

    private String about;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post>posts;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Comment>comments;

    enum Role{
        STUDENT,TEACHER,RESEARCHER,ANALYST,USER
    }

    @PrePersist
    protected void onCreate()
    {
        this.createdAt = LocalDateTime.now();
        if(this.role==null) this.role = Role.USER;
        this.dp = null;
        this.about = null;
        this.posts = null;
    }

}
