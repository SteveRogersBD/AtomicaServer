package com.example.AtomicaServer.exceptions;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(String message,Throwable cause) {
        super(message,cause);
    }
}
