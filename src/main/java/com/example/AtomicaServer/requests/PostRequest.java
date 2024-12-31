package com.example.AtomicaServer.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {

    private String title;
    private String content;
    private String image;

    public PostRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
