package com.example.AtomicaServer.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title;
    @NonNull
    private String content;

    private LocalDateTime createdAt;

    private List<String> images;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    //before the entry is saved for the first time in the db, createdAt will be auto
    //assigned
    @PrePersist
    protected void onCreate()
    {
        this.createdAt = LocalDateTime.now();
    }
}
