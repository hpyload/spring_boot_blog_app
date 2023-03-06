package com.nabil.blog_app.exception;

import org.springframework.http.HttpStatus;

/**
 * @author nabil
 * @at 3/6/23 12:20 AM
 */
public class BlogApiException extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    public BlogApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public BlogApiException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
