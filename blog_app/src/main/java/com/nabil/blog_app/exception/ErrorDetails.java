package com.nabil.blog_app.exception;

import java.util.Date;

/**
 * @author nabil
 * @at 3/9/23 9:02 PM
 */
public class ErrorDetails {
    private final Date timestamp;
    private final String message;
    private final String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
